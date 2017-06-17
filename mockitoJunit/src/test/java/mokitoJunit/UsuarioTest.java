package mokitoJunit;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import br.com.rafaelsonego.domain.Usuario;
import br.com.rafaelsonego.service.UsuarioService;
import br.com.rafaelsonego.service.impl.UsuarioServiceImpl;

public class UsuarioTest {

	private Usuario user;

	@Before
	public void criaDomain() {
		this.user = new Usuario();
		user.setNome("Rafael");
		user.setEmail("rafael2785@gmail.com");
		user.setIdade(32);
		user.setId(0);
	}

	@Test
	public void testeMetodoSave() {
		try {
			UsuarioService userService = new UsuarioServiceImpl();
			userService.salvar(user);
			Usuario usuarioRecuperado = userService.recuperarUser("Rafael");
			assertEquals(usuarioRecuperado.getNome(), user.getNome());
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void testeMetoroUpdate() {
		try {
			user.setNome("UPDATE");
			UsuarioService userService = new UsuarioServiceImpl();
			userService.atualizar(user);
			Usuario usuarioRecuperado = userService.recuperarUser("UPDATE");
			assertEquals(usuarioRecuperado.getNome(), user.getNome());
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void testandoMetodoConsultaLista() {
		try {
			UsuarioService userService = new UsuarioServiceImpl();
			List<Usuario> lista = userService.recuperarUser();
			assertTrue(lista.size() > 0);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void testandoMetodoConsultaEspecifico() {
		try {
			UsuarioService userService = new UsuarioServiceImpl();
			Usuario user = userService.recuperarUser(0);
			assertNotNull(user);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

}
