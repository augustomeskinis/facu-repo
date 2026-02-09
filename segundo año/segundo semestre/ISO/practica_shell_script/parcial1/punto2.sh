#!/bin/bash

init() {
	lista=()
	for el in $@; do
		lista+=($el)
	done
}

push() {
	if [ $# -ne 1 ]; then
		echo "ingrese 1 parametro"
		return 1
	fi

	lista+=($1)
}


last() {
	ult=$((${#lista[@]}-1))
	echo "ultimo elemento = ${#lista[@]} , quitado de la lista"
	unset lista[$ult]
	lista=(${lista[@]})
}

first() {
	echo "primer elemento = ${lista[0]} , quitado de la lista"
	unset lista[0]
	lista=(${lista[@]})
}

size() {
	echo "tamaño = ${#lista[@]}"
}

print() {
	echo "imprimiendo lista ${lista[@]}"
}

init
push 1
push 2
push 3
push 4
push 5
push 6
last
first
size
print

exit 0
