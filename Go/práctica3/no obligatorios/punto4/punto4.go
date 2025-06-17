package main

import (
	"fmt"
	"sync"
)

// Función que se ejecutará en una goroutine
// Recibe un puntero al WaitGroup, el canal por el cual enviar el mensaje, y el mensaje a enviar
func pxng(wg *sync.WaitGroup, m chan string, str string) {
	defer wg.Done() // Al terminar la ejecución de esta función, avisa al WaitGroup que terminó
	m <- str        // Envía el mensaje (PING o PONG) al canal
}

func main() {
	// Creamos un WaitGroup que nos permitirá esperar a que terminen todas las goroutines
	var wg sync.WaitGroup

	// Creamos un canal con buffer de tamaño 10 para evitar bloqueos al enviar mensajes
	messages := make(chan string, 10)

	// Lanzamos 5 pares de goroutines: una para "PING" y otra para "PONG"
	for i := 0; i < 5; i++ {
		wg.Add(2)                      // Indicamos que agregamos dos tareas (goroutines)
		go pxng(&wg, messages, "PING") // Lanzamos la goroutine que envía "PING"
		go pxng(&wg, messages, "PONG") // Lanzamos la goroutine que envía "PONG"
	}

	wg.Wait()       // Esperamos a que terminen las 10 goroutines (5 PING y 5 PONG)
	close(messages) // Cerramos el canal para que el for-range termine correctamente (buena práctica)

	// Iteramos sobre el canal y mostramos los mensajes que fueron enviados por las goroutines
	for msg := range messages {
		fmt.Println(msg) // Imprime "PING" o "PONG"
	}
}
