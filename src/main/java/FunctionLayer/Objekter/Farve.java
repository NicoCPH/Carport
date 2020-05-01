package FunctionLayer.Objekter;

public class Farve {
    String carportFarve;
    int carportFarveid;

    public Farve(String carportFarve, int carportFarveid) {
        this.carportFarve = carportFarve;
        this.carportFarveid = carportFarveid;
    }

    public String getCarportFarve() {
        return carportFarve;
    }

    public void setCarportFarve(String carportFarve) {
        this.carportFarve = carportFarve;
    }

    public int getCarportFarveid() {
        return carportFarveid;
    }

    public void setCarportFarveid(int carportFarveid) {
        this.carportFarveid = carportFarveid;
    }
}
