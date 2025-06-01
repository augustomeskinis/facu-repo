{resolución de matias Guaymas}

program ejercicio3;
const
    dimf = 3;
    //dimf = 5;
type
    info = record
        cod: integer;
        fecha: string;
        tiempo: real;
    end;
    arc = file of info;
    vecDetalles = array[1..5] of arc;
procedure merge(var mae: arc; var v: vecDetalles);
var
    i: integer;
    regDet, aux: info;
    ok: boolean;
begin
    assign(mae, 'ArchivoMaestro');
    rewrite(mae);
    for i:= 1 to dimf do
        begin
            reset(v[i]);
            while(not eof(v[i])) do
                begin
                    read(v[i], regDet);
                    ok:= false;
                    seek(mae, 0);
                    while(not eof(mae)) and (not ok) do
                        begin
                            read(mae, aux);
                            if(aux.cod = regDet.cod) then
                                ok:= true;
                        end;
                    if(ok) then
                        begin
                            aux.tiempo:= aux.tiempo + regDet.tiempo;
                            seek(mae, filepos(mae)-1);
                            write(mae, aux);
                        end
                    else
                        write(mae, regDet);
                end;
            close(v[i]);
        end;
    close(mae);
end;
procedure imprimirArchivo(var mae: arc);
var
    i: info;
begin
    reset(mae);
    while(not eof(mae)) do
        begin
            read(mae, i);
            writeln('Codigo=', i.cod, ' TiempoTotal=', i.tiempo:0:2);
        end;
    close(mae);
end;
procedure crearUnSoloDetalle(var det: arc);
var
    carga: text;
    nombre: string;
    i: info;
begin
    writeln('Ingrese la ruta del detalle');
    readln(nombre);
    assign(carga, nombre);
    reset(carga);
    writeln('Ingrese un nombre para el archivo detalle');
    readln(nombre);
    assign(det, nombre);
    rewrite(det);
    while(not eof(carga)) do
        begin
            with i do
                begin
                    readln(carga, cod, tiempo, fecha);
                    write(det, i);
                end;
        end;
    writeln('Archivo binario detalle creado');
    close(det);
    close(carga);
end;
procedure crearDetalles(var vec: vecDetalles);
var
    i: integer;
begin
    for i:= 1 to dimf do
        crearUnSoloDetalle(vec[i]);
end;
var
    vec: vecDetalles;
    mae: arc;
begin
    crearDetalles(vec);
    merge(mae, vec);
    imprimirArchivo(mae);
end.
