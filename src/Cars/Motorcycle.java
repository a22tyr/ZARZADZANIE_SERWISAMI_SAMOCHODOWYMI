package Cars;

public class Motorcycle extends Car{
    String typMotoru;

    public String getTypMotoru() {
        return typMotoru;
    }

    public void setTypMotoru(String typMotoru) {
        this.typMotoru = typMotoru;
    }

    public Motorcycle(String name, int size) {
        super(name, size);
    }

    public Motorcycle(String name, int lenght, int width, int height) {
        super(name, lenght, width, height);
    }
}
