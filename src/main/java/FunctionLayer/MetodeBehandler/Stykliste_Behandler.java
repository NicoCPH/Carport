package FunctionLayer.MetodeBehandler;

import FunctionLayer.Fejl_haendtering;
import FunctionLayer.LogicFacade;
import FunctionLayer.Objekter.Materiale;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Stykliste_Behandler {

    private static ArrayList<Materiale> materialeArrayList = new ArrayList<>();

    /**
     *Metoden laver et Arraylist som tager flere parametere som skal definere et materiale objekt, som beskriver enten et tag, rem, stolpe
     * eller spær. Obejkterne bliver tilføjet til ArrayList så der et komplet stykliste.
     *
     * @param laengde længde i cm
     * @param bredde bredde i cm
     * @param redskabsrumbeklaedningstype fortæller om der skal være redskabsrum, som er en string
     * @param tagHaeldning angiver om der skal være taghældning
     * @param tagMaterialeType angiver hvilken materialetype taget skal bruge
     *
     * @return ArrayList som indeholder materiale objekter som udgør styklisten.
     */

    public static ArrayList<Materiale> styklisten(int laengde, int bredde,
                                                  String redskabsrumbeklaedningstype, String tagHaeldning, String tagMaterialeType) throws Fejl_haendtering {
        if(materialeArrayList == null){
            materialeArrayList = new ArrayList<>();
        }
        materialeArrayList.add(new Materiale(spaer_Omregner_beskrivelse(),  "Spær", laengde, spaer_Omregner(laengde)));
        materialeArrayList.add(new Materiale(rem_Omregner_beskrivelse(), "Rem", bredde, 4));
        materialeArrayList.add(new Materiale(stolpe_Omregner_beskrivlese(), "Stolpe", 200, stolpe_Omregner(redskabsrumbeklaedningstype,tagHaeldning) ));
        materialeArrayList.add(new Materiale(tag_Omregner_beskrivelse(tagMaterialeType), "Tag", tag_laengde(tagHaeldning) ,tag_Omregner(laengde,bredde,tagHaeldning) ));
        return materialeArrayList;
    }

    /**
     *Metoden omregner hvor mange spær man skal bruge til sin carport. Det gøres ved at dividere længden med 55.0 som er vores antagelse.
     * Den returnere så det tallet med Math.round() som sørger for at vi ikke får komma tal med.
     *
     * @param laegnde længde i cm
     * @return int
     */


    public static int spaer_Omregner(int laegnde) {

        double spaer = laegnde / 55.0;

        return (int) Math.round(spaer);
    }

    /**
     *Metoden omregner hvor mange stolper den givne carport skal bruge med vores antagelse. Hvis carporten redskabsrumsbeklaedningstype type er null
     * så skal carpoten have 8 stolper og omvendt hvis den ikke er null, så skal den have 10 stolper.
     *tagHaeldning er ikke super relevant her, men parameteren bruges i andre metoder.
     *
     * @param redskabsrumbeklaedningstype er redskabsrum
     * @param tagHaeldning er hældningen på taget
     * @return int
     */

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

    /**
     *Metoden er en antagelse, som finder ud af om der er en taghældning og hvis det er taghældning, så skal den returnere tagplader med
     * længden med 30 cm. Hvis der ikke er taghældning så skal den retunere længden 100 cm.
     *
     * @param taghaeldning parameter som angiver om der skal være taghældning
     * @return int som er i cm.
     */

    public static int tag_laengde(String taghaeldning){
        if(taghaeldning == null){
            return 100;
        }else {
            return 30;
        }
    }

    /**
     *Metoden finder ud om hvilken tag omregner metode der skal bruges.
     * Hvis taghældningen er null, så returnere den fladtag_omregner metoden og omvendt.
     *
     * @param laengde længde i cm
     * @param bredde bredde i cm
     * @param taghaeldning angiver om der er hældning i taget
     * @return int som bliver udregnet i de respektive metoder
     */

    public static int tag_Omregner(int laengde, int bredde, String taghaeldning) {
        if (taghaeldning == null) {
            return fladtTag_omregner(laengde, bredde);
        } else{
            return rejsningTag_omregner(laengde, bredde);
    }
    }


    /**
     *Metoden omregner carporten med et fladt tag. Den tager længde gange bredde, som bliver divideret med 10000, som er vores antagelse.
     *
     *
     * @param laengde længde i cm
     * @param bredde bredde i cm
     * @return int
     */

    public static int fladtTag_omregner(int laengde, int bredde) {
        int totalLB = laengde * bredde;
        int LBdivideret = totalLB / 10000;

        return LBdivideret;
    }

    /**
     *Metoden omregner carporten med et resjning. Den tager længde gange bredde, som bliver divideret med 10000
     * tallet bliver så ganget med 4, som er vores antagelse.
     *
     *
     * @param laengde længde i cm
     * @param bredde bredde i cm
     * @return int
     */

    public static int rejsningTag_omregner(int laengde, int bredde) {
        int totalLB = laengde * bredde;
        int LBdivideret = totalLB / 10000;
        int totalPlader = LBdivideret * 4;

        return totalPlader;
    }

    /**
     *Metoden instancieret et Hashmap, som den finder fra LogicFacaden, som skal finde det tilsvarende Arraylist som indeholder remme.
     * Der bliver instancieret et ArrayList, som skal finde alle værdier fra Hashmappet med værdien "Rem".
     * Der bliver kørt et for each loop som gennemløber alle materiale instancer og finder beskrivelsen af spær.
     *
     *
     * @return string som er beskrivelsen af remmen.
     */

    public static String rem_Omregner_beskrivelse() throws Fejl_haendtering {

        Map<String, List<Materiale>> materialeMap = LogicFacade.findStykListe();

        List<Materiale> alleRem = materialeMap.get("Rem");
        for (Materiale rem : alleRem) {
            return rem.getBeskrivelse();
        }
        return null;
    }

    /**
     *Metoden instancieret et Hashmap, som den finder fra LogicFacaden, som skal finde det tilsvarende Arraylist som indeholder spær.
     * Der bliver instancieret et ArrayList, som skal finde alle værdier fra Hashmappet med værdien "Spær".
     * Der bliver kørt et for each loop som gennemløber alle materiale instancerog finder beskrivelsen af spær.
     *
     *
     * @return string som er beskrivelsen af remmen.
     */

    public static String spaer_Omregner_beskrivelse() throws  Fejl_haendtering {

        Map<String, List<Materiale>> materialeMap = LogicFacade.findStykListe();
        List<Materiale> alleSpær = materialeMap.get("Spær");
        for (Materiale spær : alleSpær) {
            return spær.getBeskrivelse();
        }
        return null;
    }

    /**
     *Metoden instancieret et Hashmap, som den finder fra LogicFacaden, som skal finde det tilsvarende Arraylist som indeholder stolper.
     * Der bliver instancieret et ArrayList, som skal finde alle værdier fra Hashmappet med værdien "Stolper".
     * Der bliver kørt et for each loop som gennemløber alle materiale instancerog finder beskrivelsen af stolperne.
     *
     *
     * @return string som er beskrivelsen af remmen.
     */

    public static String stolpe_Omregner_beskrivlese() throws Fejl_haendtering {

        Map<String, List<Materiale>> stolpeMap = LogicFacade.findStykListe();

        List<Materiale> alleStolper = stolpeMap.get("Stolpe");
        for (Materiale stolpe : alleStolper) {
            return stolpe.getBeskrivelse();
        }
        return null;
    }

    /**
     *Metoden instancieret et Hashmap, som den finder fra LogicFacaden, som skal finde det tilsvarende Arraylist som indeholder tag.
     * Der bliver instancieret et ArrayList, som skal finde alle værdier fra Hashmappet med værdien "Tag".
     * Der bliver kørt et for each loop som gennemløber alle materiale instancer.
     * Den køre et if-statement som siger hvis at parameteret tagmaterialetype indeholder noget med enten "Plast", "Eternitag" eller "Beton"
     * så skal den gette beskrivelsen tilsvarende til disse parameter fra materiale objektet, og derefter bliver beskrivelsen sendt med.
     *
     *
     *
     * @return string som er beskrivelsen af det givne tag
     */

    public static String tag_Omregner_beskrivelse(String tagMaterialeType) throws Fejl_haendtering {

        Map<String, List<Materiale>> tagMap = LogicFacade.findStykListe();

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
