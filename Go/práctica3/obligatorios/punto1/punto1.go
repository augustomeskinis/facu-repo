package main

import (
	"fmt"
	"math"
	"os"
	"strconv"
	"sync"
	"time"
)

func esPrimo(n int) bool {
	if n <= 1 {
		return false
	}
	limite := int(math.Sqrt(float64(n)))
	for i := 2; i <= limite; i++ {
		if n%i == 0 {
			return false
		}
	}
	return true
}

func lista1(n int, wg *sync.WaitGroup, canal chan []int) {
	defer wg.Done()
	var slice = []int{}
	for i := 1; i <= n; i++ {
		if esPrimo(i) {
			slice = append(slice, i)
		}
	}
	canal <- slice
}

func lista2(n1 int, n2 int, wg *sync.WaitGroup, canal chan []int) {
	defer wg.Done()
	var slice = []int{}
	for i := n1; i <= n2; i++ {
		if esPrimo(i) {
			slice = append(slice, i)
		}
	}
	canal <- slice
}

func main() {
	n, err := strconv.Atoi(os.Args[1])
	if (err != nil) || (n <= 0) {
		fmt.Println("error")
	} else {
		var wg sync.WaitGroup
		wg.Add(1)
		canal := make(chan []int)
		inicio := time.Now()
		go lista1(n, &wg, canal)
		slice := <-canal
		wg.Wait()
		duracion := time.Since(inicio)
		fmt.Println(slice)
		fmt.Println("tiempo = ", duracion.Milliseconds())
		wg.Add(3)
		tope := (n / 3)
		inicio2 := time.Now()
		go lista2(1, tope, &wg, canal)
		go lista2(tope+1, tope*2, &wg, canal)
		go lista2((tope*2)+1, tope*3, &wg, canal)
		a, b, c := <-canal, <-canal, <-canal
		wg.Wait()
		duracion2 := time.Since(inicio2)
		fmt.Println(a)
		fmt.Println(b)
		fmt.Println(c)
		fmt.Println("tiempo2 = ", duracion2.Milliseconds())
		fmt.Println("Speed Up = ", duracion.Milliseconds()/duracion2.Milliseconds())
	}
}

/*
	ejercicio c) con N = 1.000, speed up = 0
				 con N = 100.000, speed up = 2
				 con N = 1.000.000, speed up = 2
*/
