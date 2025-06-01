program finalJulio.pas;
type
	rangoImportancia = 1..5;
	rangoSector = 1..50;
	
	llamada = record
		nivelImportancia: rangoImportancia;
		sectorEmpresa: rangoSector;
		empleadosAfectados: integer;
	end;
	
	problema = record
		sectorEmpresa: rangoSector;
		empleadosAfectados: integer;
	end;
	

	lista = ^nodoLista;
	
	nodoLista = record
		dato: problema;
		sig: lista;
	end;
	
	vector = array [rangoImportancia] of lista;

	
	arbol = ^nodoArbol;
	
	nodoArbol = record
		dato: problema;
		hi: arbol;
		hd: arbol;
	end;
procedure leerLlamada(var ll: llamada);
begin
	ll.nivelImportancia:= Random(5)+1;
	ll.sectorEmpresa:= Random(50)+1;
	ll.empleadosAfectados:= Random(10);
end;
procedure iniciarVector(var v: vector);
var
	i: rangoImportancia;
begin
	for i:= 1 to 5 do
		v[i]:= nil
end;
procedure insertarOrdenado(var l: lista; ll: llamada);
var
	nuevo, ant, act: lista;
begin
	new(nuevo);
	nuevo^.dato.sectorEmpresa:= ll.sectorEmpresa;
	nuevo^.dato.empleadosAfectados:= ll.empleadosAfectados;
	act:=l;
	while ((act <> nil) and (act^.dato.sectorEmpresa < ll.sectorEmpresa)) do begin
		ant:= act;
		act:= act^.sig;
	end;
	if (act = l) then
		l:= nuevo
	else
		ant^.sig:= nuevo;
	nuevo^.sig:= act;
end;
procedure incisoA(var v: vector);
var
	ll:llamada;
	i: integer;
begin
	iniciarVector(v);
	leerLlamada(ll);
	for i:= 1 to 100 do begin
		insertarOrdenado(v[ll.nivelImportancia],ll);
		leerLlamada(ll);
	end;
end;
procedure agregarArbol (var a: arbol; p: problema);
begin
	if(a=nil) then begin
		new(a);
		a^.dato:= p;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else begin
		if (p.empleadosAfectados <= a^.dato.empleadosAfectados) then
			agregarArbol(a^.hi,p)
		else
			agregarArbol(a^.hd,p)
	end;
end;
procedure incisoB(var a: arbol; v: vector; N: rangoImportancia);
begin
	while (v[N]<>nil) do begin
		agregarArbol(a,v[N]^.dato);
		v[N]:= v[N]^.sig;
	end;

end;
function maxNodo(a: arbol):arbol;
begin
	if(a=nil)then
		maxNodo:=nil
	else begin
		if(a^.hd=nil)then
			maxNodo:=a
		else
			maxNodo:=maxNodo(a^.hd)
	end;
end;
procedure incisoC (a: arbol);
var
	x: arbol;
begin
	x:=maxNodo(a);
	writeln('SECTOR CON MAS EMPLEADOS AFECTADOS: ',x^.dato.sectorEmpresa, ', EMPLEADOS AFECTADOS: ',x^.dato.empleadosAfectados);
end;
var
	abb:arbol;
	vec:vector;
begin
	incisoA(vec);
	abb:=nil;
	incisoB(abb,vec,3);
	incisoC(abb);
end.
