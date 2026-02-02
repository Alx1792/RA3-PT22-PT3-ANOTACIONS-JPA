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
    private Float price;

    @ManyToOne(fetch = FetchType.LAZY) //LAZY: no carrega la persona propietària fins que es crida getPropietari() (carrega només quan es necessita)
    @JoinColumn(name = "person_id") //Posa el id de la persona i el remarque com a person_id, al person es marque que aquest camp rebra el id
    private Person propietari;
    public Vehicle() {
    }

    public Person getPropietari() {
        return propietari;
    }

    public void setPropietari(Person propietari) {
        this.propietari = propietari;
    }

    public Vehicle(Integer id, String brand, Integer year, Float price) {
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
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
