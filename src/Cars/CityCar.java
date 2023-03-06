package Cars;

public class CityCar extends Car {
     private String typSilnika;
    public CityCar(String name, int size) {
        super(name, size);
    }

    public CityCar(String name, int lenght, int width, int height) {
        super(name, lenght, width, height);
    }

    public String getTypSilnika() {
        return typSilnika;
    }

    public void setTypSilnika(String typSilnika) {
        this.typSilnika = typSilnika;
    }
}
