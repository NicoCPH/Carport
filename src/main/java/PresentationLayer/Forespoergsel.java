package PresentationLayer;

import DBAccess.CarportMapper;
import DBAccess.StyklisteMapper;
import FunctionLayer.ExceptionHandler;
import FunctionLayer.MetodeBehandler.Carport_Behandler;
import FunctionLayer.MetodeBehandler.Tegning_Behandler;
import FunctionLayer.Objekter.Materiale;
import FunctionLayer.Objekter.Stykliste;
import FunctionLayer.Svg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collection;

public class Forespoergsel extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ExceptionHandler {
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

            System.out.println("MIT LUDER ID ER : " + carportBredde);
            Materiale result = Stykliste.rem_Omregner(bredde_cm);
            System.out.println("I SKAL BARE FUCKING LAVE DEN USER STORY SOM PO SIGER DET!!!!!");
            System.out.println("RESULT MATERIALE LÆNGDE DIN FUCKING HUND!!!! : " + result.getLaengde());

            String navn = request.getParameter("navn");
            String adresse = request.getParameter("adresse");
            int postNummer = Integer.parseInt(request.getParameter("postNummer"));
            String by = request.getParameter("by");
            int tlf = Integer.parseInt(request.getParameter("tlf"));
            String email = request.getParameter("email");
            Carport_Behandler.PrisBehandler(bredde_cm, langde_cm, redskabsrumBredde, redskabsrumLaengde, tagHaeldning, request);
            Carport_Behandler.carportBehandler(carportBredde, carportlaengde, redskabsrumBredde, redskabsrumLaengde, tagHaeldning,
                    redskabsrumbeklaedningstype,
                    redskabsrumGulv, carportFarve, carportTraetype, tagMatriale, tlf, 2765, by, navn, adresse, email);
            Carport_Behandler.konstruktion_beskrivelse(bredde_cm, langde_cm, redskabsrumBredde, redskabsrumLaengde,
                        tagHaeldning, request, tagMatriale, redskabsrumbeklaedningstype, redskabsrumGulv);




            session.setAttribute("navn", navn);
            session.setAttribute("email", email);


        } catch (Exception ex) {
           ex.printStackTrace();
        }
        return "Forespoergsel_Succes";

    }
}
