program parcial12092023;
type
	rangoCodigo = 1..15;
	rangoMes = 0..12;
	atencion = record
		DNI: integer;
		mes: rangoMes;
		codigo: rangoCodigo;
	end;
	
	registroArbol = record
		DNI: integer;
		atenciones: integer;
	end;
	
	arbol =^nodoArbol;
	
	nodoArbol = record
		dato: registroArbol;
		hi: arbol;
		hd: arbol;
	end;
	
	vector = array [rangoCodigo] of integer;
	
procedure leerAtencion(var aten: atencion);
begin
	aten.mes:= Random(12);
	if(aten.mes <> 0) then begin
		aten.DNI:=Random(1000);
		aten.codigo:=Random(15)+1;
	end;
end; 
procedure iniciarVector(var v: vector);
var
	i:rangoCodigo;
begin
	for i:= 1 to 15 do 
		v[i]:=0;
end;
procedure agregarArbol(var a: arbol; aten:atencion);
begin
	if(a=nil) then begin
		new(a);
		a^.dato.DNI:= aten.DNI;
		a^.dato.atenciones:= 1;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else begin
		if(aten.DNI = a^.dato.DNI)then
			a^.dato.atenciones:= a^.dato.atenciones + 1
		else begin
			if(aten.DNI < a^.dato.DNI)then
				agregarArbol(a^.hi,aten)
			else
				agregarArbol(a^.hd,aten)
		end;
	end;
end;
procedure incisoA(var a: arbol; var v: vector);
var
	aten:atencion;
begin
	a:= nil;
	iniciarVector(v);
	leerAtencion(aten);
	while(aten.mes <> 0) do begin
		agregarArbol(a,aten);
		v[aten.codigo]:= v[aten.codigo]+1;
		leerAtencion(aten);
	end;
end;
procedure recorrerArbol(a:arbol;dni1:integer;dni2:integer;x:integer;var cant:integer);
begin
	if(a<>nil)then begin
		if(dni1 > a^.dato.DNI)then
			recorrerArbol(a^.hi,dni1,dni2,x,cant)
		else begin
			if (dni2 > a^.dato.DNI) then begin
				recorrerArbol(a^.hi,dni1,dni2,x,cant);
				if(a^.dato.atenciones > x) then
					cant:=cant + 1;
				recorrerArbol(a^.hd,dni1,dni2,x,cant);
			end;
		end;
	end;
end;		
procedure incisoB(a: arbol);
var
	DNI1,DNI2,x,cant:integer;
begin
	writeln('INGRESE UN DNI');
	readln(DNI1);
	writeln('INGRESE OTRO DNI');
	readln(DNI2);
	writeln('INGRESE UN VALOR X');
	readln(x);
	cant:=0;
	recorrerArbol(a,DNI1,DNI2,x,cant);
	writeln('La cantidad de pacientes con mas de ',x, ' atenciones es: ', cant);
end;
procedure recorrerVector(v: vector; var i: integer; var cant: integer);
begin
	if (i <= 15) then begin
		if (v[i] = 0)then
			cant:= cant + 1;
		i:= i + 1;
		recorrerVector(v,i,cant)
	end;
end;
procedure incisoC(v:vector);
var
	i,cant:integer;
begin
	i:=0; cant:=0;
	recorrerVector(v,i,cant);
	writeln('La cantidad de pacientes sin atenciones es: ', cant);
end;
var
	abb: arbol;
	vec: vector;
begin
	incisoA(abb,vec);
	incisoB(abb);
	incisoC(vec);
end.










		
