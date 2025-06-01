package main

import (
	"bufio"
	"fmt"
	"os"
	"unicode"
)

func pepe() {
	// Leer una frase desde la entrada estándar
	fmt.Print("Ingrese una frase: ")
	reader := bufio.NewReader(os.Stdin)
	frase, _ := reader.ReadString('\n') // Lee hasta que encuentre un salto de línea

	// Recorrer la frase y analizar cada carácter
	for _, char := range frase {
		if unicode.IsUpper(char) {
			fmt.Printf("'%c' es MAYÚSCULA\n", char)
		} else if unicode.IsLower(char) {
			fmt.Printf("'%c' es minúscula\n", char)
		}
	}
}
