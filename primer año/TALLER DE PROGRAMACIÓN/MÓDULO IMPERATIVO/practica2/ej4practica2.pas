program ej4practica2;
const
	df = 20;
type
	rango_vector = 1..df;
	rango_numeros = 1..100;
	vector = array [rango_vector] of rango_numeros;

procedure incisoA (var v: vector; i: integer);
begin
	if (i<=df)then begin
		Randomize;
		v[i]:= Random(100);
		incisoA(v,i+1);
	end;
end;

procedure incisoB (v:vector; var max: integer; i: integer);
begin
	if (i<=df) then begin
		if (v[i] > max) then 
			max:= v[i];
		incisoB(v,max,i+1);
	end;
end;
		
procedure incisoC (v:vector; var suma: integer; i: integer);
begin
	if (i<=df) then begin
		suma:= suma + v[i];
		incisoC(v,suma,i+1);
	end;
end;

var
	i,suma, max: integer;
	v: vector;
begin
	i:= 0; max:= -1; suma:= 0;
	incisoA(v,i);
	incisoB(v,max,i);
	writeln(max);
	incisoC(v,suma,i);
	writeln(suma);
end.
		
		
		
		
		
		
		
		
		
		
		
		
		
