package main

import (
	"fmt"
)

func cargarSlice1(s1 []int) {
	for {
		var numS1 int
		fmt.Print("Ingrese un valor para agregar al slice 1: ")
		fmt.Scan(&numS1)
		if numS1 == -1 {
			break
		}
		s1 = append(s1, numS1)
	}
}

func cargarSlice2(s2 []int) {
	for {
		var numS2 int
		fmt.Print("Ingrese un valor para agregar al slice 2: ")
		fmt.Scan(&numS2)
		if numS2 == -1 {
			break
		}
		s2 = append(s2, numS2)
	}
}

func Sum(a, b []int) []int {
	var tamaño int
	var s3 []int
	if len(a) < len(b) {
		tamaño = len(a)
	} else {
		tamaño = len(b)
	}
	for i := 0; i < tamaño; i++ {
		valor := a[i] + b[i]
		s3 = append(s3, valor)
	}
	return s3
}

func Avg(a []int) float64 {
	var total float64 = 0
	for i := 0; i < len(a); i++ {
		total += float64(a[i])
	}
	total = float64(total)
	tamaño := float64(len(a))
	return tamaño / total
}

func main() {
	var s1, s2 []int
	cargarSlice1(s1)
	cargarSlice2(s2)
	s3 := Sum(s1, s2)
	promedio := Avg(s1)
	fmt.Printf("Slice 1: ", s1)
	fmt.Println("Slice 2: ", s2)
	fmt.Println("Slice 3: ", s3)
	fmt.Println("Promedio slice 1: ", promedio)
}
