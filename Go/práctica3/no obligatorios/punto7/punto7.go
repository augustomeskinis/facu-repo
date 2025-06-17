package main

import (
	"fmt"
	"time"
)

func enviarDurante(c chan string, nombre string, duracion time.Duration, intervalo time.Duration) {
	fin := time.After(duracion)
	for {
		select {
		case <-fin:
			close(c)
			return
		default:
			c <- fmt.Sprintf("Dato desde %s", nombre)
			time.Sleep(intervalo)
		}
	}
}

func main() {
	canal5s := make(chan string)
	canal10s := make(chan string)

	go enviarDurante(canal5s, "canal5s", 5*time.Second, 1*time.Second)
	go enviarDurante(canal10s, "canal10s", 10*time.Second, 1*time.Second)

	// Estados de cierre
	cerrado5s := false
	cerrado10s := false

	// Recibir datos hasta que ambos canales estén cerrados
	for !(cerrado5s && cerrado10s) {
		select {
		case val, ok := <-canal5s:
			if ok {
				fmt.Println("Recibido de canal5s:", val)
			} else {
				cerrado5s = true
			}
		case val, ok := <-canal10s:
			if ok {
				fmt.Println("Recibido de canal10s:", val)
			} else {
				cerrado10s = true
			}
		}
	}

	fmt.Println("\nFin del programa.")
}
