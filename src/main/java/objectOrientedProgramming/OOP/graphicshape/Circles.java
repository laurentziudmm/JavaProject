package objectOrientedProgramming.OOP.graphicshape;

/**
 * Circles
 **/

public class Circles {
    
    private final Circle circle;

    public Circles(Circle circle) {
        this.circle = circle;
    }

    public double getAreaPub(){
        return circle.area();
    }

    public void getAreaDef(){

        circle.fillColour();


    }
}
