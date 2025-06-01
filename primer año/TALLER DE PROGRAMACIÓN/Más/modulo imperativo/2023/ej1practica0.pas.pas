program ej1practica0;
type
	rango_aprobadas: 1..36;
	
	materia = record;
		codigo: integer;
		nota: integer;
	end;
	
	
	vector_materias = array [rango_aprobadas] of materia;
	
	alumno = record;
		apellido: string;
		numero: integer;
		año_ingreso: integer;
		cant_aprobadas: rango_aprobadas;
		materias: vector_materias;
	end;
	
	lista = ^nodo;
	
	nodo = record;
		dato: alumno;
		sig: lista;
	end;

	informacion = record;
		numero: integer;
		promedio: real;
	end;
	
	lista2 = ^nodo2;
	nodo2 = record;
		dato: informacion;
		sig: lista2;
	end;
	

procedure cargar_vector (v: vector_materias; DL: rango_aprobadas);
var
	i: rango_aprobadas;
begin
	for i:= 1 to DL do
		writeln('ingrese el codigo de la materia: ');
		readln (v[i].codigo);
		writeln('ingrese la nota de la materia: ');
		readln(v[i].nota);
end;

procedure leer_alumno (var a: alumno);
begin
	writeln('ingrese el apellido: ');
	readln(a.apellido);
	writeln('ingrese el numero: ');
	readln(a.numero);
	writeln('ingrese el año de ingreso: ');
	readln(a.año_ingreso);
	writeln('ingrese la cantidad de materias aprobadas: ')
	readln(a.cant_aprobadas);
	cargar_vector (a.materias, a.cant_aprobadas);
end;


Procedure AgregarAdelante(var l:lista; a: alumno);
Var 
	nue:lista;
Begin
	New(nue);
	nue^.dato:=a;
	nue^.sig:=l;
	L:=nue;
End;

Procedure AgregarAdelante(var l:lista2; numero: integer; promedio: real);
Var 
	nue:lista2;
Begin
	New(nue);
	nue^.dato.numero:=numero;
	nue^.dato.promedio:=promedio;
	nue^.sig:=l;
	L:=nue;
end;

procedure cargar_lista (var l: lista);
var
	a: alumno;
begin
	leer_alumno(a);
	while (a.numero <> 1111) do begin
		agregar_adelante (l,a);
		leer_alumno (a);
	end;
end;

function calcular_promedio (l:listan, dl: integer): real;
var
	suma: integer;
begin
	suma:= 0;
	for i:= 1 to dl do
		suma:= suma + v[i].nota;
	calcular_promedio:= suma / dl;
end;

procedure procesar_lista1 (l: lista1; var l2: lista2);
begin
	while (l<>nil) do begin
		agregar_adelante2 (l2, l^.dato.numero, calcular_promedio(l,l^.dato.cant_aprobadas));
		l:= l^.sig;
	end;
end;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
