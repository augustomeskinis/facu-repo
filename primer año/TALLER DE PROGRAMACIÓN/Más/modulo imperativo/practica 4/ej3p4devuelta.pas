program ej3p4;
type
	
	finalRendido = record
		codigoAlumno: integer;
		codigoMateria: string;
		nota: -1..10;
	end;
	
	listaAprobadas = ^nodoAprobadas;
	
	aprobada = record
		materia: string;
		nota: 4..10;
	end;
	
	
	
	nodoAprobadas = record
		dato: aprobada;
		sig: listaAprobadas;
	end;
	
	alumno = record
		codigo: integer;
		lista: listaAprobadas;
	end;
	
	arbolAlumno = ^nodoArbol;
	
	nodoArbol = record
		dato: alumno;
		hi: arbolAlumno;
		hd: arbolAlumno;
	end;
	
	listaFinales = ^nodoFinales;
	
	finalArbol = record
		codigoAlumno: integer;
		nota: 1..10;
	end;		
	
	
	nodoFinales = record
		dato: finalArbol;
		sig: listaFinales;
	end;
	
	materia = record
		codigo: string;
		lista: listaFinales;
	end;
	
	arbolMateria = ^nodo2;
	
	nodo2 = record
		dato: materia;
		hi: arbolMateria;
		hd: arbolMateria;
	end;



procedure leerFinal (var f: finalRendido);
begin
	writeln('INGRESE EL CODIGO DE ALUMNO');
	readln(f.codigoAlumno);
	writeln('INGRESE EL CODIGO DE MATERIA');
	readln(f.codigoMateria);
	writeln('INGRESE LA NOTA');
	readln(f.nota);
end;

procedure agregarAdelanteAlumno (var l: listaAprobadas; materia: string; nota: integer);
var
	nuevo: listaAprobadas;
begin
	new(nuevo);
	nuevo^.dato.materia:= materia;
	nuevo^.dato.nota:= nota;
	nuevo^.sig:= nil;
	
	if (l = nil) then
		l:= nuevo
	else begin
		nuevo^.sig:= l;
		l:= nuevo;
	end;
end;

procedure agregarArbolAlumno (var a: arbolAlumno; f: finalRendido);
begin
	if (a = nil) then begin
		new(a);
		a^.dato.codigo:= f.codigoAlumno;
		a^.dato.lista:= nil;
		if (f.nota >= 4) then
			agregarAdelanteAlumno(a^.dato.lista, f.codigoMateria, f.nota);
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (f.codigoAlumno = a^.dato.codigo) then begin
			if (f.nota >= 4) then
				agregarAdelanteAlumno(a^.dato.lista, f.codigoMateria, f.nota)
		end
		else begin
			if (f.codigoAlumno < a^.dato.codigo) then
				agregarArbolAlumno(a^.hi,f)
			else
				agregarArbolAlumno(a^.hd,f)
		end;
	end;
end;

procedure agregarAdelanteFinal (var l: listaFinales; f: finalRendido);
var
	nuevo: listaFinales;
begin
	new(nuevo);
	nuevo^.dato.codigoAlumno:= f.codigoAlumno;
	nuevo^.dato.nota:= f.nota;
	nuevo^.sig:= nil;
	
	if(l=nil)then
		l:= nuevo
	else begin
		nuevo^.sig:= l;
		l:= nuevo;
	end;
end;


procedure agregarArbolMateria (var a: arbolMateria; f: finalRendido);
begin
	if (a=nil) then begin
		new(a);
		a^.dato.codigo:= f.codigoMateria;
		a^.dato.lista:= nil;
		agregarAdelanteFinal(a^.dato.lista,f);
		a^.hi:= nil;
		a^.hd:=nil;
	end
	else begin
		if (f.codigoMateria = a^.dato.codigo) then 
			agregarAdelanteFinal(a^.dato.lista,f)
		else begin
			if (f.codigoMateria < a^.dato.codigo) then
				agregarArbolMateria(a^.hi,f)
			else
				agregarArbolMateria(a^.hd,f)
		end;
	end;
end;

procedure incisoA (var a: arbolAlumno; var a2: arbolMateria);
var
	f: finalRendido;
begin
	leerFinal(f);
	while (f.nota <> -1) do begin
		agregarArbolAlumno(a,f);
		agregarArbolMateria(a2,f);
		leerFinal(f);
	end;
end;

function calcularPromedio (l: listaAprobadas) : real;
var
	suma, cant: integer;
begin
	suma:= 0; cant:= 0;
	while (l<>nil) do begin
		cant:= cant + 1;
		suma:= suma + l^.dato.nota;
		l:= l^.sig;
	end;
	calcularPromedio:= suma / cant;
end;

procedure incisoB (a: arbolAlumno; cod: integer);
var
	promedio: real;
begin
	if (a <> nil) then begin
		if (cod >= a^.dato.codigo) then
			incisoB(a^.hd,cod)
		else begin
			incisoB(a^.hi,cod);
			writeln('CODIGO DEL ALUMNO: ', a^.dato.codigo);
			promedio:= calcularPromedio(a^.dato.lista);
			writeln('PROMEDIO DEL ALUMNO: ', promedio);
			incisoB(a^.hd,cod);
		end;
	end;
end;

function aprobados (l: listaAprobadas) : integer;
var
	cant: integer;
begin
	cant:= 0;
	while (l<>nil) do begin
		cant:= cant + 1;
		l:= l^.sig
	end;
	aprobados:= cant;
end;


procedure incisoC (a: arbolAlumno; cod1: integer; cod2: integer; valor: integer; var cant: integer);
begin
	if (a<>nil) then begin
		if (cod1 >= a^.dato.codigo) then
			incisoC(a^.hd,cod1,cod2,valor,cant)
		else begin
			if (cod2 >= a^.dato.codigo) then begin
				incisoC(a^.hi,cod1,cod2,valor,cant);
				if (aprobados(a^.dato.lista) = valor) then
					cant:= cant + 1;
				incisoC(a^.hd,cod1,cod2,valor,cant);
			end;
		end;
	end;
end;


var
	abb1: arbolAlumno;
	abb2: arbolMateria;
	cod1, cod2, valor, cant: integer;
begin
	abb1:= nil; abb2:= nil;
	incisoA(abb1,abb2);
	writeln('INGRESE UN CODIGO, DEVOLVERE EL PROMEDIO DE LOS ALUMNOS CON CODIGO MAS GRANDE: ');
	readln(cod1);
	incisoB(abb1,cod1);
	writeln('INGRESE EL PRIMER CODIGO: ');
	readln(cod1);
	writeln('INGRESE EL SEGUNDO CODIGO: ');
	readln(cod2);
	writeln('INGRESE UN VALOR');
	readln(valor);
	cant:= 0;
	incisoC(abb1,cod1,cod2,valor,cant);
	writeln('LA CANTIDAD DE ALUMNOS CON FINALES APROBADOS IGUAL AL VALOR ES: ', cant);

end.
	
	
	
	
	
	
