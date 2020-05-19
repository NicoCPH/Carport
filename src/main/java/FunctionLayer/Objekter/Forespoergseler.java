package FunctionLayer.Objekter;

public class Forespoergseler {
    private int laengde;
    private int bredde;
    private String farve;
    private String carport_traeType;
    private  String Tag;
    private int haeldning;
    private String redskabs_traeType;
    private String gulv;
    private int redskab_laengde;
    private int redskabs_bredde;
    private String navn;
    private String adresse;
    private String kundeby;
    private int kundepostnummer;
    private String kundeemail;
    private int kundetlf;
    private double pris;
    private int id;


    public Forespoergseler(String gulv, int id, int laengde, int bredde, String farve, String carport_traeType, String tag, int haeldning,
                           String navn, String adresse, String kundeby, int kundepostnummer, String kundeemail, int kundetlf, double pris) {
        this.laengde = laengde;
        this.bredde = bredde;
        this.farve = farve;
        this.carport_traeType = carport_traeType;
        Tag = tag;
        this.haeldning = haeldning;
        this.navn = navn;
        this.adresse = adresse;
        this.kundeby = kundeby;
        this.kundepostnummer = kundepostnummer;
        this.kundeemail = kundeemail;
        this.kundetlf = kundetlf;
        this.pris = pris;
        this.id = id;
        this.gulv = gulv;
    }

    public Forespoergseler(int id, int laengde, int bredde, String farve, String carport_traeType, String tag, int haeldning, String redskabs_traeType, String gulv, int redskab_laengde, int redskabs_bredde,
                           String navn, String adresse, String kundeby, int kundepostnummer, String kundeemail, int kundetlf, double pris) {
        this.laengde = laengde;
        this.bredde = bredde;
        this.farve = farve;
        this.carport_traeType = carport_traeType;
        this.Tag = tag;
        this.haeldning = haeldning;
        this.redskabs_traeType = redskabs_traeType;
        this.gulv = gulv;
        this.redskab_laengde = redskab_laengde;
        this.redskabs_bredde = redskabs_bredde;
        this.navn = navn;
        this.adresse = adresse;
        this.kundeby = kundeby;
        this.kundepostnummer = kundepostnummer;
        this.kundeemail = kundeemail;
        this.kundetlf = kundetlf;
        this.pris = pris;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public int getLaengde() {
        return laengde;
    }

    public void setLaengde(int laengde) {
        this.laengde = laengde;
    }

    public int getBredde() {
        return bredde;
    }

    public void setBredde(int bredde) {
        this.bredde = bredde;
    }

    public String getFarve() {
        return farve;
    }

    public void setFarve(String farve) {
        this.farve = farve;
    }

    public String getCarport_traeType() {
        return carport_traeType;
    }

    public void setCarport_traeType(String carport_traeType) {
        this.carport_traeType = carport_traeType;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public int getHaeldning() {
        return haeldning;
    }

    public void setHaeldning(int haeldning) {
        this.haeldning = haeldning;
    }

    public String getRedskabs_traeType() {
        return redskabs_traeType;
    }

    public void setRedskabs_traeType(String redskabs_traeType) {
        this.redskabs_traeType = redskabs_traeType;
    }

    public String getGulv() {
        return gulv;
    }

    public void setGulv(String gulv) {
        this.gulv = gulv;
    }

    public int getRedskab_laengde() {
        return redskab_laengde;
    }

    public void setRedskab_laengde(int redskab_laengde) {
        this.redskab_laengde = redskab_laengde;
    }

    public int getRedskabs_bredde() {
        return redskabs_bredde;
    }

    public void setRedskabs_bredde(int redskabs_bredde) {
        this.redskabs_bredde = redskabs_bredde;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getKundeby() {
        return kundeby;
    }

    public void setKundeby(String kundeby) {
        this.kundeby = kundeby;
    }

    public int getKundepostnummer() {
        return kundepostnummer;
    }

    public void setKundepostnummer(int kundepostnummer) {
        this.kundepostnummer = kundepostnummer;
    }

    public String getKundeemail() {
        return kundeemail;
    }

    public void setKundeemail(String kundeemail) {
        this.kundeemail = kundeemail;
    }

    public int getKundetlf() {
        return kundetlf;
    }

    public void setKundetlf(int kundetlf) {
        this.kundetlf = kundetlf;
    }
}
