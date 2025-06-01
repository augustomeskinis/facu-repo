package main

import "fmt"

func puntoc() {
	const tope int = 250
	var i int = 0
	for {
		fmt.Println("Número: ", i)
		i = i + 2
		if i >= tope {
			break
		}
	}
}

func puntob() {
	var i int = 250
	for {
		fmt.Println("Número: ", i)
		i = i - 2
		if i < 0 {
			break
		}
	}
}

func main() {
	var i int = 0
	for {
		fmt.Println("Número: ", i)
		i = i + 2
		if i >= 250 {
			break
		}
	}
	fmt.Println("Punto b:")
	puntob()
	fmt.Println("Punto c:")
	puntoc()
}
