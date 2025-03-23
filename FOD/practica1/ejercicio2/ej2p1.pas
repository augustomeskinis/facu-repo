program ej2p1;
type
	archivo = file of integer;
var
	archivoLogico: archivo;
	nombreArchivo: string [12];
	num:integer;
	sumaNumeros: integer;
	cantNumeros: integer;
	menores: integer;
	promedio: real;
begin
	writeln ('ingrese el nombre del archivo: ');
	readln(nombreArchivo);
	assign (archivoLogico, nombreArchivo);
	reset (archivoLogico);
	menores:=0; sumaNumeros :=0; cantNumeros:=0;
	while not Eof (archivoLogico) do begin
		read(archivoLogico, num);
		writeln (num); // imprime el contenido del archivo en pantalla
		if (num < 1500) then
			menores:= menores + 1;
		cantNumeros:= cantNumeros + 1;
		sumaNumeros:= sumaNumeros + num;
	end;
	close(archivoLogico);
	writeln ('cantidad de numeros menores a 1500: ', menores);
	promedio:= sumaNumeros / cantNumeros;
	writeln ('promedio numeros: ',promedio);
end.
