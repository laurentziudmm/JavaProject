package Day2.OOP2;

public class TestCar {
    public static void main(String[] args) {
        Car car= CarFactory.instance(1);
        System.out.println(car.costuri());

        car=CarFactory.instance(2);
        System.out.println(car.costuri());



    }
}
