program ej1p4;

type

	venta = record
		codv: integer;
		codp: integer;
		uv: integer;
		precio: integer;
	end;
	
	lista = ^nodo;
	
	nodo = record
		dato: venta;
		sig: lista;
	end;
	
	
	producto = record
		codigo: integer;
		cantidadUV : integer;
		monto: integer;
	end;
	
	
	
	arbol = ^nodo2;
	
	nodo2 = record
		dato: producto;
		hi: arbol;
		hd: arbol;
	end;
	

procedure leer_venta (v: venta);
begin
	writeln (' ingrese el codigo de venta: ');
	readln (v.codv);
	writeln (' ingrese el codigo de producto: ');
	readln (v.codp);
	writeln (' ingrese la cantidad de unidades vendidas: ');
	readln (v.uv);
	writeln (' ingrese el precio unitario: ');
	readln (v.precio);
end;


procedure agregar_adelante (var L: lista; v: venta);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.dato:= v;
	nuevo^.sig:= nil;

	if (L = nil) then
		L:= nuevo
	else
		nuevo^.sig:= L;
		L:= nuevo;
end;

procedure cargar_lista (var L: lista) ;
var
	v: venta;
begin
	v.codv:= 0; v.codp:= 0; v.uv:= 0; v.precio:= 0;
	leer_venta (v);
	while (v.codv <> -1) do begin
		agregar_adelante (L, v);
		leer_venta (v);
	end;
end;

procedure agregar_arbol (var a:arbol; c, uv, m :integer);
Begin
  if (a = nil) then
   begin
      new(a);
      a^.dato.codigo:= c;
      a^.dato.cantidadUV:= uv;
      a^.dato.monto:= m;
      a^.HI:= nil;
      a^.HD:= nil;
   end
   else
    if (c <= A^.dato.codigo) then 
		agregar_arbol(a^.HI,c, uv, m)
    else 
		agregar_arbol (a^.HD,c, uv, m)   
End;
		
function calcular_monto (c, p: integer) : integer ;
begin
	calcular_monto:= c * p 
end;


procedure cargar_arbol (L: lista; var a: arbol ) ;
var
	m: integer;
begin
	while (L <> nil) do
	begin
		m:= calcular_monto (L^.dato.uv, L^.dato.precio);
		agregar_arbol (a, L^.dato.codp, L^.dato.uv, m);
	end;
end;

procedure imprimir (p: producto);
begin
	writeln (' el codigo del producto es: ', p.codigo);
	writeln (' la cantidad de unidades vendidas es: ', p.cantidadUV);
	writeln (' el monto es: ', p.monto);
end;

procedure imprimir_arbol (a: arbol);
begin
	if (a <> nil) then
	begin
		imprimir_arbol (a^.hi);
		imprimir (a^.dato);
		imprimir_arbol (a^.hd);
	end;
end;

var
	lis: lista;
	A: arbol;
begin
	lis:= nil; A:= nil;
	cargar_lista (lis);
	cargar_arbol (lis, A);
	imprimir_arbol (A);
end.
















