#!/bin/bash

if [ $# -lt 1 ]; then
	echo "ingrese al menos un parametro"
	exit 1
fi




for arg in "$@"; do #recorro todos los posibles usuarios

	for linea in $(cat /etc/passwd | cut -d: -f1,6); do #recorro todos los usuarios del sistema con su directorio home

		user=$(echo "$linea" | cut -d: -f1) #tomo el usuario

		if [ "$arg" = "$user" ]; then #me fijo si el posible usuario es el usuario actual

			home=$(echo "$linea" | cut -d: -f2) #si existe el usuario, tomo su home

			if [ -d "$home" ]; then #me fijo que el home sea valido
				echo "creando estructura para el usuario $user"

				# creo la estructura de directorios con brace expansion
        			mkdir -p $home/directorio_iso/{2025,2026}/{1..12}

        			# Crear los archivos con brace expansion
        			touch $home/directorio_iso/{2025,2026}/{1..12}/archivo.txt

			else
				echo "el usuario $user existe pero no tiene un directorio home valido"
			fi
		fi
	done
done
echo "recorrido finalizado"
exit 0
