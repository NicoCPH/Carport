package PresentationLayer;

import FunctionLayer.Fejl_haendtering;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 The purpose of UnknownCommand is to...

 @author kasper
 */
public class UnknownCommand extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws Fejl_haendtering {
        String msg = "Unknown command. Contact IT";
        throw new Fejl_haendtering( msg );
    }

}
