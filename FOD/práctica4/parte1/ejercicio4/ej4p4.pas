program ej4p4;
const 
	m = 3;
type
	
	alumno = record
		nombreYapellido:string;
		DNI,legajo,ingreso:integer;
	end;
	
	Nodo = record
		cantClaves:integer;
		claves: array[1..M-1]of integer; // clave = DNI
		enlances: array [1..M-1] of integer;
		hijos:array[1..M]of integer;
	end;
	
	archivoDatos = file of alumno;
	arbolB = file of Nodo;

procedure buscar(NRR, clave, NRR_encontrado, pos_encontrada:integer, resultado:boolean);
var 
	clave_encontrada: boolean;
begin
	if (nodo = null)
		resultado := false; {clave no encontrada}
	else
		posicionarYLeerNodo(A, nodo, NRR);
		claveEncontrada(A, nodo, clave, pos, clave_encontrada);
		
	if (clave_encontrada) then begin
		NRR_encontrado := NRR; { NRR actual }
		pos_encontrada := pos; { posicion dentro del array }
		resultado := true;
	end
	else
		buscar(nodo.hijos[pos], clave, NRR_encontrado, pos_encontrada, resultado)
end;

{
* incisoA:	¿qué hace posicionarYLeerNodo?
* 
* 			rta = ubica el archivo (A) en la posición NRR y 
* 			lo lee para guardarlo en la variable nodo
* 
* 			¿cómo deben enviarse los parámetros?
* 
* 			rta = A -> por valor, el archivo ya está abierto y no se modifica la referencia
* 				  nodo -> por referencia
* 				  NRR -> por valor 
* 
* 			implementación acá abajo
* }
procedure posicionarYleerNodo(A:arbolB,var nodo:Nodo,NRR:integer)
begin
	seek(A,NRR);
	read(A,nodo);
end;

{
* incisoB:  ¿qué hace claveEncontrada?
* 
* 			rta = busca en el arreglo "claves" del nodo (cargado en el procedimiento posicionarYLeerNodo) 
* 				  la clave recibida cómo parámetro en "buscar"
* 				  si la encuentra, guarda en la variable pos la posición del arreglo en la que se encuentra
* 			      y setea la variable booleana "clave_encontrada" en true
* 
* 			¿cómo deben ser enviados los parámetros?
* 
* 			rta =  A-> error, este parámetro no va
* 				   nodo -> por valor, solo hay que leer
* 					clave -> por valor, sirve para comparar con la clave leida
* 					pos -> por referencia
* 					clave encontrada -> por referencia
* 					
*  			implementación acá abajo
}
procedure claveEncontrada(nodo:Nodo; clave, pos: integer; clave_encontrada:boolean);
begin
	pos:= 1;
	while (pos<nodo.cantClaves) and (nodo.clave[pos]>clave)do
		pos:= pos+1;
	if (pos<nodo.cantClaves) and (nodo.clave[pos] = clave) then
		clave_encontrada:= true;
end;

{
* incisoC: ¿hay error en el código buscar?
* 
* 			rta= si, para el procedimiento claveEncontrada el parámetro "A" no es necesario
* 				también le falta la declaración de algunas variables a no ser que sean globales
* 				también la primer pregunta (if nodo = null) no tiene sentido porque no sea habia ledio todavia,
* 				en todo caso sería(segun chatGPT) -> if (NRR=-1) then resultado:=false
* 
* incisoD ¿qué cambios necesita el procedimiento buscar para que funcione en un árbolB+?
* 
* 			rta = 	Asegurarte de bajar siempre hasta una hoja, aunque "encuentres" la clave antes.
					Solo dar como resultado positivo si estás en una hoja y la clave fue encontrada.
					
					implementacion acá abajo
}
procedure buscar(NRR: integer; clave: integer; var NRR_encontrado, pos_encontrada: integer; var resultado: boolean);
var
  nodo: TipoNodo;
  clave_encontrada: boolean;
  pos: integer;
begin
  if (NRR = -1) then
    resultado := false  // árbol vacío
  else
  begin
    PosicionarYLeerNodo(A, nodo, NRR);  // leer nodo desde archivo
    claveEncontrada(A, nodo, clave, pos, clave_encontrada);

    if nodo.esHoja then
    begin
      // Solo en hojas se puede encontrar la clave realmente
      if clave_encontrada then
      begin
        NRR_encontrado := NRR;
        pos_encontrada := pos;
        resultado := true;
      end
      else
        resultado := false;
    end
    else
    begin
      // Siempre seguir bajando en árboles B+
      buscar(nodo.hijos[pos], clave, NRR_encontrado, pos_encontrada, resultado);
    end;
  end;
end;
