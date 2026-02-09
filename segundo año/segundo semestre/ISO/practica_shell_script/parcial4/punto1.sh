#!/bin/bash

if [ $# -lt 1 ]; then
	echo "ingrese al menos un parámetro"
fi



for linea in $(cat /etc/passwd | cut -d: -f1,6); do

	user=$(echo $linea | cut -d: -f1)
	home=$(echo $linea | cut -d: -f2)

	for posibleUser in $@; do

		if [ $user = $posibleUser ]; then

			if [ -d $home ]; then

				cant=$(find $home -type f | wc -l)
				echo "nombre = $user, home = $home, cantidad de archivos = $cant"
			else
				echo "nombre = $user, 0"
			fi
		fi
	done
done

exit 0

# si quiero que se guarde en reporte.txt y sobrescriba, entonces hago ./reporte.sh > reporte.txt
