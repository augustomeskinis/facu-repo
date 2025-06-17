program final09052023;
type
	rangoID = 1..5;
	rangoFyP = 0..10;
	rangoEsquina = 1..100;
	mensaje = record
		id: rangoID;
		flores: rangoFyP;
		papeles: rangoFyP;
		calle: rangoEsquina;
		avenida: rangoEsquina;
	end;
	
	listaMensajes = ^nodo1;
	
	nodo1 = record
		dato: mensaje;
		sig: listaMensajes;
	end;

	vector = array [1..5] of listaMensajes;
	
	registro2 = record
		num: rangoEsquina;
		totalFlores: integer;
		totalEsquinas: integer;
	end;
	
	listaAvenidas = ^nodo2;
	
	nodo2 = record
		dato: registro2;
		sig: listaAvenidas;
	end;
	
	
procedure mensajeRandom(var M: mensaje);
begin
	M.id:= Random(5)+1;
	M.flores:= Random(10)+1;
	M.papeles:=Random(10)+1;
	M.calle:=Random(100)+1;
	M.avenida:=Random(10)+1; // hago con 10 avenidas asi se repiten 
end;
procedure iniciarVector(var v: vector);
var
	i:rangoID;
begin
	for i:= 1 to 5 do
		v[i]:=nil
end;
procedure insertarOrdenado(var l: listaMensajes; m: mensaje);
var
	ant,act,nuevo:listaMensajes;
begin
	act:=l;
	new(nuevo);
	nuevo^.dato:=m;
	nuevo^.sig:=nil;
	while(act<>nil)and(act^.dato.avenida < m.avenida) do begin
		ant:=act;
		act:=act^.sig;
	end;
	if (act=l) then
		l:=nuevo
	else
		ant^.sig:=nuevo;
	nuevo^.sig:=act;
end;
procedure incisoA(var v: vector);
var
	i: rangoEsquina;
	m: mensaje;
begin
	iniciarVector(v);
	for i:= 1 to 10 do begin // cargo 10 mensajes asi se puede leer
		mensajeRandom(m);
		insertarOrdenado(v[m.id],m);
	end;
end;
procedure insertarOrdenado2(var l: listaAvenidas; m: mensaje);
var 
	nuevo: listaAvenidas;
begin
    if (l = nil) then
    begin
        // Caso base: La lista está vacía, insertar al principio.
        new(l);
        l^.dato.num := m.avenida;
        l^.dato.totalFlores:= m.flores;
        if(m.papeles=0)then
			l^.dato.totalEsquinas:=1
		else
			l^.dato.totalEsquinas:=0;
        l^.sig := nil;
    end
    else 
		if (l^.dato.num = m.avenida) then
		begin
			l^.dato.totalFlores := l^.dato.totalFlores + m. flores;
			if(m.papeles=0)then
				l^.dato.totalEsquinas:= l^.dato.totalEsquinas + 1 
		end
		else 
			if (l^.dato.num > m.avenida) then
			begin
				// Insertar antes del nodo actual.
				new(nuevo);
				nuevo^.dato.num := m.avenida;
				nuevo^.dato.totalFlores:= m.flores;
				if(m.papeles=0)then
					nuevo^.dato.totalEsquinas:=1
				else
					nuevo^.dato.totalEsquinas:=0;
				nuevo^.sig := l;
				l := nuevo;
			end
			else
			begin
				// Llamada recursiva al siguiente nodo.
				insertarOrdenado2(l^.sig, m);
			end;
end;

procedure incisoB(v:vector; var l: listaAvenidas);
var 
	i: rangoID;
begin
	for i:= 1 to 5 do begin
		while (v[i]<>nil) do begin
			insertarOrdenado2(l,v[i]^.dato);
			v[i]:= v[i]^.sig;
		end;
	end;
end;
procedure imprimirLista1(v: vector);
var
	i:rangoID;
begin
	for i:= 1 to 5 do begin
		while(v[i]<>nil) do begin
			writeln('ID DEL ROBOT: ', v[i]^.dato.id);
			writeln('FLORES: ', v[i]^.dato.flores);
			writeln('PAPELES: ', v[i]^.dato.papeles);
			writeln('CALLE: ', v[i]^.dato.calle);
			writeln('AVENIDA: ', v[i]^.dato.avenida);
			writeln('');
			v[i]:= v[i]^.sig;
		end;
	end;
end;
procedure imprimirLista2(l:listaAvenidas);
begin
	while(l<>nil)do begin
		writeln('AVENIDA NUMERO: ');
		writeln(l^.dato.num);
		writeln('FLORES DE LA AVENIDA: ');
		writeln(l^.dato.totalFlores);
		writeln('ESQUINAS CON CERO PAPELES DE LA AVENIDA:');
		writeln(l^.dato.totalEsquinas);
		l:=l^.sig;
	end;
end;
var
	vec: vector;
	lis: listaAvenidas;
begin
	Randomize;
	incisoA(vec);
	imprimirLista1(vec);
	lis:=nil;
	incisoB(vec,lis);
	imprimirLista2(lis);
end.


