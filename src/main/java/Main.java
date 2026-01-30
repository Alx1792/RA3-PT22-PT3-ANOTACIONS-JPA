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


public class Main {

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
        Session session=HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            //Persona
            Student anna= new Student("STUOO1");
            anna.setName("Anna");
            anna.setPhoneNumber(111111111);
            anna.setSurname("Lopez");
            session.persist(anna);

            Student jordi=new Student("STUOO2");
            jordi.setName("Jordi");
            jordi.setPhoneNumber(222222222);
            jordi.setSurname("Martinez");
            session.persist(jordi);

            Student clara=new Student("STUOO3");
            clara.setName("Clara");
            clara.setPhoneNumber(333333333);
            clara.setSurname("Sanchez");
            session.persist(clara);

            Teacher joan=new Teacher("TEA001");
            joan.setName("Joan");
            joan.setPhoneNumber(444444444);
            joan.setSurname("Perez");
            session.persist(joan);

            Teacher maria=new Teacher("TEA002");
            maria.setName("Maria");
            maria.setPhoneNumber(555555555);
            maria.setSurname("Gomez");
            session.persist(maria);

            Teacher pere=new Teacher("TEA002");
            pere.setName("Pere");
            pere.setPhoneNumber(666666666);
            pere.setSurname("Ruiz");
            session.persist(pere);

            //Vehicle
            //Coche
            Car toyota= new Car();
            toyota.setBrand("Toyota");
            toyota.setPrice(18000f);
            toyota.setYear(2020);
            toyota.setPropietari(anna);
            toyota.setDoors(5);
            toyota.setSeats(5);
            session.persist(toyota);

            Car ford= new Car();
            ford.setBrand("Ford");
            ford.setPrice(15000f);
            ford.setYear(2019);
            ford.setPropietari(maria);
            ford.setDoors(3);
            ford.setSeats(4);
            session.persist(ford);

            //Avion
            Plane cessna=new Plane();
            cessna.setBrand("Cessna");
            cessna.setPrice(120000f);
            cessna.setYear(2015);
            cessna.setPropietari(joan);
            cessna.setAutopilot(true);
            cessna.setTailNumber(11111);
            session.persist(cessna);

            Plane boeing= new Plane();
            boeing.setBrand("Boeing");
            boeing.setPrice(900000f);
            boeing.setYear(2010);
            boeing.setPropietari(clara);
            boeing.setAutopilot(false);
            boeing.setTailNumber(22222);
            session.persist(boeing);


            //Moto
            Motorcycle yamaha=new Motorcycle();
            yamaha.setBrand("Yamaha");
            yamaha.setPrice(9000f);
            yamaha.setYear(2021);
            yamaha.setPropietari(jordi);
            yamaha.setHasSidecar(false);
            session.persist(yamaha);

            Motorcycle harley=new Motorcycle();
            harley.setBrand("Harley-Davidson");
            harley.setPrice(20000f);
            harley.setYear(2018);
            harley.setPropietari(pere);
            harley.setHasSidecar(true);
            session.persist(harley);


        }catch (Exception e) {

        };

	}
	
	private static void fase2() {

	}

	private static void fase3() {

	}
}
