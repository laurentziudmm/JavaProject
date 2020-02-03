package objectOrientedProgramming.OOP2;


public class Motor {
    private final int cp;
    private int capacitate;

    public Motor(int cp, int capacitate) {
        this.cp = cp;
        this.capacitate = capacitate;
    }

    public int getCp() {
        return cp;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "cp=" + cp +
                ", capacitate=" + capacitate +
                '}';
    }
}
