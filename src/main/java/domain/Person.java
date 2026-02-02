package domain;

import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //Classe guardada a DB i crea la taula
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//Indica de que forma ha de mappejar la taula, en aquest cas totes les classes i subclasses estara en 1 taula gran
@DiscriminatorColumn(name = "person_type")//Creara una columna que diferenciara a partir de les subclasses si es student o teacher
@Table(name="Person")//canvia el nom de la taula a person
public abstract class Person {
    @Id//ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//AUTOINCREMENT DE ID
    @Column(name="id")// COLUMNA AMB EL NOM
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "phoneNumber")
    private Integer phoneNumber;
    @Column(name = "surname")
    private String surname;
    @OneToMany(mappedBy = "propietari",cascade = CascadeType.ALL)//La FK real està a Vehicle.propietari i es propaguen totes les operacions (guardar, esborrar, etc.) als vehicles
    private List<Vehicle> vehicles = new ArrayList<>(); //Guardar els vehicles de la persona

    public Person() {
    }

    public Person(Integer id, String name,Integer phoneNumber,String surname) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public void addVehicle(Vehicle v){
        vehicles.add(v);//Afegeix
        v.setPropietari(this);//estableix aquest propietari
    };
    public void removeVehicle(Vehicle v){
        vehicles.remove(v);//treu
        v.setPropietari(null);//estableix que no hi ha propietari

    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
