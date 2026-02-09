#!/bin/bash

num=(1 2 3 4 5 6 7 8 9 10)
impar=0
for elemento in "${num[@]}"; do
	if [ $(($elemento % 2)) -eq 0 ]
	then
		echo "$elemento es par"
	else
		impar=$(($impar + $elemento))
	fi
done
echo "suma impares: $impar"
exit 0
done
