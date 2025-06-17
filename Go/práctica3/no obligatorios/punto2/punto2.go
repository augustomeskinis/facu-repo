package main

import (
	"fmt"
	"strings"
)

type Nodo[T any] struct {
	valor     T
	siguiente *Nodo[T]
}

type List[T any] struct {
	cabeza   *Nodo[T]
	longitud int
}

// Nuevo crea una nueva lista vacía
func New[T any]() *List[T] {
	return &List[T]{nil, 0}
}

// EstaVacia verifica si la lista está vacía
func EstaVacia[T any](l *List[T]) bool {
	return l.cabeza == nil
}

// Longitud devuelve el número de elementos en la lista
func Longitud[T any](l *List[T]) int {
	return l.longitud
}

// ElementoFrontal devuelve el valor del primer elemento
func ElementoFrontal[T any](l *List[T]) T {
	if EstaVacia(l) {
		panic("Lista vacía")
	}
	return l.cabeza.valor
}

// Siguiente devuelve la lista a partir del nodo siguiente
func Siguiente[T any](l *List[T]) *List[T] {
	if EstaVacia(l) || l.cabeza.siguiente == nil {
		return nil
	}
	return &List[T]{l.cabeza.siguiente, l.longitud - 1}
}

// AString convierte la lista a una representación en string
func AString[T any](l *List[T]) string {
	if EstaVacia(l) {
		return "[]"
	}
	var builder strings.Builder
	builder.WriteString("[")
	actual := l.cabeza
	for actual != nil {
		builder.WriteString(fmt.Sprint(actual.valor))
		if actual.siguiente != nil {
			builder.WriteString(", ")
		}
		actual = actual.siguiente
	}
	builder.WriteString("]")
	return builder.String()
}

// AgregarFrente añade un elemento al inicio de la lista
func AgregarFrente[T any](l *List[T], elem T) {
	nuevoNodo := &Nodo[T]{valor: elem, siguiente: l.cabeza}
	l.cabeza = nuevoNodo
	l.longitud++
}

// AgregarAtras añade un elemento al final de la lista
func AgregarAtras[T any](l *List[T], elem T) {
	nuevoNodo := &Nodo[T]{valor: elem, siguiente: nil}
	if EstaVacia(l) {
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
func Eliminar[T any](l *List[T]) T {
	if EstaVacia(l) {
		panic("Lista vacía")
	}
	valor := l.cabeza.valor
	l.cabeza = l.cabeza.siguiente
	l.longitud--
	return valor
}

func main() {
	lista := New[int]()
	fmt.Println(lista)
}
