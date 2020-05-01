package FunctionLayer.Objekter;

/**
 * Denne klasse indeholder variabler, konstruktør, gettere & settere for et materiale.
 */

public class Materiale {

    private int id;
    private String beskrivelse;
    private double hoajde, bredde, laengde;
    private double buyprice, sellprice;
    private int type_id, measure_id;

    public Materiale(int id, String beskrivelse, double hoajde, double bredde, double laengde, double buyprice, double sellprice,
                     int type_id, int measure_id) {
        this.id = id;
        this.beskrivelse = beskrivelse;
        this.hoajde = hoajde;
        this.bredde = bredde;
        this.laengde = laengde;
        this.buyprice = buyprice;
        this.sellprice = sellprice;
        this.type_id = type_id;
        this.measure_id = measure_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public double getHoajde() {
        return hoajde;
    }

    public void setHoajde(double hoajde) {
        this.hoajde = hoajde;
    }

    public double getBredde() {
        return bredde;
    }

    public void setBredde(double bredde) {
        this.bredde = bredde;
    }

    public double getLaengde() {
        return laengde;
    }

    public void setLaengde(double laengde) {
        this.laengde = laengde;
    }

    public double getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(double buyprice) {
        this.buyprice = buyprice;
    }

    public double getSellprice() {
        return sellprice;
    }

    public void setSellprice(double sellprice) {
        this.sellprice = sellprice;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getMeasure_id() {
        return measure_id;
    }

    public void setMeasure_id(int measure_id) {
        this.measure_id = measure_id;
    }
}