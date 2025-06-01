program ej3p4;
type
	
	rango_materias = 1..30 ;
	rango_nota = -1..10 ;
	
	final = record 
		cod_alu: integer;
		cod_mat: integer;
		nota: rango_nota;
	end;
	
	lista_notas = ^nodo_notas;
	
	
	alumno = record
		codigo: integer;
		notas: lista_notas;
	end;
	

	
	nodo_notas = record
		nota: integer;
		sig: lista_notas;
	end;
	
	
	
	
	arbol1 = ^nodo1;
	
	nodo1 = record
		dato: alumno;
		hi: arbol1;
		hd: arbol1;
	end;
	
	
	
	registro_materia = record
		cod_alu: integer;
		nota: rango_nota;
	end;
	
	lista_finales = ^nodo_finales;
	
	nodo_finales = record
		dato: registro_materia;
		sig: lista_finales;
	end;
	
	materia = record
		codigo: rango_materias;
		finales: lista_finales;
	end;

	arbol2 = ^nodo2;
	
	nodo2 = record
		dato: materia;
		hi: arbol2;
		hd: arbol2;
	end;
	
procedure leer_final (var f: final);
begin
	writeln ('ingrese el codigo de alumno: ');
	readln (f.cod_alu);
	writeln ('ingrese el codigo de materia: ');
	readln (f.cod_mat);
	writeln ('ingrese la nota del final: ');
	readln (f.nota);
end;

procedure agregar_adelante1 (var l: lista_notas; nota: integer);
var
	nuevo: lista_notas;
begin
	new (nuevo);
	nuevo^.nota:= nota;
	nuevo^.sig:= nil;
	
	if (l = nil) then
		l:= nuevo
	else begin
		nuevo^.sig:= l;
		l:= nuevo;
	end;
end;


procedure agregar1 (var a: arbol1; f: final);
begin
	if (f.nota > 3) then
	begin
		if (a = nil) then begin
			new (a);
			a^.dato.codigo:= f.cod_alu;
			a^.dato.notas:= nil;
			a^.hi:= nil;
			a^.hd:= nil;
		end
		else
			if (f.cod_alu = a^.dato.codigo) then
				agregar_adelante1 (a^.dato.notas, f.nota)
			else
				if (f.cod_alu < a^.dato.codigo) then
					agregar1 (a^.hi, f)
				else
					agregar1 (a^.hd, f)
	end;
end;


procedure agregar_adelante2 (var l: lista_finales; f: final);
var
	nuevo: lista_finales;
begin
	new (nuevo);
	nuevo^.dato.cod_alu:= f.cod_alu;
	nuevo^.dato.nota:= f.nota;
	
	if (l = nil) then
		l:= nuevo
	else begin
		nuevo^.sig:= l;
		l:= nuevo;
	end;
end;


procedure agregar2 (var a: arbol2; f: final);
begin
	if (a = nil) then begin
		new (a);
		a^.dato.codigo:= f.cod_mat;
		a^.dato.finales:= nil;
		a^.hi:= nil;
		a^.hd:= nil;
	end;
	
	if (f.cod_mat = a^.dato.codigo) then begin
		agregar_adelante2 (a^.dato.finales, f);
	end
	
	else
		if (f.cod_mat < a^.dato.codigo) then 
			agregar2 (a^.hi, f)
		else
			agregar2 (a^.hd, f)
end;


procedure cargar_arboles (var a1: arbol1; var a2: arbol2);
var
	f: final;
begin
	leer_final (f);
	while (f.nota <> - 1) do begin
		agregar1 (a1, f);
		agregar2 (a2, f);
		leer_final (f);
	end;
end;



function calcular_promedio (l: lista_notas) : real ;
var
	suma, cant: integer;
begin
	suma:= 0; cant:= 0;
	while (l <> nil) do begin
		cant:= cant + 1;
		suma:= suma + l^.nota;
		l:= l^.sig;
	end;
	
	calcular_promedio:= suma / cant;
end;


procedure codigosYpromedios (a: arbol1; cod: integer);
begin
	if (a <> nil) then
	begin
		if (a^.dato.codigo > cod) then
			codigosYpromedios (a^.hd,cod)
		else 
		begin
			codigosYpromedios (a^.hi, cod);
			writeln ('el codigo, el cual es mayor que el ingresado, de este alumno es: ', a^.dato.codigo);
			writeln ('el promedio de este alumno es: ', calcular_promedio (a^.dato.notas));
			codigosYpromedios (a^.hd, cod);
		end;
	end;
end;
			
var
	abb1: arbol1;
	abb2: arbol2;
	c: integer;
begin
	abb1:= nil; abb2:= nil;
	cargar_arboles (abb1, abb2);
	writeln ('ingrese un codigo de alumno y le devolvere lo pedido: ');
	readln (c);
	codigosYpromedios (abb1, c);
	
end.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
