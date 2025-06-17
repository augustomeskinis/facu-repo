program parcial;
type
	dias = 1..31;
	meses = 1..12;
	rango_horas = 1..8;
	
	registro = record
		numero: integer;
		dia: dias;
		mes: meses;
		horas: rango_horas;
	end;
	lista = ^nodo_lista;
	
	nodo_lista = record
		dato: registro;
		sig: lista;
	end;
	
	
	registro_empleado = record
		num_empleado: integer;
		lista_empleado: lista;
	end;
	
	arbol = ^nodo;
	
	nodo = record
		dato: registro_empleado;
		hd: arbol;
		hi: arbol;
	end;

procedure leerRegistro (var r: registro);
begin
	r.numero:= Random(10);
	r.dia:= 1+ Random(31);
	r.mes:= 1+ Random(12);
	r.horas:= 1+ Random(8);
end;

procedure agregar_adelante (var l: lista; r: registro);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.dato:= r;
	nuevo^.sig:= nil;
	
	if (l = nil) then
		l:= nuevo
	else begin
		nuevo^.sig:= l;
		l:= nuevo;
	end;
end;
procedure agregar_arbol (var a: arbol; r: registro);
begin
	if (a=nil) then begin
		new(a);
		a^.dato.num_empleado:= r.numero;
		a^.dato.lista_empleado:= nil;
		agregar_adelante (a^.dato.lista_empleado, r);
		a^.hd:= nil;
		a^.hi:= nil;
	end
	else begin
		if (r.numero = a^.dato.num_empleado) then
			agregar_adelante(a^.dato.lista_empleado, r)
		else
			if (r.numero > a^.dato.num_empleado) then
				agregar_arbol(a^.hd,r)
			else
				agregar_arbol(a^.hi,r)
	end;
end;
procedure procesar_empleados (var a: arbol);
var
	r: registro;
begin
	leerRegistro(r);
	while (r.numero<>0) do begin
		agregar_arbol(a,r);
		leerRegistro(r);
	end;
end;
procedure imprimir_registro (r: registro);
begin
	writeln ('el numero de empleado es: ', r.numero);
	writeln ('el dia es: ', r.dia);
	writeln('el mes es: ', r.mes);
	writeln('las horas trabajados son: ', r.horas);
end;
procedure imprimir_empleado (l: lista);
begin
	while (l<>nil) do begin
		imprimir_registro(l^.dato);
		l:= l^.sig;
	end;
end;
procedure imprimir(a: arbol; x, y: integer);
begin
    if (a <> nil) then
    begin
        if (a^.dato.num_empleado >= x) and (a^.dato.num_empleado <= y) then
        begin
            imprimir(a^.hi, x, y);
            imprimir_empleado(a^.dato.lista_empleado);
            imprimir(a^.hd, x, y);
        end
        else if (a^.dato.num_empleado < x) then
            imprimir(a^.hd, x, y)
        else
            imprimir(a^.hi, x, y);
    end;
end;
var
	abb: arbol;
	x, y: integer;
begin
	abb:= nil;
	procesar_empleados(abb);
	writeln('ingrese un numero X , despues otro numero mayor Y: ');
	readln(x);
	readln(y);
	imprimir(abb,x,y);
end.
	
