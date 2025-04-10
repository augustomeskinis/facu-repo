program ej2p2;
const
	valorAlto = 9999;
type

	producto = record
		codigo,precio,stockAnual,stockMinimo:integer;
		nombre:string;
	end;
	
	venta = record
		codigoProducto,cantUnidadesVendidas:integer;
	end;
	
	archivomaestro = file of producto;
	
	archivodetalle = file of venta;
	
var
	maestro:archivomaestro; detalle:archivodetalle;
	ven:venta; mae:producto;
	nombre:string;
	
procedure leerVenta(var archivo:archivodetalle; var dato: venta);
begin
	if not eof (archivo) then
		read (archivo,dato)
	else
		dato.codigoProducto:= valorAlto;
end;

procedure crearArchivoMaestro();
var
	prod:producto;
begin
	writeln('ingrese un nombre para el archivo maestro: ');
	readln(nombre);
	assign(maestro,nombre);
	rewrite(maestro);
	writeln('ingrese los datos del producto, para terminar ingrese codigo 9999: ');
	writeln('codigo: ');
	readln(prod.codigo);
	while (prod.codigo <> valorAlto) do begin
		writeln('nombre: ');
		readln(prod.nombre);
		writeln('precio: ');
		readln(prod.precio);
		writeln('stockAnual: ');
		readln(prod.stockAnual);
		writeln('stockMinimo: ');
		readln(prod.stockMinimo);
		write(maestro,prod);
		writeln('codigo: ');
		readln(prod.codigo);
	end;
	close(maestro);
end;
procedure crearArchivoDetalle();
begin
	writeln('ingrese un nombre para el archivo detalle: ');
	readln(nombre);
	assign(detalle,nombre);
	rewrite(detalle);
	writeln('ingrese los datos de la venta, para terminar ingrese codigo 9999: ');
	writeln('codigo: ');
	readln(ven.codigoProducto);
	while(ven.codigoProducto <> valorAlto) do begin
		writeln('cantidad de unidades vendidas: ');
		readln(ven.cantUnidadesVendidas);
		write(detalle,ven);
		writeln('ingrese los datos de la venta, para terminar ingrese codigo 9999: ');
		writeln('codigo: ');
		readln(ven.codigoProducto);
	end;
end;
procedure actualizar();
var
	codActual,stockVendido:integer;
begin
	reset(maestro);reset(detalle);
	leerVenta(detalle,ven);
	while(ven.codigoProducto <> valorAlto) do begin
		codActual:= ven.codigoProducto;
		stockVendido:= 0;
		while (ven.codigoProducto = codActual) do begin
			stockVendido:= stockVendido + ven.cantUnidadesVendidas;
			leerVenta(detalle,ven);
		end;
		while(mae.codigo <> codActual)do
			read(maestro,mae);
		mae.stockAnual:= mae.stockAnual - stockVendido;
		seek(maestro, filepos(maestro)-1);
		write(maestro,mae);
		if (not(EOF(maestro))) then 
   			read(maestro, mae);
   	end;
   	close(detalle);
   	close(maestro);
end;
procedure exportarATexto();
var
	t:text;
begin
	reset(maestro);
	assign(t,'stock_minimo.txt');
	rewrite(t);
	while not eof(maestro) do begin
		read(maestro,mae);
		with mae do begin
			writeln(t,nombre);
			writeln(t,codigo,'',precio,'',stockAnual,'',stockMinimo);
		end;
	end;
end;
procedure imprimirArchivoMaestro();
begin
	reset(maestro);
	while not eof (maestro) do begin
		read(maestro,mae);
		writeln('producto: ', mae.nombre);
		writeln('precio: ', mae.precio);
		writeln('stock actual: ', mae.stockAnual);
		writeln('stock minimo: ', mae.stockMinimo);
		writeln('codigo: ', mae.codigo);
	end;
	close(maestro);
end;
procedure menuDeOpciones();
var 
	opcion: byte;
begin
	writeln('				MENU DE OPCIONES');
	writeln('				opcion 1: crear archivo maestro');
	writeln('				opcion 2: crear archivo detalle');
	writeln('				opcion 3: actualizar el archivo maestro con el detalle');
	writeln('				opcion 4: imprimir el archivo maestro');
	writeln('				opcion 5: Listar en un archivo de texto llamado stock_minimo.txt aquellos productos...');
	writeln('				opcion 6: salir del programa');
	readln(opcion);
	while (opcion <> 6) do begin
		case opcion of 
			1:crearArchivoMaestro();
			2:crearArchivoDetalle();
			3:actualizar();
			4:imprimirArchivoMaestro();
			5:exportarATexto();
		else
			writeln('La opcion ingresada no corresponde a ninguna de las mostradas en el menu de opciones');
		end;
		writeln('			MENU DE OPCIONES');
		writeln('			opcion 1: crear archivo maestro');
		writeln('			opcion 2: crear archivo detalle');
		writeln('			opcion 3: actualizar el archivo maestro con el detalle');
		writeln('			opcion 4: imprimir el archivo maestro');
		writeln('			opcion 5: Listar en un archivo de texto llamado stock_minimo.txt aquellos productos...');
		writeln('			opcion 6: salir del programa');
		readln(opcion);
	end;
end;
begin
	menuDeOpciones();
end.
