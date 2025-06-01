package main

import "fmt"

func funcion(n int) int {
	switch {
	case n < (-18):
		return (n * (-1))
	case (n >= (-18) && (n < (-1))):
		return (n % 4)
	case (n >= 1 && n < 20):
		return n * n
	case (n >= 20):
		return -n
	default:
		return n
	}
}

func main() {
	var n int
	fmt.Print("Ingrese un número: ")
	fmt.Scan(&n)
	resultado := funcion(n)
	fmt.Println(resultado)
}
