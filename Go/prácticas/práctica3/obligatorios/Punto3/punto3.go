package main

//Importaciones
import (
	"fmt"
	"math/rand"
	"os"
	"strconv"
	"sync"
	"time"
)

// Declaración tarea
type Tarea struct {
	num       int
	prioridad int
}

// Guarda en archivo
func guardarEnArchivo(nombre string, prioridad int, resultado int) {
	/*Abre y:
	Agrega contenido al final sin borrar lo anterior. os.O_APPEND
	Crea el archivo si no existe. os.O_CREATE
	Modo solo escritura. os.O_WRONLY
	Permisos del archivo. 0644
	*/
	archivo, err := os.OpenFile(nombre, os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0644)
	if err != nil {
		fmt.Println("Error al abrir el archivo:", err)
		return
	}
	defer archivo.Close()
	// Escribir en formato (prioridad, resultado)
	fmt.Fprintf(archivo, "(%d, %d)\n", prioridad, resultado)
}

// Procesamiento por prioridad
func procesar(tarea Tarea, mu *sync.Mutex, acumulador *int) {
	switch tarea.prioridad {
	case 0:
		suma := 0
		for _, digito := range strconv.Itoa(tarea.num) {
			d, _ := strconv.Atoi(string(digito))
			suma += d
		}
		guardarEnArchivo("prioridad0.txt", 0, suma)
	case 1:
		numStr := strconv.Itoa(tarea.num)
		invertido := ""
		for i := len(numStr) - 1; i >= 0; i-- {
			invertido += string(numStr[i])
		}
		resultado, _ := strconv.Atoi(invertido)
		guardarEnArchivo("prioridad1.txt", 1, resultado)
	case 2:
		resultado := tarea.num * 10
		fmt.Println("Resultado x10:", resultado)
	case 3:
		mu.Lock()
		*acumulador += tarea.num
		fmt.Println("Acumulado:", *acumulador)
		mu.Unlock()
	}
}

// Worker
func worker(id int, tareas <-chan Tarea, wg *sync.WaitGroup, mu *sync.Mutex, acumulador *int) {
	defer wg.Done()
	for tarea := range tareas {
		procesar(tarea, mu, acumulador)
	}
}

// Programa principal
func main() {
	rand.Seed(time.Now().UnixNano())
	// Slices y estructuras
	var tareasP0 []Tarea
	var tareasRestantes []Tarea
	//Generación de tareas
	for i := 0; i < 20; i++ {
		num := rand.Intn(1001)
		prioridad := rand.Intn(4)
		tarea := Tarea{num, prioridad}
		if prioridad == 0 {
			tareasP0 = append(tareasP0, tarea)
		} else {
			tareasRestantes = append(tareasRestantes, tarea)
		}
	}
	// Primero procesar prioridad 0 secuencialmente (una por una o con workers dedicados)
	for _, tarea := range tareasP0 {
		procesar(tarea, &sync.Mutex{}, new(int))
	}
	// Ahora procesar prioridades 1, 2 y 3 con 4 workers
	tareas := make(chan Tarea)
	var wg sync.WaitGroup
	var mu sync.Mutex
	acumulador := 0
	// Lanzamos 4 workers
	for i := 0; i < 4; i++ {
		wg.Add(1)
		go worker(i, tareas, &wg, &mu, &acumulador)
	}
	// Enviar tareas
	go func() {
		for _, tarea := range tareasRestantes {
			tareas <- tarea
		}
		close(tareas)
	}()
	// Esperar que terminen los workers
	wg.Wait()
}
