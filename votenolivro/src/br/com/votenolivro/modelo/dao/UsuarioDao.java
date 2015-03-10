package br.com.votenolivro.modelo.dao;

import br.com.votenolivro.modelo.bean.Usuario;

public interface UsuarioDao {
	void adiciona(Usuario t);
	void altera(Usuario t);
	void remove(Usuario t);
	Usuario buscaPorId(Usuario t);
}
