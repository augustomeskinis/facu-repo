#!/bin/bash
for ((i=1; i<=100; i++))
do
	echo "numero $i"
     	cuadrado=$(expr "$i" \* "$i")
	echo "cuadrado $cuadrado"
done
exit 0
