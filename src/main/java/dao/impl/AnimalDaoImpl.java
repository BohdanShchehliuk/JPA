package dao.impl;

import dao.AnimalDao;
import entity.Animal;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AnimalDaoImpl implements AnimalDao {
    private static EntityManagerFactory entityEntryFactory;


    private static EntityManagerFactory getEntityManagerFactory() {
        if (entityEntryFactory == null) {
            return Persistence
                    .createEntityManagerFactory("mohr");

        }
        return entityEntryFactory;
    }

    @Override
    public Animal add(Animal animal) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Animal animal1 = entityManager.find(Animal.class, animal.getId());

        if (entityManager.contains(animal1)) {
            entityManager.close();
            return animal;
        }
        entityManager.merge(animal);
        entityManager.getTransaction().commit();
        entityManager.close();
        return animal;
    }

    @Override
    public Animal update(Animal animal) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Animal animal1 = entityManager.find(Animal.class, animal.getId());

        if (entityManager.contains(animal1)) {
            entityManager.merge(animal);
            entityManager.getTransaction().commit();
            entityManager.close();
            return animal;
        } else {
            entityManager.close();
            return null;
        }
    }

    @Override
    public boolean delete(Animal animal) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Animal animal1 = entityManager.find(Animal.class, animal.getId());
        if (entityManager.contains(animal1)) {
            entityManager.remove(animal1);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        entityManager.close();
        return false;
    }

    @Override
    public Animal get(int id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Animal animal = entityManager.find(Animal.class, id);

        if (entityManager.contains(animal)) {
            entityManager.getTransaction().commit();
            entityManager.close();
            return animal;
        }
        entityManager.close();
        return null;
    }
}
