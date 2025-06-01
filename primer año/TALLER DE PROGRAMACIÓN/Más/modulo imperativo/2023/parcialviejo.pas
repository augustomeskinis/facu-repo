program parcial;
type

	compra = record
		cod_juego: integer;
		cod_cliente: integer;
		dia: integer;
		mes: integer;
	end;
	
	lista = ^nodolista;
	
	cliente = record
		codigo: integer;
		compra: lista;
	end;
	
	
	nodolista = record
		dato: compra;
		sig: lista;
	end;
	
	
	arbol = ^nodoarbol ;
	
	nodoarbol = record
		dato: cliente;
		hi: arbol;
		hd: arbol;
	end;
	
	vector_cantidad = array [1..12] of integer;
	
	
procedure leer_compra (var c: compra);
begin
	writeln ('ingrese el codigo de videojuego: ');
	readln (c.cod_juego);
	writeln ('ingrese el codigo de cliente: ');
	readln (c.cod_cliente);
	writeln ('ingrese el dia: ');
	readln (c.dia);
	writeln ('ingrese el mes: ');
	readln (c.mes);
end;

procedure inicializar_vector (var v: vector_cantidad);
var
	i: integer;
begin
	for i:= 1 to 12 do
		v [i]:= 0
end;

procedure agregar_adelante (var l: lista; c: compra);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.dato:= c;
	nuevo^.sig:= nil;
	
	if (l = nil) then
		l:= nuevo
	else begin
		nuevo^.sig:= l;
		l:= nuevo;
	end;
end;

procedure agregar (var a: arbol; c: compra);
begin
	if (a = nil) then
	begin
		new (a);
		a^.dato.codigo:= c.cod_cliente;
		a^.dato.compra:= nil;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else
	begin
		if (c.cod_cliente = a^.dato.codigo) then
			agregar_adelante (a^.dato.compra, c)
		else
			if (c.cod_cliente < a^.dato.codigo) then
				agregar (a^.hi, c)
			else
				agregar (a^.hd, c)
	end;
end;
		



procedure procesar_compras (var a: arbol; var v: vector_cantidad);
var
	c: compra;
begin
	a:= nil;
	inicializar_vector (v);
	leer_compra (c);
	while (c.cod_cliente <> 0) do begin
		agregar (a, c);
		v [c.mes]:= v [c.mes] + 1;
		leer_compra (c);
	end;
end;


function buscar_codigo (a:arbol; cod:integer): boolean; 

begin
  if (a = nil) then
	buscar_codigo:= false
  else 
	if (a^.dato.codigo = cod) then 
		buscar_codigo:= true

	else 
		if (cod > a^.dato.codigo) then 
			buscar_codigo:= buscar_codigo(a^.hd, cod)
		else 
			buscar_codigo:=  buscar_codigo(a^.hi, cod)
end;



procedure devolver_compras (a: arbol; cod: integer);
begin
	if (buscar_codigo (a, cod) = true) then
	begin
		while (a^.dato.compra <> nil) do begin
			writeln (a^.dato.compra^.dato.cod_juego);
			writeln (a^.dato.compra^.dato.cod_cliente);
			writeln (a^.dato.compra^.dato.dia);
			writeln (a^.dato.compra^.dato.mes);
			a^.dato.compra:= a^.dato.compra^.sig;
		end;
	end
	else
		writeln ('no se encontro el codigo');
end;

Procedure seleccion ( var v: vector_cantidad; dimLog: integer);

var
 i, j, pos, item: integer;
		
begin
 for i:=1 to dimLog-1 do begin 
          pos := i;
          for j := i+1 to dimLog do
             if v[ j ] < v[ pos ] then pos:=j;

         
         item := v[ pos ];   
         v[ pos ] := v[ i ];   
         v[ i ] := item;
      end;
end;


procedure imprimir_vector (v: vector_cantidad);
var
	i: integer;
begin
	for i:= 1 to 12 do
		writeln (v[i])
end;

		
var
	abb: arbol;
	v: vector_cantidad;
	cod: integer;
	dl: integer;
begin
	procesar_compras (abb, v);
	writeln ('ingrese un codigo de cliente y le devolvere los datos de sus compras: ');
	readln (cod);
	devolver_compras (abb, cod);
	dl:= 12;
	seleccion (v, dl);
	imprimir_vector (v);
end.






	
