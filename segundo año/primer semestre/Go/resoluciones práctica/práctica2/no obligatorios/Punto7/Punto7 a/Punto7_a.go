package main

import (
	"bufio"
	"fmt"
	"os"
	"unicode"
)

func main() {
	var letras, numeros, especiales int
	reader := bufio.NewReader(os.Stdin)

	fmt.Println("Ingrese una secuencia de caracteres (finaliza con la secuencia 'CR'):")

	var ultimo rune
	for {
		runa, _, err := reader.ReadRune()
		if err != nil {
			fmt.Println("Error al leer la entrada:", err)
			break
		}

		// Verificar si los últimos dos caracteres son 'C' y 'R'
		if ultimo == 'C' && runa == 'R' {
			// Descontar el 'C' si fue contado como letra
			if unicode.IsLetter(ultimo) {
				letras--
			}
			break
		}

		// Contar el carácter actual
		if unicode.IsLetter(runa) {
			letras++
		} else if unicode.IsDigit(runa) {
			numeros++
		} else {
			especiales++
		}

		ultimo = runa
	}

	fmt.Printf("Cantidad de letras: %d\n", letras)
	fmt.Printf("Cantidad de números: %d\n", numeros)
	fmt.Printf("Cantidad de caracteres especiales: %d\n", especiales)
}
