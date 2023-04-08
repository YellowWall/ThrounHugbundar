package src.repositories;
import java.util.List;

import src.vinnsla.Booking;
import src.vinnsla.Customer;
import src.vinnsla.Flight;
import src.vinnsla.Seat;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
public class AirlineRepository {
    private String connectionUrl = "jdbc:sqlserver://dpg-cghgmrg2qv23kcqt4800-a.frankfurt-postgres.render.com/hbv401g_database;"
        + "database=hbv401g_database;"
        + "user=hbv401g_database_user@yourserver;"
        + "password=f6oiteRl2PFv8NuE0cCGZP8XpBbMg7SS;"
        + "encrypt=true;"
        + "trustServerCertificate=true;"
        + "loginTimeout=30;";

    public AirlineRepository(){
        
    }

    public List<Customer> findCustomer(String name, String flightNo){

    }

    public List<Customer> addCustomer(Customer customer){

    }

    public Customer updateCustomer(Customer customer){

    }
}
