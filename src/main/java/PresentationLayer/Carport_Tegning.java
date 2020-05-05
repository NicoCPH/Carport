package PresentationLayer;

import FunctionLayer.ExceptionHandler;
import FunctionLayer.Svg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carport_Tegning extends Command {
    @Override
        String execute(HttpServletRequest request, HttpServletResponse response) throws ExceptionHandler {
            Svg svg = new Svg(800, 600, "0,0,800,600",0,0); // (ramme)
            svg.addRect(0,0,600,780); // øverste boks linje


        svg.addRect(0,35,4,780); // rem
        svg.addRect(0,565,4,780); // rem

        svg.addRect(150,32,10,10); // stolpe
        svg.addRect(400,32,10,10); // stolpe
        svg.addRect(650,32,10,10); // stolpe
        svg.addRect(150,562,10,10); // stolpe
        svg.addRect(400,562,10,10); // stolpe
        svg.addRect(650,562,10,10); // stolpe

        svg.addRect(55,0,600,2); // spær
        svg.addRect(110,0,600,2); // spær
        svg.addRect(165,0,600,2); // spær
        svg.addRect(220,0,600,2); // spær
        svg.addRect(275,0,600,2); // spær
        svg.addRect(330,0,600,2); // spær
        svg.addRect(385,0,600,2); // spær
        svg.addRect(440,0,600,2); // spær
        svg.addRect(495,0,600,2); // spær
        svg.addRect(550,0,600,2); // spær


        svg.addKryds(35,39 ,745, 565); // kryds linje
        svg.addKryds(745,35 ,35, 565); // kryds linje


        request.setAttribute("carporttegning", svg.toString());
        return "Forespoergsel_Succes";
    }
}
