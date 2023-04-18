package src.repositories;
import java.util.List;
import src.vinnsla.Customer;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;


import java.util.ArrayList;
public class AirlineRepository {
    private final String url = "jdbc:postgresql://dpg-cghgmrg2qv23kcqt4800-a.frankfurt-postgres.render.com/hbv401g_database";
    private static String user = "hbv401g_database_user";
    private static String password = "f6oiteRl2PFv8NuE0cCGZP8XpBbMg7SS";

    public AirlineRepository(){
        
    }

    public List<Customer> findCustomer(String name, String flightNo){
        Connection conn = null;
        ResultSet resultSet = null;
        List<Customer> returnList = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url,user,password);
            String query = "select Customer.Name as name, Customer.SSN as SSN, Customer.email as email"+
            "from Customer left Join Bookings on Customer.id = Bookings.customer" +
            "left join DateFligth on Bookins.flight = DateFlight.id" + 
            "left join Flight on DateFlight.flight = Flight.id"
            +"where Customer Name = '"+ name 
            +"' and Flight.FlightNum = " + flightNo;
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Customer cus = new Customer(resultSet.getString("Name"), resultSet.getInt("SSN"),resultSet.getString("email") );
                returnList.add(cus);
            }
            return returnList;
        } catch (SQLException e) {
            e.printStackTrace();
            return returnList;
        }
    }

    public List<Customer> addCustomer(Customer customer){
        Connection conn = null;
        ResultSet resultSet = null;
        List<Customer> returnList = new ArrayList<>();
        Customer cus = null;
        try {
            conn = DriverManager.getConnection(url,user,password);
            String stmnt = "INSERT INTO Customer (name,ssn,email) VALUES ('" + customer.getName()
            + "', " + customer.getSSN() + ", '" + customer.getEmail() + "')";
            Statement statement = conn.createStatement();
            statement.executeUpdate(stmnt);

            // Raðar síðan öllum Customers í lista og skilar honum svo eftir að nýja er bætt við
            String query = "SELECT Name, SSN, email FROM Customer";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                cus = new Customer(resultSet.getString("Name"), resultSet.getInt("SSN"),resultSet.getString("email") );
                returnList.add(cus);
            }
            return returnList;
        } catch (SQLException e) {
            e.printStackTrace();
            return returnList;
        }
    }

    public Customer updateCustomer(Customer customer){
        Connection conn = null;
        Customer cus = null;
        try {
            conn = DriverManager.getConnection(url,user,password);
            String stmnt = "UPDATE Customer" +
            "SET Name = '" + customer.getName() + 
            "' , SSN = " + customer.getSSN() +
            " , email = '" + customer.getEmail() +
            "' " +
            "where SSN = " + customer.getSSN();
            Statement statement = conn.createStatement();
            statement.executeUpdate(stmnt);
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            return cus;
        }
    }
}
