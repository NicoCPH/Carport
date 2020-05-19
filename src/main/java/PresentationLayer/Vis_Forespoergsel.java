package PresentationLayer;

import FunctionLayer.Fejl_haendtering;
import FunctionLayer.LogicFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class Vis_Forespoergsel extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Fejl_haendtering {
        try {
            String email = request.getParameter("email");
            if (LogicFacade.forespoergsel(email).size() > 0) {
                LogicFacade.forespoergsel(email).clear();
            }
            request.setAttribute("showorders", new ArrayList<>(LogicFacade.forespoergsel(email)));
        } catch(Fejl_haendtering exceptionHandler){
                exceptionHandler.printStackTrace();
            }

        return "Forside_Saelger";
    }
}
