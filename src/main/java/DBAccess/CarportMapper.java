package DBAccess;


import FunctionLayer.Carport;
import FunctionLayer.ExceptionHandler;
import FunctionLayer.Redskabsrum;
import FunctionLayer.Tag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Her køres alt kode der har noget at gøre med database, så når vi skal hente fra database eller indsætte fx.

 @author Nicolas
 */
public class CarportMapper {

    private static List<Carport> dropdownBreddeList = new ArrayList<Carport>();
    private static List<Tag> dropdownLaengdeList = new ArrayList<>();
    private static List<Carport> dropdownFarveList = new ArrayList<>();
    private static List<Carport> dropdownTraetypeList = new ArrayList<>();
    private static List<Tag> dropdownHaeldningList = new ArrayList<>();
    private static List<Tag> dropdown = new ArrayList<>();
    //private static List<Kunde> dropdownKundeList = new ArrayList<>();


    public static List<Carport> getDropdownBreddeList() {
        return dropdownBreddeList;
    }

    public static List<Tag> getDropdownLaengdeList() {
        return dropdownLaengdeList;
    }

    public static List<Carport> getDropdownFarveList() {
        return dropdownFarveList;
    }

    public static List<Carport> getDropdownTraetypeList() {
        return dropdownTraetypeList;
    }

    public static List<Tag> getDropdownHaeldningList() {
        return dropdownHaeldningList;
    }

    public static void forespoergselList(int carportLaengde, int carportBredde, int carportFarve,
                                         int carportTraeType, int tagMateriale, int tagFarve, int tagHaeldning, int redskabsrumsbredde,
                                         int redskabsrumslaengde, int redskabsrumBeklaedningstype, int redskabsrumGulv,
                                         String navn, String adresse, int postNummer, String by, int tlf,
                                         String email) throws ExceptionHandler {

    try {
        Connection con = Connector.connection();

        String SQL = "INSERT INTO `carportdb`.`forespoergsel` (`carportlaengde`, `carportbredde`, `carportfarve`," +
                " `carporttraetype`, `tagmateriale`, `tagfarve`, `taghaeldning`, `redskabsrumbredde`," +
                " `redskabsrumlaengde`, `redskabsrumbeklaedningstype`, `redskabsrumgulv`, `kundenavn`, `kundeadresse`," +
                " `kundepostnummer`, `kundeby`, `kundetlf`, `kundeemail`)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement ps = con.prepareStatement(SQL);

        ps.setInt(1, carportLaengde);
        ps.setInt(2, carportBredde);
        ps.setInt(3, carportFarve);
        ps.setInt(4, carportTraeType);
        ps.setInt(5, tagMateriale);
        ps.setInt(6, tagFarve);
        ps.setInt(7, tagHaeldning);
        ps.setInt(8, redskabsrumsbredde);
        ps.setInt(9, redskabsrumslaengde);
        ps.setInt(10, redskabsrumBeklaedningstype);
        ps.setInt(11, redskabsrumGulv);
        ps.setString(12, navn);
        ps.setString(13, adresse);
        ps.setInt(14, postNummer);
        ps.setString(15, by);
        ps.setInt(16, tlf);
        ps.setString(17, email);
        ps.executeUpdate();


    } catch (SQLException | ClassNotFoundException ex) {
        throw new ExceptionHandler(ex.getMessage());
    }

}

    public static void dropdownTag ()  throws ExceptionHandler{
            if(dropdownHaeldningList == null) {
                dropdownHaeldningList = new ArrayList<>();
                }
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();
            String SQL = "SELECT * FROM carportdb.haeldning;";
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                int taghaeldning = rs.getInt("haeldninger");
                int idtaghaeldning = rs.getInt("idhaeldning");
                dropdownHaeldningList.add(new Tag(taghaeldning, idtaghaeldning));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ExceptionHandler(ex.getMessage());
        }

    }


public static void dropdownBredde() throws ExceptionHandler {
    if(dropdownBreddeList == null) {
        dropdownBreddeList = new ArrayList<Carport>();
    }
    try {
        Connection con = Connector.connection();
        Statement st2 = con.createStatement();

        String SQL3 = "Select * from carportdb.bredder;";
        ResultSet rs3 = st2.executeQuery(SQL3);

        while (rs3.next()) {

            int carportBredde = rs3.getInt("bredde");
            int carportBreddeid = rs3.getInt("idbredder");
            dropdownBreddeList.add(new Carport(carportBredde,
                    carportBreddeid));
        }

    } catch (SQLException | ClassNotFoundException ex) {
        throw new ExceptionHandler(ex.getMessage());
    }


}

    public static void dropdownLaengde() throws ExceptionHandler {
        if(dropdownLaengdeList == null) {
            dropdownLaengdeList = new ArrayList<Tag>();
        }
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();

            String SQL = "select * from carportdb.laengder;";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                int carportLaengde = rs.getInt("laengde");
                int carportLaengdeid = rs.getInt("idlaengder");
                dropdownLaengdeList.add(new Tag(carportLaengde, carportLaengdeid));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ExceptionHandler(ex.getMessage());
        }


    }

    public static void dropdownFarve() throws ExceptionHandler {
        if(dropdownFarveList == null) {
            dropdownFarveList = new ArrayList<Carport>();
        }
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();

            String SQL = "select * from carportdb.farver;";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                int carportFarveid = rs.getInt("idfarver");
                String carportFarve = rs.getString("farve");
                dropdownFarveList.add(new Carport(carportFarve, carportFarveid));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ExceptionHandler(ex.getMessage());
        }


    }
    public static void dropdownTraetype() throws ExceptionHandler {
        if(dropdownTraetypeList == null) {
            dropdownTraetypeList = new ArrayList<Carport>();
        }
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();

            String SQL = "select * from carportdb.traetyper;";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                int carporttraeTypeid = rs.getInt("idtraetyper");
                String carporttraeType = rs.getString("traetype");
                dropdownTraetypeList.add(new Carport(carporttraeType, carporttraeTypeid));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ExceptionHandler(ex.getMessage());
        }


    }
}
