package br.com.votenolivro.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.votenolivro.modelo.bean.Livro;
import br.com.votenolivro.modelo.bean.Ranking;

@Repository
public class JpaLivroDao implements LivroDao{
	
	private final int maxResult = 2;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void adiciona(Livro livro) {
		entityManager.persist(livro);
	}

	@Transactional
	public void altera(Livro livro) {
		entityManager.merge(livro);
	}

	@Transactional
	public void remove(Livro livro) {
		entityManager.remove(livro);
	}

	public Livro buscaPorId(Livro livro) {
		return entityManager.find(Livro.class, livro.getId());
	}

	public List<Livro> lista(int start) {
		String jpql = "select t from Livro t";
		TypedQuery<Livro> query = entityManager.createQuery(jpql, Livro.class);
		query.setFirstResult(start);
		query.setMaxResults(this.maxResult);
		return query.getResultList();
	}
	
	public List<Ranking> mostrarRanking(){
		String jpql = "select new br.com.votenolivro.modelo.bean.Ranking(t2.titulo, count(t1)) from Usuario t1 left join t1.livros t2 group by t2.titulo order by count(1) desc";
		TypedQuery<Ranking> query = entityManager.createQuery(jpql, Ranking.class);
		return query.getResultList();
	}


}
