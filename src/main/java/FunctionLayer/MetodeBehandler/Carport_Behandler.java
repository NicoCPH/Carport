package FunctionLayer.MetodeBehandler;

import DBAccess.CarportMapper;
import FunctionLayer.Fejl_haendtering;
import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Carport_Behandler {

    public static void carportBehandler(int bredde_cm, int laengde_cm, String rBredde, String rLaengde, String tagHaeldning,
                                        String redskabsrumbeklaedningstype, String redskabsrumGulv, int carportFarve, int carportTraetype, int tagMatriale,
                                        int tlf, int postNummer, String by, String navn, String adresse, String email) throws Fejl_haendtering {

        if (redskabsrumbeklaedningstype == null && tagHaeldning == null ) {
            LogicFacade.lavForespoergsel_UdenRedskabsrum(laengde_cm, bredde_cm, carportFarve, carportTraetype, tagMatriale,
                    8, navn, adresse, postNummer, by, tlf, email);

        } else if(redskabsrumbeklaedningstype == null) {
            int TH = Integer.parseInt(tagHaeldning);
            LogicFacade.lavForespoergsel_UdenRedskabsrum(laengde_cm, bredde_cm, carportFarve, carportTraetype, tagMatriale,
                    TH, navn, adresse, postNummer, by, tlf, email);

        }else if (tagHaeldning == null){
            int RB = Integer.parseInt(rBredde);
            int RL = Integer.parseInt(rLaengde);
            int RBT = Integer.parseInt(redskabsrumbeklaedningstype);
            int RG = Integer.parseInt(redskabsrumGulv);
            LogicFacade.lav_Forespoergsel(laengde_cm, bredde_cm, carportFarve, carportTraetype, tagMatriale,
                    8, RB, RL, RBT, RG,
                    navn, adresse, postNummer, by, tlf, email);

        }else {
            int RB = Integer.parseInt(rBredde);
            int RL = Integer.parseInt(rLaengde);
            int RBT = Integer.parseInt(redskabsrumbeklaedningstype);
            int RG = Integer.parseInt(redskabsrumGulv);
            int TH = Integer.parseInt(tagHaeldning);
            LogicFacade.lav_Forespoergsel(laengde_cm, bredde_cm, carportFarve, carportTraetype, tagMatriale,
                    TH, RB, RL, RBT, RG,
                    navn, adresse, postNummer, by, tlf, email);
        }
    }


    public static void PrisBehandler(int bredde_cm, int laengde_cm, String rBredde, String rLaengde, String tagHaeldning, HttpServletRequest request){
        HttpSession session = request.getSession();
        if (rBredde == null && tagHaeldning == null ) {
            double URFLT = Carport_Udregner.udregning_Pris_UdenRedskab_Fladtag(laengde_cm,bredde_cm);
            session.setAttribute("pris", URFLT);

        } else if(rBredde == null) {
            int TH = Integer.parseInt(tagHaeldning);
            int TH_final = CarportMapper.getDropdown_Haeldning_List().get(TH).getHaeldning();
            double MRTH = Carport_Udregner.udregning_Pris_UdenRedskab_Rejsning(laengde_cm, bredde_cm, TH_final);
            session.setAttribute("pris", MRTH);

        }else if (tagHaeldning == null){
            int Rlangde_cm = CarportMapper.get_Dropdown_Laengde_List().get(Integer.parseInt(rLaengde)).getCarportLaengde();
            int Rbredde_cm = CarportMapper.get_Dropdown_Bredde_List().get(Integer.parseInt(rBredde)).getCarportBredde();
            double MRFLT = Carport_Udregner.udregning_Pris_MedRedskab_Fladtag(laengde_cm, bredde_cm, Rlangde_cm, Rbredde_cm);
            session.setAttribute("pris", MRFLT);

        }else {
            int Rlangde_cm = CarportMapper.get_Dropdown_Laengde_List().get(Integer.parseInt(rLaengde)).getCarportLaengde();
            int Rbredde_cm = CarportMapper.get_Dropdown_Bredde_List().get(Integer.parseInt(rBredde)).getCarportBredde();
            int TH = Integer.parseInt(tagHaeldning);
            int TH_final = CarportMapper.getDropdown_Haeldning_List().get(TH).getHaeldning();
            double MRTH = Carport_Udregner.udregning_Pris_MedRedskab_Rejsning(laengde_cm, bredde_cm, Rlangde_cm, Rbredde_cm, TH_final);
            session.setAttribute("pris", MRTH);

        }
    }

    public static void konstruktion_beskrivelse(int bredde_cm, int laengde_cm, String rBredde, String rLaengde, String tagHaeldning,
                                                HttpServletRequest request, int tagmatriale, String redskabsrumbeklaedningstype, String redskabsrumGulv){
        HttpSession session = request.getSession();
        if (rBredde == null && tagHaeldning == null ) {
           double langde_m = (double) laengde_cm/100;
           double bredde_m = (double) bredde_cm/100;
           String tag = CarportMapper.getDropdown_Tagmatriale_List().get(tagmatriale).getType();

           String beskrivelse = "Carport mål: L:" + langde_m + "m B:"+ bredde_m + "m<br> <br> " + "Tag: <br>" + "Spærtype: Spær uden rejsning <br>" +
                    "Tagmatriale: " + tag;
            session.setAttribute("beskrivelse", beskrivelse);

        } else if(rBredde == null) {
            double langde_m = (double) laengde_cm/100;
            double bredde_m = (double) bredde_cm/100;
            String tag = CarportMapper.getDropdown_Tagmatriale_List().get(tagmatriale).getType();


            String beskrivelse = "Carport mål: L:" + langde_m + "m B:"+ bredde_m + "m<br> <br> " + "Tag: <br>" + "Spærtype: Spær med rejsning <br>" +
                    "Tagmatriale: " + tag;
            session.setAttribute("beskrivelse",beskrivelse);

        }else if (tagHaeldning == null){
            double langde_m = (double) laengde_cm/100;
            double bredde_m = (double) bredde_cm/100;
            double rlangde_1 = CarportMapper.get_Dropdown_Laengde_List().get(Integer.parseInt(rLaengde)).getCarportLaengde();
            double rlangde_m = rlangde_1/100;
            double rbredde_1 = CarportMapper.get_Dropdown_Bredde_List().get(Integer.parseInt(rBredde)).getCarportBredde();
            double rbredde_m = rbredde_1/100;
            String tag = CarportMapper.getDropdown_Tagmatriale_List().get(tagmatriale).getType();
            String RBT = CarportMapper.get_Dropdown_Traetype_List().get(Integer.parseInt(redskabsrumbeklaedningstype)).getCarporttraeType();
            String RG = CarportMapper.getDropdown_Gulv_List().get(Integer.parseInt(redskabsrumGulv)).getGulv();

            String beskrivelse = "Carport mål: L: " + langde_m + "m B: "+ bredde_m + "m<br> <br> " + "Redskabsrum: "
                    + "L: " + rlangde_m + " B: " + rbredde_m+ "<br> BeklædningsType: " + RBT + "<br> Redskabsrum Gulv: " + RG + "<br><br> Tag: <br>" + "Spærtype: Spær uden rejsning<br>" +
                    "Tagmatriale: " + tag;
            session.setAttribute("beskrivelse",beskrivelse);

        }else {
            double langde_m = (double) laengde_cm/100;
            double bredde_m = (double) bredde_cm/100;
            double rlangde_1 = CarportMapper.get_Dropdown_Laengde_List().get(Integer.parseInt(rLaengde)).getCarportLaengde();
            double rlangde_m = rlangde_1/100;
            double rbredde_1 = CarportMapper.get_Dropdown_Bredde_List().get(Integer.parseInt(rBredde)).getCarportBredde();
            double rbredde_m = rbredde_1/100;
            String tag = CarportMapper.getDropdown_Tagmatriale_List().get(tagmatriale).getType();
            String RBT = CarportMapper.get_Dropdown_Traetype_List().get(Integer.parseInt(redskabsrumbeklaedningstype)).getCarporttraeType();
            String RG = CarportMapper.getDropdown_Gulv_List().get(Integer.parseInt(redskabsrumGulv)).getGulv();

            String beskrivelse = "Carport mål: L: " + langde_m + "m B: "+ bredde_m + "m<br> <br> <br>" + "Redskabsrum: "
                    + "L: " + rlangde_m + " B: "+ rbredde_m+ "<br> BeklædningsType: " + RBT + "<br> Redskabsrum Gulv: " + RG + "<br><br> Tag: <br>" + "Spærtype: Spær med rejsning<br>" +
                    "Tagmatriale: " + tag;
            session.setAttribute("beskrivelse",beskrivelse);
        }


    }

}
