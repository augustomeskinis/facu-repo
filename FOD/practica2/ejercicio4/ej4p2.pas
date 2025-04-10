program ej4p2;
const
	valorAlto = 9999;
type
	producto = record
		codigo:integer;
		nombre:string;
		descripcion:string;
		stockDisponible:integer;
		stockMinimo:integer;
		precio:integer;
	end;
	
	archivoMaestro = file of producto;
	
	venta = record
		codigoProducto,cantVendida:integer;
	end;
	
	archivoDetalle = file of venta;
	
	vector = array [1..30] of archivoDetalle;
	
var
	maestro:archivoMaestro; prod:producto;
	detalles:vector; ven:venta;
	
procedure leerVenta(var archivo: detalle; dato: venta);
begin
	if not eof (archivo) then
		read(archivo,dato)
	else
		dato.cod:= valorAlto;
end;
procedure modificarMaestro();
var 
	i:integer;
begin
	reset(maestro);
	for i:= i to 30 do begin
		while (detalle[i].codigoProducto <> valorAlto) do begin
			

























