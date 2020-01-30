package Day2.OOP.graphicshape;

/**
 * Square
 **/

public class Square extends Shape{
    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side*side;
    }
}
