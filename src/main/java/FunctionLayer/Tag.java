package FunctionLayer;

public class Tag {

    int type;
    int farve;
    int haeldning;

    public Tag(int type, int farve, int haeldning) {
        this.type = type;
        this.farve = farve;
        this.haeldning = haeldning;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getFarve() {
        return farve;
    }

    public void setFarve(int farve) {
        this.farve = farve;
    }

    public int getHaeldning() {
        return haeldning;
    }

    public void setHaeldning(int haeldning) {
        this.haeldning = haeldning;
    }
}
