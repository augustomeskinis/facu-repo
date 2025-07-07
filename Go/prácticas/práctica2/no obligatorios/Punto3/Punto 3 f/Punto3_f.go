package main

/*
Vamos a analizar qué sucede con las funciones definidas en las partes anteriores (a, b, c) cuando reciben un valor fuera de rango, es decir, un valor que no corresponde a los puntos cardinales definidos (N, S, E, O, NO, SE, NE, SO). Cada función maneja los valores inválidos de manera diferente según su implementación. A continuación, detallo el comportamiento para cada caso, refiriéndome a las soluciones en Go proporcionadas previamente, y explico en español cómo se gestionan los errores.

Contexto
Las funciones analizadas son:
Parte a: Usa un switch/case para determinar la dirección opuesta.
Parte b: Usa un slice con el orden de definición y lógica de índices par/impar.
Parte c: Usa un mapa (map) para asociar cada punto cardinal con su opuesto.
Todas las funciones (OppositeDirection) devuelven un PuntoCardinal (el punto opuesto) y un error para indicar si ocurrió un problema.
Un valor "fuera de rango" sería cualquier entrada que no sea uno de los puntos cardinales válidos, como "X", "norte", una cadena vacía (""), o cualquier otro valor no definido.
1. Parte a: Implementación con switch/case
Código relevante:

go

Copiar
func OppositeDirection(direction PuntoCardinal) (PuntoCardinal, error) {
	switch strings.ToUpper(string(direction)) {
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
		return "", fmt.Errorf("invalid cardinal point: %s", direction)
	}
}
Comportamiento con valores fuera de rango:

La función convierte la entrada a mayúsculas usando strings.ToUpper para hacerla insensible a mayúsculas/minúsculas (e.g., "n" se trata como "N").
Si la entrada no coincide con ninguno de los casos del switch ("N", "S", "E", "O", "NO", "SE", "NE", "SO"), se ejecuta la cláusula default.
En el caso default:
Devuelve un valor vacío ("") como PuntoCardinal.
Devuelve un error con el mensaje: fmt.Errorf("invalid cardinal point: %s", direction), que incluye la entrada inválida.
Ejemplo:
Entrada: "X"
Salida: "", error: invalid cardinal point: X
Entrada: "" (cadena vacía)
Salida: "", error: invalid cardinal point:
Entrada: "norte"
Salida: "", error: invalid cardinal point: norte
Impacto en el programa principal:

En el main, el error se captura y se imprime:
go

Copiar
opposite, err := OppositeDirection(CardinalPoint(input))
if err != nil {
    fmt.Println("Error:", err)
    return
}
El programa muestra el mensaje de error y termina sin intentar usar el valor inválido.
2. Parte b: Implementación con orden de definición (índices par/impar)
Código relevante:

go

Copiar
var CardinalPoints = []CardinalPoint{
	"N", "S", "E", "O", "NO", "SE", "NE", "SO",
}

func OppositeDirection(direction CardinalPoint) (CardinalPoint, error) {
	input := strings.ToUpper(string(direction))
	for i, point := range CardinalPoints {
		if point == CardinalPoint(input) {
			if i%2 == 0 {
				return CardinalPoints[i+1], nil
			}
			return CardinalPoints[i-1], nil
		}
	}
	return "", fmt.Errorf("invalid cardinal point: %s", direction)
}
Comportamiento con valores fuera de rango:

La función convierte la entrada a mayúsculas para normalizarla.
Itera sobre el slice CardinalPoints buscando una coincidencia con la entrada.
Si no se encuentra ninguna coincidencia (es decir, la entrada no está en el slice), el bucle termina sin ejecutar el bloque if y la función llega a la instrucción final:
Devuelve un valor vacío ("") como PuntoCardinal.
Devuelve un error: fmt.Errorf("invalid cardinal point: %s", direction).
Ejemplo:
Entrada: "X"
Salida: "", error: invalid cardinal point: X
Entrada: ""
Salida: "", error: invalid cardinal point:
Entrada: "Norte"
Salida: "", error: invalid cardinal point: Norte
Impacto en el programa principal:

Igual que en la parte a, el main maneja el error imprimiéndolo y terminando el programa:
go

Copiar
opposite, err := OppositeDirection(CardinalPoint(input))
if err != nil {
    fmt.Println("Error:", err)
    return
}
El error se muestra claramente, y el programa no intenta procesar el valor inválido.
3. Parte c: Implementación con un mapa
Código relevante:

go

Copiar
var opposites = map[CardinalPoint]CardinalPoint{
	"N":  "S",
	"S":  "N",
	"E":  "O",
	"O":  "E",
	"NO": "SE",
	"SE": "NO",
	"NE": "SO",
	"SO": "NE",
}

func OppositeDirection(direction CardinalPoint) (CardinalPoint, error) {
	input := strings.ToUpper(string(direction))
	if opposite, exists := opposites[CardinalPoint(input)]; exists {
		return opposite, nil
	}
	return "", fmt.Errorf("invalid cardinal point: %s", direction)
}
Comportamiento con valores fuera de rango:

La función convierte la entrada a mayúsculas para normalizarla.
Intenta buscar la entrada en el mapa opposites usando la sintaxis opposite, exists := opposites[CardinalPoint(input)].
Si la clave no existe en el mapa (es decir, exists es false), la entrada es inválida, y la función:
Devuelve un valor vacío ("") como PuntoCardinal.
Devuelve un error: fmt.Errorf("invalid cardinal point: %s", direction).
Ejemplo:
Entrada: "X"
Salida: "", error: invalid cardinal point: X
Entrada: ""
Salida: "", error: invalid cardinal point:
Entrada: "norte"
Salida: "", error: invalid cardinal point: norte
Impacto en el programa principal:

Como en las otras implementaciones, el main captura el error y lo imprime:
go

Copiar
opposite, err := OppositeDirection(CardinalPoint(input))
if err != nil {
    fmt.Println("Error:", err)
    return
}
El programa muestra el mensaje de error y termina.
Resumen del Comportamiento
Manejo consistente de errores: Las tres implementaciones (a, b, c) manejan valores fuera de rango de manera robusta:
Normalizan la entrada convirtiéndola a mayúsculas para aceptar entradas como "n" o "N".
Si la entrada no es un punto cardinal válido, devuelven:
Un PuntoCardinal vacío ("").
Un error con el formato "invalid cardinal point: <entrada>".
Diferencias en la detección:
Parte a: Usa switch/case y detecta valores inválidos en la cláusula default.
Parte b: Itera un slice y detecta valores inválidos si no hay coincidencia tras el bucle.
Parte c: Consulta un mapa y detecta valores inválidos si la clave no existe.
Impacto en el programa:
En todos los casos, el programa principal imprime el mensaje de error y termina, evitando procesar valores inválidos.
La salida es amigable para el usuario, indicando claramente que la entrada no es válida.
*/
