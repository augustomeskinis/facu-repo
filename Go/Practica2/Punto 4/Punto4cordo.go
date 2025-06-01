package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func sumatoriaX(x [5]int) float64 {
	var sum float64 = 0
	for i := 0; i < len(x); i++ {
		valor := x[i]
		if valor != 0 {
			sum += 1 / (float64(valor))
		} else {
			sum += 0
		}
	}
	return sum
}

func productoriaZ(z [5]int) float64 {
	var prod int = 1
	for i := 0; i < len(z); i++ {
		prod *= z[i] * z[i] * z[i]
	}
	return float64(prod)
}

func maxmin(y [5]int) (maxInt float64, minInt float64) {
	var max int = 0
	var min int = 9999
	for i := 0; i < len(y); i++ {
		if y[i] > max {
			max = y[i]
		}
		if y[i] < min {
			min = y[i]
		}
	}
	maxInt = float64(max)
	minInt = float64(min)
	return maxInt, minInt
}

func calcular(x [5]int, y [5]int, z [5]int) float64 {
	sumX := sumatoriaX(x)
	productoZ := productoriaZ(z)
	max, min := maxmin(y)
	return ((sumX - productoZ) * max * min)
}

func main() {
	//Vectores
	var x [5]int
	var y [5]int
	var z [5]int

	reader := bufio.NewReader(os.Stdin)
	//Cargar arreglos
	var pos int = 0
	for i := 0; i < 5; i++ {
		//Arreglo x
		fmt.Println("Ingrese valor para el arreglo x: ")
		num1, _ := reader.ReadString('\n')
		num1 = strings.TrimSpace(num1)
		num1int, err := strconv.Atoi(num1)
		if err != nil {
			fmt.Println("Error al leer la entrada:", err)
			return
		}
		x[pos] = int(num1int)
		//Arreglo y
		fmt.Println("Ingrese valor para el arreglo y: ")
		num2, _ := reader.ReadString('\n')
		num2 = strings.TrimSpace(num2)
		num2int, err := strconv.Atoi(num2)
		if err != nil {
			fmt.Println("Error al leer la entrada:", err)
			return
		}
		y[pos] = num2int
		//Arreglo z
		fmt.Println("Ingrese valor para el arreglo z: ")
		num3, _ := reader.ReadString('\n')
		num3 = strings.TrimSpace(num3)
		num3int, err := strconv.Atoi(num3)
		if err != nil {
			fmt.Println("Error al leer la entrada:", err)
			return
		}
		z[pos] = num3int
		pos++
	}

	resultado := calcular(x, y, z)
	fmt.Println("El resultado es: ", resultado)
}
