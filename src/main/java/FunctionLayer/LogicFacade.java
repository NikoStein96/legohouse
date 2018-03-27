package FunctionLayer;

import DBAccess.UserMapper;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static OrderSample makeOrder(int height, int length, int width, String email) throws SQLException, ClassNotFoundException, LoginSampleException {
        OrderSample order = new OrderSample(height, width, length);
        UserMapper.createOrder(order, email);
        return order;
    }
    
    public static boolean deleteOrder(int id) throws ClassNotFoundException, SQLException, LoginSampleException{
        return UserMapper.deleteOrder(id);
    }
    
    public static ArrayList<OrderSample> showOrders() throws ClassNotFoundException, SQLException, LoginSampleException{
        ArrayList<OrderSample> order = null;
        return order = UserMapper.showOrders();
    }
    
    public static ArrayList<OrderSample> getCustomerOrder(String email) throws ClassNotFoundException, SQLException, LoginSampleException{
        ArrayList<OrderSample> order = null;
        return order = UserMapper.getCustomerOrders(email);
    }
}
