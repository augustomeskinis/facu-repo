package main

import (
	"fmt"
	"strings"
)

// Fecha representa una fecha de nacimiento con día, mes y año.
type Fecha struct {
	Dia int
	Mes int
	Ano int
}

// Ingresante representa la información de un ingresante a una carrera.
type Ingresante struct {
	Apellido        string
	Nombre          string
	CiudadOrigen    string
	FechaNacimiento Fecha
	PresentoTitulo  bool
	CodigoCarrera   string
}

type Nodo struct {
	dato      Ingresante
	siguiente *Nodo
}

type Lista struct {
	cabeza   *Nodo
	longitud int
}

func imprimirNombreyApellido(ingresante Ingresante) {
	fmt.Println("Nombre: ", ingresante.Nombre)
	fmt.Println("Apellido: ", ingresante.Apellido)
}

func recorrerLista(l *Lista, añosIngresantes map[int]int, carrerasInscriptos map[string]int) {
	if (l == nil) || (l.cabeza == nil) {
		return
	}
	actual := l.cabeza
	var anterior *Nodo
	for actual != nil {
		//Inciso d
		presento := actual.dato.PresentoTitulo
		if presento {
			//Inciso a
			if actual.dato.CiudadOrigen == "Bariloche" {
				imprimirNombreyApellido(actual.dato)
			}
			//Iniciso b
			if valor, existe := añosIngresantes[actual.dato.FechaNacimiento.Ano]; existe {
				valor++
			} else {
				añosIngresantes[actual.dato.FechaNacimiento.Ano] = 1
			}
			//Inciso c
			carrera := strings.ToUpper(actual.dato.CodigoCarrera)
			carrerasInscriptos[carrera]++
			//Avanza
			anterior = actual
			actual = actual.siguiente
		} else {
			l.longitud--
			if anterior == nil {
				l.cabeza = actual.siguiente
			} else {
				anterior.siguiente = actual.siguiente
			}
			actual = actual.siguiente
		}
	}
}

func informar(l *Lista, añosIngresantes map[int]int, carrerasInscriptos map[string]int) {
	//Informar año en que más ingresante nacieron
	max := -1
	var anoMax int
	for ano, valor := range añosIngresantes {
		if valor > max {
			max = valor
			anoMax = ano
		}
	}
	fmt.Println("El año con mayor cantidad de ingresantes fue: ", anoMax)
	//Informar carrera con mayor cantidad de inscriptos
	max = -1
	var carreraMax string
	for carrera, valor := range carrerasInscriptos {
		if valor > max {
			max = valor
			carreraMax = carrera
		}
	}
	fmt.Println("La carrera con mayor cantidad de inscriptos es: ", carreraMax)
}

func main() {
	var lista *Lista
	añosIngresantes := make(map[int]int)
	carrerasInscriptos := map[string]int{
		"APU": 0,
		"LI":  0,
		"LS":  0,
	}
	recorrerLista(lista, añosIngresantes, carrerasInscriptos)
	informar(lista, añosIngresantes, carrerasInscriptos)
}
