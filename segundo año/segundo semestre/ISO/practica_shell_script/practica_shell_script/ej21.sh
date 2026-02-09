#!/bin/bash

num=(10 3 5 7 9 3 5 4)
mult=1
productoria(){
	for elemento in "${num[@]}"; do
		mult=$(($mult * $elemento))
	done
}
productoria
echo "resultado $mult"
exit 0
