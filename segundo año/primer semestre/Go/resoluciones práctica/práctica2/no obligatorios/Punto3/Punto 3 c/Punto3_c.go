package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

// Declaración del tipo CardinalPoint
type CardinalPoint string

// Punto cardianales en un map con su opuesto
var opuestos = map[CardinalPoint]CardinalPoint{
	"N":  "S",
	"S":  "N",
	"E":  "O",
	"O":  "E",
	"NO": "SE",
	"SE": "NO",
	"NE": "SO",
	"SO": "NE",
}

// Función que devuelve la dirección opuesta al cardinal point
func OppositeDirection(direccion CardinalPoint) (CardinalPoint, error) {
	pc := strings.ToUpper(string(direccion))
	if opuesto, exists := opuestos[CardinalPoint(pc)]; exists {
		return opuesto, nil
	}
	return "", fmt.Errorf("Punto cardinal inválido: %s", direccion)
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	fmt.Print("Ingrese el punto cardinal de donde viene el viento (N, S, E, O, NO, SE, NE, SO): ")
	puntoCardinal, _ := reader.ReadString('\n')
	puntoCardinal = strings.TrimSpace(puntoCardinal)

	opposite, err := OppositeDirection(CardinalPoint(puntoCardinal))
	if err != nil {
		fmt.Println("Error:", err)
		return
	}
	fmt.Printf("El viento se dirige hacia el: %s\n", opposite)
}
