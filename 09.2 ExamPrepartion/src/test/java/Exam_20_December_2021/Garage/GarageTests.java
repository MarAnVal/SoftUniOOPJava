package test.java.Exam_20_December_2021.Garage;

import main.java.Exam_20_December_2021.Garage.Car;
import main.java.Exam_20_December_2021.Garage.Garage;
import org.junit.Assert;
import org.junit.Test;

public class GarageTests {
    @Test
    public void testGetCars() {
        Garage garage = new Garage();
        Assert.assertEquals(0, garage.getCars().size());
    }

    @Test
    public void testGetCount() {
        Garage garage = new Garage();
        Assert.assertEquals(0, garage.getCount());
    }

    @Test
    public void testAddCar() {
        Garage garage = new Garage();
        String brand = "SomeBrand";
        int maxSpeed = 120;
        double price = 100.10;
        Car car = new Car(brand, maxSpeed, price);
        garage.addCar(car);
        Assert.assertEquals(car, garage.getCars().get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarNull() {
        Garage garage = new Garage();
        Car car = null;
        garage.addCar(car);
    }
    @Test
    public void testFindAllCarsWithMaxSpeedAbove(){
        Car car1 = new Car("SomeBrand1", 1421, 110.1234214);
        Car car2 = new Car("SomeBrand2", 321421, 110123.4214);
        Car car3 = new Car("SomeBrand3", 2321421, 1101.234214);
        Car car4 = new Car("SomeBrand4", 21, 11.01234214);
        Car car5 = new Car("SomeBrand5", 2, 11012342.14);
        Garage garage = new Garage();
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        garage.addCar(car4);
        garage.addCar(car5);

        Assert.assertEquals(3, garage.findAllCarsWithMaxSpeedAbove(100).size());
        Assert.assertEquals(0, garage.findAllCarsWithMaxSpeedAbove(2321421).size());
    }
    @Test
    public void testGetTheMostExpensiveCar(){
        Car car1 = new Car("SomeBrand1", 1421, 110.1234214);
        Car car2 = new Car("SomeBrand2", 321421, 110123.4214);
        Car car3 = new Car("SomeBrand3", 2321421, 1101.234214);
        Car car4 = new Car("SomeBrand4", 21, 11.01234214);
        Car car5 = new Car("SomeBrand5", 2, 11012342.14);
        Garage garage = new Garage();
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        garage.addCar(car4);
        garage.addCar(car5);

        Assert.assertEquals(car5, garage.getTheMostExpensiveCar());
    }

    @Test
    public void testFindAllCarsByBrand(){
        Car car1 = new Car("SomeBrand", 1421, 110.1234214);
        Car car2 = new Car("SomeBrand2", 321421, 110123.4214);
        Car car3 = new Car("SomeBrand3", 2321421, 1101.234214);
        Car car4 = new Car("SomeBrand", 21, 11.01234214);
        Car car5 = new Car("SomeBrand5", 2, 11012342.14);
        Garage garage = new Garage();
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        garage.addCar(car4);
        garage.addCar(car5);

        Assert.assertEquals(2, garage.findAllCarsByBrand("SomeBrand").size());
        Assert.assertEquals(1, garage.findAllCarsByBrand("SomeBrand2").size());
    }
}