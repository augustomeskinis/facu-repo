program ej2practica4;
type
	
	prestamo = record
		isbn: integer;
		numSocio: integer;
		diaYmes: real;
		diasPrestado: integer;
	end;
	
	arbolPrestamo = ^nodo1;
	
	nodo1 = record
		dato: prestamo;
		hi: arbolPrestamo;
		hd: arbolPrestamo;
	end;
	
	prestamo2 = record
		numSocio: integer;
		diaYmes: real;
		diasPrestado: integer;
	end;
	
	listaPrestamos = ^nodoLista;
	
	nodoLista = record
		dato: prestamo2;
		sig: listaPrestamos;
	end;
	
	registroArbolIsbn = record
		isbn: integer;
		lista: listaPrestamos;
	end;
	
	arbolIsbn = ^nodo2;
	
	nodo2 = record
		dato: registroArbolIsbn;
		hi: arbolIsbn;
		hd: arbolIsbn;
	end;
	
	registroC = record
		isbn: integer;
		cant: integer;
	end;
	
	arbolCantidad = ^nodoC;
	
	nodoC = record
		dato: registroC;
		hi: arbolCantidad;
		hd: arbolCantidad;
	end;
	
	
procedure leerPrestamo(var p: prestamo);
begin
	writeln('INGRESE UN ISBN: ');
	readln(p.isbn);
	if (p.isbn<>-1) then begin
		writeln('INGRESE UN NUMERO DE SOCIO: ');
		readln(p.numSocio);
		writeln('INGRESE DIA Y MES');
		readln(p.diaYmes);
		writeln('INGRESE LA CANTIDAD DE DIAS PRESTADO: ');
		readln(p.diasPrestado);
	end;
end;

procedure agregarArbolPrestamo (var a: arbolPrestamo; p: prestamo);
begin
	if (a = nil) then begin
		new(a);
		a^.dato:= p;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (p.isbn <= a^.dato.isbn) then
			agregarArbolPrestamo(a^.hi,p)
		else
			agregarArbolPrestamo(a^.hd,p)
	end;
end;


procedure agregarAdelante (var l: listaPrestamos; p: prestamo);
var
	nuevo: listaPrestamos;
begin
	new(nuevo);
	nuevo^.dato.numSocio:= p.numSocio;
	nuevo^.dato.diaYmes:= p.diaYmes;
	nuevo^.dato.diasPrestado:= p.diasPrestado;
	nuevo^.sig:= nil;
	
	if (l = nil) then
		l:= nuevo
	else begin
		nuevo^.sig:= l;
		l:= nuevo;
	end;
end;

procedure agregarArbolIsbn (var a: arbolIsbn; p: prestamo);
begin
	if (a=nil) then begin
		new(a);
		a^.dato.isbn:= p.isbn;
		a^.dato.lista:= nil;
		agregarAdelante(a^.dato.lista, p);
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (p.isbn = a^.dato.isbn) then
			agregarAdelante(a^.dato.lista, p)
		else begin
			if (p.isbn < a^.dato.isbn) then
				agregarArbolIsbn(a^.hi,p)
			else
				agregarArbolIsbn(a^.hd,p)
		end;
	end;
end;



procedure incisoA (var a1: arbolPrestamo; var a2: arbolIsbn);
var
	p: prestamo;
begin
	leerPrestamo(p);
	while(p.isbn<>-1) do begin
		agregarArbolPrestamo(a1,p);
		agregarArbolIsbn(a2,p);
		leerPrestamo(p);
	end;
end;

function incisoB (a: arbolPrestamo) : integer;
begin
	if (a^.hd = nil) then
		incisoB:= a^.dato.isbn
	else
		incisoB:= incisoB(a^.hd)
end;

function incisoC (a: arbolIsbn): integer;
begin
	if (a^.hi = nil) then
		incisoC:= a^.dato.isbn
	else
		incisoC:= incisoC(a^.hi)
end;

procedure incisoD (a: arbolPrestamo; num: integer; var cant: integer);
begin
	if (a<>nil) then begin
		incisoD(a^.hi,num,cant);
		if (a^.dato.numSocio = num) then
			cant:= cant + 1;
		incisoD(a^.hd,num,cant);
	end;
end;

procedure sumarPrestamos (l: listaPrestamos; num: integer; var cant: integer);
begin
	while (l<>nil) do begin
		if (num = l^.dato.numSocio) then
			cant:= cant + 1;
		l:= l^.sig;
	end;
end;

procedure incisoE (a: arbolIsbn; num: integer; var cant: integer);
begin
	if (a<>nil) then begin
		incisoE(a^.hi,num,cant);
		sumarPrestamos(a^.dato.lista,num,cant);
		incisoE(a^.hd,num,cant);
	end;
end;

procedure agregarArbolF (var a: arbolCantidad; p: prestamo);
begin
	if (a = nil) then begin
		new(a);
		a^.dato.isbn:= p.isbn;
		a^.dato.cant:= 1;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (p.isbn = a^.dato.isbn) then
			a^.dato.cant:= a^.dato.cant + 1
		else begin
			if (p.isbn < a^.dato.isbn) then
				agregarArbolF(a^.hi,p)
			else
				agregarArbolF(a^.hd,p)
		end;
	end;
end;

procedure incisoF (a: arbolPrestamo; var a2: arbolCantidad);
begin
	if (a<>nil) then begin
		incisoF(a^.hi, a2);
		agregarArbolF(a2,a^.dato);
		incisoF(a^.hd,a2);
	end;
end;

procedure imprimirArbolF(a: arbolCantidad);
begin
	if (a<>nil) then begin
		imprimirArbolF(a^.hi);
		writeln('ISBN: ', a^.dato.isbn);
		writeln('CANTIDAD DE VECES QUE SE PRESTO: ', a^.dato.cant);
		imprimirArbolF(a^.hd);
	end;
end;



var
	abb1: arbolPrestamo;
	abb2: arbolIsbn;
	num, cant: integer;
	abb3: arbolCantidad;
	
begin
	abb1:= nil; abb2:= nil;
	incisoA(abb1,abb2);
	if (abb1<>nil) then begin
		writeln('EL ISBN MAS GRANDE ES: ', incisoB(abb1));
		writeln('EL ISBN MAS PEQUEÑO ES: ', incisoC(abb2));
		writeln('INGRESE UN NUMERO DE SOCIO Y DEVOLVERE LA CANTIDAD DE PRESTAMOS: ');
		readln(num);
		cant:= 0;
		incisoD(abb1,num,cant);
		writeln('CANTIDAD: ', cant);
		writeln('INGRESE OTRO NUMERO DE SOCIO Y DEVOLVERE LA CANTIDAD DE PRESTAMOS: ');
		readln(num);
		cant:= 0;
		writeln('CANTIDAD: ', cant);
		abb3:= nil;
		incisoF(abb1,abb3);
		writeln('A CONTINUACION SE IMPRIMIRAN LOS ISBN CON LA CANTIDAD DE VECES QUE SE PRESTO CADA UNO: ');
		imprimirArbolF(abb3);
	end;
end.
	
	
	
	
		
	
	
	
	
	
