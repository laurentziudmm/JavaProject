package objectOrientedProgramming.OOP2;


public class Combustibil {
    private String tip;
    private int price;

    public Combustibil(String tip, int price) {
        this.tip = tip;
        this.price = price;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
