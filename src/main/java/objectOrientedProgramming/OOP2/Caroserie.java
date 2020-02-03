package objectOrientedProgramming.OOP2;

public class Caroserie {
    private String culoare;
    private final String forma;

    public Caroserie(String culoare, String forma) {
        this.culoare = culoare;
        this.forma = forma;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public String getForma() {
        return forma;
    }
}
