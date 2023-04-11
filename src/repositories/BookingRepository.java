package src.repositories;
import java.util.List;

import src.vinnsla.Booking;
import src.vinnsla.Flight;
import src.vinnsla.Seat;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookingRepository {

    private final String url = "jdbc:postgresql://dpg-cghgmrg2qv23kcqt4800-a.frankfurt-postgres.render.com/hbv401g_database";
    private static String user = "hbv401g_database_user";
    private static String password = "f6oiteRl2PFv8NuE0cCGZP8XpBbMg7SS";
    public BookingRepository(){
    }  
    public void main(){
        Connection conn = null;
        ResultSet resultSet = null;
        try{conn = DriverManager.getConnection(url,user,password);
            String selectSql = "select * from flights";
            Statement stmnt = conn.createStatement();
            resultSet= stmnt.executeQuery(selectSql);
            System.out.println(selectSql);
            while(resultSet.next()){
                System.out.print(resultSet.getString(1));
            }
        }catch(SQLException e){

        }

    }

    


    public Seat[] getInFlightSeats(Flight flight){
        Connection conn = null;
        ResultSet resultSet = null;
        try{ conn = DriverManager.getConnection(url,user,password);
            String selectSql = "Select Seats.seat "+ 
            "from Seats Left Join "+ 
            "tickets on Seats.ticket = ticket.id "+ 
            "left join Bookings on "+ 
            "ticket.booking = Bookings.id "+ 
            "left join DateFlight on "+ 
            "Bookings.flight = DateFlight.id "+ 
            "left join Flight on "+
            "DateFlight.flight = Flight.id "+
            "where Flight.FlightNum = "+ flight.getFlightNo()+
            " and DateFlight.Date = "+ flight.getDate();
            Statement stmnt = conn.createStatement();
            resultSet= stmnt.executeQuery(selectSql);
            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
            }return new Seat[0];
        }catch(SQLException e){
            e.printStackTrace();
            return new Seat[0];
        }
        

    }
    public int getSpaceInFlight(Flight flight){
        try(Connection connection = DriverManager.getConnection(connectionUrl);
        )
        {

        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    public List<Booking> getBookings() {
        try(Connection connection = DriverManager.getConnection(connectionUrl);){

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public List<Booking> createBooking(Booking booking){
        try(Connection connection = DriverManager.getConnection(connectionUrl);){

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public boolean cancelBooking(Booking booking){
        try(Connection connection = DriverManager.getConnection(connectionUrl);){

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public boolean reserveSeats(){
        try(Connection connection = DriverManager.getConnection(connectionUrl);){

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public boolean createTicket(){
        try(Connection connection = DriverManager.getConnection(connectionUrl);){

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public boolean removeTicket(){
        try(Connection connection = DriverManager.getConnection(connectionUrl);){

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public boolean removeSeat(){
        try(Connection connection = DriverManager.getConnection(connectionUrl);){

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Booking updateBooking(Booking booking){
        try(Connection connection = DriverManager.getConnection(connectionUrl);){

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}