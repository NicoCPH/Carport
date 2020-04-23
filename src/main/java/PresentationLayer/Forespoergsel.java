package PresentationLayer;

import FunctionLayer.ExceptionHandler;
import FunctionLayer.LogicFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Forespoergsel extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ExceptionHandler {

        HttpSession session = request.getSession();

        int carportLaengde = (int) session.getAttribute("carportlaengde");
        int carportBredde = (int) session.getAttribute("carportbredde");
        int carportFarve = (int) session.getAttribute("carportfarve");
        int carportTraeType = (int) session.getAttribute("carporttraetype");

        int tagMateriale = (int) session.getAttribute("tagMateriale");
        int tagFarve = (int) session.getAttribute("tagfarve");
        int tagHaeldning = (int) session.getAttribute("tagHaeldning");

        int redskabsrumsbredde = (int) session.getAttribute("redskabsrumsbredde");
        int redskabsrumslaengde = (int) session.getAttribute("redskabsrumslaengde");
        int redskabsrumBeklaedningstype = (int) session.getAttribute("redskabsrumbeklaedningstype");
        int redskabsrumGulv = (int) session.getAttribute("redskabsrumGulv");

        String navn = (String) session.getAttribute("navn");
        String adresse = (String) session.getAttribute("adresse");
        int postNummer = (int) session.getAttribute("postNummer");
        String by = (String) session.getAttribute("by");
        int tlf = (int) session.getAttribute("tlf");
        String email = (String) session.getAttribute("email");

        LogicFacade.lavForespoergsel(carportLaengde, carportBredde, carportFarve, carportTraeType, tagMateriale, tagFarve, tagHaeldning,
                redskabsrumsbredde, redskabsrumslaengde, redskabsrumBeklaedningstype, redskabsrumGulv, navn, adresse,
                postNummer, by, tlf, email);

        return null;
    }
}
