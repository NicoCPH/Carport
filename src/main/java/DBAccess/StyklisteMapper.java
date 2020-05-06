package DBAccess;

import FunctionLayer.ExceptionHandler;
import FunctionLayer.Objekter.Materiale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StyklisteMapper {

    protected static Map<String, List<Materiale>> materialeMap = new HashMap<>();

    public static Map<String, List<Materiale>> getMaterialeMap() {
        return materialeMap;
    }

    public static Map<String, List<Materiale>> findStykListe() throws ExceptionHandler {

        List<Materiale> alleMaterialer = stykListe();

        List<Materiale> RemListe = new ArrayList<>();
        List<Materiale> StolpeListe = new ArrayList<>();
        List<Materiale> SpaerListe = new ArrayList<>();
        List<Materiale> TagListe = new ArrayList<>();

        if(materialeMap == null) {
            materialeMap = new HashMap<>();
        }

        alleMaterialer.forEach(materiale -> {
            switch(materiale.getNavn()){
                case "Rem":
                    RemListe.add(materiale);
                    break;
                case "Spær":
                    SpaerListe.add(materiale);
                    break;
                case "Stolpe":
                    StolpeListe.add(materiale);
                    break;
                case "Tag":
                    TagListe.add(materiale);
                    break;
                default:
                    break;
            }
        });

        materialeMap.put("Rem",RemListe);
        materialeMap.put("Spær", SpaerListe);
        materialeMap.put("Stolpe", StolpeListe);
        materialeMap.put("Tag", TagListe);

        return materialeMap;
    }

    public static List<Materiale> stykListe() throws ExceptionHandler {

        List<Materiale> alleMaterialer = new ArrayList<>();

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

                alleMaterialer.add(m);
            }


        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return alleMaterialer;
    }

}
