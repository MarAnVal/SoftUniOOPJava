package test.java.Exam_11_December_2021.Cats;

import main.java.Exam_11_December_2021.Cats.Cat;
import main.java.Exam_11_December_2021.Cats.House;
import org.junit.Assert;
import org.junit.Test;

public class HouseTests {
    @Test(expected = NullPointerException.class)
    public void testSetNameNull() {
        new House(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameSpaces() {
        new House("    ", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityNegative() {
        new House("SomeName", -34321);
    }

    @Test
    public void testGetName() {
        House house = new House("SomeName", 11);
        Assert.assertEquals("SomeName", house.getName());
    }

    @Test
    public void testGetCapacity() {
        House house = new House("SomeName", 11);
        Assert.assertEquals(11, house.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatFullCapacity() {
        Cat cat = new Cat("SomeName");
        House house = new House("SomeHouseName", 1);
        house.addCat(cat);
        house.addCat(cat);
    }

    @Test
    public void testGetCount() {
        Cat cat1 = new Cat("SomeName1");
        Cat cat2 = new Cat("SomeName2");
        House house = new House("SomeHouseName", 10);
        house.addCat(cat1);
        house.addCat(cat2);
        Assert.assertEquals(2, house.getCount());
    }

    @Test
    public void testRemoveCat() {
        Cat cat1 = new Cat("SomeName1");
        Cat cat2 = new Cat("SomeName2");
        House house = new House("SomeHouseName", 10);
        house.addCat(cat1);
        house.addCat(cat2);
        Assert.assertEquals(2, house.getCount());
        house.removeCat("SomeName1");
        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatNotExisting() {
        Cat cat1 = new Cat("SomeName1");
        Cat cat2 = new Cat("SomeName2");
        House house = new House("SomeHouseName", 10);
        house.addCat(cat1);
        house.addCat(cat2);
        Assert.assertEquals(2, house.getCount());
        house.removeCat("SomeName3");
    }

    @Test
    public void testGetStatistics() {
        Cat cat1 = new Cat("SomeName1");
        Cat cat2 = new Cat("SomeName2");
        House house = new House("SomeHouseName", 10);
        house.addCat(cat1);
        house.addCat(cat2);
        String expectedText = "The cat SomeName1, SomeName2 is in the house SomeHouseName!";
        Assert.assertEquals(expectedText, house.statistics());
    }

    @Test
    public void testCatForSale() {
        Cat cat1 = new Cat("SomeName1");
        Cat cat2 = new Cat("SomeName2");

        House house = new House("SomeHouseName", 10);
        house.addCat(cat1);
        house.addCat(cat2);
        Assert.assertEquals(cat1, house.catForSale("SomeName1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleNotExisting() {
        Cat cat1 = new Cat("SomeName1");
        Cat cat2 = new Cat("SomeName2");

        House house = new House("SomeHouseName", 10);
        house.addCat(cat1);
        house.addCat(cat2);
        Assert.assertEquals(cat1, house.catForSale("SomeName3"));
    }
    @Test
    public void testIsHungry() {
        Cat cat1 = new Cat("SomeName1");
        Cat cat2 = new Cat("SomeName2");

        House house = new House("SomeHouseName", 10);
        house.addCat(cat1);
        house.addCat(cat2);
        Assert.assertTrue(cat1.isHungry());
        house.catForSale("SomeName1");
        Assert.assertFalse(cat1.isHungry());
    }

}
