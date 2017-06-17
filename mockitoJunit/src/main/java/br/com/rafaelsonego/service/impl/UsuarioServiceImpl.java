package br.com.rafaelsonego.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import br.com.rafaelsonego.dao.UsuarioDao;
import br.com.rafaelsonego.dao.impl.UsuarioDaoImpl;
import br.com.rafaelsonego.domain.Usuario;
import br.com.rafaelsonego.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	static Logger log = Logger.getLogger(UsuarioServiceImpl.class);
	
	@Override
	public void salvar(Usuario user) {
		try {
			log.debug("Iniciando metodo salvar");
			UsuarioDao userDao = new UsuarioDaoImpl();
			userDao.salvar(user);
			log.debug("Metodo Finalizado com sucesso - Objeto salvo na base");
		} catch (Exception ex) {
			log.error("Falha ao executar", ex);
		}
	}

	@Override
	public void atualizar(Usuario user) {
		try {
			log.debug("Iniciando metodo atualizar");
			UsuarioDao userDao = new UsuarioDaoImpl();
			userDao.atualizar(user);
			log.debug("Metodo Finalizado com sucesso - Objeto atualizado na base - id: " + user.getId());
		} catch (Exception ex) {
			log.error("Falha ao executar", ex);
		}
	}

	@Override
	public List<Usuario> recuperarUser() throws Exception {
		try {
			log.debug("Iniciando metodo recuperarUser");
			UsuarioDao userDao = new UsuarioDaoImpl();
			List<Usuario> list = userDao.recuperarUser();
			log.debug("Metodo Finalizado com sucesso - Lista de objetos recuperado da base");
			return list;
		} catch (Exception ex) {
			log.error("Falha ao executar", ex);
			throw ex;
		}
	}

	@Override
	public Usuario recuperarUser(int id) throws Exception {
		try {
			log.debug("Iniciando metodo recuperarUser");
			UsuarioDao userDao = new UsuarioDaoImpl();
			Usuario list = userDao.recuperarUser(id);
			log.debug("Metodo Finalizado com sucesso - Objeto recuperado da base - id: " + id);
			return list;
		} catch (Exception ex) {
			log.error("Falha ao executar", ex);
			throw ex;
		}
	}

	@Override
	public Usuario recuperarUser(String nome) throws Exception {
		try {
			log.debug("Iniciando metodo recuperarUser");
			UsuarioDao userDao = new UsuarioDaoImpl();
			Usuario list = userDao.recuperarUser(nome);
			log.debug("Metodo Finalizado com sucesso - Objeto recuperado da base - nome: " + nome);
			return list;
		} catch (Exception ex) {
			log.error("Falha ao executar", ex);
			throw ex;
		}
	}
}
