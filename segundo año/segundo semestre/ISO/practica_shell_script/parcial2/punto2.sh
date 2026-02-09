#!/bin/bash

init(){
	pila=()
}

push(){
	if [ $# -lt 1 ]; then
		echo "ingrese al menos 1 parametro"
		return 1
	fi
	for el in $@;do
		pila+=($el)
	done
}

pop() {
        if [ ${#pila[@]} -lt 1 ]; then
                echo "la pila no tiene elementos, no se puede hacer pop"
                return 1
        fi
        ult=$((${#pila[@]} - 1))    # ← Último índice
        echo "${pila[$ult]}"        # ← Saca el ÚLTIMO elemento
        unset pila[$ult]
        pila=(${pila[@]})
}


taill() {
	ult=$((${#pila[@]} -1))
	echo "${pila[$ult]}"
}

lenght(){
	echo "${#pila[@]}"
}



if [ $# -lt 3 ]; then
	echo "ingrese al menos 3 elementos/parametros"
	exit 1
fi
init

for el in $@; do
	push $el
done
for el in $@; do
	pop
done


exit 0 
