#!/bin/bash

vector1=(1 80 65 35 2)
vector2=(5 98 3 41 8)

if [ ${#vector1[@]} -ne ${#vector2[@]} ]; then
    echo "Los 2 vectores no tienen igual longitud"
    exit 1
fi

for ((i=0; i < ${#vector2[@]}; i++)); do
    echo "La suma de los elementos de la posicion $i de los vectores es $((vector1[i] + vector2[i]))"
done

exit 0
