package test.java.Exam_22_August_2022.ArcheologicalExcavations;

import main.java.Exam_22_August_2022.ArcheologicalExcavations.Archaeologist;
import main.java.Exam_22_August_2022.ArcheologicalExcavations.Excavation;
import org.junit.Assert;
import org.junit.Test;

public class ExcavationTests {
    @Test(expected = NullPointerException.class)
    public void testConstructorWithEmptyName(){
        new Excavation(null, 10);
    }
    @Test(expected = NullPointerException.class)
    public void testConstructorWithSpacesName(){
        new Excavation("   ", 10);
    }
    @Test
    public void testConstructorWithCorrectName(){
        String name = "SomeName";
        Excavation excavation = new Excavation(name, 10);
        Assert.assertEquals(name, excavation.getName());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNegativeCapacity(){
        new Excavation("SomeName", -1);
    }
    @Test
    public void testConstructorWithCorrectCapacity(){
        int capacity = 10;
        Excavation excavation = new Excavation("SomeName", capacity);
        Assert.assertEquals(capacity, excavation.getCapacity());
    }
    @Test
    public void testAddArchaeologist(){
        Archaeologist firstArchaeologist = new Archaeologist("FirstName", 10);
        Excavation excavation = new Excavation("SomeName", 10);
        excavation.addArchaeologist(firstArchaeologist);
        Assert.assertEquals(1, excavation.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistWithFullCapacity(){
        Archaeologist firstArchaeologist = new Archaeologist("FirstName", 10);
        Archaeologist secondArchaeologist = new Archaeologist("SecondName", 10);
        Excavation excavation = new Excavation("SomeName", 1);
        excavation.addArchaeologist(firstArchaeologist);
        excavation.addArchaeologist(secondArchaeologist);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistWithSameName(){
        Archaeologist firstArchaeologist = new Archaeologist("FirstName", 10);
        Archaeologist secondArchaeologist = new Archaeologist("FirstName", 20);
        Excavation excavation = new Excavation("SomeName", 10);
        excavation.addArchaeologist(firstArchaeologist);
        excavation.addArchaeologist(secondArchaeologist);
    }
    @Test
    public void testRemoveArchaeologistExisting(){
        Archaeologist firstArchaeologist = new Archaeologist("FirstName", 10);
        Archaeologist secondArchaeologist = new Archaeologist("SecondName", 20);
        Excavation excavation = new Excavation("SomeName", 10);
        excavation.addArchaeologist(firstArchaeologist);
        excavation.addArchaeologist(secondArchaeologist);

        Assert.assertTrue(excavation.removeArchaeologist("FirstName"));
    }
    @Test
    public void testRemoveArchaeologistNotExisting(){
        Archaeologist firstArchaeologist = new Archaeologist("FirstName", 10);
        Archaeologist secondArchaeologist = new Archaeologist("SecondName", 20);
        Excavation excavation = new Excavation("SomeName", 10);
        excavation.addArchaeologist(firstArchaeologist);
        excavation.addArchaeologist(secondArchaeologist);

        Assert.assertFalse(excavation.removeArchaeologist("SomeName"));
    }
}
