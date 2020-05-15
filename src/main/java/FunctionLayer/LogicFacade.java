package FunctionLayer;


import DBAccess.CarportMapper;
import DBAccess.KundeMapper;
import DBAccess.Medarbejder_Mapper;
import DBAccess.Stykliste_Mapper;
import FunctionLayer.Objekter.Materiale;

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

    public static Map<String, List<Materiale>> getMaterialeMap() {
        return materialeMap;
    }

    public static Map<String, List<Materiale>> findStykListe() throws Fejl_haendtering {

        List<Materiale> alleMaterialer = Stykliste_Mapper.stykListe();

        List<Materiale> RemListe = new ArrayList<>();
        List<Materiale> StolpeListe = new ArrayList<>();
        List<Materiale> SpaerListe = new ArrayList<>();
        List<Materiale> TagListe = new ArrayList<>();

        if(materialeMap == null) {
            materialeMap = new HashMap<>();
        }

        alleMaterialer.forEach(materiale -> {
            switch(materiale.getNavn()){
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

        materialeMap.put("Rem",RemListe);
        materialeMap.put("Spær", SpaerListe);
        materialeMap.put("Stolpe", StolpeListe);
        materialeMap.put("Tag", TagListe);

        return materialeMap;
    }

    public static void lav_Forespoergsel(int carportLaengde, int carportBredde, int carportFarve,
                                         int carportTraeType , int tagMateriale, int tagHaeldning, int redskabsrumsbredde,
                                         int redskabsrumslaengde, int redskabsrumBeklaedningstype, int redskabsrumGulv,
                                         String navn, String adresse, int postNummer, String by, int tlf,
                                         String email, double pris) throws Fejl_haendtering {

        KundeMapper.lavKunde_MedRedskabsrum(navn, adresse, postNummer, by, tlf, email, carportLaengde, carportBredde, carportFarve, carportTraeType
        , tagMateriale, tagHaeldning, redskabsrumsbredde, redskabsrumslaengde, redskabsrumBeklaedningstype, redskabsrumGulv, pris);

    }

    public static void lavForespoergsel_UdenRedskabsrum(int carportLaengde, int carportBredde, int carportFarve,
                                                        int carportTraeType , int tagMateriale, int tagHaeldning,
                                                        String navn, String adresse, int postNummer, String by, int tlf,
                                                        String email, double pris) throws Fejl_haendtering {

        KundeMapper.lavKunde_UdenRedskabsrum(navn, adresse, postNummer, by, tlf, email, carportLaengde, carportBredde,
                carportFarve, carportTraeType, tagMateriale, tagHaeldning, pris);

    }

    public static Medarbejder login(String email, String password ) throws Fejl_haendtering {
        return Medarbejder_Mapper.login( email, password );
    }

    public static Medarbejder createEmployee(String navn, String password, String email) throws Fejl_haendtering {
        Medarbejder user = new Medarbejder(navn, password, email);
        Medarbejder_Mapper.createEmployee( user );
        return user;
    }


}
