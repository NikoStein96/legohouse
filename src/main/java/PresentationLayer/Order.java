package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LegoHouseAlgorithm;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderSample;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Order extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        int height = Integer.parseInt(request.getParameter("height"));
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));

        LegoHouseAlgorithm lego = new LegoHouseAlgorithm();

        ArrayList<Integer> bricks = lego.calc(height, length, width);

        request.setAttribute("longbrick", Integer.toString(bricks.get(0)));
        request.setAttribute("mediumbrick", Integer.toString(bricks.get(1)));
        request.setAttribute("shortbrick", Integer.toString(bricks.get(2)));
        request.setAttribute("longbrickw", Integer.toString(bricks.get(3)));
        request.setAttribute("mediumbrickw", Integer.toString(bricks.get(4)));
        request.setAttribute("shortbrickw", Integer.toString(bricks.get(5)));

        int finalLongBrick = ((bricks.get(0) + bricks.get(3)) * 2) * height;
        int finalMediumBrick = ((bricks.get(1) + bricks.get(4)) * 2) * height;
        int finalShortBrick = ((bricks.get(2) + bricks.get(5)) * 2) * height ;

        request.setAttribute("finallongbrick", finalLongBrick);
        request.setAttribute("finalmediumbrick", finalMediumBrick);
        request.setAttribute("finalshortbrick", finalShortBrick);
        String email = (String)request.getSession().getAttribute("email");
        
        try {
            LogicFacade.makeOrder(height, length, width, email);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return "order";
    }
}