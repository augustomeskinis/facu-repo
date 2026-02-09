#!/bin/bash

inicializar() {
	array=()
}

agregar_elem(){
	if [ $# -ne 1 ]; then
  		echo "ingrese un parametro"
		return 1
	fi
	array=(${array[@]} $1)

	echo "elemento $1 fue agregado"
}

eliminar_elem(){
	if [ $# -ne 1 ]; then
		echo "ingrese un parametro"
		return 1
	fi
	if [ $1 -ge ${#array[@]} ]; then
		echo "posicion no valida"
		return 2
	fi

	unset array[$1];
	array=(${array[@]});
	echo "elemento $1 fue eliminado"
}

longitud(){
	echo "longitud del arreglo: ${#array[@]}"
}

imprimir(){
	echo ${array[@]}
}


inicializar_con_valores(){
    	if [ $# -ne 2 ]; then
		echo "ingrese 2 parametros"
		return 1
	fi

	array=()  # Reiniciar el arreglo
	for ((i=0; i<$1; i++)); do
		agregar_elem $2
	done

	echo "arreglo creado"
}



select action in inicializar agregar_elem eliminar_elem longitud imprimir inicializar_con_valores terminar; do
case $action in
    "inicializar")
        inicializar
    ;;
    "agregar_elem")
        echo "Ingresa un elemento"
        read elemento
        agregar_elem $elemento
    ;;
    "eliminar_elem")
        echo "Ingrese una posicion a borrar"
        read posicion
        eliminar_elem $posicion
    ;;
    "longitud")
        echo "El arreglo tiene $(longitud) elementos"
    ;;
    "imprimir")
        echo "Arreglo: $(imprimir)"
    ;;
    "inicializar_con_valores")
        echo "Ingrese cantidad"
        read cantidad
        echo "Ingrese valor"
        read valor
        inicializar_con_valores $cantidad $valor
    ;;
    "terminar")
        echo "Fin"
        exit 0
    ;;
esac
done
exit 0
