program ej1practica3;
const
	df = 10;
type
	rango_vector = 0..df;
	
	vector = array[rango_vector] of char;
	
	lista = ^nodo;
	
	nodo= record
		dato: char;
		sig: lista;
	end;

procedure incisoA(var v: vector; var dl: rango_vector);
var
	c: char;
begin
	writeln('ingrese un caracter, para terminar ingrese un punto: ');
	readln(c);
	if (dl<df) and (c <> '.') then begin
		dl:= dl + 1;
		v[dl]:= c;
		incisoA(v,dl);
	end;
end;

procedure incisoB(v:vector;dl: rango_vector);
var
	i: rango_vector;
begin
	for i:= 1 to dl do 
		writeln(v[i]);
end;

procedure incisoC(v:vector; var i:rango_vector;  dl: rango_vector);
begin	
	if (i<=dl) then begin
		i:= i + 1;
		writeln(v[i]);
		incisoC(v,i,dl);
	end;
end;

function incisoD(c:char): integer; // preguntar
begin
	if (c = '.') then
		incisoD:= 0
	else begin
    writeln('ingrese un caracter, para terminar ingrese un punto: ');
    readln(c);
		incisoD:= incisoD(c) + 1;
  end;
end;

procedure incisoE(var l: lista);
var
	c: char;
begin
	writeln('ingrese un caracter, para terminar ingrese un punto: ');
	readln(c);
	if (c <> '.') then begin
		new(l);
		l^.dato:= c;
		l^.sig:= nil;
		incisoE(l^.sig);
	end;
end;

procedure incisoF(l: lista);
begin
	if (l<>nil) then begin
		writeln('el caracter es: ', l^.dato);
		incisoF(l^.sig);
	end;
end;

procedure incisoG(l: lista);
begin
	if (l<>nil) then begin
		incisoG(l^.sig);
		writeln(l^.dato);
	end;
end;

var
	vec: vector;
	dl,i: rango_vector;
	cant: integer;
	l: lista;
  C: CHAR;
begin
	dl:= 0; i:= 0; 
	incisoA(vec,dl);
	incisoB(vec,dl);
	incisoC(vec,i,dl);
  writeln('ingrese un caracter, para terminar ingrese un punto: ');
	readln(c);
	cant:= incisoD(c);
	writeln('la cantidad de caracteres leidos es ', cant);
	incisoE(l);
	incisoF(l);
	incisoG(l);
end.
	
	
	
	
	
	
	
	
	
	
	
	
		
		
