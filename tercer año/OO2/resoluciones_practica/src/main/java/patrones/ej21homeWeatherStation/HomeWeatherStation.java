package patrones.ej21homeWeatherStation;

import java.util.ArrayList;
import java.util.List;

/**
 * Estación meteorológica base que implementa WeatherData.
 * Proporciona lectura de temperatura (Fahrenheit), presión y radiación solar.
 * NO debe ser abstracta. Es el objeto base que será decorado.
 */
public class HomeWeatherStation implements WeatherData {
    private double temperatura;
    private double presion;
    private double radiacionSolar;
    protected List<Double> temperaturas;

    public HomeWeatherStation(double temperatura, double presion, double radiacionSolar) {
        this.temperatura = temperatura;
        this.presion = presion;
        this.radiacionSolar = radiacionSolar;
        this.temperaturas = new ArrayList<>();
        this.temperaturas.add(temperatura);
    }

    // Retorna la temperatura en grados Fahrenheit
    @Override
    public double getTemperatura() {
        return this.temperatura;
    }

    // Retorna la presión atmosférica en hPa
    @Override
    public double getPresion() {
        return this.presion;
    }

    // Retorna la radiación solar
    @Override
    public double getRadiacionSolar() {
        return this.radiacionSolar;
    }

    // Retorna una lista con todas las temperaturas sensadas hasta el momento, en grados Fahrenheit
    @Override
    public List<Double> getTemperaturas() {
        return this.temperaturas;
    }

    // Retorna un reporte de todos los datos: temperatura, presión, y radiación solar
    @Override
    public String displayData() {
        return "Temperatura F: " + this.getTemperatura() + "; " +
                "Presión atmosf: " + this.getPresion() + "; " +
                "Radiación solar: " + this.getRadiacionSolar() + ";";
    }

    // Setters para actualizar los valores sensados
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
        this.temperaturas.add(temperatura);
    }

    public void setPresion(double presion) {
        this.presion = presion;
    }

    public void setRadiacionSolar(double radiacionSolar) {
        this.radiacionSolar = radiacionSolar;
    }
}