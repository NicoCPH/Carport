package FunctionLayer.Objekter;

import DBAccess.Stykliste_Mapper;
import FunctionLayer.Fejl_haendtering;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Stykliste {

    private static ArrayList<Materiale> materialeArrayList = new ArrayList<>();

    public static ArrayList<Materiale> styklisten(int laengde, int bredde,
                                                  String redskabsrumbeklaedningstype, String tagHaeldning, String tagMaterialeType) throws ExceptionHandler {
        if(materialeArrayList == null){
            materialeArrayList = new ArrayList<>();
        }
        materialeArrayList.add(new Materiale(spaer_Omregner_beskrivelse(),  "Spær", laengde, spaer_Omregner(laengde)));
        materialeArrayList.add(new Materiale(rem_Omregner_beskrivelse(), "Rem", bredde, 4));
        materialeArrayList.add(new Materiale(stolpe_Omregner_beskrivlese(), "Stolpe", 200, stolpe_Omregner(redskabsrumbeklaedningstype,tagHaeldning) ));
        materialeArrayList.add(new Materiale(tag_Omregner_beskrivelse(tagMaterialeType), "Tag", tag_laengde(tagHaeldning) ,tag_Omregner(laengde,bredde,tagHaeldning) ));
        return materialeArrayList;
    }

    public static int spaer_Omregner(int laegnde) {

        double spaer = laegnde / 55.0;

        return (int) Math.round(spaer);
    }

    public static int stolpe_Omregner(String redskabsrumbeklaedningstype, String tagHaeldning) {
        int stolper;

        if (redskabsrumbeklaedningstype == null && tagHaeldning == null) {
            stolper = 8;
            return  stolper;

        } else if (redskabsrumbeklaedningstype == null) {
            stolper = 8;
            return stolper;

        } else if (tagHaeldning == null) {
            stolper = 10;
            return stolper;

        } else {
            stolper = 10;
            return stolper;
        }


    }

    public static int tag_laengde(String taghaeldning){
        if(taghaeldning == null){
            return 100;
        }else {
            return 30;
        }
    }
    public static int tag_Omregner(int laengde, int bredde, String taghaeldning) {
        if (taghaeldning == null) {
            return fladtTag_omregner(laengde, bredde);
        } else{
            return rejsningTag_omregner(laengde, bredde);
    }
    }

    public static int fladtTag_omregner(int laengde, int bredde) {
        int totalLB = laengde * bredde;
        int LBdivideret = totalLB / 10000;

        return LBdivideret;
    }

    public static int rejsningTag_omregner(int laengde, int bredde) {
        int totalLB = laengde * bredde;
        int LBdivideret = totalLB / 10000;
        int totalPlader = LBdivideret * 4;

        return totalPlader;
    }

    /*public static Materiale rem_Omregner(int bredde) throws ExceptionHandler {
        Map<String, List<Materiale>> materialeMap = StyklisteMapper.findStykListe();

    public static Materiale rem_Omregner(int bredde) throws Fejl_haendtering {
        Map<String, List<Materiale>> materialeMap = Stykliste_Mapper.findStykListe();

        List<Materiale> alleRem = materialeMap.get("Rem");
        for (Materiale rem : alleRem) {
            if (rem.getLaengde() == bredde) {
                return rem;
            }
        }
        return null;
    }

   /* public static Materiale spaer_Omregener(int laengde) throws ExceptionHandler {
        Map<String, List<Materiale>> materialeMap = StyklisteMapper.findStykListe();

    public static Materiale spær_Omregener(int laengde) throws Fejl_haendtering {
        Map<String, List<Materiale>> materialeMap = Stykliste_Mapper.findStykListe();
        List<Materiale> alleSpær = materialeMap.get("Spær");
        for (Materiale spær : alleSpær) {
            if (spær.getLaengde() == laengde) {
                return spær;
            }
        }
        return null;
    }
*/

    public static String rem_Omregner_beskrivelse() throws ExceptionHandler {
        Map<String, List<Materiale>> materialeMap = StyklisteMapper.findStykListe();
        List<Materiale> alleRem = materialeMap.get("Rem");
        for (Materiale rem : alleRem) {
            return rem.getBeskrivelse();
        }
        return null;
    }


    public static String spaer_Omregner_beskrivelse() throws ExceptionHandler {
        Map<String, List<Materiale>> materialeMap = StyklisteMapper.findStykListe();
        List<Materiale> alleSpær = materialeMap.get("Spær");
        for (Materiale spær : alleSpær) {
            return spær.getBeskrivelse();
        }
        return null;
    }

    public static String stolpe_Omregner_beskrivlese() throws ExceptionHandler {
        Map<String, List<Materiale>> stolpeMap = StyklisteMapper.findStykListe();
        List<Materiale> alleStolper = stolpeMap.get("Stolpe");
        for (Materiale stolpe : alleStolper) {
            return stolpe.getBeskrivelse();
        }
        return null;
    }

    public static String tag_Omregner_beskrivelse(String tagMaterialeType) throws ExceptionHandler {
        Map<String, List<Materiale>> tagMap = StyklisteMapper.findStykListe();
        List<Materiale> alleTag = tagMap.get("Tag");


        for (Materiale tag : alleTag) {


            if (tagMaterialeType.contains("Plast")) {
                if (tag.getBeskrivelse().contains("Plast")) {
                    return tag.getBeskrivelse();
                }
            } else {

                if (tagMaterialeType.contains("Beton")) {
                    if (tag.getBeskrivelse().contains("Beton")) {
                        return tag.getBeskrivelse();
                    }
                }
                if(tagMaterialeType.contains("Eternitag")) {
                    if(tag.getBeskrivelse().contains("Eternitag")) {
                        return tag.getBeskrivelse();
                    }
                }


            }


        }
        return "Intet tagmaterialer fundet";
    }
}
