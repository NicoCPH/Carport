package PresentationLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
import FunctionLayer.Fejl_haendtering;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * One example on this could be this button: href="FrontController?target=redirect&destination=customerpage"
 * Destination hentes når man trykker på knappen inde i jsp siden.
 * FrontController?target=redirect&destination=customerpage
 * man sendes til java klassen redirect
 * hvor man har initializeret en String ved navn destination, som får en værdi
 * herefter går den ned i switch casen for at udføre sin opgave
 * og breaker til sidst
 */


public class Redirect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Fejl_haendtering {

        String destination = request.getParameter("destination");

        switch (destination) {

            case "index": request.setAttribute("message", "Index side"); break;
            case "Carport_Fladt": request.setAttribute( "message", "Login side"); break;
            case "Carpot_Rejsning": request.setAttribute( "message", "Rediger bruger side"); break;

        }
        return destination;
    }
}

