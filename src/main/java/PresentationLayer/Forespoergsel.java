package PresentationLayer;

import DBAccess.CarportMapper;
import FunctionLayer.Carport_Udregner;
import FunctionLayer.ExceptionHandler;
import FunctionLayer.LogicFacade;
import MetodeBehandler.Carport_Behandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Forespoergsel extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ExceptionHandler {
        try {
            HttpSession session = request.getSession();
            System.out.println("hhh");
            int carportBredde = Integer.parseInt(request.getParameter("bredde"));
            int bredde_cm = CarportMapper.getDropdownBreddeList().get(carportBredde).getCarportBredde();
            int carportlaengde = Integer.parseInt(request.getParameter("carportlaengde"));
            int langde_cm = CarportMapper.getDropdownLaengdeList().get(carportlaengde).getCarportLaengde();

            int tagMatriale = Integer.parseInt(request.getParameter("tagMateriale"));

            int carportFarve = Integer.parseInt(request.getParameter("carportfarve"));
            System.out.println(carportFarve);
            int carportTraetype = Integer.parseInt(request.getParameter("carporttraetype"));
            System.out.println(carportTraetype);
            String tagHaeldning = request.getParameter("tagHaeldning");
            System.out.println(tagHaeldning);
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

            Carport_Behandler.PrisBehandler(bredde_cm,langde_cm,redskabsrumBredde,redskabsrumLaengde,tagHaeldning, request);
            System.out.println("du videre");
            Carport_Behandler.carportBehandler(carportBredde,carportlaengde,redskabsrumBredde,redskabsrumLaengde,tagHaeldning,
                    redskabsrumbeklaedningstype,
                    redskabsrumGulv,carportFarve,carportTraetype,tagMatriale,tlf,postNummer,by,navn,adresse,email);

            session.setAttribute("navn", navn);
            session.setAttribute("email", email);


}catch (Exception ex){
    ex.getMessage();
}
        return "Forespoergsel_Succes";
    }
}
