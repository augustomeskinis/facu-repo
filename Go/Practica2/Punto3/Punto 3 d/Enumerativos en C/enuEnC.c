enum PuntoCardinal {
    NORTE,  // 0
    SUR,    // 1
    ESTE,   // 2
    OESTE   // 3
};

/*1. C
En C, los enumerativos se declaran usando la palabra clave enum. Los valores son enteros (generalmente comenzando desde 0) y no están fuertemente tipados.
Notas:
Puedes asignar valores explícitos: enum PuntoCardinal { NORTE = 1, SUR = 2 };.
No hay verificación estricta de tipos; los valores son esencialmente enteros.
Uso: enum PuntoCardinal direccion = NORTE;.*/