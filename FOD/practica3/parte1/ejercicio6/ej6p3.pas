program ej6p3;
type
	regMaestro = record
		cod,stock,precioUnitario:integer;
		descripcion,colores,tipoPrenda:string;
	end;
	
	archivoMaestro = file of regMaestro;
	
	archivoDetalle = file of integer;

procedure bajaLogica(var arM:archivoMaestro; var arD:archivoDetalle);
var
	regM:regMaestro;
	cod:integer;
begin
	assign(arD,'archivo detalle');
	reset(arD);
	read(arD,cod);
	while not eof (arD) do begin
		assign(arM,'archivo maestro');
		reset(arM);
		read(arM,regM);
		while(cod <> regM.cod)do
			read(arM,regM);
		regM.cod:= regM.cod * -1;
		seek(arM,filePos(arM)-1);
		write(arM,regM);
		close(arM);
		read(arD,cod);
	end;
	close(arM)
end;

procedure efectivizarBajaLogica(var archivoViejo,archivoNuevo: archivoMaestro);
var
	reg:regMaestro;
begin
	assign(archivoNuevo,'archivo nuevo');
	rewrite(archivoNuevo);
	reset(archivoViejo);
	while not eof (archivoViejo) do begin
		read(archivoViejo,reg);
		if (reg.cod > 0) then
			write(archivoNuevo,reg)
	end;
	close(archivoViejo);
	close(archivoNuevo);
	rename(archivoNuevo,'archivo maestro'); // renombra el archivo nuevo con el nombre del archivo maestro original
end;
var
	arM,arMNuevo:archivoMaestro;
	arD:archivoDetalle;
begin
	assign(arM,'archivo maestro');
	rewrite(arM);
	assign(arD,'archivo detalle');
	rewrite(arD);
	// acá irian los procesos de creación de los archivos 
	bajaLogica(arM,arD);
	efectivizarBajaLogica(arM,arMNuevo);
end.
