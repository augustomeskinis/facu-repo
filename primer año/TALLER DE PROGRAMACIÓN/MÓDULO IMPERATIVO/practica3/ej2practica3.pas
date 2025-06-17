program ej2practica3;
type
	venta = record
		codigo: integer;
		fecha: integer;
		uv: integer;
	end;
	
	arbol_ventas = ^nodo;
	
	nodo = record
		dato: venta;
		hi: arbol_ventas;
		hd: arbol_ventas;
	end;
	
	productos_vendidos = record
		codigo: integer;
		totaluv: integer;
	end;
	
	arbol_productos = ^nodo2;
	
	nodo2 = record
		dato: productos_vendidos;
		hi: arbol_productos;
		hd: arbol_productos;
	end;
	
procedure leer_venta (var v: venta);
begin
	writeln('ingrese un codigo de producto: ');
	readln(v.codigo);
	writeln('ingrese una fecha: ');
	readln(v.fecha);
	writeln('ingrese la cantidad de unidades vendidas: ');
	readln(v.uv);
end;

procedure agregar_arbol_ventas (var a: arbol_ventas; v: venta);
begin
	if (a = nil) then begin
		new(a);
		a^.dato:= v;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (v.codigo <= a^.dato.codigo) then
			agregar_arbol_ventas(a^.hi,v)
		else
			agregar_arbol_ventas(a^.hd,v)
	end;
end;
procedure agregar_arbol_productos (var a: arbol_productos; codigo: integer; uv: integer);
begin
	if (a=nil) then begin
		new(a);
		a^.dato.codigo:= codigo;
		a^.dato.totaluv:= uv;
	end
	else begin
		if (codigo = a^.dato.codigo) then
			a^.dato.totaluv:= a^.dato.totaluv + uv
		else begin
			if (codigo < a^.dato.codigo) then
				agregar_arbol_productos(a^.hi,codigo,uv)
			else
				agregar_arbol_productos(a^.hd,codigo,uv)
		end;
	end;
end;
	
	
procedure cargar_arboles (var a: arbol_ventas; var a2: arbol_productos);
var
	v: venta;
begin
	leer_venta(v);
	while (v.codigo <> 0) do begin
		agregar_arbol_ventas(a,v);
		agregar_arbol_productos(a2,v.codigo,v.uv);
		leer_venta(v);
	end;
end;

function busqCant1(a: arbol_ventas; busq: integer):integer;
var
	aux: integer;
begin
    if (a = nil) then
        busqCant1:= 0 //Valor no encontrado
    else if (a^.dato.codigo = busq) then
    begin
        aux:= a^.dato.uv;
        busqCant1:= busqCant1(a^.hi, busq) + aux;
    end
    else if (busq > a^.dato.codigo) then
        busqCant1:= busqCant1(a^.hd, busq)
    else
        busqCant1:= busqCant1(a^.hd, busq);
end;

function busqCant2(a: arbol_productos; busq: integer):integer;
begin
    if (a = nil) then
        busqCant2:= 0 //Valor no encontrado
    else if (a^.dato.codigo = busq) then
        busqCant2:= a^.dato.totaluv
    else if (busq > a^.dato.codigo) then
        busqCant2:= busqCant2(a^.hd, busq)
    else
        busqCant2:= busqCant2(a^.hi, busq);
end;

var
	abb1: arbol_ventas;
	abb2: arbol_productos;
	codigo: integer;
begin
	abb1:= nil; abb2:= nil;
	cargar_arboles(abb1,abb2);
	writeln('ingrese un codigo y le dire las uv: ');
	readln(codigo);
	writeln(busqCant1(abb1,codigo));
	writeln(busqCant2(abb2,codigo));
end.












	
