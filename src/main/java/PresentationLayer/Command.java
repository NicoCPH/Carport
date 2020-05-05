package PresentationLayer;

import FunctionLayer.ExceptionHandler;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("forespoergsel", new Forespoergsel());
        commands.put("Carport_Rejsning", new Carport_Rejsning());
        commands.put("Carport_Fladt", new Carport_Fladt());
        commands.put( "redirect", new Redirect() );
        commands.put( "Forespoergsel_Succes", new Succes() );
        commands.put( "Forside_Kunde", new Forside_Kunde() );
        commands.put("Forside_Saelger", new Forside_Saelger() );

    }

    static Command from( HttpServletRequest request ) {
        String targetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws ExceptionHandler;

}
