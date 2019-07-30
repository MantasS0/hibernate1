package lt.bit.java2.jpa;

import lt.bit.java2.jpa.entities.Employee;
import lt.bit.java2.jpa.entities.Gender;


import javax.persistence.EntityManager;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOG.info("Started");

        EntityManager em = EntityManagerHelper.entityManager();

        Employee employee = em.find(Employee.class, 10001);

        System.out.printf("name: %s \n" +
                "surname: %s\n" +
                "birth date: %s\n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getBirthDate().toInstant());

        employee.setFirstName("Jonas");
        em.persist(employee);
    }
}
