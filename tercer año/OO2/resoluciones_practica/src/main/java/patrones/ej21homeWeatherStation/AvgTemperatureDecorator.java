package patrones.ej21homeWeatherStation;

public class AvgTemperatureDecorator extends WeatherDataDecorator {

    public AvgTemperatureDecorator(WeatherData weatherData) {
        super(weatherData);
    }

    public double avgTemperature(){
        return this.getTemperaturas().stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public String displayData(){
        return this.weatherData.displayData() + " ,promedio: " + this.avgTemperature();
    }

}
