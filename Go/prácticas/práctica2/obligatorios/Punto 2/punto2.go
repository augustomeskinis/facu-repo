package main

import (
	"bufio"
	"crypto/sha256"
	"encoding/hex"
	"fmt"
	"math/rand"
	"os"
	"time"
)

type Transaccion struct {
	monto      float64
	idenEnvia  string
	idenRecibe string
	timestamp  string
}

type Bloque struct {
	data       Transaccion
	timestamp  string
	hash       string
	hashPrevio string
}

type Cadena struct {
	bloques []Bloque
}

type Billetera struct {
	identificador int
	nombre        string
	apellido      string
}

//Implementación si lo hago con unba lista enlazada
/*
type Nodo struct{
	dato Bloque
	siguiente *Nodo
}
type Cadena struct{
	cabeza Nodo
	cantidadBloques int
}
Es la misma implementación que en el ejercicio 9
*/

// Función para calcular el hash del bloque
func calcularHash(bloque Bloque) string {
	// Concatenamos toda la información del bloque en un string
	record := fmt.Sprintf("%f%s%s%s%s", bloque.data.monto, bloque.data.idenEnvia, bloque.data.idenRecibe, bloque.data.timestamp, bloque.hashPrevio)

	// Usamos sha256.Sum256 para generar el hash
	hash := sha256.Sum256([]byte(record))

	// Convertimos el resultado a hexadecimal
	return hex.EncodeToString(hash[:])
}

//Función para crear una billetera
func crearBilletera(billetera Billetera) Billetera {
	reader := bufio.NewReader(os.Stdin)
	fmt.Println("Ingrese el nombre del cliente: ")
	nombre, err := reader.ReadString('\n')
	if err != nil {
		fmt.Println("Error al leer")
		return billetera
	}
	fmt.Println("Ingrese el apellido del cliente: ")
	apellido, err := reader.ReadString('\n')
	if err != nil {
		fmt.Println("Error al leer")
		return billetera
	}
	billetera.nombre = nombre
	billetera.apellido = apellido
	rand.Seed(time.Now().UnixNano())
	iden := rand.Intn(100000) + 1
	billetera.identificador = iden
	return billetera
}

//Función para insertar un bloque en la cadena
func agregarBloque(cadena Cadena, nuevoBloque Bloque, trans Transaccion) {
	//Obtener hash previo si existe
	var hashPrevio string
	if len(cadena.bloques) > 0 {
		hashPrevio = cadena.bloques[len(cadena.bloques)-1].hash
	} else {
		hashPrevio = ""
	}
	//Creo nuevo bloque
	nuevoBloque = Bloque{
		data:       trans,
		timestamp:  time.Now().Format(time.RFC3339),
		hashPrevio: hashPrevio,
	}
	nuevoBloque.hash = calcularHash(nuevoBloque)
	//Agrego el bloque
	cadena.bloques = append(cadena.bloques, nuevoBloque)
}

//Si fuera una lista
/*
cadena *Cadena
en vez de len(cadena.bloques) sería cadena.cantidadBloques
*/

//Función para enviar una transacción
func enviarTransacción(cadena Cadena, monto float64, envia string, recibe string) {
	trans := Transaccion{
		monto:      monto,
		idenEnvia:  envia,
		idenRecibe: recibe,
		timestamp:  time.Now().Format(time.RFC3339),
	}

	var nuevoBloque Bloque
	agregarBloque(cadena, nuevoBloque, trans)
}

//Si fuera una lista
/*
cadena *Cadena*/

func obtenerSaldoUsuario(cadena Cadena, iden string) float64 {
	var montoEnvia float64 = 0
	var montoRecibe float64 = 0
	var i int
	for i = 0; i < len(cadena.bloques); i++ {
		if cadena.bloques[i].data.idenEnvia == iden {
			montoEnvia += cadena.bloques[i].data.monto
		} else if cadena.bloques[i].data.idenRecibe == iden {
			montoRecibe += cadena.bloques[i].data.monto
		}
	}
	return montoRecibe - montoEnvia
}

//Si fuera una lista
/*
cadena *Cadena
en vez de len(cadena.bloques) sería cadena.cantidadBloques
recorro con anterior y actual y mientras actual sea distinto de nil
*/

//Función que verifica que la cadena sea consistente
func verificarConsistencia(cadena Cadena) bool {
	for i := 1; i < len(cadena.bloques); i++ {
		bloqueActual := cadena.bloques[i]
		bloqueAnterior := cadena.bloques[i-1]
		// Verificamos si el hash previo es igual al hash del bloque anterior
		if bloqueActual.hashPrevio != bloqueAnterior.hash {
			return false
		}
		// Verificamos si el hash actual está bien calculado
		if calcularHash(bloqueActual) != bloqueActual.hash {
			return false
		}
	}
	return true
}

//Si fuera una lista
/*
cadena *Cadena
en vez de len(cadena.bloques) sería cadena.cantidadBloques
recorro con anterior y actual y mientras actual sea distinto de nil
*/

func main() {
	var billetera Billetera
	crearBilletera(billetera)
	var cadena Cadena
	enviarTransacción(cadena, 100.0, "123", "456")
	enviarTransacción(cadena, 50.5, "456", "789")
	//Obtener el identificador de un usuario
	saldo := obtenerSaldoUsuario(cadena, "12645")
	fmt.Println("El saldo del usuario con identificación 12645 es: $", saldo)
	//Verificar que una cadena sea consistente
	esConsistente := verificarConsistencia(cadena)
	fmt.Println("True si la cadena es consistente, False si no: ", esConsistente)
	/*Para enviar una transacción solo se puede sio tiene saldo suficiente,
	calculo el saldo con la función obtenerSaldoUsuario y se lo mando a enviarTransacción:
		func enviarTransacción(cadena Cadena, monto float64, envia string, recibe string,saldoUsuario float64) {
			if saldo<monto{
				return
			}
			trans := Transaccion{
				monto:      monto,
				idenEnvia:  envia,
				idenRecibe: recibe,
				timestamp:  time.Now().Format(time.RFC3339),
			}
			var nuevoBloque Bloque
			agregarBloque(cadena, nuevoBloque, trans)
		}
	*/

}
