package FunctionLayer;

public class Redskabsrum {

    int redskabsLaengde;
    int redskabsBredde;
    int beklaedningsType;
    int gulvType;

    public Redskabsrum(int redskabsLaengde, int redskabsBredde, int beklaedningsType,int gulvType) {
        this.redskabsLaengde = redskabsLaengde;
        this.redskabsBredde = redskabsBredde;
        this.beklaedningsType = beklaedningsType;
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

    public int getBeklaedningsType() {
        return beklaedningsType;
    }

    public void setBeklaedningsType(int beklaedningsType) {
        this.beklaedningsType = beklaedningsType;
    }

    public int getGulvType() {
        return gulvType;
    }

    public void setGulvType(int gulvType) {
        this.gulvType = gulvType;
    }
}
