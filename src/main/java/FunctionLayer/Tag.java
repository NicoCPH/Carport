package FunctionLayer;

public class Tag {

    String tagmateriale;
    String farve;
    int haeldning;

    int tagmaterialeid;
    int farveid;
    int haeldningid;


    public Tag(String type, String farve, int haeldning, int typeid, int farveid, int haeldningid) {
        this.tagmateriale = type;
        this.farve = farve;
        this.haeldning = haeldning;
        this.tagmaterialeid = typeid;
        this.farveid = farveid;
        this.haeldningid = haeldningid;
    }

    public Tag(int typeid, int farveid, int haeldningid) {
        this.tagmaterialeid = typeid;
        this.farveid = farveid;
        this.haeldningid = haeldningid;
    }

    public int getFarveid() {
        return farveid;
    }

    public void setFarveid(int farveid) {
        this.farveid = farveid;
    }

    public int getHaeldningid() {
        return haeldningid;
    }

    public void setHaeldningid(int haeldningid) {
        this.haeldningid = haeldningid;
    }

    public int getTypeid() {
        return tagmaterialeid;
    }

    public void setTypeid(int typeid) {
        this.tagmaterialeid = typeid;
    }

    public String getType() {
        return tagmateriale;
    }

    public void setType(String type) {
        this.tagmateriale = type;
    }

    public String getFarve() {
        return farve;
    }

    public void setFarve(String farve) {
        this.farve = farve;
    }

    public int getHaeldning() {
        return haeldning;
    }

    public void setHaeldning(int haeldning) {
        this.haeldning = haeldning;
    }
}
