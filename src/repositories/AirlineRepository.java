package src.repositories;
import java.util.List;
import java.util.Locale;
import src.vinnsla.Booking;
import src.vinnsla.Customer;
import src.vinnsla.Flight;
import src.vinnsla.Seat;
import java.text.SimpleDateFormat;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
public class AirlineRepository {
    private final String url = "jdbc:postgresql://dpg-cghgmrg2qv23kcqt4800-a.frankfurt-postgres.render.com/hbv401g_database";
    private static String user = "hbv401g_database_user";
    private static String password = "f6oiteRl2PFv8NuE0cCGZP8XpBbMg7SS";
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

    public AirlineRepository(){
        
    }

    public List<Customer> findCustomer(String name, String flightNo){
        Connection conn = null;
        ResultSet resultSet = null;
        try {
            conn = DriverManager.getConnection(url,user,password);
            String query = "select * from customer where Name =" + name;
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            List<Customer> returnList = new ArrayList<>();
            while (resultSet.next()) {
                Customer cus = new Customer(resultSet.getString("Name"), resultSet.getInt("SSN"),resultSet.getString("email") );
                returnList.add(cus);
            }
            return returnList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Customer> addCustomer(Customer customer){
        return null;
    }

    public Customer updateCustomer(Customer customer){
        return null;
    }
}
