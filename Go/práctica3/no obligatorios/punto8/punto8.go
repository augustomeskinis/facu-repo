package main

//Importaciones
import (
	"fmt"
	"sync"
)

// Estructuras
type Contacto struct {
	Nombre            string
	Apelldio          string
	CorreoElectronico string
	Telefono          int
}
type Agenda map[string]Contacto

// Funciones
func agregarContacto(contacto Contacto, agenda Agenda, wg *sync.WaitGroup, mu *sync.Mutex) {
	defer wg.Done()
	mu.Lock()
	val, ok := agenda[contacto.CorreoElectronico]
	if ok == false {
		agenda[contacto.CorreoElectronico] = contacto
	}
	mu.Unlock()
}
func eliminarContacto(correo string, agenda Agenda, wg *sync.WaitGroup, mu *sync.Mutex) {
	defer wg.Done()
	mu.Lock()
	val, ok := agenda[correo]
	if ok {
		delete(agenda, val.CorreoElectronico)
	}
	mu.Unlock()
}
func buscarContacto(correo string, agenda Agenda, wg *sync.WaitGroup, mu *sync.Mutex, canal chan Contacto) {
	defer wg.Done()
	mu.Lock()
	val, ok := agenda[correo]
	if ok {
		canal <- val
	}
	mu.Unlock()
}

// Programa principal
func main() {
	agenda := make(Agenda)
	var wg sync.WaitGroup
	var mu sync.Mutex
	canal := make(chan Contacto)

	contacto1 := Contacto{"Mateo", "Cordo", "mate2@gmail.com", 1234}
	contacto2 := Contacto{"Augusto", "Meskinis", "augus@gmail.com", 3456}
	contacto3 := Contacto{"Joaquin", "Ardaist", "joa@gmail.com", 7891}

	wg.Add(6)
	go agregarContacto(contacto1, agenda, &wg, &mu)
	go agregarContacto(contacto2, agenda, &wg, &mu)
	go agregarContacto(contacto3, agenda, &wg, &mu)
	go buscarContacto("augus@gmail.com", agenda, &wg, &mu, canal)
	contacto := <-canal
	fmt.Println(contacto)
	go eliminarContacto("joa@gmail.com", agenda, &wg, &mu)
	go eliminarContacto("mate2@gmail.com", agenda, &wg, &mu)

	wg.Wait()
	fmt.Println(agenda)
}
