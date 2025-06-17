program ej2p1;
const
	df = 300;
type
	rango_vector = 0..df;
	
	oficina = record
		codigo: integer;
		dni: integer;
		expensa: integer;
	end;
	
	vector = array [rango_vector] of oficina;

procedure leer_oficina (var o: oficina);
begin
	writeln('ingrese un codigo: ');
	readln(o.codigo);
	writeln('ingrese un dni: ');
	readln(o.dni);
	writeln('ingrese un valor de expensa: ');
	readln(o.expensa);
end;

procedure cargar_vector (var v: vector; var dl: rango_vector);
var
	o:oficina;
begin
	leer_oficina(o);
	while (o.codigo <> -1) do begin
		dl:= dl + 1;
		v[dl]:= o;
		leer_oficina (o);
	end;
end;

procedure insercion (var v: vector; dl: integer);
var
	i,j: integer;
	actual: oficina;
begin
	for i:= 2 to dl do begin
		actual:= v[i];
		j:= i-1;
		
		while (j>0) and (v[j].codigo > actual.codigo) do begin
			v[j+1]:= v[j];
			j:= j-1;
		end;
		v[j+1]:= actual;
	end;
end;

procedure seleccion (var v: vector; dl: rango_vector);
var
	i,j,pos: integer;
	item: oficina;
begin
	for i:= 1 to (dl-1) do begin
		pos:= i;
		for j:= i+1 to dl do begin
			if (v[j].codigo < v[pos].codigo) then
				pos:= j;
		item:= v[pos];
		v[pos]:= v[i];
		v[i]:= item;
		end;
	end;
end;

var
	v: vector;
	dl: rango_vector;
begin
	cargar_vector(v,dl);
	insercion(v,dl);
	seleccion(v,dl);
end.	
		
		
		
		













