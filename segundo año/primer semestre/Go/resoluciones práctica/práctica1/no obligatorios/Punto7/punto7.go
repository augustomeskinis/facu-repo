package main

import "fmt"

func main() {
	var temp float64
	var temperaturas [3]float64
	var max float64 = 0
	var min float64 = 40
	for i := 1; i < 10; i++ {
		fmt.Scan(&temp)
		switch {
		case temp > 37.5:
			temperaturas[0]++
			if temp >= max {
				max = temp
			}
		case (temp > 36) && (temp < 37.5):
			temperaturas[1]++
		case temp < 36:
			temperaturas[2]++
			if temp <= min {
				min = temp
			}
		}
	}
	fmt.Println("Porcentaje de pacientes en el grupo 1: ", (temperaturas[2]/10)*100, "%")
	fmt.Println("Porcentaje de pacientes en el grupo 2: ", (temperaturas[1]/10)*100, "%")
	fmt.Println("Porcentaje de pacientes en el grupo 3: ", (temperaturas[0]/10)*100, "%")
	fmt.Println("Temperatura máxima: ", max)
	fmt.Println("Temperatura mínima: ", min)
	fmt.Println("Temperatura promedio entre la máxima y la mínima: ", (max+min)/2)
}

// a.
/*
	No, en la mayoría de los lenguajes de programación, las estructuras case o switch no admiten tipos de datos reales (como float o double). Esto se debe a que los valores de punto flotante pueden tener imprecisiones en su representación binaria, lo que hace que la comparación exacta sea poco confiable.

	Algunos lenguajes que no permiten switch con números reales:
		C, C++, Java, JavaScript: Solo permiten switch con valores enteros, caracteres o cadenas.

		Python: No tiene switch, pero usa match-case desde Python 3.10, que admite tipos más flexibles, aunque sigue sin ser ideal para float.
	Alternativa: Usar if-elif-else en lugar de switch para evaluar rangos de números reales.
*/

/*
	Cada lenguaje maneja el casting de manera diferente:

	Lenguaje	Float → Int	Int → Float
	C/C++	(int) num	(float) num
	Java	(int) num	(float) num
	Python	int(num)	float(num)
	Go	int(num)	float64(num)
	JavaScript	Math.floor(num) (redondea hacia abajo)	parseFloat(num)
*/
