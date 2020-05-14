package PresentationLayer;

import DBAccess.Forespoergsels_Mapper;
import FunctionLayer.Fejl_haendtering;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class Vis_Forespoergsel extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Fejl_haendtering {
        try {
            String email = request.getParameter("email");
            if (Forespoergsels_Mapper.Alle_Forespoerelser(email).size() > 0) {
                Forespoergsels_Mapper.Alle_Forespoerelser(email).clear();
            }
            request.setAttribute("showorders", new ArrayList<>(Forespoergsels_Mapper.Alle_Forespoerelser(email)));
        } catch(Fejl_haendtering exceptionHandler){
                exceptionHandler.printStackTrace();
            }

        return "Forside_Saelger";
    }
}
