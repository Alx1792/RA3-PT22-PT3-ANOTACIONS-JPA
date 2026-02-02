import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Car;
import domain.Person;
import domain.Vehicle;
import domain.Motorcycle;
import domain.Plane;
import domain.Teacher;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
    // Obrim una sessió d'Hibernate per treballar amb la BD
    private static Session session = HibernateSession.getSessionFactory().openSession();


	private static List<Person> people = new ArrayList<>();
	private static List<Vehicle> vehicles = new ArrayList<>();
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcio;

		do {
			System.out.println("\n===== MENÚ PRINCIPAL =====");
			System.out.println("1) Fase 1: Crear dades de prova");
			System.out.println("2) Fase 2: Treure vehicles de persones");
			System.out.println("3) Fase 3: Actualitzar un vehicle");
			System.out.println("0) Sortir");
			System.out.print("Escull una opció: ");

			opcio = sc.nextInt();
			sc.nextLine();

			switch (opcio) {
				case 1:
					fase1();
					break;
				case 2:
					fase2();
					break;
				case 3:
					fase3();
					break;
				case 0:
					System.out.println("Fins aviat!");
					break;
				default:
					System.out.println("Opció incorrecta.");
			}

		} while (opcio != 0);

		sc.close();
		HibernateSession.getSessionFactory().close();
	}
	
	private static void fase1() {

        Transaction tx = session.beginTransaction();//
        try {
            //Persona
            Student anna= new Student("STUOO1");
            anna.setName("Anna");
            anna.setPhoneNumber(111111111);
            anna.setSurname("Lopez");
            session.save(anna);// INSERT d'Anna a la taula Person




            Student jordi=new Student("STUOO2");
            jordi.setName("Jordi");
            jordi.setPhoneNumber(222222222);
            jordi.setSurname("Martinez");
            session.save(jordi);


            Student clara=new Student("STUOO3");
            clara.setName("Clara");
            clara.setPhoneNumber(333333333);
            clara.setSurname("Sanchez");
            session.save(clara);


            Teacher joan=new Teacher("TEA001");
            joan.setName("Joan");
            joan.setPhoneNumber(444444444);
            joan.setSurname("Perez");
            session.save(joan);


            Teacher maria=new Teacher("TEA002");
            maria.setName("Maria");
            maria.setPhoneNumber(555555555);
            maria.setSurname("Gomez");
            session.save(maria);


            Teacher pere=new Teacher("TEA003");
            pere.setName("Pere");
            pere.setPhoneNumber(666666666);
            pere.setSurname("Ruiz");
            session.save(pere);


            //Vehicle
            //Coche
            Car toyota= new Car();
            toyota.setBrand("Toyota");
            toyota.setPrice(18000f);
            toyota.setYear(2020);
            // Afegeix el vehicle a la llista d'Anna i marca Anna com a propietària
            anna.addVehicle(toyota);
            toyota.setDoors(5);
            toyota.setSeats(5);
            session.persist(anna);// Guarda anna i, per cascade, el toyota




            Car ford= new Car();
            ford.setBrand("Ford");
            ford.setPrice(15000f);
            ford.setYear(2019);
            maria.addVehicle(ford);
            ford.setDoors(3);
            ford.setSeats(4);
            session.persist(maria);


            //Avion
            Plane cessna=new Plane();
            cessna.setBrand("Cessna");
            cessna.setPrice(120000f);
            cessna.setYear(2015);
            cessna.setAutopilot(true);
            cessna.setTailNumber(11111);
            joan.addVehicle(cessna);
            session.persist(joan);


            Plane boeing= new Plane();
            boeing.setBrand("Boeing");
            boeing.setPrice(900000f);
            boeing.setYear(2010);
            boeing.setAutopilot(false);
            boeing.setTailNumber(22222);
            clara.addVehicle(boeing);
            session.persist(clara);


            //Moto
            Motorcycle yamaha=new Motorcycle();
            yamaha.setBrand("Yamaha");
            yamaha.setPrice(9000f);
            yamaha.setYear(2021);
            jordi.addVehicle(yamaha);
            session.persist(jordi);



            Motorcycle harley=new Motorcycle();
            harley.setBrand("Harley-Davidson");
            harley.setPrice(20000f);
            harley.setYear(2018);
            harley.setHasSidecar(true);
            pere.addVehicle(harley);
            session.persist(pere);
            tx.commit();

        }catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();

        };

	}
	
	private static void fase2() {

        if (session.getTransaction().isActive()) {
            session.getTransaction().commit();
        }//Comprova si habia una transaccio oberta davant i fa que si hi ha una forçi un commit del anterior
        Transaction tx = session.beginTransaction(); // Nova transacció per fer els canvis d’aquesta fase
        try{
            Person person=session.get(Person.class,1);// Carrega de la BD la persona amb id = 1
            Vehicle vehicle=session.get(Vehicle.class,1);// Carrega de la BD el vehicle amb id = 1
            if (person != null && vehicle != null) {
                person.removeVehicle(vehicle); // Treu el vehicle de la llista de vehicles de la person i posa el propietari del vehicle a null

            }
        tx.commit();// Confirma la transacció: Hibernate fa l’UPDATE del vehicle a la BD


        }catch (Exception e){
            System.out.println("Error");
            e.printStackTrace();

        }

	}

	private static void fase3() {
        if (session.getTransaction().isActive()) {
            session.getTransaction().commit();
        }
        Transaction tx = session.beginTransaction();
        try{
            Vehicle vehicle=session.get(Vehicle.class,1);
            vehicle.setBrand("Seat");
            vehicle.setPrice(19999f);
            vehicle.setYear(2022);
            tx.commit();

        }catch (Exception e){
            if(tx !=null){
                tx.rollback();
            }
            System.out.println("Error ");

        }

	}
}
