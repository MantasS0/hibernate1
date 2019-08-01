package lt.bit.java2.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.function.Consumer;
import java.util.logging.Logger;

public final class EntityManagerHelper {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());


    private static EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        }catch (Exception e){
            e.printStackTrace();
            LOG.severe(e.getMessage());
        }
    }

    public static EntityManager entityManager(){
        return entityManagerFactory.createEntityManager();
    }


    /**
     *
     * Consumer gets 1 parameter, returns nothing
     * Producer parameters - non, returns something
     * Function gets 1 parameter, returns something
     */

    public static void executeInTrasaction(Consumer<EntityManager> executor){
        EntityManager em = entityManager();
        em.getTransaction().begin();

        //TODO ...
        executor.accept(em);

        em.getTransaction().commit();
        em.close();
    }



}

//@FunctionalInterface
//interface Executor {
//    void execute(EntityManager em);
//}
