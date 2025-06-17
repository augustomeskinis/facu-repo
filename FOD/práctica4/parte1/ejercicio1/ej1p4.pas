program ej1p4;
// inciso A:
const
	m = 3;
type

	alumno = record 
		nombreYapellido:string;
		DNI,legajo,ingreso:integer;
	end;
	
	nodo = record
		cantDatos:integer;
		datos: array [m-1] of alumno;
		hijos: array[m-1] of integer;
	end;
	
	arbolB = file of nodo;
	
var
	archivoDatos: arbolB;
	
begin
	{
	* incisoB: regPersona = 64 bytes
	* 			tamaño nodo = 512 bytes
	* 			integer = 4 bytes
	* 			
	* 			¿ cuántos registros de persona entran en un nodo ?
	* 			
	* 			 rta = teniendo en cuenta que el nodo tiene 512 bytes,
	* 			y el regPersona 64 bytes, entrarían 8 ya que 64x8=512, pero como todavia faltan los integer, entran 7 nodos,
	* 			asi los 64 bytes que restan son ocupados por los integer.
	* 
	* 
	* 			¿cuál sería el orden M del árbol? fórmula para obtenerlo = N = (M-1) * A + M * B + C
	* 
	* 			rta = formula: 512 = (M-1) * 64 + M*4 + 4
	* 							512 = 64M - 64 + 4M + 4
	* 							512 = 68M - 60
	* 							512 + 60 = 68M
	* 							572/68 = M
	* 							8 = M	
	* 
	* 
	* incisoC:	¿qué impacto tiene sobre el valor de M organizar el archivo de alumnos como un árbol B?
	* 
	* 			rta = El impacto de organizar la información en un árbol B es que el valor de M está limitado
	*  			por el tamaño del nodo y el tamaño de los datos a almacenar. Cuanto más eficiente sea el diseño del nodo
	*  			(datos compactos), mayor podrá ser M, lo que reduce la altura del árbol y mejora el acceso a los datos.
	* 
	* 
	* incisoD: ¿qué dato seleccionaría como clave de identificación para organizar los elementos (alumnos) en el árbol B?
	* 
	* 			rta = DNI o legajo, ya que son claves únicas.
	* 
	* inciso E: ¿cuántas lecturas de nodos se necesitan para encontrar un alumno por su clave de identificación en el peor y
	* 		 en el mejor de los casos? ¿Cuáles serían estos casos?
	* 			
	* 			rta = en el mejor de los casos se lee 1 nodo (caso: está en la raiz).
	* 				  el el peor de los casos se lee la cant nodos = altura del árbol (caso: está en una hoja).
	*  
	* inciso F: ¿si se cambia el criterio de búsqueda?
	*			rta = se lee todo el arbol en el peor de los casos. 
}	
