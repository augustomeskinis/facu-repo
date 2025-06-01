program ej1practica5;  // PREGUNTAR: POR QUE DEVUELVE DNI NEGATIVO? QUE ESTA MAL DE LOS MODULOS SELECCION E INSERCION?
const 
	df = 300;
type
	rangoVector = 1..df;
	
	oficina = record
		codigoID: integer;
		dni: integer;
		valorExpensa: integer;
	end;
	
	vector = array [rangoVector] of oficina;
	
procedure leerOficina (var o: oficina);
begin
	writeln('INGRESE UN CODIGO DE IDENTIFICACION');
	readln(o.codigoID);
	if (o.codigoID <> -1) then begin
		writeln('INGRESE DNI DEL PROPIETARIO');
		readln(o.dni);
		writeln('INGRESE EL VALOR DE EXPENSA');
		readln(o.valorExpensa);
	end;
end;

procedure agregarVector (var v: vector; var dl: integer; o: oficina);
begin
	if (dl+1 <= df) then begin
		dl:= dl + 1;
		v[dl]:= o;
	end;
end;


procedure incisoA (var v: vector; var dl: integer);
var
	o: oficina;
begin
	leerOficina(o);
	while (o.codigoID <> -1) and (dl <= df) do begin
		agregarVector(v,dl,o);
		leerOficina(o);
	end;
end;

procedure seleccion (var v: vector; dl: integer);
var
	i, j, pos: integer;
	item: oficina;
begin
	for i:= 1 to (dl-1) do begin
		pos:= i;
		for j:= i+1 to dl do begin
			if (v[j].codigoID < v[pos].codigoID) then
				pos:= j;
		end;
		item:= v[pos];
		v[pos]:= v[i];
		v[i]:= item;
		writeln(item.codigoID);
	end;
end;

{procedure insercion (var v: vector; dl: rangoVector);
var
	i,j: integer;
	actual: oficina;
begin
	for i:= 2 to dl do begin
		actual:= v[i];
		j:= i-1;
		while (j > 0) and (v[i].codigoID > actual.codigoID) do begin
			v[j+1]:= v[j];
			j:= j-1;
		end;
		v[j+1]:= actual;
	end;
end;}
	

function incisoC (v: vector; dl: integer; codigo: integer) : integer;
var
	pri, ult, medio: integer;
begin
	pri:= 1;
	ult:= dl;
	
	medio:= (pri + ult) div 2;
	
	while (pri <= ult) and (codigo <> v[medio].codigoID) do begin
		if (codigo < v[medio].codigoID) then
			ult:= ult - 1
		else
			pri:= pri + 1;
		medio:= (pri + ult) div 2;
	end;
	
	if (pri <= ult) and (codigo = v[medio].codigoID) then
		incisoC:= medio
	else
		incisoC:= 0
end;

procedure imprimirVector (v: vector; dl: integer);
var
	i: rangoVector;
begin
	for i:= 1 to dl do begin
		writeln('CODIGO DE IDENTIFICACION: ', v[i].codigoID);
		writeln('DNI DEL PROPIETARIO: ', v[i].dni);
		writeln('VALOR DE LA EXPENSA: ', v[i].valorExpensa);
	end;
end;

procedure monto (v: vector; dl: integer; var i: integer; var m: integer);
begin
	if (i <= dl) then begin
		m:= m + v[i].valorExpensa;
		i:= i + 1;
		monto(v,dl,i,m);
	end;
end;


var
	vec: vector;
	dl, codigo, pos, i, m: integer;
begin
	dl:= 0;
	incisoA(vec,dl);
	seleccion(vec,dl);
	imprimirVector(vec,dl);
	writeln('INGRESE UN CODIGO Y DEVOLVERE EL DNI');
	readln(codigo);
	pos:= incisoC(vec,dl,codigo);
	if (pos <> 0) then
		writeln('DNI DEL PROPIETARIO: ', vec[pos].dni)
	else
		writeln('NO SE HA ENCONTRADO LA OFICINA');
	i:= 1;
	monto(vec,dl,i,m);
	writeln('MONTO TOTAL: ', m);
end.
	
	
	
	
	
	
	
	
	
	
	
	
