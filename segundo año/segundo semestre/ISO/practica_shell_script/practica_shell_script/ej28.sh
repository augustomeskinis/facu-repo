#!/bin/bash

arr=()
archivos=$(find $HOME -type f -name "*.sh" 2>/dev/null)


for ar in $archivos; do
    arr+=("$ar")  
done

echo "Cargados ${#arr[@]} archivos"  



verArchivo() {

    for ar in "${arr[@]}"; do  #   
        if [ "$ar" = "$1" ]; then  
      	# if  echo $ar | grep -q $1 ; then 
            cat "$ar"  
            return 0
        fi
    done
    echo "Archivo no encontrado"
    return 5
}

cantidadArchivos() {
    echo "Cantidad de archivos: ${#arr[@]}"
}


borrarArchivo() {
    if [ -z "$1" ]; then
        echo "Error: debe proporcionar un nombre de archivo"
        return 1
    fi

    local pos=0
    for i in "${arr[@]}"; do  
            if echo $ar | grep -q $1; then
            echo "¿Quiere eliminar el archivo lógicamente? (si/no)"
            read respuesta
            case "$respuesta" in
                si)
                    unset arr[$pos]
                    arr=("${arr[@]}")  # Reindexar
                    echo "Se eliminó el archivo lógicamente"
                    ;;
                no)
                    unset arr[$pos]
                    arr=("${arr[@]}")  # Reindexar
                    rm "$i"
                    echo "Eliminación física del archivo correctamente"
                    ;;
                *)
                    echo "El valor ingresado es incorrecto"
                    return 1
                    ;;
            esac
            return 0
        fi
        ((pos++))
    done
    echo "El archivo no existe"
    return 10
}

# MENÚ DE OPCIONES
while true; do
    echo ""
    echo "========== MENÚ DE OPCIONES =========="
    echo "1) Ver contenido de un archivo"
    echo "2) Mostrar cantidad de archivos"
    echo "3) Borrar un archivo"
    echo "4) Salir"
    echo "======================================"
    echo -n "Seleccione una opción: "
    read opcion

    case "$opcion" in
        1)
            echo -n "Ingrese el nombre del archivo: "
            read nombre_archivo
            verArchivo "$nombre_archivo"
            ;;
        2)
            cantidadArchivos
            ;;
        3)
            echo -n "Ingrese el nombre del archivo a borrar: "
            read nombre_archivo
            borrarArchivo "$nombre_archivo"
            ;;
        4)
            echo "Saliendo del programa..."
            exit 0
            ;;
        *)
            echo "Opción inválida. Intente nuevamente."
            ;;
    esac
done
