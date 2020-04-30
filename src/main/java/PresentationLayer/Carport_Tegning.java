package PresentationLayer;

import FunctionLayer.ExceptionHandler;
import FunctionLayer.Svg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carport_Tegning extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ExceptionHandler {
        Svg svg = new Svg(800, 600, "0,0,800,600",0,0);
        svg.addRect(0,0,600,780);
        svg.addRect(0,35,4,780);
        svg.addRect(0,565,4,780);
        request.setAttribute("carporttegning", svg.toString());
        return "Carport_Tegning";
    }
}
