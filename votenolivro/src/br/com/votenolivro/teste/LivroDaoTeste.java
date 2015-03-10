package br.com.votenolivro.teste;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.votenolivro.modelo.bean.Ranking;
import br.com.votenolivro.modelo.dao.LivroDao;

public class LivroDaoTeste {
	
	@Autowired
	private LivroDao livroDao;
	
	@Test
	public void listaRankingGeral() {
		List<Ranking> lista = livroDao.mostrarRanking();
		for (Ranking ranking : lista) {
			System.out.println(ranking.getLivro());
		}
	}

}
