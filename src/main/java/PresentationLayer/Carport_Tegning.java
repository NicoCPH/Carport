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
        svg.addRect(150,560,10,10); // stolpe
        svg.addRect(400,560,10,10); // stolpe
        svg.addRect(650,560,10,10); // stolpe

        svg.addRect(0,0,0,0); // spær
        svg.addRect(0,0,0,0); // spær
        svg.addRect(0,0,0,0); // spær
        svg.addRect(0,0,0,0); // spær
        svg.addRect(0,0,0,0); // spær
        svg.addRect(0,0,0,0); // spær
        svg.addRect(0,0,0,0); // spær
        svg.addRect(0,0,0,0); // spær
        svg.addRect(0,0,0,0); // spær
        svg.addRect(0,0,0,0); // spær

        svg.addKryds(39,39 ,745, 565); // kryds linje
        svg.addKryds(745,39 ,39, 565); // kryds linje

        request.setAttribute("carporttegning", svg.toString());
        return "Carport_Tegning";
    }
}
