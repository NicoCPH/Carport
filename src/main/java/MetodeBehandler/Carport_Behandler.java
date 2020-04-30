package MetodeBehandler;

import DBAccess.CarportMapper;
import FunctionLayer.Carport_Udregner;
import FunctionLayer.ExceptionHandler;
import FunctionLayer.LogicFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Carport_Behandler {

    public static void carportBehandler(int bredde_cm, int laengde_cm, String rBredde, String rLaengde, String tagHaeldning,
                                        String redskabsrumbeklaedningstype, String redskabsrumGulv, int carportFarve, int carportTraetype, int  tagMatriale,
                                        int tlf, int postNummer, String by, String navn, String adresse, String email) throws ExceptionHandler {

        if (redskabsrumbeklaedningstype == null && tagHaeldning == null ) {
            LogicFacade.lavForespoergselUdenRedskabsrum(laengde_cm, bredde_cm, carportFarve, carportTraetype, tagMatriale,
                    8, navn, adresse, postNummer, by, tlf, email);
            System.out.println("uden RB og TH");
        } else if(redskabsrumbeklaedningstype == null) {
            int TH = Integer.parseInt(tagHaeldning);
            LogicFacade.lavForespoergselUdenRedskabsrum(laengde_cm, bredde_cm, carportFarve, carportTraetype, tagMatriale,
                    TH, navn, adresse, postNummer, by, tlf, email);
            System.out.println("uden RB med TH");
        }else if (tagHaeldning == null){
            int RB = Integer.parseInt(rBredde);
            int RL = Integer.parseInt(rLaengde);
            int RBT = Integer.parseInt(redskabsrumbeklaedningstype);
            int RG = Integer.parseInt(redskabsrumGulv);
            LogicFacade.lavForespoergsel(laengde_cm, bredde_cm, carportFarve, carportTraetype, tagMatriale,
                    8, RB, RL, RBT, RG,
                    navn, adresse, postNummer, by, tlf, email);

            System.out.println("med RB og uden TH");
        }else {
            int RB = Integer.parseInt(rBredde);
            int RL = Integer.parseInt(rLaengde);
            int RBT = Integer.parseInt(redskabsrumbeklaedningstype);
            int RG = Integer.parseInt(redskabsrumGulv);
            int TH = Integer.parseInt(tagHaeldning);
            System.out.println("med RB og TH");
            LogicFacade.lavForespoergsel(laengde_cm, bredde_cm, carportFarve, carportTraetype, tagMatriale,
                    TH, RB, RL, RBT, RG,
                    navn, adresse, postNummer, by, tlf, email);
        }
    }


    public static void PrisBehandler(int bredde_cm, int laengde_cm, String rBredde, String rLaengde, String tagHaeldning, HttpServletRequest request){
        HttpSession session = request.getSession();
        if (rBredde == null && tagHaeldning == null ) {
            double URFLT = Carport_Udregner.udregning_Pris_UdenRedskab_Fladtag(laengde_cm,bredde_cm);
            session.setAttribute("pris", URFLT);
            System.out.println("uden RB og TH");
        } else if(rBredde == null) {
            int TH = Integer.parseInt(tagHaeldning);
            int TH_final = CarportMapper.getDropdownHaeldningList().get(TH).getHaeldning();
            double MRTH = Carport_Udregner.udregning_Pris_UdenRedskab_Rejsning(laengde_cm, bredde_cm, TH_final);
            session.setAttribute("pris", MRTH);
            System.out.println("uden RB med TH");
        }else if (tagHaeldning == null){
            int Rlangde_cm = CarportMapper.getDropdownLaengdeList().get(Integer.parseInt(rLaengde)).getCarportLaengde();
            int Rbredde_cm = CarportMapper.getDropdownBreddeList().get(Integer.parseInt(rBredde)).getCarportBredde();
            double MRFLT = Carport_Udregner.udregning_Pris_MedRedskab_Fladtag(laengde_cm, bredde_cm, Rlangde_cm, Rbredde_cm);
            session.setAttribute("pris", MRFLT);
            System.out.println("med RB og uden TH");
        }else {
            int Rlangde_cm = CarportMapper.getDropdownLaengdeList().get(Integer.parseInt(rLaengde)).getCarportLaengde();
            int Rbredde_cm = CarportMapper.getDropdownBreddeList().get(Integer.parseInt(rBredde)).getCarportBredde();
            int TH = Integer.parseInt(tagHaeldning);
            int TH_final = CarportMapper.getDropdownHaeldningList().get(TH).getHaeldning();
            double MRTH = Carport_Udregner.udregning_Pris_MedRedskab_Rejsning(laengde_cm, bredde_cm, Rlangde_cm, Rbredde_cm, TH_final);
            session.setAttribute("pris", MRTH);
            System.out.println("med RB og TH");
        }
    }

    public static void konstruktion_beskrivelse(){
        


    }

}
