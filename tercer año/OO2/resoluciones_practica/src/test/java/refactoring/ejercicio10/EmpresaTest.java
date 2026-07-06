package refactoring.ejercicio10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import refactoring.ejercicio10.conRefactoring.*;

class EmpresaTest {
	Empresa sistema;

	@BeforeEach
	public void setUp() {
		this.sistema = new Empresa();
		this.sistema.agregarNumeroTelefono("2214444554");
		this.sistema.agregarNumeroTelefono("2214444555");
		this.sistema.agregarNumeroTelefono("2214444556");
		this.sistema.agregarNumeroTelefono("2214444557");
		this.sistema.agregarNumeroTelefono("2214444558");
		this.sistema.agregarNumeroTelefono("2214444559");
	}

	@Test
	void testcalcularMontoTotalLlamadas() {
		Cliente emisorPersonaFisca = sistema.registrarUsuario("11555666", "Brendan Eich" , "fisica");
		Cliente remitentePersonaFisica = sistema.registrarUsuario("00000001", "Doug Lea" , "fisica");
		Cliente emisorPersonaJuridica = sistema.registrarUsuario("17555222", "Nvidia Corp" , "juridica");
		Cliente remitentePersonaJuridica = sistema.registrarUsuario("25765432", "Sun Microsystems" , "juridica");

		LLamadaStrategy nac = new LlamadaNacional();
		LLamadaStrategy inter = new LlamadaInternacional();

		this.sistema.registrarLlamada(emisorPersonaJuridica, remitentePersonaFisica, nac, 10);
		this.sistema.registrarLlamada(emisorPersonaJuridica, remitentePersonaFisica, inter, 8);
		this.sistema.registrarLlamada(emisorPersonaJuridica, remitentePersonaJuridica, nac, 5);
		this.sistema.registrarLlamada(emisorPersonaJuridica, remitentePersonaJuridica, inter, 7);
		this.sistema.registrarLlamada(emisorPersonaFisca, remitentePersonaFisica, nac, 15);
		this.sistema.registrarLlamada(emisorPersonaFisca, remitentePersonaFisica, inter, 45);
		this.sistema.registrarLlamada(emisorPersonaFisca, remitentePersonaJuridica, nac, 13);
		this.sistema.registrarLlamada(emisorPersonaFisca, remitentePersonaJuridica, inter, 17);

		assertEquals(11454.64, this.sistema.calcularMontoTotalLlamadas(emisorPersonaFisca), 0.01);
		assertEquals(2445.40, this.sistema.calcularMontoTotalLlamadas(emisorPersonaJuridica), 0.01);
		assertEquals(0, this.sistema.calcularMontoTotalLlamadas(remitentePersonaFisica));
		assertEquals(0, this.sistema.calcularMontoTotalLlamadas(remitentePersonaJuridica));
	}

	@Test
	void testAgregarUsuario() {
		assertEquals(this.sistema.cantidadDeUsuarios(), 0);
		this.sistema.agregarNumeroTelefono("2214444558"); 
		Cliente nuevaPersona = this.sistema.registrarUsuario("2444555","Alan Turing", "fisica");

		assertEquals(1, this.sistema.cantidadDeUsuarios());
		assertTrue(this.sistema.existeUsuario(nuevaPersona));
	}

	@Test
	void obtenerNumeroLibre() {
		// por defecto es el ultimo
		assertEquals("2214444559", this.sistema.obtenerNumeroLibre());

		this.sistema.getGestorNumeros().setStrategy(new GeneradorPrimero());
		assertEquals("2214444554", this.sistema.obtenerNumeroLibre());

		this.sistema.getGestorNumeros().setStrategy(new GeneradorRandom());
		assertNotNull(this.sistema.obtenerNumeroLibre());
	}
}
