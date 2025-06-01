program ej4p3;
type
	regFlor = record
		nombre: String[45];
		codigo: integer;
	end;
	
	
	archivoFlores = file of regFlor;
	
var
	ar:archivoFlores;
	f,cabecera:regFlor;
	
	
procedure agregarFlor(nombre:string;codigo:integer);
var
	posFinal,posEliminado:integer;
begin
	assign(ar,'archivoFlores');
	reset(ar);
	read(ar,cabecera);
	if(cabecera.codigo=0)then begin
		f.nombre:= nombre;
		f.codigo:= codigo;
		seek(ar,fileSize(ar));
		write(ar,f);
	end
	else begin
		posEliminado:= cabecera.codigo * (-1);
		seek(ar,posEliminado);
		read(ar,f);
		cabecera.codigo:=f.codigo;
		f.codigo:= codigo;
		f.nombre:= nombre;
		seek(ar,posEliminado);
		write(ar,f);
		seek(ar,0);
		write(ar,cabecera);
	end;
	close(ar);
end;

procedure listarArchivo();
begin
	assign(ar,'archivoFlores');
	reset(ar);
	seek(ar, 1);
	while not eof (ar) do begin
		read(ar,f);
		if(f.nombre <> '***')then begin
			writeln('nombre: ',f.nombre);
			writeln('codigo: ',f.codigo);
		end;
	end;
	close(ar);
end;

procedure eliminarFlor(florAEliminar:regFlor);
begin
	assign(ar,'archivoFlores');
	reset(ar);
	seek(ar, 1);
	read(ar,f);
	while not eof (ar) and (f.codigo <> florAEliminar.codigo) do 
		read(ar,f);
	if(f.codigo = florAEliminar.codigo)then begin
		f.nombre:= '***';
		if (cabecera.codigo = 0) then
			f.codigo:= 0
		else begin
			f.codigo:= cabecera.codigo;
			cabecera.codigo:= filePos(ar)-1*-1;
		end;
		seek(ar,filePos(ar)-1);
		write(ar,f);
		seek(ar, 0);
		write(ar, cabecera);
	end;
	close(ar);
end;

var
	codLeido:integer;
	nombreLeido:string;
	florLeida:regFlor;
begin
	assign(ar,'archivoFlores');
	rewrite(ar);
	cabecera.codigo:=0;
	write(ar,cabecera);
	close(ar);
	writeln('	ingrese el codigo de  la flor a agregar (0 para terminar): 	');
	readln(codLeido);
	while(codLeido <> 0) do begin
		writeln('	ingrese el nombre de  la flor a agregar: 	');
		readln(nombreLeido);
		agregarFlor(nombreLeido,codLeido);
		writeln('	ingrese el codigo de  la flor a agregar (0 para terminar): 	');
		readln(codLeido);
	end;
	listarArchivo();
	writeln('	ingrese el codigo de  la flor a eliminar: 	');
	readln(codLeido);
	florLeida.codigo:=codLeido;
	writeln('	ingrese el nombre de  la flor a eliminar: 	');
	readln(nombreLeido);
	florLeida.nombre:=nombreLeido;
	eliminarFlor(florLeida);
	writeln('				ARCHIVO POST ELIMINACION');
	listarArchivo();
end.
