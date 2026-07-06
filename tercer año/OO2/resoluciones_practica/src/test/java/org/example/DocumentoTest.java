package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import parcialesViejos.parcial2.patrones.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DocumentoTest {

    private Documento documento;

    @BeforeEach
    public void setUp() {
        Elemento parrafoIntro = new Parrafo("Temas de la materia:");
        Elemento lista = new ListaOrdenada(List.of("Patrones de diseño", "Refactoring de código"));
        Elemento seccionInterna = new Seccion("Arquitectura de servicios",
                List.of(new Parrafo("Arranca el semestre que viene")));

        Elemento seccionRaiz = new Seccion("Orientación a objetos",
                List.of(parrafoIntro, lista, seccionInterna));

        documento = new Documento("Plan de estudio", "Pedro", seccionRaiz);
    }

    @Test
    public void testToString() {
        String esperado =
                "Plan de estudio - Pedro\n" +
                        "### Orientación a objetos\n" +
                        "Temas de la materia:\n" +
                        "1. Patrones de diseño\n" +
                        "2. Refactoring de código\n" +
                        "### Arquitectura de servicios\n" +
                        "Arranca el semestre que viene\n";

        assertEquals(esperado, documento.toString());
    }

    @Test
    public void testBuscarTextoExistente() {
        assertTrue(documento.buscar("Refactoring"));   // ítem de la lista
        assertTrue(documento.buscar("Arquitectura"));  // título de sección interna
        assertTrue(documento.buscar("semestre"));      // texto de un párrafo
    }

    @Test
    public void testBuscarTextoInexistente() {
        assertFalse(documento.buscar("Programación funcional"));
    }

    @Test
    public void testTraducir() {
        Documento traducido = documento.traducir();

        // es un documento nuevo, no el mismo
        assertNotSame(documento, traducido);

        // con el stub Translator -> "[traducido] " + texto
        assertTrue(traducido.toString().contains("[traducido] Orientación a objetos"));
        assertTrue(traducido.toString().contains("[traducido] Patrones de diseño"));

        // el original no se modificó
        assertFalse(documento.toString().contains("[traducido]"));
    }
}