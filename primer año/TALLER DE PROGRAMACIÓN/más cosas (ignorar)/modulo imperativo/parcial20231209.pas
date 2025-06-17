program parcial2023;
const
	df = 15;
type
	rangoM = 0..12;
	rangoD = 1..df;
	
	atencion = record
		dni: integer;
		mes: rangoM;
		diagnostico: rangoD;
	end;
	
	paciente = record
		dni: integer;
		cant: integer;
	end;
	
	arbol = ^nodo;
	
	nodo = record
		dato: paciente;
		hi: arbol;
		hd: arbol;
	end;
	
	vector = array [rangoD] of integer;

procedure leerAtencion(var a: atencion);
begin
	writeln('INGRESE UN MES');
	readln(a.mes);
	if (a.mes <> 0) then begin
		WRITELN('INGRESE UN DNI');
		readln(a.dni);
		WRITELN('INGRESE UN DIAGNOSTICO');
		readln(a.diagnostico);
	end;
end;
	

procedure agregarArbol (var a: arbol; aten: atencion);
begin
	if (a = nil) then begin
		new (a);
		a^.dato.dni:= aten.dni;
		a^.dato.cant:= 1;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (aten.dni = a^.dato.dni) then
			a^.dato.cant:= a^.dato.cant + 1
		else begin
			if (aten.dni < a^.dato.dni) then
				agregarArbol(a^.hi, aten)
			else
				agregarArbol(a^.hd, aten)
		end;
	end;
end;

procedure iniciarVector (var v: vector);
var
	i: rangoD;
begin
	for i:= 1 to df do
		v[i]:= 0
end;

procedure incisoA (var a: arbol; var v: vector);
var
	aten: atencion;
begin
	leerAtencion(aten);
	while (aten.mes <> 0) do begin
		agregarArbol(a, aten);
		v[aten.diagnostico]:= v[aten.diagnostico] + 1;
		leerAtencion(aten);
	end;
end;


procedure cantidad (a: arbol; dni1: integer; dni2: integer; x: integer; var cant: integer);
begin
	if (a <> nil) then begin
		if (dni1 >= a^.dato.dni) then
			cantidad(a^.hd, dni1, dni2, x, cant)
		else begin
			if (dni2 >= a^.dato.dni) then begin
				cantidad(a^.hi, dni1, dni2, x, cant);
				if (a^.dato.cant > x) then
					cant:= cant + 1;
				cantidad(a^.hd, dni1, dni2, x, cant);
			end;
		end;
	end;
end;

procedure incisoB (a: arbol);
var
	dni1, dni2, x, cant: integer;
begin
	cant:= 0;
	writeln('INGRESE EL DNI MAS CHICO');
	readln(dni1);
	writeln('INGRESE EL DNI MAS GRANDE');
	readln(dni2);
	writeln('INGRESE UNA CANTIDAD DE ANTENCIONES');
	readln(x);
	cantidad(a,dni1,dni2,x,cant);
	writeln('RESULTADO INCISO B: ', cant);
end;

procedure atenciones (v: vector; var i: integer; var cant: integer);
begin
	i:= i + 1;
	if (i < df) then begin
		if (v[i] = 0) then
			cant:= cant + 1;
		atenciones(v,i,cant);
	end;
end;

procedure incisoC (v: vector);
var
	i, cant: integer;
begin
	i:= 0; cant:= 0;
	atenciones (v,i,cant);
	writeln('LA CANTIDAD DE DIAGNOSTICOS SIN ATENCIONES ES: ', cant);
end;

var
	abb: arbol;
	vec: vector;
begin	
	abb:= nil;
	iniciarVector(vec);
	incisoA(abb, vec);
	incisoB(abb);
	incisoC(vec);
end.


























