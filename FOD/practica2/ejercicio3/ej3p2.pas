program ej3p3;
const
	valorAlto ='zzz';
type
	provincia = record
		nombre:string;
		cantAnalfabetizados,totalEncuestados:integer;
	end;
	
	censo = record
		nombreProvincia:string;
		codigoLocalidad,cantAnalfabetizados,cantEncuestados:integer;
	end;
	
	archivoMaestro = file of provincia;
	
	archivoDetalle = file of censo;
var
	maestro: archivoMaestro;
	prov:provincia;
	detalle1,detalle2: archivoDetalle;
	censo1,censo2:censo;
	nombre:string[20];
procedure leerMaestro(var maestro:archivoMaestro;var prov:provincia);
begin
	if not eof(maestro) then
		read(maestro,prov)
	else
		prov.nombre:= valorAlto;
end;
procedure leerDetalle(var detalle:archivoDetalle;var cen:censo);
begin
	if not eof (detalle) then
		read(detalle,cen)
	else
		cen.nombreProvincia:=valorAlto;
end;
procedure crearArchivoMaestro ();
begin
	writeln('ingrese un nombre para el archivo maestro: ');
	readln(nombre);
	assign(maestro,nombre);
	rewrite(maestro);
	writeln('ingrese el nombre de la provincia o fin para finalizar: ');
	readln(prov.nombre);
	while(prov.nombre <> 'fin') do begin
		writeln('cantidad analfabetizados: ');
		readln(prov.cantAnalfabetizados);
		writeln('total encuestados: ');
		readln(prov.totalEncuestados);
		write(maestro,prov);
		writeln('ingrese el nombre o fin para finalizar: ');
		readln(prov.nombre);
	end;
	close(maestro);
end;
procedure crearArchivoDetalle(var detalle:archivoDetalle;var cen:censo);
begin
	writeln('ingrese un nombre para el archivo detalle: ');
	readln(nombre);
	assign(detalle,nombre);
	rewrite(detalle);
	writeln('ingrese el nombre de la provincia o fin para finalizar: ');
	readln(cen.nombreProvincia);
	while(nombre <> 'fin') do begin
		writeln('ingrese el codigo de la localidad: ');
		readln(cen.codigoLocalidad);
		writeln('ingrese la cantidad de analfabetizados: ');
		readln(cen.cantAnalfabetizados);
		writeln('ingrese la cantidad de encuestados:');
		readln(cen.cantEncuestados);
		write(detalle,cen);
		writeln('ingrese el nombre de la provincia o fin para finalizar: ');
		readln(cen.nombreProvincia);
	end;
	close(detalle);
end;
procedure actualizar();
var
	provinciaActual: string;
	cant1,cant2,tot1,tot2:integer;
begin
	reset(detalle1);reset(detalle2);reset(maestro);
	leerDetalle(detalle1,censo1);leerDetalle(detalle2,censo2);
	while(censo1.nombreProvincia <> valorAlto) and (censo2.nombreProvincia <> valorAlto) do begin
		provinciaActual:= censo1.nombreProvincia;
		cant1:=0;cant2:=0;
		tot1:=0;tot2:=0;
		while(censo1.nombreProvincia = provinciaActual) or (censo2.nombreProvincia = provinciaActual) do begin
			if (censo1.nombreProvincia = provinciaActual)then begin
				cant1:= cant1 + censo1.cantAnalfabetizados;
				tot1:= tot1 + censo1.cantEncuestados;
				leerDetalle(detalle1,censo1)
			end;
			if (censo2.nombreProvincia= provinciaActual)then begin
				cant2:= cant2 + censo2.cantAnalfabetizados;
				tot2:= tot2 + censo2.cantEncuestados;
				leerDetalle(detalle2,censo2)
			end;
		end;
		while(prov.nombre <> provinciaActual)do
			read(maestro,prov);
		prov.cantAnalfabetizados:= prov.cantAnalfabetizados + cant1 + cant2;
		prov.totalEncuestados:= prov.totalEncuestados + tot1 + tot2;
		seek(maestro,filepos(maestro)-1);
		write(maestro,prov);
		if (not(EOF(maestro))) then 
   			read(maestro, prov);
   	end;
   	close(detalle1);close(detalle2);close(maestro);
end;
procedure imprimirArchivoMaestro();
begin
	reset(maestro);
	while not eof (maestro) do begin
		read(maestro,prov);
		with prov do
			writeln('nombre:',nombre,'cantidad de analfabetizados: ',cantAnalfabetizados,
			'total encuestados: ',totalEncuestados);
	end;
end;
procedure menuDeOpciones();
var 
	opcion: byte;
begin
	writeln('				MENU DE OPCIONES');
	writeln('				opcion 1: crear archivo maestro');
	writeln('				opcion 2: crear archivo detalle 1');
	writeln('			    opcion 3: crear archivo detalle 2');
	writeln('				opcion 4: actualizar el archivo maestro con el detalle');
	writeln('				opcion 5: imprimir archivo maestro');
	writeln('				opcion 6: salir del programa');
	readln(opcion);
	while (opcion <> 6) do begin
		case opcion of 
			1:crearArchivoMaestro();
			2:crearArchivoDetalle(detalle1,censo1);
			3:crearArchivoDetalle(detalle2,censo2);
			4:actualizar();
			5:imprimirArchivoMaestro();
		else
			writeln('La opcion ingresada no corresponde a ninguna de las mostradas en el menu de opciones');
		end;
		writeln('				MENU DE OPCIONES');
		writeln('				opcion 1: crear archivo maestro');
		writeln('				opcion 2: crear archivo detalle 1');
		writeln('			    opcion 3: crear archivo detalle 2');
		writeln('				opcion 4: actualizar el archivo maestro con el detalle');
		writeln('				opcion 5: imprimir archivo maestro');
		writeln('				opcion 6: salir del programa');
		readln(opcion);
	end;
end;
begin
	menuDeOpciones()
end.
