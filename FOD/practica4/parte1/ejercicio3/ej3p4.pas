program ej3p4;
{
* incisoA: ¿Cómo se organizan los elementos (claves) de un árbol B+? ¿Qué elementos se encuentran 
* 			en los nodos internos y que elementos se encuentran en los nodos hojas?
* 
* 			rta = en un arbolB+ los elementos se organizan de la siguiente manera 
* 					nodos internos = contienen solo las claves (por ej DNI) usadas para guiar la búsqueda
* 									 contienen los punteros a los hijos (otros nodos del árbol)
* 									 no contienen referencias directas a los registros de datos
* 					nodos hoja  = Contienen todas las claves del índice
* 								  contienen punteros a los registros del archivo de datos 
* 								  Están enlazados secuencialmente entre sí, lo que permite recorrer el índice de forma ordenada
* 									 y eficiente para búsquedas por rango.
* 
* inciso B: ¿Qué característica distintiva presentan los nodos hojas de un árbol B+? ¿Por qué?
* 			basicamente tienen todo el archivo 
* . 		LOS NODOS NO TERMINALES NO TIENEN DATOS SINO PUNTEROS A LOS DATOS.
* 
}
// inciso C: definir el arbolB+
const
  MaxClaves = 50;
  MaxHijos = MaxClaves + 1;

type
  { Registro de datos del archivo de alumnos }
  alumno = record
    dni: integer;
    nombre: string[30];
    apellido: string[30];
    legajo: integer;
    anioIngreso: integer;
  end;

  { Nodo interno del árbol B+ }
  nodoInterno = record
    esHoja: boolean;  { TRUE si es hoja, FALSE si es interno }
    cantClaves: integer;
    claves: array[1..MaxClaves] of integer;      { DNIs }
    hijos: array[1..MaxHijos] of integer;        { punteros a nodos hijos }
  end;

  { Nodo hoja del árbol B+ }
  nodoHoja = record
    esHoja: boolean;  { TRUE si es hoja, FALSE si es interno }
    cantClaves: integer;
    claves: array[1..MaxClaves] of integer;      { DNIs }
    referencias: array[1..MaxClaves] of integer; { punteros a datos del archivo }
    sigHoja: integer;                            { puntero a la siguiente hoja (para recorrido secuencial) }
  end;

  { Nodo general del árbol B+ (puede ser hoja o interno) }
  nodoArbolB+ = record
    case boolean of
      true: (hoja: TNodoHoja);
      false: (interno: TNodoInterno);
  end;

  archivoAlumno = file of alumno;
  archivoIndice = file of nodoArbolB+;
{
* incisoD:  Describa, con sus palabras, el proceso de búsqueda de un alumno con un DNI específico
			haciendo uso de la estructura auxiliar (índice) que se organiza como un árbol B+. ¿Qué
			diferencia encuentra respecto a la búsqueda en un índice estructurado como un árbol B?
* 
* 			rta = 1. comienzo en la raiz del árbolB
* 				  2. comparación de las claves del nodo actual para ver con que hijo continuar
* 				  3. se repite este proceso hasta llegar a una hoja.
* 				  4. en el nodo hoja se busca el DNI entre las claves
* 				  5. si se encuentra, se usa el puntero al archivo de datos para acceder al registro del alumno.
* 
* 				  diferencia con el árbolB: En un árbol B, los datos pueden estar tanto en los nodos internos como en las hojas.
* 											En un árbol B+, todas las claves y referencias a los datos están en las hojas.
* 
* incisoE: Explique con sus palabras el proceso de búsqueda de los alumnos que tienen DNI en el
			rango entre 40000000 y 45000000, apoyando la búsqueda en un índice organizado como un
			árbol B+. 
* 
* 			rta = 	se recorre desde la raiz hasta llegar al nodo hoja que contiene la clave 40.000.000 o la más próxima superior.
* 				  	Desde ese nodo hoja, se recorre secuencialmente hacia la derecha (siguiendo los enlaces entre hojas).
* 					En cada hoja se buscan las claves que estén dentro del rango.
					Esto se repite hasta encontrar una clave mayor a 45.000.000 o hasta llegar al final.
					Por cada DNI dentro del rango, se usa el puntero al archivo de datos para recuperar el registro del alumno.
* 
* 			¿Qué ventajas encuentra respecto a este tipo de búsquedas en un árbol B?
* 
* 			rta = 	En un árbol B, como los datos no están organizados secuencialmente en las hojas, no se puede recorrer fácilmente un rango:
					Se debería hacer una búsqueda separada por cada valor posible del rango o recorrer muchos nodos desordenados.
					En un árbol B+, como las hojas están enlazadas en orden y contienen todas las claves reales,
				    el recorrido por rango es rápido, secuencial y eficiente. 
 }
