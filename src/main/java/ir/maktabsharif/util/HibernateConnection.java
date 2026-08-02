package ir.maktabsharif.util;

import jakarta.persistence.*;

import java.util.function.Function;

public class HibernateConnection {
    private static final String PERSISTENCE_UNIT = "Library Management System";

    private static EntityManagerFactory emf;

    private static EntityManagerFactory getEmf(){
        if (emf == null){
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return emf;
    }

    private static EntityManager getEm(){
        EntityManager em = getEmf().createEntityManager();
        return em;
    }

    public static <T> T InTxReturned(Function<EntityManager,T> operation){
        EntityManager em = getEm();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            T result = operation.apply(em);
            tx.commit();

            return result;
        } catch (PersistenceException e) {
            tx.rollback();
            throw e;
        }finally {
            em.close();
        }
    }
}
