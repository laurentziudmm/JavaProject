package day2.OOP.runapp;

import day2.OOP.canvas.Canvas;
import day2.OOP.graphicshape.*;

/**
 * RunApp
 **/

public class RunApp {
    public static void main(String[] args) {

        Circle circle=new Circle(4,5,7, 21, 22f);
        Circles circles = new Circles(circle);
        double area= circles.getAreaPub();
        circles.getAreaDef();
        System.out.println("The default circle area is "+area);

        Canvas canvas=new Canvas();
        canvas.paint();

        Shape s1=new Circle(10,-1,-2, 21, 22f);
//        Shape s2=new Square(10);
        System.out.println(s1.area());
//        System.out.println(s2.area());


        Object p1=new Point(10,20);
        Object p2=new Point(50,100);
        Object p3=new Point(10,20);

        System.out.println("p1 equals p2 "+p1.equals(p2));
        System.out.println("p1 equals p3 "+p1.equals(p3));
    }
}
