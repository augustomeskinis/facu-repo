package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

// Declaración del tipo CardinalPoint
type CardinalPoint string

// Arreglo pata los cardinal points, par saber la posición en la que está
var CardinalPoints = []CardinalPoint{
	"N",  // índice 0 (par, opuesto es índice 1)
	"S",  // índice 1 (impar, opuesto es índice 0)
	"E",  // índice 2 (par, opuesto es índice 3)
	"O",  // índice 3 (impar, opuesto es índice 2)
	"NO", // índice 4 (par, opuesto es índice 5)
	"SE", // índice 5 (impar, opuesto es índice 4)
	"NE", // índice 6 (par, opuesto es índice 7)
	"SO", // índice 7 (impar, opuesto es índice 6)
}

// Función que devuelve la dirección opuesta al cardinal point
func opuestoDirection(direccion CardinalPoint) (CardinalPoint, error) {
	input := strings.ToUpper(string(direccion))
	// Obtener el índice del punto cardinal
	for i, point := range CardinalPoints {
		if point == CardinalPoint(input) {
			// Índice par: opuesto es el siguiente índice (i+1)
			if i%2 == 0 {
				return CardinalPoints[i+1], nil
			}
			// Índice impar: opuesto es el índice anterior (i-1)
			return CardinalPoints[i-1], nil
		}
	}
	return "", fmt.Errorf("Punto cardinal inválido: %s", direccion)
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	fmt.Print("Ingrese el punto cardinal de donde viene el viento (N, S, E, O, NO, SE, NE, SO): ")
	puntoCardinal, _ := reader.ReadString('\n')
	puntoCardinal = strings.TrimSpace(puntoCardinal)

	opuesto, err := opuestoDirection(CardinalPoint(puntoCardinal))
	if err != nil {
		fmt.Println("Error:", err)
		return
	}
	fmt.Printf("El viento se dirige hacia el: %s\n", opuesto)
}
