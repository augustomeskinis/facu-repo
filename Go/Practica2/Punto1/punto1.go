package main

import (
	"fmt"
)

func main() {
	//Cargamos el arreglo
	var temperaturas [10]float64

	var i int
	for i = 0; i < len(temperaturas); i++ {
		var temp float64
		fmt.Scan(&temp)
		temperaturas[i] = temp
	}

	//Crear variables para cada grupo acumuladores
	categorias1 := 0
	categorias2 := 0
	categorias3 := 0

	//Variable maxima y mínima
	var max, min float64
	max = 0
	min = 50
	//Recorrer arreglo
	for i = 0; i < len(temperaturas); i++ {
		temp := temperaturas[i]
		switch {
		case temp > 37.5:
			categorias1++
		case (temp >= 36 && temp <= 37.5):
			categorias2++
		case temp < 36:
			categorias3++
		}
		if temp > max {
			max = temp
		}
		if temp < min {
			min = temp
		}
	}

	//Informamos
	porcentaje1 := (float64(categorias1) / 10) * 100
	porcentaje2 := (float64(categorias2) / 10) * 100
	porcentaje3 := (float64(categorias3) / 10) * 100
	fmt.Println("Porcentaje de la categoría 1 es:", porcentaje1, "%")
	fmt.Println("Porcentaje de la categoría 2 es:", porcentaje2, "%")
	fmt.Println("Porcentaje de la categoría 3 es:", porcentaje3, "%")

	promedioEntero := int((max + min) / 2)
	fmt.Println("Promedio entero entre la temperatura máxima y la mínima es: ", promedioEntero)
}
