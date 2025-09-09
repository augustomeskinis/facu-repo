package main

//Importaciones
import (
	"fmt"
	"sync"
	"time"
)

// Goroutine
func atencionCaja(cola chan string, wg *sync.WaitGroup) {
	defer wg.Done()
	for persona := range cola {
		fmt.Println("Se está atendiendo a ", persona)
		time.Sleep(1 * time.Second)
	}
}

// Main
func main() {
	var wg sync.WaitGroup
	var cola = make(chan string)
	//LLamó a la goroutine
	wg.Add(1)
	inicio := time.Now()
	go atencionCaja(cola, &wg)
	//Cargo la cola
	var persona string
	for i := 0; i < 10; i++ {
		fmt.Println("Nombre de la persona que ingresó a la cola: ")
		fmt.Scan(&persona)
		cola <- persona
	}
	close(cola)
	wg.Wait()
	duracion := time.Since(inicio)
	fmt.Println("Tiempo de ejecución: ", duracion)
}
