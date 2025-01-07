package OOP_assignment2;

import OOP_assignment2.models.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        Patient patient1 = new Patient("John Doe", 30, "A12345");
        Patient patient2 = new Patient("Jane Smith", 28, "B67890");
        MedicalProfessional doctor = new MedicalProfessional("Dr. Alice", "Cardiologist", 15);

        people.add(patient1);
        people.add(patient2);
        people.add(doctor);

        Hospital hospital = new Hospital("City Hospital", "123 Main Street", 100);

        // Display all people
        for (Person person : people) {
            System.out.println(person);
        }

        System.out.println(hospital);

        // Filter: Patients older than 25
        System.out.println("\nPatients older than 25:");
        people.stream()
                .filter(person -> person instanceof Patient)
                .filter(person -> ((Patient) person).getAge() > 25)
                .forEach(System.out::println);

        // Sort: People by name
        System.out.println("\nPeople sorted by name:");
        people.stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(System.out::println);

        // Check equality
        System.out.println("\nAre patients the same? " + patient1.equals(patient2));
    }
}
