package day2.OOP2;


public abstract class  MasinaDiesel  extends BaseCar implements Car {


    public Combustibil combustibil()  {
        return new Combustibil("Diesel",6);
    }
}
