package FunctionLayer;

public class Carport {

    int carportBredde;
    int carportLaengde;
    String carportFarve;
    String carporttraeType;
    int carportBreddeid;
    int carportLaengdeid;
    String carportFarveid;
    String carporttraeTypeid;

    public Carport(int carportBredde, int carportLaengde, String carportFarve, String carporttraeType,
                   int carportBreddeid, int carportLaengdeid, String carportFarveid, String carporttraeTypeid) {
        this.carportBredde = carportBredde;
        this.carportLaengde = carportLaengde;
        this.carportFarve = carportFarve;
        this.carporttraeType = carporttraeType;
        this.carportBreddeid = carportBreddeid;
        this.carportLaengdeid = carportLaengdeid;
        this.carportFarveid = carportFarveid;
        this.carporttraeTypeid = carporttraeTypeid;
    }

    public Carport(int carportBreddeid, int carportLaengdeid, String carportFarveid, String carporttraeTypeid) {
        this.carportBreddeid = carportBreddeid;
        this.carportLaengdeid = carportLaengdeid;
        this.carportFarveid = carportFarveid;
        this.carporttraeTypeid = carporttraeTypeid;
    }

    public int getCarportBredde() {
        return carportBredde;
    }

    public void setCarportBredde(int carportBredde) {
        this.carportBredde = carportBredde;
    }

    public int getCarportLaengde() {
        return carportLaengde;
    }

    public void setCarportLaengde(int carportLaengde) {
        this.carportLaengde = carportLaengde;
    }

    public String getCarportFarve() {
        return carportFarve;
    }

    public void setCarportFarve(String carportFarve) {
        this.carportFarve = carportFarve;
    }

    public String getCarporttraeType() {
        return carporttraeType;
    }

    public void setCarporttraeType(String carporttraeType) {
        this.carporttraeType = carporttraeType;
    }

    public int getCarportBreddeid() {
        return carportBreddeid;
    }

    public void setCarportBreddeid(int carportBreddeid) {
        this.carportBreddeid = carportBreddeid;
    }

    public int getCarportLaengdeid() {
        return carportLaengdeid;
    }

    public void setCarportLaengdeid(int carportLaengdeid) {
        this.carportLaengdeid = carportLaengdeid;
    }

    public String getCarportFarveid() {
        return carportFarveid;
    }

    public void setCarportFarveid(String carportFarveid) {
        this.carportFarveid = carportFarveid;
    }

    public String getCarporttraeTypeid() {
        return carporttraeTypeid;
    }

    public void setCarporttraeTypeid(String carporttraeTypeid) {
        this.carporttraeTypeid = carporttraeTypeid;
    }
}
