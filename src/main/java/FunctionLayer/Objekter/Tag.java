package FunctionLayer.Objekter;

public class Tag {

    private  String tagmateriale;
    private int haeldning;
    private int tagmaterialeid;
    private int haeldningid;

    public Tag(int haeldning, int haeldningid) {
        this.haeldning = haeldning;
        this.haeldningid = haeldningid;
    }

    public Tag(String tagmateriale, int tagmaterialeid) {
        this.tagmateriale = tagmateriale;
        this.tagmaterialeid = tagmaterialeid;
    }

    public Tag(String type,  int haeldning, int typeid, int farveid, int haeldningid) {
        this.tagmateriale = type;

        this.haeldning = haeldning;
        this.tagmaterialeid = typeid;

        this.haeldningid = haeldningid;
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

    public int getHaeldning() {
        return haeldning;
    }

    public void setHaeldning(int haeldning) {
        this.haeldning = haeldning;
    }
}
