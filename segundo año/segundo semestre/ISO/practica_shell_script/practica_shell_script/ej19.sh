#!/bin/bash
cd /home/iso/practica_shell_script/
while true; do
	echo "menu de comandos amigable para el usuario"
	echo "opcion 1: ejecutar evaluacion de expresiones"
	echo "opcion 2: ejecutar uso de estructuras de control"
	echo "opcion 3: ejecutar renombrando archivos" 
	echo "opcion 4: salir"
	echo "--------------"
	echo "ingrese una opcion"
	read opcion
	case $opcion in
	"1")
		echo "ejecutando el ej12a"
		./ej12.sh
		;;
	"2")
		echo "ejecutando el 13a"
		./ej13a.sh
		;;
	"3")
		echo "ejecutando el ej14"
		./ej14.sh
		;;
	"4")
		echo "saliendo"
		exit 0
		;;
	"*")
		echo"opcion no valida"
	esac
done
