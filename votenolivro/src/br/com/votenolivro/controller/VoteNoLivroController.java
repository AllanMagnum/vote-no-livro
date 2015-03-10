package br.com.votenolivro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import br.com.votenolivro.modelo.bean.Livro;
import br.com.votenolivro.modelo.bean.Ranking;
import br.com.votenolivro.modelo.bean.Usuario;
import br.com.votenolivro.modelo.dao.LivroDao;
import br.com.votenolivro.modelo.dao.UsuarioDao;

@Controller
public class VoteNoLivroController {
	
	@Autowired
	private LivroDao livroDao;
	@Autowired
	private UsuarioDao usuarioDao;
	
	private List<Livro> livrosVotados = new ArrayList<Livro>();
	
	@RequestMapping("/votar")
	public String votar(Model model, WebRequest webRequest){
		List<Livro> livros = new ArrayList<Livro>();
		String param = webRequest.getParameter("pagina");
		String livroVotado = webRequest.getParameter("voto");
		int pagina;
		
		if(livroVotado != null){
			Livro livro1 = new Livro();
			livro1.setId(Long.parseLong(livroVotado));
			livrosVotados.add(livroDao.buscaPorId(livro1));
		}
		
		if(param != null){
			pagina = Integer.parseInt(param);
		}else{
			pagina = 0;
		}
		
		if(pagina == 0){
			livros = livroDao.lista(0);
			model.addAttribute("pagina", 2);
		}else{
			livros = livroDao.lista(pagina++);
			model.addAttribute("pagina", pagina);
		}	
			
		for (Livro livro : livros) {
			System.out.println(livro.getTitulo());
		}
		model.addAttribute("livros", livros);
		
		return "votenolivro";
	}
	
	@RequestMapping("/finalizar")
	public String finalizar(Model model, Usuario usuario, WebRequest webRequest){
		String livroVotado = webRequest.getParameter("voto");
		
		if(livroVotado != null){
			Livro livro1 = new Livro();
			livro1.setId(Long.parseLong(livroVotado));
			livrosVotados.add(livroDao.buscaPorId(livro1));
		}
		
		usuario.setId(0);
		usuario.setLivros(livrosVotados);
		usuarioDao.adiciona(usuario); 
		
		List<Ranking> rankings = livroDao.mostrarRanking();
		int total = 0;
		for (Ranking ranking : rankings) {
			total += ranking.getQuantidade();
		}
		
		model.addAttribute("rankings", rankings);
		model.addAttribute("total", total);
		
		
		return "votoconfirmado";
	}
}
