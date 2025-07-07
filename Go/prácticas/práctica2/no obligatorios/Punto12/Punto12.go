package main

import (
	"fmt"
	"math/rand"
	"time"
)

// Estructura para representar a un cliente
type Cliente struct {
	DNI            int
	Nombre         string
	Apellido       string
	CodigoImpuesto string
	Monto          float64
}

// Función para generar un cliente aleatorio (simulación de datos)
func generarCliente() Cliente {
	nombres := []string{"Juan", "María", "Pedro", "Ana", "Luis"}
	apellidos := []string{"Gómez", "Pérez", "Rodríguez", "López", "Martínez"}
	codigos := []string{"A", "B", "C", "D"}

	rand.Seed(time.Now().UnixNano())
	return Cliente{
		DNI:            rand.Intn(90000000) + 10000000, // DNI entre 10M y 99M
		Nombre:         nombres[rand.Intn(len(nombres))],
		Apellido:       apellidos[rand.Intn(len(apellidos))],
		CodigoImpuesto: codigos[rand.Intn(len(codigos))],
		Monto:          float64(rand.Intn(5000)) + 500, // Monto entre 500 y 5500
	}
}

// Función para atender clientes y contar códigos de impuestos
func atenderClientes(clientes []Cliente) {
	const montoObjetivo = 10000.0
	montoRecaudado := 0.0
	clientesAtendidos := 0
	// Mapa para contar la cantidad de pagos por cada código de impuesto
	conteoImpuestos := map[string]int{
		"A": 0,
		"B": 0,
		"C": 0,
		"D": 0,
	}

	fmt.Println("Iniciando atención de clientes...")
	for i, cliente := range clientes {
		if montoRecaudado >= montoObjetivo {
			break
		}

		fmt.Printf("\nAtendiendo cliente %d:\n", i+1)
		fmt.Printf("DNI: %d, Nombre: %s %s, Código Impuesto: %s, Monto: $%.2f\n",
			cliente.DNI, cliente.Nombre, cliente.Apellido, cliente.CodigoImpuesto, cliente.Monto)

		montoRecaudado += cliente.Monto
		clientesAtendidos++
		// Incrementar el conteo del código de impuesto
		conteoImpuestos[cliente.CodigoImpuesto]++

		fmt.Printf("Monto recaudado hasta ahora: $%.2f\n", montoRecaudado)
	}

	// Determinar el código de impuesto más pagado
	var codigoMasPagado string
	maxPagos := 0
	for codigo, conteo := range conteoImpuestos {
		if conteo > maxPagos {
			maxPagos = conteo
			codigoMasPagado = codigo
		}
	}

	// Calcular clientes sin atender
	clientesSinAtender := len(clientes) - clientesAtendidos

	fmt.Printf("\nResumen:\n")
	fmt.Printf("Clientes atendidos: %d\n", clientesAtendidos)
	fmt.Printf("Monto total recaudado: $%.2f\n", montoRecaudado)
	if montoRecaudado >= montoObjetivo {
		fmt.Println("Se alcanzó el objetivo de recaudación de $10,000.")
	} else {
		fmt.Println("No hay más clientes para atender.")
	}

	// Informar el código de impuesto más pagado
	if maxPagos > 0 {
		fmt.Printf("El código de impuesto más pagado fue: %s (%d veces)\n", codigoMasPagado, maxPagos)
	} else {
		fmt.Println("No se atendieron clientes, por lo que no hay un código de impuesto más pagado.")
	}

	// Informar la cantidad de clientes sin atender
	if clientesSinAtender > 0 {
		fmt.Printf("Clientes que quedaron sin atender: %d\n", clientesSinAtender)
	} else {
		fmt.Println("No quedaron clientes sin atender.")
	}
}

func main() {
	// Simular una lista de clientes (10 clientes para el ejemplo)
	var clientes []Cliente
	for i := 0; i < 10; i++ {
		clientes = append(clientes, generarCliente())
	}

	// Atender a los clientes
	atenderClientes(clientes)
}
