#!/bin/bash
echo "ingrese el n1"
read n1
echo "ingrese el n2"
read n2
multiplicacion=$(expr "$n1" \* "$n2")
echo "multiplicacion $multiplicacion"
suma=$(expr "$n1" + "$n2")
echo "suma $suma"
resta=$(expr "$n1" - "$n2")
echo "resta $resta"
if [ "$n1" -gt "$n2" ]
then
	echo "$n1 es mayor"
elif [ "$n1" -lt "$n2" ]
then
	echo "$n2 es mayor"
fi
exit 0
