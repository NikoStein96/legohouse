package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderSample;
import com.mysql.cj.mysqlx.protobuf.MysqlxCrud.Delete;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        ArrayList<OrderSample> orderList = null;

        if (request.getParameter("command").equals("employeeorder")) {
            try {
                orderList = LogicFacade.showOrders();
                request.setAttribute("list", orderList);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (request.getParameter("command").equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                LogicFacade.deleteOrder(id);
                ArrayList<OrderSample> o = LogicFacade.showOrders();
                request.setAttribute("list", o);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "employeeorder";
    }

}
