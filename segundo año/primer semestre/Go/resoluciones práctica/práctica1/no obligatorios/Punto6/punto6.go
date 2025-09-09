package main

import "fmt"

func division(n1, n2 int) float64 {
	if n1 >= n2 {
		return float64(n1 / n2)
	}
	return float64(n1 / 2)
}

func main() {
	var num1 int
	var num2 int
	fmt.Print(("Ingrese un número entero: "))
	fmt.Scan(&num1)
	fmt.Print(("Ingrese un número entero: "))
	fmt.Scan(&num2)
	var resultado float64 = division(num1, num2)
	fmt.Printf("El valor de la división es = %f", resultado)
}

//punto b, con uint
//punto b, num1 y num2 son float64
