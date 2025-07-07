package main

import (
	"fmt"
	"strings"
)

// Stack representa una pila de enteros implementada con un slice
type Stack []int

// New crea y devuelve una pila vacía
func New() Stack {
	return Stack{}
}

// IsEmpty verifica si la pila está vacía
func IsEmpty(s Stack) bool {
	return len(s) == 0
}

// Len devuelve el número de elementos en la pila
func Len(s Stack) int {
	return len(s)
}

// ToString devuelve una representación en string de la pila
func ToString(s Stack) string {
	var builder strings.Builder
	builder.WriteString("[")
	for i, elem := range s {
		if i > 0 {
			builder.WriteString(", ")
		}
		fmt.Fprintf(&builder, "%d", elem)
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
	return s[len(s)-1]
}

// Push agrega un elemento al final de la pila (cima)
func Push(s *Stack, element int) {
	*s = append(*s, element)
}

// Pop elimina y devuelve el elemento en la cima de la pila
// Si la pila está vacía, lanza un panic
func Pop(s *Stack) int {
	if IsEmpty(*s) {
		panic("pila vacía")
	}
	n := len(*s)
	element := (*s)[n-1]
	*s = (*s)[:n-1]
	return element
}

// Iterate aplica la función f a cada elemento de la pila, de la base a la cima
func Iterate(s Stack, f func(int) int) {
	for i := 0; i < len(s); i++ {
		s[i] = f(s[i])
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
	Iterate(pila, func(x int) int { return x * 2 })
	fmt.Println("\nDespués de duplicar elementos:", ToString(pila))

	// Eliminar elementos
	fmt.Println("\nPop:", Pop(&pila))
	fmt.Println("Pila después de Pop:", ToString(pila))
	fmt.Println("Pop:", Pop(&pila))
	fmt.Println("Pila después de Pop:", ToString(pila))
}
