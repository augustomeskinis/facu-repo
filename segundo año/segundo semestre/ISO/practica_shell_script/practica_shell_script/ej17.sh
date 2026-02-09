#!/bin/bash

directorio=$(pwd)

for archivo in "$directorio"/*; do
	if [ -f "$archivo" ]; then
		echo "$archivo" | tr 'a-zA-Z' 'A-Za-z' | tr -d 'a' | tr -d 'A'
	fi
done
exit 0
