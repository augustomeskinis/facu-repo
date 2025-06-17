program ej12p2;
const
	valorAlto = 9999;
type
	acceso = record
		anio,mes,dia,idUsuario,tiempoAcceso:integer;
	end;
	
	archivo = file of acceso;
var
	ar:archivo;
	ac:acceso;
	anio,totAnio,mes,totMes,dia,totDia,idUsuario,
	totUsuario: integer;

procedure cargarArchivo();
begin
end;

procedure leerArchivo();
begin
	if not eof then
		read(ar,ac)
	else
		ac.anio:=valorAlto;
end;

procedure informarAnio(pos:integer);
begin
	reset(ar);
	seek(ar,pos);
	leerArchivo();
	anio:= ac.anio;
	totAnio:=0;
	writeln('AÑO ', anio);
	while (anio <> valorAlto) and (anio = ac.anio) do begin
		mes:= ac.mes;
		writeln('MES ',mes);
		totMes:=0;
		while (anio = ac.anio) and (mes = ac.mes) do begin
			dia:=ac.dia;
			writeln('DIA ',dia);
			totDia:=0;
			while (anio = ac.anio) and (mes = ac.mes) and (dia = ac.dia) do begin
				idUsuario:= ac.idUsuario;
				writeln('USUARIO ',idUsuario);
				totUsuario:=0;
				while (anio = anio) and (mes = ac.mes) and (dia = ac.dia) and (idUsuario = ac.IdUsuario) do begin
					totUsuario:= totUsuario + ac.tiempoAcceso;
					leerArchivo();
				end;
				writeln('total del usuario: ', totUsuario);
				totDia:= totDia+totUsuario;
			end;
			writeln('total del dia: ', totDia);
			totMes:= totMes+totDia;
		end;
		writeln('total del mes: ', totMes);
		totAnio:= totAnio+totMes;
	end;
	close(ar);
	writeln('total del anio: ',totAnio);
end;
var
	encontre:boolean;
	anioIngresado,posicion:integer;
begin
	assign(ar,'ar');
	rewrite(ar);
	cargarArchivo();
	leerArchivo();
	writeln('ingrese el anio que quiere informar');
	readln(anioIngresado);
	encontre:= false;
	while (anio <> valorAlto) and (not encontre) do begin
		if (ac.anio = anioIngresado) then begin
			encontre:= true;
			posicion:= filePos(ar)-1;
			close(ar);
			informarAnio(posicion);
		end
		else 
			leerArchivo();
	end;
	if (not encontre) then
		close(ar);
end.
