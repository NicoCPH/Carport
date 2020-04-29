package PresentationLayer;

import DBAccess.CarportMapper;
import FunctionLayer.ExceptionHandler;
import FunctionLayer.LogicFacade;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Forespoergsel extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ExceptionHandler {
        try {
            System.out.println("hhh");
            int carportBredde = Integer.parseInt(request.getParameter("bredde"));
            System.out.println(carportBredde);
            int carportlaengde = Integer.parseInt(request.getParameter("carportlaengde"));
            System.out.println(carportlaengde);
            int tagMatriale = Integer.parseInt(request.getParameter("tagMateriale"));
            System.out.println(tagMatriale);
            int carportFarve = Integer.parseInt(request.getParameter("carportfarve"));
            System.out.println(carportFarve);
            int carportTraetype = Integer.parseInt(request.getParameter("carporttraetype"));
            String tagHaeldning = request.getParameter("tagHaeldning");
            String tagHaeldning1 = request.getParameter("tagHaeldning");
            String redskabsrumBredde = request.getParameter("redskabsrumsbredde");
            System.out.println(redskabsrumBredde);
            String redskabsrumLaengde = request.getParameter("redskabsrumslaengde");
            System.out.println(redskabsrumLaengde);
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
