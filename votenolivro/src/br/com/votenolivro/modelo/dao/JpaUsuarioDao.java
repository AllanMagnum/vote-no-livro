package br.com.votenolivro.modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.votenolivro.modelo.bean.Usuario;

@Repository
public class JpaUsuarioDao implements UsuarioDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void adiciona(Usuario usuario) {
		entityManager.persist(usuario);
	}

	@Transactional
	public void altera(Usuario usuario) {
		entityManager.merge(usuario);
	}

	@Transactional
	public void remove(Usuario usuario) {
		entityManager.remove(usuario);
	}

	public Usuario buscaPorId(Usuario usuario) {
		return entityManager.find(Usuario.class, usuario.getId());
	}
}
