package FunctionLayer.Objekter;

public class Traetype {
    private  int carporttraeTypeid;
    private String carporttraeType;

    public Traetype(int carporttraeTypeid, String carporttraeType) {
        this.carporttraeTypeid = carporttraeTypeid;
        this.carporttraeType = carporttraeType;
    }

    public int getCarporttraeTypeid() {
        return carporttraeTypeid;
    }

    public void setCarporttraeTypeid(int carporttraeTypeid) {
        this.carporttraeTypeid = carporttraeTypeid;
    }

    public String getCarporttraeType() {
        return carporttraeType;
    }

    public void setCarporttraeType(String carporttraeType) {
        this.carporttraeType = carporttraeType;
    }
}
