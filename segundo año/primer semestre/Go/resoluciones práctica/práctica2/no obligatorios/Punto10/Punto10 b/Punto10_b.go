package main

import (
	"fmt"
	"strings"
)

// Node representa un nodo de la lista enlazada
type Node struct {
	value int
	next  *Node
}

// Stack representa una pila de enteros implementada con una lista enlazada
type Stack struct {
	head *Node
	size int
}

// New crea y devuelve una pila vacía
func New() Stack {
	return Stack{head: nil, size: 0}
}

// IsEmpty verifica si la pila está vacía
func IsEmpty(s Stack) bool {
	return s.head == nil
}

// Len devuelve el número de elementos en la pila
func Len(s Stack) int {
	return s.size
}

// ToString devuelve una representación en string de la pila
func ToString(s Stack) string {
	var builder strings.Builder
	builder.WriteString("[")
	current := s.head
	for i := 0; current != nil; i++ {
		if i > 0 {
			builder.WriteString(", ")
		}
		fmt.Fprintf(&builder, "%d", current.value)
		current = current.next
	}
	builder.WriteString("]")
	return builder.String()
}

// FrontElement devuelve el elemento en la cima de la pila sin eliminarlo
// Si la pila está vacía, lanza un panic
func FrontElement(s Stack) int {
	if IsEmpty(s) {
		panic("pila vacía")
	}
	return s.head.value
}

// Push agrega un elemento al inicio de la pila (cima)
func Push(s *Stack, element int) {
	newNode := &Node{value: element, next: s.head}
	s.head = newNode
	s.size++
}

// Pop elimina y devuelve el elemento en la cima de la pila
// Si la pila está vacía, lanza un panic
func Pop(s *Stack) int {
	if IsEmpty(*s) {
		panic("pila vacía")
	}
	element := s.head.value
	s.head = s.head.next
	s.size--
	return element
}

// Iterate aplica la función f a cada elemento de la pila, de la cima a la base
func Iterate(s *Stack, f func(int) int) {
	current := s.head
	for current != nil {
		current.value = f(current.value)
		current = current.next
	}
}

// Ejemplo de uso
func main() {
	// Crear una pila
	pila := New()
	fmt.Println("Pila inicial:", ToString(pila))
	fmt.Println("Está vacía?", IsEmpty(pila))
	fmt.Println("Tamaño:", Len(pila))

	// Agregar elementos
	Push(&pila, 1)
	Push(&pila, 2)
	Push(&pila, 3)
	fmt.Println("\nDespués de Push(1, 2, 3):", ToString(pila))
	fmt.Println("Tamaño:", Len(pila))
	fmt.Println("Elemento en la cima:", FrontElement(pila))

	// Iterar para duplicar cada elemento
	Iterate(&pila, func(x int) int { return x * 2 })
	fmt.Println("\nDespués de duplicar elementos:", ToString(pila))

	// Eliminar elementos
	fmt.Println("\nPop:", Pop(&pila))
	fmt.Println("Pila después de Pop:", ToString(pila))
	fmt.Println("Pop:", Pop(&pila))
	fmt.Println("Pila después de Pop:", ToString(pila))
}
