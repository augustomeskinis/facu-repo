package main

import (
	"fmt"
)

type Vector [5]float64

func Initialize(v Vector, f float64) {
	for i := 0; i < len(v); i++ {
		v[i] = f
	}
}

func Sum(v1, v2 Vector) Vector {
	var v3 Vector
	for i := 0; i < 5; i++ {
		v3[i] = v1[i] + v2[i]
	}
	return v3
}

func SumInPlace(v1, v2 Vector) {
	for i := 1; i < 5; i++ {
		v1[i] += v2[i]
	}
}

func main() {
	var v1, v2 Vector
	var f float64 = 0
	Initialize(v1, f)
	Initialize(v2, f)
	v3 := Sum(v1, v2)
	SumInPlace(v1, v2)
	fmt.Println("Vector 1: ", v1)
	fmt.Println("Vector 2: ", v2)
	fmt.Println("Vector 3: ", v3)
}
