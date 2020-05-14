package PresentationLayer;

import DBAccess.Forespoergsels_Mapper;
import FunctionLayer.Fejl_haendtering;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Opdater_pris extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Fejl_haendtering {


        try {
            int id = Integer.parseInt(request.getParameter("id")); // gets input from user.

            double pris = Double.parseDouble(request.getParameter("pris"));

            Forespoergsels_Mapper.Update_Pris(id, pris);

        }catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        return "Forside_Saelger";
    }
}
