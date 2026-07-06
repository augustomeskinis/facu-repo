package refactoring.ejercicio4;

import java.time.LocalDate;

public class HotelStay extends Product {
    public double cost;
    private Hotel hotel;

    public HotelStay(double cost, TimePeriod timePeriod, Hotel hotel) {
        super(timePeriod);
        this.cost = cost;
        this.hotel = hotel;
    }

    public double priceFactor() {
        return this.cost / this.price();
    }

    public double price() {
        return this.hotel.price(this.timePeriod);
    }
}
