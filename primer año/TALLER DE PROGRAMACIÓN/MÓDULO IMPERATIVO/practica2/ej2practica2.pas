program ej2practica2;

procedure imprimir (n: integer);
begin
	if (n > 0) then begin
		imprimir (n DIV 10); // esto achica el numero
		writeln(n MOD 10); // esto imprime el ultimo digito
	end;
end;

procedure procesar_numero ();
var
	n: integer;
begin
	writeln('ingrese un numero: ');
	readln(n);
	repeat 
		imprimir(n);
		writeln('ingrese un numero: ');
		readln(n);
	until (n=0);
end;
begin
	procesar_numero ();
end.
