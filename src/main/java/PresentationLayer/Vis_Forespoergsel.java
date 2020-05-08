package PresentationLayer;

import FunctionLayer.Fejl_haendtering;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Vis_Forespoergsel extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Fejl_haendtering {
        return "Forside_Saelger";
    }
}
