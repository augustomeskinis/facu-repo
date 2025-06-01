package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"unicode"
)

func cambiarMiercoles(posiciones []int, charFrase []rune, cambio []rune) string {
	for i := 0; i < len(posiciones); i++ {
		inicio := posiciones[i]
		for j := 0; j < 9; j++ {
			char := charFrase[inicio]
			if unicode.IsUpper(char) {
				charFrase[inicio] = unicode.ToUpper(cambio[j])
			} else if unicode.IsLower(char) {
				charFrase[inicio] = cambio[j]
			}
			inicio++
		}
	}
	fraseCambiada := string(charFrase)
	return fraseCambiada
}

func chequearMiercoles(charFrase, charMiercoles []rune, pos int) bool {
	if pos+len(charMiercoles) > len(charFrase) {
		return false
	}
	for i := 0; i < len(charMiercoles); i++ {
		if unicode.ToLower(charFrase[pos+i]) != charMiercoles[i] {
			return false
		}
	}
	return true

}

func fraseTrans(frase string) string {
	charFrase := []rune(frase)
	auxCharFrase := charFrase
	cambio := []rune("automóvil")
	charMiercoles := []rune("miércoles")
	var slicePosiciones []int
	for a := 0; a < len(charFrase); a++ {
		esMiercoles := false
		pos := a
		char := auxCharFrase[a]
		if char == 'm' {
			esMiercoles = chequearMiercoles(auxCharFrase, charMiercoles, pos)
		}
		if esMiercoles {
			slicePosiciones = append(slicePosiciones, pos)
		}
	}
	fc := cambiarMiercoles(slicePosiciones, charFrase, cambio)
	return fc
}

func main() {
	fmt.Println("Ingrese una frase que contenga la palabra miércoles: ")
	reader := bufio.NewReader(os.Stdin)
	frase, err := reader.ReadString('\n')
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println("La frase vieja es: ", frase)
	fraseCambiada := fraseTrans(frase)
	fmt.Println("La frase nueva es: ", fraseCambiada)
}
