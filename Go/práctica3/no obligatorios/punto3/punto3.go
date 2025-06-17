package main

import (
	"fmt"
)

func hello() {
	fmt.Println("Inicia Goroutine de hello")
	for i := 0; i < 3; i++ {
		fmt.Println(i, " Hello world")
	}
	fmt.Println("Termina Goroutine de hello")
}

func main() {
	fmt.Println("Inicia Goroutine del main")
	go hello()
	fmt.Println("Termina Goroutine del main")
}

/*
	Punto a)
		Respuesta: No se garantiza ninguna impresión de "Hello world"
			Porque la goroutine hello() se ejecuta de forma concurrente, pero el programa principal (main) puede terminar antes de que hello() imprima algo.
			Si el main() termina, el programa completo termina, incluyendo todas las goroutines activas.
		En resumen:
			Podría imprimirse 0, 1, 2 o 3 veces "Hello world", dependiendo del sistema y la planificación.
	Punto b)
			Respuesta: 2 Goroutines
				La goroutine principal que ejecuta main().
				La goroutine que se lanza con go hello().
	Punto c)
		Usando timesleep
			func main() {
				fmt.Println("Inicia Goroutine del main")
				go hello()
				time.Sleep(1 * time.Second) // Esperar suficiente tiempo para que termine hello()
				fmt.Println("Termina Goroutine del main")
			}
		Usando channels
			func hello(done chan bool) {
				fmt.Println("Inicia Goroutine de hello")
				for i := 0; i < 3; i++ {
					fmt.Println(i, " Hello world")
				}
				fmt.Println("Termina Goroutine de hello")
				done <- true // Notificar que terminó
			}
			func main() {
				fmt.Println("Inicia Goroutine del main")
				done := make(chan bool)
				go hello(done)
				<-done // Esperar a que hello termine
				fmt.Println("Termina Goroutine del main")
			}
*/
