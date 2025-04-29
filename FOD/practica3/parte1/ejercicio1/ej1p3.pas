program ej1p3;
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
procedure punto4incisoA(var archivoLogico:archivo);
var
	empNuevo,emp:empleado;
	yaRegistrado: boolean;
begin
	writeln('desea agregar algun empleado mas?');
	leerEmpleado(empNuevo);
	reset(archivoLogico);
	yaRegistrado:=false;
	while (empNuevo.apellido <> 'fin') do begin
		while not EOF (archivoLogico) and (not yaRegistrado) do begin
			read(archivoLogico,emp);
			if (empNuevo.numero = emp.numero) then
				yaRegistrado:=true;
		end;
		if (yaRegistrado = true) then
			writeln('NO SE PUDO AGREGAR AL EMPLEADO PQ YA EXISTE ESE NUMERO')
		else begin
			seek(archivoLogico,fileSize(archivoLogico));
			writeln('EMPLEADO AGREGADO CON EXITO');
		end;
		yaRegistrado:=false;
		leerEmpleado(empNuevo);
	end;
	close(archivoLogico);
end;
procedure punto4incisoB(var arc: archivo);
var
    num, edad: integer;
    e: empleado;
    encontre: boolean;
begin
    reset(arc);
    writeln('Ingrese un numero de empleado');
    readln(num);
    encontre:= false;
    while(not EOF(arc)) and (not encontre) do
        begin
            read(arc, e);
            if(e.numero = num) then
                begin
                    encontre:= true;
                    writeln('Ingrese la nueva edad del empleado');
                    readln(edad);
                    e.edad:= edad;
                    seek(arc, filePos(arc)-1);
                    write(arc, e);
                end;
        end;
    if(encontre) then
        writeln('Se modifico la edad del empleado con numero ', num)
    else
        writeln('No se hallo al empleado con el numero ', num);
    close(arc);
end;
procedure punto4incisoC(var archivoLogico:archivo);
var
	archivoDetexto:Text;
	emp:empleado;
begin
	assign(archivoDeTexto,'todos_empleados.txt');
	reset(archivoLogico);
	rewrite(archivoDeTexto);
	while not EOF(archivoLogico)do begin
		read(archivoLogico,emp);
		with emp do writeln(archivoDeTexto, ' ', numero, ' ', apellido, ' ', nombre, ' ', edad, ' ', dni);
        end;
    writeln('Archivo de texto del contenido del archivo exportado correctamente');
    close(archivoLogico);
    close(archivoDeTexto);
end;

procedure bajaP3(var archivoLogico:archivo);
var
	empregUlt:empleado;
	num,ult,pos:integer;
	encontre:boolean;
begin
	writeln('ingrese el numero del empleado a borrar: ');
	readln(num);
	encontre = false;
	reset(archivoLogico);
	while not eof (archivoLogico) and (emp.numero <> num) do begin
		read(archivoLogico,emp);
		if (num = emp.numero)then begin
			encontre = true
			pos:= filePos(archivo)-1;
		end;
	end;
	if (encontre) then
		ult:= fileSize(archivoLogico)-1;
		seek(archivo,ult);
		read(archivo,regUlt);
		seek(archivo,pos);
		write(archivo,regUlt);
		seek(archivo,ult);
		truncate(archivo);
		writeln('empleado borrado');
	end;
	close(archivoLogico);
end;
var
	nombreArchivo:String;
	archivoLogico:archivo;
	emp:empleado;
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
	punto4incisoA(archivoLogico);
	punto4incisoB(archivoLogico);
	punto4incisoC(archivoLogico);
	bajaP3(archivoLogico);
end.
