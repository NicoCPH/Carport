package FunctionLayer;

public class Redskabsrum {


    String beklaedningsType;
    String reskabsrumGulv;
    int beklaedningsTypeid;
    int redskabsrumGulvid;


    public Redskabsrum(String beklaedningsType, int beklaedningsTypeid) {
        this.beklaedningsType = beklaedningsType;
        this.beklaedningsTypeid = beklaedningsTypeid;
    }

    public Redskabsrum(int redskabsrumGulvid, String reskabsrumGulv) {
        this.redskabsrumGulvid = redskabsrumGulvid;
        this.reskabsrumGulv = reskabsrumGulv;
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
