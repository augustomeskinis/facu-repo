package main

import (
	"fmt"
	"time"
)

func enviarValores(c chan int, id int, valores []int) {
	for _, v := range valores {
		c <- v
		time.Sleep(time.Millisecond * 200) // Simula demora en el envío
	}
	close(c)
}

func main() {
	// Crear canales
	canal1 := make(chan int)
	canal2 := make(chan int)
	canal3 := make(chan int)

	// Iniciar las rutinas que envían valores
	go enviarValores(canal1, 1, []int{1, 2, 3})
	go enviarValores(canal2, 2, []int{4, 5, 6, 7})
	go enviarValores(canal3, 3, []int{8, 9})

	// Contadores de valores recibidos por canal
	cont1, cont2, cont3 := 0, 0, 0

	// Estados de canales cerrados
	cerrado1, cerrado2, cerrado3 := false, false, false

	// Loop de recepción
	for !(cerrado1 && cerrado2 && cerrado3) {
		select {
		case val, ok := <-canal1: // val, ok := <-canal	Lee el valor y verifica si está cerrado
			if ok {
				fmt.Println("Recibido de canal1:", val)
				cont1++
			} else {
				cerrado1 = true
			}
		case val, ok := <-canal2:
			if ok {
				fmt.Println("Recibido de canal2:", val)
				cont2++
			} else {
				cerrado2 = true
			}
		case val, ok := <-canal3:
			if ok {
				fmt.Println("Recibido de canal3:", val)
				cont3++
			} else {
				cerrado3 = true
			}
		}
	}

	fmt.Println("\nTotal de valores recibidos:")
	fmt.Println("Canal 1:", cont1)
	fmt.Println("Canal 2:", cont2)
	fmt.Println("Canal 3:", cont3)
}
