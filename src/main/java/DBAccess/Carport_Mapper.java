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


    public static void forespoergselList(int carportLaengde, int carportBredde, int carportFarve,
                                         int carportTraeType, int tagMateriale, int tagHaeldning, int redskabsrumsbredde,
                                         int redskabsrumslaengde, int redskabsrumBeklaedningstype, int redskabsrumGulv, int kundeid, double pris) throws Fejl_haendtering {



    try {
        Connection con = Connector.connection();

        String SQL = "INSERT INTO `carportdb`.`forespoergsel` (`carportlaengde`, `carportbredde`, `carportfarve`," +
                " `carporttraetype`, `tagmateriale`, `taghaeldning`, `redskabsrumbredde`," +
                " `redskabsrumlaengde`, `redskabsrumbeklaedningstype`, `redskabsrumgulv`, `kundeID`, `pris`)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

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
        ps.setInt(11, kundeid);
        ps.setDouble(12, pris);


        ps.executeUpdate();


    } catch (SQLException | ClassNotFoundException ex) {
      ex.printStackTrace();
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
