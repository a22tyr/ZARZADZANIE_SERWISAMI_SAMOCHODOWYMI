package Cars;

public class Amphibians extends Car {
    String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Amphibians(String name, int size) {
        super(name, size);
    }

    public Amphibians(String name, int lenght, int width, int height) {
        super(name, lenght, width, height);
    }
}
