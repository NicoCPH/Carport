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
    System.out.println("44");
    int carportBredde = Integer.parseInt(request.getParameter("bredde"));
    System.out.println("cb" + carportBredde);
    int carportlaengde = Integer.parseInt(request.getParameter("carportlaengde"));
    System.out.println("CL"  + carportlaengde);
    int tagMatriale = Integer.parseInt(request.getParameter("tagMateriale"));
    System.out.println("TM" + tagMatriale);
    int carportFarve = Integer.parseInt(request.getParameter("carportfarve"));
    System.out.println("CF" + carportFarve);
    int tagFarve = Integer.parseInt(request.getParameter("tagfarve"));
    System.out.println("TF" + tagFarve);
    int carportTraetype = Integer.parseInt(request.getParameter("carporttraetype"));
    System.out.println("TT" + carportTraetype);
    int redskabsrumBredde = Integer.parseInt(request.getParameter("redskabsrumsbredde"));
    System.out.println("RB" + redskabsrumBredde);
    int redskabsrumLaengde = Integer.parseInt(request.getParameter("redskabsrumslaengde"));
    System.out.println("RL" + redskabsrumLaengde);
    int redskabsrumbeklaedningstype = Integer.parseInt(request.getParameter("redskabsrumbeklaedningstype"));
    System.out.println("RBT" + redskabsrumbeklaedningstype);
    int redskabsrumGulv = Integer.parseInt(request.getParameter("redskabsrumGulv"));
    System.out.println("RG" + redskabsrumbeklaedningstype);
    String navn = request.getParameter("navn");
    String adresse = request.getParameter("adresse");
    int postNummer = Integer.parseInt(request.getParameter("postNummer"));
    String by = request.getParameter("by");
    int tlf = Integer.parseInt(request.getParameter("tlf"));
    String email = request.getParameter("email");


    System.out.println(navn + adresse + postNummer + by + tlf + email);

    LogicFacade.lavForespoergsel(carportlaengde, carportBredde, carportFarve, carportTraetype, tagMatriale, tagFarve,
            tagMatriale, redskabsrumBredde, redskabsrumLaengde, redskabsrumbeklaedningstype, redskabsrumGulv,
            navn, adresse, postNummer, by, tlf, email);


}catch (Exception ex){
    ex.getMessage();
}
        return "index";
    }
}
