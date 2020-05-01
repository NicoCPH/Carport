package DBAccess;


import FunctionLayer.*;
import FunctionLayer.Objekter.*;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Her køres alt kode der har noget at gøre med database, så når vi skal hente fra database eller indsætte fx.

 @author Nicolas
 */
public class CarportMapper {

    private static Map<Integer, Bredde> dropdownBreddeList = new HashMap<>();
    private static Map<Integer, Laengde> dropdownLaengdeList = new HashMap<>();
    private static Map<Integer, Farve> dropdownFarveList = new HashMap<>();
    private static Map<Integer, Traetype> dropdownTraetypeList = new HashMap<>();
    private static Map<Integer, Tag> dropdownHaeldningList = new HashMap<>();
    private static Map<Integer, Tag> dropdownTagmatrialeList = new HashMap<>();
    private static Map<Integer, Gulv> dropdownGulvList = new HashMap<>();
    //private static List<Kunde> dropdownKundeList = new ArrayList<>();


    public static Map<Integer, Bredde> getDropdownBreddeList() {
        return dropdownBreddeList;
    }

    public static Map<Integer, Laengde> getDropdownLaengdeList() {
        return dropdownLaengdeList;
    }

    public static Map<Integer, Farve> getDropdownFarveList() {
        return dropdownFarveList;
    }

    public static Map<Integer, Traetype> getDropdownTraetypeList() {
        return dropdownTraetypeList;
    }

    public static Map<Integer, Tag> getDropdownHaeldningList() {
        return dropdownHaeldningList;
    }

    public static Map<Integer, Tag> getDropdownTagmatrialeList() {
        return dropdownTagmatrialeList;
    }

    public static Map<Integer, Gulv> getDropdownGulvList() {
        return dropdownGulvList;
    }

    public static void forespoergselList(int carportLaengde, int carportBredde, int carportFarve,
                                         int carportTraeType, int tagMateriale, int tagHaeldning, int redskabsrumsbredde,
                                         int redskabsrumslaengde, int redskabsrumBeklaedningstype, int redskabsrumGulv,
                                         String navn, String adresse, int postNummer, String by, int tlf,
                                         String email) throws ExceptionHandler {

    try {
        Connection con = Connector.connection();

        String SQL = "INSERT INTO `carportdb`.`forespoergsel` (`carportlaengde`, `carportbredde`, `carportfarve`," +
                " `carporttraetype`, `tagmateriale`, `taghaeldning`, `redskabsrumbredde`," +
                " `redskabsrumlaengde`, `redskabsrumbeklaedningstype`, `redskabsrumgulv`, `kundenavn`, `kundeadresse`," +
                " `kundepostnummer`, `kundeby`, `kundetlf`, `kundeemail`)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement ps = con.prepareStatement(SQL);

        ps.setInt(1, carportLaengde);
        ps.setInt(2, carportBredde);
        ps.setInt(3, carportFarve);
        ps.setInt(4, carportTraeType);
        ps.setInt(5, tagMateriale);
        ps.setInt(6, tagHaeldning);
        ps.setInt(7, redskabsrumsbredde);
        ps.setInt(8, redskabsrumslaengde);
        ps.setInt(9, redskabsrumBeklaedningstype);
        ps.setInt(10, redskabsrumGulv);
        ps.setString(11, navn);
        ps.setString(12, adresse);
        ps.setInt(13, postNummer);
        ps.setString(14, by);
        ps.setInt(15, tlf);
        ps.setString(16, email);
        ps.executeUpdate();


    } catch (SQLException | ClassNotFoundException ex) {
      ex.getMessage();
    }

}
    public static void forespoergselListUdenRedskabrum(int carportLaengde, int carportBredde, int carportFarve,
                                         int carportTraeType, int tagMateriale, int tagHaeldning,
                                         String navn, String adresse, int postNummer, String by, int tlf,
                                         String email) throws ExceptionHandler {

        try {
            Connection con = Connector.connection();

            String SQL = "INSERT INTO `carportdb`.`forespoergsel` (`carportlaengde`, `carportbredde`, `carportfarve`," +
                    " `carporttraetype`, `tagmateriale`, `taghaeldning`, `kundenavn`, `kundeadresse`," +
                    " `kundepostnummer`, `kundeby`, `kundetlf`, `kundeemail`)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setInt(1, carportLaengde);
            ps.setInt(2, carportBredde);
            ps.setInt(3, carportFarve);
            ps.setInt(4, carportTraeType);
            ps.setInt(5, tagMateriale);
            ps.setInt(6, tagHaeldning);
            ps.setString(7, navn);
            ps.setString(8, adresse);
            ps.setInt(9, postNummer);
            ps.setString(10, by);
            ps.setInt(11, tlf);
            ps.setString(12, email);
            ps.executeUpdate();


        } catch (SQLException | ClassNotFoundException ex) {
            ex.getMessage();
        }

    }

