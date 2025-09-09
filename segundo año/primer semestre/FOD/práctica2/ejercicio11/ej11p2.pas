program ej11p2;
const
	valorAlto = 9999;
type
	empleado = record
		departamento,division,numero,categoria,horasExtra:integer;
	end;
	
	archivo = file of empleado;
	
	vector = array [1..15] of integer;

var
	carga: text;
	ar: archivo;
	emp: empleado;
	valorHoraExtra: vector;
	i,valor,
	departamento,totalHorasDepartamento,montoTotalDepartamento,
	division,totalHorasDivision,montoTotalDivision,
	numero,totalHorasEmpleado,importeACobrar,
	categoria:integer;
procedure leer();
begin
	if not eof (ar) then
		read(ar,emp)
	else
		emp.departamento:= valorAlto;
end;
procedure cargarArchivoAleatorio;
var
  i, cant: integer;
  emp: empleado;
begin
  assign(ar, 'ar');
  rewrite(ar);  // Crea o sobrescribe el archivo binario

  randomize;
  writeln('Ingrese la cantidad de registros a generar: ');
  readln(cant);

  for i := 1 to cant do
  begin
    emp.departamento := random(5) + 1; // 1 a 5
    emp.division := random(3) + 1;     // 1 a 3
    emp.numero := random(100) + 1;     // 1 a 100
    emp.categoria := random(15) + 1;   // 1 a 15
    emp.horasExtra := random(21);      // 0 a 20
    write(ar, emp);                    // Guarda el registro en el archivo
  end;
  close(ar);
  writeln('Archivo cargado con ', cant, ' registros aleatorios.');
end;
begin
	assign(carga,'carga.txt');
	cargarArchivoAleatorio();
	reset(carga);
	for i:= 1 to 15 do begin
		read(carga,categoria,valor);
		valorHoraExtra[categoria] := valor;
	end;
	reset(ar);
	leer();
	while(emp.departamento <> valorAlto) do begin
		departamento:= emp.departamento;
		writeln('DEPARTAMENTO: ', departamento);
		totalHorasDepartamento:= 0; montoTotalDepartamento:= 0; 
		while (departamento = emp.departamento) do begin
			division:= emp.division;
			writeln('DIVISION: ', division);
			totalHorasDivision:= 0; montoTotalDivision:= 0;
			while (departamento = emp.departamento) and (division = emp.division) do begin
				numero:= emp.numero;
				writeln('NUMERO DE EMPLEADO: ',numero);
				totalHorasEmpleado:= 0; importeACobrar:=0;
				categoria:= emp.categoria;
				while(departamento = emp.departamento) and (division = emp.division) and (numero = emp.numero) do begin
					totalHorasEmpleado:= totalHorasEmpleado + emp.horasExtra;
					leer();
				end;
				writeln('TOTAL DE HORAS: ', totalHorasEmpleado);
				importeACobrar:= totalHorasEmpleado*valorHoraExtra[categoria];
				writeln('IMPORTE A COBRAR: ', importeACobrar);
				totalHorasDivision:= totalHorasDivision + totalHorasEmpleado;
				montoTotalDivision:= montoTotalDivision + importeACobrar;
			end;
			writeln('TOTAL HORAS DIVISION: ', totalHorasDivision);
			writeln('MONTO TOTAL DIVISION: ',montoTotalDivision);
			totalHorasDepartamento:= totalHorasDepartamento + totalHorasDivision;
			montoTotalDepartamento:= montoTotalDepartamento + montoTotalDivision;
		end;
		writeln('TOTAL HORAS DEPARTAMENTO: ', totalHorasDepartamento);
		writeln('MONTO TOTAL DEPARTAMENTO: ',montoTotalDepartamento);
	end;
	close(ar);
end.
