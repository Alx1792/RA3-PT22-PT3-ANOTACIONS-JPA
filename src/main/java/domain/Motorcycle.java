package domain;

public class Motorcycle extends Vehicle{
    private boolean hasSidecar;

    public Motorcycle(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    public Motorcycle(Integer id, String brand, Integer year, float price, boolean hasSidecar) {
        super(id, brand, year, price);
        this.hasSidecar = hasSidecar;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "hasSidecar=" + hasSidecar +
                '}';
    }
}
