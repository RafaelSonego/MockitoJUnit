package br.com.rafaelsonego.service;

import java.util.List;

import br.com.rafaelsonego.domain.Usuario;

public interface UsuarioService {

	void salvar(Usuario testDomain);

	void atualizar(Usuario testDomain);

	List<Usuario> recuperarUser() throws Exception;

	Usuario recuperarUser(int id) throws Exception;
	
	Usuario recuperarUser(String nome) throws Exception;

}
