package domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Vehicle")
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="brand")
    private String brand;
    @Column(name="year")
    private Integer year;
    @Column(name="price")
    private float price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person_id;
    public Vehicle() {
    }

    public Person getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Person person_id) {
        this.person_id = person_id;
    }

    public Vehicle(Integer id, String brand, Integer year, float price) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
