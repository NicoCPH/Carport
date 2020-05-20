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
        int value3 = Tegning_Algoritme.spaer_Omregner(0);
        int expected3 = 0;
        int value4 = Tegning_Algoritme.spaer_Omregner(-1);
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
        Svg svg = new Svg(800,600,"800, 600, 0, 0",0,0);
        svg.add_Rect(0,35,4, 500);
        svg.add_Rect(0, Tegning_Algoritme.rem_Bredde_Omregner(210),4, 500);
        int expected = 210 - 35;
        assertEquals(expected, Tegning_Algoritme.rem_Bredde_Omregner(210));
    }

    @Test
    public void kryds_Laengde_Omregner() throws Fejl_haendtering {
        Tegning_Algoritme.kryds_Laengde_Omregner(100);
        int expected = 100 - 35;
        assertEquals(expected, Tegning_Algoritme.kryds_Laengde_Omregner(100));
    }

    @Test
    public void kryds() throws Fejl_haendtering {
        Svg svg = new Svg(800,600,"800, 600, 0, 0",0,0);
        svg.add_Kryds(35,39 , Tegning_Algoritme.kryds_Laengde_Omregner(500),
                Tegning_Algoritme.rem_Bredde_Omregner(230));
        svg.add_Kryds(Tegning_Algoritme.kryds_Laengde_Omregner(500),39 ,35,
                Tegning_Algoritme.rem_Bredde_Omregner(230));
        int expected = 500 - 35;
        int expected2 = 230 - 35;
        assertEquals(expected, Tegning_Algoritme.kryds_Laengde_Omregner(500));
        assertEquals(expected2, Tegning_Algoritme.rem_Bredde_Omregner(230));
    }

    @Test
    public void stolpe_Bredde_Omregner() throws Fejl_haendtering {
        int expected = 100 - 38;
        assertEquals(expected, Tegning_Algoritme.stolpe_Bredde_Omregner(100));
    }

    @Test
    public void redskabsrum_Vaeg_Bredde_Omregner() throws Fejl_haendtering {
        int expected = 100 - 70;
        assertEquals(expected, Tegning_Algoritme.redskabsrum_Vaeg_Bredde_Omregner(100));
    }

    @Test
    public void redskabsrum_Vaeg_X_Omregner() {
        int expected = 100 + 5;
        assertEquals(expected, Tegning_Algoritme.redskabsrum_Vaeg_X_Omregner(100));
    }

    @Test
    public void redskabsrum_Vaeg_Y_Omregner() {
        int expected = 100 + 5;
        assertEquals(expected, Tegning_Algoritme.redskabsrum_Vaeg_Y_Omregner(100));
    }

    @Test
    public void stolper_Laengde1() {
        int laengde = 100;
        double laengdeOmregnet = laengde / 5;
        int expected = 20;
        assertEquals(expected, Math.toIntExact(Math.round(laengdeOmregnet)));
    }


    @Test
    public void stolper_Laengde2() {
        int laengde = 100;
        double laengdeOmregnet = laengde / 2;
        int expected = 50;
        assertEquals(expected, Math.toIntExact(Math.round(laengdeOmregnet)));
    }

    @Test
    public void stolper_Laengde3() {
        int laengde = 100;
        double laengdeOmregnet = laengde / 1.25;
        int expected = 80;
        assertEquals(expected, Math.toIntExact(Math.round(laengdeOmregnet)));
    }

    @Test
    public void stolper_Uden_redskabsrum() throws Fejl_haendtering {
        Svg svg = new Svg(800,600,"800, 600, 0, 0",0,0);
        int laengde3 = 100;
        int laengde1 = 200;
        int bredde = 300;
        svg.add_Rect(Tegning_Algoritme.stolper_Laengde3(laengde3),32,10,10);
        svg.add_Rect(Tegning_Algoritme.stolper_Laengde1(laengde1),
                Tegning_Algoritme.stolpe_Bredde_Omregner(bredde),10,10);
        int expected3 = 80;
        int expected1 = 40;
        int expected = bredde - 38;
        assertEquals(expected3, Tegning_Algoritme.stolper_Laengde3(laengde3));
        assertEquals(expected1, Tegning_Algoritme.stolper_Laengde1(laengde1));
        assertEquals(expected, Tegning_Algoritme.stolpe_Bredde_Omregner(bredde));
    }

    @Test
    public void stolper_Med_redskabsrum() throws Fejl_haendtering {
        Svg svg = new Svg(800,600,"800, 600, 0, 0",0,0);
        int redLaengde = 100;
        int red_Bredde = 200;
        svg.add_Rect(Tegning_Algoritme.redskabsrum_Vaeg_X_Omregner(0), 32,
                Tegning_Algoritme.redskabsrum_Vaeg_Bredde_Omregner(red_Bredde),1);
        svg.add_Rect(Tegning_Algoritme.redskabsrum_Vaeg_X_Omregner(redLaengde), 32,
                Tegning_Algoritme.redskabsrum_Vaeg_Bredde_Omregner(red_Bredde),1);
        svg.add_Rect(0, Tegning_Algoritme.redskabsrum_Vaeg_Y_Omregner(32), 1,redLaengde);
        svg.add_Rect(Tegning_Algoritme.redskabsrum_Vaeg_X_Omregner(0),
                Tegning_Algoritme.redskabsrum_Vaeg_Y_Omregner(Tegning_Algoritme.stolpe_Bredde_Omregner(red_Bredde)), 1,redLaengde);
    int expectedX = 0 + 5;
    int expectedBredde = red_Bredde - 70;
    assertEquals(expectedX, Tegning_Algoritme.redskabsrum_Vaeg_X_Omregner(0));
    assertEquals(expectedBredde, Tegning_Algoritme.redskabsrum_Vaeg_Bredde_Omregner(red_Bredde));
    }

    @Test
    public void tegning_Uden_Redskabsrum() {
    } // hjælp

    @Test
    public void tegning_Med_Redskabsrum() {
    } // hjælp
}