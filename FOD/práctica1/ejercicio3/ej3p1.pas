program ej3p1;
type
	empleado = record
		numero: integer;
		apellido: string;
		nombre: string;
		edad: integer;
		DNI: integer;
	end;
	
	archivo = file of empleado;
	
procedure leerEmpleado (var emp: empleado);
begin
	writeln ('ingrese el apellido del empleado o fin para finalizar');
	readln(emp.apellido);
	if (emp.apellido <> 'fin') then begin
		writeln('ingrese el nombre del empleado: ');
		readln(emp.nombre);
		writeln('ingrese el numero del empleado: ');
		readln(emp.numero);
		writeln('ingrese la edad del empleado: ');
		readln(emp.edad);
		writeln('ingrese el DNI del empleado: ');
		readln(emp.DNI);
	end;
end;
procedure inciso1 (var archivoLogico:archivo);
var
	nombreOApellidoIngresado:string;
	emp:empleado;
begin
	writeln('INGRESE LOS NOMBRES O APELLIDOS QUE QUIERE BUSCAR EN EL ARCHIVO: ');
	readln(nombreOApellidoIngresado);
	reset(archivoLogico);
	while not EOF (archivoLogico) do begin
		read(archivoLogico,emp);
		if (emp.nombre = nombreOapellidoIngresado) or (emp.apellido = nombreOapellidoIngresado) then
			writeln ('NOMBRE Y APELLIDO',emp.nombre,emp.apellido);	
	end;
	close(archivoLogico);
end;
procedure inciso2 (var archivoLogico:archivo);
var
	emp:empleado;
begin
	writeln('a continucion se escriben todos los empleados: ');
	reset(archivoLogico);
	while not EOF (archivoLogico) do begin
		read(archivoLogico,emp);
		writeln(emp.apellido);
		writeln(emp.nombre);
		writeln(emp.numero);
		writeln(emp.DNI);
		writeln(emp.edad);
	end;
	close(archivoLogico);
end;
procedure inciso3 (var archivoLogico:archivo);
var
	emp:empleado;
begin
	writeln('a continucion se escriben todos los empleados mayores de 70: ');
	reset(archivoLogico);
	while not EOF (archivoLogico) do begin
		read(archivoLogico,emp);
		if (emp.edad > 70) then begin
			writeln(emp.apellido);
			write(emp.nombre);
		end;
	end;
	close(archivoLogico);
end;
var
	archivoLogico: archivo;
	nombreArchivo: string;
	emp: empleado;
begin
	writeln ('ingrese el nombre del archivo: ');
	readln(nombreArchivo);
	assign(archivoLogico, nombreArchivo);
	rewrite(archivoLogico);
	leerEmpleado(emp);
	while (emp.apellido <> 'fin') do begin
		write(archivoLogico,emp);
		leerEmpleado(emp);
	end;
	close(archivoLogico);
	inciso1(archivoLogico);
	inciso2(archivoLogico);
	inciso3(archivoLogico);
end.
	
		
