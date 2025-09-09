program ej5p1;
type
	celular = record
		codigo:integer;
		precio:real;
		marca:string;
		stockDisponible:integer;
		stockMinimo:integer;
		descripcion:string;
		nombre:string;
	end;
	archivo = file of celular;
	
procedure crearArchivo (var arc: archivo;var carga:text;nombreArchivo:string);
var
	cel:celular;
begin
	assign (arc, nombreArchivo);
	reset(carga);
	rewrite(arc);
	while (not EOF(carga)) do begin
		readln(carga, cel.codigo, cel.precio, cel.marca);
        readln(carga, cel.stockDisponible, cel.stockMinimo, cel.descripcion);
        readln(carga, cel.nombre);
		write(arc,cel);
	end;
	close(carga);
	close(arc);
end;
procedure imprimirCelular(cel:celular);
begin
	with cel do 
		writeln('nombre: ',nombre, 'codigo: ',codigo, 'precio: ', precio, 
		'marca: ', marca, 'stockDisponible: ', stockDisponible,
		'stockMinimo', stockMinimo, 'descripcion: ', descripcion);
end;
procedure listarCelularesMenosStock(var arc:archivo; nombreArchivo:string);
var
	cel:celular;
begin
	assign(arc,nombreArchivo);
	reset(arc);
	while not eof (arc) do begin
		read(arc,cel);
		if (cel.stockDisponible < cel.stockMinimo) then
			imprimirCelular(cel);
	end;
	close(arc);
end;
procedure listarCelularesMismaDescripcion(var arc:archivo; nombreArchivo:string);
var
	cel:celular;
	descripcion: string;
begin
	writeln ('ingrese una descripcion:');
	readln(descripcion);
	writeln('celulares con la misma descripcion: ');
	assign(arc,nombreArchivo);
	reset(arc);	
	while not eof (arc) do begin
		read(arc,cel);
		if(cel.descripcion = descripcion)then
			imprimirCelular(cel);
	end;
	close(arc);
end;
procedure exportarTexto(var arc: archivo; var carga: text; nombreArchivo:string);
var
    c: celular;
begin
	assign(arc,nombreArchivo);
    reset(arc);
    rewrite(carga);
    while(not eof(arc)) do
        begin
            read(arc, c);
            with c do
                begin
                    writeln(carga, codigo, ' ', precio:0:2, marca);
                    writeln(carga, stockDisponible, ' ', stockMinimo, descripcion);
                    writeln(carga, nombre);
                end;
        end;
    close(carga);
    close(arc);
end;
procedure menuDeOpciones(var arc:archivo; var carga: text; nombreArchivo:string);
var
    opcion: integer;
begin
    writeln('MENU DE OPCIONES');
    writeln('Opcion 1: Crear un archivo de registros no ordenados de celulares');
    writeln('Opcion 2: Listar en pantalla los datos de aquellos celulares que tengan un stock menor al stock minimo');
    writeln('Opcion 3: Listar en pantalla los celulares cuya descripcion contenga una cadena de caracteres proporcionada');
    writeln('Opcion 4: Exportar el archivo creado a un texto celulares.txt');
    writeln('Opcion 5: Salir del menu y terminar la ejecucion del programa');
    readln(opcion);
    while(opcion <> 5) do
        begin
            case opcion of
                1: crearArchivo(arc,carga,nombreArchivo);
                2: listarCelularesMenosStock(arc,nombreArchivo);
                3: listarCelularesMismaDescripcion(arc,nombreArchivo);
                4: exportarTexto(arc,carga,nombreArchivo);
            else
                writeln('La opcion ingresada no corresponde a ninguna de las mostradas en el menu de opciones');
            end;
            writeln();
            writeln('MENU DE OPCIONES');
            writeln('Opcion 1: Crear un archivo de registros no ordenados de celulares');
            writeln('Opcion 2: Listar en pantalla los datos de aquellos celulares que tengan un stock menor al stock minimo');
            writeln('Opcion 3: Listar en pantalla los celulares cuya descripcion contenga una cadena de caracteres proporcionada');
            writeln('Opcion 4: Exportar el archivo creado a un texto celulares.txt');
            writeln('Opcion 5: Salir del menu y terminar la ejecucion del programa');
            readln(opcion);
        end;
end;
var
	carga:text;
	arc:archivo;
	nombreArchivo:string;
begin
	assign(carga,'celulares.txt');
	writeln('ingrese un nombre para el archivo: ');
	readln(nombreArchivo);
	menuDeOpciones(arc,carga,nombreArchivo);
end.
