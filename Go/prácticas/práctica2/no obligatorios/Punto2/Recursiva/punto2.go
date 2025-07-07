package main

import (
	"fmt"
)

func factorial(n int) int {
	if n == 0 {
		return 1
	}
	return n * factorial(n-1)
}

func main() {
	for n := 0; n <= 9; n++ {
		fmt.Println(n, "! = ", factorial(n))
	}
}
