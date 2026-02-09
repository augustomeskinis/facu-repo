#!/bin/bash 

#hay que validar la cantidad de parametros o el tipo?

usuario=$1


while true #esta bien la condicion while = true, y para salir  de esta el exit??
do
	who | grep "$usuario" > /dev/null #hay que redirigir la salida a  dev/null?

	if [ $? -eq 0 ]; then #si la salida del grep es exitosa, informo que se logueo en el sistema.
		echo "usuario $usuario logueado en el sistema"
		exit 0
	fi
	sleep 10 #hay que usar este comando??
done


