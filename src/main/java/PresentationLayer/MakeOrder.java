package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MakeOrder extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        try {
            LogicFacade.deleteOrder(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MakeOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MakeOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "makeorder";
    }
    
}