package FunctionLayer.MetodeBehandler;

import DBAccess.Carport_Mapper;
import FunctionLayer.Fejl_haendtering;
import FunctionLayer.LogicFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Carport_Behandler {

    /**
     *Metoden her behandler alt input fra brugeren og derefter vælger hvilken type carport der skal indsættes i databasen,alt efter om den har
     * Hældning eller ej og med eller uden redskabsrum.
     *
     * @param adresse adressen
     * @param bredde_cm bredde i cm
     * @param by by
     * @param carportFarve carport farven
     * @param carportTraetype carport trætype
     * @param email kunde email
     * @param laengde_cm længde i cm
     * @param navn kunde navn
     * @param postNummer kunde postnummer
     * @param pris pris på tilbud
     * @param rBredde redskabs bredde
     * @param redskabsrumbeklaedningstype redskabs beklædningstype
     * @param redskabsrumGulv redskabs gulv
     * @param rLaengde redskabs længde
     * @param tagHaeldning hældning på taget
     * @param tagMatriale tag matriale
     * @param tlf kunde tlf
     * @throws Fejl_haendtering
     */
    public static void carportBehandler(int bredde_cm, int laengde_cm, String rBredde, String rLaengde, String tagHaeldning,
                                        String redskabsrumbeklaedningstype, String redskabsrumGulv, int carportFarve, int carportTraetype, int tagMatriale,
                                        int tlf, int postNummer, String by, String navn, String adresse, String email, double pris) throws Fejl_haendtering {

        if (redskabsrumbeklaedningstype == null && tagHaeldning == null ) {
            LogicFacade.lav_Forespoergsel(laengde_cm, bredde_cm, carportFarve, carportTraetype, tagMatriale,
                    8, 20, 22, 7, 4,
                    navn, adresse, postNummer, by, tlf, email, pris);

        } else if(redskabsrumbeklaedningstype == null) {
            int TH = Integer.parseInt(tagHaeldning);
            LogicFacade.lav_Forespoergsel(laengde_cm, bredde_cm, carportFarve, carportTraetype, tagMatriale,
                    TH, 20, 22, 7, 4,
                    navn, adresse, postNummer, by, tlf, email, pris);
        }else if (tagHaeldning == null){
            int RB = Integer.parseInt(rBredde);
            int RL = Integer.parseInt(rLaengde);
            int RBT = Integer.parseInt(redskabsrumbeklaedningstype);
            int RG = Integer.parseInt(redskabsrumGulv);
            LogicFacade.lav_Forespoergsel(laengde_cm, bredde_cm, carportFarve, carportTraetype, tagMatriale,
                    8, RB, RL, RBT, RG,
                    navn, adresse, postNummer, by, tlf, email, pris);

        }else {
            int RB = Integer.parseInt(rBredde);
            int RL = Integer.parseInt(rLaengde);
            int RBT = Integer.parseInt(redskabsrumbeklaedningstype);
            int RG = Integer.parseInt(redskabsrumGulv);
            int TH = Integer.parseInt(tagHaeldning);
            LogicFacade.lav_Forespoergsel(laengde_cm, bredde_cm, carportFarve, carportTraetype, tagMatriale,
                    TH, RB, RL, RBT, RG,
                    navn, adresse, postNummer, by, tlf, email, pris);
        }
    }

    /**
     *Metoden her behandler alt input fra brugern, og vælger derefter hvilken metode den skal ind i for at beregne den rigtige pris til brugern.
     * alt efter om der er hældning, med eller uden redskabsrum
     *
     * @param bredde_cm bredde i cm
     * @param laengde_cm længde i cm
     * @param rBredde redskabs bredde
     * @param rLaengde redskabs længde
     * @param tagHaeldning hældning på taget
     * @param request finder sessionen
     * @return double
     */
    public static double PrisBehandler(int bredde_cm, int laengde_cm, String rBredde, String rLaengde, String tagHaeldning, HttpServletRequest request){
        HttpSession session = request.getSession();
        if (rBredde == null && tagHaeldning == null ) {
            double URFLT = Carport_Udregner.udregning_Pris_UdenRedskab_Fladtag(laengde_cm,bredde_cm);
            session.setAttribute("pris", URFLT);
            return URFLT;

        } else if(rBredde == null) {
            int TH = Integer.parseInt(tagHaeldning);
            int TH_final = Carport_Mapper.getDropdown_Haeldning_List().get(TH).getHaeldning();
            double MRTH = Carport_Udregner.udregning_Pris_UdenRedskab_Rejsning(laengde_cm, bredde_cm, TH_final);
            session.setAttribute("pris", MRTH);
            return MRTH;

        }else if (tagHaeldning == null){
            int Rlangde_cm = Carport_Mapper.get_Dropdown_Laengde_List().get(Integer.parseInt(rLaengde)).getCarportLaengde();
            int Rbredde_cm = Carport_Mapper.get_Dropdown_Bredde_List().get(Integer.parseInt(rBredde)).getCarportBredde();
            double MRFLT = Carport_Udregner.udregning_Pris_MedRedskab_Fladtag(laengde_cm, bredde_cm, Rlangde_cm, Rbredde_cm);
            session.setAttribute("pris", MRFLT);
            return MRFLT;

        }else {
            int Rlangde_cm = Carport_Mapper.get_Dropdown_Laengde_List().get(Integer.parseInt(rLaengde)).getCarportLaengde();
            int Rbredde_cm = Carport_Mapper.get_Dropdown_Bredde_List().get(Integer.parseInt(rBredde)).getCarportBredde();
            int TH = Integer.parseInt(tagHaeldning);
            int TH_final = Carport_Mapper.getDropdown_Haeldning_List().get(TH).getHaeldning();
            double MRTH = Carport_Udregner.udregning_Pris_MedRedskab_Rejsning(laengde_cm, bredde_cm, Rlangde_cm, Rbredde_cm, TH_final);
            session.setAttribute("pris", MRTH);
            return MRTH;

        }
    }



    /**
     *Metoden her behandler alt input fra brugeren og derefter vælger hvordan vores konstruktions beskrivelse skal se ud.
     *
     *
     * @param bredde_cm bredde i cm
     * @param laengde_cm længde i cm
     * @param rBredde redskabs bredde
     * @param redskabsrumbeklaedningstype redskabs beklædningstype
     * @param redskabsrumGulv redskabs gulv
     * @param rLaengde redskabs længde
     * @param tagHaeldning hældning på taget
     * @param tagmatriale tag matriale
     * @param request finder sessionen
     */
    public static void konstruktion_beskrivelse(int bredde_cm, int laengde_cm, String rBredde, String rLaengde, String tagHaeldning,
                                                HttpServletRequest request, int tagmatriale, String redskabsrumbeklaedningstype, String redskabsrumGulv){
        HttpSession session = request.getSession();
        if (rBredde == null && tagHaeldning == null ) {
           double langde_m = (double) laengde_cm/100;
           double bredde_m = (double) bredde_cm/100;
           String tag = Carport_Mapper.getDropdown_Tagmatriale_List().get(tagmatriale).getType();

           String beskrivelse = "Carport mål: L:" + langde_m + "m B:"+ bredde_m + "m<br> <br> " + "Tag: <br>" + "Spærtype: Spær uden rejsning <br>" +
                    "Tagmatriale: " + tag;
            session.setAttribute("beskrivelse", beskrivelse);

        } else if(rBredde == null) {
            double langde_m = (double) laengde_cm/100;
            double bredde_m = (double) bredde_cm/100;
            String tag = Carport_Mapper.getDropdown_Tagmatriale_List().get(tagmatriale).getType();


            String beskrivelse = "Carport mål: L:" + langde_m + "m B:"+ bredde_m + "m<br> <br> " + "Tag: <br>" + "Spærtype: Spær med rejsning <br>" +
                    "Tagmatriale: " + tag;
            session.setAttribute("beskrivelse",beskrivelse);

        }else if (tagHaeldning == null){
            double langde_m = (double) laengde_cm/100;
            double bredde_m = (double) bredde_cm/100;
            double rlangde_1 = Carport_Mapper.get_Dropdown_Laengde_List().get(Integer.parseInt(rLaengde)).getCarportLaengde();
            double rlangde_m = rlangde_1/100;
            double rbredde_1 = Carport_Mapper.get_Dropdown_Bredde_List().get(Integer.parseInt(rBredde)).getCarportBredde();
            double rbredde_m = rbredde_1/100;
            String tag = Carport_Mapper.getDropdown_Tagmatriale_List().get(tagmatriale).getType();
            String RBT = Carport_Mapper.get_Dropdown_Traetype_List().get(Integer.parseInt(redskabsrumbeklaedningstype)).getCarporttraeType();
            String RG = Carport_Mapper.getDropdown_Gulv_List().get(Integer.parseInt(redskabsrumGulv)).getGulv();

            String beskrivelse = "Carport mål: L: " + langde_m + "m B: "+ bredde_m + "m<br> <br> " + "Redskabsrum: "
                    + "L: " + rlangde_m + " B: " + rbredde_m+ "<br> BeklædningsType: " + RBT + "<br> Redskabsrum Gulv: " + RG + "<br><br> Tag: <br>" + "Spærtype: Spær uden rejsning<br>" +
                    "Tagmatriale: " + tag;
            session.setAttribute("beskrivelse",beskrivelse);

        }else {
            double langde_m = (double) laengde_cm/100;
            double bredde_m = (double) bredde_cm/100;
            double rlangde_1 = Carport_Mapper.get_Dropdown_Laengde_List().get(Integer.parseInt(rLaengde)).getCarportLaengde();
            double rlangde_m = rlangde_1/100;
            double rbredde_1 = Carport_Mapper.get_Dropdown_Bredde_List().get(Integer.parseInt(rBredde)).getCarportBredde();
            double rbredde_m = rbredde_1/100;
            String tag = Carport_Mapper.getDropdown_Tagmatriale_List().get(tagmatriale).getType();
            String RBT = Carport_Mapper.get_Dropdown_Traetype_List().get(Integer.parseInt(redskabsrumbeklaedningstype)).getCarporttraeType();
            String RG = Carport_Mapper.getDropdown_Gulv_List().get(Integer.parseInt(redskabsrumGulv)).getGulv();

            String beskrivelse = "Carport mål: L: " + langde_m + "m B: "+ bredde_m + "m<br> <br> <br>" + "Redskabsrum: "
                    + "L: " + rlangde_m + " B: "+ rbredde_m+ "<br> BeklædningsType: " + RBT + "<br> Redskabsrum Gulv: " + RG + "<br><br> Tag: <br>" + "Spærtype: Spær med rejsning<br>" +
                    "Tagmatriale: " + tag;
            session.setAttribute("beskrivelse",beskrivelse);
        }


    }

}
