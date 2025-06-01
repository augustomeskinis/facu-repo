{
	overflow = cuando en un árbol se quiere insertar en un nodo un registro pero el nodo
	no tiene suficiente espacio, por lo que se divide y una clave se promociona al nodo padre.
	
	underflow = ocurre cuando: se elimina una clave de un nodo y este queda con menos claves que el mínimo permitido.
				qué se hace: se intenta redistribuir claves con un hermano o, si no es posible, se realiza una fusión.
				ejemplo: si un nodo debe tener al menos 2 claves y queda con 1 después de una eliminación, hay underflow.

	redistribución = Cuando un nodo tiene underflow puede trasladarse llaves de un nodo
					adyacente hermano (en caso que este tenga suficientes elementos)

								nodo adyacente hermano: dos nodos son adyacentes hermanos cuando tienen el mismo padre y
								 son apuntados por punteros adyacentes en el padre.



	fusión o concatenación = Ocurre cuando: hay underflow y no se puede redistribuir porque los hermanos tampoco tienen claves extra.
							Qué se hace: se fusiona el nodo con un hermano y una clave del padre baja entre ellos.
							Resultado: se reduce el número de nodos en el árbol y puede propagarse hacia arriba si el padre sufre underflow.
}
