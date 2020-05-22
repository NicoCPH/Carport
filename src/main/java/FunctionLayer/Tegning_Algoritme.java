package FunctionLayer;

import DBAccess.Carport_Mapper;

import javax.servlet.http.HttpServletRequest;

public class Tegning_Algoritme {

/**
 * Tegning_Algoritme klassens formål er at tage parametre i form af variabler fra dropdown menuer på vores hjemmeside.
 * De variabler metoderne i klassen tager, bruges til at skitsere en tegning af hvordan kundens ønskede carport ser ud.
 * Klassen består af en række metoder med beregninger, antagelser og svg metoder.
 */
    /**
     * Dette er et viewbox objekt taget fra klassen Svg til at kunne definere størrelsen af tegningen på hjemmesiden.
     */
    private static Svg svg = new Svg(900, 700, "0,0,900,700",0,0); // (ramme)

            /**
             * spaer_Omregner() tager en længde fra dropdown menuen på hjemmesiden og dividere det med 55 for så at regne ud hvor
             * mange spær der skal bruges pr. 55.
             * De 55 er en antagelse.
             * if statementet sørger for at længden ikke kan blive for lille eller for stor.
             */
            public static int spaer_Omregner(int laengde) throws Fejl_haendtering {
                if (laengde < 0 || laengde > 780) {
                    throw new Fejl_haendtering("Længden på carporten skal mindst være 0 og max 780");
                }
                return Math.round(laengde / 55);
            }

            /**
             * spaer_Taeller() tager den omregnet længde og carportens bredde, for så at lave de spær der skal bruges og hvor
             * bredde de skal være.
             * if statementet sørger for at længden og bredden ikke kan blive for lille eller for stor.
             */
            public static void spaer_Taeller(int laengde, int bredde) throws Fejl_haendtering {
                if (laengde < 0 || laengde > 780 || bredde < 175 || bredde > 750) {
                    throw new Fejl_haendtering("Bredden på carporten skal mindst være 210 og max 750 samtidig må længden ikke være mindre end 0 og større end 780");
                }
                svg.add_Rect(0,0,bredde,2);
                int count = 0;
                for (int i = 0; i < spaer_Omregner(laengde); i++) {
                    count +=55;
                    svg.add_Rect(count,0,bredde,2);
                }
            }

            /**
             * rem_Bredde_Omregner() bruges til at udregne hvor remmen skal ligge, carportens fulde bredde, minuset med 35
             * De minus 35 er en antagelse.
             * if statementet sørger for at bredden ikke bliver for stor eller for lille.
             */
            public static int rem_Bredde_Omregner(int bredde) throws Fejl_haendtering {
                if (bredde < 175 || bredde > 750) {
                    throw new Fejl_haendtering("Bredden på carporten skal mindst være 210 og max 750.");
                }
                return bredde-35;
                }

            /**
             * remme() tegner de remme der er i carporten og hvor bredde og lange de skal være, ved at tage længden
             * fra dropdown menuen på vores hjemmeside og den omregnet bredde.
             * if statementet sørger for at længden og bredden ikke bliver for stor eller for lille.
             */
            public static void remme(int laengde, int bredde) throws Fejl_haendtering {
                if (laengde < 0 || laengde > 780 || bredde < 175 || bredde > 750) {
                    throw new Fejl_haendtering("Bredden på carporten skal mindst være 210 og max 750 samtidig må længden ikke være mindre end 0 og større end 780");
                }
                svg.add_Rect(0,35,4, laengde); // rem
                svg.add_Rect(0, rem_Bredde_Omregner(bredde),4, laengde); // rem
            }

            /**
             * kryds_Laengde_Omregner() tager en længde og minuser med 35 for at få krydsne til at sidde på remmene.
             * if statementet sørger for at længden ikke bliver for stor eller for lille.
             */
            public static int kryds_Laengde_Omregner(int laengde) throws Fejl_haendtering {
                if (laengde < 35 || laengde > 780) {
                    throw new Fejl_haendtering("Længden på carportens kryds skal mindst være 35 og max 780");
                }
                return laengde-35;
            }

