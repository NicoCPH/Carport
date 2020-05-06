package PresentationLayer;

import DBAccess.CarportMapper;
import FunctionLayer.ExceptionHandler;
import FunctionLayer.MetodeBehandler.Carport_Behandler;
import FunctionLayer.Svg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class Forespoergsel extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ExceptionHandler {

        Svg svg = new Svg(800, 600, "0,0,800,600",0,0); // (ramme)
        svg.addRect(0,0,600,780); // øverste boks linje

        try {
            HttpSession session = request.getSession();

            int carportBredde = Integer.parseInt(request.getParameter("bredde"));
            int bredde_cm = CarportMapper.getDropdownBreddeList().get(carportBredde).getCarportBredde();
            int carportlaengde = Integer.parseInt(request.getParameter("carportlaengde"));
            int langde_cm = CarportMapper.getDropdownLaengdeList().get(carportlaengde).getCarportLaengde();
            int tagMatriale = Integer.parseInt(request.getParameter("tagMateriale"));
            int carportFarve = Integer.parseInt(request.getParameter("carportfarve"));
            int carportTraetype = Integer.parseInt(request.getParameter("carporttraetype"));
            String tagHaeldning = request.getParameter("tagHaeldning");
            String redskabsrumBredde = request.getParameter("redskabsrumsbredde");
            String redskabsrumLaengde = request.getParameter("redskabsrumslaengde");
            String redskabsrumbeklaedningstype = request.getParameter("redskabsrumbeklaedningstype");
            String redskabsrumGulv = request.getParameter("redskabsrumGulv");


            String navn = request.getParameter("navn");
            String adresse = request.getParameter("adresse");
            int postNummer = Integer.parseInt(request.getParameter("postNummer"));
            String by = request.getParameter("by");
            int tlf = Integer.parseInt(request.getParameter("tlf"));
            String email = request.getParameter("email");

            Carport_Behandler.PrisBehandler(bredde_cm, langde_cm, redskabsrumBredde, redskabsrumLaengde, tagHaeldning, request);
            Carport_Behandler.carportBehandler(carportBredde, carportlaengde, redskabsrumBredde, redskabsrumLaengde, tagHaeldning,
                    redskabsrumbeklaedningstype,
                    redskabsrumGulv, carportFarve, carportTraetype, tagMatriale, tlf, postNummer, by, navn, adresse, email);
            Carport_Behandler.konstruktion_beskrivelse(bredde_cm, langde_cm, redskabsrumBredde, redskabsrumLaengde,
                        tagHaeldning, request, tagMatriale, redskabsrumbeklaedningstype, redskabsrumGulv);

            FunctionLayer.TegningAlgoritme.tegning(langde_cm,bredde_cm, request);
            session.setAttribute("navn", navn);
            session.setAttribute("email", email);

        } catch (Exception ex) {
           ex.printStackTrace();
        }
        return "Forespoergsel_Succes";

    }

}
