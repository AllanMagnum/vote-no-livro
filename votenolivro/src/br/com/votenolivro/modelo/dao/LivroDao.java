package br.com.votenolivro.modelo.dao;

import java.util.List;

import br.com.votenolivro.modelo.bean.Livro;
import br.com.votenolivro.modelo.bean.Ranking;

public interface LivroDao {
	void adiciona(Livro t);
	void altera(Livro t);
	void remove(Livro t);
	Livro buscaPorId(Livro t);
	List<Livro> lista(int start);
	List<Ranking> mostrarRanking();
}
