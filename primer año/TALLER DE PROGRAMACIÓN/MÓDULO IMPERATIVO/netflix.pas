program netflix;
type	
	rangoGenero = 1..8;

	pelicula = record
		codPelicula: integer;
		codGenero: rangoGenero;
		puntajePromedio: real;
	end;
	
	lista = ^nodo;
	
	nodo = record
		dato:  pelicula;
		sig: lista;
	end;
	
	vectorListas = array [rangoGenero] of lista;
	
procedure leerPelicula (var p:pelicula);
begin
	writeln('INGRESE EL CODIGO DE PELICULA: ');
	readln(p.codPelicula);
	if(p.codPelicula <> -1)then begin
		writeln('INGRESE EL CODIGO DE GENERO: ');
		readln(p.codGenero);
		writeln('INGRESE EL PUNTAJE: ');
		readln(p.puntajePromedio);
	end;
end;
procedure iniciarVector(var vL: vectorListas);
var
	i: rangoGenero;
begin
	for i:= 1 to 8 do
		vL[i]:=nil
end;
procedure agregarAtras(var l,ult: lista; p:pelicula);
var
	nuevo:lista;
begin
	new(nuevo);
	nuevo^.dato:=p;
	nuevo^.sig:=nil;
	if(l=nil)then
		l:=nuevo
	else
		ult^.sig:=nuevo;
	ult:= nuevo;
end;
procedure incisoA(var vL: vectorListas);
var
	p:pelicula;
	vU: vectorListas;
begin
	iniciarVector(vL);
	leerPelicula(p);
	while (p.codPelicula <> -1) do begin
		agregarAtras(vL[p.codGenero],vU[p.codGenero],p);
		leerPelicula(p);
	end;
end;
procedure imprimirVector(vL:vectorListas);
var
	i:rangoGenero;
begin
	for i:= 1 to 8 do begin
		while(vL[i]<>nil)do begin
			writeln('');
			writeln('DATOS DE LA PELICULA: ');
			writeln('codigo de pelicula: ',vL[i]^.dato.codPelicula);
			writeln('codigo de genero: ',vL[i]^.dato.codGenero);
			writeln('puntaje promedio: ',vL[i]^.dato.puntajePromedio);
			vL[i]:=vL[i]^.sig;
		end;
	end;
end;
var
	vec: vectorListas;
begin
	incisoA(vec);
	imprimirVector(vec);
end.
