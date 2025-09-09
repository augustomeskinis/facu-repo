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

	//Definimos las categorias
	categorias := map[string]int{
		"alta":        0,
		"normal":      0,
		"baja":        0,
		"incorrectos": 0,
	}

	//Variables de máx y min
	var max float64 = 0
	var min float64 = 50

	//Recorrer arreglo
	for i = 0; i < len(temperaturas); i++ {
		temp := temperaturas[i]
		switch {
		case temp > 37.5:
			categorias["alta"]++
		case (temp >= 36 && temp <= 37.5):
			categorias["normal"]++
		case temp < 36:
			categorias["baja"]++
		case (temp > 50 || temp < 20):
			categorias["incorrectos"]++
		}
		if temp > max {
			max = temp
		}
		if temp < min {
			min = temp
		}
	}

	//Informamos
	porcentaje1 := (float64(categorias["alta"]) / 10) * 100
	porcentaje2 := (float64(categorias["normal"]) / 10) * 100
	porcentaje3 := (float64(categorias["baja"]) / 10) * 100
	porcentajeIncorrectos := (float64(categorias["incorrectos"]) / 10) * 100
	fmt.Println("Porcentaje de la categoría 1 es:", porcentaje1, "%")
	fmt.Println("Porcentaje de la categoría 2 es:", porcentaje2, "%")
	fmt.Println("Porcentaje de la categoría 3 es:", porcentaje3, "%")
	fmt.Println("Porcentaje de la categoría de incorrectos es:", porcentajeIncorrectos, "%")

	promedioEntero := int((max + min) / 2)
	fmt.Println("Promedio entero entre la temperatura máxima y la mínima es: ", promedioEntero)
}
