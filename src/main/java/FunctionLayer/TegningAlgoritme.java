package FunctionLayer;

import javax.servlet.http.HttpServletRequest;

public class TegningAlgoritme {

    private static Svg svg = new Svg(800, 600, "0,0,800,600",0,0); // (ramme)

            public static int spaer_Omregner(int laengde) {
                int rundetOp = Math.round(laengde / 55);
                return rundetOp;
            }

            public static void spaerTaeller(int laengde, int bredde) {
                svg.addRect(0,0,bredde,2);
                int count = 0;
                for (int i = 0; i < spaer_Omregner(laengde); i++) {
                    count +=55;
                    svg.addRect(count,0,bredde,2);
                    System.out.println(count);
                }
            }

            public static int remBredde_Omregner(int bredde) {
                int breddeOmregnet = bredde-35;
                return breddeOmregnet;
            }

            public static int laengde_Omregner(int laengde) {
                int laengdeOmregnet = laengde-35;
                return laengdeOmregnet;
            }

            public static void remme(int laengde, int bredde) {
                svg.addRect(0,35,4,laengde); // rem
                svg.addRect(0,remBredde_Omregner(bredde),4,laengde); // rem
            }

            public static int krydsLaengde_Omregner(int laengde) {
                int laengdeOmregnet = laengde-35;
                return laengdeOmregnet;
            }

            public static void kryds(int laengde, int bredde) {
                svg.addKryds(35,39 ,krydsLaengde_Omregner(laengde), remBredde_Omregner(bredde)); // kryds linje
                svg.addKryds(krydsLaengde_Omregner(laengde),39 ,35, remBredde_Omregner(bredde)); // kryds linje
            }

            public static int stolpeBredde_Omregner(int bredde) {
                int stolpeOmregnet = bredde-38;
                return stolpeOmregnet;
            }

            public static int stolperLaengde1(int laengde) {
                double laengdeOmregnet = laengde / 5;
                int finalLaengdeOmregnet = Math.toIntExact(Math.round(laengdeOmregnet));
                return finalLaengdeOmregnet;
            }

            public static int stolperLaengde2(int laengde) {
                double laengdeOmregnet = laengde / 2;
                int finalLaengdeOmregnet = Math.toIntExact(Math.round(laengdeOmregnet));
                return finalLaengdeOmregnet;
            }

            public static int stolperLaengde3(int laengde) {
                double laengdeOmregnet = laengde / 1.25;
                int finalLaengdeOmregnet = Math.toIntExact(Math.round(laengdeOmregnet));
                return finalLaengdeOmregnet;
            }

            public static void stolperUden_carport(int laengde1, int laengde2, int laengde3, int bredde) {
                svg.addRect(stolperLaengde1(laengde1),32,10,10); // stolpe
                svg.addRect(stolperLaengde2(laengde2),32,10,10); // stolpe
                svg.addRect(stolperLaengde3(laengde3),32,10,10); // stolpe
                svg.addRect(stolperLaengde1(laengde1),stolpeBredde_Omregner(bredde),10,10); // stolpe
                svg.addRect(stolperLaengde2(laengde2),stolpeBredde_Omregner(bredde),10,10); // stolpe
                svg.addRect(stolperLaengde3(laengde3),stolpeBredde_Omregner(bredde),10,10); // stolpe
            }

            public static void tegning(int laengde, int bredde, HttpServletRequest request) {
                try {
                    remme(laengde, bredde);
                    spaerTaeller(laengde, bredde);
                    kryds(laengde, bredde);
                    stolperUden_carport(laengde, laengde, laengde, bredde);
                    request.setAttribute("carporttegning", svg.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                     }
                }
            }
