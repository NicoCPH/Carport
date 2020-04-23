package DBAccess;


import FunctionLayer.ExceptionHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Her køres alt kode der har noget at gøre med database, så når vi skal hente fra database eller indsætte fx.

 @author Nicolas
 */
public class CarportMapper {

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
}
