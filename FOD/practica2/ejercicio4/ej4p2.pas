{
    -Se cuenta con un archivo de productos de una cadena de venta de alimentos congelados.
    De cada producto se almacena: código del producto, nombre, descripción, stock disponible, stock mínimo y precio del producto.
    -Se recibe diariamente un archivo detalle de cada una de las 30 sucursales de la cadena. Se
    debe realizar el procedimiento que recibe los 30 detalles y actualiza el stock del archivo maestro.
    -La información que se recibe en los detalles es: código de producto y cantidad vendida.
    -Además, se deberá informar en un archivo de texto: nombre de producto, descripción, stock disponible y precio de aquellos productos que tengan 
    stock disponible por debajo del stock mínimo.
    -Nota: todos los archivos se encuentran ordenados por código de productos. En cada detalle
    puede venir 0 o N registros de un determinado producto.
}

program punto4;
//Constante
const valorAlto=999;
//Declaraciones
type
    producto = record
        codigo,stockDisponible,stockMinimo:integer;
        nombre,descripcion:string;
        precio:real;
    end;
    r_detalle = record
        codigo,cantVendida:integer;
    end;
    maestro = file of producto;
    detalle = file of r_detalle;
    texto = text;
//Variables globales
var
    archivoMaestro:maestro;
    archivosDetalle:array[1..30] of file of r_detalle;
    archivoTexto:texto;
    regMaestro:producto;
    regDetalle:array[1..30] of r_detalle;
    nombreFisicoMaestro:string;
    nombreFisicoTexto:string;
        indice_min:integer;
//Procesos
procedure abrirArchivosDetalle();
var
    i:integer;
begin
    for i := 1 to 30 do begin
        assign(archivosDetalle[i], ('detalle  + i '));
        reset(archivosDetalle[i]);
        if (not eof(archivosDetalle[i])) then 
            read(archivosDetalle[i],regDetalle[i])
        else 
            regDetalle[i].codigo:=valorAlto;
    end;
end;
procedure asignar();
begin
    write('Ingrese el nombre físico del maestro: ');
    readln(nombreFisicoMaestro);
    assign(archivoMaestro,nombreFisicoMaestro);
    reset(archivoMaestro);
    abrirArchivosDetalle();
    write('Ingrese el nombre del archivo de texto de salida: ');
    readln(nombreFisicoTexto);
    assign(archivoTexto,nombreFisicoTexto);
    rewrite(archivoTexto);
end;
procedure cerrarArchivosDetalle();
var
    i: integer;
begin
    for i := 1 to 30 do
        close(archivosDetalle[i]);
end;
procedure leerSiguienteDetalle(indice: integer);
begin
    if (not eof(archivosDetalle[indice])) then
        read(archivosDetalle[indice], regDetalle[indice])
    else
        regDetalle[indice].codigo := 9999;
end;
procedure minimo(var min:integer;var totalVendido:integer);
var
    i:integer;
begin
    min:=9999;
    for i:=1 to 30 do begin
        if (regDetalle[i].codigo<min) then begin
            min:=regDetalle[i].codigo;
            indice_min:=i;
        end;
    end;
    if (min<>9999) then begin
        totalVendido:=0;
        for i:=1 to 30 do begin
            while regDetalle[i].codigo=min do begin
                totalVendido:=totalVendido+regDetalle[i].cantVendida;
                leerSiguienteDetalle(i);
            end;
        end;
    end;
end;
//Programa principal
var
    codigoDetalle,totalVendido:integer;
begin
    asignar();
    while (not eof(archivoMaestro)) do begin
        read(archivoMaestro,regMaestro);
        minimo(codigoDetalle,totalVendido);
        while (regMaestro.codigo<codigoDetalle) do begin
            if (not eof(archivoMaestro)) then
                read(archivoMaestro,regMaestro)
        end;
        if (regMaestro.codigo=codigoDetalle) then begin
            regMaestro.stockDisponible:=regMaestro.stockDisponible-totalVendido;
            seek(archivoMaestro,filepos(archivoMaestro)-1);
            write(archivoMaestro,regMaestro);
        end;
        if regMaestro.stockDisponible < regMaestro.stockMinimo then begin
            writeln(archivoTexto, 'Nombre: ', regMaestro.nombre);
            writeln(archivoTexto, 'Descripcion: ', regMaestro.descripcion);
            writeln(archivoTexto, 'Stock Disponible: ', regMaestro.stockDisponible);
            writeln(archivoTexto, 'Precio: ', regMaestro.precio:0:2);
            writeln(archivoTexto, '--------------------------------------');
        end;
    end;
    close(archivoMaestro);
    cerrarArchivosDetalle();
    close(archivoTexto);
end.
