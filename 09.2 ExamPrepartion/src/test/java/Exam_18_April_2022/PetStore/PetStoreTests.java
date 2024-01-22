package test.java.Exam_18_April_2022.PetStore;

import main.java.Exam_18_April_2022.PetStore.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PetStoreTests {
    @Test
    public void testAddAnimal() {
        //String specie, int maxKilograms, double price
        String specie = "specie";
        int maxKilograms = 10;
        double price = 1.0;
        Animal animal = new Animal(specie, maxKilograms, price);
        PetStore petStore = new PetStore();
        petStore.addAnimal(animal);
        petStore.addAnimal(animal);
        Assert.assertEquals(2, petStore.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalNull() {
        PetStore petStore = new PetStore();
        petStore.addAnimal(null);
    }

    @Test
    public void testGetTheMostExpensiveAnimal() {
        Animal animal1 = new Animal("specie1", 10, 1.11);
        Animal animal2 = new Animal("specie2", 10, 2.74);
        Animal animal3 = new Animal("specie3", 10, 4.87);
        Animal animal4 = new Animal("specie4", 10, 4.0);

        PetStore petStore = new PetStore();
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        petStore.addAnimal(animal4);
        Animal actualMostExpensiveAnimal = petStore.getTheMostExpensiveAnimal();

        Assert.assertEquals(animal3, actualMostExpensiveAnimal);
    }
    @Test(expected = UnsupportedOperationException.class)
    public void testGetAnimals(){
        Animal animal1 = new Animal("specie1", 10, 1.11);
        Animal animal2 = new Animal("specie2", 10, 2.74);
        Animal animal3 = new Animal("specie3", 10, 4.87);
        Animal animal4 = new Animal("specie4", 10, 4.0);

        PetStore petStore = new PetStore();
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        List<Animal> animals = petStore.getAnimals();
        animals.add(animal4);
    }
    @Test
    public void testFindAllAnimalBySpecie(){
        Animal animal1 = new Animal("specie", 10, 1.11);
        Animal animal2 = new Animal("specie2", 10, 2.74);
        Animal animal3 = new Animal("specie", 10, 4.87);
        Animal animal4 = new Animal("specie4", 10, 4.0);

        PetStore petStore = new PetStore();
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        petStore.addAnimal(animal4);

        List<Animal> specieAnimals = petStore.findAllAnimalBySpecie("specie");
        Assert.assertEquals(2, specieAnimals.size());
    }
@Test
    public void testFindAllAnimalsWithMaxKilograms(){
    Animal animal1 = new Animal("specie", 10, 1.11);
    Animal animal2 = new Animal("specie2", 3, 2.74);
    Animal animal3 = new Animal("specie", 67, 4.87);
    Animal animal4 = new Animal("specie4", 1, 4.0);

    PetStore petStore = new PetStore();
    petStore.addAnimal(animal1);
    petStore.addAnimal(animal2);
    petStore.addAnimal(animal3);
    petStore.addAnimal(animal4);

    List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(3);
    Assert.assertEquals(2, animals.size());
}
}

