package day2.OOP.graphicshape;

/**
 * Shape implementation
 **/

public class Shape extends AbstractShape{
    private final  int color;
    private final float saturation;

    public Shape(int color, float saturation) {
        this.color = color;
        this.saturation = saturation;
    }

    int getColor() {
        return color;
    }



    public float getSaturation() {
        return saturation;
    }


    @Override
    public double area() {
        return 0;
    }
}
