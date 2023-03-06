package Cars;

public class OffRoadCar extends Car{
    int whealSize;

    public int getWhealSize() {
        return whealSize;
    }

    public void setWhealSize(int whealSize) {
        this.whealSize = whealSize;
    }

    public OffRoadCar(String name, int size) {
        super(name, size);
    }

    public OffRoadCar(String name, int lenght, int width, int height) {
        super(name, lenght, width, height);
    }
}
