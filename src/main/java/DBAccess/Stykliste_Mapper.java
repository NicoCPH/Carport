package DBAccess;

import FunctionLayer.Fejl_haendtering;
import FunctionLayer.Objekter.Materiale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stykliste_Mapper {


    public static List<Materiale> stykListe() throws Fejl_haendtering {

        List<Materiale> alle_Materialer = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT beskrivelse, længde, navn FROM `matrialer`;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String beskrivelse = rs.getString("beskrivelse");
                int laengde = rs.getInt("længde");
                String navn = rs.getString("navn");
                Materiale m = new Materiale(beskrivelse, navn, laengde);

                alle_Materialer.add(m);
            }


        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return alle_Materialer;
    }

}
