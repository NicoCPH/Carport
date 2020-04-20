package FunctionLayer;

public class Redskabsrum {

    int redskabsLaengde;
    int redskabsBredde;
    String beklaedningsType;
    String placering;
    String gulvType;

    public Redskabsrum(int redskabsLaengde, int redskabsBredde, String beklaedningsType, String placering, String gulvType) {
        this.redskabsLaengde = redskabsLaengde;
        this.redskabsBredde = redskabsBredde;
        this.beklaedningsType = beklaedningsType;
        this.placering = placering;
        this.gulvType = gulvType;
    }

    public int getRedskabsLaengde() {
        return redskabsLaengde;
    }

    public void setRedskabsLaengde(int redskabsLaengde) {
        this.redskabsLaengde = redskabsLaengde;
    }

    public int getRedskabsBredde() {
        return redskabsBredde;
    }

    public void setRedskabsBredde(int redskabsBredde) {
        this.redskabsBredde = redskabsBredde;
    }

    public String getBeklaedningsType() {
        return beklaedningsType;
    }

    public void setBeklaedningsType(String beklaedningsType) {
        this.beklaedningsType = beklaedningsType;
    }

    public String getPlacering() {
        return placering;
    }

    public void setPlacering(String placering) {
        this.placering = placering;
    }

    public String getGulvType() {
        return gulvType;
    }

    public void setGulvType(String gulvType) {
        this.gulvType = gulvType;
    }
}
