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

    private static List<Forespoergseler> UR = new ArrayList<>();
    private static List<Forespoergseler> MR = new ArrayList<>();
private static final String Select_All_From_Forespoegsel = "SELECT ku.by, ku.postnummer, ku.kundeId, ku.adresse, ku.tlf, idforespoergsel, CL.laengde, CLB.bredde, farve, TC.traetype, typer, haeldninger, RL.laengde," +
    "RLB.bredde, gulv, TC2.traetype, ku.navn, ku.email FROM carportdb.forespoergsel p \n" +
    "inner join laengder CL on carportlaengde = CL.idlaengder\n" +
    "inner join laengder RL on redskabsrumlaengde = RL.idlaengder\n" +
    "inner join bredder CLB on carportbredde = CLB.idbredder\n" +
    "inner join bredder RLB on redskabsrumbredde = RLB.idbredder\n"+
    "inner join farver on carportfarve = idfarver\n" +
    "inner join traetyper TC on carporttraetype = TC.idtraetyper\n" +
    "inner join tagmateriale on tagmateriale = idtagmateriale\n" +
    "inner join haeldning on taghaeldning = idhaeldning\n" +
    "inner join gulv on redskabsrumgulv = idGulv\n" +
    "inner join traetyper TC2 on redskabsrumbeklaedningstype = TC2.idtraetyper\n"+
        "inner join kunde ku on p.kundeID = ku.kundeID\n" +
        "where ku.email = ?;";
private static final String Select_All_from_Forespoegsel_udenRedskab = "SELECT ku.by, ku.postnummer, ku.kundeId, ku.adresse, ku.tlf, idforespoergsel, CL.laengde, CLB.bredde, farve, TC.traetype, typer, haeldninger, ku.navn, ku.email FROM carportdb.forespoergsel p \n" +
    "inner join laengder CL on carportlaengde = CL.idlaengder\n" +
    "inner join bredder CLB on carportbredde = CLB.idbredder\n" +
    "inner join farver on carportfarve = idfarver\n" +
    "inner join traetyper TC on carporttraetype = TC.idtraetyper\n" +
    "inner join tagmateriale on tagmateriale = idtagmateriale\n" +
    "inner join haeldning on taghaeldning = idhaeldning\n" +
    "inner join kunde ku on p.kundeID = ku.kundeID\n" +
        "where ku.email = ?;";



public static List<Forespoergseler> Alle_Forespoerelser(String email) throws Fejl_haendtering {
    if (MR == null) {
        MR = new ArrayList<>();
    }

    try {
        Connection con = Connector.connection();
        PreparedStatement ps = con.prepareStatement(Select_All_From_Forespoegsel);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        int resultsCounter = 0;
        if (rs.next()) {
            while (rs.next()) {


                resultsCounter++;
                System.out.println("While løkke");
                int laengde = rs.getInt("CL.laengde");
                int bredde = rs.getInt("CLB.bredde");
                String farve = rs.getString("farve");
                String carport_traeType = rs.getString("TC.traetype");
                String Tag = rs.getString("typer");
                int haeldning = rs.getInt("haeldninger");
                String redskabs_traeType = rs.getString("TC2.traetype");
                String gulv = rs.getString("gulv");
                int redskab_laengde = rs.getInt("RL.laengde");
                int redskabs_bredde = rs.getInt("RLB.bredde");
                String navn = rs.getString("ku.navn");
                String adresse = rs.getString("ku.adresse");
                String kundeemail = rs.getString("ku.email");
                int kundetlf = rs.getInt("ku.tlf");
                String by = rs.getString("ku.by");
                int postnummer = rs.getInt("ku.postnummer");
                System.out.println(redskabs_traeType);


                MR.add(new Forespoergseler(laengde, bredde, farve, carport_traeType, Tag, haeldning, redskabs_traeType, gulv,
                        redskab_laengde, redskabs_bredde, navn, adresse, by, postnummer, kundeemail, kundetlf));


            }

        } if (resultsCounter == 0){
            System.out.println("Anden metodekald");
            Alle_Forespoerelser_UdenRedskab(email);
        }









    } catch (SQLException | ClassNotFoundException ex) {
        ex.printStackTrace();
    }
    return MR;
}
    public static List<Forespoergseler> Alle_Forespoerelser_UdenRedskab(String email) throws Fejl_haendtering {
        if(MR == null) {
            MR = new ArrayList<>();
        }
        try {
            System.out.println("555");
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(Select_All_from_Forespoegsel_udenRedskab);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int laengde = rs.getInt("CL.laengde");
                int bredde = rs.getInt("CLB.bredde");
                String farve = rs.getString("farve");
                String carport_traeType = rs.getString("TC.traetype");
                String Tag = rs.getString("typer");
                int haeldning = rs.getInt("haeldninger");
                String navn = rs.getString("ku.navn");
                String adresse = rs.getString("ku.adresse");
                String kundeemail = rs.getString("ku.email");
                int kundetlf = rs.getInt("ku.tlf");
                String by = rs.getString("ku.by");
                int postNummer = rs.getInt("ku.postnummer");



                MR.add(new Forespoergseler(laengde,bredde,farve,carport_traeType,Tag,haeldning,
                        navn,adresse,by,postNummer, kundeemail, kundetlf));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return MR;
    }
}
