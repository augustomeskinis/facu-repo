program ej2p3;
type
	asistente = record
		nro,telefono,DNI:integer;
		apellido,nombre,email:string;
	end;
	
	archivoAsistente = file of asistente;
var
	ar:archivoAsistente;
	asi:asistente;
procedure leer();
begin
	writeln('ingrese el nro de asistente o -1 para terminar');
	readln(asi.nro);
	if (asi.nro <> -1) then begin
		writeln('ingrese el telefono del asistente: ');
		readln(asi.telefono);
		writeln('ingrese el DNI del asistente: ');
		readln(asi.DNI);
		writeln('ingrese el apellido del asistente: ');
		readln(asi.apellido);
		writeln('ingrese el nombre del asistente: ');
		readln(asi.nombre);
		writeln('ingrese el email del asistente: ');
		readln(asi.email);
	end;
end;

procedure cargarAsistentes();
begin
	leer();
	while(asi.nro <> -1)do begin
		write(ar,asi);
		leer();
	end;
	close(ar);
end;

procedure eliminarAsistentes();
begin
	writeln('eliminando a todos los asistentes con nro 1000');
	assign(ar,'archivoAsistente');
	reset(ar);
	while not eof (ar) do begin
		read(ar,asi);
		if(asi.nro = 1000)then begin
			asi.nombre:='***';
			seek(ar,filePos(ar)-1);
			write(ar,asi);
		end;
	end;
	close(ar);
end;

procedure imprimirAsistente();
begin
	with asi do begin
		writeln ('		numero: ',nro, '		telefono:',telefono,'		DNI:',DNI,'		nombre:',nombre);
	end;
end;



procedure imprimirArchivo();
begin
	writeln('imprimiendo archivo: ');
	assign(ar,'archivoAsistente');
	reset(ar);
	while not eof (ar) do begin
		read(ar,asi);
		imprimirAsistente();
	end;
	close(ar);
end;
begin
	assign(ar,'archivoAsistente');
	rewrite(ar);
	cargarAsistentes();
	eliminarAsistentes();
	imprimirArchivo();
end.
