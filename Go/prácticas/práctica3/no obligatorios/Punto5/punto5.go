package main

import (
	"fmt"       // Para imprimir en consola
	"math/rand" // Para generar números aleatorios
	"sync"      // Para usar WaitGroup y sincronizar goroutines
	"time"      // Para usar tiempos y dormir las goroutines
)

const (
	numProducers = 2 // Número de productores
	numConsumers = 2 // Número de consumidores
	numPerThread = 3 // Cantidad de elementos que produce o consume cada goroutine
)

// Función del productor
func productor(id int, ch chan int, wg *sync.WaitGroup) {
	defer wg.Done() // Al terminar, se notifica al WaitGroup que esta goroutine terminó

	for i := 0; i < numPerThread; i++ {
		// Espera aleatoria entre 0 y 1 segundo
		time.Sleep(time.Duration(rand.Intn(1000)) * time.Millisecond)

		// Genera un número aleatorio entre 0 y 100
		num := rand.Intn(101)

		// Muestra qué productor produjo qué número
		fmt.Printf("Productor %d produjo: %d\n", id, num)

		// Envía el número al canal para que lo consuma algún consumidor
		ch <- num
	}
}

// Función del consumidor
func consumidor(id int, ch chan int, wg *sync.WaitGroup) {
	defer wg.Done() // Al terminar, se notifica al WaitGroup que esta goroutine terminó

	for i := 0; i < numPerThread; i++ {
		// Recibe un número del canal (espera si no hay datos)
		num := <-ch

		// Imprime qué consumidor consumió qué número
		fmt.Printf("Consumidor %d consumió: %d\n", id, num)
	}
}

func main() {
	// Inicializa la semilla de aleatoriedad usando el tiempo actual
	rand.Seed(time.Now().UnixNano())

	// Crea un canal con buffer de tamaño suficiente para todos los números
	ch := make(chan int, numProducers*numPerThread)

	// Crea un WaitGroup para sincronizar la ejecución de todas las goroutines
	var wg sync.WaitGroup

	// Lanza los productores como goroutines
	for i := 1; i <= numProducers; i++ {
		wg.Add(1) // Incrementa el contador del WaitGroup
		go productor(i, ch, &wg)
	}

	// Lanza los consumidores como goroutines
	for i := 1; i <= numConsumers; i++ {
		wg.Add(1) // Incrementa el contador del WaitGroup
		go consumidor(i, ch, &wg)
	}

	// Espera a que todas las goroutines terminen
	wg.Wait()

	// Mensaje final
	fmt.Println("Todos los productores y consumidores han terminado.")
}

/*
¿Cómo podrías saber qué productor produjo cada número?
Si quieres saber qué productor produjo un número, debes enviar al canal no solo el número sino también el identificador del productor.

Por ejemplo, puedes definir un tipo que incluya ambos datos:

type Producto struct {
    productorID int
    valor       int
}

Y modificar el canal a chan Producto, luego los productores envían algo como:

ch <- Producto{id, num}
Y los consumidores reciben:

producto := <-ch
fmt.Printf("Consumidor %d consumió: %d producido por Productor %d\n", consumidorID, producto.valor, producto.productorID)

*/
