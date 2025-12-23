NOTAS HU:



1 - cuando varias historias tienen criterios de aceptación comunes debería separarse en otras historias



2 - en el título el rol debe ser bien específico

 	ejemplo: <persona> no es lo mismo que <matriculado> ; <médico> no es lo mismo que <médico registrado y autenticado>



3 - en los escenarios

 	DADO:

 	- en los existosos van todo lo que me condiciona el sistema

 		ejemplo: *DADO el DNI 22.222.222 no matriculado, el email 22222222@gmail.com no matriculado y las condiciones son las adecuadas para un pago exitoso*



 	- en los fallidos va solo el que me lo hace fallar

 		ejemplo (fallido por DNI no matriculado): *DADO el DNI 22.222.222 no matriculado*



 	CUANDO: va lo que hace el rol

 		ejemplo: *CUANDO la persona ingresa...* (TODO lo que ingresa)



 	ENTONCES: lo que hace el sistema (no lo que NO hace)

 		ejemplo: *ENTONCES el sistema retorna error por DNI no matriculado*

 	ejemplo que NO va: \*ENTONCES el sistema no registra el DNI\*







4 - tener en cuenta, hay algunos casos que en un escenario fallido en el DADO hay que poner más de una condición, esto es por orden de ejecución:

 	ejemplo (escenario de Pagar con tarjeta)

 

 			Escenario 2: Pago fallido por número de tarjeta de crédito inexistente

 				*DADO* la conexión con el servidor del banco exitosa y el número 3456 no corresponde a un número de tarjeta de crédito,

 				*CUANDO* el matriculado o la persona ingresa el número de tarjeta 3456 y presiona “Pagar”

 				*ENTONCES* el sistema retorna un error por número de tarjeta inexistente.

 

 	explicación

 

 			*en este escenario, por más que falle por número de tarjeta inexistente,*

 		\*igual hay que aclarar que la conexión con el servidor de banco es exitosa,\*

&nbsp;		\\\*porque por orden de ejecución no llegaría nunca al pagar con tarjeta\\\*



