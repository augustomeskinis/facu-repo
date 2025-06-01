program ej1practica4;
type
	venta = record
		codigo_venta: integer;
		codigo_producto: integer;
		uv: integer;
		precio: integer;
	end;
	
	producto = record
		codigo: integer;
		total_uv: integer;
		monto: integer;
	end;
	
	arbol = ^nodo;
	
	nodo = record
		dato: producto;
		hi: arbol;
		hd: arbol;
	end;

procedure leer_venta (var v: venta);
begin
	writeln('ingrese un codigo de venta: ');
	readln(v.codigo_venta);
	writeln('ingrese un codigo de producto: ');
	readln(v.codigo_producto);
	writeln('ingrese la cant de uv: ');
	readln(v.uv);
	writeln('ingrese el precio: ');
	readln(v.precio);
end;

procedure agregar_arbol(var a: arbol; v: venta);
begin
	if (a = nil) then begin
		new(a);
		a^.dato.codigo:= v.codigo_producto;
		a^.dato.total_uv:= v.uv;
		a^.dato.monto:= v.precio;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (a^.dato.codigo = v.codigo_producto) then begin
			a^.dato.total_uv:= a^.dato.total_uv + v.uv;
			a^.dato.monto:= a^.dato.monto + v.precio;
		end
		else begin
			if (a^.dato.codigo < v.codigo_producto) then
				agregar_arbol(a^.hi,v)
			else
				agregar_arbol(a^.hd,v);
		end;
	end;
end;

procedure incisoA (var a: arbol);
var
	v: venta;
begin
	leer_venta(v);
	while (v.codigo_venta <> -1) do begin
		agregar_arbol(a,v);
		leer_venta(v);
	end;
end;

procedure imprimir_arbol(p:producto);
begin
	writeln('codigo de producto: ', p.codigo);
	writeln('total de unidades vendidas: ', p.total_uv);
	writeln('monto total: ', p.monto);
end;

procedure incisoB(a: arbol);
begin
	if (a<>nil) then begin
		incisoB(a^.hi);
		imprimir_arbol(a^.dato);
		incisoB(a^.hd);
	end;
end;

procedure incisoC(a:arbol; var max_cod: integer; var max_uv: integer);
begin
	if (a<>nil)then begin
		incisoC(a^.hi,max_cod,max_uv);
		if (a^.dato.total_uv >= max_uv) then begin
			max_uv:= a^.dato.total_uv;
			max_cod:= a^.dato.codigo;
		end;
		incisoC(a^.hd,max_cod,max_uv);
	end;
end;

procedure menores (a: arbol; cod: integer; var cant: integer);
begin
	if (a <> nil) then begin
		if (a^.dato.codigo >= cod) then 
			menores(a^.hi,cod,cant)
		else begin
			menores(a^.hi,cod,cant);
			cant:= cant + 1;
			menores(a^.hd,cod,cant);
		end;
	end;
end;

procedure incisoD (a: arbol);
var
	codigo, cantidad: integer;
begin
	writeln('INGRESE UN CODIGO Y LE DIRE LA CANTIDAD QUE HAY MENORES QUE EL: ');
	readln(codigo);
	cantidad:=0;
	menores(a,codigo,cantidad);
	writeln('CANTIDAD: ', cantidad);
end;

procedure monto(a: arbol; cod1, cod2: integer; var monto_total: integer);  // PREGUNTAR. COMO HAGO PARA NO INCLUIR LOS CODIGOS? 
begin
	if (a <> nil) then begin
		if (a^.dato.codigo < cod1) then
			monto(a^.hd, cod1, cod2, monto_total)
		else begin
			if (a^.dato.codigo > cod2) then
				monto(a^.hi, cod1, cod2, monto_total)
			else begin
				monto(a^.hi, cod1, cod2, monto_total);
				monto_total := monto_total + a^.dato.monto;
				monto(a^.hd, cod1, cod2, monto_total);
			end;
		end;
	end;
end;

procedure incisoE(a: arbol);
var
	cod1,cod2,monto_total: integer;
begin
	writeln('INGRESE DOS CODIGOS, DEVOLVERE EL MONTO TOTAL ENTRE ELLOS: ');
	writeln('1er codigo: ');
	readln(cod1);
	writeln('2do codigo: ');
	readln(cod2);
	monto_total:=0;
	monto(a,cod1,cod2,monto_total);
	writeln('MONTO TOTAL: ', monto_total);
end;

var
	abb: arbol;
	max_cod, max_uv: integer;
begin
	abb:= nil;
	max_cod:= 0; max_uv:= -1;
	incisoA(abb);
	incisoB(abb);
	incisoC(abb,max_cod,max_uv);
	writeln('el codigo de producto con mayor cantidad de uv es: ', max_cod);
	incisoD(abb);
	incisoE(abb);
end.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
