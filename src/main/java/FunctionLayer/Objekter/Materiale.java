package FunctionLayer.Objekter;

/**
 * Denne klasse indeholder variabler, konstruktør, gettere & settere for et materiale.
 */

public class Materiale {

    private int id;
    private String beskrivelse, navn;
    private int laengde;

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

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getLaengde() {
        return laengde;
    }

    public void setLaengde(int laengde) {
        this.laengde = laengde;
    }

    public Materiale(int id, String beskrivelse, String navn, int laengde) {
        this.id = id;
        this.beskrivelse = beskrivelse;
        this.navn = navn;
        this.laengde = laengde;
    }

    public Materiale(String beskrivelse, String navn, int laengde) {
        this.beskrivelse = beskrivelse;
        this.navn = navn;
        this.laengde = laengde;
    }

    public Materiale(int laengde, String beskrivelse, String navn) {
        this.beskrivelse = beskrivelse;
        this.navn = navn;
        this.laengde = laengde;
    }

}