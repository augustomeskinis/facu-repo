#!/bin/bash

if [ "$#" -ne 3 ]; then
    echo "Cantidad de parametros invalida"
    echo "Uso: $0 DIRECTORIO -a|-b CADENA"
    exit 1
fi

DIRECTORIO="$1"
OPCION="$2"
CADENA="$3"

if [ ! -d "$DIRECTORIO" ]; then
    echo "$DIRECTORIO no es un directorio"
    exit 2
fi

if [ "$OPCION" = "-a" ]; then
    for archivo in "$DIRECTORIO"/*; do
        if [ -f "$archivo" ]; then
            nombre=$(basename "$archivo")
            mv "$archivo" "$DIRECTORIO/${nombre}${CADENA}"
        fi
    done
elif [ "$OPCION" = "-b" ]; then
    for archivo in "$DIRECTORIO"/*; do
        if [ -f "$archivo" ]; then
            nombre=$(basename "$archivo")
            mv "$archivo" "$DIRECTORIO/${CADENA}${nombre}"
        fi
    done
else
    echo "Operacion incorrecta. Use -a o -b"
    exit 3
fi

exit 0

