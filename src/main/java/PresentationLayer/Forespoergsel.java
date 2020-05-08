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

import java.util.HashMap;


public class Forespoergsel extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ExceptionHandler {

        Svg svg = new Svg(800, 600, "0,0,800,600",0,0); // (ramme)

        try {
            HttpSession session = request.getSession();

            int carportBredde = Integer.parseInt(request.getParameter("bredde"));
            int bredde_cm = CarportMapper.getDropdownBreddeList().get(carportBredde).getCarportBredde();
            int carportlaengde = Integer.parseInt(request.getParameter("carportlaengde"));
            int langde_cm = CarportMapper.getDropdownLaengdeList().get(carportlaengde).getCarportLaengde();
            int tagMatriale = Integer.parseInt(request.getParameter("tagMateriale"));
            String tagMaterialetype = CarportMapper.getDropdownTagmatrialeList().get(tagMatriale).getType();
            int carportFarve = Integer.parseInt(request.getParameter("carportfarve"));
            int carportTraetype = Integer.parseInt(request.getParameter("carporttraetype"));
            String tagHaeldning = request.getParameter("tagHaeldning");
            String redskabsrumBredde = request.getParameter("redskabsrumsbredde");
            String redskabsrumLaengde = request.getParameter("redskabsrumslaengde");
            String redskabsrumbeklaedningstype = request.getParameter("redskabsrumbeklaedningstype");
            String redskabsrumGulv = request.getParameter("redskabsrumGulv");

            System.out.println(tagMaterialetype);
            String result1 = Stykliste.tag_Omregner_beskrivelse(tagMaterialetype);
            System.out.println(result1);
            Materiale result = Stykliste.rem_Omregner(bredde_cm);
            System.out.println(result.getLaengde());
            String result2 = Stykliste.stolpe_Omregner_beskrivlese();
            System.out.println(result2);
            System.out.println(Stykliste.spaer_Omregner(langde_cm));
            System.out.println(Stykliste.stolpe_Omregner(redskabsrumbeklaedningstype, tagHaeldning));


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


                if (carportlaengde / 2 >= Integer.parseInt(redskabsrumLaengde) && carportBredde >= Integer.parseInt(redskabsrumBredde)) {

                Carport_Behandler.PrisBehandler(bredde_cm, langde_cm, redskabsrumBredde, redskabsrumLaengde, tagHaeldning, request);
                Carport_Behandler.carportBehandler(carportBredde, carportlaengde, redskabsrumBredde, redskabsrumLaengde, tagHaeldning,
                        redskabsrumbeklaedningstype,
                        redskabsrumGulv, carportFarve, carportTraetype, tagMatriale, tlf, postNummer, by, navn, adresse, email);
                Carport_Behandler.konstruktion_beskrivelse(bredde_cm, langde_cm, redskabsrumBredde, redskabsrumLaengde,

                        tagHaeldning, request, tagMatriale, redskabsrumbeklaedningstype, redskabsrumGulv);

                FunctionLayer.TegningAlgoritme.tegning(langde_cm, bredde_cm, request, redskabsrumbeklaedningstype, redskabsrumLaengde, redskabsrumBredde);

                session.setAttribute("navn", navn);
                session.setAttribute("email", email);

            } else {
                    return "Fejl";
                }
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        return "Forespoergsel_Succes";

    }

}
