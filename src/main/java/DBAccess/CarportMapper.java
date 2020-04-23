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

public static void forespoergselList(int tagType, int tagFarve, int tagHaeldning, int redskabsrumsbredde,
                                     int redskabsrumslaengde, int redskabsrumBeklaedningstype, int redskabsrumGulv,
                                     String navn, String adresse, int postNummer, String by, int tlf,
                                     String email, int carportLaengde, int carportBredde, int carportFarve,
                                     int traeType) throws ExceptionHandler {

    try {
        Connection con = Connector.connection();

        String SQLTag = "INSERT INTO `carportdb`.`tag` (`type`, `farve`, `hældning`) VALUES (?, ?, ?);";
        String SQLRedskabsrum = "INSERT INTO `carportdb`.`redskabsrum` (`bredde`, `længde`, `beklædningstype`, `gulv`) VALUES (?, ?, ?, ?);";
        String SQLKunde = "INSERT INTO `carportdb`.`kunde` (`navn`, `adresse`, `postnummer`, `by`, `tlf`, `email`) VALUES (?, ?, ?, ?, ?, ?);";
        String SQLCarport = "INSERT INTO `carportdb`.`carport` (`laengde`, `bredde`, `farve`, `traetype`) VALUES (?, ?, ?, ?);";

        PreparedStatement psT = con.prepareStatement(SQLTag);
        PreparedStatement psR = con.prepareStatement(SQLRedskabsrum);
        PreparedStatement psK = con.prepareStatement(SQLKunde);
        PreparedStatement psC = con.prepareStatement(SQLCarport);

        psT.setInt(1, tagType);
        psT.setInt(2, tagFarve);
        psT.setInt(3, tagHaeldning);
        psT.executeUpdate();

        psR.setInt(1, redskabsrumsbredde);
        psR.setInt(2, redskabsrumslaengde);
        psR.setInt(3, redskabsrumBeklaedningstype);
        psR.setInt(4, redskabsrumGulv);
        psR.executeUpdate();

        psK.setString(1, navn);
        psK.setString(2, adresse);
        psK.setInt(3, postNummer);
        psK.setString(4, by);
        psK.setInt(5, tlf);
        psK.setString(6, email);
        psK.executeUpdate();

        psC.setInt(1, carportLaengde);
        psC.setInt(2, carportBredde);
        psC.setInt(3, carportFarve);
        psC.setInt(4, traeType);
        psC.executeUpdate();

        // Her skal laves noget som tager id'erne fra tag. redskabsrum og kunde og herefter inserter de id'er ind i carport !!

    } catch (SQLException | ClassNotFoundException ex) {
        throw new ExceptionHandler(ex.getMessage());
    }

}
}
