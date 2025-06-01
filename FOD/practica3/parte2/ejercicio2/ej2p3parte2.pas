program ej2p3parte2;
{resuelto con ayuda de chatGPT, igual raro que tomen esto ya que son archivos no ordenados}
const
	valorAlto = 9999;
type
	localidad = record
		codigo, nroMesa, cantVotos: integer;
	end;

	archivo = file of localidad;
	archivoControl = file of integer;

var
	ar: archivo;
	arControl: archivoControl;
	loc, locAux: localidad;

procedure cargarDatos();
begin
	assign(ar, 'archivo');
	rewrite(ar);

	// Localidad 101
	loc.codigo := 101; loc.nroMesa := 1; loc.cantVotos := 150; write(ar, loc);
	loc.codigo := 101; loc.nroMesa := 2; loc.cantVotos := 180; write(ar, loc);

	// Localidad 202
	loc.codigo := 202; loc.nroMesa := 1; loc.cantVotos := 90;  write(ar, loc);
	loc.codigo := 202; loc.nroMesa := 3; loc.cantVotos := 120; write(ar, loc);

	// Localidad 101 otra vez
	loc.codigo := 101; loc.nroMesa := 3; loc.cantVotos := 170; write(ar, loc);

	// Localidad 303
	loc.codigo := 303; loc.nroMesa := 1; loc.cantVotos := 200; write(ar, loc);

	close(ar);
end;

procedure recorrerArchivo();
var
	cod, codigoAprocesar, totVotos, totGeneralVotos: integer;
	procesado: boolean;
	pos: integer;
begin
	assign(ar, 'archivo'); reset(ar);
	assign(arControl, 'archivoControl'); rewrite(arControl); // vaciar archivo de control

	totGeneralVotos := 0;

	while not eof(ar) do begin
		read(ar, loc);
		pos := filepos(ar); // guardamos posición

		// Revisar si la localidad ya fue procesada
		procesado := false;
		seek(arControl, 0);
		while not eof(arControl) and not procesado do begin
			read(arControl, cod);
			if cod = loc.codigo then
				procesado := true;
		end;

		if not procesado then begin
			codigoAprocesar := loc.codigo;
			totVotos := 0;

			// Cerrar y reabrir archivo para recorrer desde el principio
			close(ar);
			assign(ar, 'archivo');
			reset(ar);

			while not eof(ar) do begin
				read(ar, locAux);
				if locAux.codigo = codigoAprocesar then
					totVotos := totVotos + locAux.cantVotos;
			end;

			writeln('Localidad ', codigoAprocesar, ' - Total Votos: ', totVotos);
			totGeneralVotos := totGeneralVotos + totVotos;

			// Marcar como procesado
			seek(arControl, filesize(arControl));
			write(arControl, codigoAprocesar);

			// Reabrir archivo y volver al punto anterior
			close(ar);
			assign(ar, 'archivo');
			reset(ar);
			seek(ar, pos);
		end;
	end;

	close(ar);
	close(arControl);

	writeln('TOTAL GENERAL DE VOTOS: ', totGeneralVotos);
end;

begin
	cargarDatos();
	recorrerArchivo();
end.
