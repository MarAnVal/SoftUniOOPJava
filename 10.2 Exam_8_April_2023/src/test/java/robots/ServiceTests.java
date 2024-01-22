package test.java.robots;

import main.java.robots.Robot;
import main.java.robots.Service;

import org.junit.Assert;
import org.junit.Test;

public class ServiceTests {
    //public Service(String name, int capacity){
    //        this.setCapacity(capacity);
    //        this.setName(name);
    //        this.robot = new ArrayList<>();
    //    }
    //
    //    public String getName() {
    //        return name;
    //    }
    //
    //    private void setName(String name) {
    //        if (name == null || name.trim().isEmpty()){
    //            throw new NullPointerException("Invalid name!");
    //        }
    //        this.name = name;
    //    }
    @Test(expected = NullPointerException.class)
    public void testServiceSetNameNull(){
        Service service = new Service(null, 343);
    }
    @Test(expected = NullPointerException.class)
    public void testServiceSetNameSpaces(){
        Service service = new Service("   ", 343);
    }
    //    public int getCapacity() {
    //        return capacity;
    //    }
    //
    //    private void setCapacity(int capacity) {
    //        if (capacity < 0) {
    //            throw new IllegalArgumentException("Invalid capacity!");
    //        }
    //        this.capacity = capacity;
    //    }
    @Test(expected = IllegalArgumentException.class)
    public void testServiceSetCapacityNegative(){
        Service service = new Service("SomeName", -343);
    }
    @Test
    public void testServiceGetCapacity(){
        Service service = new Service("SomeName", 343);
        Assert.assertEquals(343, service.getCapacity());
    }
    @Test
    public void testServiceGetCount(){
        Service service = new Service("SomeName", 343);
        Assert.assertEquals(0, service.getCount());
    }
    @Test
    public void testServiceGetName(){
        Service service = new Service("SomeName", 343);
        Assert.assertEquals("SomeName", service.getName());
    }
    //    public int getCount() {
    //        return this.robot.size();
    //    }
    //
    //    public void add(Robot robot){
    //        if (this.robot.size() == this.capacity){
    //            throw new IllegalArgumentException("Full service!");
    //        }
    //        this.robot.add(robot);
    //    }
    @Test
    public void testAdd(){
        Robot robot = new Robot("RobotName");
        Service service = new Service("SomeName", 1);
        service.add(robot);
        Assert.assertEquals(1, service.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddFullCapacity(){
        Robot robot = new Robot("RobotName");
        Service service = new Service("SomeName", 1);
        service.add(robot);
        service.add(robot);
    }
    //    public void remove(String name) {
    //        Robot robotToRemove = this.robot.stream()
    //                .filter(f -> name.equals(f.getName()))
    //                .findAny()
    //                .orElse(null);
    //        if (robotToRemove == null){
    //            throw new IllegalArgumentException(String.format("Robot with name %s doesn't exist!", name));
    //        }
    //        this.robot.remove(robotToRemove);
    //    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNotExisting(){
        Robot robot = new Robot("RobotName");
        Service service = new Service("SomeName", 1);
        service.add(robot);
        service.remove("RobotName1");
    }
    @Test
    public void testRemove(){
        Robot robot = new Robot("RobotName");
        Service service = new Service("SomeName", 10);
        service.add(robot);
        service.add(robot);
        service.remove("RobotName");
        Assert.assertEquals(1, service.getCount());
    }
    //    public Robot forSale(String name){
    //        Robot robot = this.robot.stream()
    //                .filter(f -> name.equals(f.getName()))
    //                .findAny()
    //                .orElse(null);
    //        if (robot == null){
    //            throw new IllegalArgumentException(String.format("Robot with name %s doesn't exist!", name));
    //        }
    //        robot.setReadyForSale(false);
    //
    //        return robot;
    //    }
    @Test(expected = IllegalArgumentException.class)
    public void testForSaleNotExisting(){
        Robot robot = new Robot("RobotName");
        Service service = new Service("SomeName", 10);
        service.add(robot);
        service.add(robot);
        service.forSale("RobotName1");
    }
    @Test
    public void testForSale(){
        Robot robot = new Robot("RobotName");
        Robot robot1 = new Robot("RobotName1");
        Service service = new Service("SomeName", 10);
        service.add(robot);
        service.add(robot1);
        Assert.assertEquals(robot1, service.forSale("RobotName1"));
        Assert.assertFalse(robot1.isReadyForSale());
    }
    //    public String report(){
    //        String names = this.robot.stream().map(Robot::getName).collect(Collectors.joining(", "));
    //        return String.format("The robot %s is in the service %s!", names, this.name);
    //    }
    @Test
    public void testReport(){
        String serviceName = "SomeName";
        String robots = "RobotName, RobotName1";
        String expected = String.format("The robot %s is in the service %s!", robots, serviceName);
        Robot robot = new Robot("RobotName");
        Robot robot1 = new Robot("RobotName1");
        Service service = new Service("SomeName", 10);
        service.add(robot);
        service.add(robot1);
        Assert.assertEquals(expected, service.report());
    }
}
