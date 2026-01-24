package domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("motorcycle")
public class Motorcycle extends Vehicle{
    @Column(name = "hasSidecar")
    private boolean hasSidecar;

    public Motorcycle() {
    }

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
