program punto3;
//Constate
const valorAlto = 9999;
//Declaraciones
type
    novela = record
        codigo:integer;
        genero,nombre,director:string;
        duracion,precio:real;
    end;
    maestro = file of novela;
//Variables globales
var
    archivo:maestro;
    registro:novela;
    cabecera:novela;
    nombreFisico:string;
    texto:text;
    nombreTexto:string;
//Procesos
procedure leer(var archivo:maestro;var reg:novela);
begin
    if (not eof(archivo)) then
        read(archivo,reg)
    else
        reg.codigo:=valorAlto;
end;
procedure leerNovela(var reg:novela);
begin
    write('Ingrese el código de la novela: ');
    readln(reg.codigo);
    write('Ingrese el género de la novela: ');
    readln(reg.genero);
    write('Ingrese el nombre de la novela: ');
    readln(reg.nombre);
    write('Ingrese el director: ');
    readln(reg.director);
    write('Ingrese la duración de la novela: ');
    readln(reg.duracion);
    write('Ingrese el precio de la novela: $');
    readln(reg.precio);
end;
procedure cargarArchivo(var archivo:maestro);
begin
    leerNovela(registro);
    write(archivo,registro);
    writeln('Novela agregada exitosamente');
    writeln('-----------------------------------');
end;
procedure crearYcargarArchivo();
var
    i:integer;
begin
    write('Ingrese el nombre del archivo a crear: ');
    readln(nombreFisico);
    assign(archivo,nombreFisico);
    rewrite(archivo);
    cabecera.codigo:=0;
    write(archivo,cabecera);
    for i:= 1 to 5 do begin
        cargarArchivo(archivo);
    end;
    close(archivo);
end;
procedure agregarNovela();
var
    codigoCabecera:integer;
    codigoCabeceraAux:integer;
    reg:novela;
    posicionEscribir:integer;
begin
    leerNovela(registro);
    assign(archivo,nombreFisico);
    reset(archivo);

    read(archivo,cabecera);
    codigoCabecera := cabecera.codigo;

    if (codigoCabecera = 0) then begin
        seek(archivo,filesize(archivo));
        write(archivo,registro)
    end else begin
        codigoCabeceraAux:=codigoCabecera*-1;
        posicionEscribir := codigoCabeceraAux-1;

        seek(archivo,posicionEscribir);
        read(archivo,reg);

        if (reg.codigo<0) then begin
            cabecera.codigo:=reg.codigo;
            seek(archivo,0);
            write(archivo,cabecera);
            seek(archivo,posicionEscribir);
        end;
        
        write(archivo,registro);
    end;
    close(archivo);
end;
procedure modificarNovela();
var
    codNovela:integer;
    encontro:boolean;
    reg:novela;
begin
    assign(archivo,nombreFisico);
    reset(archivo);

    write('Ingrese el código de la novela a modificar: ');
    readln(codNovela);

    encontro:=false;
    leer(archivo,registro);
    while (registro.codigo<>valorAlto) and (not encontro) do begin
        if (registro.codigo=codNovela) then
            encontro := true
        else 
            leer(archivo,registro);
    end;
    if (encontro) then begin
        reg.codigo:=registro.codigo;
        write('Ingrese el nuevo género: ');
        readln(reg.genero);
        write('Ingrese el nuevo director: ');
        readln(reg.director);
        write('Ingrese el nuevo nombre: ');
        readln(reg.nombre);
        write('Ingrese el nuevo duración: ');
        readln(reg.duracion);
        write('Ingrese el nuevo precio: $');
        readln(reg.precio);
        seek(archivo,filepos(archivo)-1);
        write(archivo,reg);
    end;
    close(archivo);
end;
procedure eliminarNovela();
var
    codigoEliminar:integer;
    regEliminar:novela;
    encontrado:boolean;
    posEliminar:integer;
begin
    assign(archivo,nombreFisico);
    reset(archivo);

    write('Ingrese el código a eliminar: ');
    readln(codigoEliminar);

    read(archivo,cabecera);

    encontrado:=false;
    leer(archivo,regEliminar);
    while ((regEliminar.codigo<>valorAlto) and (not encontrado)) do begin
        if (regEliminar.codigo=codigoEliminar) then
            posEliminar:=filepos(archivo);
            encontrado:=true;
        leer(archivo,regEliminar);
    end;
    if (encontrado) then begin
        regEliminar.codigo:=cabecera.codigo;
        seek(archivo,posEliminar);
        write(archivo,regEliminar);

        cabecera.codigo:=-posEliminar;
        seek(archivo,0);
        write(archivo,cabecera);

        writeln('Novela eliminada correctamente.');
    end else
        writeln('Código no encontrado.');
    close(archivo);
end;
procedure opcionesB();
var
    opcionElegida:char;
begin
        writeln('   a. Agregar novela');
        writeln('   b. Modificar novela');
        writeln('   c. Eliminar novela');
        readln(opcionElegida);
        case opcionElegida of
            'a':agregarNovela();
            'b':modificarNovela();
            'c':eliminarNovela();
        end;
end;
procedure listarArchivoTexto();
var
    pos:integer;
begin
    assign(archivo,nombreFisico);
    reset(archivo);

    write('Ingrese el nombre del archivo de texto a generar: ');
    readln(nombreTexto);
    assign(texto,nombreTexto);
    rewrite(texto);

    writeln(texto, 'Listado de novelas (activas y borradas):');
    writeln(texto, '-----------------------------------------');

    for pos:=1 to filesize(archivo) do begin
        seek(archivo,pos);
        read(archivo,registro);

        if (registro.codigo>0) then begin
            writeln(texto,'Código: ',registro.codigo);
            writeln(texto, 'Género: ', registro.genero);
            writeln(texto, 'Nombre: ', registro.nombre);
            writeln(texto, 'Duración: ', registro.duracion);
            writeln(texto, 'Director: ', registro.director);
            writeln(texto, 'Precio: ', registro.precio:0:2);
            writeln(texto, '---------------');
        end else begin
            writeln(texto, 'Registro borrado en posición ', pos, ' (en lista libre, apunta a ', registro.codigo, ')');
        end;
    end;
    close(archivo);
    close(texto);

    writeln('Exportación finalizada. Revisa el archivo "novelas.txt".');
end;
//Programa principal
var 
    opcionElegida:char;
begin
    repeat
        writeln('OPCIONES: ');
        writeln('1. Crear y cargar archivo');
        writeln('2. Modificar archivo');
        writeln('3. Pasar las novelas a un archivo de texto');
        writeln('4. Fin');
        readln(opcionElegida);
        case opcionElegida of
            '1':crearYcargarArchivo();
            '2':opcionesB();
            '3':listarArchivoTexto();
        end;
    until (opcionElegida='4');
end.
