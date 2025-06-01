program parcialDesaprobado;
type
	rangoVencimiento = 2000..2023;
	rangoVector = 1..24;
	
	poliza = record
		DNI: integer;
		sumaAsegurada: integer;
		valorCuota: integer;
		anioVencimiento: rangoVencimiento;
	end;
	
	listaPolizas = ^nodoLista;
	
	nodoLista = record
		dato: poliza;
		sig: listaPolizas;
	end;
	
	vector = array [rangoVector] of listaPolizas;
	
	poliza2= record
		sumaAsegurada: integer;
		valorCuota: integer;
		anioVencimiento: rangoVencimiento;
	end;
	
	listaPolizas2 = ^nodoLista2;
	
	nodoLista2 = record
		dato: poliza2;
		sig: listaPolizas2;
	end;
	
	registroCliente = record
		DNI: integer;
		lista: listaPolizas2;
	end;
	
	arbol = ^nodoArbol;
	
	nodoArbol = record
		dato: registroCliente;
		hi: arbol;
		hd: arbol;
	end;

procedure leerPoliza(var p:poliza);
begin
	writeln('INGRESE EL DNI DEL CLIENTE: ');
	readln(p.DNI);
	if(p.DNI <> -1) then begin
		p.sumaAsegurada:= Random(100);
		p.valorCuota:= Random(500);
		p.anioVencimiento:= Random(23)+2000;
	end;
end;
procedure iniciarVector(var v: vector);
var
	i: rangoVector;
begin
	for i:= 1 to 24 do
		v[i]:= nil
end;
procedure insertarOrdenado(var l: listaPolizas; p:poliza);
var
	nuevo,ant,act: listaPolizas;
begin
	act:= l;
	new(nuevo);
	nuevo^.dato:= p;
	while ( (act <> nil) and (act^.dato.sumaAsegurada < p.sumaAsegurada)) do begin
		ant:=act;
		act:=act^.sig;
	end;
	if(act=l)then
		l:=nuevo
	else
		ant^.sig:=nuevo;
	nuevo^.sig:= act;
end;
procedure incisoA(var v: vector);
var
	p:poliza;
begin
	iniciarVector(v);
	leerPoliza(p);
	while(p.DNI <> -1) do begin
		insertarOrdenado(v[(p.anioVencimiento - 1999)],p);
		leerPoliza(p);
	end;
end;
procedure agregarAdelante(var l: listaPolizas2; p: poliza);
var
	nuevo: listaPolizas2;
begin
	new(nuevo);
	nuevo^.dato.sumaAsegurada:= p.sumaAsegurada;
	nuevo^.dato.valorCuota:= p.valorCuota;
	nuevo^.dato.anioVencimiento:= p.anioVencimiento;
	nuevo^.sig:=nil;
	nuevo^.sig:= l;
	l:=nuevo;
end;
procedure agregarArbol(var a: arbol; p:poliza);
begin
	if (a=nil) then begin
		new(a);
		a^.dato.DNI:= p.DNI;
		a^.dato.lista:= nil;
		agregarAdelante(a^.dato.lista,p);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else begin
		if(p.DNI = a^.dato.DNI)then
			agregarAdelante(a^.dato.lista,p)
		else begin
			if(p.DNI < a^.dato.DNI)then
				agregarArbol(a^.hi,p)
			else
				agregarArbol(a^.hd,p)
		end;
	end;
end;
procedure incisoB (var a: arbol; v: vector; X: integer);
var
	i: rangoVector;
begin
	for i:= 1 to 24 do begin
		while ((v[i]<>nil) and (v[i]^.dato.sumaAsegurada < X)) do begin
			agregarArbol(a,v[i]^.dato);
			v[i]:= v[i]^.sig;
		end;
	end;
end;
procedure recorrerArbol(a: arbol; x: integer; var cant: integer);
begin
	if (a<>nil) then begin
		recorrerArbol(a^.hi,x,cant);
		while (a^.dato.lista <> nil) do begin
			if(a^.dato.lista^.dato.valorCuota > x) then
				cant:= cant + 1;
			a^.dato.lista:=a^.dato.lista^.sig;
		end;
		recorrerArbol(a^.hd,x,cant);
	end;
end;
procedure incisoC(a: arbol);
var
	x, cant: integer;
begin
	writeln('INGRESE UN UN VALOR DE CUOTA X: ');
	readln(x);
	cant:=0;
	recorrerArbol(a,x,cant);
	writeln('LA CANTIDAD DE POLIZAS CON MAYOR VALOR DE CUOTA: ',x,' ,ES: ',cant);
end;
procedure imprimirVector(v: vector);
var
	i: rangoVector;
begin
	for i:= 1 to 24 do begin
		while(v[i]<>nil) do begin
			writeln('DNI DEL CLIENTE: ',v[i]^.dato.DNI);
			writeln('SUMA ASEGURADA: ',v[i]^.dato.sumaAsegurada);
			writeln('VALOR CUOTA: ', v[i]^.dato.valorCuota);
			writeln('ANIO VENCIMIENTO: ',v[i]^.dato.anioVencimiento);
			writeln('');
			v[i]:=v[i]^.sig;
		end;
	end;
end;
var
	vec: vector;
	abb: arbol;
begin
	Randomize;
	incisoA(vec);
	imprimirVector(vec);
	abb:=nil;
	incisoB(abb,vec,50);
	incisoC(abb);
end.
