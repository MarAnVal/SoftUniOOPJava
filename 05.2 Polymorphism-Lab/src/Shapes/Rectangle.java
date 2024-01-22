package Shapes;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public final double getHeight() {
        return height;
    }

    public final double getWidth() {
        return width;
    }

    @Override
    protected double calculatePerimeter() {
        return 2 * (getHeight() + getWidth());
    }

    @Override
    protected double calculateArea() {
        return getHeight() * getWidth();
    }

}
