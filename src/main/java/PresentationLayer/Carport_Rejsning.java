package PresentationLayer;

import FunctionLayer.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carport_Rejsning extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ExceptionHandler {
        return "Carport_Rejsning";
    }
}
