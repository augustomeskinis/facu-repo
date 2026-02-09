#!/bin/bash

if [ $# -ne 1 ]; then
	echo "se debe ingresar 1 parámetro"
	exit 2
fi

PARAMETRO=$1
LOGFILE="/var/log/archivo-encontrado-${PARAMETRO}.log"


while true; do

	for home in $(cat /etc/passwd | cut -d: -f6); do

		if [ -d $home ]; then
			find $home -name $PARAMETRO 2> /dev/null >> $LOGFILE
		fi

	done

	if [ -f $LOGFILE ]; then

		cant=$(cat $LOGFILE | wc -l)
		if [ $cant -ge 10]; then
			echo "se encontraron $cant archivos"
			exit 0
		fi
	fi

	sleep 1h

done


