program ej1repaso;
const
	df = 50;
type
	rango_vector = 0..df;
	rango_cod = 1..15;
	rango_cant = 1..99;
	
	venta = record
		dia: integer;
		codigo: rango_cod;
		cantidad_vendida: rango_cant;
	end;
	
	vector = array [rango_vector] of venta;

procedure incisoA (var v: vector; var dl: rango_vector);
var
	dia: integer;
begin
	writeln('ingrese un dia: ');
	readln (dia);
	while ((dl<df) and (dia <>0)) do begin
		dl:= dl+1;
		v[dl].dia:= dia;
		Randomize;
		v[dl].codigo:= Random(50);
		writeln('ingrese una cantidad: ');
		readln(v[dl].cantidad_vendida);
		writeln('ingrese un dia: ');
		readln(dia);
	end;
end;

procedure incisoB (v: vector; dl: rango_vector);
var
	i: rango_vector;
begin
	for i:= 1 to dl do begin
		writeln ('el dia es: ',v[i].dia);
		writeln('el codigo es: ',v[i].codigo);
		writeln('la cantidad es: ',v[i].cantidad_vendida);
	end;
end;

procedure incisoC (var v: vector; dl: integer);
var
	i,j,pos:integer;
	item: venta;
begin
	for i:= 1 to (dl-1) do begin
		pos:= i;
		for j:= i+1 to dl do begin
			if(v[j].codigo<v[i].codigo)then
				pos:= j;
			item:= v[pos];
			v[pos]:= v[i];
			v[i]:= item;
		end;
	end;
end;

procedure incisoE (var v: vector; var dl: rango_vector; cod1: rango_cod; cod2: rango_cod);
var
	dist, cont: integer;
begin
	dist:= 0;
	cont:= 1;
	while (v[cont].codigo < cod1) do
	begin
		cont:= cont + 1;
	end;
	while (v[cont].codigo < cod2) do
	begin
		dist:= dist + 1;
		cont:= cont + 1;
	end;
	while (cont < dl) do
	begin
		v[(cont-dist)]:= v[cont];
		cont:= cont + 1;
	end;
end;
			
function es_par (num:rango_cod): boolean;
begin
	es_par:= (num MOD 2 = 0);
end;

procedure incisoG (v:vector; dl:rango_vector);
var
	i: rango_vector;
	suma: integer;
begin
	suma:= 0;
	for i:= 1 to dl do begin
		if (es_par(v[i].codigo)) then begin
			writeln(v[i].dia);
			writeln(v[i].codigo);
			writeln(v[i].cantidad_vendida);
		suma:= suma + v[i].cantidad_vendida;
		end;
	end;
end;
var
	v: vector;
	dl,cod1,cod2: rango_vector;
begin
	dl:=0; cod1:=0; cod2:=0;
	incisoA(v,dl);
	incisoB(v,dl);
	incisoC(v,dl);
	incisoB(v,dl);
	incisoE(v,dl,cod1,cod2);
	incisoB(v,dl);
	incisoG(v,dl);
	incisoB(v,dl);
end.
















