
package Utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class hibernateUtil {
   private static EntityManager em;
    private static EntityManagerFactory factory;
    
    private static EntityManagerFactory getFactory()
    {
        if (factory == null || factory.isOpen() == false) {
            factory = Persistence.createEntityManagerFactory("QuanLYBanTraSua");
        }

        return factory;
    }
    
    public static EntityManager getEntityManager()
    {
        if (em == null || em.isOpen() == false) {
            EntityManagerFactory factory = getFactory();
            em = factory.createEntityManager();
        }

        return em;
    } 
}
