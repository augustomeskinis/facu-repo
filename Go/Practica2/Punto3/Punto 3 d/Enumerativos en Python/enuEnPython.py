from enum import Enum

class PuntoCardinal(Enum):
    NORTE = "N"
    SUR = "S"
    ESTE = "E"
    OESTE = "O"
    
"""
Notas:
Los valores pueden ser de cualquier tipo (cadenas, enteros, etc.).
Acceso: PuntoCardinal.NORTE o PuntoCardinal["NORTE"].
Los enums son inmutables y no se pueden modificar en tiempo de ejecución.
Uso: direccion = PuntoCardinal.NORTE.
"""