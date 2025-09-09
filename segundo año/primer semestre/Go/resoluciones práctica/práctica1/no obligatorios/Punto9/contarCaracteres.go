package main

import (
	"fmt"
	"unicode/utf8"
)

func hola() {
	str := "Hola 😊"
	fmt.Println("Bytes:", len(str))                    // Muestra la cantidad de bytes
	fmt.Println("Runas:", utf8.RuneCountInString(str)) // Cuenta la cantidad de caracteres reales
}

//Bytes: 10
//Runas: 6
