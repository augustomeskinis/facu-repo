package main

import (
	"fmt"
)

// Declaro el struct donde guardo el elemento y las ocurrencias concecutivas
type elemOcurre struct {
	elemento    int
	ocurrencias int
}

// Declaro el slice donde cada posición es un struct con el elemento y sus ocurrencias concecutivas
type OptimumSlice []elemOcurre

// Slice de los números
type slice []int

// Función que me crea el OptimunSlice
func New(s []int) OptimumSlice {
	var os OptimumSlice
	if len(s) == 0 {
		return os
	}

	actual := s[0]
	count := 1

	for i := 1; i < len(s); i++ {
		if s[i] == actual {
			count++
		} else {
			os = append(os, elemOcurre{elemento: actual, ocurrencias: count})
			actual = s[i]
			count = 1
		}
	}
	// Agrega el último grupo
	os = append(os, elemOcurre{elemento: actual, ocurrencias: count})
	return os
}

// Función que devuelve si el slice está vacío
func isEmpty(o OptimumSlice) bool {
	return len(o) == 0
}

// Función que devuelve la cantidad de elementos en el slice
func Len(o OptimumSlice) int {
	total := 0
	for _, e := range o {
		total += e.ocurrencias
	}
	return total
}

// Función que devuelve el primer elemento
func frontElement(o OptimumSlice) int {
	if len(o) == 0 {
		panic("Slice vacío")
	}
	return o[0].elemento
}

// Función que devuelve el último elemento
func lastElement(o OptimumSlice) int {
	if len(o) == 0 {
		panic("Slice vacío")
	}
	return o[len(o)-1].elemento
}

// Función que inserta un elemento en una posición determinada en el slice descomprimido
func Insert(o OptimumSlice, element int, posicion int) OptimumSlice {
	if posicion < 0 || posicion > Len(o) {
		panic("Posición fuera de rango")
	}

	var nuevoSlice OptimumSlice
	pos := 0 // posición descomprimida acumulada

	for _, bloque := range o {
		// Si el nuevo elemento va antes de este bloque
		if pos+bloque.ocurrencias < posicion {
			nuevoSlice = append(nuevoSlice, bloque)
			pos += bloque.ocurrencias
			continue
		}

		// Si el nuevo elemento va dentro de este bloque
		if pos <= posicion && posicion < pos+bloque.ocurrencias {
			offset := posicion - pos
			// Parte 1 del bloque (antes del insert)
			if offset > 0 {
				nuevoSlice = append(nuevoSlice, elemOcurre{elemento: bloque.elemento, ocurrencias: offset})
			}
			// Elemento a insertar
			nuevoSlice = append(nuevoSlice, elemOcurre{elemento: element, ocurrencias: 1})
			// Parte 2 del bloque (después del insert)
			if offset < bloque.ocurrencias {
				nuevoSlice = append(nuevoSlice, elemOcurre{elemento: bloque.elemento, ocurrencias: bloque.ocurrencias - offset})
			}
			pos += bloque.ocurrencias // para salir del ciclo
			continue
		}

		// Si ya insertamos, agregamos el resto sin cambios
		nuevoSlice = append(nuevoSlice, bloque)
	}

	// Caso especial: insertar al final
	if posicion == Len(o) {
		nuevoSlice = append(nuevoSlice, elemOcurre{elemento: element, ocurrencias: 1})
	}

	return nuevoSlice
}

// Función que devuelve el slice descomprimido
func SliceArray(o OptimumSlice) []int {
	var s []int
	for _, e := range o {
		for i := 0; i < e.ocurrencias; i++ {
			s = append(s, e.elemento)
		}
	}
	return s
}

func main() {
	s := []int{3, 3, 3, 2, 2, 1}
	os := New(s)
	estaVacio := isEmpty(os)
	fmt.Println("True si está vacío y False si no: ", estaVacio)
	len := Len(os)
	fmt.Println("Cantidad total de elementos: ", len)
	frontElement := frontElement(os)
	fmt.Println("Primer elemento: ", frontElement)
	lastElement := lastElement(os)
	fmt.Println("Último elemento: ", lastElement)
	fmt.Println("Se inserta el 9 en la posición 6", Insert(os, 10, 6))
	fmt.Println("Representación del slice descomprimido: ", SliceArray(os))
}
