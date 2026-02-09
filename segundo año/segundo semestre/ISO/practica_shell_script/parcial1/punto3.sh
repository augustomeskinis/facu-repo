#!/bin/bash

# Verificar que se pasó un parámetro
if [ $# -ne 1 ]; then
    echo "Error: Debe proporcionar un path como parámetro"
    echo "Uso: $0 <path_archivo>"
    exit 1
fi

archivo=$1

# Verificar que el archivo existe
if [ ! -e "$archivo" ]; then
    echo "Error: El archivo '$archivo' no existe"
    exit 2
fi

echo "El archivo '$archivo' existe"
echo ""
echo "Permisos del usuario sobre el archivo:"

# Verificar permisos de lectura
if [ -r "$archivo" ]; then
    echo "- Tiene permiso de LECTURA"
else
    echo "- NO tiene permiso de lectura"
fi

# Verificar permisos de escritura
if [ -w "$archivo" ]; then
    echo "- Tiene permiso de ESCRITURA"
else
    echo "- NO tiene permiso de escritura"
fi

# Verificar permisos de ejecución
if [ -x "$archivo" ]; then
    echo "- Tiene permiso de EJECUCIÓN"
    echo ""
    echo "Quitando permisos de ejecución..."
    chmod u-x "$archivo"

    if [ $? -eq 0 ]; then
        echo "Permisos de ejecución removidos exitosamente"
    else
        echo "Error al quitar permisos de ejecución"
        exit 3
    fi
else
    echo "- NO tiene permiso de ejecución"
fi

exit 0
