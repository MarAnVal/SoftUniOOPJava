package Rectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        int pointX = point.getX();
        int startX = this.bottomLeft.getX();
        int endX = this.topRight.getX();
        if (endX < startX) {
            int buffer = startX;
            startX = endX;
            endX = buffer;
        }
        int pointY = point.getY();
        int startY = this.bottomLeft.getY();
        int endY = this.topRight.getY();
        if (endY < startY) {
            int buffer = startY;
            startY = endY;
            endY = buffer;
        }
        return pointX >= startX && pointX <= endX && pointY >= startY && pointY <= endY;
    }
}
