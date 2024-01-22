package test.java.Exam_22_August_2021.farmville;

import main.java.Exam_22_August_2021.Farmville.Animal;
import main.java.Exam_22_August_2021.Farmville.Farm;
import org.junit.Assert;
import org.junit.Test;

public class FarmvilleTests {
    @Test
    public void testAnimalGetEnergy() {
        Animal animal = new Animal("sheep", 13.5);
        Assert.assertEquals(13.5, animal.getEnergy(), 13.5);
    }

    @Test
    public void testAnimalGetType() {
        Animal animal = new Animal("sheep", 13.5);
        Assert.assertEquals("sheep", animal.getType());
    }

    @Test(expected = NullPointerException.class)
    public void testFarmSetNameNull() {
        //if (name == null || name.trim().isEmpty()) {
        //            throw new NullPointerException(INVALID_FARM_NAME);
        //        }
        //
        //        this.name = name;
        Farm farm = new Farm(null, 13124);
    }

    @Test(expected = NullPointerException.class)
    public void testFarmSetNameSpaces() {
        //if (name == null || name.trim().isEmpty()) {
        //            throw new NullPointerException(INVALID_FARM_NAME);
        //        }
        //
        //        this.name = name;
        Farm farm = new Farm("   ", 13124);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFarmSetCapacityNegative() {
        //if (capacity < ZERO_CAPACITY) {
        //            throw new IllegalArgumentException(INVALID_CAPACITY);
        //        }
        //
        //        this.capacity = capacity;
        Farm farm = new Farm("SomeName", -134);
    }

    @Test
    public void testFarmGetName() {
        Farm farm = new Farm("SomeName", 134);
        Assert.assertEquals("SomeName", farm.getName());
    }

    @Test
    public void testFarmGetCapacity() {
        Farm farm = new Farm("SomeName", 134);
        Assert.assertEquals(134, farm.getCapacity());
    }

    @Test
    public void testFarmAdd() {
        int countToAdd = 10;
        int capacity = 432;
        Farm farm = new Farm("SomeName", capacity);
        Assert.assertEquals(0, farm.getCount());
        for (int i = 0; i < countToAdd; i++) {
            String type = "" + i;
            Animal animal = new Animal(type, 12.2);
            farm.add(animal);
        }
        Assert.assertEquals(countToAdd, farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFarmAddFullCapacity() {
        int countToAdd = 10;
        int capacity = 9;
        Farm farm = new Farm("SomeName", capacity);
        for (int i = 0; i < countToAdd; i++) {
            String type = "" + i;
            Animal animal = new Animal(type, 12.2);
            farm.add(animal);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFarmAddSameTypeAnimal() {
        Farm farm = new Farm("SomeName", 10);
        Animal animal1 = new Animal("SameType", 1243.2);
        Animal animal2 = new Animal("SameType", 13242.2);
        farm.add(animal1);
        farm.add(animal2);
    }

    @Test
    public void testFarmRemoveTrue() {
        int n = 124;
        Farm farm = new Farm("SomeName", n);
        for (int i = 0; i < n; i++) {
            String type = "" + i;
            Animal animal = new Animal(type, 12.2);
            farm.add(animal);
        }
        Assert.assertTrue(farm.remove("120"));
    }
    @Test
    public void testFarmRemoveFalse() {
        int n = 124;
        Farm farm = new Farm("SomeName", n);
        for (int i = 0; i < n; i++) {
            String type = "" + i;
            Animal animal = new Animal(type, 12.2);
            farm.add(animal);
        }
        Assert.assertFalse(farm.remove("600"));
    }
}
