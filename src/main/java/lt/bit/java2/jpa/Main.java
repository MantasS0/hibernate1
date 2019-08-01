package lt.bit.java2.jpa;

import lt.bit.java2.jpa.entities.Employee;
import lt.bit.java2.jpa.entities.Gender;
import lt.bit.java2.jpa.entities.Title;
import lt.bit.java2.jpa.entities.TitlePK;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOG.info("Started");


        EntityManager em = EntityManagerHelper.entityManager();

//        Employee employee = em.find(Employee.class, 10004);
//        System.out.println(employee.getFullName());
//
//        employee.getTitles().forEach(title -> {
//            System.out.println(title.getTitle());
//        });



//        em.setFlushMode(FlushModeType.COMMIT);
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
        Employee employee = em.find(Employee.class, 10004);
//        Title title1 = new Title();
//        title1.setEmpNo(employee.getEmpNo());
//        title1.setFromDate(employee.getTitles().get(0).getFromDate());
//        title1.setToDate(employee.getTitles().get(0).getToDate());
//        title1.setTitle("Entity Director");
//        employee.getTitles().add(title1);
//        em.persist(employee);
//        em.flush();
//        tx.commit();



//        TitlePK titlePK = new TitlePK(employee, "Senior Engineer", LocalDate.of(1995, 12, 1));
//        titlePK.setEmpNo(10001);
//        titlePK.setTitle("Senior Engineer");
//        titlePK.setFromDate(LocalDate.of(1986,6,26));
//        Title title = em.find(Title.class, titlePK);
        employee.getTitles().forEach(title -> {
            System.out.println(title.getTitle());
        });
        System.out.println(employee.getFullName());
    }
}
