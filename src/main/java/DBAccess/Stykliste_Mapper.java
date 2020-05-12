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

    protected static Map<String, List<Materiale>> materiale_Map = new HashMap<>();

    public static Map<String, List<Materiale>> getMateriale_Map() {
        return materiale_Map;
    }

    public static Map<String, List<Materiale>> find_StykListe() throws Fejl_haendtering {

        List<Materiale> alle_Materialer = stykListe();

        List<Materiale> Rem_Liste = new ArrayList<>();
        List<Materiale> Stolpe_Liste = new ArrayList<>();
        List<Materiale> Spaer_Liste = new ArrayList<>();
        List<Materiale> Tag_Liste = new ArrayList<>();

        if(materiale_Map == null) {
            materiale_Map = new HashMap<>();
        }

        alle_Materialer.forEach(materiale -> {
            switch(materiale.getNavn()){
                case "Rem":
                    Rem_Liste.add(materiale);
                    break;
                case "Spær":
                    Spaer_Liste.add(materiale);
                    break;
                case "Stolpe":
                    Stolpe_Liste.add(materiale);
                    break;
                case "Tag":
                    Tag_Liste.add(materiale);
                    break;
                default:
                    break;
            }
        });

        materiale_Map.put("Rem",Rem_Liste);
        materiale_Map.put("Spær", Spaer_Liste);
        materiale_Map.put("Stolpe", Stolpe_Liste);
        materiale_Map.put("Tag", Tag_Liste);

        return materiale_Map;
    }

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
