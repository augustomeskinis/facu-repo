program ej3practica4;
type
	final_rendido = record
		codigo_alumno: integer;
		codigo_materia: integer;
		nota: integer;
	end;
	
	aprobada = record
		codigo: integer;
		nota: integer;
	end;
	
	lista_materias = ^nodo3;
	
	nodo3 = record
		dato: aprobada;
		sig: lista_materias;
	end;
	
	alumno = record
		codigo: integer;
		lista: lista_materias;
	end;
	
	arbol_alumno = ^nodo1;
	
	nodo1 = record
		dato: alumno;
		hi: arbol_alumno;
		hd: arbol_alumno;
	end;
	
	lista_finales = ^nodo;
	
	nodo = record
		dato: final_rendido;
		sig: lista_finales;
	end;

	materia = record
		codigo: integer;
		lista: lista_finales;
	end;
	
	arbol_materia = ^nodo2;
	
	nodo2 = record
		dato: materia;
		hi: arbol_materia;
		hd: arbol_materia;
	end;
	
procedure leer_final (var f:final_rendido);
begin
	writeln('ingrese el codigo de alumno: ');
	readln(f.codigo_alumno);
	writeln('ingrese el codigo de materia: ');
	readln(f.codigo_materia);
	writeln('ingrese la nota: ');
	readln(f.nota);
end;

procedure agregar_adelante (var l: lista_materias; codigo: integer; nota: integer);
var
	nuevo: lista_materias;
begin
	new(nuevo);
	nuevo^.dato.codigo:= codigo;
	nuevo^.dato.nota:= nota;
	nuevo^.sig:= nil;
	if (l=nil) then
		l:= nuevo
	else begin
		nuevo^.sig:= l;
		l:= nuevo;
	end;
end;

procedure agregar_arbol_alumno(var a: arbol_alumno;f: final_rendido);
begin
	if (a = nil) then begin
		new(a);
		a^.dato.codigo:= f.codigo_alumno;
		a^.dato.lista:= nil;
		if (f.nota > 3) then
			agregar_adelante(a^.dato.lista, f.codigo_materia, f.nota);
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (a^.dato.codigo = f.codigo_alumno) and (f.nota > 3) then
			agregar_adelante(a^.dato.lista, f.codigo_materia, f.nota)
		else begin
			if (a^.dato.codigo < f.codigo_alumno) then
				agregar_arbol_alumno(a^.hi,f)
			else
				agregar_arbol_alumno(a^.hd,f)
		end;
	end;
end;

procedure agregar_adelante2(var l: lista_finales; f: final_rendido);
var
	nuevo: lista_finales;
begin
	new(nuevo);
	nuevo^.dato:= f;
	nuevo^.sig:= l;
	l:= nuevo;
end;

procedure agregar_arbol_materia (var a: arbol_materia; f: final_rendido);
begin
	if (a = nil) then begin
		new(a);
		a^.dato.codigo:= f.codigo_materia;
		a^.dato.lista:= nil;
		agregar_adelante2(a^.dato.lista,f);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else begin
		if (a^.dato.codigo = f.codigo_materia) then
			agregar_adelante2(a^.dato.lista,f)
		else begin
			if (a^.dato.codigo < f.codigo_materia) then
				agregar_arbol_materia(a^.hi,f)
			else
				agregar_arbol_materia(a^.hd,f)
		end;
	end;
end;

procedure incisoA (var a: arbol_alumno; var a2: arbol_materia);
var
	f: final_rendido;
begin
	leer_final(f);
	while (f.nota <> -1) do begin
		agregar_arbol_alumno(a,f);
		agregar_arbol_materia(a2,f);
		leer_final(f);
	end;
end;

procedure imprimir_arbol_alumnos(a:arbol_alumno);
begin
	if (a<>nil) then begin
		imprimir_arbol_alumnos(a^.hi);
		writeln('CODIGO: ',a^.dato.codigo);
		while (a^.dato.lista<>nil) do begin
			writeln('NOTA: ', a^.dato.lista^.dato.nota);
			a^.dato.lista:= a^.dato.lista^.sig;
		end;
		imprimir_arbol_alumnos(a^.hd);
	end;
end;


function calcular_promedio (l: lista_materias): real;
var
	suma, cant: integer;
begin
	suma:= 0; cant:= 0;
	while (l<>nil) do begin
		suma:= suma + l^.dato.nota;
		cant:= cant + 1;
	end;
	calcular_promedio:= suma / cant;
end;


procedure incisoB (a: arbol_alumno; cod: integer);   // preguntar: xq no devuelve nada? que significa retornar?
var
	promedio: real;
begin
	if (a<>nil) then begin
		if (a^.dato.codigo <= cod) then 
			incisoB(a^.hd,cod)
		else begin
			writeln('CODIGO DE ALUMNO: ', a^.dato.codigo);
			promedio:= calcular_promedio(a^.dato.lista);
			writeln('PROMEDIO DE ALUMNO: ', promedio);
			if (a^.hd <> nil) then
				incisoB(a^.hd,cod)
		end;
	end;
end;


function cant_finales (l: lista_materias) : integer;
var
	cant: integer;
begin
	cant:= 0;
	while (l<>nil) do 
		cant:= cant+1;
	cant_finales:= cant;
end;


function cant_alumnos (a: arbol_alumno; cod1: integer; cod2: integer; valor: integer): integer;
var
	cant: integer;
begin
	if (a = nil) then	
		cant_alumnos:= 0
	else begin
		if (a^.dato.codigo >= cod1) and (a^.dato.codigo <= cod2) then begin
			cant:= 0;
			cant:= cant_finales(a^.dato.lista);
			if (cant = valor) then
				cant_alumnos:= 1 + cant_alumnos(a^.hd,cod1,cod2,valor)
			else
				cant_alumnos:= cant_alumnos(a^.hd,cod1,cod2,valor)
		end
		else begin
			if (a^.dato.codigo < cod1) then
				cant_alumnos:= cant_alumnos(a^.hd,cod1,cod2,valor);
		end;
	end;
end;
		
procedure incisoC (a: arbol_alumno);
var
	cant, cod1, cod2, valor: integer;
begin
	writeln('INGRESE DOS CODIGOS Y UN VALOR ENTERO: ');
	writeln('codigo 1: ');
	readln(cod1);
	writeln('codigo 2: ');
	readln(cod2);
	writeln('valor entero: ');
	readln(valor);
	cant:= cant_alumnos(a,cod1,cod2,valor);
	writeln('RESULTADO INCISO D: ', cant);
end;


var
	abb1: arbol_alumno;
	abb2: arbol_materia;
	codigo: integer;
begin
	abb1:= nil; abb2:= nil;
	incisoA(abb1,abb2);
	imprimir_arbol_alumnos(abb1);
	writeln('INGRESE UN CODIGO, DEVOLVERE LOS ALUMNOS CON CODIGO MAS GRANDE Y SU PROMEDIO: ');
	readln(codigo);
	incisoB(abb1,codigo);
	incisoC(abb1);
end.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
