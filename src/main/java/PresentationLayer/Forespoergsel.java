package PresentationLayer;

import DBAccess.CarportMapper;
import FunctionLayer.Carport_Udregner;
import FunctionLayer.ExceptionHandler;
import FunctionLayer.LogicFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Forespoergsel extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ExceptionHandler {
        try {
            System.out.println("hhh");
            int carportBredde = Integer.parseInt(request.getParameter("bredde"));
            int bredde_cm = CarportMapper.getDropdownBreddeList().get(carportBredde).getCarportBredde();
            int carportlaengde = Integer.parseInt(request.getParameter("carportlaengde"));
            int langde_cm = CarportMapper.getDropdownLaengdeList().get(carportlaengde).getCarportLaengde();

            int tagMatriale = Integer.parseInt(request.getParameter("tagMateriale"));
            System.out.println(Carport_Udregner.udregning_Pris_UdenRedskab_Fladtag(langde_cm,bredde_cm));
            int carportFarve = Integer.parseInt(request.getParameter("carportfarve"));

            int carportTraetype = Integer.parseInt(request.getParameter("carporttraetype"));
            String tagHaeldning = request.getParameter("tagHaeldning");
            String tagHaeldning1 = request.getParameter("tagHaeldning");
            String redskabsrumBredde = request.getParameter("redskabsrumsbredde");
            int Rbredde_cm = CarportMapper.getDropdownBreddeList().get(Integer.parseInt(redskabsrumBredde)).getCarportBredde();
            String redskabsrumLaengde = request.getParameter("redskabsrumslaengde");
            int Rlangde_cm = CarportMapper.getDropdownLaengdeList().get(Integer.parseInt(redskabsrumLaengde)).getCarportLaengde();
            System.out.println(Carport_Udregner.udregning_Pris_MedRedskab_Fladtag(langde_cm, bredde_cm ,Rlangde_cm, Rbredde_cm));
            String redskabsrumbeklaedningstype = request.getParameter("redskabsrumbeklaedningstype");
            System.out.println(redskabsrumbeklaedningstype);
            String redskabsrumGulv = request.getParameter("redskabsrumGulv");
            System.out.println(redskabsrumGulv);

            String navn = request.getParameter("navn");
            String adresse = request.getParameter("adresse");
            int postNummer = Integer.parseInt(request.getParameter("postNummer"));
            String by = request.getParameter("by");
            int tlf = Integer.parseInt(request.getParameter("tlf"));
            String email = request.getParameter("email");



            if (redskabsrumbeklaedningstype == null && tagHaeldning == null ) {
                LogicFacade.lavForespoergselUdenRedskabsrum(carportlaengde, carportBredde, carportFarve, carportTraetype, tagMatriale,
                        8, navn, adresse, postNummer, by, tlf, email);
                System.out.println("uden RB og TH");
            } else if(redskabsrumbeklaedningstype == null) {
                int TH = Integer.parseInt(tagHaeldning);
                LogicFacade.lavForespoergselUdenRedskabsrum(carportlaengde, carportBredde, carportFarve, carportTraetype, tagMatriale,
                        TH, navn, adresse, postNummer, by, tlf, email);
                System.out.println("uden RB med TH");
            }else if (tagHaeldning == null){
                int RB = Integer.parseInt(redskabsrumBredde);
                int RL = Integer.parseInt(redskabsrumLaengde);
                int RBT = Integer.parseInt(redskabsrumbeklaedningstype);
                int RG = Integer.parseInt(redskabsrumGulv);
                LogicFacade.lavForespoergsel(carportlaengde, carportBredde, carportFarve, carportTraetype, tagMatriale,
                        8, RB, RL, RBT, RG,
                        navn, adresse, postNummer, by, tlf, email);
                System.out.println("med RB og uden TH");
            }else {
                int RB = Integer.parseInt(redskabsrumBredde);
                int RL = Integer.parseInt(redskabsrumLaengde);
                int RBT = Integer.parseInt(redskabsrumbeklaedningstype);
                int RG = Integer.parseInt(redskabsrumGulv);
                int TH = Integer.parseInt(tagHaeldning1);
                System.out.println("med RB og TH");
                LogicFacade.lavForespoergsel(carportlaengde, carportBredde, carportFarve, carportTraetype, tagMatriale,
                        TH, RB, RL, RBT, RG,
                        navn, adresse, postNummer, by, tlf, email);
            }





    HttpSession session = request.getSession();
    session.setAttribute("navn", navn);
    session.setAttribute("email", email);


}catch (Exception ex){
    ex.getMessage();
}
        return "Forespoergsel_Succes";
    }
}
