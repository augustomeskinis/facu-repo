package main

import "fmt"

func factorial(n int) int {
	if n == 0 {
		return 1
	}
	resultado := 1
	for i := 1; i <= n; i++ {
		resultado *= i
	}
	return resultado
}

func main() {
	var n int
	for n = 0; n <= 9; n++ {
		fmt.Printf("%d! = %d\n", n, factorial(n))
	}
}
