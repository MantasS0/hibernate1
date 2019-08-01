package lt.bit.java2.jpa;

import lt.bit.java2.jpa.entities.Employee;

import javax.persistence.EntityManager;

public class UpdateEmployee {
    public static void main(String[] args) {

/*

        //Just Like Lamda. Also we are creating ANONYMOUS CLASS.
        EntityManagerHelper.executeInTrasaction(new Executor() {
            @Override
            public void execute(EntityManager em) {
                Employee employee = em.find(Employee.class, 10004);
                employee.setFirstName("Jonas");
            }
        });

*/
        //Lamda
        EntityManagerHelper.executeInTrasaction(em -> {
            Employee employee = em.find(Employee.class, 10004);
            employee.setFirstName("Jonas");
        });


//        EntityManager em = EntityManagerHelper.entityManager();
//
//        em.getTransaction().begin();
//
//        Employee employee = em.find(Employee.class, 10004);
//        employee.setFirstName("Jonas");
//
//        em.getTransaction().commit();
//        em.close();
    }
}
