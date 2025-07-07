package main

import (
	"bufio"
	"fmt"
	"os"
	"unicode"
)

func main() {
	var mayusculas, minusculas, especiales int
	digitos := make(map[rune]int) // Mapa para contar ocurrencias de cada dígito
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
			if unicode.IsUpper(ultimo) {
				mayusculas--
			} else if unicode.IsLower(ultimo) {
				minusculas--
			}
			break
		}

		// Contar el carácter actual
		if unicode.IsLetter(runa) {
			if unicode.IsUpper(runa) {
				mayusculas++
			} else if unicode.IsLower(runa) {
				minusculas++
			}
		} else if unicode.IsDigit(runa) {
			digitos[runa]++ // Incrementar el conteo del dígito en el mapa
		} else {
			especiales++
		}

		ultimo = runa
	}

	// Imprimir resultados
	fmt.Printf("Cantidad de letras mayúsculas: %d\n", mayusculas)
	fmt.Printf("Cantidad de letras minúsculas: %d\n", minusculas)
	fmt.Printf("Cantidad de caracteres especiales: %d\n", especiales)
	fmt.Println("Ocurrencias de cada dígito decimal:")
	for i := '0'; i <= '9'; i++ {
		if count, exists := digitos[i]; exists {
			fmt.Printf("Dígito %c: %d\n", i, count)
		} else {
			fmt.Printf("Dígito %c: 0\n", i)
		}
	}
}
