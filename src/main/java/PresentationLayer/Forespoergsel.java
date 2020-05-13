package PresentationLayer;

import DBAccess.CarportMapper;
import FunctionLayer.Fejl_haendtering;
import FunctionLayer.MetodeBehandler.Carport_Behandler;
import FunctionLayer.Objekter.Stykliste;
import FunctionLayer.Svg;
import FunctionLayer.Tegning_Algoritme;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Forespoergsel extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Fejl_haendtering {

        Svg svg = new Svg(800, 600, "0,0,800,600",0,0); // (ramme)

        try {
            HttpSession session = request.getSession();


            int carportBredde = Integer.parseInt(request.getParameter("bredde"));
            int bredde_cm = CarportMapper.get_Dropdown_Bredde_List().get(carportBredde).getCarportBredde();
            int carportlaengde = Integer.parseInt(request.getParameter("carportlaengde"));
            int langde_cm = CarportMapper.get_Dropdown_Laengde_List().get(carportlaengde).getCarportLaengde();
            int tagMatriale = Integer.parseInt(request.getParameter("tagMateriale"));
            String tagMaterialetype = CarportMapper.getDropdown_Tagmatriale_List().get(tagMatriale).getType();
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


            if (redskabsrumBredde == null) {
                Tegning_Algoritme.tegning_Uden_Redskabsrum(langde_cm, bredde_cm, request);
               double pris = Carport_Behandler.PrisBehandler(bredde_cm, langde_cm, redskabsrumBredde, redskabsrumLaengde, tagHaeldning, request);
                Carport_Behandler.carportBehandler(carportBredde, carportlaengde, redskabsrumBredde, redskabsrumLaengde, tagHaeldning,
                        redskabsrumbeklaedningstype,
                        redskabsrumGulv, carportFarve, carportTraetype, tagMatriale, tlf, postNummer, by, navn, adresse, email, pris);
                Carport_Behandler.konstruktion_beskrivelse(bredde_cm, langde_cm, redskabsrumBredde, redskabsrumLaengde, tagHaeldning, request, tagMatriale, redskabsrumbeklaedningstype, redskabsrumGulv);
            } else if (carportlaengde / 2 >= Integer.parseInt(redskabsrumLaengde) && carportBredde >= Integer.parseInt(redskabsrumBredde)) {
                double pris = Carport_Behandler.PrisBehandler(bredde_cm, langde_cm, redskabsrumBredde, redskabsrumLaengde, tagHaeldning, request);
                Carport_Behandler.carportBehandler(carportBredde, carportlaengde, redskabsrumBredde, redskabsrumLaengde, tagHaeldning,
                        redskabsrumbeklaedningstype,
                        redskabsrumGulv, carportFarve, carportTraetype, tagMatriale, tlf, postNummer, by, navn, adresse, email, pris);
                Carport_Behandler.konstruktion_beskrivelse(bredde_cm, langde_cm, redskabsrumBredde, redskabsrumLaengde, tagHaeldning, request, tagMatriale, redskabsrumbeklaedningstype, redskabsrumGulv);

                Tegning_Algoritme.tegning_Med_Redskabsrum(langde_cm, bredde_cm, request, redskabsrumLaengde, redskabsrumBredde);
            } else {
                return "Fejl";
            }

            session.setAttribute("navn", navn);
            session.setAttribute("email", email);
            session.setAttribute("stykliste", Stykliste.styklisten(langde_cm,bredde_cm,redskabsrumbeklaedningstype,tagHaeldning,tagMaterialetype));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "Forespoergsel_Succes";

    }

}
