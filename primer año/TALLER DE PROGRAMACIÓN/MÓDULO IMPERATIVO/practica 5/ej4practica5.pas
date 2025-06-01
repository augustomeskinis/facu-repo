program ej4practica5;
type
	reclamo = record
		codigo: integer;
		dni: integer;
		ano: integer;
		tipo: string;
	end;
	
	listaReclamos = ^nodoLista;
	
	reclamo2 = record
		codigo: integer;
		ano: integer;
		tipo: string;
	end;

	nodoLista = record
		dato: reclamo2;
		sig: listaReclamos;
	end;
	
	
	registroDNI = record
		dni: integer;
		lista: listaReclamos;
		totalReclamos: integer;
	end;

	arbol = ^nodoArbol;
	
	nodoArbol = record
		dato: registroDNI;
		hi: arbol;
		hd: arbol;
	end;

procedure leerReclamo (var r: reclamo);
begin
	writeln('INGRESE EL CODIGO');
	readln(r.codigo);
	if(r.codigo <> -1) then begin
		writeln('INGRESE EL DNI');
		readln(r.dni);
		writeln('INGRESE EL AÑO');
		readln(r.ano);
		writeln('INGRESE EL TIPO');
		readln(r.tipo);
	end;
end;

procedure agregarAdelante (var l: listaReclamos; r: reclamo);
var
	nuevo: listaReclamos;
begin
	new(nuevo);
	nuevo^.dato.codigo:= r.codigo;
	nuevo^.dato.ano:= r.ano;
	nuevo^.dato.tipo:= r.tipo;
	nuevo^.sig:= nil;
	
	if (l = nil) then
		l:= nuevo
	else begin
		nuevo^.sig:= l;
		l:= nuevo
	end;
end;


procedure agregarArbol (var a: arbol; r: reclamo);
begin
	if (a = nil) then begin
		new(a);
		a^.dato.dni:= r.dni;
		a^.dato.totalReclamos:= a^.dato.totalReclamos + 1;
		a^.dato.lista:= nil;
		agregarAdelante(a^.dato.lista, r);
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (r.dni = a^.dato.dni) then begin
			a^.dato.totalReclamos:= a^.dato.totalReclamos + 1;
			agregarAdelante(a^.dato.lista, r);
		end
		else begin
			if (r.dni < a^.dato.dni) then
				agregarArbol(a^.hi, r)
			else
				agregarArbol(a^.hd, r)
		end;
	end;
end;


procedure incisoA(var a: arbol);
var
	r: reclamo;
begin
	leerReclamo(r);
	while (r.codigo <> -1) do begin
		agregarArbol(a,r);
		leerReclamo(r);
	end;
end;

function buscarDni (a: arbol; dni: integer) : integer;
begin
	if (a = nil) then
		buscarDni:= 0
	else begin
		if (dni = a^.dato.dni) then
			buscarDni:= a^.dato.totalReclamos
		else begin
			if (dni > a^.dato.dni) then
				buscarDni:= buscarDni(a^.hd,dni)
			else
				buscarDni:= buscarDni(a^.hi,dni)
		end;
	end;
end;


procedure incisoB (a: arbol);
var
	dni, cant: integer;
begin
	writeln('INGRESE UN DNI Y DEVOLVERE SU CANTIDAD DE RECLAMOS');
	readln(dni);
	cant:= buscarDni(a,dni);
	writeln('CANTIDAD: ', cant);
end;

var
	abb: arbol;
begin
	abb:= nil;
	incisoA(abb);
	incisoB(abb);
end.
		
		
		
		
		
		
		
		






