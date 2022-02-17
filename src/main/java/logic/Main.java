package logic;

import dao.AnimalDao;
import dao.impl.AnimalDaoImpl;
import entity.Animal;

public class Main {

    private static AnimalDao animalDao = new AnimalDaoImpl();

    public static void main(String[] args) {
        Animal animal = new Animal().builder()
                .id(100)
                .age(25)
                .name("putin")
                .tail(true)
                .build();

        animalDao.add(animal);

        Animal animal1 = animalDao.get(1);
        animal1.setName("dragon");

        animalDao.update(animal1);
        Animal animal2 = animalDao.get(2);
        System.out.println(animalDao.delete(animal2));
    }
}
