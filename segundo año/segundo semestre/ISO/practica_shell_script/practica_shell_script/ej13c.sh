#!/bin/bash
archivo="$1"
if [ -e $archivo ]; then
	if [ -f $archivo ]; then
		echo "es archivo"
	elif [ -d $archivo ]; then
		echo "es directorio"
	fi
else
	mkdir "$archivo"
fi
exit 0
