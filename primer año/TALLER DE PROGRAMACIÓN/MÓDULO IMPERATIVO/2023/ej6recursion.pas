program ej6recursion;

type
	
	lista = ^nodo;
	
	nodo = record
		dato: integer;
		sig: lista;
	end;

procedure agregar_adelante (var L:lista; num: integer);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.dato:= num;
	nuevo^.sig:= nil;
	
	if (L = nil) then
		L:= nuevo
	else
	begin
		nuevo^.sig:= L;
		L:= nuevo;
	end;
end;




procedure imprimir_binario (l: lista);
begin
	while (l <> nil) do begin
		write (l^.dato);
		l:= l^.sig;
	end;
end;

procedure calcular_binario (var x: integer; L: lista);
var
	resto: integer;
begin
	resto:= x MOD 2;
	agregar_adelante (L, resto);
	x:= x DIV 2;
	
	if (x <> 0) then 
		calcular_binario (x, L)
	else
	begin
		write ('su binario es : ');
		imprimir_binario (L);
	end;
end;


	

var
	lis: lista;
	num: integer;
begin
	lis:= nil;

	write ('ingrese el numero decimal ');
	read (num);
	if (num <> 0) then
		calcular_binario (num, lis);
end.	
