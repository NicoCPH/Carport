package FunctionLayer;

public class Tag {

    String type;
    String farve;
    int haeldning;

    public Tag(String type, String farve, int haeldning) {
        this.type = type;
        this.farve = farve;
        this.haeldning = haeldning;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
