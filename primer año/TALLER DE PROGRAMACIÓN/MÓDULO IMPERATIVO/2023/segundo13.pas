program segundodo1;

const
corte=0;

type
 
 rubro= 1..8; 
 producto=record
   codp:integer;
   precio:real;
 end;
 
 lista=^nodo;
 nodo=record
   dato:producto;
   sig:lista;
 end;
 
vectorrubro=array[rubro] of lista;

procedure leer ( var r:producto ; var c:rubro);
begin 
	writeln ('ingrese el precio');
  readln(r.precio);
  if(r.precio<>corte) then
  begin
		writeln ('ingrese el codigo');
    readln(r.codp);
    writeln ('ingrese el rubro');
    readln(c);
  end;  
end;

procedure agregar_ordenado( var l:lista ; r:producto );
var
  nue,ant,act:lista;
begin
  new(nue);
  nue^.dato:=r;
  act:=l;
  ant:=l;
  while(act<> nil) and ( r.codp > act^.dato.codp) do 
   begin
    ant:=act;
    act:= act^.sig;
   end;
  if( act=ant) then
    l:=nue
  else
    ant^.sig:=nue;
  nue^.sig:=act;
end;        

procedure cargar( var v:vectorrubro);
var 
  c:rubro;
  r:producto;
begin
   leer(r,c);
   while(r.precio<>corte) do begin
     agregar_ordenado(v[c] , r);
     leer(r,c);
   end;
 end;
 
procedure iniciar (var v:vectorrubro);
var
  i:integer;
begin
  for i:= 1 to 8 do
    v[i]:= nil;
end;



procedure imprimir(l:lista ; i:integer);
begin
  while(l<>nil) do
   begin
    writeln('el codigo', l^.dato.codp,'pertenece al rubro ', i);
    l:= l^.sig;
   end;
end;
    
procedure mostrar(v:vectorrubro);
var
 i: integer;
begin
 for i := 1 to 8 do 
   imprimir(v[i],i);
end;



var 
  v: vectorrubro; 
begin

 iniciar(v);  
 cargar(v);
 mostrar(v);
end.
  

