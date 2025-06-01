package main

import (
	"fmt"
)

// PuntoCardinal define los puntos cardinales como un tipo enumerativo
type PuntoCardinal string

// Constantes para los puntos cardinales
const (
	N  PuntoCardinal = "N"  // Norte
	S  PuntoCardinal = "S"  // Sur
	E  PuntoCardinal = "E"  // Este
	O  PuntoCardinal = "O"  // Oeste
	NO PuntoCardinal = "NO" // Noroeste
	SE PuntoCardinal = "SE" // Sureste
	NE PuntoCardinal = "NE" // Noreste
	SO PuntoCardinal = "SO" // Suroeste
)

// String implementa la interfaz Stringer para PuntoCardinal
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
	// Ejemplos de uso con fmt.Println
	direcciones := []PuntoCardinal{N, S, E, O, NO, SE, NE, SO, "X"} // Incluye un valor inválido
	for _, dir := range direcciones {
		fmt.Printf("El punto cardinal %v es: %s\n", string(dir), dir)
	}
}
