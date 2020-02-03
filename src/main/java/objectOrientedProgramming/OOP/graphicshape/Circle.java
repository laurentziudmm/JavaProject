package objectOrientedProgramming.OOP.graphicshape;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

/**
 * Circle implementation
 **/

public class Circle extends  Shape{
    private final int xPos;
    private final int  yPos;
    private final int radius;



    public Circle(int xPos, int yPos, int radius, int color, float saturation ) {
        super(color , saturation);
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }




    @Override
    public double area() {
        return PI*pow(this.radius,2);
    }

    public void fillColour(){
        System.out.println("The circle colour is "+getColor());
    }





    @Override
    public String toString() {
        return "center =("+xPos+","+yPos+") and radius = "+radius;
    }
}
