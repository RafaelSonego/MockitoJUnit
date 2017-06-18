package br.com.rafaelsonego.service;

import java.util.List;

import br.com.rafaelsonego.domain.Usuario;

public interface UsuarioService {

	Usuario salvar(Usuario user) throws Exception;

	Usuario atualizar(Usuario user) throws Exception;

	List<Usuario> recuperarUser() throws Exception;

	Usuario recuperarUser(int id) throws Exception;
	
	Usuario recuperarUser(String nome) throws Exception;

}
