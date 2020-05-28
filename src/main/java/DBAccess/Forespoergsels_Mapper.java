package DBAccess;

import FunctionLayer.Fejl_haendtering;
import FunctionLayer.Objekter.Forespoergseler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Forespoergsels_Mapper {

    private static List<Forespoergseler> MR = new ArrayList<>();

    private static final String Update_Pris = "UPDATE forespoergsel\n" +
            "SET pris = ?\n" +
            "WHERE idforespoergsel = ?;";
    private static final String Select_All_From_Forespoegsel = "SELECT  ku.postnummer, ku.kundeId,  ku.tlf, idforespoergsel, CL.laengde, CLB.bredde, farve, TC.traetype, typer, haeldninger, RL.laengde," +
            "RLB.bredde, gulv, TC2.traetype, ku.navn, ku.email, pris FROM forespoergsel p \n" +
            "inner join laengder CL on carportlaengde = CL.idlaengder\n" +
            "inner join laengder RL on redskabsrumlaengde = RL.idlaengder\n" +
            "inner join bredder CLB on carportbredde = CLB.idbredder\n" +
            "inner join bredder RLB on redskabsrumbredde = RLB.idbredder\n" +
            "inner join farver on carportfarve = idfarver\n" +
            "inner join traetyper TC on carporttraetype = TC.idtraetyper\n" +
            "inner join tagmateriale on tagmateriale = idtagmateriale\n" +
            "inner join haeldning on taghaeldning = idhaeldning\n" +
            "inner join gulv on redskabsrumgulv = idGulv\n" +
            "inner join traetyper TC2 on redskabsrumbeklaedningstype = TC2.idtraetyper\n" +
            "inner join kunde ku on p.kundeID = ku.kundeID\n" +
            "where ku.email = ?;";


    /**
     *Metoden henter alle forespørgsler fra databasen og ligger ned i et arraylist af forespørgsles objekter.
     * Derudover er der en if statement der tager sig af om der er et redskabsrum eller ej.
     *
     *
     * @param email Kundens email
     * @return List<Forespoergseler>
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws NullPointerException
     * @throws IndexOutOfBoundsException
     */
    public static List<Forespoergseler> Alle_Forespoerelser(String email) throws Fejl_haendtering {
        if (MR == null) {
            MR = new ArrayList<>();
        }
        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(Select_All_From_Forespoegsel);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            int i = -1;
            while (rs.next()) {
                i++;
                String gulv = rs.getString("gulv");
                int redskab_laengde = rs.getInt("RL.laengde");
                int redskabs_bredde = rs.getInt("RLB.bredde");
                int laengde = rs.getInt("CL.laengde");
                int bredde = rs.getInt("CLB.bredde");
                String farve = rs.getString("farve");
                String carport_traeType = rs.getString("TC.traetype");
                String Tag = rs.getString("typer");
                int haeldning = rs.getInt("haeldninger");
                String navn = rs.getString("ku.navn");
                String kundeemail = rs.getString("ku.email");
                int kundetlf = rs.getInt("ku.tlf");
                int postnummer = rs.getInt("ku.postnummer");
                String redskabs_traeType = rs.getString("TC2.traetype");
                double pris = rs.getFloat("pris");
                int id = rs.getInt("idforespoergsel");

                MR.add(new Forespoergseler(id, laengde, bredde, farve, carport_traeType, Tag, haeldning, redskabs_traeType, gulv,
                        redskab_laengde, redskabs_bredde, navn, postnummer, kundeemail, kundetlf, pris));

                if (redskab_laengde == 0) {
                    MR.remove(i);
                    MR.add(new Forespoergseler(gulv, id, laengde, bredde, farve, carport_traeType, Tag, haeldning,
                            navn,  postnummer, kundeemail, kundetlf, pris));
                }
            }


        } catch (SQLException | ClassNotFoundException | NullPointerException | IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }

        return MR;
    }


    /**
     *Metoden opdatere prisen på kundens forespørgsel.
     *
     *
     * @param id kundens id
     * @param pris Pris på tilbud
     * @return List<Forespoergseler>
     */
    public static void Update_Pris(int id, double pris){

        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(Update_Pris);
            ps.setDouble(1,pris);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException | ClassNotFoundException | NullPointerException | IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }
}