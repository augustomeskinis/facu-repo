#!/bin/bash

source /usr/lib/functions.sh

init() {
	numeros=()
}


init

for arg in $@; do

	is_number  $arg
	es=$?

	if [ $es -eq 0 ]; then
		numeros+=($arg)
	else
		echo "$arg no es numero"
	fi
done


sum() {

	suma=0
	for num in ${numeros[@]}; do
		((suma+=$num))
	done
	echo "$suma"
	return $suma
}


sum

add_number(){
	if [ $# -ne 1 ]; then
		echo "se debe ingresar un parametro"
		return 1
	fi

	numeros+=($1)
}


all_numbers(){
	echo "numeros: ${numeros[@]}"
}

lista_numeros=$(all_numbers)
suma_total=$(sum)


echo "fecha = 2/2/2026, numeros = $lista_numeros, suma = $suma_total" >> /var/log/sums.log


exit 0
