package FunctionLayer.MetodeBehandler;

import FunctionLayer.Objekter.Stykliste;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class StyklisteBehandler {

    public static void styklisteBehandler(int laengde, int bredde, String redskabsrumbeklaedningstype, String tagHaeldning, HttpServletRequest request){
        Stykliste.spaer_Omregner(laengde);
        Stykliste.stolpe_Omregner(redskabsrumbeklaedningstype,tagHaeldning);


    }

}
