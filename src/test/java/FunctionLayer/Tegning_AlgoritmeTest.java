package FunctionLayer;

import FunctionLayer.Fejl_haendtering;
import FunctionLayer.MetodeBehandler.Tegning_Algoritme;
import FunctionLayer.Objekter.Svg;
import org.hamcrest.core.StringContains;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.plugin.dom.core.Element;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        assertEquals(expected, value);
        assertEquals(expected2, value2);
        assertEquals(expected3, value3);
        assertEquals(expected4, value4);

    }

    @Test
    public void spaer_Taeller() throws Fejl_haendtering {
        Svg svg = new Svg(800,600,"800,600,0,0",0,0);
        svg.add_Rect(0,0,100,110);
        String expected = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
               "" + "width=\"600\" height=\"800\" x=\"0\" y=\"0\" viewBox=\"800,600,0,0\" preserveAspectRatio=\"xMinYMin\">" +
               "<rect x=\"0\" y=\"0\" height=\"100\" width=\"110\" style=\"stroke:#000000; fill: #ffffff\" />" + "</svg>";
        
        assertEquals(expected, svg.toString());

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
        Svg svg = new Svg(800,600,"800,600,0,0",0,0);
        svg.add_Rect(0,0,100,110);
        String expected = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
                "" + "width=\"600\" height=\"800\" x=\"0\" y=\"0\" viewBox=\"800,600,0,0\" preserveAspectRatio=\"xMinYMin\">" +
                "<rect x=\"0\" y=\"0\" height=\"100\" width=\"110\" style=\"stroke:#000000; fill: #ffffff\" />" + "</svg>";

        assertEquals(expected, svg.toString());
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
        int laengde = 400;
        int bredde = 210;
        Tegning_Algoritme.stolper_Uden_redskabsrum(laengde,laengde,laengde,bredde);

    }

    @Test
    public void stolper_Med_redskabsrum() throws Fejl_haendtering {
        Svg svg = new Svg(800,600,"800,600,0,0",0,0);
        int laengde = 750;
        int laengdeR = 320;
        int bredde = 420;
        int breddeR = 420;
        Tegning_Algoritme.stolper_Med_redskabsrum(laengde, laengde, laengde, laengdeR, bredde, breddeR);

    }
    @Test
    public void Text() {
        Svg svg = new Svg(800,600,"800,600,0,0",0,0);
        int bredde = 250;
        svg.add_text(250,125,bredde + "cm");
        String expectedText = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
                "" + "width=\"600\" height=\"800\" x=\"0\" y=\"0\" viewBox=\"800,600,0,0\" preserveAspectRatio=\"xMinYMin\">" +
                "<text style=\"text-anchor: middle\" x=\"250\" y=\"125\">250cm</text>" + "</svg>";
        assertEquals(expectedText, svg.toString());

    }
    @Test
    public void TextR() {
        Svg svg = new Svg(800,600,"800,600,0,0",0,0);
        int bredde = 500;
        svg.add_text_Rotated(500,250,bredde + "cm");
        String expectedRText = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
                "" + "width=\"600\" height=\"800\" x=\"0\" y=\"0\" viewBox=\"800,600,0,0\" preserveAspectRatio=\"xMinYMin\">" +
                "<text style=\"text-anchor: middle\" transform=\"translate(500,250) rotate(-90)\">500cm</text>" + "</svg>";
        assertEquals(expectedRText, svg.toString());
    }

    @Test
    public void pil() {
            Svg svg = new Svg(800,600,"800,600,0,0",0,0);
            svg.add_pil(0,0,100,100);
            String expected = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
                    "" + "width=\"600\" height=\"800\" x=\"0\" y=\"0\" viewBox=\"800,600,0,0\" preserveAspectRatio=\"xMinYMin\">" +
                    "<line x1=\"0\"  y1=\"0\" x2=\"100\" y2=\"100\" \n\tstyle=\"stroke: #006600;\n"+
                    "\tmarker-start: url(#beginArrow);\n\tmarker-end: url(#endArrow);\"/>" + "</svg>";
            assertEquals(expected, svg.toString());
    }

    @Test
    public void pilSpids() {
        Svg svg = new Svg(800, 600, "800,600,0,0", 0, 0);
        svg.add_pilspids();
        String expected = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
                "" + "width=\"600\" height=\"800\" x=\"0\" y=\"0\" viewBox=\"800,600,0,0\" preserveAspectRatio=\"xMinYMin\">" +
                "<defs>\n" + " <marker \n" + " \tid=\"beginArrow\" \n" + " \tmarkerWidth=\"12\" \n" +
                "\tmarkerHeight=\"12\" \n" + " \trefX=\"0\" \n" + "\trefY=\"6\" \n" + "\torient=\"auto\">\n" +
                "<path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" + "</marker>\n" + "<marker \n" +
                "\tid=\"endArrow\" \n" + " \tmarkerWidth=\"12\" \n" + "\tmarkerHeight=\"12\" \n" + "\trefX=\"12\" \n" +
                "\trefY=\"6\" \n" + "\torient=\"auto\">\n" + "<path d=\"M0,0 L12,6 L0,12 L0,0 \"style=\"fill: #000000;\" />\n" +
                "</marker>\n" + "</defs>" + "</svg>";
        assertEquals(expected, svg.toString());
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl() throws Fejl_haendtering {
        Tegning_Algoritme.spaer_Omregner(-1);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl1() throws Fejl_haendtering {
        Tegning_Algoritme.spaer_Omregner(781);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl2() throws Fejl_haendtering {
       Tegning_Algoritme.spaer_Taeller(781,751);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl3() throws Fejl_haendtering {
        Tegning_Algoritme.spaer_Taeller(-1,-1);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl4() throws Fejl_haendtering {
        Tegning_Algoritme.spaer_Taeller(-1,751);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl5() throws Fejl_haendtering {
        Tegning_Algoritme.rem_Bredde_Omregner(751);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl6() throws Fejl_haendtering {
        Tegning_Algoritme.rem_Bredde_Omregner(-1);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl7() throws Fejl_haendtering {
        Tegning_Algoritme.spaer_Omregner(-1);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl8() throws Fejl_haendtering {
        Tegning_Algoritme.kryds_Laengde_Omregner(-1);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl9() throws Fejl_haendtering {
        Tegning_Algoritme.kryds_Laengde_Omregner(781);
    }


    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl10() throws Fejl_haendtering {
        Tegning_Algoritme.kryds_Laengde_Omregner(34);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl11() throws Fejl_haendtering {
        Tegning_Algoritme.stolpe_Bredde_Omregner(-1);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl12() throws Fejl_haendtering {
        Tegning_Algoritme.stolpe_Bredde_Omregner(781);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl13() throws Fejl_haendtering {
       Tegning_Algoritme.redskabsrum_Vaeg_Bredde_Omregner(174);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl14() throws Fejl_haendtering {
        Tegning_Algoritme.redskabsrum_Vaeg_Bredde_Omregner(751);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl15() throws Fejl_haendtering {
        Tegning_Algoritme.stolper_Laengde1(-1);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl16() throws Fejl_haendtering {
        Tegning_Algoritme.stolper_Laengde1(781);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl17() throws Fejl_haendtering {
        Tegning_Algoritme.stolper_Laengde2(-1);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl18() throws Fejl_haendtering {
        Tegning_Algoritme.stolper_Laengde2(781);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl19() throws Fejl_haendtering {
        Tegning_Algoritme.stolper_Laengde3(-1);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl20() throws Fejl_haendtering {
        Tegning_Algoritme.stolper_Uden_redskabsrum(-1,-1,-1,-1);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl21() throws Fejl_haendtering {
        Tegning_Algoritme.stolper_Uden_redskabsrum(781,781,781,781);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl22() throws Fejl_haendtering {
        Tegning_Algoritme.stolper_Med_redskabsrum(-1,-1,-1,-1,-1,-1);
    }

    @Test(expected = Fejl_haendtering.class)
    public void testAfFejl23() throws Fejl_haendtering {
        Tegning_Algoritme.stolper_Med_redskabsrum(781,781,781,781,781,781);
    }
}