package DBAccess;

import FunctionLayer.Fejl_haendtering;
import FunctionLayer.Svg;
import FunctionLayer.Tegning_Algoritme;
import org.hamcrest.core.StringContains;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Tegning_AlgoritmeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void spaer_Omregner() throws Fejl_haendtering {
        int value = Tegning_Algoritme.spaer_Omregner(330);
        int expected = 6;
        int value2 = Tegning_Algoritme.spaer_Omregner(317);
        int expected2 = 5;
        int value3 = Tegning_Algoritme.spaer_Omregner(780);
        int expected3 = 14;
        int value4 = Tegning_Algoritme.spaer_Omregner(0);
        int expected4 = 0;
        assertEquals(expected, value);
        assertEquals(expected2, value2);
        assertEquals(expected3, value3);
        assertEquals(expected4, value4);

    }

    @Test
    public void spaer_Taeller() {
        Svg svg = new Svg(800,600,"800,600,0,0",0,0);
        svg.add_Rect(0,0,100,110);
        String expected = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
               "" + "width=\"600\" height=\"800\" x=\"0\" y=\"0\" viewBox=\"800,600,0,0\" preserveAspectRatio=\"xMinYMin\">" +
               "<rect x=\"0\" y=\"0\" height=\"100\" width=\"110\" style=\"stroke:#000000; fill: #ffffff\" />" + "</svg>";
        /*
        Tegning_Algoritme.spaer_Taeller(110,100);
        String expected2 = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
                "" + "width=\"600\" height=\"800\" x=\"0\" y=\"0\" viewBox=\"800,600,0,0\" preserveAspectRatio=\"xMinYMin\">" +
                "<rect x=\"0\" y=\"0\" height=\"100\" width=\"110\" style=\"stroke:#000000; fill: #ffffff\" />" +
                "<rect x=\"0\" y=\"0\" height=\"100\" width=\"110\" style=\"stroke:#000000; fill: #ffffff\" /></svg>";
        */
        assertEquals(expected, svg.toString());
        //assertEquals(expected2, svg.toString());
    }

    @Test
    public void rem_Bredde_Omregner() throws Fejl_haendtering {
        int value = Tegning_Algoritme.rem_Bredde_Omregner(210);
        int expected = 210 - 35;
        int value2 = Tegning_Algoritme.rem_Bredde_Omregner(750);
        int expected2 = 750 - 35;
        int value3 = Tegning_Algoritme.rem_Bredde_Omregner(555);
        int expected3 = 555 - 35;
        assertEquals(expected, value);
        assertEquals(expected2, value2);
        assertEquals(expected3, value3);

    }

    @Test
    public void remme() throws Fejl_haendtering {
        int value = Tegning_Algoritme.rem_Bredde_Omregner(210);
        int value2 = Tegning_Algoritme.rem_Bredde_Omregner(555);
        int value3 = Tegning_Algoritme.rem_Bredde_Omregner(750);
        int expected = 210 - 35;
        int expected2 = 555 - 35;
        int expected3 = 750 - 35;
        assertEquals(expected, value);
        assertEquals(expected2, value2);
        assertEquals(expected3, value3);
    }

    @Test
    public void kryds_Laengde_Omregner() throws Fejl_haendtering {
        int value = Tegning_Algoritme.kryds_Laengde_Omregner(100);
        int value2 = Tegning_Algoritme.kryds_Laengde_Omregner(35);
        int value3 = Tegning_Algoritme.kryds_Laengde_Omregner(780);
        int expected = 100 - 35;
        int expected2 = 35 - 35;
        int expected3 = 780 - 35;
        assertEquals(expected, value);
        assertEquals(expected2, value2);
        assertEquals(expected3, value3);
    }

    @Test
    public void kryds() throws Fejl_haendtering {
        Svg svg = new Svg(800,600,"800,600,0,0",0,0);
        svg.add_Kryds(35,39 , Tegning_Algoritme.kryds_Laengde_Omregner(500),
                Tegning_Algoritme.rem_Bredde_Omregner(230));
        String expectedS = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
                "" + "width=\"600\" height=\"800\" x=\"0\" y=\"0\" viewBox=\"800,600,0,0\" preserveAspectRatio=\"xMinYMin\">" +
                "<line x1=\"35\" y1=\"39\" x2=\"465\" y2=\"195\" style=\"stroke:#000000; stroke-dasharray: 5 5;\" />" + "</svg>";
        assertEquals(expectedS, svg.toString());
    }

    @Test
    public void stolpe_Bredde_Omregner() throws Fejl_haendtering {
        int value = Tegning_Algoritme.stolpe_Bredde_Omregner(210);
        int value2 = Tegning_Algoritme.stolpe_Bredde_Omregner(555);
        int value3 = Tegning_Algoritme.stolpe_Bredde_Omregner(750);
        int expected = 210 - 38;
        int expected2 = 555 - 38;
        int expected3 = 750 - 38;
        assertEquals(expected, value);
        assertEquals(expected2, value2);
        assertEquals(expected3, value3);
    }

    @Test
    public void redskabsrum_Vaeg_Bredde_Omregner() throws Fejl_haendtering {
        int value = Tegning_Algoritme.redskabsrum_Vaeg_Bredde_Omregner(210);
        int value2 = Tegning_Algoritme.redskabsrum_Vaeg_Bredde_Omregner(555);
        int value3 = Tegning_Algoritme.redskabsrum_Vaeg_Bredde_Omregner(750);
        int expected = 210 - 70;
        int expected2 = 555 - 70;
        int expected3 = 750 - 70;
        assertEquals(expected, value);
        assertEquals(expected2, value2);
        assertEquals(expected3, value3);

    }

    @Test
    public void redskabsrum_Vaeg_X_Omregner() {
        int value = Tegning_Algoritme.redskabsrum_Vaeg_X_Omregner(0);
        int value2 = Tegning_Algoritme.redskabsrum_Vaeg_X_Omregner(100);
        int value3 = Tegning_Algoritme.redskabsrum_Vaeg_X_Omregner(1000);
        int value4 = Tegning_Algoritme.redskabsrum_Vaeg_X_Omregner(10000);
        int value5 = Tegning_Algoritme.redskabsrum_Vaeg_X_Omregner(-1);
        int value6 = Tegning_Algoritme.redskabsrum_Vaeg_X_Omregner(-5);
        int value7 = Tegning_Algoritme.redskabsrum_Vaeg_X_Omregner(-500);
        int expected = 0 + 5;
        int expected2 = 100 + 5;
        int expected3 = 1000 + 5;
        int expected4 = 10000 + 5;
        int expected5 = -1 + 5;
        int expected6 = -5 + 5;
        int expected7 = -500 + 5;
        assertEquals(expected, value);
        assertEquals(expected2, value2);
        assertEquals(expected3, value3);
        assertEquals(expected4, value4);
        assertEquals(expected5, value5);
        assertEquals(expected6, value6);
        assertEquals(expected7, value7);
    }

    @Test
    public void redskabsrum_Vaeg_Y_Omregner() {
        int value = Tegning_Algoritme.redskabsrum_Vaeg_Y_Omregner(0);
        int value2 = Tegning_Algoritme.redskabsrum_Vaeg_Y_Omregner(100);
        int value3 = Tegning_Algoritme.redskabsrum_Vaeg_Y_Omregner(1000);
        int value4 = Tegning_Algoritme.redskabsrum_Vaeg_Y_Omregner(10000);
        int value5 = Tegning_Algoritme.redskabsrum_Vaeg_Y_Omregner(-1);
        int value6 = Tegning_Algoritme.redskabsrum_Vaeg_Y_Omregner(-5);
        int value7 = Tegning_Algoritme.redskabsrum_Vaeg_Y_Omregner(-500);
        int expected = 0 + 5;
        int expected2 = 100 + 5;
        int expected3 = 1000 + 5;
        int expected4 = 10000 + 5;
        int expected5 = -1 + 5;
        int expected6 = -5 + 5;
        int expected7 = -500 + 5;
        assertEquals(expected, value);
        assertEquals(expected2, value2);
        assertEquals(expected3, value3);
        assertEquals(expected4, value4);
        assertEquals(expected5, value5);
        assertEquals(expected6, value6);
        assertEquals(expected7, value7);
    }

    @Test
    public void stolper_Laengde1() throws Fejl_haendtering {
        int laengde = Tegning_Algoritme.stolper_Laengde1(0);
        int laengde2 = Tegning_Algoritme.stolper_Laengde1(210);
        int laengde3 = Tegning_Algoritme.stolper_Laengde1(555);
        int laengde4 = Tegning_Algoritme.stolper_Laengde1(780);
        double laengdeOmregnet = laengde / 5;
        double laengdeOmregnet2 = laengde2 / 5;
        double laengdeOmregnet3 = laengde3 / 5;
        double laengdeOmregnet4 = laengde4 / 5;
        int expected = 0;
        int expected2 = 8;
        int expected3 = 22;
        int expected4 = 31;
        assertEquals(expected, Math.toIntExact(Math.round(laengdeOmregnet)));
        assertEquals(expected2, Math.toIntExact(Math.round(laengdeOmregnet2)));
        assertEquals(expected3, Math.toIntExact(Math.round(laengdeOmregnet3)));
        assertEquals(expected4, Math.toIntExact(Math.round(laengdeOmregnet4)));
    }


    @Test
    public void stolper_Laengde2() throws Fejl_haendtering {
        int laengde = Tegning_Algoritme.stolper_Laengde2(0);
        int laengde2 = Tegning_Algoritme.stolper_Laengde2(210);
        int laengde3 = Tegning_Algoritme.stolper_Laengde2(555);
        int laengde4 = Tegning_Algoritme.stolper_Laengde2(780);
        double laengdeOmregnet = laengde / 2;
        double laengdeOmregnet2 = laengde2 / 2;
        double laengdeOmregnet3 = laengde3 / 2;
        double laengdeOmregnet4 = laengde4 / 2;
        int expected = 0;
        int expected2 = 52;
        int expected3 = 138;
        int expected4 = 195;
        assertEquals(expected, Math.toIntExact(Math.round(laengdeOmregnet)));
        assertEquals(expected2, Math.toIntExact(Math.round(laengdeOmregnet2)));
        assertEquals(expected3, Math.toIntExact(Math.round(laengdeOmregnet3)));
        assertEquals(expected4, Math.toIntExact(Math.round(laengdeOmregnet4)));
    }

    @Test
    public void stolper_Laengde3() throws Fejl_haendtering {
        int laengde = Tegning_Algoritme.stolper_Laengde3(0);
        int laengde2 = Tegning_Algoritme.stolper_Laengde3(210);
        int laengde3 = Tegning_Algoritme.stolper_Laengde3(555);
        int laengde4 = Tegning_Algoritme.stolper_Laengde3(780);
        double laengdeOmregnet = laengde / 1.25;
        double laengdeOmregnet2 = laengde2 / 1.25;
        double laengdeOmregnet3 = laengde3 / 1.25;
        double laengdeOmregnet4 = laengde4 / 1.25;
        int expected = 0;
        int expected2 = 134;
        int expected3 = 355;
        int expected4 = 499;
        assertEquals(expected, Math.toIntExact(Math.round(laengdeOmregnet)));
        assertEquals(expected2, Math.toIntExact(Math.round(laengdeOmregnet2)));
        assertEquals(expected3, Math.toIntExact(Math.round(laengdeOmregnet3)));
        assertEquals(expected4, Math.toIntExact(Math.round(laengdeOmregnet4)));
    }

    @Test
    public void stolper_Uden_redskabsrum() throws Fejl_haendtering {
        Svg svg = new Svg(800,600,"800,600,0,0",0,0);
        int laengde1 = 0;
        int bredde1 = 210;
        Tegning_Algoritme.stolper_Uden_redskabsrum(laengde1,laengde1,laengde1,bredde1);
        String expectedS = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
                "" + "width=\"600\" height=\"800\" x=\"0\" y=\"0\" viewBox=\"800,600,0,0\" preserveAspectRatio=\"xMinYMin\">" +
                "<line x1=\"35\" y1=\"39\" x2=\"465\" y2=\"195\" style=\"stroke:#000000; stroke-dasharray: 5 5;\" />" + "</svg>";
        assertEquals(expectedS, svg.toString());

        // hvordan finder jeg ud af om den laver mine objekter via. svg korrekt.

    }

    @Test
    public void stolper_Med_redskabsrum() throws Fejl_haendtering {
        int laengde1 = 0;
        int laengde2 = 150;
        int laengde3 = 780;
        int laengdeR1 = 0;
        int laengdeR2 = 150;
        int laengdeR3 = 780;
        int bredde1 = 210;
        int bredde2 = 555;
        int bredde3 = 750;
        int breddeR1 = 210;
        int breddeR2 = 555;
        int breddeR3 = 750;
        Tegning_Algoritme.stolper_Med_redskabsrum(laengde1, laengde1, laengde1, laengdeR1, bredde1, breddeR1);
        Tegning_Algoritme.stolper_Med_redskabsrum(laengde2, laengde2, laengde2, laengdeR2,bredde2, breddeR2);
        Tegning_Algoritme.stolper_Med_redskabsrum(laengde3, laengde3, laengde3, laengdeR3, bredde3, breddeR3);

        // hvordan finder jeg ud af om den laver mine objekter via. svg korrekt.
    }

    @Test
    public void tegning_Uden_Redskabsrum() {
    }

    @Test
    public void tegning_Med_Redskabsrum() {
    }
}