program ej3practica2;
type
	rango_numero = 0..100;
	
	lista = ^nodo;
	
	nodo = record
		dato: rango_numero;
		sig: lista;
	end;
	
procedure incisoA (var l: lista);
var
	n: integer;
begin
	Randomize;
	n:= Random (100);
	if (n>0) then begin
		new(l);
		l^.dato:= n;
		l^.sig:= nil;
		incisoA(l^.sig);
	end;
end;

procedure incisoB (l: lista; var min: integer);
begin
	if (l<>nil) then begin
		if (l^.dato < min) then
			min:= l^.dato;
		incisoB(l^.sig, min);
	end;
end;

procedure incisoC (l: lista; var max: integer);
begin
	if (l<>nil) then begin
		if(l^.dato > max) then
			max:= l^.dato;
		incisoC(l^.sig,max);
	end;
end;

var
	min, max: integer;
	l: lista;
begin
	min:= 101; max:= -1;
	incisoA(l);
	incisoB(l,min);
	writeln(min);
	incisoC(l,max);
	writeln(max);
end.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
