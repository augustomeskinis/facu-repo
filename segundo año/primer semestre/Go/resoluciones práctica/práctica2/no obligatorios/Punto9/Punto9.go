package main

import (
	"fmt"
	"strings"
)

// Nodo representa un nodo de la lista enlazada
type Nodo struct {
	valor     int
	siguiente *Nodo
}

// Lista representa la lista enlazada
type Lista struct {
	cabeza   *Nodo
	longitud int
}

// Nuevo crea una nueva lista vacía
func Nueva() *Lista {
	return &Lista{nil, 0}
}

// EstaVacia verifica si la lista está vacía
func (l *Lista) EstaVacia() bool {
	return l.cabeza == nil
}

// Longitud devuelve el número de elementos en la lista
func (l *Lista) Longitud() int {
	return l.longitud
}

// ElementoFrontal devuelve el valor del primer elemento
func (l *Lista) ElementoFrontal() int {
	if l.EstaVacia() {
		panic("Lista vacía")
	}
	return l.cabeza.valor
}

// Siguiente devuelve la lista a partir del nodo siguiente
func (l *Lista) Siguiente() *Lista {
	if l.EstaVacia() || l.cabeza.siguiente == nil {
		return Nueva()
	}
	return &Lista{l.cabeza.siguiente, l.longitud - 1}
}

// AString convierte la lista a una representación en string
func (l *Lista) AString() string {
	if l.EstaVacia() {
		return "[]"
	}
	var builder strings.Builder
	builder.WriteString("[")
	actual := l.cabeza
	for actual != nil {
		builder.WriteString(fmt.Sprintf("%d", actual.valor))
		if actual.siguiente != nil {
			builder.WriteString(", ")
		}
		actual = actual.siguiente
	}
	builder.WriteString("]")
	return builder.String()
}

// AgregarFrente añade un elemento al inicio de la lista
func (l *Lista) AgregarFrente(elem int) {
	nuevoNodo := &Nodo{valor: elem, siguiente: l.cabeza}
	l.cabeza = nuevoNodo
	l.longitud++
}

// AgregarAtras añade un elemento al final de la lista
func (l *Lista) AgregarAtras(elem int) {
	nuevoNodo := &Nodo{valor: elem, siguiente: nil}
	if l.EstaVacia() {
		l.cabeza = nuevoNodo
	} else {
		actual := l.cabeza
		for actual.siguiente != nil {
			actual = actual.siguiente
		}
		actual.siguiente = nuevoNodo
	}
	l.longitud++
}

// Eliminar remueve y devuelve el primer elemento
func (l *Lista) Eliminar() int {
	if l.EstaVacia() {
		panic("Lista vacía")
	}
	valor := l.cabeza.valor
	l.cabeza = l.cabeza.siguiente
	l.longitud--
	return valor
}

// Iterar aplica una función a cada elemento de la lista
func (l *Lista) Iterar(f func(int) int) {
	actual := l.cabeza
	for actual != nil {
		actual.valor = f(actual.valor)
		actual = actual.siguiente
	}
}

// Función principal para demostrar el uso
func main() {
	lista := Nueva()
	fmt.Println("Lista vacía:", lista.AString())
	fmt.Println("¿Está vacía?:", lista.EstaVacia())
	fmt.Println("Longitud:", lista.Longitud())

	// Agregar elementos
	lista.AgregarFrente(1)
	lista.AgregarFrente(2)
	lista.AgregarAtras(3)
	fmt.Println("\nDespués de agregar 2, 1, 3:", lista.AString())
	fmt.Println("Elemento frontal:", lista.ElementoFrontal())
	fmt.Println("Longitud:", lista.Longitud())

	// Iterar para duplicar valores
	lista.Iterar(func(x int) int { return x * 2 })
	fmt.Println("Después de duplicar valores:", lista.AString())

	// Usar Siguiente
	listaSiguiente := lista.Siguiente()
	fmt.Println("Lista desde el segundo elemento:", listaSiguiente.AString())

	// Eliminar elemento
	eliminado := lista.Eliminar()
	fmt.Println("Elemento eliminado:", eliminado)
	fmt.Println("Lista después de eliminar:", lista.AString())
}
