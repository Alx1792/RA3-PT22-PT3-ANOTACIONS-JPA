package domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("plane")
public class Plane extends Vehicle{
    @Column(name="tallNumber")
    private Integer tallNumber;
    @Column(name="autopilot")
    private boolean autopilot;

    public Plane() {
    }
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
