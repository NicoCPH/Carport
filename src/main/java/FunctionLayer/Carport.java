package FunctionLayer;

public class Carport {

    public String type;
    public int bredde;
    public int laengde;
    public String farve;
    public String traeType;


    public Carport(String type, int bredde, int laengde, String farve, String traeType) {
        this.type = type;
        this.bredde = bredde;
        this.laengde = laengde;
        this.farve = farve;
        this.traeType = traeType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBredde() {
        return bredde;
    }

    public void setBredde(int bredde) {
        this.bredde = bredde;
    }

    public int getLaengde() {
        return laengde;
    }

    public void setLaengde(int laengde) {
        this.laengde = laengde;
    }

    public String getFarve() {
        return farve;
    }

    public void setFarve(String farve) {
        this.farve = farve;
    }

    public String getTraeType() {
        return traeType;
    }

    public void setTraeType(String traeType) {
        this.traeType = traeType;
    }
}
