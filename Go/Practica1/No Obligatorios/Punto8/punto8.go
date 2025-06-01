package main

import "fmt"

func main() {
	var puntoCardinal string
	fmt.Print("Ingrese un punto cardinal: ")
	fmt.Scan(&puntoCardinal)
	switch {
	case ((puntoCardinal == "N") || (puntoCardinal == "n")):
		fmt.Println("El viento de dirige al sur")
	case ((puntoCardinal == "S") || (puntoCardinal == "s")):
		fmt.Println("El viento de dirige al norte")
	case ((puntoCardinal == "E") || (puntoCardinal == "e")):
		fmt.Println(("El viento se dirige al oeste"))
	case ((puntoCardinal == "O") || (puntoCardinal == "o")):
		fmt.Println(("El viento se dirige al este"))
	default:
		fmt.Println(("Punto cardinal inválido"))
	}
}
