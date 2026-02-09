#!/bin/bash

# Estructura global - UN SOLO ARREGLO
pila=()

# Función push: agrega elemento al final
push() {
    pila+=("$1")
}

# Función pop: elimina el último elemento
pop() {
    unset pila[${#pila[@]}-1]
    pila=(${pila[@]})
}

# Función length: devuelve la longitud
length() {
    echo ${#pila[@]}
}

# Función print: imprime todos los elementos
print() {
    echo ${pila[@]}
}

# Programa principal

# 1. Agregar 10 elementos
echo "Agregando 10 elementos..."
for ((i=1; i<=10; i++)); do
    push "elemento$i"
done

# 2. Sacar 3 elementos
echo "Sacando 3 elementos..."
pop
pop
pop

# 3. Imprimir longitud
echo "Longitud de la pila: $(length)"

# 4. Imprimir todos los elementos
print
exit 0
