package DBAccess;

import FunctionLayer.Fejl_haendtering;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KundeMapper {

    public static List<String> kundeEmails = new ArrayList<>();

    public static void lavKunde_MedRedskabsrum(String navn, String adresse, int postNummer, String by, int tlf,
                                                       String email, int carportLaengde, int carportBredde, int carportFarve,
                                int carportTraeType, int tagMateriale, int tagHaeldning, int redskabsrumsbredde,
                                int redskabsrumslaengde, int redskabsrumBeklaedningstype, int redskabsrumGulv, double pris) throws Fejl_haendtering {

        if(findEmail(email).contains(email)){
            int kundeid = findKundeId(email);
            Carport_Mapper.forespoergselList(carportLaengde, carportBredde, carportFarve,
                    carportTraeType,  tagMateriale,  tagHaeldning,  redskabsrumsbredde,
                    redskabsrumslaengde,  redskabsrumBeklaedningstype, redskabsrumGulv, kundeid, pris);

        } else {


            try {
                Connection con = Connector.connection();

                String SQL = "INSERT INTO `carportdb`.`kunde` (`navn`, `adresse`," +
                        " `postnummer`, `by`, `tlf`, `email`)" +
                        " VALUES (?, ?, ?, ?, ?, ?);";

                PreparedStatement ps = con.prepareStatement(SQL);

                ps.setString(1, navn);
                ps.setString(2, adresse);
                ps.setInt(3, postNummer);
                ps.setString(4, by);
                ps.setInt(5, tlf);
                ps.setString(6, email);
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

    public static int findKundeId (String email)  throws Fejl_haendtering {
        int kundeid = 0;
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();
            String SQL = "SELECT kundeId FROM carportdb.kunde where email = ?;";
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



    public static List findEmail (String email)  throws Fejl_haendtering {
        if(kundeEmails == null) {
            kundeEmails = new ArrayList<>();
        }

        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();
            String SQL = "SELECT email FROM carportdb.kunde;";
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
