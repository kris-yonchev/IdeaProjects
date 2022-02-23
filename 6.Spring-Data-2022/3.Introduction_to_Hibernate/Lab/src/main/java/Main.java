import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Student student = new Student("Gasho", 15);
        em.persist(student);
        Student student2 = new Student("Pesho", 16);
        em.persist(student2);
        em.getTransaction().commit();
        em.close();
    }
}
