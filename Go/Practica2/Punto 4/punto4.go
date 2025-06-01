import ("fmt"
	"bufio"
	"os"
	"strconv"
	"math"
)

func realizarSumatoria (arreglo []){
	var suma float64 = 0;
	for i=0;i<5;i++{
		suma+= 1/ float64 (arreglo[i]);
	}
	return suma;
}

func realizarProductoria(arreglo []){
	var prod float64 = 0;
	for i=0;i<5;i++{
		prod *= math.Pow( float64 (arreglo[i]) , 3) ;  
	}
	return
}

func calcularMaxMix(var arreglo [])(max int, min int){
	max int = -1;
	min int = 9999;
	for i=0;i<5;i++{
		if (arreglo[i] > max){
			max:= arreglo[i];
		}
		if (arreglo[i] < min){
			min:= arreglo[i];
		}
	}
	return max,min;
}

func main (){
	var n int;
	reader:= bufio.NewReader(os.Stdin);
	var arreglo1[5] int;
	var arreglo2[5] int;
	var arreglo3[5] int;
	var num int;
	for n=0; n < 5; n++{
		fmt.Println("ingrese el valor " , n, "para la sucesión: " 1);
		arreglo1[n]:= fmt.Scan(&num);
		fmt.Println("ingrese el valor " , n, "para la sucesión 2");
		arreglo2[n]:= fmt.Scan(&num);
		fmt.Println("ingrese el valor " , n, "para la sucesión 3");
		arreglo3[n]:= fmt.Scan(&num);
	}
	var sumatoria float64 = realizarSumatoria(arreglo1);
	var productoria float64 = realizarProductoria(arreglo2);
	var max,mic float64 = calcularMaxMix(arreglo3);
	var resultado float64 = (sumatoria - productoria) *max*min;
	fmt.Println("RESULTADO DE LA CUENTA: ", resultado);
}