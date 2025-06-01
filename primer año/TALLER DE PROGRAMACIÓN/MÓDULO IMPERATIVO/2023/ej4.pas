program ej4recursion;
type
	
	vector = array [1..20] of integer;
	
procedure CargarVector (var v: vector; var i: integer; NRandom: integer);

begin
	Randomize;
	
	if (i <= 20) then 
	begin
		Nrandom:= Random (100);
		v[i]:=  Nrandom;
		i:= i + 1;
		CargarVector (v,i, NRandom);
	end;
end;

procedure Maximo (v: vector; var max: integer; var i: integer);
	
begin
	i:= i + 1;
	if (i <= 20) then;
	begin
		if (v [i] > max) then
		begin
			max:= v[i];
			maximo (v, max, i);
		end;
	end;	
end;

procedure sumar_vector (v: vector; var suma: integer; i: integer);
	
begin
	i:= i + 1;
	if (i <= 20) then;
	begin
		suma:= suma + v [i];
		sumar_vector (v, suma, i);
	end;
end;
var
	m, i, s, Nrandom: integer;
	vec: vector;

begin
	m:=0; s:= 0; i:= 0; NRandom:= 0;
	CargarVector (vec, i, NRandom);
	writeln ('el vector se cargo ');
	i:= 0;
	Maximo (vec, m, i);
	writeln ('el maximo es  ', m);
	i:= 0;
	sumar_vector (vec, s, i);
	writeln ('la suma de todo el vector es ', s);
end.	
	
	
	
	
	
	
