package DBAccess;

import FunctionLayer.Fejl_haendtering;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Kunde_Mapper {

    public static List<String> kundeEmails = new ArrayList<>();
    /**
     *Metoden finder ud af om man allerede har en kunde med den email, og hvis den har, laver den ikke en ny kunde men derimod,
     * tilføjer forespørgslen til den givne email.
     * Ellers laver den en nye kunde. og tilføjer forespørgslen til den.
     *
     * @param carportBredde bredde i cm
     * @param carportFarve carport farven
     * @param carportTraeType carport trætype
     * @param email kunde email
     * @param carportLaengde længde i cm
     * @param navn kunde navn
     * @param postNummer kunde postnummer
     * @param pris pris på tilbud
     * @param redskabsrumsbredde  redskabs bredde
     * @param redskabsrumBeklaedningstype redskabs beklædningstype
     * @param redskabsrumGulv redskabs gulv
     * @param redskabsrumslaengde redskabs længde
     * @param tagHaeldning hældning på taget
     * @param tagMateriale tag matriale
     * @param tlf kunde tlf
     * @throws Fejl_haendtering
     */
    public static void lav_Kunde(String navn, int postNummer,  int tlf,
                                 String email, int carportLaengde, int carportBredde, int carportFarve,
                                 int carportTraeType, int tagMateriale, int tagHaeldning, int redskabsrumsbredde,
                                 int redskabsrumslaengde, int redskabsrumBeklaedningstype, int redskabsrumGulv, double pris) throws Fejl_haendtering {

        if(findEmail().contains(email)){
            int kundeid = findKundeId(email);
            Carport_Mapper.forespoergselList(carportLaengde, carportBredde, carportFarve,
                    carportTraeType,  tagMateriale,  tagHaeldning,  redskabsrumsbredde,
                    redskabsrumslaengde,  redskabsrumBeklaedningstype, redskabsrumGulv, kundeid, pris);

        } else {


            try {
                Connection con = Connector.connection();

                String SQL = "INSERT INTO `carportdb`.`kunde` (`navn`," +
                        " `postnummer`, `tlf`, `email`)" +
                        " VALUES (?, ?, ?, ?);";

                PreparedStatement ps = con.prepareStatement(SQL);

                ps.setString(1, navn);
                ps.setInt(2, postNummer);
                ps.setInt(3, tlf);
                ps.setString(4, email);
                ps.executeUpdate();


            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }


            int kundeid = findKundeId(email);
            Carport_Mapper.forespoergselList(carportLaengde, carportBredde, carportFarve,
                    carportTraeType, tagMateriale, tagHaeldning, redskabsrumsbredde,
                    redskabsrumslaengde, redskabsrumBeklaedningstype, redskabsrumGulv, kundeid, pris);

        }
    }
    /**
     *Metoden her behandler alt input fra brugern, og finder derefter id på kunden ved en givent email.
     *
     * @param email Kundens email
     * @return int
     */
    public static int findKundeId (String email)  throws Fejl_haendtering {
        int kundeid = 0;
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();
            String SQL = "SELECT kundeId FROM kunde where email = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                kundeid = rs.getInt("kundeId");

            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return kundeid;
    }


    /**
     *Metoden her finder alle email i databasen.
     *
     * @return List<String>
     */
    public static List<String> findEmail ()  throws Fejl_haendtering {
        if(kundeEmails == null) {
            kundeEmails = new ArrayList<>();
        }

        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();
            String SQL = "SELECT email FROM kunde;";
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()) {
               String kundeemail = rs.getString("email");
               kundeEmails.add(kundeemail);

            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return kundeEmails;
    }

}
