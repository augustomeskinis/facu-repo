package patrones.ej21homeWeatherStation;

public class CelsiusDecorator extends WeatherDataDecorator {


    public CelsiusDecorator(WeatherData weatherData) {
        super(weatherData);
    }

    public double celsius(){
        return (this.getTemperatura()-32) / 1.8;
    }

    public String displayData(){
        return this.weatherData.displayData() + "celsius: " + celsius();
    }
}
