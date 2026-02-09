#!/bin/bash

directorio=$1

#verificar cantidad de parametros

if [ $# -ne 1 ]; then
	echo "ingrese 1 parametro"
	exit 1
fi


# Verificar si el directorio existe
if [ ! -d $directorio ]; then
    echo "El directorio no existe."
    exit 4  # Termina el script con código de error 4 si el directorio no existe
fi

# Contadores
contar_lectura_escritura=0

# Iterar sobre los archivos en el directorio
for archivo in $directorio/*; do
    # Comprobar si es un archivo regular
    if [ -f "$archivo" ]; then
        # Verificar si tiene permisos de lectura y escritura
        if [ -r "$archivo" ] && [ -w "$archivo" ]; then
            ((contar_lectura_escritura++))
        fi
    fi
done

# Informar la cantidad de archivos con permisos de lectura y escritura
echo "Cantidad de archivos con permisos de lectura y escritura: $contar_lectura_escritura"

