package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"unicode"
)

func cambiarJueves(posiciones []int, charFrase []rune, cambio []rune) string {
	for i := 0; i < len(posiciones); i++ {
		inicio := posiciones[i]
		for j := 0; j < 6; j++ {
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

func chequearJueves(charFrase, charJueves []rune, pos int) bool {
	if pos+len(charJueves) > len(charFrase) {
		return false
	}
	for i := 0; i < len(charJueves); i++ {
		if unicode.ToLower(charFrase[pos+i]) != charJueves[i] {
			return false
		}
	}
	return true

}

func fraseTrans(frase string) string {
	charFrase := []rune(frase)
	auxCharFrase := charFrase
	cambio := []rune("martes")
	var charJueves = []rune("jueves")
	var slicePosiciones []int
	for a := 0; a < len(charFrase); a++ {
		esJueves := false
		pos := a
		char := auxCharFrase[a]
		if char == 'j' {
			esJueves = chequearJueves(auxCharFrase, charJueves, pos)
		}
		if esJueves {
			slicePosiciones = append(slicePosiciones, pos)
		}
	}
	fc := cambiarJueves(slicePosiciones, charFrase, cambio)
	return fc
}

func main() {
	fmt.Println("Ingrese una frase que contenga la palabra jueves/martes: ")
	reader := bufio.NewReader(os.Stdin)
	frase, err := reader.ReadString('\n')
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println("La frase vieja es: ", frase)
	fraseCambiada := fraseTrans(frase)
	fmt.Println("La frase nueva es: ", fraseCambiada)
}
