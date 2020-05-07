package FunctionLayer.Objekter;

import DBAccess.StyklisteMapper;
import FunctionLayer.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Stykliste {

    private static ArrayList<Materiale> materialeArrayList = new ArrayList<>();

    public static double spaer_Omregner(int laegnde) {

        double spaer = laegnde / 55.0;

        return (double) Math.round(spaer);
    }

    public static int stolpe_Omregner(String redskabsrumbeklaedningstype, String tagHaeldning) {
        int stolper;

        if (redskabsrumbeklaedningstype == null && tagHaeldning == null) {
            stolper = 6;

        } else if (redskabsrumbeklaedningstype == null) {
            stolper = 6;

        } else if (tagHaeldning == null) {
            stolper = 8;

        } else {
            stolper = 8;
        }

        return stolper;
    }

    public static Materiale rem_Omregner(int bredde) throws ExceptionHandler {
        Map<String, List<Materiale>> materialeMap = StyklisteMapper.findStykListe();
        List<Materiale> alleRem = materialeMap.get("Rem");
        for (Materiale rem : alleRem) {
            if (rem.getLaengde() == bredde) {
                return rem;
            }
        }
        return null;
    }

    public static Materiale spær_Omregener(int laengde) throws ExceptionHandler {
        Map<String, List<Materiale>> materialeMap = StyklisteMapper.findStykListe();
        List<Materiale> alleSpær = materialeMap.get("Spær");
        for (Materiale spær : alleSpær) {
            if (spær.getLaengde() == laengde) {
                return spær;
            }
        }
        return null;
    }


}