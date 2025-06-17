package ar.edu.unlp.info.oo1.ejercicio17_AlquilerDePropiedades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testPropiedad { // IGNORAR, FUE PARA PROBAR NOMAS NO VAS A ENTENDER NADA
	Propiedad propiedad;
	LocalDate from1;
	LocalDate to1;
	Reserva reserva1;
	LocalDate from2;
	LocalDate to2;
	Reserva reserva2;
	Usuario usuario1;
	@BeforeEach
	public void setUp () {
		usuario1 = new Usuario ("","",1);
		
		propiedad = new Propiedad ("15 n98", "prop", 10);
		from1 = LocalDate.of(2025, 01, 01);
		to1 = LocalDate.of(2025, 01, 10);
		DateLapse dateLapse1 = new DateLapse (from1,to1);
		reserva1 = new Reserva (usuario1, dateLapse1);
		
		from2 = LocalDate.of(2025, 02, 01);
		to2 = LocalDate.of(2025, 02, 10);
		DateLapse dateLapse2 = new DateLapse (from2,to2);
		reserva2 = new Reserva (usuario1,dateLapse2);
	}
	
	
	@Test
	public void testConsultarDisponibilidad (){
		propiedad.añadirReserva(reserva1);
		propiedad.añadirReserva(reserva2);
		
		LocalDate from3 = LocalDate.of(2025, 01, 10);
		LocalDate to3 = LocalDate.of(2025, 01, 15);
		DateLapse otroDateLapse = new DateLapse (from3,to3);
		assertEquals(false, propiedad.consultarDisponibilidad(otroDateLapse));
		
		from3 = LocalDate.of(2025, 01, 20);
		to3 = LocalDate.of(2025, 01, 30);
		otroDateLapse = new DateLapse (from3,to3);
		assertEquals(true, propiedad.consultarDisponibilidad(otroDateLapse));
		
		from3 = LocalDate.of(2025, 02, 11);
		to3 = LocalDate.of(2025, 02, 15);
		otroDateLapse = new DateLapse (from3,to3);
		assertEquals(true, propiedad.consultarDisponibilidad(otroDateLapse));
	}
	
	
	
	
	
	
}
