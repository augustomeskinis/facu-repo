package main

import (
	"fmt"
)

type Map[K comparable, V any] map[K]V

func main() {
	mapa1 := Map[int, string]{
		1: "Argentina",
		2: "Francia",
		3: "Brasil",
		4: "Holanda",
	}
	mapa2 := Map[string, string]{
		"Mateo":   "Cordo",
		"Augusto": "Meskinis",
	}
	for index, valor := range mapa1 {
		fmt.Println(index, ": ", valor)
	}
	for index, valor := range mapa2 {
		fmt.Println(index, ": ", valor)
	}
}
