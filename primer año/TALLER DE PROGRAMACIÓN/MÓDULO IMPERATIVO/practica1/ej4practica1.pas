program ej4practica1;
const
	df = 8;
type
	rango_vector = 1..df;
	
	producto = record
		codigo: integer;
		precio: real;
	end;
	
	lista = ^nodo;
	
	nodo = record
		dato: producto;
		sig: lista;
	end;
	
	vector_rubro = array [rango_vector] of lista;
	
	vector_rubro3 = array [1..30] of producto;

procedure leer_producto (var p: producto);
begin
	writeln('ingrese un codigo de producto: ');
	readln(p.codigo);
	writeln('ingrese un precio: ');
	readln(p.precio);
end;

procedure iniciar_vector (var v: vector_rubro);
var
	i: rango_vector;
begin
	for i:= 1 to df do
		v[i]:= nil
end;

procedure insertar_ordenado (var l: lista; p: producto);
var
	nuevo, actual, anterior: lista;
begin
	new(nuevo);
	nuevo^.dato:= p;
	nuevo^.sig:= nil;
	
	if (l=nil) then
		l:= nuevo
	else begin
		actual:= l;
		anterior:= l;
		while (actual<>nil) and (actual^.dato.codigo < nuevo^.dato.codigo) do begin
			anterior:= actual;
			actual:= actual^.sig;
		end;
		if (actual <> nil) then begin
			if (actual = l) then begin
				nuevo^.sig:= l;
				l:= nuevo;
			end
			else begin
				anterior^.sig:= nuevo;
				nuevo^.sig:= actual;
			end;
		end
		else
			anterior^.sig:= nuevo;
	end;
end;

procedure incisoA (var v: vector_rubro);
var
	p: producto;
	rubro: integer;
begin
	iniciar_vector(v);
	leer_producto(p);
	while (p.precio <> 0) do begin
		writeln('ingrese un rubro: ');
		readln(rubro);
		insertar_ordenado(v[rubro],p);
		leer_producto(p);
	end;
end;

procedure incisoB (v: vector_rubro);
var
	i: rango_vector;
begin
	for i:= 1 to df do begin
		writeln ('codigos de productos del rubro: ',i);
		while (v[i]<>nil) do begin
			writeln(v[i]^.dato.codigo);
			v[i]:=v[i]^.sig;
		end;
	end;
end;

procedure incisoC (v: vector_rubro; var v2: vector_rubro3; var dl:integer);
begin
	dl:= 0;
	while (v[3]<>nil) and (dl<=30) do begin
		dl:= dl+1;
		v2[dl]:= v[3]^.dato;
		v[3]:= v[3]^.sig;
	end;
end;

procedure incisoD (var v: vector_rubro3; dl: integer);
var
	i,j: integer;
	actual: producto;
begin
	for i:= 2 to dl do begin
		actual:= v[i];
		j:= i-1;
		while (j>0) and (v[j].precio > actual.precio) do begin
			v[j+1]:=v[j];
			j:= j-1;
		end;
		v[j+1]:= actual
	end;
end;

procedure incisoE (v: vector_rubro3; dl: integer);
var
	i:integer;
begin
	writeln('los precios del vector ordenado son: ');
	for i:= 1 to dl do
		writeln(v[i].precio)
end;

procedure incisoF (v:vector_rubro3; dl: integer);
var
	suma: real;
	i: integer;
begin
	suma:= 0;
	for i:= 1 to dl do
		suma:= suma + v[i].precio;
	suma:= suma / dl;
	writeln('el promedio de los precios del rubro 3 es: ',suma);
end;
var
	vec1: vector_rubro;
	vec2: vector_rubro3;
	dl: integer;
begin
	incisoA(vec1);
	incisoB(vec1);
	incisoC(vec1,vec2,dl);
	incisoD(vec2,dl);
	incisoE(vec2,dl);
	incisoF(vec2,dl);
end.
	







































