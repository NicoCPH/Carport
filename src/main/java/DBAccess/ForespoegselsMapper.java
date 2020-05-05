package DBAccess;

import FunctionLayer.ExceptionHandler;
import FunctionLayer.Objekter.Forespoergsel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ForespoegselsMapper {

    private static List<Forespoergsel> UR = new ArrayList<>();
    private static List<Forespoergsel> MR = new ArrayList<>();
private static final String Select_All_From_Forespoegsel = "SELECT CL.laengde, CLB.bredde, farve, TC.traetype, typer, haeldninger, RL.laengde," +
    "RLB.bredde, gulv, TC2.traetype, kundenavn, kundeadresse, kundeby, kundepostnummer, kundeemail, kundetlf FROM carportdb.forespoergsel \n" +
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
        "where kundeemail = ?;";
private static final String Select_All_from_Forespoegsel_udenRedskab = "SELECT CL.laengde, CLB.bredde, farve, TC.traetype, typer, haeldninger," +
        "kundenavn, kundeadresse, kundeby, kundepostnummer, kundeemail, kundetlf FROM carportdb.forespoergsel \n" +
        "inner join laengder CL on carportlaengde = CL.idlaengder\n" +
        "inner join bredder CLB on carportbredde = CLB.idbredder\n" +
        "inner join farver on carportfarve = idfarver\n" +
        "inner join traetyper TC on carporttraetype = TC.idtraetyper\n" +
        "inner join tagmateriale on tagmateriale = idtagmateriale\n" +
        "inner join haeldning on taghaeldning = idhaeldning\n" +
        "where kundeemail = ?;";



public static List<Forespoergsel> Alle_Forespoerelser(String email) throws ExceptionHandler {
    if(MR == null) {
        MR = new ArrayList<>();
    }
    try {
        Connection con = Connector.connection();
        PreparedStatement ps = con.prepareStatement(Select_All_From_Forespoegsel);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
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
            String navn = rs.getString("kundenavn");
            String adresse = rs.getString("kundeadresse");
            String kundeby = rs.getString("kundeby");
            int kundepostnummer = rs.getInt("kundepostnummer");
            String kundeemail = rs.getString("kundeemail");
            int kundetlf = rs.getInt("kundetlf");


            MR.add(new Forespoergsel(laengde,bredde,farve,carport_traeType,Tag,haeldning,redskabs_traeType,gulv,
                    redskab_laengde,redskabs_bredde,navn,adresse,kundeby,kundepostnummer,kundeemail,kundetlf));


        }else{
            return Alle_Forespoerelser_UdenRedskab(email);
        }

    } catch (SQLException | ClassNotFoundException ex) {
        ex.printStackTrace();
    }
    return MR;
}
    public static List<Forespoergsel> Alle_Forespoerelser_UdenRedskab(String email) throws ExceptionHandler {
        if(MR == null) {
            MR = new ArrayList<>();
        }
        try {
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
                String navn = rs.getString("kundenavn");
                String adresse = rs.getString("kundeadresse");
                String kundeby = rs.getString("kundeby");
                int kundepostnummer = rs.getInt("kundepostnummer");
                String kundeemail = rs.getString("kundeemail");
                int kundetlf = rs.getInt("kundetlf");
                MR.add(new Forespoergsel(laengde,bredde,farve,carport_traeType,Tag,haeldning,
                        navn,adresse,kundeby,kundepostnummer,kundeemail,kundetlf));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return MR;
    }
}
