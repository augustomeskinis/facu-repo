program ej1practica3;
type
	socio = record
		numero: integer;
		nombre: string;
		edad: integer;
	end;
	
	arbol =^nodo;
	
	nodo = record
		dato: socio;
		hd: arbol;
		hi: arbol;
	end;
procedure leer_socio (var s: socio);
begin
	writeln('ingrese un num de socio: ');
	readln(s.numero);
	writeln('ingrese un nombre: ');
	readln(s.nombre);
	writeln('ingrese una edad: ');
	readln(s.edad);
end;

procedure agregar_arbol (var a: arbol; s: socio);
begin
	if (a=nil) then begin
		new(a);
		a^.dato:= s;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (s.numero <= a^.dato.numero) then
			agregar_arbol(a^.hi,s)
		else
			agregar_arbol(a^.hd,s)
	end;
end;

procedure incisoA (var a: arbol);
var
	s: socio;
begin
	a:= nil;
	leer_socio(s);
	while (s.numero <> 0) do begin
		agregar_arbol(a,s);
		leer_socio(s);
	end;
end;

function calcular_maximo (a:arbol): arbol;
begin
	if (a^.hd = nil) then
		calcular_maximo:= a
	else
		calcular_maximo:= calcular_maximo(a^.hd)
end;
procedure imprimir_socio(s:socio);
begin
	writeln('numero de socio: ', s.numero);
	writeln('edad de socio: ', s.edad);
	writeln('nombre de socio: ', s.nombre);
end;

function calcular_minimo (a:arbol): arbol;
begin
	if (a^.hi = nil) then
		calcular_minimo:= a
	else
		calcular_minimo:= calcular_minimo(a^.hi)
end;

procedure incisoI (a: arbol);
begin
	writeln('el numero de socio mas grande es: ');
	imprimir_socio(calcular_maximo(a)^.dato);
end;

procedure incisoII (a: arbol);
begin
	writeln('el numero de socio mas chico es: ');
	imprimir_socio(calcular_minimo(a)^.dato)
end;

procedure calcular_edad (a: arbol; var max: integer; var max_socio: integer);
begin
	if (a <> nil) then begin
		calcular_edad(a^.hi,max,max_socio);
		if (a^.dato.edad >= max) then begin
			max:= a^.dato.edad;
			max_socio:= a^.dato.numero;
		end;
		calcular_edad(a^.hd,max,max_socio);
	end;
end;

procedure incisoIII (a: arbol);
var
	max, max_socio: integer;
begin
	max:= -1; max_socio:= 0;
	calcular_edad(a,max,max_socio);
	writeln('el socio mas viejo es: ', max_socio);
end;

//procedure incisoIV (var a: arbol); // preguntar ¿se puede pasar el arbol por referencia? como lo hago si no?
function buscar (a:arbol; x:integer): boolean; 
begin
	if (a = nil) then 
		buscar:= false
	else 
		if(a^.dato.numero = x) then
		buscar:= true
		else 
			if (x > a^.dato.numero) then 
				buscar:= buscar(a^.hd, x)
			else 
				buscar:= buscar(a^.hi, x)
end;
procedure incisoV (a:arbol);
var
	num: integer;
begin
	writeln('ingrese un numero de socio y le informare si esta en el arbol: ');
	readln(num);
	if (buscar(a,num)) then
		writeln ('SE ENCUENTRA EN EL ARBOL')
	else
		writeln('NO SE ENCUENTRA EN EL ARBOL')
end;

procedure buscar_nombre (a:arbol;nombre:string; var esta: boolean);
begin
	if (a<>nil) and (esta = false) then begin
		if (a^.dato.nombre = nombre) then
			esta:= true
		else begin
			buscar_nombre(a^.hi,nombre,esta);
			buscar_nombre(a^.hi,nombre,esta);
		end;
end;
procedure incisoVI (a:arbol);  // preguntar: de que manera debo buscar el nombre?
var
	nombre: string;
	esta: boolean;
begin
	writeln('ingrese un nombre y le informare si esta en el arbol: ');
	readln(nombre);
	buscar_nombre(a,nombre,esta);
	if(esta = true)
		writeln('ESTA EN EL ARBOL')
	else
		writeln('NO ESTA EN EL ARBOL')
end;

procedure cant_socios(a: arbol; var cant: integer);   // preguntar. puede ser funcion?
begin
	if (a<>nil) then begin
		cant_socios(a^.hi,cant);
		cant:= cant + 1;
		cant_socios(a^.hd,cant);
	end;
end;
procedure incisoVII (a: arbol);
var
	cant: integer;
begin
	cant_socios(a,cant);
	writeln('la cantidad total de socios es: ', cant);
end;
procedure suma_edades (a:arbol;var suma: integer);  // preguntar. puede ser funcion?
begin
	if (a<>nil) then begin
		suma_edades(a,suma);
		suma:= suma + a^.dato.edad;
		suma_edades(a,suma);
	end;
end;
procedure incisoVIII(a:arbol);  
var
	suma, cant: integer;
	promedio: real;
begin
	suma:= 0; cant:=0;
	cant_socios(a,cant);
	suma_edades(a,suma);
	promedio:= cant / suma;
	writeln('el promedio es: ', promedio);
end;
procedure incisoXI (a: arbol);
begin
	if (a<>nil) then begin
		incisoXI(a^.hi);
		writeln(a^.dato.numero);
		incisoXI(a^.hd);
	end;
end;
function es_par (num: integer): boolean;
begin
	es_par:= (num MOD 2 = 0) ;
end;
procedure incisoX (a: arbol);
begin
	if (a<>nil) then begin
		incisoX(a^.hi);
		incisoX(a^.hd);
		if (es_par(a^.dato.numero))then
			writeln(a^.dato.numero)
	end;
end;

var
	abb: arbol;
begin
	incisoA(abb);
	incisoI(abb);
	incisoII(abb);
	incisoIII(abb);
//	incisoIV(abb);
	incisoV(abb);
	incisoVI(abb);
	incisoVII(abb);
	incisoVIII(abb);
	writeln('numeros de los socios en orden creciente: ');
	incisoXI(abb);
	writeln('numeros de los socios pares en orden decreciente: ');
	incisoX(abb);
end.
