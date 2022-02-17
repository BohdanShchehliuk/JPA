package dao;

import entity.Animal;

public interface AnimalDao {

    Animal add(Animal animal);

    Animal update(Animal animal);

    boolean delete(Animal animal);

    Animal get(int id);

}

