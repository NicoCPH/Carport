package FunctionLayer;


import DBAccess.*;
import FunctionLayer.Objekter.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Her sætter vi alt ind der har noget at gøre med database, som skal bruges i vores kode.
 * @author Nicolas
 */
public class LogicFacade {


    protected static Map<String, List<Materiale>> materialeMap = new HashMap<>();


    public static Map<String, List<Materiale>> findStykListe() throws Fejl_haendtering {

        List<Materiale> alleMaterialer = Stykliste_Mapper.stykListe();

        List<Materiale> RemListe = new ArrayList<>();
        List<Materiale> StolpeListe = new ArrayList<>();
        List<Materiale> SpaerListe = new ArrayList<>();
        List<Materiale> TagListe = new ArrayList<>();
        if(materialeMap.size() > 0){
            materialeMap.clear();
            materialeMap = new HashMap<>();
        }

        alleMaterialer.forEach(materiale -> {
            switch (materiale.getNavn()) {
                case "Rem":
                    RemListe.add(materiale);
                    break;
                case "Spær":
                    SpaerListe.add(materiale);
                    break;
                case "Stolpe":
                    StolpeListe.add(materiale);
                    break;
                case "Tag":
                    TagListe.add(materiale);
                    break;
                default:
                    break;
            }
        });

        materialeMap.put("Rem", RemListe);
        materialeMap.put("Spær", SpaerListe);
        materialeMap.put("Stolpe", StolpeListe);
        materialeMap.put("Tag", TagListe);

        return materialeMap;
    }

    public static void lav_Forespoergsel(int carportLaengde, int carportBredde, int carportFarve,
                                         int carportTraeType, int tagMateriale, int tagHaeldning, int redskabsrumsbredde,
                                         int redskabsrumslaengde, int redskabsrumBeklaedningstype, int redskabsrumGulv,
                                         String navn,  int postNummer,  int tlf,
                                         String email, double pris) throws Fejl_haendtering {

        Kunde_Mapper.lav_Kunde(navn, postNummer, tlf, email, carportLaengde, carportBredde, carportFarve, carportTraeType
                , tagMateriale, tagHaeldning, redskabsrumsbredde, redskabsrumslaengde, redskabsrumBeklaedningstype, redskabsrumGulv, pris);

    }


    public static Map<Integer, Bredde> dropdown_Bredde() throws Fejl_haendtering {
        return Carport_Mapper.dropdown_Bredde();
    }

    public static Map<Integer, Laengde> dropdown_Laengde() throws Fejl_haendtering {
        return Carport_Mapper.dropdown_Laengde();
    }

    public static Map<Integer, Gulv> dropdown_Gulv() throws Fejl_haendtering {
        return Carport_Mapper.dropdown_Gulv();
    }

    public static Map<Integer, Traetype> dropdown_TraeType() throws Fejl_haendtering {
        return Carport_Mapper.dropdown_Trae_type();
    }

    public static Map<Integer, Tag> dropdown_Haeldning() throws Fejl_haendtering {
        return Carport_Mapper.dropdown_Haeldning();
    }

    public static Map<Integer, Farve> dropdown_Farve() throws Fejl_haendtering {
        return Carport_Mapper.dropdown_Farve();
    }

    public static Map<Integer, Tag> dropdown_Tagmatriale() throws Fejl_haendtering {
        return Carport_Mapper.dropdown_Tagmatriale();
    }

    public static List<Forespoergseler> forespoergsel(String email) throws Fejl_haendtering {
        return Forespoergsels_Mapper.Alle_Forespoerelser(email);
    }

    public static void opdater_pris(int id, double pris) {
       Forespoergsels_Mapper.Update_Pris(id,pris);
    }

}
