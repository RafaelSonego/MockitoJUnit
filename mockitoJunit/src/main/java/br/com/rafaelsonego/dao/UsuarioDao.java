package br.com.rafaelsonego.dao;

import java.util.List;

import br.com.rafaelsonego.domain.Usuario;

public interface UsuarioDao {
	
	void salvar(Usuario user);
	
	void atualizar(Usuario user);
	
	List<Usuario> recuperarUser();
	
	Usuario recuperarUser(int id);
	
	Usuario recuperarUser(String nome);
	
}
