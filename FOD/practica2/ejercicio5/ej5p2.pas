program ej5p2;
const
	valorAlto = 9999;
type
	regDetalle = record
		codUsuario, fecha: integer;
		tiempoSesion:real;
	end;
	
	regMaestro = record
		codUsuario,fecha: integer;
		tiempoTotal:real;
	end;
	
	
	registrosDetalle = array [1..5] of regDetalle;
	archivoDetalle = array [1..5] of file of regDetalle;
	archivoMaestro = file of regMaestro;
	
	
// VARIABLES GLOBALES


var
	detalles: archivoDetalle;
	regD:registrosDetalle;
	maestro:archivoMaestro;
	regM:regMaestro;
	
// PROCEDIMIENTOS

procedure asignarDetalles();
var 
	i:integer;
begin
	for i:= 1 to 5 do 
		assign(detalles[i], 'detalle' + '(i)');
end;

procedure leerDetalle(i:integer);
begin
	if not eof (detalles[i]) then 
		read(detalles[i],regD[i])
	else begin
		regD[i].codUsuario:= valorAlto;
		regD[i].fecha:=valorAlto;
	end;
end;

procedure minimo(var codDetalle: integer; var fechaDetalle: integer; var tiempoSesion: real);
var
	minC,minF,i:integer;
begin
	minC:= valorAlto;
	minF:= valorAlto;
	for i:= 1 to 5 do begin
		if (regD[i].codUsuario < minC) or ((regD[i].codUsuario = minC) and (regD[i].fecha < minF))then begin
			minC:= regD[i].codUsuario;
			minF:= regD[i].fecha
		end;
	end;
	
	if ((minC<> valorAlto) and (minF <> valorAlto)) then begin
		tiempoSesion:=0;
		for i:= 1 to 5 do begin
			while ((regD[i].codUsuario = minC) and (regD[i].fecha = minF)) do begin
				tiempoSesion:= tiempoSesion + regD[i].tiempoSesion;
				leerDetalle(i);
			end;
		end;
	end;
end;
// PROGRAMA PRINCIPAL

var
	codDetalle,fechaDetalle,i:integer;
	tiempoSesion:real;
begin
	assign(maestro,'/var/log');
	rewrite(maestro);
	asignarDetalles();
	while not eof (maestro) do begin
		read(maestro,regM);
		minimo(codDetalle,fechaDetalle,tiempoSesion);
		while(not eof(maestro) and (regM.codUsuario < codDetalle)) do 
				read(maestro,regM);
		if (regM.codUsuario = codDetalle) then begin
			regM.tiempoTotal:= regM.tiempoTotal + tiempoSesion;
			seek(maestro,filepos(maestro)-1);
			write(maestro,regM);
		end;
	end;
	close(maestro);
	for i:=1 to 5 do 
		close(detalles[i]);
end.
