package domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("plane")
public class Plane extends Vehicle{
    @Column(name="tailNumber")
    private Integer tailNumber;
    @Column(name="autopilot")
    private boolean autopilot;

    public Plane() {
    }
    public Plane(Integer tailNumber, boolean autopilot) {
        this.tailNumber = tailNumber;
        this.autopilot = autopilot;
    }

    public Plane(Integer id, String brand, Integer year, Float price, Integer tailNumber, boolean autopilot) {
        super(id, brand, year, price);
        this.tailNumber = tailNumber;
        this.autopilot = autopilot;
    }

    public Integer getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(Integer tailNumber) {
        this.tailNumber = tailNumber;
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
                "tailNumber=" + tailNumber +
                ", autopilot=" + autopilot +
                '}';
    }
}
