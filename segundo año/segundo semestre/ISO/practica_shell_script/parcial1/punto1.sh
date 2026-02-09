#!/bin/bash

if [ $# -lt 1 ]; then
	echo "ingrese 1 parámetro"
	exit 1
fi

for linea in $(cat /etc/passwd | cut -d: -f1,6); do

	user=$(echo $linea | cut -d: -f1)
	home=$(echo $linea | cut -d: -f2)

	for posibleUser in $@; do

		if [ $user = $posibleUser ]; then
			echo "usuario: $user existe"
			if [ -d $home ]; then
				echo "/$user/$home"
				echo $user $(find $home -name "*.docx" | wc -l)

			else
				echo "Sin HOME"
			fi
		fi
	done
done

exit 0
