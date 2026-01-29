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
            Student juanjo= new Student("S001");
            juanjo.setName("Juanjo");
            juanjo.setSurname("Alveloa");
            juanjo.setPhoneNumber(900000001);
            session.persist(juanjo);

            Teacher dulors= new Teacher("T001");
            dulors.setName("Dulors");
            dulors.setSurname("Martín");
            dulors.setPhoneNumber(909090909);
            session.persist(dulors);

            Car nissan= new Car(4,5);
            nissan.setBrand("Nissan");
            nissan.setYear(2006);
            nissan.setPrice(8900f);
            juanjo.addVehicle(nissan);
            session.persist(nissan);

            Car twingo= new Car(5,5);
            twingo.setBrand("Twingo");
            twingo.setYear(2017);
            twingo.setPrice(14000f);
            dulors.addVehicle(twingo);
            session.persist(twingo);

            Motorcycle yamaha= new Motorcycle(false);
            yamaha.setBrand("Yamaha");
            yamaha.setYear(2015);
            yamaha.setPrice(2100f);
            dulors.ad



        }catch (Exception e) {

        };

	}
	
	private static void fase2() {

	}

	private static void fase3() {

	}
}
