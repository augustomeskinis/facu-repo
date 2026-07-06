package refactoring.ejercicio4;

import java.time.LocalDate;

public class CarRental extends Product {
    private double cost;
    private Company company;

    public CarRental(double cost, TimePeriod timePeriod, Company company) {
        super(timePeriod);
        this.cost = cost;
        this.company = company;
    }

    public double price() {
        return this.company.price();
    }

    public double cost() {
        return this.cost;
    }
}
