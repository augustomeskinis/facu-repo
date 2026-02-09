#!/bin/bash

init(){
	cola=()
}

push(){
	if [ $# -lt 1 ]; then
		echo "ingrese al menos 1 parametro"
		return 1
	fi
	for el in $@;do
		cola+=($el)
	done
}

pop() {
        if [ ${#cola[@]} -lt 1 ]; then
                echo "la pila no tiene elementos, no se puede hacer pop"
                return 1
        fi
        echo "${cola[0]}"
        unset cola[0]
        pila=(${cola[@]})
}


taill() {
	ult=$((${#cola[@]}))
	echo "${cola[$ult]}"
}

size(){
	echo "${#cola[@]}"
}

list() {
	echo "${cola[@]}"
}


init #inicializa la cola
push 1 2 3 4 5 6 #inserta 6 elementos en la cola
pop #quita el primer elemento que hice en el push anterior (1)
taill
size
list
