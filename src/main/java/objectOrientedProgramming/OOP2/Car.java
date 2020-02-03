package objectOrientedProgramming.OOP2;


public interface Car {
    int volumRezervor();

    Combustibil combustibil();

    default int costuri() {
        System.out.println("From Interface");
        return combustibil().getPrice() * volumRezervor();
    }
}
