package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "help", new Help() );
        commands.put( "link", new Link());
        commands.put( "order", new Order());
        commands.put( "makeorder", new MakeOrder());
        commands.put( "employee", new Employee());
        commands.put( "employeeorder", new EmployeeOrder());
        commands.put( "delete", new EmployeeOrder());
        commands.put( "see", new Customer());
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException;

}
