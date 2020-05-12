package DBAccess;


import FunctionLayer.Fejl_haendtering;
import FunctionLayer.Objekter.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Her køres alt kode der har noget at gøre med database, så når vi skal hente fra database eller indsætte fx.

 @author Nicolas
 */
public class Carport_Mapper {

    protected static Map<Integer, Bredde> dropdown_Bredde_List = new HashMap<>();
    protected static Map<Integer, Laengde> dropdown_Laengde_List = new HashMap<>();
    protected static Map<Integer, Farve> dropdown_Farve_List = new HashMap<>();
    protected static Map<Integer, Traetype> dropdown_Traetype_List = new HashMap<>();
    protected static Map<Integer, Tag> dropdown_Haeldning_List = new HashMap<>();
    protected static Map<Integer, Tag> dropdown_Tagmatriale_List = new HashMap<>();
    protected static Map<Integer, Gulv> dropdown_Gulv_List = new HashMap<>();
    //private static List<Kunde> dropdown_Kunde_List = new ArrayList<>();


    public static Map<Integer, Bredde> get_Dropdown_Bredde_List() {
        return dropdown_Bredde_List;
    }

    public static Map<Integer, Laengde> get_Dropdown_Laengde_List() {
        return dropdown_Laengde_List;
    }

    public static Map<Integer, Farve> get_Dropdown_Farve_List() {
        return dropdown_Farve_List;
    }

    public static Map<Integer, Traetype> get_Dropdown_Traetype_List() {
        return dropdown_Traetype_List;
    }

    public static Map<Integer, Tag> getDropdown_Haeldning_List() {
        return dropdown_Haeldning_List;
    }

    public static Map<Integer, Tag> getDropdown_Tagmatriale_List() {
        return dropdown_Tagmatriale_List;
    }

    public static Map<Integer, Gulv> getDropdown_Gulv_List() {
        return dropdown_Gulv_List;
    }

