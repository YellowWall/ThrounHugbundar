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
import java.util.Date;

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
        Connection conn = null;
        ResultSet resultSet = null;
        try{ conn = DriverManager.getConnection(url,user,password);
            return 1;

        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }

    }
    public List<Booking> getBookings() {
        Connection conn = null;
        ResultSet resultSet = null;
        List<Booking> myList = new ArrayList<>();
        try{ conn = DriverManager.getConnection(url,user,password);
            return myList;
        }catch(SQLException e){
            e.printStackTrace();
            return myList;
        }

    }

    public List<Booking> createBooking(Booking booking){
        Connection conn = null;
        ResultSet resultSet = null;
        List<Booking> myList = new ArrayList<>();
        try{ conn = DriverManager.getConnection(url,user,password);
            return myList;
        }catch(SQLException e){
            e.printStackTrace();
            return myList;
        }

    }

    public boolean cancelBooking(Booking booking){
        Connection conn = null;
        ResultSet resultSet = null;
        try{ conn = DriverManager.getConnection(url,user,password);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean reserveSeats(){
        Connection conn = null;
        ResultSet resultSet = null;
        try{ conn = DriverManager.getConnection(url,user,password);
            return true;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean createTicket(){
        Connection conn = null;
        ResultSet resultSet = null;
        try{ conn = DriverManager.getConnection(url,user,password);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean removeTicket(){
        Connection conn = null;
        ResultSet resultSet = null;
        try{ conn = DriverManager.getConnection(url,user,password);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeSeat(){
        Connection conn = null;
        ResultSet resultSet = null;
        try{ conn = DriverManager.getConnection(url,user,password);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public Booking updateBooking(Booking booking){
        Connection conn = null;
        ResultSet resultSet = null;
        try{ conn = DriverManager.getConnection(url,user,password);
            return new Booking("not1",new Customer("test", 0, "test@test.is"),new Date());
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}