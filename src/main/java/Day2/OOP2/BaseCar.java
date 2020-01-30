package Day2.OOP2;


public abstract class BaseCar  {

    public abstract int volumRezervor();

    public abstract Combustibil combustibil();

    public int costuri(){
        System.out.println("From abstract");
        return combustibil().getPrice()*volumRezervor()*10;
    }






}
