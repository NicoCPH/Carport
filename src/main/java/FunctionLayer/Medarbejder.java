package FunctionLayer;

public class Medarbejder {

    private int id;
    private String navn;
    private String password;
    private String email;


    public Medarbejder(int id, String navn, String password, String email) {
        this.id = id;
        this.navn = navn;
        this.password = password;
        this.email = email;
    }

    public Medarbejder(String navn, String password, String email) {
        this.navn = navn;
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}