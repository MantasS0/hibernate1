package lt.bit.java2.jpa;

import lt.bit.java2.jpa.entities.Employee;
import lt.bit.java2.jpa.entities.Gender;
import lt.bit.java2.jpa.entities.Title;
import lt.bit.java2.jpa.entities.TitlePK;


import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOG.info("Started");

        EntityManager em = EntityManagerHelper.entityManager();

        Employee employee = em.find(Employee.class, 10004);
        System.out.println(employee.getFullName());

        employee.getTitles().forEach(title -> {
            System.out.println(title.getTitle());
        });

//        employee.setFirstName("Jonas");
//        em.persist(employee);


//        TitlePK titlePK = new TitlePK(10001, "Senior Engineer", LocalDate.of(1986, 6, 26));
////        titlePK.setEmpNo(10001);
////        titlePK.setTitle("Senior Engineer");
////        titlePK.setFromDate(LocalDate.of(1986,6,26));
//        Title title = em.find(Title.class, titlePK);
//        System.out.println(title.getTitle());
//        System.out.println(title.getEmployee().getFirstName());
    }
}
