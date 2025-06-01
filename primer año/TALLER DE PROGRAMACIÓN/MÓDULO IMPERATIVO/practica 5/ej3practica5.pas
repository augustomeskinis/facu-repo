program ej3practica5;
const
	df = 10;
type
	rangoVector = 1..df;
	
	producto = record
		codigo: integer;
		rubro: rangoVector;
		stock: integer;
		precio: integer;
	end;
	
	arbol = ^nodo;
	
	nodo = record
		dato: producto;
		hi: arbol;
		hd: arbol;
	end;
	
	vector = array [rangoVector] of arbol;
	
procedure leerProducto (var p: producto);
begin
	writeln('INGRESE EL CODIGO DE PRODUCTO');
	readln(p.codigo);
	if (p.codigo <> -1) then begin
		writeln('INGRESE EL RUBRO (1 AL 10)');
		readln(p.rubro);
		writeln('INGRESE EL STOCK');
		readln(p.stock);
		writeln('INGRESE EL PRECIO');
		readln(p.precio);
	end;
end;

procedure iniciarVector (var v: vector);
var
	i: rangoVector;
begin
	for i:= 1 to df do 
		v[i]:= nil;
end;

procedure agregarArbol (var a: arbol; p: producto);
begin
	if (a = nil) then begin	
		new(a);
		a^.dato:= p;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (p.codigo <= a^.dato.codigo) then
			agregarArbol(a^.hi, p)
		else
			agregarArbol(a^.hd, p)
	end;
end;

procedure incisoA (var v: vector);
var
	p: producto;
begin
	leerProducto(p);
	while (p.codigo <> -1) do begin
		agregarArbol(v[p.rubro], p);
		leerProducto(p);
	end;
end;

function buscar (a: arbol; cod: integer): boolean;
begin
	if (a = nil) then 
		buscar:= false
	else begin
		if (a^.dato.codigo = cod) then
			buscar:= true
		else begin
			if (cod > a^.dato.codigo) then
				buscar:= buscar(a^.hd, cod)
			else
				buscar:= buscar(a^.hi, cod)
		end;
	end;
end;


procedure incisoB (v: vector);
var
	rubro: rangoVector;
	cod: integer;
	existe: boolean;
begin
	writeln('INGRESE UN RUBRO Y UN CODIGO Y LE DIRE SI EXISTE ESE CODIGO EN ESE RUBRO');
	writeln('RUBRO: ');
	readln(rubro);
	writeln('CODIGO: ');
	readln(cod);
	existe:= buscar (v[rubro], cod);
	if (existe) then
		writeln('EL CODIGO EXISTE')
	else
		writeln('EL CODIGO NO EXISTE')
end;

function mayor (a: arbol) : arbol;
begin
	if (a = nil) then
		mayor:= nil
	else begin
		if (a^.hd = nil) then
			mayor:= a
		else
			mayor:= mayor (a^.hd)
	end;
end;

procedure incisoC (v: vector);
var
	i: rangoVector;
	x: arbol;
begin
	for i:= 1 to df do begin
		if (v[i] <> nil) then begin
			x:= mayor (v[i]);
			writeln ('RUBRO: ', i);
			writeln('CODIGO MAYOR: ', x^.dato.codigo);
			writeln('STOCK DEL MAYOR: ', x^.dato.stock);
		end;
	end;
end;
		

var
	v: vector;
begin
	iniciarVector(v);
	incisoA(v);
	incisoB(v);
	incisoC(v);
end.
	
	
	
	
	
	
	
	
	
	
	
	
