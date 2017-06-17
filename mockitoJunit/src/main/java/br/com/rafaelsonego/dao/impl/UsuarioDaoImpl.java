package br.com.rafaelsonego.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.rafaelsonego.dao.UsuarioDao;
import br.com.rafaelsonego.dao.connection.ConnectionFactory;
import br.com.rafaelsonego.domain.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
	static Logger log = Logger.getLogger(UsuarioDaoImpl.class);

	private Connection conection;

	public UsuarioDaoImpl() {
		try {
			log.debug("Instanciando Dao - Criando conexão com a base");
			this.conection = ConnectionFactory.getConnection();
			log.debug("Conexao criada com sucesso");
		} catch (Exception e) {
			log.error("Falha ao criar conexao com banco de dados", e);
			throw new RuntimeException(e);
		}
	}

	public void salvar(Usuario user) {
		PreparedStatement ps = null;
		try {
			log.debug("Inserindo objeto na base, classe DAO");
			String sql = "INSERT INTO USUARIO (NOME, EMAIL, IDADE) VALUES (?, ?, ?);";

			ps = conection.prepareStatement(sql);

			ps.setString(1, user.getNome());
			ps.setString(2, user.getEmail());
			ps.setInt(3, user.getIdade());

			ps.execute();
			log.debug("Objeto inserido na base classe dao");
		} catch (SQLException e) {
			log.error("Falha ao executar comando sql", e);
			throw new RuntimeException(e);
		} catch (Exception e) {
			log.error("Erro na classe DAO", e);
			throw new RuntimeException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (conection != null) {
				try {
					conection.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public void atualizar(Usuario user) {
		PreparedStatement ps = null;
		try {
			log.debug("Atualizando objeto na base");
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE USUARIO SET ");
			sb.append("	NOME = ? ,");
			sb.append("	EMAIL = ? ,");
			sb.append("	IDADE = ? ");
			sb.append("WHERE ");
			sb.append(" ID = ? ");

			ps = conection.prepareStatement(sb.toString());

			ps.setString(1, user.getNome());
			ps.setString(2, user.getEmail());
			ps.setInt(3, user.getIdade());
			ps.setInt(4, user.getId());

			ps.execute();
			log.debug("Objeto atualizado com sucesso - classe dao");
		} catch (SQLException e) {
			log.error("Falha ao executar comando sql", e);
			throw new RuntimeException(e);
		} catch (Exception e) {
			log.error("Erro na classe DAO", e);
			throw new RuntimeException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (conection != null) {
				try {
					conection.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public List<Usuario> recuperarUser() {
		log.debug("Consultando obejtos na base - classe dao");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM USUARIO ";
			ps = conection.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Usuario> listUser = new ArrayList<Usuario>();

			while (rs.next()) {
				Usuario user = new Usuario();
				user.setId(rs.getInt("ID"));
				user.setNome(rs.getString("NOME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setIdade(rs.getInt("IDADE"));
				listUser.add(user);
			}
			log.debug("Metodo executado com sucesso - classe dao");
			return listUser;
		} catch (SQLException e) {
			log.error("Falha ao executar comando sql", e);
			throw new RuntimeException(e);
		} catch (Exception e) {
			log.error("Erro na classe DAO", e);
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (conection != null) {
				try {
					conection.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public Usuario recuperarUser(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			log.debug("Recuperando objeto especifico - classe dao");
			String sql = "SELECT * FROM USUARIO WHERE ID = ?";

			ps = conection.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				Usuario user = new Usuario();
				user.setId(rs.getInt("ID"));
				user.setNome(rs.getString("NOME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setIdade(rs.getInt("IDADE"));
				log.debug("Foi encontrado um objeto - classe dao");
				return user;
			}
			log.debug("Nao foi encontrado nenhum resultado - Retornando null");
			return null;
		} catch (SQLException e) {
			log.error("Falha ao executar comando sql", e);
			throw new RuntimeException(e);
		} catch (Exception e) {
			log.error("Erro na classe DAO", e);
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (conection != null) {
				try {
					conection.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public Usuario recuperarUser(String nome) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			log.debug("Recuperando objeto especifico - classe dao");
			String sql = "SELECT * FROM USUARIO WHERE NOME = ?";

			ps = conection.prepareStatement(sql);
			ps.setString(1, nome);

			rs = ps.executeQuery();

			if (rs.next()) {
				Usuario user = new Usuario();
				user.setId(rs.getInt("ID"));
				user.setNome(rs.getString("NOME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setIdade(rs.getInt("IDADE"));
				log.debug("Foi encontrado um objeto - classe dao");
				return user;
			}
			log.debug("Nao foi encontrado nenhum resultado - Retornando null");
			return null;
		} catch (SQLException e) {
			log.error("Falha ao executar comando sql", e);
			throw new RuntimeException(e);
		} catch (Exception e) {
			log.error("Erro na classe DAO", e);
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (conection != null) {
				try {
					conection.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}
