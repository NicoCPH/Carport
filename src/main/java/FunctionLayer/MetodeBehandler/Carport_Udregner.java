package FunctionLayer.MetodeBehandler;

public class Carport_Udregner {


    /**
     *Metoden udregner en pris via 2 parametre som er længde og bredde. ud fra nogle givne variabler, regner den prisen ud.
     *
     * Uden redskabsrum og med fladtag
     *
     * @param bredde bredde i cm
     * @param laengde længde i cm
     * @return double
     */
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

    /**
     *Metoden udregner en pris via 2 parametre som er længde og bredde. ud fra nogle givne variabler, regner den prisen ud.
     *
     * Med fladt tag og redskabsrum
     *
     * @param bredde bredde i cm
     * @param laengde længde i cm
     * @return double
     */
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

    /**
     *Metoden udregner en pris via 2 parametre som er længde og bredde. ud fra nogle givne variabler, regner den prisen ud.
     *
     * Med redskabsrum og rejsning
     *
     * @param bredde bredde i cm
     * @param laengde længde i cm
     * @return double
     */
    public static double udregning_Pris_MedRedskab_Rejsning(int laengde, int bredde, int rlaengde, int rbredde, int haeldning){
        double spaertrae = 50.0;
        double stolper = 4.0*400.0;
        double laengde_Pris = (double) laengde /10.0;
        double bredde_Pris = (double) bredde /10.0;
        double bredde_total = bredde_Pris*spaertrae;
        double laengde_total = laengde_Pris*spaertrae;
        double rlaengde_Pris = (double) rlaengde /10.0;
        double rbredde_Pris = (double) rbredde /10.0;
        double rbredde_total = rbredde_Pris*spaertrae;
        double rlaengde_total = rlaengde_Pris*spaertrae;
        double total = (stolper+haeldnings_beregner(haeldning))+(bredde_total+laengde_total)+(rbredde_total+rlaengde_total);

        return total;
    }
    /**
     *Metoden udregner en pris via 2 parametre som er længde og bredde. ud fra nogle givne variabler, regner den prisen ud.
     *
     * Uden redskabsrum og med rejsning
     *
     * @param bredde bredde i cm
     * @param laengde længde i cm
     * @return double
     */
    public static double udregning_Pris_UdenRedskab_Rejsning(int laengde, int bredde, int haeldning){
        double spaertrae = 50.0;
        double stolper = 6.0*400.0;
        double laengde_Pris = (double) laengde /10.0;
        double bredde_Pris = (double) bredde /10.0;
        double bredde_total = bredde_Pris*spaertrae;
        double laengde_total = laengde_Pris*spaertrae;
        double total = (stolper+haeldnings_beregner(haeldning))+(bredde_total+laengde_total);
        return total;
    }

    /**
     *Metoden udregner en pris via en givent hældning og en givent standard pris.
     *
     * @param haeldning hældningen på carporten i %
     * @return double
     */
public static double haeldnings_beregner(int haeldning){
        double Standard_pris = 3500;
        if(haeldning == 15){
            return Standard_pris +1000;
        }else if(haeldning == 20){
            return Standard_pris +1500;
        }else if(haeldning == 25){
            return Standard_pris +2000;
        }else if(haeldning == 30){
            return Standard_pris +2500;
        }else if(haeldning == 35){
            return Standard_pris +3000;
        }else if(haeldning == 40){
            return Standard_pris +3500;
        }else {
            return Standard_pris +3500;
        }


}
}
