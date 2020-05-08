package FunctionLayer;

import DBAccess.Carport_Mapper;

import javax.servlet.http.HttpServletRequest;

public class Tegning_Algoritme {

    private static Svg svg = new Svg(800, 600, "0,0,800,600",0,0); // (ramme)

            public static int spaer_Omregner(int laengde) {
                int rundetOp = Math.round(laengde / 55);
                return rundetOp;
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
                int breddeOmregnet = bredde-35;
                return breddeOmregnet;
            }

            public static int laengde_Omregner(int laengde) {
                int laengdeOmregnet = laengde-35;
                return laengdeOmregnet;
            }

            public static void remme(int laengde, int bredde) {
                svg.add_Rect(0,35,4,laengde); // rem
                svg.add_Rect(0, rem_Bredde_Omregner(bredde),4,laengde); // rem
            }

            public static int kryds_Laengde_Omregner(int laengde) {
                int laengdeOmregnet = laengde-35;
                return laengdeOmregnet;
            }

            public static void kryds(int laengde, int bredde) {
                svg.add_Kryds(35,39 , kryds_Laengde_Omregner(laengde), rem_Bredde_Omregner(bredde)); // kryds linje
                svg.add_Kryds(kryds_Laengde_Omregner(laengde),39 ,35, rem_Bredde_Omregner(bredde)); // kryds linje
            }

            public static int stolpe_Bredde_Omregner(int bredde) {
                int stolpeOmregnet = bredde-38;
                return stolpeOmregnet;
            }

            public static int Redskabsrum_Vaeg_Bredde_Omregner(int bredde) {
                int vaegOmregnet = bredde-70;
                return vaegOmregnet;
            }

            public static int Redskabsrum_Vaeg_X_Omregner(int x) {
                int xOmregnet = x+5;
                return xOmregnet;
            }

            public static int Redskabsrum_Vaeg_Y_Omregner(int y) {
                int yOmregnet = y+5;
                return yOmregnet;
            }

            public static int stolper_Laengde1(int laengde) {
                double laengdeOmregnet = laengde / 5;
                int finalLaengdeOmregnet = Math.toIntExact(Math.round(laengdeOmregnet));
                return finalLaengdeOmregnet;
            }

            public static int stolper_Laengde2(int laengde) {
                double laengdeOmregnet = laengde / 2;
                int finalLaengdeOmregnet = Math.toIntExact(Math.round(laengdeOmregnet));
                return finalLaengdeOmregnet;
            }

            public static int stolper_Laengde3(int laengde) {
                double laengdeOmregnet = laengde / 1.25;
                int finalLaengdeOmregnet = Math.toIntExact(Math.round(laengdeOmregnet));
                return finalLaengdeOmregnet;
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
                svg.add_Rect(stolper_Laengde1(laengde1),32,10,10); // stolpe
                svg.add_Rect(stolper_Laengde2(laengde2),32,10,10); // stolpe
                svg.add_Rect(stolper_Laengde3(laengde3),32,10,10); // stolpe
                svg.add_Rect(stolper_Laengde1(laengde1), stolpe_Bredde_Omregner(bredde),10,10); // stolpe
                svg.add_Rect(stolper_Laengde2(laengde2), stolpe_Bredde_Omregner(bredde),10,10); // stolpe
                svg.add_Rect(stolper_Laengde3(laengde3), stolpe_Bredde_Omregner(bredde),10,10); // stolpe

                svg.add_Rect(Redskabsrum_Vaeg_X_Omregner(0), 32, Redskabsrum_Vaeg_Bredde_Omregner(red_Bredde),1); // redskabsrumsvæg
                svg.add_Rect(Redskabsrum_Vaeg_X_Omregner(redLaengde), 32, Redskabsrum_Vaeg_Bredde_Omregner(red_Bredde),1); // redskabsrumsvæg
                svg.add_Rect(0, Redskabsrum_Vaeg_Y_Omregner(32), 1,redLaengde); // redskabsrumsvæg
                svg.add_Rect(Redskabsrum_Vaeg_X_Omregner(0), Redskabsrum_Vaeg_Y_Omregner(stolpe_Bredde_Omregner(red_Bredde)), 1,redLaengde); // redskabsrumsvæg

                svg.add_Rect(0, stolpe_Bredde_Omregner(red_Bredde),10,10); // redskabsrum stolpe
                svg.add_Rect(0, 32,10,10); // redskabsrum stolpe
                svg.add_Rect(redLaengde,32,10,10); // redskabsrum stolpe
                svg.add_Rect(redLaengde, stolpe_Bredde_Omregner(red_Bredde),10,10); // redskabsrum stolpe
            }

            public static void tegning(int laengde, int bredde, HttpServletRequest request, String redskabsrum, String red_Laengde, String red_Bredde) {

                try {
                        svg.add_Rect(0, 0, bredde, laengde); // boks linjerne
                        if (redskabsrum == null) {
                            remme(laengde, bredde);
                            spaer_Taeller(laengde, bredde);
                            kryds(laengde, bredde);
                            stolper_Uden_redskabsrum(laengde, laengde, laengde, bredde);
                            request.setAttribute("carporttegning", svg.toString());
                        } else {
                            int bredde_cm = Carport_Mapper.get_Dropdown_Bredde_List().get(Integer.parseInt(red_Bredde)).getCarportBredde();
                            int laengde_cm = Carport_Mapper.get_Dropdown_Laengde_List().get(Integer.parseInt(red_Laengde)).getCarportLaengde();
                            tegning_Med_Redskabsrum(laengde, bredde, request, laengde_cm, bredde_cm);
                        }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            public static void tegning_Med_Redskabsrum(int laengde, int bredde, HttpServletRequest request, int red_Laengde, int red_Bredde) {
                remme(laengde, bredde);
                spaer_Taeller(laengde, bredde);
                kryds(laengde, bredde);
                stolper_Med_redskabsrum(laengde, laengde, laengde, red_Laengde, bredde, red_Bredde);
                request.setAttribute("carporttegning", svg.toString());
            }

}
