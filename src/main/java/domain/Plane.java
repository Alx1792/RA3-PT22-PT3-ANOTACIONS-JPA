package domain;

public class Plane extends Vehicle{
    private Integer tallNumber;
    private boolean autopilot;

    public Plane(Integer tallNumber, boolean autopilot) {
        this.tallNumber = tallNumber;
        this.autopilot = autopilot;
    }

    public Plane(Integer id, String brand, Integer year, float price, Integer tallNumber, boolean autopilot) {
        super(id, brand, year, price);
        this.tallNumber = tallNumber;
        this.autopilot = autopilot;
    }

    public Integer getTallNumber() {
        return tallNumber;
    }

    public void setTallNumber(Integer tallNumber) {
        this.tallNumber = tallNumber;
    }

    public boolean isAutopilot() {
        return autopilot;
    }

    public void setAutopilot(boolean autopilot) {
        this.autopilot = autopilot;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "tallNumber=" + tallNumber +
                ", autopilot=" + autopilot +
                '}';
    }
}
