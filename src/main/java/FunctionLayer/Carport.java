package FunctionLayer;

public class Carport {

    int carportBredde;
    int carportLaengde;
    String carportFarve;
    String carporttraeType;
    int carportBreddeid;
    int carportLaengdeid;
    int carportFarveid;
    int carporttraeTypeid;

    public Carport(int carportBredde, int carportBreddeid) {
        this.carportBredde = carportBredde;
        this.carportBreddeid = carportBreddeid;
    }

    public Carport(String carportFarve, int carportFarveid) {
        this.carportFarve = carportFarve;
        this.carportFarveid = carportFarveid;
    }

    public Carport(int carportBredde, int carportLaengde, String carportFarve, String carporttraeType,
                   int carportBreddeid, int carportLaengdeid, int carportFarveid, int carporttraeTypeid) {
        this.carportBredde = carportBredde;
        this.carportLaengde = carportLaengde;
        this.carportFarve = carportFarve;
        this.carporttraeType = carporttraeType;
        this.carportBreddeid = carportBreddeid;
        this.carportLaengdeid = carportLaengdeid;
        this.carportFarveid = carportFarveid;
        this.carporttraeTypeid = carporttraeTypeid;
    }

    public Carport(int carportBreddeid, int carportLaengdeid, int carportFarveid, int carporttraeTypeid) {
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

    public int getCarportFarveid() {
        return carportFarveid;
    }

    public void setCarportFarveid(int carportFarveid) {
        this.carportFarveid = carportFarveid;
    }

    public int getCarporttraeTypeid() {
        return carporttraeTypeid;
    }

    public void setCarporttraeTypeid(int carporttraeTypeid) {
        this.carporttraeTypeid = carporttraeTypeid;
    }
}
