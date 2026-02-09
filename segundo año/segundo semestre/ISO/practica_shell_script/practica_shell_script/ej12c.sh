#!/bin/bash

case $3 in
"suma")  
        suma=$(expr "$1" + "$2")
        echo "suma: $suma"
        ;;
"resta") 
        resta=$(expr "$1" - "$2")
        echo "resta: $resta"
        ;;
"multiplicacion")
        multiplicacion=$(expr "$1" \* "$2")
        echo "multiplicacion: $multiplicacion"
        ;;
"division")
        if [ "$2" -eq 0 ]; then
                echo "Error: No se puede dividir por cero"
                exit 1
        fi
        division=$(expr "$1" / "$2")
        echo "division: $division"
        ;;
*)
        echo "Operación no válida. Use: suma, resta, multiplicacion o division"
        exit 1
        ;;
esac

exit 0
