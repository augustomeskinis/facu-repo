#!/bin/bash

if [ ! -d "$HOME/bin" ]; then
	mkdir "$HOME/bin"
	echo "directorio /bin creado"
fi

cant=0

for archivo in *; do
	if [ -f "$archivo" ] && [ -x "$archivo" ]; then
		mv "$archivo" "$HOME/bin/"
		echo "archivo $archivo movido"
		cant=$((cant + 1)) 
	fi
done

echo "cantidad de archivos movidos: $cant"


exit 0
