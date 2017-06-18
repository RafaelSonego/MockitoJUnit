package mokitoJunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.rafaelsonego.domain.Usuario;
import br.com.rafaelsonego.service.UsuarioService;

public class UsuarioMockitoTest {

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
			UsuarioService userServiceFalse = mock(UsuarioService.class);
			when(userServiceFalse.salvar(user)).thenReturn(user);			
			Usuario usuarioRecuperado = userServiceFalse.salvar(user);
			assertEquals(usuarioRecuperado.getNome(), user.getNome());
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void testeMetoroUpdate() {
		try {
			UsuarioService userServiceFalse = mock(UsuarioService.class);
			when(userServiceFalse.atualizar(user)).thenReturn(user);			
			Usuario usuarioRecuperado = userServiceFalse.atualizar(user);
			assertEquals(usuarioRecuperado.getNome(), user.getNome());
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void testandoMetodoConsultaLista() {
		try {
			UsuarioService userServiceFalse = mock(UsuarioService.class);
			List<Usuario> listUsuario = Arrays.asList(user);
			when(userServiceFalse.recuperarUser()).thenReturn(listUsuario);	
			List<Usuario> lista = userServiceFalse.recuperarUser();
			assertTrue(lista.size() > 0);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void testandoMetodoConsultaEspecifico() {
		try {
			UsuarioService userServiceFalse = mock(UsuarioService.class);
			when(userServiceFalse.recuperarUser(0)).thenReturn(user);	
			Usuario user = userServiceFalse.recuperarUser(0);
			assertNotNull(user);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

}
