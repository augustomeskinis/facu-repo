program probando;
type
	arbol = ^nodo;
	
	nodo = record
		dato: integer;
		hi: arbol;
		hd: arbol;
	end;

procedure agregarArbol (var a: arbol; num: integer);
begin
	if (a = nil) then begin
		new(a);
		a^.dato:= num;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (num <= a^.dato) then
			agregarArbol(a^.hi, num)
		else
			agregarArbol(a^.hd, num)
	end;
end;



procedure postOrden (a: arbol);
begin
	if (a<>nil) then begin
		postOrden(a^.hi);
		postOrden(a^.hd);
		writeln(a^.dato);
	end;
end;
	
var
	num: integer;
	abb: arbol;
begin
	abb:= nil;
	writeln('INGRESE NUMEROS');
	readln(num);
	while (num <> -1) do begin
		agregarArbol(abb,num);
		writeln('INGRESE NUMEROS');
		readln(num);
	end;
	postOrden(abb);
end.
