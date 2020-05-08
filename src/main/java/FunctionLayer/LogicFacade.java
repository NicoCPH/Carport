package FunctionLayer;


import DBAccess.Carport_Mapper;
import DBAccess.Medarbejder_Mapper;


/**
 * Her sætter vi alt ind der har noget at gøre med database, som skal bruges i vores kode.
 * @author Nicolas
 */
public class LogicFacade {

    public static void lav_Forespoergsel(int carportLaengde, int carportBredde, int carportFarve,
                                         int carportTraeType , int tagMateriale, int tagHaeldning, int redskabsrumsbredde,
                                         int redskabsrumslaengde, int redskabsrumBeklaedningstype, int redskabsrumGulv,
                                         String navn, String adresse, int postNummer, String by, int tlf,
                                         String email) throws Fejl_haendtering {

        Carport_Mapper.forespoergselList(carportLaengde, carportBredde, carportFarve, carportTraeType, tagMateriale,
                tagHaeldning, redskabsrumsbredde, redskabsrumslaengde, redskabsrumBeklaedningstype, redskabsrumGulv,
        navn, adresse, postNummer, by, tlf, email);

    }

    public static void lavForespoergsel_UdenRedskabsrum(int carportLaengde, int carportBredde, int carportFarve,
                                                        int carportTraeType , int tagMateriale, int tagHaeldning,
                                                        String navn, String adresse, int postNummer, String by, int tlf,
                                                        String email) throws Fejl_haendtering {

        Carport_Mapper.forespoergselListUdenRedskabrum(carportLaengde, carportBredde, carportFarve, carportTraeType, tagMateriale,
                tagHaeldning, navn, adresse, postNummer, by, tlf, email);

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
