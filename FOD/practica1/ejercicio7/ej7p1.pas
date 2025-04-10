program ej7p1;
type
	novela = record
		codigo:integer;
		nombre,genero:string;
		precio:real;
	end;
	archivo = file of novela;
var
	arc: archivo;
	nombreArchivo: string;
	carga: text;
	nov:novela;
procedure abrirArchivo();
begin
	assign(arc,nombreArchivo);
	reset(arc);
end;
procedure cargarArchivo();
begin
	writeln('Ingrese un nombre para el archivo: ');
	readln(nombreArchivo);
	assign(arc,nombreArchivo);
	rewrite(arc);
	assign(carga, 'novelas.txt');
	reset(carga);
	while (not EOF (carga)) do begin
		readln(carga, nov.codigo, nov.precio, nov.genero);
		readln(carga, nov.nombre);
		write(arc,nov);
	end;
	close(arc);
	close(carga);
end;
procedure leerNovela(var nov:novela);
begin
	writeln('ingrese el codigo: ');
	readln(nov.codigo);
	writeln('ingrese el nombre: ');
	readln(nov.nombre);
	writeln('ingrese el genero: ');
	readln(nov.genero);
	writeln('ingrese el precio: ');
	readln(nov.precio);
end;
procedure agregar();
begin
	writeln('Ingrese los datos de la novela a agregar: ');
	leerNovela(nov);
	abrirArchivo();
	seek(arc,fileSize(arc)-1);
	write(arc,nov);
	close(arc);
end;
procedure modificar();
var
	cod:integer;
	listo:boolean;
	nov2:novela;
begin
	writeln('ingrese el codigo de la novela a modificar: ');
	readln(cod);
	listo:=false;
	abrirArchivo();
	while ( not eof (arc) ) and (listo = false) do begin
		read(arc,nov);
		if (cod = nov.codigo) then begin
			listo:= true;
			leerNovela(nov2);
			write(arc,nov2);
		end;
	end;
	close(arc);
end;
procedure imprimirNovela();
begin
	writeln('codigo de novela: ',nov.codigo);
	writeln('nombre de novela: ',nov.nombre);
	writeln('genero de novela: ',nov.genero);
	writeln('precio de novela: ',nov.precio);
end;
procedure imprimirArchivoBinario();
begin
	abrirArchivo();
	while (not eof (arc)) do begin
		read(arc,nov);
		imprimirNovela();
	end;
	close(arc);
end;
begin
	cargarArchivo();
	agregar();
	imprimirNovela();
	modificar();
	imprimirNovela();
end.
