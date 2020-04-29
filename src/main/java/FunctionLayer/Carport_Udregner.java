package FunctionLayer;

public class Carport_Udregner {


    public static double udregning_Pris_UdenRedskab_Fladtag(int laengde, int bredde){
            double spaertrae = 50.0;
            double stolper = 6.0*400.0;
            double tagprkvm = 75.0;
            double kvadratMeter = ((double) laengde * (double) bredde)/10000;
            double tag_Kvm_Pris = tagprkvm*kvadratMeter;
            double laengde_Pris = (double) laengde /10.0;
            double bredde_Pris = (double) bredde /10.0;
            double bredde_total = bredde_Pris*spaertrae;
            double laengde_total = laengde_Pris*spaertrae;
            double total = (stolper+tag_Kvm_Pris)+(bredde_total+laengde_total);

        return total;
    }
    public static double udregning_Pris_MedRedskab_Fladtag(int laengde, int bredde, int rlaengde, int rbredde){
        double spaertrae = 50.0;
        double stolper = 4.0*400.0;
        double tagprkvm = 75.0;
        double kvadratMeter = ((double) laengde * (double) bredde)/10000;
        double tag_Kvm_Pris = tagprkvm*kvadratMeter;
        double laengde_Pris = (double) laengde /10.0;
        double bredde_Pris = (double) bredde /10.0;
        double bredde_total = bredde_Pris*spaertrae;
        double laengde_total = laengde_Pris*spaertrae;
        double rlaengde_Pris = (double) rlaengde /10.0;
        double rbredde_Pris = (double) rbredde /10.0;
        double rbredde_total = rbredde_Pris*spaertrae;
        double rlaengde_total = rlaengde_Pris*spaertrae;
        double total = (stolper+tag_Kvm_Pris)+(bredde_total+laengde_total)+(rbredde_total+rlaengde_total);

        return total;
    }


}