            /**
             * kryds() tager en omregnet længde og omregnet bredde, samt et predifineret x og y coordinat.
             * Som tilsammen tegner krydsne på remmene, på carporten.
             * if statementet sørger for at længden og bredden ikke bliver for stor eller for lille.
             */
            public static void kryds(int laengde, int bredde) throws Fejl_haendtering {
                if (laengde < 35 || laengde > 780 || bredde < 175 || bredde > 750) {
                    throw new Fejl_haendtering("Bredden på carporten skal mindst være 210 og max 750 samtidig må længden ikke være mindre end 0 og større end 780");
                }
                svg.add_Kryds(35,39 , kryds_Laengde_Omregner(laengde), rem_Bredde_Omregner(bredde)); // kryds linje
                svg.add_Kryds(kryds_Laengde_Omregner(laengde),39 ,35, rem_Bredde_Omregner(bredde)); // kryds linje
            }

            /**
             * stolpe_Bredde_Omregner() er til at omregne hvor stolperne skal sidde i forhold til carportens bredde.
             * Metoden tager carportens bredde og minuser med 38.
             * Stolperne er minuset med 38 for at få dem lagt på midten af remmene. Dette er en antagelse.
             * if statementet sørger for at bredden ikke bliver for stor eller for lille.
             */
            public static int stolpe_Bredde_Omregner(int bredde) throws Fejl_haendtering {
                if (bredde < 175 || bredde > 750) {
                    throw new Fejl_haendtering("Bredden på carporten skal mindst være 210 og max 750");
                }
                return bredde-38;
            }

            /**
             * Redskabsrum_Vaeg_Bredde_Omregner() bruges til at omregne hvor redskabsrummets væg skal sidde i forhold
             * til bredden.
             * De minus 70 passer med carportens rem.
             * if statementet sørger for at bredden ikke bliver for stor eller for lille.
             */
            public static int redskabsrum_Vaeg_Bredde_Omregner(int bredde) throws Fejl_haendtering {
                if (bredde < 175 || bredde > 750) {
                    throw new Fejl_haendtering("Bredden på carporten skal mindst være 210 og max 750");
                }
                return bredde-70;
            }

            /**
             * Redskabsrum_Vaeg_X_Omregner() bruges til at omregne hvor redskabsrummets væg skal sidde i forhold til
             * x coordinatet.
             * De plus 5 er for at få væggen til at være i midten af redskabsrummets stolper, hvilket er hvad der
             * bliver omregnet.
             */
            public static int redskabsrum_Vaeg_X_Omregner(int x) {
                return x+5;
            }

            /**
             * Redskabsrum_Vaeg_Y_Omregner() bruges til at omregne hvor redskabsrummets væg skal sidde i forhold til
             * y coordinatet.
             * De plus 5 er for at få væggen til at være i midten af redskabsrummets stolper, hvilket er hvad der
             * bliver omregnet.
             */
            public static int redskabsrum_Vaeg_Y_Omregner(int y) { return y+5; }

            /**
            * stolper_Laengde1() bruges til at sætte de 2 stolpers (fra venstre) længde.
            * Metoden tager en længde og dividere med 5 som er en antagelse.
             * * if statementet sørger for at længden ikke bliver for stor eller for lille.
            */
            public static int stolper_Laengde1(int laengde) throws Fejl_haendtering {
                if (laengde < 0 || laengde > 780) {
                    throw new Fejl_haendtering("Længden på carporten skal mindst være 0 og max 780");
                }
                double laengdeOmregnet = laengde / 5;
                return Math.toIntExact(Math.round(laengdeOmregnet));
            }

            /**
            * stolper_Laengde2() bruges til at sætte de 2 midter stolpers længde.
            * Metoden tager en længde og dividere med 2 som er en antagelse.
             * * if statementet sørger for at længden ikke bliver for stor eller for lille.
            */
            public static int stolper_Laengde2(int laengde) throws Fejl_haendtering {
                if (laengde < 0 || laengde > 780) {
                    throw new Fejl_haendtering("Længden på carporten skal mindst være 0 og max 780");
                }
                double laengdeOmregnet = laengde / 2;
                return Math.toIntExact(Math.round(laengdeOmregnet));
            }