    public static void forespoergsel_List(int carport_Laengde, int carport_Bredde, int carport_Farve,
                                          int carport_Trae_Type, int tag_Materiale, int tag_Haeldning, int redskabsrums_Bredde,
                                          int redskabsrums_Laengde, int redskabsrum_Beklaedningstype, int redskabsrum_Gulv,
                                          String navn, String adresse, int postNummer, String by, int tlf,
                                          String email) throws Fejl_haendtering {

    try {
        Connection con = Connector.connection();

        String SQL = "INSERT INTO `carportdb`.`forespoergsel` (`carportlaengde`, `carportbredde`, `carportfarve`," +
                " `carporttraetype`, `tagmateriale`, `taghaeldning`, `redskabsrumbredde`," +
                " `redskabsrumlaengde`, `redskabsrumbeklaedningstype`, `redskabsrumgulv`, `kundenavn`, `kundeadresse`," +
                " `kundepostnummer`, `kundeby`, `kundetlf`, `kundeemail`)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement ps = con.prepareStatement(SQL);

        ps.setInt(1, carport_Laengde);
        ps.setInt(2, carport_Bredde);
        ps.setInt(3, carport_Farve);
        ps.setInt(4, carport_Trae_Type);
        ps.setInt(5, tag_Materiale);
        ps.setInt(6, tag_Haeldning);
        ps.setInt(7, redskabsrums_Bredde);
        ps.setInt(8, redskabsrums_Laengde);
        ps.setInt(9, redskabsrum_Beklaedningstype);
        ps.setInt(10, redskabsrum_Gulv);
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
    public static void forespoergsel_List_Uden_Redskabrum(int carport_Laengde, int carport_Bredde, int carport_Farve,
                                                          int carport_Trae_Type, int tag_Materiale, int tag_Haeldning,
                                                          String navn, String adresse, int postNummer, String by, int tlf,
                                                          String email) throws Fejl_haendtering {

        try {
            Connection con = Connector.connection();

            String SQL = "INSERT INTO `carportdb`.`forespoergsel` (`carportlaengde`, `carportbredde`, `carportfarve`," +
                    " `carporttraetype`, `tagmateriale`, `taghaeldning`, `kundenavn`, `kundeadresse`," +
                    " `kundepostnummer`, `kundeby`, `kundetlf`, `kundeemail`)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setInt(1, carport_Laengde);
            ps.setInt(2, carport_Bredde);
            ps.setInt(3, carport_Farve);
            ps.setInt(4, carport_Trae_Type);
            ps.setInt(5, tag_Materiale);
            ps.setInt(6, tag_Haeldning);
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

    public static void dropdown_Haeldning()  throws Fejl_haendtering {
            if(dropdown_Haeldning_List == null) {
                dropdown_Haeldning_List = new HashMap<>();
                }
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();
            String SQL = "SELECT * FROM carportdb.haeldning;";
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {

                int tag_Haeldning = rs.getInt("haeldninger");
                int id_Tag_Haeldning = rs.getInt("idhaeldning");
                dropdown_Haeldning_List.put(id_Tag_Haeldning, new Tag(tag_Haeldning, id_Tag_Haeldning));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new Fejl_haendtering(ex.getMessage());
        }

    }

    public static void dropdown_Gulv()  throws Fejl_haendtering {
        if(dropdown_Gulv_List == null) {
            dropdown_Gulv_List = new HashMap<>();
        }
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();
            String SQL = "SELECT * FROM carportdb.gulv;";
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {

                int idGulv = rs.getInt("idGulv");
                String gulv = rs.getString("gulv");
                dropdown_Gulv_List.put(idGulv, new Gulv(idGulv, gulv));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new Fejl_haendtering(ex.getMessage());
        }

    }
    public static void dropdown_Tagmatriale()  throws Fejl_haendtering {
        if(dropdown_Tagmatriale_List == null) {
            dropdown_Tagmatriale_List = new HashMap<>();
        }
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();
            String SQL = "SELECT * FROM carportdb.tagmateriale;";
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {

                int id_Matriale = rs.getInt("idtagmateriale");
                String typer = rs.getString("typer");
                dropdown_Tagmatriale_List.put(id_Matriale, new Tag(typer, id_Matriale));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new Fejl_haendtering(ex.getMessage());
        }

    }

public static void dropdown_Bredde() throws Fejl_haendtering {
    if(dropdown_Bredde_List == null) {
        dropdown_Bredde_List = new HashMap<>();
    }
    try {
        Connection con = Connector.connection();
        Statement st2 = con.createStatement();

        String SQL3 = "Select * from carportdb.bredder;";
        ResultSet rs3 = st2.executeQuery(SQL3);

        while (rs3.next()) {

            int carport_Bredde = rs3.getInt("bredde");
            int carport_Bredde_id = rs3.getInt("idbredder");
            dropdown_Bredde_List.put(carport_Bredde_id, new Bredde(carport_Bredde,
                    carport_Bredde_id));
        }

    } catch (SQLException | ClassNotFoundException ex) {
        throw new Fejl_haendtering(ex.getMessage());
    }


}

    public static void dropdown_Laengde() throws Fejl_haendtering {
        if(dropdown_Laengde_List == null) {
            dropdown_Laengde_List = new HashMap<>();
        }
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();

            String SQL = "select * from carportdb.laengder;";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                int carport_Laengde = rs.getInt("laengde");
                int carport_Laengde_id = rs.getInt("idlaengder");
                dropdown_Laengde_List.put(carport_Laengde_id, new Laengde(carport_Laengde_id,carport_Laengde));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new Fejl_haendtering(ex.getMessage());
        }


    }

    public static void dropdown_Farve() throws Fejl_haendtering {
        if(dropdown_Farve_List == null) {
            dropdown_Farve_List = new HashMap<>();
        }
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();

            String SQL = "select * from carportdb.farver;";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                int carport_Farve_id = rs.getInt("idfarver");
                String carport_Farve = rs.getString("farve");
                dropdown_Farve_List.put(carport_Farve_id, new Farve(carport_Farve, carport_Farve_id));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new Fejl_haendtering(ex.getMessage());
        }


    }
    public static void dropdown_Trae_type() throws Fejl_haendtering {
        if(dropdown_Traetype_List == null) {
            dropdown_Traetype_List = new HashMap<>();
        }
        try {
            Connection con = Connector.connection();
            Statement st = con.createStatement();

            String SQL = "select * from carportdb.traetyper;";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                int carport_Trae_Type_id = rs.getInt("idtraetyper");
                String carport_Trae_Type = rs.getString("traetype");
                dropdown_Traetype_List.put(carport_Trae_Type_id, new Traetype(carport_Trae_Type_id, carport_Trae_Type));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new Fejl_haendtering(ex.getMessage());
        }

    }
}
