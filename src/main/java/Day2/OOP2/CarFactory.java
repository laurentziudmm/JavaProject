package Day2.OOP2;


public class CarFactory {
    public static Car instance(int tip){
        if(tip==1){
            return new Logan14();
        }else if(tip==2){
            return new Logan15();
        }else{
            throw new IllegalStateException("Caz netratat!");
        }
    }
}
