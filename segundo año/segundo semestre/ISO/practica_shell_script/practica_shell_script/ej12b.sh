#!/bin/bash
function realizarCuentas() {
        suma=$(expr "$1" + "$2")
        echo "suma: $suma"
        resta=$(expr "$1" - "$2")
        echo "resta: $resta" 
        multiplicacion=$(expr "$1" \* "$2")
        echo "multiplicacion: $multiplicacion" 
        if [ "$1" -gt "$2" ]
        then
                echo "$1 es mayor"
        else
                echo "$2 es mayor"
        fi
}

# Validar que se reciban 2 parámetros
if [ $# -ne 2 ]; then
    echo "Uso: $0 numero1 numero2"
    exit 1
fi

# Llamar a la función con los parámetros recibidos
realizarCuentas $1 $2

exit 0
