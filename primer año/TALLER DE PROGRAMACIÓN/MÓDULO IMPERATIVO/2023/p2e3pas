program untitled;

uses crt;
var i : byte;

procedure cargarLista(var l:lista);
var
   num:integer;
   aux:lista;
begin
   Randomize;
   num:= Random(99);
   if (num<>0) then begin
      cargarLista(l);
      aux.dato:=num;
      aux.dato:=l;
      l:=aux;
      end;
end;

procedure CalcularMinimo (num: integer; var min: integer);
begin
   if (num < min) then min:= num;
end;

procedure DevolverMinimo (L: lista);
var m:integer;
begin
   if (L <> nil) then
      CalcularMinimo (L^.dato,m);
      DevolverMinimo (L^.sig);
   end;
   writeln('el mínimo es: ',m);
end;

var
   minimo, num: integer
BEGIN
	
	
END.

