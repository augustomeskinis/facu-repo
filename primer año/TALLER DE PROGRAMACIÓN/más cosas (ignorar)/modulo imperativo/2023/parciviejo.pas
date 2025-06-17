program viejo;
type
	prestamo = record
		numero: integer;
		isbn: integer;
		codsocio: integer;
	end;
	socios = record
		codigo: integer;
		cantprestamos: integer;
	end;
		
	lista = ^nodo2;
	nodo2 = record
		dato: socios;
		sig: lista;
	end;
	lista2 = ^nodo3;
	nodo3 = record
		dato: prestamo;
		sig: lista2;
	end;
	arbol = ^nodo;
	
	registro = record
		isbn: integer;
		listaprestamos: lista2;
	end;
	nodo = record
		dato: registro;
		hi: arbol;
		hd: arbol;
	end;

procedure leerprestamo (var p: prestamo);
begin
	writeln('ingrese un numero de prestamo: ');
	readln(p.numero);
	writeln('ingrese isbn');
	readln(p.isbn);
	writeln('ingrese el cod de socio');
	readln(p.codsocio);
end;
procedure agregar_adelante (var l: lista; cod: integer; cant: integer);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.dato.codigo:= cod;
	nuevo^.dato.cantprestamos:= cant;
	nuevo^.sig:=l;
	l:= nuevo;
end;
procedure agregar_adelante2 (var l: lista2; p: prestamo);
var
	nuevo: lista2;
begin
	new(nuevo);
	nuevo^.dato:= p;
	nuevo^.sig:= l;
	l:= nuevo;
end;
procedure agregar (var a: arbol; p: prestamo);
begin
	if (a=nil) then
	begin
		new(a);
		a^.dato.isbn:= p.isbn;
		a^.dato.listaprestamos:= nil;
		agregar_adelante2 (a^.dato.listaprestamos,p);
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (p.isbn=a^.dato.isbn) then
			agregar_adelante2(a^.dato.listaprestamos,p);
		if (p.isbn<a^.dato.isbn ) then
			agregar (a^.hi, p)
		else
			agregar (a^.hd, p)
	end;
end;
procedure procesar_estructuras (var a: arbol; var l: lista);
var
	p: prestamo;
	cant, actual: integer;
begin
	a:= nil;
	l:= nil;
	leerprestamo(p);
	while (p.codsocio<>0) do begin
		actual:= p.codsocio;
		cant:= 0;
		while ((p.codsocio<>0)and(actual=p.codsocio)) do begin
			agregar (a,p);
			cant:= cant + 1;
			leerprestamo(p);
		end;
		agregar_adelante (l,actual,cant);
	end;
end;
procedure contar (l: lista2; var cant: integer);
begin
	while (l<>nil) do begin
		cant:= cant + 1;
		l:= l^.sig;
	end;
end;
procedure prestamosISBN (a: arbol; isbn: integer; var cant: integer);
begin
	if (a<>nil) then begin
		if (a^.dato.isbn=isbn) then
			contar(a^.dato.listaprestamos, cant)
		else 
			if (a^.dato.isbn<isbn) then 
				prestamosISBN(a^.hd,isbn,cant)
			else
				prestamosISBN(a^.hi,isbn,cant)
		end;
end;
procedure prestamosSOCIOS (l: lista; x: integer; var cant: integer);
begin
	if (l<>nil) then begin
		if (l^.dato.cantprestamos > x) then begin
			cant:= cant + 1;
			prestamosSOCIOS(l^.sig,x,cant);
		end
		else
			prestamosSOCIOS(l^.sig,x,cant);
	end;
end;
var
	abb: arbol;
	lis: lista;
	cant: integer;
begin
	procesar_estructuras(abb,lis);
	cant:= 0;
	prestamosISBN(abb,11,cant);
	writeln('la cantidad de prestamos con este isbn es: ');
	writeln(cant);
	cant:= 0;
	prestamosSOCIOS(lis,2,cant);
	writeln('la cantidad de prestamos de este socio es: ');
	writeln(cant);
end.










	
	
	
	
