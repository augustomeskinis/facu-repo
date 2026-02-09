#!/bin/bash
#hecho por mi correjido por ia. preguntar: para iterar sobre parametros es mejor $@ o $*



# Comprobar que haya al menos un parámetro

if [ $# -lt 1 ]; then
    echo "Error: Debe proporcionar al menos un parámetro"
    exit 1
fi

i=1  # Contador de posición (empezamos en 1)
arInexistentes=0  # Contador de archivos inexistentes

for ruta in "$@"; do
    if [ -e "$ruta" ]; then #verificar que existe la ruta

        if [ $((i % 2)) -eq 1 ]; then #verficiar si es par o impar la posicion del parámetro
            if [ -f "$ruta" ]; then
                echo "Posición $i: $ruta es un archivo"
            elif [ -d "$ruta" ]; then
                echo "Posición $i: $ruta es un directorio"
            fi
        fi
    else # si entra aca es porque no existe la ruta, entonces sumo 1 a arInexistentes

        arInexistentes=$((arInexistentes + 1))
    fi

    i=$((i + 1)) #incremento contador de posicion
done

echo "Cantidad de archivos inexistentes: $arInexistentes"
exit 0
