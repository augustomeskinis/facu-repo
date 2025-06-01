/*
	1. Leer frase
	2. Mandar la frase y una palabra a una funcion
	3. Pasar la frase a un slice con fields
	4. Pasar la palabra a un slice de runas
	5. Comparar cada palabra de la frase con la palabra
	6. Si es la palabra, invertir mayusculas por minusculas y viceversa
	7. Ir agregando a un slice final
*/

package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strings"
	"unicode"
)

func limpiarPalabra(palabra string) string {
	return strings.TrimFunc(palabra, func(r rune) bool {
		return !unicode.IsLetter(r)
	})
}

func esPalabra(palabra string, palabraBuscar string) bool {
	//Limpio la frase de comas,punto,etc.
	palabra = limpiarPalabra(palabra)
	//Compruebo si es o no es
	es := false
	if strings.ToLower(palabra) == strings.ToLower(palabraBuscar) {
		es = true
	}
	return es
}

func invertirPalabra(slicePalabra []rune) []rune {
	//Recorro cada carácter de la palabra
	for i := 0; i < len(slicePalabra); i++ {
		char := slicePalabra[i]
		//Si es mayúscula, la paso a minúsucla
		if unicode.IsUpper(char) {
			slicePalabra[i] = unicode.ToLower(char)
			//Al revés
		} else {
			slicePalabra[i] = unicode.ToUpper(char)
		}
	}
	return slicePalabra
}

func transformacion(sliceFrase []string, palabraBuscar string) string {
	//Crear string final
	var fraseFinal string
	//Recorrer la frase buscando coinicidencias con la palabra
	for i := 0; i < len(sliceFrase); i++ {
		//Tomo cada palabra
		palabra := sliceFrase[i]
		//Mandamos a ver si la primera palabra de la frase es la palabra
		es := esPalabra(palabra, palabraBuscar)
		//Si es, la invierto
		if es {
			slicePalabra := []rune(palabra)
			slicePalabra = invertirPalabra(slicePalabra)
			palabraInvertida := string(slicePalabra)
			fraseFinal += palabraInvertida + " "
		} else {
			fraseFinal += palabra + " "
		}
	}
	return fraseFinal
}

func main() {
	//Lee frase
	fmt.Println("Ingrese una frase: ")
	reader := bufio.NewReader(os.Stdin)
	frase, err := reader.ReadString('\n')
	//Comprueba que no haya errores al leer la frase
	if err != nil {
		log.Fatal(err)
	}
	//Saca espacios en blanco de más
	frase = strings.TrimSpace(frase)
	//Imprime la frase vieja
	fmt.Println("La frase vieja es: ", frase)
	//Pasamos la frase a un slice con cada palabra
	sliceFrase := strings.Fields(frase)
	//Obtenemos la palabra
	palabra := os.Args[1]
	//Mandamos la palabra y el sliceFrase a transformarse
	fraseFinal := transformacion(sliceFrase, palabra)
	//Imprime la frase cambiada
	fmt.Println("Frase final: ")
	fmt.Println(string(fraseFinal))
}
