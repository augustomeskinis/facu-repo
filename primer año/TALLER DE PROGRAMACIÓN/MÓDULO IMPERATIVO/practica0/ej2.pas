program ej2practica0
const
	cant_zonas = 5;
type
	zonas: 1..cant_zonas;
	
	propiedad = record;
		cod: integer;
		tipo: integer;
		precio: real;
		metros: real;
	end;

	lista = ^nodo;
	nodo = record;
		dato: propiedad;
		sig: lista;
	end;
	
	lista2 = ^nodo2;
	nodo2 = record;
		dato: integer;
		sig: lista2;
	end;
		
	vector = array [zonas] of lista;
	
procedure leer_propiedad(var p: propiedad; var zona: zonas);
begin
	readln(p.cod);
	readln(p.tipo);
	readln(p.precio);
	readln(p.metros);
	readln(zona);
end;

Procedure insertarOrdenado ( var pri: lista; p: propiedad);
var ant, nue, act: lista;
begin
 new (nue);
 nue^.dato := p;
 act := pri;
 while (act<>NIL) and (act^.dato.tipo < p.tipo) do begin
 ant := act;
 act := act^.sig ;
 end;
 if (act = pri) then pri := nue 
 else ant^.sig := nue;
 nue^.sig := act ;
end;

procedure procesar_lista(var v: vector);
var
	p: propiedad;
	z: zonas;
begin
	leer_propiedad(p, z);
	while (p.precio <> -1) do
	begin
		insertarOrdenado(v[z], p);
		leer_propiedad(p, z);
	end;
end;

procedure insertarLista (l: lista; var l2: lista2);
var
	nuevo: lista2;
begin
	new(nuevo);
	nuevo^.dato:= l^.dato.cod;
	nuevo^.sig:= nil;
	if (l2 = nil);
		l2:= nuevo;
	else
		nuevo^.sig:= l2;
		l2:= nuevo;
end;
	
procedure generar_listaB(l: lista; t: integer; var l2: lista2);	
begin
	l2:= nil;
	while (l^.dato.tipo <= t) do
	begin
		if (l^.dato.tipo = t) then
			insertarLista(l, l2);
		l:= l^.sig;
	end;
end;

var
	lis2: lista2;
	vec: vector;
	z:zonas; t: integer;
begin
	lis:= nil; lis2:= nil;
	procesar_lista (vec);
	readln(z);
	readln(t);
	generar_listaB (vec[z],t,lis2);
end.



	
	
	
	
		
	
	
	
	
