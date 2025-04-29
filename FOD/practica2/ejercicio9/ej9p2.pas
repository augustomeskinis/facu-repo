program ej9p2;
const
	valorAlto = 9999;
type
	
	regCliente = record
		codigo:integer;
		nombre,apellido:string;
	end;
	
	
	venta = record
		cliente:regCliente;
		ano,mes,dia,monto:integer;
	end;

	archivoVenta = file of venta;

var
	ven:venta;
	archivo:archivoVenta;

procedure leer();
begin
	if not eof (archivo) then
		read(archivo,ven)
	else
		ven.cliente.codigo:= valorAlto;
end;

procedure recorrerArchivo;
var
	totalMensual,totalAnual,totalEmpresa,codigo,ano,mes:integer;
begin
	reset(archivo);
	totalEmpresa:= 0;
	leer();
	while(ven.cliente.codigo <> valorAlto) do begin
		writeln('CLIENTE');
		writeln('CODIGO: ', ven.cliente.codigo);
		writeln('NOMBRE: ', ven.cliente.nombre);
		writeln('APELLIDO: ', ven.cliente.apellido);
		codigo:= ven.cliente.codigo;
		while (ven.cliente.codigo = codigo) do begin
			writeln('ANIOO:',ven.ano);
			totalAnual:=0;
			ano:= ven.ano;
			while(ven.cliente.codigo = codigo) and (ven.ano = ano) do begin
				writeln('MES: ', ven.mes);
				totalMensual:=0;
				mes:= ven.mes;
				while (ven.cliente.codigo = codigo) and (ven.ano = ano) and (ven.mes = mes) do begin
					totalMensual:= totalMensual + ven.mes;
					leer();
				end;
				writeln('TOTAL MENSUAL: ', totalMensual);
				totalAnual:= totalAnual + totalMensual;
			end;
			writeln('TOTAL ANUAL, ', totalAnual);
			totalEmpresa:= totalEmpresa + totalAnual;
		end;
	end;
	writeln('TOTAL EMPRESA: ',totalEmpresa);
	close(archivo);
end;

begin
	recorrerArchivo();
end.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
