package domain;

public class Car extends Vehicle{
    private Integer doors;
    private Integer seats;

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
