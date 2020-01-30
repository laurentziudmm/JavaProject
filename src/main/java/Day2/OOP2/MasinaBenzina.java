package Day2.OOP2;


public abstract class MasinaBenzina extends BaseCar implements Car{


    public Combustibil combustibil() {
        return new Combustibil("Benzina", 7);
    }
}
