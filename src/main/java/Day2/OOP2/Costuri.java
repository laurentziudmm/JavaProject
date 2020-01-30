package Day2.OOP2;



public interface Costuri {
    int pretUnitar();
    int cantitate();

    default int costuri(){
        System.out.println("From Interface");
        return pretUnitar()*cantitate();
    }
}
