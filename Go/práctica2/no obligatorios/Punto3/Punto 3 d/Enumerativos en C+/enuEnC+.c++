// Estilo C
enum PuntoCardinal {
    NORTE, SUR, ESTE, OESTE
};

// Estilo moderno con enum class
enum class PuntoCardinal {
    NORTE, SUR, ESTE, OESTE
};

/*2. C++
C++ hereda la sintaxis de C, pero introduce enum class (desde C++11) para un tipado más fuerte y evitar colisiones de nombres.
Notas:
Con enum class, los valores están en un espacio de nombres propio: PuntoCardinal::NORTE.
enum class evita que los valores se conviertan implícitamente a enteros.
Uso: PuntoCardinal dir = PuntoCardinal::NORTE;.
3. Java*/