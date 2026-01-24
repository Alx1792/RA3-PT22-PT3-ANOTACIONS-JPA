package domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("car")
public class Car extends Vehicle{
    @Column(name = "doors")
    private Integer doors;
    @Column(name = "seats")
    private Integer seats;

    public Car() {
    }

    public Car(Integer doors, Integer seats) {
        this.doors = doors;
        this.seats = seats;
    }

    public Car(Integer id, String brand, Integer year, float price, Integer doors, Integer seats) {
        super(id, brand, year, price);
        this.doors = doors;
        this.seats = seats;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Car{" +
                "doors=" + doors +
                ", seats=" + seats +
                '}';
    }
}
