program ej2p4;
// inciso A:
const 
	m = 3;
type
	
	alumno = record
		nombreYapellido:string;
		DNI,legajo,ingreso:integer;
	end;
	
	nodo = record
		cantClaves:integer;
		claves: array[1..M-1]of integer; // clave = DNI
		enlances: array [1..M-1] of integer;
		hijos:array[1..M]of integer;
	end;
	
	archivoDatos = file of alumno;
	arbolB = file of nodo;
begin
{
* inciso B:  Suponga que cada nodo del árbol B cuenta con un tamaño de 512 bytes. ¿Cuál sería el
			orden del árbol B (valor de M) que se emplea como índice?
* 			
* 			rta = para resolverlo voy a usar la fórmula del punto anterior, pero sin la A
* 				 ( ya que los registros no se almacenan en este archivo )
* 				  entonces =  N = (M-1) + M * B + C
* 							  512 = (M-1) + M*4 + 4
* 							  512 = M-1 + 4M + 4
* 							  512 = 5M + 3
* 							  509 = 5M
* 							  509/5 = M
* 							  101 = M	
* inciso C: ¿Qué implica que el orden del árbol B sea mayor que en el caso del ejercicio 1?
* 			
* 			rta = reduce por mucho la altura del árbol y mejora el acceso a los datos, lo que significa
* 					que esta manera de organizar los datos (archivo de índices como árbol B) es mejor que la organización
* 					del punto 1 (archivo de datos como árbolB)
* 
* 
* inciso D: Describa con sus palabras el proceso para buscar el alumno con el DNI 12345678 usando el índice definido en este punto.
* 
* 			rta = 1. Se accede a la raíz del árbol B (índice).
* 				2. Se compara el DNI buscado (12345678) con las claves del nodo actual.
				3. Según el resultado de la comparación, se sigue el puntero correspondiente al hijo adecuado.
				4. 	Este proceso se repite hasta llegar a una hoja o encontrar la clave.
				5. Una vez encontrada la entrada con el DNI, esta contiene un puntero al registro de datos correspondiente en el archivo de alumnos.
				6. Finalmente, se accede a ese registro en el archivo de datos y se recupera toda la información del alumno.
* 
* 
* inciso E: ¿Qué ocurre si desea buscar un alumno por su número de legajo? ¿Tiene sentido usar el índice que organiza el acceso al archivo de alumnos por DNI?
* 			
* 			rta = la búsqueda no sería eficiente. el orden del árbol (DNI) perdería sentido. 
* 	
* 			¿Cómo haría para brindar acceso indizado al archivo de alumnos por número de legajo?
* 			
* 			rta = se crea otro archivo, en este el campo de claves serían en legajo en vez del DNI.
* 
* 
* inciso F: Suponga que desea buscar los alumnas que tienen DNI en el rango entre 40000000 y
			45000000. ¿Qué problemas tiene este tipo de búsquedas con apoyo de un árbol B que solo
			provee acceso indizado por DNI al archivo de alumnos?
* 
* 			rta = El árbol B con acceso solo por índice no está diseñado para búsquedas POR RANGO eficientes,
* 			 ya que requiere múltiples accesos y no permite un recorrido ordenado fluido si las hojas no están enlazadas.
* 			diría (creo) que estos árboles son eficientes para las búsquedas de un DNI en específico.
* 	
}
end.
