program finall; 
type
	alumno = record
		nombre: string;
		dni: integer;
		tiempo: real;
	end;
	
	arbol = ^nodoArbol;
	
	nodoArbol = record
		dato: alumno;
		hi: arbol;
		hd: arbol;
	end;
	lista = ^nodoLista;
	
	nodoLista = record
		dato: alumno;
		sig: lista;
	end;
procedure leerAlumno (var a: alumno);
begin
	writeln('ingrese el dni: ');
	readln(a.dni);
	if (a.dni <> 0) then begin
		writeln('ingrese el nombre: ');
		readln(a.nombre);
		writeln('ingrese el tiempo: ');
		readln(a.tiempo);
	end;
end;
procedure agregarAlumno(var a: arbol; var al: alumno);
begin
	if(a=nil)then begin
		new(a);
		a^.dato:= al;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if(al.tiempo <= a^.dato.tiempo) then
			agregarAlumno(a^.hi,al)
		else
			agregarAlumno(a^.hd,al)
	end;
end;
procedure incisoA (var a: arbol);
var
	al: alumno;
begin
	leerAlumno(al);
	while (al.dni <> 0) do begin
		agregarAlumno(a,al);
		leerAlumno(al);
	end;
end;
procedure agregarAtras(var l: lista; var ult: lista; al:alumno);
var
	nuevo:lista;
begin
	new(nuevo);
	nuevo^.dato:=al;
	nuevo^.sig:=nil;
	if(l=nil)then
		l:=nuevo
	else
		nuevo^.sig:=ult;
	ult:=nuevo;
end;
procedure recorrerYcrearLista(a:arbol; var l:lista;var ult: lista; num1,num2: real); // esta es la forma mas eficiente?
begin
	if(a<>nil) then begin
		if(num1 >= a^.dato.tiempo) then
			recorrerYcrearLista(a^.hd,l,ult,num1,num2)
		else begin
			if(num2 >= a^.dato.tiempo) then begin
				recorrerYcrearLista(a^.hi,l,ult,num1,num2);
				agregarAtras(l,ult,a^.dato);
				recorrerYcrearLista(a^.hd,l,ult,num1,num2);
			end;
		end;
	end;
end;
procedure incisoB(a:arbol;var l:lista);
var
	ult: lista;
	num1,num2:real;
begin
	num1:= 2.5; num2:= 3.2;
	recorrerYcrearLista(a,l,ult,num1,num2);
end;
procedure imprimirLista(l:lista);
begin
	while(l<>nil) do begin
		writeln('nombre: ',l^.dato.nombre);
		writeln('dni: ',l^.dato.dni);
		writeln('tiempo: ',l^.dato.tiempo);
		l:= l^.sig;
	end;
end;
function alumnoMasRapido(a:arbol): alumno;
begin
	if(a^.hi = nil) then 
		alumnoMasRapido:= a^.dato
	else
		alumnoMasRapido:= alumnoMasRapido(a^.hi);
end;
procedure incisoC(a: arbol);
var
	x: alumno;
begin
	x:= alumnoMasRapido(a);
	writeln('el nombre del alumno mas rapido es: ', x.nombre);
	writeln('el dni del alumno mas rapido es: ', x.dni);
end;
var	
	abb: arbol;
	lis: lista;
begin
	abb:= nil;
	incisoA(abb);
	lis:= nil;
	incisoB(abb,lis);
	imprimirLista(lis);
	if(abb<>nil)then
		incisoC(abb);
end.
