package FunctionLayer;


import DBAccess.CarportMapper;
import DBAccess.MedarbejderMapper;
import DBAccess.StyklisteMapper;
import FunctionLayer.Objekter.Materiale;


/**
 * Her sætter vi alt ind der har noget at gøre med database, som skal bruges i vores kode.
 * @author Nicolas
 */
public class LogicFacade {

    public static void lavForespoergsel(int carportLaengde, int carportBredde, int carportFarve,
                                        int carportTraeType ,int tagMateriale, int tagHaeldning, int redskabsrumsbredde,
                                         int redskabsrumslaengde, int redskabsrumBeklaedningstype, int redskabsrumGulv,
                                        String navn, String adresse, int postNummer, String by, int tlf,
                                        String email) throws ExceptionHandler {

        CarportMapper.forespoergselList(carportLaengde, carportBredde, carportFarve, carportTraeType, tagMateriale,
                tagHaeldning, redskabsrumsbredde, redskabsrumslaengde, redskabsrumBeklaedningstype, redskabsrumGulv,
        navn, adresse, postNummer, by, tlf, email);

    }

    public static void lavForespoergselUdenRedskabsrum(int carportLaengde, int carportBredde, int carportFarve,
                                        int carportTraeType ,int tagMateriale,  int tagHaeldning,
                                        String navn, String adresse, int postNummer, String by, int tlf,
                                        String email) throws ExceptionHandler {

        CarportMapper.forespoergselListUdenRedskabrum(carportLaengde, carportBredde, carportFarve, carportTraeType, tagMateriale,
                tagHaeldning, navn, adresse, postNummer, by, tlf, email);

    }

    public static Medarbejder login(String email, String password ) throws ExceptionHandler {
        return MedarbejderMapper.login( email, password );
    }

    public static Medarbejder createEmployee(String navn, String password, String email) throws ExceptionHandler {
        Medarbejder user = new Medarbejder(navn, password, email);
        MedarbejderMapper.createEmployee( user );
        return user;
    }


}
