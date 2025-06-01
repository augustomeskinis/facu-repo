package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

// Declaración del tipo CardinalPoint
type CardinalPoint string

// Constantes pata los cardinal points
const (
	N  CardinalPoint = "N"
	S  CardinalPoint = "S"
	E  CardinalPoint = "E"
	O  CardinalPoint = "O"
	NO CardinalPoint = "NO"
	SE CardinalPoint = "SE"
	NE CardinalPoint = "NE"
	SO CardinalPoint = "SO"
)

// Función que devuelve la dirección opuesta al cardinal point
func OppositeDirection(direccion CardinalPoint) (CardinalPoint, error) {
	switch strings.ToUpper(string(direccion)) {
	case "N":
		return S, nil
	case "S":
		return N, nil
	case "E":
		return O, nil
	case "O":
		return E, nil
	case "NO":
		return SE, nil
	case "SE":
		return NO, nil
	case "NE":
		return SO, nil
	case "SO":
		return NE, nil
	default:
		return "", fmt.Errorf("Punto cardinal inválido: %s", direccion)
	}
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
