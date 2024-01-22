package ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        validateDimension(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        validateDimension(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        validateDimension(height, "Height");
        this.height = height;
    }

    //+ calculateSurfaceArea (): double
    public double calculateSurfaceArea() {
        return (2 * (this.length * this.width + this.length * this.height + this.width * this.height));
    }

    //+ calculateLateralSurfaceArea (): double
    public double calculateLateralSurfaceArea() {
        return (2 * this.height * (this.length + this.width));
    }

    //+ calculateVolume (): double
    public double calculateVolume() {
        return this.height * this.width * this.length;
    }

    private void validateDimension(double dimension, String dimensionName) {
        //Width cannot be zero or negative.
        if (dimension < 1) {
            throw new IllegalArgumentException(dimensionName + " cannot be zero or negative.");
        }
    }
}
