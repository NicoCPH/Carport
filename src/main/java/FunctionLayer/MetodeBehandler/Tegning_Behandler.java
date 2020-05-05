package FunctionLayer.MetodeBehandler;


public class Tegning_Behandler {

    public static double spaer_Omregner(int laegnde){

        double spaer = laegnde/55.0;

        return (double) Math.round(spaer);
    }



    public static String Tegning(double spaer){

        return "fefkef";
    }

    public static void main(String[] args) {
        int laengde = 0;
        Tegning(spaer_Omregner(laengde));
    }


}
