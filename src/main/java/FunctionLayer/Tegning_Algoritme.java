package FunctionLayer;

import DBAccess.Carport_Mapper;

import javax.servlet.http.HttpServletRequest;

public class Tegning_Algoritme {


    private static Svg svg = new Svg(900, 700, "0,0,900,700",0,0); // (ramme)

            public static int spaer_Omregner(int laengde) {
                return Math.round(laengde / 55);
            }

            public static void spaer_Taeller(int laengde, int bredde) {
                svg.add_Rect(0,0,bredde,2);
                int count = 0;
                for (int i = 0; i < spaer_Omregner(laengde); i++) {
                    count +=55;
                    svg.add_Rect(count,0,bredde,2);
                }
            }

            public static int rem_Bredde_Omregner(int bredde) {
                return bredde-35;
            }

            public static void remme(int laengde, int bredde) {
                svg.add_Rect(0,35,4, laengde); // rem
                svg.add_Rect(0, rem_Bredde_Omregner(bredde),4, laengde); // rem
            }

            public static int kryds_Laengde_Omregner(int laengde) {
                return laengde-35;
            }

            public static void kryds(int laengde, int bredde) {
                svg.add_Kryds(35,39 , kryds_Laengde_Omregner(laengde), rem_Bredde_Omregner(bredde)); // kryds linje
                svg.add_Kryds(kryds_Laengde_Omregner(laengde),39 ,35, rem_Bredde_Omregner(bredde)); // kryds linje
            }

            public static int stolpe_Bredde_Omregner(int bredde) {
                return bredde-38;
            }

            public static int Redskabsrum_Vaeg_Bredde_Omregner(int bredde) {
                return bredde-70;
            }

            public static int Redskabsrum_Vaeg_X_Omregner(int x) {
                return x+5;
            }

            public static int Redskabsrum_Vaeg_Y_Omregner(int y) {
                return y+5;
            }

            public static int stolper_Laengde1(int laengde) {
                double laengdeOmregnet = laengde / 5;
                return Math.toIntExact(Math.round(laengdeOmregnet));
            }

            public static int stolper_Laengde2(int laengde) {
                double laengdeOmregnet = laengde / 2;
                return Math.toIntExact(Math.round(laengdeOmregnet));
            }

            public static int stolper_Laengde3(int laengde) {
                double laengdeOmregnet = laengde / 1.25;
                return Math.toIntExact(Math.round(laengdeOmregnet));
            }

            public static void stolper_Uden_redskabsrum(int laengde1, int laengde2, int laengde3, int bredde) {
                svg.add_Rect(stolper_Laengde1(laengde1),32,10,10); // stolpe
                svg.add_Rect(stolper_Laengde2(laengde2),32,10,10); // stolpe
                svg.add_Rect(stolper_Laengde3(laengde3),32,10,10); // stolpe
                svg.add_Rect(stolper_Laengde1(laengde1), stolpe_Bredde_Omregner(bredde),10,10); // stolpe
                svg.add_Rect(stolper_Laengde2(laengde2), stolpe_Bredde_Omregner(bredde),10,10); // stolpe
                svg.add_Rect(stolper_Laengde3(laengde3), stolpe_Bredde_Omregner(bredde),10,10); // stolpe
            }

            public static void stolper_Med_redskabsrum(int laengde1, int laengde2, int laengde3, int redLaengde, int bredde, int red_Bredde) {
                if (redLaengde <= laengde2 / 3) {
                    svg.add_Rect(stolper_Laengde2(laengde2), 32, 10, 10); // stolpe
                }

                svg.add_Rect(stolper_Laengde3(laengde3), 32, 10, 10); // stolpe

                if (red_Bredde != bredde) {
                    svg.add_Rect(stolper_Laengde1(laengde1), stolpe_Bredde_Omregner(bredde), 10, 10); // stolpe
                }

                if (red_Bredde != bredde || redLaengde <= laengde2 / 3) {
                    svg.add_Rect(stolper_Laengde2(laengde2), stolpe_Bredde_Omregner(bredde), 10, 10); // stolpe
                }

                svg.add_Rect(stolper_Laengde3(laengde3), stolpe_Bredde_Omregner(bredde), 10, 10); // stolpe

                svg.add_Rect(Redskabsrum_Vaeg_X_Omregner(0), 32, Redskabsrum_Vaeg_Bredde_Omregner(red_Bredde),1); // redskabsrumsvæg
                svg.add_Rect(Redskabsrum_Vaeg_X_Omregner(redLaengde), 32, Redskabsrum_Vaeg_Bredde_Omregner(red_Bredde),1); // redskabsrumsvæg
                svg.add_Rect(0, Redskabsrum_Vaeg_Y_Omregner(32), 1,redLaengde); // redskabsrumsvæg
                svg.add_Rect(Redskabsrum_Vaeg_X_Omregner(0), Redskabsrum_Vaeg_Y_Omregner(stolpe_Bredde_Omregner(red_Bredde)), 1,redLaengde); // redskabsrumsvæg

                svg.add_Rect(0, stolpe_Bredde_Omregner(red_Bredde),10,10); // redskabsrum stolpe
                svg.add_Rect(0, 32,10,10); // redskabsrum stolpe
                svg.add_Rect(redLaengde,32,10,10); // redskabsrum stolpe
                svg.add_Rect(redLaengde, stolpe_Bredde_Omregner(red_Bredde),10,10); // redskabsrum stolpe
            }

            public static void tegning_Uden_Redskabsrum(int laengde, int bredde, HttpServletRequest request) {

                try {
                    svg.add_Rect(0, 0, bredde, laengde); // boks linjerne
                    remme(laengde, bredde);
                    spaer_Taeller(laengde, bredde);
                    kryds(laengde, bredde);
                    stolper_Uden_redskabsrum(laengde, laengde, laengde, bredde);

                    svg.add_pil(laengde + 15,0, laengde + 15, bredde);
                    svg.add_text_Rotated(laengde + 30,bredde / 2, bredde + " cm");
                    svg.add_pil(0,bredde + 15, laengde, bredde + 15);
                    svg.add_text(laengde / 2 , bredde + 30, laengde + " cm");
                    svg.add_pilspids();

                    request.setAttribute("carporttegning", svg.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            public static void tegning_Med_Redskabsrum(int laengde, int bredde, HttpServletRequest request, String red_Laengde, String red_Bredde) {
                try {
                    svg.add_Rect(0, 0, bredde, laengde); // boks linjerne
                    remme(laengde, bredde);
                    spaer_Taeller(laengde, bredde);
                    kryds(laengde, bredde);
                    stolper_Med_redskabsrum(laengde, laengde, laengde,

                            Carport_Mapper.get_Dropdown_Laengde_List().get(Integer.parseInt(red_Laengde)).getCarportLaengde(),
                            bredde, Carport_Mapper.get_Dropdown_Bredde_List().get(Integer.parseInt(red_Bredde)).getCarportBredde());

                    svg.add_pil(laengde + 15,0, laengde + 15, bredde);
                    svg.add_text_Rotated(laengde + 30,bredde / 2, bredde + " cm");
                    svg.add_pil(0,bredde + 15, laengde, bredde + 15);
                    svg.add_text(laengde / 2 , bredde + 30, laengde + " cm");
                    svg.add_pilspids();

                    request.setAttribute("carporttegning", svg.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

}
