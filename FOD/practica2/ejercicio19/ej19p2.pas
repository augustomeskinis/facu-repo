program ej19p2;
const
	valorAlto = 9999;
type
	rango = 1..50;

	direccion = record
		calle,ciudad:string;
		nro,piso,depto:integer;
	end;
	
	infoNacimiento = record
		nroPartida,matriculaMedico,DNImadre,DNIpadre:integer;
		nombre,apellido,nombreYapellidoMadre,nombreYapellidoPadre:string;
		direc:direccion;
	end;

	archivoNacimiento = file of infoNacimiento;
		
	infoFallecimiento = record
		nroPartida,matriculaMedico,DNI,horaDec:integer;
		direc:direccion;
		nombre,apellido,fechaDec:string;
		lugarDec:direccion;
	end;
	
	archivoFallecimiento = file of infoFallecimiento;
	
	infoMaestro = record
		nombre,apellido,nombreYapellidoMadre,nombreYapellidoPadre:string;
		nroPartida,matriculaMedico,DNImadre,DNIpadre:integer;
		direc:direccion;
		fallecio:boolean;
		matriculaMedicoF,horaDec:integer;
		fechaDec:string;
		lugarDec:direccion;
	end;
	
	archivoMaestro = file of infoMaestro;
var
	maestro:archivoMaestro;
	regMaestro:infoMaestro;
	
	archivosNacimiento: array [rango] of archivoNacimiento;
	regNacimiento: array [rango] of infoNacimiento;
	
	maestroNacimiento: archivoNacimiento;
	regMaestroNacimiento: infoNacimiento;
	
	
	archivosFallecimiento: array [rango] of archivoFallecimiento;
	regFallecimiento: array [rango] of infoFallecimiento;
	
	maestroFallecimiento: archivoFallecimiento;
	regMaestroFallecimiento: infoFallecimiento;
	
procedure cerrarArchivosNacimiento();
var
	i:rango;
begin
	for i:= 1 to 50 do 
		close(archivosNacimiento[i]);
end;
procedure asignarArchivosNacimiento(); { asigna nombre fisico a los archivos de nacimiento y carga el vector de registros con los primeros
										registros de los archivos nacimiento}
var 
	i:integer;
begin
	for i:= 1 to 50 do begin
		assign(archivosNacimiento[i],'arNacimieto');
		reset(archivosNacimiento[i]);
		if not eof (archivosNacimiento[i]) then
			read(archivosNacimiento[i],regNacimiento[i])
		else
			regNacimiento[i].nroPartida:= valorAlto;
	cerrarArchivosNacimiento();
	end;
end;

procedure leerSiguienteNacimiento(i:rango); {lee el proximo nacimiento en la posicion del indice que recibe}
begin
	if not eof (archivosNacimiento[i]) then
		read(archivosNacimiento[i],regNacimiento[i])
	else
		regNacimiento[i].nroPartida:= valorAlto;
end;

procedure minimoNacimientos(var min: infoNacimiento); {calcula el minimo de todos los registros cargados actualmente
														en el vector del registros de nacimiento y lee el proximo}
var
	i,indiceMin:rango;
begin
	min.nroPartida:= valorAlto;
	for i:= 1 to 50 do begin
		if (regNacimiento[i].nroPartida < min.nroPartida) then begin
			min:= regNacimiento[i];
			indiceMin:= i;
		end;
	end;
	leerSiguienteNacimiento(indiceMin);
end;


procedure crearMaestroNacimiento(); {hace un merge de los 50 archivos de nacimientos en un archivo 
									llamado maestroNacimiento, ordenados por nro de partida}
var
	min:infoNacimiento;
begin
	minimoNacimientos(min);
	while(min.nroPartida<>valorAlto)do begin
		write(maestroNacimiento,min);
		minimoNacimientos(min);
	end;
	close(maestroNacimiento);
end;

procedure cerrarArchivosFallecimiento();
var
	i:rango;
begin
	for i:= 1 to 50 do 
		close(archivosFallecimiento[i])
