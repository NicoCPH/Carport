package FunctionLayer;

public class Carport {

    public int bredde;
    public int laengde;
    public int farve;
    public int traeType;


    public Carport(int bredde, int laengde, int farve, int traeType) {
        this.bredde = bredde;
        this.laengde = laengde;
        this.farve = farve;
        this.traeType = traeType;
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

    public int getFarve() {
        return farve;
    }

    public void setFarve(int farve) {
        this.farve = farve;
    }

    public int getTraeType() {
        return traeType;
    }

    public void setTraeType(int traeType) {
        this.traeType = traeType;
    }
}
