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

    private static List<Tag> dropdownTagList = new ArrayList<>();
    private static List<Redskabsrum> dropdownRedskabsrumList = new ArrayList<>();
    private static List<Carport> dropdownCarportList = new ArrayList<>();
    //private static List<Kunde> dropdownKundeList = new ArrayList<>();

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

    public static List<Tag> dropdownTag ()  throws ExceptionHandler{
            if(dropdownTagList == null) {
                dropdownTagList = new ArrayList<>();
                }
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();
            String SQL = "SELECT `tagmateriale`, `tagfarve`, `taghaeldning` FROM `caportdb`.`forespoergsel`;";
            String SQL2 = "SELECT `idtagmateriale` FROM `caportdb`.`tagmateriale`;";
            String SQL3 = "SELECT `idfarver` FROM `caportdb`.`farver`;";
            String SQL4 = "SELECT `idhaeldning` FROM `caportdb`.`haeldning`;";
            ResultSet rs = st.executeQuery(SQL);
            ResultSet rs2 = st.executeQuery(SQL2);
            ResultSet rs3 = st.executeQuery(SQL3);
            ResultSet rs4 = st.executeQuery(SQL4);
            while (rs.next() && rs2.next() && rs3.next() && rs4.next()) {
                String tagmateriale = rs.getString("tagmateriale");
                String tagfarve = rs.getString("tagfarve");
                int taghaeldning = rs.getInt("taghaeldning");
                int tagmaterialeid = rs2.getInt("idtype");
                int farveid = rs3.getInt("idfarver");
                int haeldningid = rs4.getInt("idhaeldning");
                dropdownTagList.add(new Tag(tagmateriale, tagfarve, taghaeldning, tagmaterialeid, farveid, haeldningid));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ExceptionHandler(ex.getMessage());
        }

        return dropdownTagList;
    }

    public static List<Redskabsrum> dropdownRedskabsrum ()  throws ExceptionHandler{
        if(dropdownRedskabsrumList == null) {
            dropdownRedskabsrumList = new ArrayList<>();
        }


        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();
            String SQL = "SELECT `redskabsrumlaengde`, `redskabsrumbredde`, `redskabsrumbeklaedningstype`, `redskabsrumgulv` FROM `caportdb`.`forespoergsel`;";
            String SQL2 = "SELECT `idbredder` FROM `carportdb`.`bredder`;";
            String SQL3 = "SELECT `idlaengder` FROM `carportdb`.`laengder`;";
            String SQL4 = "SELECT `idtraetyper` FROM `carportdb`.`traetyper`;";
            String SQL5 = "SELECT `idtraetyper` FROM `carportdb`.`traetyper`;";
            ResultSet rs = st.executeQuery(SQL);
            ResultSet rs2 = st.executeQuery(SQL2);
            ResultSet rs3 = st.executeQuery(SQL3);
            ResultSet rs4 = st.executeQuery(SQL4);
            ResultSet rs5 = st.executeQuery(SQL5);
            while (rs.next() && rs2.next()  && rs3.next()  && rs4.next()  && rs5.next()) {
                int redskabsrumlaengde = rs.getInt("redskabsrumlaengde");
                int redskabsrumbredde = rs.getInt("redskabsrum");
                String beklaedningstype = rs.getString("redskabsrumbeklaedningstype");
                String redskabsrumgulv = rs.getString("redskabsrumgulv");
                int redskabsrumLaengdeid = rs2.getInt("idlaengder");
                int reskabsrumsBreddeid= rs3.getInt("idbredder");
                int beklaedningstypeid = rs4.getInt("idtraetyper");
                int redskabsrumgulvid = rs5.getInt("idtraetyper");
                dropdownRedskabsrumList.add(new Redskabsrum(redskabsrumlaengde, redskabsrumbredde, beklaedningstype,
                        redskabsrumgulv, redskabsrumLaengdeid, reskabsrumsBreddeid, beklaedningstypeid, redskabsrumgulvid));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ExceptionHandler(ex.getMessage());
        }

        return dropdownRedskabsrumList;
    }

    public static List<Carport> dropdownCarport ()  throws ExceptionHandler{
        if(dropdownCarportList == null) {
            dropdownCarportList = new ArrayList<>();
        }
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();
            String SQL = "SELECT `carportlaengde`, `carportbredde`, `carportfarve`, `carporttraetype` FROM `caportdb`.`forespoergsel`;";
            String SQL2 = "SELECT `idlaengder` FROM `caportdb`.`laengder`;";
            String SQL3 = "SELECT `idbredder` FROM `caportdb`.`bredder`;";
            String SQL4 = "SELECT `idfarver` FROM `caportdb`.`farver`;";
            String SQL5 = "SELECT `idtraetyper` FROM `carportdb`.`traetyper`;";
            ResultSet rs = st.executeQuery(SQL);
            ResultSet rs2 = st.executeQuery(SQL2);
            ResultSet rs3 = st.executeQuery(SQL3);
            ResultSet rs4 = st.executeQuery(SQL4);
            ResultSet rs5 = st.executeQuery(SQL5);
            while (rs.next() && rs2.next() && rs3.next() && rs4.next() && rs5.next()) {
                int carportBredde = rs.getInt("carportlaengde");
                int carportLaengde = rs.getInt("carportbredde");
                String carportFarve = rs.getString("carportfarve");
                String carporttraeType = rs.getString("carporttraetype");
                int carportLaengdeid = rs2.getInt("idlaengder");
                int carportBreddeid = rs3.getInt("idbredder");
                String carportFarveid = rs4.getString("idfarver");
                String carporttraeTypeid = rs5.getString("idtraetyper");
                dropdownCarportList.add(new Carport(carportBredde, carportLaengde, carportFarve, carporttraeType,
                        carportBreddeid, carportLaengdeid, carportFarveid, carporttraeTypeid));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ExceptionHandler(ex.getMessage());
        }

        return dropdownCarportList;
    }

}
