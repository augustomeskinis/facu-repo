program ej1p1;
type
    archivo = file of integer;
var
    archivoLogico: archivo;
    num: integer;
    nombreArchivo: string [12];
begin
    writeln ('ingrese el nombre del archivo: ');
    readln (nombreArchivo);
    assign (archivoLogico, nombreArchivo);
    rewrite (archivoLogico);
    writeln('Ingrese números enteros (30000 para terminar):');
    readln (num);
    while (num <> 30000) do begin 
        write(archivoLogico, num);
        writeln('Ingrese números enteros (30000 para terminar):');
        readln (num);
    end;
    close (archivoLogico);
end.
