program ej2p4;
type

	prestamo = record
		isbn: integer;
		numsocio: integer;
		diaYmes: integer;
		cantdias: integer;
	end;
	
	
	
	lista = ^nodo;
	
	nodo = record
		dato: prestamo;
		sig: lista;
	end;	
	
	
	registro_isbn = record
		isbn: integer;
		prestamos: lista;
	end;

	arbol1 = ^nodo1;

	nodo1 = record
		dato: prestamo;
		hi: arbol1;
		hd: arbol1;
	end;
	
	arbol2 = ^nodo2;
	
	nodo2 = record
		dato: registro_isbn;
		hi: arbol2;
		hd: arbol2;
	end;
	
	
	registro_prestaciones = record
		isbn: integer;
		cant: integer;
	end;
	
	
	
	arbol3 = ^nodo3;
	
	nodo3 = record
		dato: registro_prestaciones;
		hi: arbol3;
		hd: arbol3;
	end;
	
	


procedure leer_prestamo (var p: prestamo);
begin
	writeln ('ingrese el isbn: ');
	readln (p.isbn);
	writeln ('ingrese el numero de socio: ');
	readln (p.numsocio);
	writeln ('ingrese el dia y el mes: ');
	readln (p.diaYmes);
	writeln ('ingrese la cantidad de dias que fue prestado: ');
	readln (p.cantdias);
end;

procedure agregar1 (var a: arbol1; p: prestamo);
begin
	if (a = nil) then 
	begin	
		new (a);
		a^.dato:= p;
		a^.hi:= nil;
		a^.hd:= nil
	end
	
	else 
		if (p.isbn <= a^.dato.isbn) then
			agregar1 (a^.hi, p)
		else
			agregar1 (a^.hd, p)
end;

procedure agregar_adelante (var l: lista; p: prestamo);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.dato:= p;
	nuevo^.sig:= nil;
	
	if (l = nil) then
		l:= nuevo
	else
		nuevo^.sig:= l;
		l:= nuevo;
end;



procedure agregar2 (var a: arbol2; p: prestamo);
begin
	
	if (a = nil) then begin
		new (a);
		a^.dato.prestamos:= nil;
		a^.dato.isbn:= p.isbn;
		agregar_adelante (a^.dato.prestamos, p);
	end
	else
		if (p.isbn = a^.dato.isbn) then
			agregar_adelante (a^.dato.prestamos, p)
		else 
		if (p.isbn < a^.dato.isbn) then
			agregar2 (a^.hi, p)
		else
			agregar2 (a^.hd, p)
end;
			
	
	
procedure cargar_arboles (var a1: arbol1; var a2: arbol2);
var
	p: prestamo;
begin
	a1:= nil;
	a2:= nil;
	leer_prestamo (p);
	while (p.isbn <> -1) do begin
		agregar1 (a1, p);
		agregar2 (a2, p);
		leer_prestamo (p);
	end;
end;


procedure maximo (a: arbol1; var max: integer);
begin
	if (a <> nil) then begin
		maximo (a^.hi, max);
		if (a^.dato.isbn > max) then
			max:= a^.dato.isbn;
		maximo (a^.hd, max);
	end;
end;

procedure minimo (a: arbol2; var min: integer);
begin
	if (a <> nil) then begin
		minimo (a^.hi, min);
		if (a^.dato.isbn < min) then
			min:= a^.dato.isbn;
		minimo (a^.hd, min);
	end;
end;

procedure cantidad_prestamos (a: arbol1; numsocio: integer; var cant: integer);
begin
	if (a <> nil) then
	begin
		cantidad_prestamos (a^.hi, numsocio, cant);
		if (a^.dato.numsocio = numsocio) then
			cant:= cant + 1;
		cantidad_prestamos (a^.hd, numsocio, cant);
	end;
end;


procedure cantidad_prestamos2 (a: arbol2; numsocio: integer; var cant: integer);
begin
	if (a <> nil) then
	begin
		cantidad_prestamos2 (a^.hi, numsocio, cant);
		while (a^.dato.prestamos <> nil) do
		begin
			if (a^.dato.prestamos^.dato.numsocio = numsocio) then
				cant:= cant + 1;
			a^.dato.prestamos:= a^.dato.prestamos^.sig;
		end;
		cantidad_prestamos2 (a^.hd, numsocio, cant);
	end;
end;


procedure agregar3 (a: arbol3; isbn: integer);
begin
	
	if (a = nil) then
	begin
		new(a);
		a^.dato.isbn:= isbn;
		a^.dato.cant:= a^.dato.cant + 1 ;
		a^.hi:= nil;
		a^.hd:= nil;
	end;
	
	if (isbn = a^.dato.isbn) then 
		a^.dato.cant:= a^.dato.cant + 1
	else
		if (isbn < a^.dato.isbn) then
			agregar3 (a^.hi, isbn)
		else
			agregar3 (a^.hd, isbn)
end;			
		
		
		
		



procedure crear_estructura1 (a: arbol1; var a3: arbol3);
begin
	if (a <> nil) then
	begin
		agregar3 (a3, a^.dato.isbn); 
		crear_estructura1 (a^.hi, a3);
		crear_estructura1 (a^.hd, a3);
	end;
end;

		
procedure imprimir_arbol3 (a: arbol3);
begin
	if (a <> nil) then
	begin
		imprimir_arbol3 (a^.hi);
		writeln ('la cantidad de veces que fue prestrado el isbn: ', a^.dato.isbn, 'es: ', a^.dato.cant);
		imprimir_arbol3 (a^.hd);
	end;
end;
		
		
		

var
	abb1: arbol1;
	abb2: arbol2;
	abb3: arbol3;
	max, min, c, num: integer;
begin
	cargar_arboles (abb1, abb2);
	max:= 0; min:= 9999; c:= 0;
	maximo (abb1,max);
	writeln ('el isbn mas grande de este arbol es: ', max);
	minimo (abb2, min);
	writeln ('el isbn mas chico de este arbol es: ', min);
	writeln (' ingrese un numero de socio : ');
	readln (num);
	cantidad_prestamos (abb1, num, c);
	writeln ('la cantidad de prestamos de este socio es: ', c);
	writeln ('ingrese otro numero de socio: ') ;
	readln (num);
	c:= 0;
	cantidad_prestamos2 (abb2, num, c);
	writeln ('la cantidad de prestamos de este socio es: ', c);
	abb3:= nil;
	crear_estructura1 (abb1, abb3);
	imprimir_arbol3 (abb3);
	
end.







