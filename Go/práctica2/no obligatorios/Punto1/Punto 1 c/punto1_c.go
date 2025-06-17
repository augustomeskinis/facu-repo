package main

import (
	"fmt"
)

// Declaramos los tipos
type Celsius float64
type Fahrenheit float64

// Declaramos las funciones
func CTtoF(c Celsius) Fahrenheit {
	return Fahrenheit(c*9/5 + 32)
}

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
	var max Fahrenheit = 0
	var min Fahrenheit = 50

	//Arreglo vació de temperaturas Fahrenheit
	var temperaturasFahrenheit [10]Fahrenheit

	//Hacerle el casting a las temperaturas
	for i = 0; i < len(temperaturas); i++ {
		temp := temperaturas[i]
		var tempC = Celsius(temp)
		tempF := CTtoF((tempC))
		temperaturasFahrenheit[i] = tempF
	}

	//Recorrer arreglo
	for i = 0; i < len(temperaturasFahrenheit); i++ {
		temp := temperaturasFahrenheit[i]
		switch {
		case temp > ((37.5 * (9 / 5)) + 32):
			categorias["alta"]++
		case (temp >= ((36*(9/5))+32) && temp <= ((37.5*(9/5))+32)):
			categorias["normal"]++
		case temp < ((36 * (9 / 5)) + 32):
			categorias["baja"]++
		case (temp > ((50*(9/5))+32) || temp < ((20*(9/5))+32)):
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
	porcentaje1 := (Fahrenheit(categorias["alta"]) / 10) * 100
	porcentaje2 := (Fahrenheit(categorias["normal"]) / 10) * 100
	porcentaje3 := (Fahrenheit(categorias["baja"]) / 10) * 100
	porcentajeIncorrectos := (Fahrenheit(categorias["incorrectos"]) / 10) * 100
	fmt.Println("Porcentaje de la categoría 1 es:", porcentaje1, "%")
	fmt.Println("Porcentaje de la categoría 2 es:", porcentaje2, "%")
	fmt.Println("Porcentaje de la categoría 3 es:", porcentaje3, "%")
	fmt.Println("Porcentaje de la categoría de incorrectos es:", porcentajeIncorrectos, "%")

	promedioEntero := int((max + min) / 2)
	fmt.Println("Promedio entero entre la temperatura máxima y la mínima es: ", promedioEntero)
}