            /**
            * stolper_Laengde3() bruges til at sætte de 2 stolpers (fra højre) længde.
            * Metoden tager en længde og dividere med 1.25 som er en antagelse.
             * if statementet sørger for at længden ikke bliver for stor eller for lille.
            */
            public static int stolper_Laengde3(int laengde) throws Fejl_haendtering {
                if (laengde < 0 || laengde > 780) {
                    throw new Fejl_haendtering("Længden på carporten skal mindst være 0 og max 780");
                }
                double laengdeOmregnet = laengde / 1.25;
                return Math.toIntExact(Math.round(laengdeOmregnet));
            }

            /**
             * Metoden bruger de beregnede længder og bredder til at sætte hvor stolperne skal være.
             * Denne metode er uden redskabsrum.
             * y coordinatet på de 3 første stolper er predifineret, for at sætte dem på remmene.
             * Height og width er predifineret for at tegne størrelsen på stolperne.
             * if statementet sørger for at længderne og bredderne ikke bliver for store eller for små.
            */
            public static void stolper_Uden_redskabsrum(int laengde1, int laengde2, int laengde3, int bredde) throws Fejl_haendtering {
                if (laengde1 < 0 || laengde1 > 780 || laengde2 < 0 || laengde2 > 780 || laengde3 < 0 || laengde3 > 780 || bredde < 175 || bredde > 750) {
                    throw new Fejl_haendtering("Bredden på carporten skal mindst være 210 og max 750 samtidig må længden ikke være mindre end 0 og større end 780");
                }
                svg.add_Rect(stolper_Laengde1(laengde1),32,10,10); // stolpe
                svg.add_Rect(stolper_Laengde2(laengde2),32,10,10); // stolpe
                svg.add_Rect(stolper_Laengde3(laengde3),32,10,10); // stolpe
                svg.add_Rect(stolper_Laengde1(laengde1), stolpe_Bredde_Omregner(bredde),10,10); // stolpe
                svg.add_Rect(stolper_Laengde2(laengde2), stolpe_Bredde_Omregner(bredde),10,10); // stolpe
                svg.add_Rect(stolper_Laengde3(laengde3), stolpe_Bredde_Omregner(bredde),10,10); // stolpe
            }


            /**
             * Metoden bruger de beregnede længder og bredder til at sætte hvor stolperne skal være.
             * Metoden laver også stolperne på redskabsrummet alt afhængigt af hvor stor carporten er.
             * Hvis redskabsrummet er visse størrelser adder og fjernes stolper, baseret på antagelser lavet af os selv.
             * Denne metode er med redskabsrum.
             * Height og width er predifineret for at tegne størrelsen på stolperne.
             * Nogle af stolpernes x og y coordinater er i denne metode er predifineret for at få redskabsrummets og
             * carportens stolper til ikke at overlappe hinanden og for at give mening i forhold til vores antagelser.
             * if statementsne i denne metode er der for at adde og fjerne div. stolper efter vores antagelser.
             */
            public static void stolper_Med_redskabsrum(int laengde1, int laengde2, int laengde3, int redLaengde, int bredde, int red_Bredde) throws Fejl_haendtering {
                if (laengde1 < 0 || laengde1 > 780 || laengde2 < 0 || laengde2 > 780 || laengde3 < 0 || laengde3 > 780 || redLaengde < 0 || redLaengde > 780 || bredde < 175 || bredde > 750 || red_Bredde < 175 || red_Bredde > 750) {
                    throw new Fejl_haendtering("Bredden på carporten skal mindst være 210 og max 750 samtidig må længden ikke være mindre end 0 og større end 780");
                }
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

                svg.add_Rect(redskabsrum_Vaeg_X_Omregner(0), 32, redskabsrum_Vaeg_Bredde_Omregner(red_Bredde),1); // redskabsrumsvæg
                svg.add_Rect(redskabsrum_Vaeg_X_Omregner(redLaengde), 32, redskabsrum_Vaeg_Bredde_Omregner(red_Bredde),1); // redskabsrumsvæg
                svg.add_Rect(0, redskabsrum_Vaeg_Y_Omregner(32), 1,redLaengde); // redskabsrumsvæg
                svg.add_Rect(redskabsrum_Vaeg_X_Omregner(0), redskabsrum_Vaeg_Y_Omregner(stolpe_Bredde_Omregner(red_Bredde)), 1,redLaengde); // redskabsrumsvæg

                svg.add_Rect(0, stolpe_Bredde_Omregner(red_Bredde),10,10); // redskabsrum stolpe
                svg.add_Rect(0, 32,10,10); // redskabsrum stolpe
                svg.add_Rect(redLaengde,32,10,10); // redskabsrum stolpe
                svg.add_Rect(redLaengde, stolpe_Bredde_Omregner(red_Bredde),10,10); // redskabsrum stolpe
            }

