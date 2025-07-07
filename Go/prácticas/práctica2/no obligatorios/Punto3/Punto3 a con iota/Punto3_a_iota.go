// Package main implementa un programa que lee un punto cardinal desde donde
// viene el viento y muestra hacia dónde se dirige, usando un enumerativo con iota
// y switch/case para determinar la dirección opuesta.
package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

// PuntoCardinal representa un punto cardinal como un tipo enumerativo basado en enteros.
type PuntoCardinal int

// Constantes para los puntos cardinales, definidas con iota para asignación automática.
const (
	N  PuntoCardinal = iota // Norte = 0
	S                       // Sur = 1
	E                       // Este = 2
	O                       // Oeste = 3
	NO                      // Noroeste = 4
	SE                      // Sureste = 5
	NE                      // Noreste = 6
	SO                      // Suroeste = 7
)

// stringToPuntoCardinal convierte una cadena a su valor PuntoCardinal correspondiente.
func stringToPuntoCardinal(input string) (PuntoCardinal, error) {
	switch strings.ToUpper(input) {
	case "N":
		return N, nil
	case "S":
		return S, nil
	case "E":
		return E, nil
	case "O":
		return O, nil
	case "NO":
		return NO, nil
	case "SE":
		return SE, nil
	case "NE":
		return NE, nil
	case "SO":
		return SO, nil
	default:
		return 0, fmt.Errorf("punto cardinal inválido: %s", input)
	}
}

// OppositeDirection devuelve el punto cardinal opuesto al ingresado.
// Usa switch/case para mapear cada punto cardinal a su opuesto.
func OppositeDirection(direction PuntoCardinal) (PuntoCardinal, error) {
	switch direction {
	case N:
		return S, nil
	case S:
		return N, nil
	case E:
		return O, nil
	case O:
		return E, nil
	case NO:
		return SE, nil
	case SE:
		return NO, nil
	case NE:
		return SO, nil
	case SO:
		return NE, nil
	default:
		return 0, fmt.Errorf("punto cardinal inválido: %d", direction)
	}
}

// String implementa la interfaz Stringer para proporcionar una representación legible.
func (p PuntoCardinal) String() string {
	switch p {
	case N:
		return "Norte"
	case S:
		return "Sur"
	case E:
		return "Este"
	case O:
		return "Oeste"
	case NO:
		return "Noroeste"
	case SE:
		return "Sureste"
	case NE:
		return "Noreste"
	case SO:
		return "Suroeste"
	default:
		return "Desconocido"
	}
}

func main() {
	// Configura un lector para la entrada estándar
	reader := bufio.NewReader(os.Stdin)
	fmt.Print("Ingrese el punto cardinal desde donde viene el viento (N, S, E, O, NO, SE, NE, SO): ")
	input, _ := reader.ReadString('\n')
	// Elimina espacios y saltos de línea
	input = strings.TrimSpace(input)

	// Convierte la entrada de cadena a PuntoCardinal
	direction, err := stringToPuntoCardinal(input)
	if err != nil {
		fmt.Println("Error:", err)
		return
	}

	// Calcula la dirección opuesta
	opposite, err := OppositeDirection(direction)
	if err != nil {
		fmt.Println("Error:", err)
		return
	}

	// Muestra el resultado usando la representación de Stringer
	fmt.Printf("El viento va hacia: %s\n", opposite)
}
