program ej7p3;
type
	regAve = record
		codigo:integer;
		nombre,familia,zonaGeografica:string;
	end;
	
	archivo = file of regAve;

var
	ar:archivo;
	ave:regAve;

procedure borrarAve(codigo: integer);
var
	encontre:boolean;
begin
	encontre:=false;
	assign(ar,'archivo ave');
	reset(ar);
	read(ar,ave);
	while (not eof (ar)) and (not encontre) do begin
		if(ave.codigo = codigo)then begin
			ave.codigo:= ave.codigo*-1;
			seek(ar,filePos(ar)-1);
			write(ar,ave);
			encontre:= true;
		end
		else
			read(ar,ave);
	end;
	close(ar);
end;

procedure compactarArchivo();
var
	posBorrar,posFinal:integer;
begin
	assign(ar, 'archivo ave');
	reset(ar);
	while not eof (ar) do begin
		read(ar,ave);
		if (ave.codigo < 0) then begin
			posBorrar:= filePos(ar)-1;
			posFinal:= fileSize(ar);
			seek(ar,posFinal);
			read(ar,ave);
			seek(ar,posBorrar);
			write(ar,ave);
			seek(ar,posFinal);
			truncate(ar);
			seek(ar,posBorrar+1);
		end;
	end;
	close(ar);
end;
var
	codigo:integer;
begin
	assign(ar,'archivo ave');
	rewrite(ar);
	// aca iria el proceso de cargar el archivo 
	writeln('	ingrese el codigo de ave a borrar, -1 para finalizar');
	readln(codigo);
	while (codigo <> -1) do begin
		borrarAve(codigo);
		writeln('	ingrese el codigo de ave a borrar, -1 para finalizar');
		readln(codigo);
	end;
	compactarArchivo();
end.
