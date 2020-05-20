package PresentationLayer;

import DBAccess.Carport_Mapper;
import FunctionLayer.Fejl_haendtering;
import FunctionLayer.MetodeBehandler.Carport_Behandler;
import FunctionLayer.MetodeBehandler.Stykliste_Behandler;
import FunctionLayer.MetodeBehandler.Tegning_Algoritme;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Forespoergsel klassens formål er at tage en række variabler fra hjemmesidens dropdown menuer og sende dem videre til
 * databasen via. LogicFacaden klassen. Div. variabler bruges også til carportens tegning.
 */

public class Forespoergsel extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Fejl_haendtering {

        try {
            HttpSession session = request.getSession();

            int carportBredde = Integer.parseInt(request.getParameter("bredde"));
            int bredde_cm = Carport_Mapper.get_Dropdown_Bredde_List().get(carportBredde).getCarportBredde();
            int carportlaengde = Integer.parseInt(request.getParameter("carportlaengde"));
            int langde_cm = Carport_Mapper.get_Dropdown_Laengde_List().get(carportlaengde).getCarportLaengde();
            int tagMatriale = Integer.parseInt(request.getParameter("tagMateriale"));
            String tagMaterialetype = Carport_Mapper.getDropdown_Tagmatriale_List().get(tagMatriale).getType();
            int carportFarve = Integer.parseInt(request.getParameter("carportfarve"));
            int carportTraetype = Integer.parseInt(request.getParameter("carporttraetype"));
            String tagHaeldning = request.getParameter("tagHaeldning");
            String redskabsrumBredde = request.getParameter("redskabsrumsbredde");
            String redskabsrumLaengde = request.getParameter("redskabsrumslaengde");
            String redskabsrumbeklaedningstype = request.getParameter("redskabsrumbeklaedningstype");
            String redskabsrumGulv = request.getParameter("redskabsrumGulv");

            String navn = request.getParameter("navn");
            int postNummer = Integer.parseInt(request.getParameter("postNummer"));
            int tlf = Integer.parseInt(request.getParameter("tlf"));
            String email = request.getParameter("email");

            /*
            * Her tages bredden på redskabsrummet for at finde ud af om tegning skal laves med eller uden redskabsrum.
            * Hvis redskabsrummet er over halvt så langt som carporten laver den en fejl og sender dig til fejl.jsp
             */
            if (redskabsrumBredde == null) {
                Tegning_Algoritme.tegning_Uden_Redskabsrum(langde_cm, bredde_cm, request);
               double pris = Carport_Behandler.PrisBehandler(bredde_cm, langde_cm, redskabsrumBredde, redskabsrumLaengde, tagHaeldning, request);
                Carport_Behandler.carportBehandler(carportBredde, carportlaengde, redskabsrumBredde, redskabsrumLaengde, tagHaeldning,
                        redskabsrumbeklaedningstype,
                        redskabsrumGulv, carportFarve, carportTraetype, tagMatriale, tlf, postNummer,  navn,  email, pris);
                Carport_Behandler.konstruktion_beskrivelse(bredde_cm, langde_cm, redskabsrumBredde, redskabsrumLaengde, tagHaeldning, request, tagMatriale, redskabsrumbeklaedningstype, redskabsrumGulv);
            } else if (carportlaengde / 2 >= Integer.parseInt(redskabsrumLaengde) && carportBredde >= Integer.parseInt(redskabsrumBredde)) {
                double pris = Carport_Behandler.PrisBehandler(bredde_cm, langde_cm, redskabsrumBredde, redskabsrumLaengde, tagHaeldning, request);
                Carport_Behandler.carportBehandler(carportBredde, carportlaengde, redskabsrumBredde, redskabsrumLaengde, tagHaeldning,
                        redskabsrumbeklaedningstype,
                        redskabsrumGulv, carportFarve, carportTraetype, tagMatriale, tlf, postNummer,  navn,  email, pris);
                Carport_Behandler.konstruktion_beskrivelse(bredde_cm, langde_cm, redskabsrumBredde, redskabsrumLaengde, tagHaeldning, request, tagMatriale, redskabsrumbeklaedningstype, redskabsrumGulv);

                Tegning_Algoritme.tegning_Med_Redskabsrum(langde_cm, bredde_cm, request, redskabsrumLaengde, redskabsrumBredde);
            } else {
                return "Fejl";
            }

            session.setAttribute("navn", navn);
            session.setAttribute("email", email);
            session.setAttribute("stykliste", Stykliste_Behandler.styklisten(langde_cm,bredde_cm,redskabsrumbeklaedningstype,tagHaeldning,tagMaterialetype));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "Forespoergsel_Succes";

    }

}
