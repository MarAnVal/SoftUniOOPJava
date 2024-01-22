package Shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public final double getRadius() {
        return radius;
    }
    @Override
    protected double calculatePerimeter() {
        //perimeter of a circle = 2πr
        return 2 * Math.PI * this.radius;
    }

    @Override
    protected double calculateArea() {
        // Area of a circle = πrr
        return Math.PI * this.radius * this.radius;
    }
}
