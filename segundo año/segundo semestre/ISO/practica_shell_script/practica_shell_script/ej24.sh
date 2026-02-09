#!/bin/bash

#como busco el grupo "users"

usuarios=()

for i in $(cat /etc/group | grep "users" | cut -d: -f4 | cut -d, -f1-); do
	usuarios+=($i)
done



if [ $1 = "-b" ]; then
	echo "usuario de la posicion $2: ${usuarios[$2]}"

elif [ $1 = "-l" ]; then
	echo "longitud del arreglo: ${#usuarios[@]}"

elif [ $1 = "-i" ]; then
  	echo "usuarios del sistema: ${usuarios[@]}"
fi


exit 0
