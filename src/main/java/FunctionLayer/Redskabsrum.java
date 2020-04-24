package FunctionLayer;

public class Redskabsrum {

    int redskabsrumLaengde;
    int redskabsrumBredde;
    String beklaedningsType;
    String reskabsrumGulv;
    int redskabsrumLaengdeid;
    int reskabsrumsBreddeid;
    int beklaedningsTypeid;
    int redskabsrumGulvid;

    public Redskabsrum(int redskabsrumLaengde, int redskabsrumBredde, String beklaedningsType, String gulvType,
                       int redskabsrumLaengdeid, int reskabsrumsBreddeid, int beklaedningsTypeid, int gulvTypeid) {
        this.redskabsrumLaengde = redskabsrumLaengde;
        this.redskabsrumBredde = redskabsrumBredde;
        this.beklaedningsType = beklaedningsType;
        this.reskabsrumGulv = gulvType;
        this.redskabsrumLaengdeid = redskabsrumLaengdeid;
        this.reskabsrumsBreddeid = reskabsrumsBreddeid;
        this.beklaedningsTypeid = beklaedningsTypeid;
        this.redskabsrumGulvid = gulvTypeid;
    }

    public Redskabsrum(int redskabsrumLaengdeid, int reskabsrumsBreddeid, int beklaedningsTypeid, int gulvTypeid) {
        this.redskabsrumLaengdeid = redskabsrumLaengdeid;
        this.reskabsrumsBreddeid = reskabsrumsBreddeid;
        this.beklaedningsTypeid = beklaedningsTypeid;
        this.redskabsrumGulvid = gulvTypeid;
    }

    public int getRedskabsrumLaengde() {
        return redskabsrumLaengde;
    }

    public void setRedskabsrumLaengde(int redskabsrumLaengde) {
        this.redskabsrumLaengde = redskabsrumLaengde;
    }

    public int getRedskabsrumBredde() {
        return redskabsrumBredde;
    }

    public void setRedskabsrumBredde(int redskabsrumBredde) {
        this.redskabsrumBredde = redskabsrumBredde;
    }

    public String getBeklaedningsType() {
        return beklaedningsType;
    }

    public void setBeklaedningsType(String beklaedningsType) {
        this.beklaedningsType = beklaedningsType;
    }

    public String getGulvType() {
        return reskabsrumGulv;
    }

    public void setGulvType(String gulvType) {
        this.reskabsrumGulv = gulvType;
    }

    public int getRedskabsrumLaengdeid() {
        return redskabsrumLaengdeid;
    }

    public void setRedskabsrumLaengdeid(int redskabsrumLaengdeid) {
        this.redskabsrumLaengdeid = redskabsrumLaengdeid;
    }

    public int getReskabsrumsBreddeid() {
        return reskabsrumsBreddeid;
    }

    public void setReskabsrumsBreddeid(int reskabsrumsBreddeid) {
        this.reskabsrumsBreddeid = reskabsrumsBreddeid;
    }

    public int getBeklaedningsTypeid() {
        return beklaedningsTypeid;
    }

    public void setBeklaedningsTypeid(int beklaedningsTypeid) {
        this.beklaedningsTypeid = beklaedningsTypeid;
    }

    public int getGulvTypeid() {
        return redskabsrumGulvid;
    }

    public void setGulvTypeid(int gulvTypeid) {
        this.redskabsrumGulvid = gulvTypeid;
    }
}
