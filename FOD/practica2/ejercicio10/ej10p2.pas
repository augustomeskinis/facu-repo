program ej10p2;
const
	valorAlto = 'ZZZ';
type
	mesa = record
		provincia,localidad:string;
		numero,cantVotos:integer;
	end;
	
	archivo = file of mesa;

var
	m:mesa;
	ar:archivo;

procedure leer();
begin
	if not eof (ar) then
		read(ar,m)
	else
		m.provincia:= valorAlto
end;
var
	provincia,localidad,cantProv,cantLoc:integer
begin
	crearYcargarArchivo();
	reset(ar)
	leer();
	while (m.provincia <> valorAlto) do begin
		provincia:= m.provincia;
		writeln('PROVINCIA: ', provincia);
		cantProv:=0;
		while (m.provincia = provincia) do begin
			localidad:= m.localidad;
			writeln('LOCALIDAD: ', localidad);
			cantLoc:=0;
			while (m.provincia = provincia) and (m.localidad = localidad) do begin
				cantLoc:= cantLoc + m.cantVotos;
				leer();
			end;
			writeln('CANTIDAD LOCALIDAD: ' , cantLoc);
			cantProv:= cantPRov + cantLoc;
		end;
		writeln('CANTIDAD PROVINCIA: ', cantProv);
	end;
	close(ar);
end.
		
		
		
		
		
		
		
		
		
