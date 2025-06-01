/*
1. Tengo la frase
2. Convertir frase al slice de runas
3. Recorrer slice de frase hasta espacio en blanco
4. Mientras recorro slice frase,agrego caracter a
variable palabra
5. Con variable contador palabra, si variable es impar
hago el paso 6, sino agrego directamente a slice final
6. Convierto palabra a slice palabra
7. Mando palabra a invertirse y me devuelve slice de
palabra invertida, y la agrego a slice frase final
8. Creo slice de palabra invertida vacio
9. Con un for al reves, recorro el slice palabra y voy
agrgando al slice invertido
10. Imprimir slice final
*/

package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strings"
)

func convertirPalabra(slicePalabra []rune) []rune {
	var slicePalabraInvertido []rune
	for i := len(slicePalabra) - 1; i >= 0; i-- {
		slicePalabraInvertido = append(slicePalabraInvertido, slicePalabra[i])
	}
	return slicePalabraInvertido
}

func main() {
	fmt.Println("Ingrese una frase: ")
	reader := bufio.NewReader(os.Stdin)
	frase, err := reader.ReadString('\n')

	if err != nil {
		log.Fatal(err)
	}

	frase = strings.TrimSpace(frase)
	fmt.Println("La frase vieja es: ", frase)

	sliceFrase := []rune(frase)
	var sliceFinal []rune
	var palabra []rune
	contPalabra := 0

	for i := 0; i < len(sliceFrase); i++ {
		char := sliceFrase[i]
		if char != ' ' && char != '\n' {
			palabra = append(palabra, char)
		} else {
			if len(palabra) > 0 {
				contPalabra++
				if contPalabra%2 == 1 {
					palabraInvertida := convertirPalabra(palabra)
					sliceFinal = append(sliceFinal, palabraInvertida...)
					sliceFinal = append(sliceFinal, ' ')
				} else {
					sliceFinal = append(sliceFinal, palabra...)
					sliceFinal = append(sliceFinal, ' ')
				}
				palabra = nil
			}
		}
	}

	if len(palabra) > 0 {
		contPalabra++
		if contPalabra%2 == 1 {
			palabraInvertida := convertirPalabra(palabra)
			sliceFinal = append(sliceFinal, palabraInvertida...)
		} else {
			sliceFinal = append(sliceFinal, palabra...)
		}
	}

	fmt.Println("Frase final: ")
	fmt.Println(string(sliceFinal))
}
