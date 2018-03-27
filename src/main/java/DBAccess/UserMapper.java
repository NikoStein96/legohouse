package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderSample;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * The purpose of UserMapper is to...
 *
 * @author kasper
 */
public class UserMapper {

    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static void createOrder(OrderSample order, String email) throws SQLException, ClassNotFoundException, LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (height, length, width, userid) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getHeigh());
            ps.setInt(2, order.getLength());
            ps.setInt(3, order.getWidth());
            ps.setInt(4, UserMapper.getCustomerId(email));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            order.setId(id);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<OrderSample> showOrders() throws ClassNotFoundException, SQLException, LoginSampleException {
            ArrayList<OrderSample> order = new ArrayList();
        try {


            Connection con = Connector.connection();
            String SQL = "SELECT * from useradmin.orders";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            
            int id = rs.getInt("idorder");
            int height = rs.getInt("height");
            int length = rs.getInt("length");
            int width = rs.getInt("width");
            
            OrderSample o = new OrderSample(height, length, width);
            o.setId(id);
            order.add(o);
            }
            return order;
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
    
    public static boolean deleteOrder(int id) throws ClassNotFoundException, SQLException, LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "DELETE FROM `useradmin`.`orders` WHERE `idorder`=?;";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
    public static int getCustomerId(String email) throws ClassNotFoundException, SQLException, LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id from useradmin.users where email = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            
            int id = rs.getInt("id");
            return id;
            }
            return 0;
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
    public static ArrayList<OrderSample> getCustomerOrders(String email) throws ClassNotFoundException, SQLException, LoginSampleException {
        ArrayList<OrderSample> order = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * from useradmin.orders where userid = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, getCustomerId(email));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            
            int id = rs.getInt("idorder");
            int height = rs.getInt("height");
            int length = rs.getInt("length");
            int width = rs.getInt("width");
            
            OrderSample o = new OrderSample(height, length, width);
            o.setId(id);
            order.add(o);
            
            }
            return order;
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
}
