#!/bin/bash

for linea in $(cat /etc/passwd | cut -d: -f1,6); do

	user=$(echo $linea | cut -d: -f1)
	home=$(echo $linea | cut -d: -f2)
	cantGrupos=$(cat /etc/group | cut -d: -f2- | grep $user | wc -l)
	cantLineas=$(grep -R $user /var/log 2> /dev/null | wc -l)
	if [ -d $home ]; then
		cantAr=$(find "$home" -type f 2> /dev/null | wc -l)
		cantDir=$(find "$home" -type d 2> /dev/null | wc -l)
		total=$((cantAr+cantDir))

		echo "$user ; $cantGrupos ; $home ; $total ; $cantLineas"
	else
		echo "$user ; $cantGrupos ; XXX ; -1 ; $cantLineas"
	fi
done
