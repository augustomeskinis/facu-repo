package ar.edu.unlp.info.oo1.ejercicio20_LiquidacionDeHaberes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testEmpleado {
	private Empleado empleado;
	private ContratoPorHoras contratoPorHoras;
	private ContratoDePlanta contratoDePlanta;
	private LocalDate fecha1 ;
	private LocalDate fecha2 ; 
	
	@BeforeEach
	public void setUp () {
		LocalDate fecha1 = LocalDate.of(2010, 1, 1);
		LocalDate fecha2 = LocalDate.of(2015, 1, 1);
		contratoPorHoras = new ContratoPorHoras (fecha1,fecha2,10,100);
		fecha1 = LocalDate.of(2015, 1, 1);
		contratoDePlanta = new ContratoDePlanta (fecha1,null,100,5,10);
		empleado = new Empleado ("augusto","meskinis",20463451,fecha1,true,contratoPorHoras);
	}
	
	@Test
	public void testNuevoContrato () {
		fecha1 = LocalDate.of(2020, 1, 1);
		fecha2 = LocalDate.of(2025, 1, 1);
		contratoPorHoras = new ContratoPorHoras (fecha1,fecha2,10,100);
		assertEquals (true, empleado.nuevoContrato(contratoPorHoras));
		fecha1 = LocalDate.of(2024, 1, 1);
		fecha2 = LocalDate.of(2027, 1, 1);
		contratoPorHoras = new ContratoPorHoras (fecha1,fecha2,10,100);
		assertEquals (false, empleado.nuevoContrato(contratoPorHoras));
		assertEquals (false,empleado.nuevoContrato(contratoDePlanta));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
