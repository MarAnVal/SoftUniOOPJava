package test.java.Exam_16_August_2020.Computers;

import main.java.Exam_16_August_2020.Computers.Computer;
import main.java.Exam_16_August_2020.Computers.ComputerManager;
import org.junit.Assert;
import org.junit.Test;

public class ComputerManagerTests {
    // public ComputerManager() {
    //        this.computers = new ArrayList<>();
    //    }
    //    public List<Computer> getComputers() {
    //        return Collections.unmodifiableList(this.computers);
    //    }
    @Test
    public void testGetCount() {
        ComputerManager computerManager = new ComputerManager();
        Assert.assertEquals(0, computerManager.getCount());
    }

    //    public int getCount() {
    //        return this.computers.size();
    //    }
    @Test
    public void testGetComputers() {
        ComputerManager computerManager = new ComputerManager();
        Assert.assertEquals(0, computerManager.getComputers().size());
    }

    //    private void validateNullValue(Object variable, String exceptionMessage) {
    //        if (variable == null) {
    //            throw new IllegalArgumentException(exceptionMessage);
    //        }
    //    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerValidateNullValue() {
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(null);
    }

    //    public void addComputer(Computer computer) {
    //        this.validateNullValue(computer, CAN_NOT_BE_NULL_MESSAGE);
    //        boolean flag = this.computers.stream()
    //                .filter(c -> c.getManufacturer().equals(computer.getManufacturer()) && c.getModel().equals(computer.getModel()))
    //                .findFirst().orElse(null) != null;
    //        if (flag) {
    //            throw new IllegalArgumentException("This computer already exists.");
    //        }
    //
    //        this.computers.add(computer);
    //    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerSameValues() {
        ComputerManager computerManager = new ComputerManager();
        //(String manufacturer, String model, double price)
        Computer computer1 = new Computer("Manufacturer", "Model", 213.2445);
        Computer computer2 = new Computer("Manufacturer", "Model", 213.24556);
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
    }

    @Test
    public void testAddComputer() {
        ComputerManager computerManager = new ComputerManager();
        //(String manufacturer, String model, double price)
        Computer computer1 = new Computer("Manufacturer", "Model1", 213.2445);
        Computer computer2 = new Computer("Manufacturer", "Model", 213.24556);
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        Assert.assertEquals(2, computerManager.getCount());
    }

    //    public Computer getComputer(String manufacturer, String model) {
    //        this.validateNullValue(manufacturer, CAN_NOT_BE_NULL_MESSAGE);
    //        this.validateNullValue(model, CAN_NOT_BE_NULL_MESSAGE);
    //
    //        Computer computer = this
    //                .computers
    //                .stream()
    //                .filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model))
    //                .findFirst()
    //                .orElse(null);
    //
    //        if (computer == null) {
    //            throw new IllegalArgumentException("There is no computer with this manufacturer and model.");
    //        }
    //        return computer;
    //    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerValidateNullValueNullManufacturer() {
        ComputerManager computerManager = new ComputerManager();
        computerManager.getComputer(null, "Model");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerValidateNullValueNullModel() {
        ComputerManager computerManager = new ComputerManager();
        computerManager.getComputer("Manufacturer", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerNotExisting() {
        ComputerManager computerManager = new ComputerManager();
        //(String manufacturer, String model, double price)
        Computer computer1 = new Computer("Manufacturer", "Model1", 213.2445);
        Computer computer2 = new Computer("Manufacturer", "Model", 213.24556);
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        computerManager.removeComputer("Manufacturer", "Model2");
    }

    @Test
    public void testGetComputer() {
        ComputerManager computerManager = new ComputerManager();
        //(String manufacturer, String model, double price)
        Computer computer1 = new Computer("Manufacturer", "Model1", 213.2445);
        Computer computer2 = new Computer("Manufacturer", "Model", 213.24556);
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        Assert.assertEquals(computer1, computerManager.getComputer("Manufacturer", "Model1"));
        Assert.assertEquals(2, computerManager.getCount());

    }

    //    public Computer removeComputer(String manufacturer, String model) {
    //        Computer computer = this.getComputer(manufacturer, model);
    //
    //        this.computers.remove(computer);
    //        return computer;
    //    }
    @Test
    public void removeComputer() {
        ComputerManager computerManager = new ComputerManager();
        //(String manufacturer, String model, double price)
        Computer computer1 = new Computer("Manufacturer", "Model1", 213.2445);
        Computer computer2 = new Computer("Manufacturer", "Model", 213.24556);
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        Assert.assertEquals(computer1, computerManager.removeComputer("Manufacturer", "Model1"));
        Assert.assertEquals(computer2, computerManager.removeComputer("Manufacturer", "Model"));
        Assert.assertEquals(0, computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeComputerNotExisting() {
        ComputerManager computerManager = new ComputerManager();
        //(String manufacturer, String model, double price)
        Computer computer1 = new Computer("Manufacturer", "Model1", 213.2445);
        Computer computer2 = new Computer("Manufacturer", "Model", 213.24556);
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        Assert.assertNull(computerManager.removeComputer("Manufacturer1", "Model1"));
        Assert.assertEquals(2, computerManager.getCount());
    }
    //    public List<Computer> getComputersByManufacturer(String manufacturer) {
    //        this.validateNullValue(manufacturer, CAN_NOT_BE_NULL_MESSAGE);
    //
    //        List<Computer> computers = this
    //                .computers
    //                .stream()
    //                .filter(c -> c.getManufacturer().equals(manufacturer))
    //                .collect(Collectors.toList());
    //
    //        return computers;
    //    }
    @Test
    public void testGetComputersByManufacturer(){
        ComputerManager computerManager = new ComputerManager();
        //(String manufacturer, String model, double price)
        Computer computer1 = new Computer("Manufacturer1", "Model1", 213.2445);
        Computer computer2 = new Computer("Manufacturer2", "Model2", 213.24556);
        Computer computer3 = new Computer("Manufacturer2", "Model3", 213.2445);
        Computer computer4 = new Computer("Manufacturer3", "Model4", 213.24556);
        Computer computer5 = new Computer("Manufacturer3", "Model5", 213.2445);
        Computer computer6 = new Computer("Manufacturer3", "Model6", 213.24556);
        computerManager.addComputer(computer1);
        Assert.assertEquals(1, computerManager.getComputersByManufacturer("Manufacturer1").size());
        computerManager.addComputer(computer2);
        computerManager.addComputer(computer3);
        Assert.assertEquals(2, computerManager.getComputersByManufacturer("Manufacturer2").size());
        computerManager.addComputer(computer4);
        computerManager.addComputer(computer5);
        computerManager.addComputer(computer6);
        Assert.assertEquals(3, computerManager.getComputersByManufacturer("Manufacturer3").size());
    }
}