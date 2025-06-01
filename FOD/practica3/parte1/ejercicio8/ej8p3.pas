program ej8p3;
type
	distribucion = record
		anioLanzamiento,kernel,cantDes:integer;
		nombre,descripcion:string;
	end;
	
	archivo = file of distribucion;

var
	cabecera:distribucion;


function buscarDistribucion(var ar:archivo; nombre:string):integer;
var
	existe:boolean;
	pos:integer;
	dis:distribucion;
begin
	writeln('		buscando distribucion');
	existe:=false; pos:=-1;
	assign(ar,'archivoDis');
	reset(ar);
	seek(ar,filePos(ar)+1);
	while((not eof (ar)) and (not existe)) do begin
		read(ar,dis);
		if(dis.nombre = nombre)then begin
			existe:=true;
			pos:=filePos(ar)-1;
		end;
	end;
	close(ar);
	buscarDistribucion:=pos;
end;

procedure altaDistribucion(var ar: archivo; nuevaDis:distribucion);
var
	existe,posAgregar:integer;
begin
	existe:=buscarDistribucion(ar,nuevaDis.nombre);
	if (existe = -1) then
		writeln('	no se pudo agregar la distribucion pq ya existe')
	else begin
		assign(ar,'archivoDis');
		reset(ar);
		read(ar,cabecera);
		if (cabecera.cantDes < 0) then begin
			posAgregar:=cabecera.cantDes*-1;
			seek(ar,posAgregar);
			read(ar,cabecera);
			seek(ar,posAgregar);
			write(ar,nuevaDis);
			seek(ar,0);
			write(ar,cabecera);
		end
		else begin
			seek(ar,fileSize(ar)-1);
			write(ar,nuevaDis);
		end;
		close(ar);
		writeln('	se realizo el alta de la distribucion: ',nuevaDis.nombre);
	end;
end;

procedure eliminarDistribucion(var ar:archivo; nombre:string);
var
	posABorrar:integer;
begin
	posABorrar:=buscarDistribucion(ar,nombre);
	if (posABorrar = -1) then
		writeln('	la distribucion a borrar no existe')
	else begin
		assign(ar,'archivoDis');
		reset(ar);
		read(ar,cabecera);
		seek(ar,posABorrar);
		write(ar,cabecera);
		cabecera.cantDes:=posABorrar*-1;
		seek(ar,0);
		write(ar,cabecera);
		close(ar);
		writeln ('	se elimino la distribución correctamente');
	end;
end;

var
	ar:archivo;
begin
	assign(ar,'archivoDis');
	rewrite(ar);
	// crear archivo y cargarlo acá
end.

	
