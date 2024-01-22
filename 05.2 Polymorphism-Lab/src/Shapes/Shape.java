package Shapes;

public abstract class Shape {
    private double perimeter;
    private double area;
    public final double getPerimeter(){
        return calculatePerimeter();
    }
    public final double getArea(){
        return calculateArea();
    }
    protected abstract double calculatePerimeter();
    protected abstract double calculateArea();
}
