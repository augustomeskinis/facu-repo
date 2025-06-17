program ej2adicionales;
const
	df = 9;
type

	rangoVector = 1..df;


	auto = record
		patente: integer;
		anoFabricacion: 2010..2018;
		marca: string;
		modelo: string;
	end;
	
	arbolPatente = ^nodoPatente;
	
	
	nodoPatente = record
		dato: auto;
		hi: arbolPatente;
		hd: arbolPatente;
	end;
	
	listaAutos = ^nodoLista;
	
	vector = array [rangoVector] of listaAutos;
	
	
	nodoLista = record
		dato: auto;
		sig: listaAutos;
	end;
	
	
	registroMarca = record
		marca: string;
		lista: listaAutos;
	end;
	
	arbolMarca = ^nodoMarca;
	
	nodoMarca = record
		dato: registroMarca;
		hi: arbolMarca;
		hd: arbolMarca;
	end;

procedure leerAuto (var car: auto);
begin
	writeln('INGRESE LA PATENTE: ');
	readln(car.patente);
	if (car.patente <> - 1) then begin
		writeln('INGRESE EL ANO DE FABRICACION: ');
		readln(car.anoFabricacion);
		writeln('INGRESE LA MARCA: ');
		readln(car.marca);
		writeln('INGRESE EL MODELO: ');
		readln(car.modelo);
	end;
end;

procedure agregarArbolPatente (var a: arbolPatente; car: auto);
begin
	if (a = nil) then begin
		new(a);
		a^.dato:= car;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (car.patente <= a^.dato.patente) then
			agregarArbolPatente(a^.hi,car)
		else
			agregarArbolPatente(a^.hd,car)
	end;
end;

procedure agregarAdelante (var l: listaAutos; car: auto);
var
	nuevo: listaAutos;
begin
	new(nuevo);
	nuevo^.dato:= car;
	nuevo^.sig:= nil;
	
	if(l=nil) then
		l:= nuevo
	else begin
		nuevo^.sig:= l;
		l:= nuevo;
	end;
end;

procedure agregarArbolMarca (var a: arbolMarca; car: auto);
begin
	if (a=nil) then begin
		new(a);
		a^.dato.marca:= car.marca;
		a^.dato.lista:= nil;
		agregarAdelante(a^.dato.lista, car);
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (car.marca = a^.dato.marca) then
			agregarAdelante(a^.dato.lista,car)
		else begin
			if (car.marca < a^.dato.marca) then
				agregarArbolMarca(a^.hi,car)
			else
				agregarArbolMarca(a^.hd,car)
		end;
	end;
end;

procedure incisoA (var a1: arbolPatente; var a2: arbolMarca);
var
	car: auto;
begin
	leerAuto(car);
	while (car.patente <> -1) do begin
		agregarArbolPatente(a1,car);
		agregarArbolMarca(a2,car);
		leerAuto(car);
	end;
end;
	
	
procedure incisoB (a: arbolPatente; marca: string; var cant: integer);
begin
	if (a<>nil) then begin
		incisoB(a^.hi,marca,cant);
		if (marca = a^.dato.marca) then
			cant:= cant + 1;
		incisoB(a^.hd,marca,cant);
	end;
end;

function buscarNodo (a: arbolMarca; marca: string) : arbolMarca;
begin
	if (a = nil) then
		buscarNodo:= nil
	else begin
		if (a^.dato.marca = marca) then
			buscarNodo:= a
		else begin
			if (marca < a^.dato.marca) then
				buscarNodo:= buscarNodo(a^.hi,marca)
			else
				buscarNodo:= buscarNodo(a^.hd,marca)
		end;
	end;
end;

procedure incisoC (a: arbolMarca);
var
	x: arbolMarca; cant: integer;
	marca: string;
begin
	writeln('INGRESE OTRA MARCA Y LE DEVOLVERE LA CANTIDAD DE AUTOS: ');
	readln(marca);
	x:= buscarNodo(a,marca);
	cant:= 0;
	if (x<>nil) then begin
		while (x^.dato.lista <> nil) do begin
			cant:= cant + 1;
			x^.dato.lista:= x^.dato.lista^.sig;
		end;
	end;
	writeln('CANTIDAD: ', cant);
end;


procedure iniciarVector (var v: vector);
var
	i: rangoVector;
begin
	for i:= 1 to df do
		v[i]:= nil;
end;


procedure cargarVector (a: arbolPatente; var v: vector);
begin
	if (a<>nil) then begin
		cargarVector(a^.hi,v);
		agregarAdelante(v[(a^.dato.anoFabricacion - 2009)], a^.dato);
		cargarVector(a^.hd,v);
	end;
end;

procedure imprimirLista (l: listaAutos);
begin
	while (l<>nil) do begin
		writeln('ANO DE FABRICACION: ', l^.dato.anoFabricacion);
		writeln('PATENTE: ', l^.dato.patente);
		writeln('MARCA: ', l^.dato.marca);
		writeln('MODELO: ', l^.dato.modelo);
		l:= l^.sig;
	end;
end;



procedure incisoD (a: arbolPatente; var v: vector);
var
	i: rangoVector;
begin
	iniciarVector(v);
	cargarVector(a,v);
	for i:= 1 to df do
		imprimirLista(v[i])
end;

function buscarPatente(a: arbolPatente; patente: integer): string;
begin
	if (a=nil) then
		buscarPatente:= 'no se encontro la patente '
	else begin
		if (a^.dato.patente  = patente) then
			buscarPatente:= a^.dato.modelo
		else begin
			if (patente < a^.dato.patente) then
				buscarPatente:= buscarPatente(a^.hi,patente)
			else
				buscarPatente:= buscarPatente(a^.hd,patente)
		end;
	end;
end;


procedure incisoE (a: arbolPatente);
var
	modelo: string;
	patente: integer;
begin
	writeln('INGRESE UNA PATENTE Y DEVOLVERE EL MODELO: ');
	readln(patente);
	modelo:= buscarPatente(a,patente);
	writeln('EL MODELO DEL AUTO CON LA PATENTE: ', patente, ' ES: ', modelo);
end;

procedure buscarLista (l: listaAutos;patente: integer; var modelo: string);
begin
	while (l<>nil) do begin
		if (l^.dato.patente = patente) then 
			modelo:= l^.dato.modelo;
		l:= l^.sig;
	end;
end;


procedure incisoF (a: arbolMarca; patente: integer; var modelo: string);
begin
	if (a<>nil) then begin
		incisoF(a^.hi,patente,modelo);
		buscarLista(a^.dato.lista,patente,modelo);
		incisoF(a^.hd,patente,modelo);
	end;
end;
	
	
var
	abb1: arbolPatente;
	abb2: arbolMarca;
	marca: string; cant: integer;
	v: vector;
	modelo: string;
	patente: integer;
begin
	abb1:= nil; abb2:= nil;
	incisoA(abb1,abb2);
	writeln('INGRESE UNA MARCA Y LE DEVOLVERE LA CANTIDAD DE AUTOS: ');
	readln(marca);
	cant:= 0;
	incisoB(abb1,marca,cant);
	writeln('CANTIDAD: ', cant);
	incisoC(abb2);
	incisoD(abb1,v);
	incisoE(abb1);
	writeln('INGRESE OTRA PATENTE Y DEVOLVERE EL MODELO: ');
	readln(patente);
	incisoF(abb2,patente,modelo);
	writeln('EL MODELO ES: ', modelo);
end.
	
			
	
	
	
	
	
	
	
	
