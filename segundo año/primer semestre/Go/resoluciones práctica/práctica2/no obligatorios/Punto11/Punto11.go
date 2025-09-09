package main

import (
	"fmt"
	"sort"
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

// String implementa la interfaz Stringer para Ingresante.
func (i Ingresante) String() string {
	titulo := "No presentó"
	if i.PresentoTitulo {
		titulo = "Presentó"
	}
	return fmt.Sprintf("Ingresante: %s, %s\nCiudad de origen: %s\nFecha de nacimiento: %02d/%02d/%d\nTítulo secundario: %s\nCarrera: %s",
		i.Apellido, i.Nombre, i.CiudadOrigen, i.FechaNacimiento.Dia, i.FechaNacimiento.Mes, i.FechaNacimiento.Ano, titulo, i.CodigoCarrera)
}

// CompararPorEdad compara dos ingresantes por su fecha de nacimiento.
// Devuelve:
//   1 si i1 es mayor (nació antes),
//  -1 si i2 es mayor,
//   0 si tienen la misma fecha de nacimiento.
func CompararPorEdad(i1, i2 Ingresante) int {
	f1 := i1.FechaNacimiento
	f2 := i2.FechaNacimiento

	if f1.Ano < f2.Ano {
		return 1
	}
	if f1.Ano > f2.Ano {
		return -1
	}
	if f1.Mes < f2.Mes {
		return 1
	}
	if f1.Mes > f2.Mes {
		return -1
	}
	if f1.Dia < f2.Dia {
		return 1
	}
	if f1.Dia > f2.Dia {
		return -1
	}
	return 0
}

// CompararPorAlfabetico compara dos ingresantes por apellido y nombre lexicográficamente.
// Devuelve:
//   1 si i1 va después,
//  -1 si i1 va antes,
//   0 si son iguales.
func CompararPorAlfabetico(i1, i2 Ingresante) int {
	// Comparar apellidos (en mayúsculas para ignorar diferencias de caso)
	apellido1 := strings.ToUpper(i1.Apellido)
	apellido2 := strings.ToUpper(i2.Apellido)
	if apellido1 < apellido2 {
		return -1
	}
	if apellido1 > apellido2 {
		return 1
	}
	// Si los apellidos son iguales, comparar nombres
	nombre1 := strings.ToUpper(i1.Nombre)
	nombre2 := strings.ToUpper(i2.Nombre)
	if nombre1 < nombre2 {
		return -1
	}
	if nombre1 > nombre2 {
		return 1
	}
	return 0
}

// Ingresantes es un tipo para un slice de Ingresante que implementa sort.Interface.
type Ingresantes []Ingresante

// Len devuelve la longitud del slice.
func (s Ingresantes) Len() int {
	return len(s)
}

// Swap intercambia los elementos en las posiciones i y j.
func (s Ingresantes) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}

// Less define el criterio de ordenamiento: primero por edad (mayor a menor),
// luego por apellido y nombre (alfabéticamente).
func (s Ingresantes) Less(i, j int) bool {
	// Comparar por edad primero
	edadComp := CompararPorEdad(s[i], s[j])
	if edadComp == 1 {
		return true // s[i] nació antes (es mayor), va primero
	}
	if edadComp == -1 {
		return false // s[j] nació antes, va primero
	}
	// Si las edades son iguales, comparar por orden alfabético
	alfComp := CompararPorAlfabetico(s[i], s[j])
	return alfComp == -1 // s[i] va antes alfabéticamente
}

