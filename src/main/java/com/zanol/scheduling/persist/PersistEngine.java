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

    public static Object getObject(EntityManager em, Class<?> clazz, Object id) {
        return em.find(clazz, id);
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

        return new ArrayList<Object>(q.getResultList());
    }

    public static void remove(EntityManager em, Object object) {
        em.remove(object);
    }

    public static void remove(EntityManager em, List<Object> objectList) {
        objectList.forEach(object -> remove(em, object));
    }
}