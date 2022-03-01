package _4_HospitalDatabase;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        TODO Implement console app and validate rest of data(Diagnose, Medicament, Visitation)
        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercise_db");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Validator validator = new Validator();
        System.out.println("Please enter patient first name: ");
        String firstName = validator.validateName(scanner.nextLine());
        System.out.println("Please enter patient last name: ");
        String lastName = validator.validateName(scanner.nextLine());
        System.out.println("(*Optional) Please enter patient address: ");
        String address = scanner.nextLine();
        System.out.println("Please enter patient e-mail address: ");
        String email = validator.emailValidation(scanner.nextLine());
        System.out.println("Please enter patient date of birth in format DD/MM/YYYY: ");
        String birthDate = validator.birthDateValidation(scanner.nextLine());
        System.out.println("Please provide a link with a picture uploaded to imgur.com: ");
        String pictureLink = validator.pictureLinkValidation(scanner.nextLine());
        System.out.println("Does the patient have medical insurance? Please answer with YES or NO: ");
        boolean insurance = validator.insuranceValidation(scanner.nextLine());

        Patient patient = new Patient(firstName, lastName, address, email, birthDate, pictureLink, insurance);
        em.persist(patient);
        System.out.println("Registration successful!");

        em.getTransaction().commit();
    }
}
