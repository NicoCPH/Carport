package FunctionLayer;


import DBAccess.CarportMapper;

import java.util.List;


/**
 * Her sætter vi alt ind der har noget at gøre med database, som skal bruges i vores kode.
 * @author Nicolas
 */
public class LogicFacade {

    public static void lavForespoergsel(int carportLaengde, int carportBredde, int carportFarve,
                                        int carportTraeType ,int tagMateriale, int tagFarve, int tagHaeldning, int redskabsrumsbredde,
                                         int redskabsrumslaengde, int redskabsrumBeklaedningstype, int redskabsrumGulv,
                                        String navn, String adresse, int postNummer, String by, int tlf,
                                        String email) throws ExceptionHandler {

        CarportMapper.forespoergselList(carportLaengde, carportBredde, carportFarve, carportTraeType, tagMateriale, tagFarve,
                tagHaeldning, redskabsrumsbredde, redskabsrumslaengde, redskabsrumBeklaedningstype, redskabsrumGulv,
        navn, adresse, postNummer, by, tlf, email);

    }

    public static void lavForespoergselUdenRedskabsrum(int carportLaengde, int carportBredde, int carportFarve,
                                        int carportTraeType ,int tagMateriale, int tagFarve, int tagHaeldning,
                                        String navn, String adresse, int postNummer, String by, int tlf,
                                        String email) throws ExceptionHandler {

        CarportMapper.forespoergselListUdenRedskabrum(carportLaengde, carportBredde, carportFarve, carportTraeType, tagMateriale, tagFarve,
                tagHaeldning, navn, adresse, postNummer, by, tlf, email);

    }
}
