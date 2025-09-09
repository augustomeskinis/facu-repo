package main

import (
	"fmt"     // Importa el paquete fmt para imprimir en consola
	"strings" // Importa el paquete strings para usar strings.Builder
)

// Convert convierte un entero v a su representación en base b como string
func Convert(v int, b int) string {
	// Validar que la base esté entre 2 y 36 (inclusive)
	if b < 2 || b > 36 {
		return "" // Retorna string vacío si la base es inválida
	}

	// Manejar el caso especial cuando v es 0
	if v == 0 {
		return "0" // Retorna "0" directamente, ya que 0 en cualquier base es 0
	}

	// Definir los dígitos para las bases hasta 36 (0-9 y A-Z)
	digits := "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

	// Verificar si el número es negativo para manejar el signo
	isNegative := v < 0
	if isNegative {
		v = -v // Convertir v a positivo para realizar los cálculos
	}

	// Usar strings.Builder para construir el string eficientemente
	var result strings.Builder
	// Bucle para convertir el número a la base b
	for v > 0 {
		remainder := v % b                  // Obtener el residuo de v dividido por b
		result.WriteByte(digits[remainder]) // Añadir el dígito correspondiente al residuo
		v /= b                              // Dividir v por b para continuar con el siguiente dígito
	}

	// Si el número es negativo, añadir el signo menos
	if isNegative {
		result.WriteByte('-') // Agrega '-' al final del string construido
	}

	// Convertir el string construido a un slice de runas para invertir
	runes := []rune(result.String())
	// Invertir el string, ya que los dígitos se generaron en orden inverso
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i] // Intercambiar runas desde los extremos
	}

	// Convertir el slice de runas de vuelta a string y retornarlo
	return string(runes)
}

func main() {
	// Ejemplos de uso para probar la función
	fmt.Println(Convert(23, 2))   // Imprime: 10111 (23 en base 2)
	fmt.Println(Convert(23, 16))  // Imprime: 17 (23 en base 16)
	fmt.Println(Convert(-23, 2))  // Imprime: -10111 (-23 en base 2)
	fmt.Println(Convert(0, 10))   // Imprime: 0 (0 en base 10)
	fmt.Println(Convert(255, 16)) // Imprime: FF (255 en base 16)
}