end;

procedure asignarArchivosFallecimiento();
var 
	i:rango;
begin
	for i:= 1 to 50 do begin
		assign(archivosFallecimiento[i],'arF');
		reset(archivosFallecimiento[i]);
		if not eof (archivosFallecimiento[i]) then
			read(archivosFallecimiento[i],regFallecimiento[i])
		else
			regFallecimiento[i].nroPartida:= valorAlto;
	end;
end;

procedure leerSiguienteFallecimiento(i:rango);
begin
	if not eof (archivosFallecimiento[i])then
		read(archivosFallecimiento[i],regFallecimiento[i])
	else
		regFallecimiento[i].nroPartida:=valorAlto;
end;

procedure minimoFallecimientos(var min:infoFallecimiento);
var
	i,indiceMin:rango;
begin
	min.nroPartida:= valorAlto;
	for i:= 1 to 50 do begin
		if (regFallecimiento[i].nroPartida < min.nroPartida) then begin
			min:= regFallecimiento[i];
			indiceMin:=i;
		end;
	end;
	leerSiguienteFallecimiento(indiceMin);
end;
	
procedure crearMaestroFallecimiento();
var
	min:infoFallecimiento;
begin
	minimoFallecimientos(min);
	while(min.nroPartida<>valorAlto)do begin
		write(maestroFallecimiento,min);
		minimoFallecimientos(min);
	end;
	cerrarArchivosFallecimiento();
	close(maestroFallecimiento);
end;
	
procedure leerNacimiento();
begin
	if not eof (maestroNacimiento) then
		read(maestroNacimiento,regMaestroNacimiento)
	else
		regMaestroNacimiento.nroPartida:= valorAlto;
end;
	
procedure leerFallecimiento();
begin
	if not eof (maestroFallecimiento)then
		read(maestroFallecimiento,regMaestroFallecimiento)
	else
		regMaestroFallecimiento.nroPartida:=valorAlto;
end;
	
procedure asignar1();
begin
	regMaestro.nroPartida:=regMaestroNacimiento.nroPartida;
	regMaestro.nombre:=regMaestroNacimiento.nombre;
	regMaestro.apellido:=regMaestroNacimiento.apellido;
	regMaestro.nombreYapellidoMadre:=regMaestroNacimiento.nombreYapellidoMadre;
	regMaestro.nombreYapellidoPadre:=regMaestroNacimiento.nombreYapellidoPadre;
	regMaestro.matriculaMedico:=regMaestroNacimiento.matriculaMedico;
	regMaestro.DNIpadre:=regMaestroNacimiento.DNIpadre;
	regMaestro.DNImadre:=regMaestroNacimiento.DNImadre;
	regMaestro.direc:=regMaestroNacimiento.direc;

end;	
procedure asignar2();
begin
	regMaestro.fallecio:= true;
	regMaestro.matriculaMedicoF:= regMaestroFallecimiento.matriculaMedico;
	regMaestro.fechaDec:=regMaestroFallecimiento.fechaDec;
	regMaestro.horaDec:=regMaestroFallecimiento.horaDec;
	regMaestro.lugarDec:=regMaestroFallecimiento.lugarDec;		
end;		
	
procedure crearMaestro();
begin
	reset(maestroFallecimiento);reset(maestroNacimiento);
	rewrite(maestro);
	leerNacimiento();
	leerFallecimiento();
	while (regMaestroNacimiento.nroPartida <> valorAlto) do
	begin
	  asignar1();

	  if (regMaestroNacimiento.nroPartida = regMaestroFallecimiento.nroPartida) then
	  begin
		asignar2();
		leerFallecimiento();
	  end
	  else
		regMaestro.fallecio := false;

	  write(maestro, regMaestro);
	  leerNacimiento();
end;

end;

begin
	asignarArchivosNacimiento();
	crearMaestroNacimiento();
	asignarArchivosFallecimiento();
	crearMaestroFallecimiento();
	crearMaestro();
end.
