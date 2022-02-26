import entities.Plane;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vehicle_hierarchy");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Plane plane = new Plane("Fosho", new BigDecimal(150000), "jetFuel", 100);
        em.persist(plane);

        em.getTransaction().commit();
    }
}
