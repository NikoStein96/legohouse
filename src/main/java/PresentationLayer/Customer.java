package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderSample;
import com.mysql.cj.mysqlx.protobuf.MysqlxCrud;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Customer extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        
        ArrayList<OrderSample> orderList = null;
        
        request.getSession();
        String email = (String) request.getSession().getAttribute("email");
        out.print("<p>" + email + "</p>");
        
//        if(request.getParameter("command").equals("see")){
//            request.setAttribute("email", email);
//            return "customerorder";
//        } 
        
        if(request.getParameter("command").equals("see")){

            try {
                ArrayList<OrderSample> o = LogicFacade.getCustomerOrder(email);
                request.setAttribute("list", o);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MysqlxCrud.Delete.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MysqlxCrud.Delete.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "customerorder";
        }
        return null;
    }
    
}
