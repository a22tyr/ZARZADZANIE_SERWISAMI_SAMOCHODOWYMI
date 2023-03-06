package Rooms;

public class IndependentCarServiceSpot extends CarSServiceSpot {
    private static int id =100;
    private int IdCarService;

    public IndependentCarServiceSpot(int size, Servis servis) {
        super(size, servis);
        id++;
        this.IdCarService = id;
    }

    public IndependentCarServiceSpot(int lenght, int width, int height, Servis servis) {
        super(lenght, width, height, servis);
        id++;
        this.IdCarService = id;
    }
    @Override
    public String toString() {
        return "Independent Car servide o id " + IdCarService;
    }

    @Override
    public int getIdCarService() {
        return IdCarService;
    }
}
