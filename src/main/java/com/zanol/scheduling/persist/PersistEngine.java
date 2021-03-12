package com.zanol.scheduling.persist;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class PersistEngine {

/*    private static PersistEngine persistEngine;

    public static PersistEngine getInstance() {
        if (Objects.isNull(persistEngine) || entityManager.isOpen()) {
            PersistEngine persistEngine = new PersistEngine();
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("");
            persistEngine. = entityManager = entityManagerFactory.createEntityManager();
        }

        return persistEngine;
    }*/

//    @PersistenceContext
//    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Transactional
    public static Object persist(EntityManager em, Object object) {
        em.merge(object);

        return object;
    }

    public static List<Object> persistList(EntityManager em, List<Object> objectList) {
        objectList.forEach(object -> persist(em, object));

        return objectList;
    }

    public static Object getObject(EntityManager em, Class<?> clazz, Object key, Object value) {
        String query = "SELECT O FROM " + clazz.getCanonicalName() + " O WHERE " + key + " = '" + value + "'";

        return getObject(em, query);
    }

    public static Object getObject(EntityManager em, Class<?> clazz, Object id) {
        return em.find(clazz, id);
    }

    public static Object getObject(EntityManager em, String query) {
        Query q = em.createQuery(query);

        try {
            return q.getSingleResult();
        }catch (NoResultException e) {
            return null;
        }
    }

    public static List<Object> getObjects(EntityManager em, Class<?> clazz) {
        return getObjects(em, clazz, "id");
    }

    public static List<Object> getObjects(EntityManager em, Class<?> clazz, String orderBy) {
        String query = "SELECT O FROM " + clazz.getCanonicalName() + " O ORDER BY O." + orderBy;

        return getObjects(em, query);
    }

    public static List<Object> getObjects(EntityManager em, String query) {
        Query q = em.createQuery(query);

        try {
            return new ArrayList<Object>(q.getResultList());
        }catch (NoResultException e) {
            return null;
        }
    }

    public static void remove(EntityManager em, Object object) {
        em.remove(object);
    }

    public static void remove(EntityManager em, List<Object> objectList) {
        objectList.forEach(object -> remove(em, object));
    }
}