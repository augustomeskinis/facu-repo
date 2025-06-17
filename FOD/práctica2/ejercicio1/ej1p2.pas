program ej1p2;
const 
	valorAlto = 9999;
type
	empleado = record
		codigo:integer;
		nombre:string;
		montoComision:integer;
	end;
	
	archivo = file of empleado;
var
	ar1, ar2: archivo;
	emp: empleado;
	
procedure leerEmpleado(var ar:archivo;var emp: empleado);
begin
	if not eof (ar) then
		read(ar,emp)
	else
		emp.codigo:=valorAlto;
end;
var
	suma,codActual:integer;
begin
	assign(ar1,'archivo existente');
	assign(ar2, 'archivo nuevo');
	rewrite(ar2);
	reset(ar1);
	leerEmpleado(ar1,emp);
	while (emp.codigo <> valorAlto) do begin
		suma:=0;
		codActual:=emp.codigo;
		while (emp.codigo <> valorAlto) and (codActual = emp.codigo) do begin
			suma:= suma + emp.montoComision;
			leerEmpleado(ar1,emp);
		end;
		emp.montoComision:= suma;
		write(ar2,emp);
	end;
	close(ar1);
	close(ar2);
end.
