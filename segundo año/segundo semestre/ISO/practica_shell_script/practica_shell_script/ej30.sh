#!/bin/bash

initialize(){
	conjunto=()
}

initialize_with(){

	if [ $# -lt 1 ];then
		echo "error por cantidad de parametros < 1"
		return 1
	fi
	conjunto=()
	for arg in "$*"; do
		existe=0
		for valor in "${conjunto[*]}"; do
			if [ "$arg" = "$valor" ]; then
				existe=1
				break
			fi
		done
		if [ $existe -eq 0 ]; then
			conjunto+=("$arg")
		fi
	done
}

add(){
	if [ $# -ne 1 ]; then
		echo "error por cantidad de parametros <> 1"
		return 1
	fi
	for valor in "${conjunto[*]}"; do 
		if [ "$1" = "$valor" ]; then
			echo "el valor ya se encuentra en el conjunto"
			return 1
		fi
	done
	conjunto+=("$1")
	echo "se agrego el valor en el $1 en el conjunto"
	return 0
}

remove(){

	if [ $# -lt 1 ]; then
		echo "error por cantidad de parametros < 1"
		return 1
	fi
	cant=0
	for arg in "$*"; do
		for ((i=0; i<${#conjunto[*]}; i++)); do
			if [ "$arg" = "${conjunto[i]}" ]; then
				echo "$arg eliminado"
				unset conjunto[$i]
				cant=$((cant + 1))
				break
			fi
		done
	done

	conjunto=("${conjunto[*]}")


	if [ $cant -lt 1 ]; then
		echo "no se pudo eliminar ningun elemento"
		return 1
	fi

	return 0
}

contains(){

	if [ $# -ne 1 ]; then
		echo "requiere un parametro"
		return 1
	fi




	for valor in "${conjunto[*]}"; do
		if [ "$valor" = "$1" ]; then
			echo "el conjunto contiene el valor $1"
			return 0
		fi
	done
	echo "no se encuentra el valor $1 en el conjunto" 
	return 1
}

print(){
	echo "elementos del conjunto"
	for valor in "${conjunto[*]}"; do
		echo "$valor"
	done
}


print_sorted() {
    echo "Elementos del conjunto (ordenados):"
    for valor in "${conjunto[*]}"; do
        echo "$valor"
    done | sort
}




# ========== JUEGO DE BINGO ========== (hecho por IA)

# Validar y obtener valor máximo
if [ $# -eq 0 ]; then
    max=99
elif [ $# -eq 1 ]; then
    max=$1
    
    # Validar que sea un número
    if ! [[ "$max" =~ ^[0-9]+$ ]]; then
        echo "Error: El argumento debe ser un número"
        exit 1
    fi
    
    # Validar rango
    if [ $max -eq 0 ] || [ $max -gt 32767 ]; then
        echo "Error: El valor máximo debe estar entre 1 y 32767"
        exit 1
    fi
else
    echo "Uso: $0 [valor_maximo]"
    exit 1
fi

echo "=========================================="
echo "       JUEGO DE BINGO"
echo "=========================================="
echo "Rango de números: 0 - $max"
echo "Presione ENTER para cantar número"
echo "Escriba 'BINGO' para finalizar"
echo "=========================================="
echo ""

# Inicializar el conjunto de números cantados
initialize

# Bucle principal del juego
while true; do
    # Generar número aleatorio que no haya sido cantado
    while true; do
        numero=$(($RANDOM % ($max + 1)))
        
        # Verificar si ya fue cantado
        if ! contains $numero; then
            break
        fi
        
        # Si ya se cantaron todos los números posibles
        if [ ${#conjunto[*]} -gt $max ]; then
            echo "¡Se cantaron todos los números posibles!"
            break 2
        fi
    done
    
    # Agregar el número al conjunto
    add $numero
    
    # Cantar el número
    echo ">>> Número cantado: $numero <<<"
    echo ""
    
    # Esperar entrada del usuario
    echo -n "Presione ENTER para continuar o escriba BINGO: "
    read respuesta
    
    # Verificar si el usuario cantó BINGO
    if [ "$respuesta" = "BINGO" ] || [ "$respuesta" = "bingo" ]; then
        echo ""
        echo "=========================================="
        echo "           ¡¡¡ BINGO !!!"
        echo "=========================================="
        break
    fi
    
    echo ""
done

# Imprimir números cantados en orden
echo ""
echo "Números cantados (en orden):"
echo "----------------------------"
print_sorted
echo "----------------------------"
echo "Total de números cantados: ${#conjunto[*]}"

exit 0
