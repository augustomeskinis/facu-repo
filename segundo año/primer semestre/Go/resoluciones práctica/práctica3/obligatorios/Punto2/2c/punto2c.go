package main

//Importamos
import (
	"fmt"
	"sync"
	"time"
)

// Goroutine
func atencionCaja(id int, cola chan string, wg *sync.WaitGroup) {
	defer wg.Done()
	for persona := range cola {
		fmt.Printf("Caja %d está atendiendo a %s\n", id, persona)
		time.Sleep(1 * time.Second)
		fmt.Printf("Caja %d terminó de atender a %s\n", id, persona)
	}
}

func main() {
	var wg sync.WaitGroup
	numCajas := 3
	numClientes := 10

	// Crear canales (colas) para cada caja
	colas := make([]chan string, numCajas)
	inicio := time.Now()
	for i := 0; i < numCajas; i++ {
		colas[i] = make(chan string, 100) // buffer para permitir medir longitud
		wg.Add(1)
		go atencionCaja(i+1, colas[i], &wg)
	}

	// Asignar clientes a cajas
	for i := 0; i < numClientes; i++ {
		var nombre string
		fmt.Printf("Nombre del cliente %d: ", i+1)
		fmt.Scan(&nombre)

		// Buscar la cola con menos clientes esperando
		minIdx := 0
		minLen := len(colas[0])
		for j := 1; j < numCajas; j++ {
			if len(colas[j]) < minLen {
				minIdx = j
				minLen = len(colas[j])
			}
		}
		// Mandar cliente a la cola con menos clientes
		colas[minIdx] <- nombre
	}

	// Cerrar las colas
	for _, cola := range colas {
		close(cola)
	}

	wg.Wait()
	duracion := time.Since(inicio)
	fmt.Println("Tiempo de ejecución: ", duracion)
}
