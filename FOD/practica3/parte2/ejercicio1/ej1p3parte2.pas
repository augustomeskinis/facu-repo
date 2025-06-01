program ej1parte2p3;
type
	producto = record
		codigo,precio,stockAnual,stockMinimo:integer;
		nombre:string;
	end;
	
	archivoMAestro = file of producto;
	
	venta = record
		codigo,cantUV:integer
	end;
	
	archivoDetalle = file of venta;
	
var
	maestro:archivoMaestro;
	detalle:archivoDetalle;
	m:producto;
	det:venta;
procedure actualizarMaestro();
var
	encontre:boolean;
begin
	encontre:=false;
	assign(maestro,'arMaestro');
	reset(maestro);
	assign(detalle,'arDetalle');
	reset(detalle);
	while not eof (Detalle) do begin
		seek(maestro,0);
		read(detalle,det);
		while not eof (maestro) and not encontre do begin
			read(maestro,m);
			if (m.codigo = det.codigo) then
				encontre:= true;
		end;
		if (encontre) then begin
			m.stockAnual:= m.stockAnual - det.cantUV;
			seek(maestro,filePos(maestro)-1);
			write(maestro,m);
			encontre:= false;
		end;
	end;
	close(detalle);close(maestro);
end;

procedure actualizarMaestroINCISOB();
{
Recorre el maestro una sola vez.

Para cada producto, busca en el detalle desde el inicio si hay una venta con el mismo código.

Si encuentra, actualiza el stock.

Como cada venta aparece una sola vez, no hay acumulación ni múltiples escrituras.
}
var
  encontre: boolean;
begin
  assign(maestro, 'arMaestro');
  reset(maestro);
  assign(detalle, 'arDetalle');
  reset(detalle);

  while not eof(maestro) do begin
    read(maestro, m);
    
    // Busco si hay una venta para este producto
    seek(detalle, 0);  // vuelvo al inicio del detalle
    encontre := false;
    while not eof(detalle) and not encontre do begin
      read(detalle, det);
      if det.codigo = m.codigo then begin
        m.stockAnual := m.stockAnual - det.cantUV;
        seek(maestro, filepos(maestro) - 1); // volver para escribir
        write(maestro, m);
        encontre := true;
      end;
    end;
  end;

  close(detalle);
  close(maestro);
end;
begin
	assign(maestro,'arMaestro');
	rewrite(maestro);
	assign(detalle,'arDetalle');
	rewrite(detalle);
	// cargar maestro y detalle
	actualizarMaestro();
end;