func main() {
	// Ejemplo de uso
	ingresante1 := Ingresante{
		Apellido:        "Pérez",
		Nombre:          "Juan",
		CiudadOrigen:    "Buenos Aires",
		FechaNacimiento: Fecha{Dia: 15, Mes: 6, Ano: 2000},
		PresentoTitulo:  true,
		CodigoCarrera:   "LI",
	}
	ingresante2 := Ingresante{
		Apellido:        "Gómez",
		Nombre:          "María",
		CiudadOrigen:    "Córdoba",
		FechaNacimiento: Fecha{Dia: 20, Mes: 3, Ano: 1999},
		PresentoTitulo:  false,
		CodigoCarrera:   "APU",
	}
	ingresante3 := Ingresante{
		Apellido:        "Pérez",
		Nombre:          "Ana",
		CiudadOrigen:    "Rosario",
		FechaNacimiento: Fecha{Dia: 15, Mes: 6, Ano: 2000},
		PresentoTitulo:  true,
		CodigoCarrera:   "LS",
	}

	fmt.Println(ingresante1)
	fmt.Println("---------------------------------------------------------------")

	// Comparación por edad
	fmt.Println("Comparación por edad:")
	if CompararPorEdad(ingresante1, ingresante2) == 1 {
		fmt.Printf("%s es mayor que %s\n", ingresante1.Nombre, ingresante2.Nombre)
	} else if CompararPorEdad(ingresante1, ingresante2) == -1 {
		fmt.Printf("%s es menor que %s\n", ingresante1.Nombre, ingresante2.Nombre)
	} else {
		fmt.Printf("%s y %s tienen la misma edad\n", ingresante1.Nombre, ingresante2.Nombre)
	}

	// Comparación por orden alfabético
	fmt.Println("\nComparación por orden alfabético:")
	if CompararPorAlfabetico(ingresante1, ingresante2) == 1 {
		fmt.Printf("%s va después de %s\n", ingresante1.Nombre, ingresante2.Nombre)
	} else if CompararPorAlfabetico(ingresante1, ingresante2) == -1 {
		fmt.Printf("%s va antes de %s\n", ingresante1.Nombre, ingresante2.Nombre)
	} else {
		fmt.Printf("%s y %s son iguales alfabéticamente\n", ingresante1.Nombre, ingresante2.Nombre)
	}

	// Comparación alfabética con mismo apellido
	fmt.Println("\nComparación alfabética (mismo apellido):")
	if CompararPorAlfabetico(ingresante1, ingresante3) == 1 {
		fmt.Printf("%s va después de %s\n", ingresante1.Nombre, ingresante3.Nombre)
	} else if CompararPorAlfabetico(ingresante1, ingresante3) == -1 {
		fmt.Printf("%s va antes de %s\n", ingresante1.Nombre, ingresante3.Nombre)
	} else {
		fmt.Printf("%s y %s son iguales alfabéticamente\n", ingresante1.Nombre, ingresante3.Nombre)
	}

	// Crear un slice de ingresantes
	ingresantes := Ingresantes{
		Ingresante{
			Apellido:        "Pérez",
			Nombre:          "Juan",
			CiudadOrigen:    "Buenos Aires",
			FechaNacimiento: Fecha{Dia: 15, Mes: 6, Ano: 2000},
			PresentoTitulo:  true,
			CodigoCarrera:   "LI",
		},
		Ingresante{
			Apellido:        "Gómez",
			Nombre:          "María",
			CiudadOrigen:    "Córdoba",
			FechaNacimiento: Fecha{Dia: 20, Mes: 3, Ano: 1999},
			PresentoTitulo:  false,
			CodigoCarrera:   "APU",
		},
		Ingresante{
			Apellido:        "Pérez",
			Nombre:          "Ana",
			CiudadOrigen:    "Rosario",
			FechaNacimiento: Fecha{Dia: 15, Mes: 6, Ano: 2000},
			PresentoTitulo:  true,
			CodigoCarrera:   "LS",
		},
		Ingresante{
			Apellido:        "López",
			Nombre:          "Carlos",
			CiudadOrigen:    "Mendoza",
			FechaNacimiento: Fecha{Dia: 10, Mes: 8, Ano: 2001},
			PresentoTitulo:  true,
			CodigoCarrera:   "LI",
		},
	}

	// Imprimir ingresantes antes de ordenar
	fmt.Println("Antes de ordenar:")
	for _, ing := range ingresantes {
		fmt.Println(ing)
		fmt.Println("---")
	}

	// Ordenar el slice usando el paquete sort
	sort.Sort(ingresantes)

	// Imprimir ingresantes después de ordenar
	fmt.Println("\nDespués de ordenar (por edad, luego alfabéticamente):")
	for _, ing := range ingresantes {
		fmt.Println(ing)
		fmt.Println("---")
	}
}
