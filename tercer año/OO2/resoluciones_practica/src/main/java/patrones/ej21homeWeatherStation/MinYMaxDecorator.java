package patrones.ej21homeWeatherStation;

public class MinYMaxDecorator extends WeatherDataDecorator {


    public MinYMaxDecorator(WeatherData weatherData){
        super(weatherData);
    }

    public String minYmax (){
        double min = this.getTemperaturas().stream().mapToDouble(Double::doubleValue).min().orElseThrow();
        double max = this.getTemperaturas().stream().mapToDouble(Double::doubleValue).max().orElseThrow();
        return " Minimo: " + min + " , maximo: " + max;
    }

    public String displayData(){
        return weatherData.displayData() + this.minYmax();
    }
}
