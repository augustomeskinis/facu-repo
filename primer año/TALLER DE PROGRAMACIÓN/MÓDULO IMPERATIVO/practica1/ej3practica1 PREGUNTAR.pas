program ej3practica1;
const
	df = 8;
type
	rango_vector = 0..df;
	
	pelicula = record
		cod_pelicula: integer;
		cod_genero: integer;
		puntuaje: real;
	end;
	
	lista = ^nodo;
	
	nodo = record
		dato: pelicula;
		sig: lista;
	end;
	
	vector_generos = array [rango_vector] of lista;
	
	vector_codigos = array [rango_vector] of integer;

	
procedure leer_pelicula (var p:pelicula);
begin
	writeln ('ingrese un codigo: ');
	readln(p.cod_pelicula);
	writeln ('ingrese un genero: ');
	readln(p.cod_genero);
	writeln('ingrese un puntuaje: ');
	readln(p.puntuaje);
end;


procedure agregar_atras (var l: lista; p: pelicula);
var
	nuevo, aux: lista;
begin
	new (nuevo);
	nuevo^.dato:= p;
	nuevo^.sig:= nil;
	
	if (l=nil) then
		l:= nuevo
	else begin
		aux:= l;
		while (aux^.sig <> nil) do
			aux:= aux^.sig;
		aux^.sig:= nuevo;
	end;
end;


procedure iniciar_vector (var v: vector_generos);
var
	i: rango_vector;
begin
	for i:= 1 to df do
		v[i]:= nil
end;


procedure incisoA (var v: vector_generos);
var
	p: pelicula;
begin
	iniciar_vector(v);
	leer_pelicula(p);
	while (p.cod_pelicula <> 0) do begin
		agregar_atras (v[p.cod_genero],p);
		leer_pelicula(p);
	end;
end;

function calcular_maximo (l: lista): integer;
var
	max: real;
	maxcod: integer;
begin
	max:= -1; 
	maxcod:= 0;
	while (l<>nil) do begin
		if (l^.dato.puntuaje >= max) then begin
			max:= l^.dato.puntuaje;
			maxcod:= l^.dato.cod_pelicula;
		end;
		l:= l^.sig;
	end;
	calcular_maximo:= maxcod;
end;


procedure incisoB (v1: vector_generos; var v2: vector_codigos);
var
	i: rango_vector;
begin
	for i:= 1 to df do 
		v2[i]:= calcular_maximo(v1[i]);
end;

procedure incisoC (var v: vector_codigos);
var
	i,j,pos: integer;
	item: integer;
begin
	for i:= 1 to df-1 do begin
		pos:= i;
		for j:= i+1 to df do 
			if (v[j] < v[pos]) then
				pos:= j;
		item:= v[pos];
		v[pos]:= v[i];
		v[i]:= item;
	end;
end;

procedure incisoD (v: vector_codigos);
begin
	writeln('el codigo con menor puntuaje es: ', v[1]);
	writeln('el codigo con mayor puntuaje es: ', v[df]);
end;

var
	vec1: vector_generos;
	vec2: vector_codigos;
begin
	incisoA(vec1);
	incisoB(vec1,vec2);
	incisoC(vec2);
	incisoD(vec2);
end.

