            /**
            * Metoden her tager carportens længde og bredde fra forespørgslen som har taget dem fra dropdown menuerne
             * på hjemmesiden. Metoden tager også et request fra forespørgslen for at kunne vise tegningen på siden.
             * Metoden tegner en tegning af kundens ønskede carport, fra variablerne valgt af kunden fra dropdown menuen
             * på hjemmesiden og tegner derefter carporten.
             * Div. metoder bliver kaldt og laver de ting som carporten indeholder. I denne metode består carporten af:
             * Carportens tag ramme, 2 remme, x antal spær (antallet er regnet ud efter længden på carporten), 1 kryds
             * som består af to linjer sat på remmerne, stolper placeret efter antagelser, længder og bredder.
             * Tilsidst er pilene sat ind for at kunne se længden og bredden på den ønskede carport.
             * if statementet sørger for at længden og bredden ikke bliver for store eller for lille.
             */
            public static void tegning_Uden_Redskabsrum(int laengde, int bredde, HttpServletRequest request) throws Fejl_haendtering {
                if (laengde < 0 || laengde > 780 || bredde < 175 || bredde > 750) {
                    throw new Fejl_haendtering("Bredden på carporten skal mindst være 210 og max 750 samtidig må længden ikke være mindre end 0 og større end 780");
                }
                try {
                    svg.add_Rect(0, 0, bredde, laengde); // Carportens tag
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

             /**
            * Metoden her tager carportens og redskabsrummets længde og bredde fra forespørgslen som har taget dem fra dropdown menuerne
            * på hjemmesiden. Metoden tager også et request fra forespørgslen for at kunne vise tegningen på siden.
            * Metoden tegner en tegning af kundens ønskede carport, fra variablerne valgt af kunden fra dropdown menuen
            * på hjemmesiden og tegner derefter carporten.
            * Div. metoder bliver kaldt og laver de ting som carporten indeholder. I denne metode består carporten af:
            * Carportens tag ramme, 2 remme, x antal spær (antallet er regnet ud efter længden på carporten), 1 kryds
            * som består af to linjer sat på remmerne, stolper placeret efter antagelser, længder og bredder.
            * Tilsidst er pilene sat ind for at kunne se længden og bredden på den ønskede carport.
              * if statementet sørger for at længderne og bredderne ikke bliver for store eller for små.
            */
            public static void tegning_Med_Redskabsrum(int laengde, int bredde, HttpServletRequest request, String red_Laengde, String red_Bredde) throws Fejl_haendtering {
                if (laengde < 0 || laengde > 780 || bredde < 175 || bredde > 750 || Integer.parseInt(red_Laengde) < 0 || Integer.parseInt(red_Laengde) > 780 || Integer.parseInt(red_Bredde) < 175 || Integer.parseInt(red_Bredde) > 750) {
                    throw new Fejl_haendtering("Bredden på carporten skal mindst være 210 og max 750 samtidig må længden ikke være mindre end 0 og større end 780");
                }
                try {
                    svg.add_Rect(0, 0, bredde, laengde); // Carportens tag
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
