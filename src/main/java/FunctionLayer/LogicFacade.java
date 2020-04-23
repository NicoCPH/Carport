package FunctionLayer;


import DBAccess.CarportMapper;

import java.util.List;

/**
 * Her sætter vi alt ind der har noget at gøre med database, som skal bruges i vores kode.
 * @author Nicolas
 */
public class LogicFacade {

    public static void lavForespoergsel(int tagType, int tagFarve, int tagHaeldning, int redskabsrumsbredde,
                                         int redskabsrumslaengde, int redskabsrumBeklaedningstype, int redskabsrumGulv,
                                        String navn, String adresse, int postNummer, String by, int tlf,
                                        String email, int carportLaengde, int carportBredde, int carportFarve,
                                        int traeType) throws ExceptionHandler {

        CarportMapper.forespoergselList(tagType, tagFarve, tagHaeldning, redskabsrumsbredde,
        redskabsrumslaengde, redskabsrumBeklaedningstype, redskabsrumGulv,
        navn, adresse, postNummer, by, tlf, email, carportLaengde, carportBredde, carportFarve, traeType);

    }

}