    public static void dropdownHaeldning ()  throws ExceptionHandler{
            if(dropdownHaeldningList == null) {
                dropdownHaeldningList = new HashMap<>();
                }
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();
            String SQL = "SELECT * FROM carportdb.haeldning;";
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                int taghaeldning = rs.getInt("haeldninger");
                int idtaghaeldning = rs.getInt("idhaeldning");
                dropdownHaeldningList.put(idtaghaeldning, new Tag(taghaeldning, idtaghaeldning));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ExceptionHandler(ex.getMessage());
        }

    }

    public static void dropdownGulv ()  throws ExceptionHandler{
        if(dropdownGulvList == null) {
            dropdownGulvList = new HashMap<>();
        }
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();
            String SQL = "SELECT * FROM carportdb.gulv;";
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                int idGulv = rs.getInt("idGulv");
                String gulv = rs.getString("gulv");
                dropdownGulvList.put(idGulv, new Gulv(idGulv, gulv));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ExceptionHandler(ex.getMessage());
        }

    }
    public static void dropdownTagmatriale()  throws ExceptionHandler{
        if(dropdownTagmatrialeList == null) {
            dropdownTagmatrialeList = new HashMap<>();
        }
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();
            String SQL = "SELECT * FROM carportdb.tagmateriale;";
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                int idmatriale = rs.getInt("idtagmateriale");
                String typer = rs.getString("typer");
                dropdownTagmatrialeList.put(idmatriale, new Tag(typer, idmatriale));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ExceptionHandler(ex.getMessage());
        }

    }

public static void dropdownBredde() throws ExceptionHandler {
    if(dropdownBreddeList == null) {
        dropdownBreddeList = new HashMap<>();
    }
    try {
        Connection con = Connector.connection();
        Statement st2 = con.createStatement();

        String SQL3 = "Select * from carportdb.bredder;";
        ResultSet rs3 = st2.executeQuery(SQL3);

        while (rs3.next()) {

            int carportBredde = rs3.getInt("bredde");
            int carportBreddeid = rs3.getInt("idbredder");
            dropdownBreddeList.put(carportBreddeid, new Bredde(carportBredde,
                    carportBreddeid));
        }

    } catch (SQLException | ClassNotFoundException ex) {
        throw new ExceptionHandler(ex.getMessage());
    }


}

    public static void dropdownLaengde() throws ExceptionHandler {
        if(dropdownLaengdeList == null) {
            dropdownLaengdeList = new HashMap<>();
        }
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();

            String SQL = "select * from carportdb.laengder;";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                int carportLaengde = rs.getInt("laengde");
                int carportLaengdeid = rs.getInt("idlaengder");
                dropdownLaengdeList.put(carportLaengdeid, new Laengde(carportLaengdeid,carportLaengde));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ExceptionHandler(ex.getMessage());
        }


    }

    public static void dropdownFarve() throws ExceptionHandler {
        if(dropdownFarveList == null) {
            dropdownFarveList = new HashMap<>();
        }
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();

            String SQL = "select * from carportdb.farver;";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                int carportFarveid = rs.getInt("idfarver");
                String carportFarve = rs.getString("farve");
                dropdownFarveList.put(carportFarveid, new Farve(carportFarve, carportFarveid));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ExceptionHandler(ex.getMessage());
        }


    }
    public static void dropdownTraetype() throws ExceptionHandler {
        if(dropdownTraetypeList == null) {
            dropdownTraetypeList = new HashMap<>();
        }
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();

            String SQL = "select * from carportdb.traetyper;";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                int carporttraeTypeid = rs.getInt("idtraetyper");
                String carporttraeType = rs.getString("traetype");
                dropdownTraetypeList.put(carporttraeTypeid, new Traetype(carporttraeTypeid, carporttraeType));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ExceptionHandler(ex.getMessage());
        }


    }
}
