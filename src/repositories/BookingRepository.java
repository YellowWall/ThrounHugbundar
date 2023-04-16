package src.repositories;
import java.util.List;
import java.util.Locale;

import org.postgresql.core.Tuple;
import src.vinnsla.Booking;
import src.vinnsla.Customer;
import src.vinnsla.Flight;
import src.vinnsla.Seat;
import src.vinnsla.Ticket;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BookingRepository {

    private final String url = "jdbc:postgresql://dpg-cghgmrg2qv23kcqt4800-a.frankfurt-postgres.render.com/hbv401g_database";
    private static String user = "hbv401g_database_user";
    private static String password = "f6oiteRl2PFv8NuE0cCGZP8XpBbMg7SS";
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
    public BookingRepository(){
    }  
    public void run(){
        Connection conn = null;
        ResultSet resultSet = null;
        try{conn = DriverManager.getConnection(url,user,password);
            String selectSql = "select flightNum from flight";
            Statement stmnt = conn.createStatement();
            resultSet= stmnt.executeQuery(selectSql);
            while(resultSet.next()){
                System.out.print(resultSet.getString(1));
            }
        }catch(SQLException e){

        }

    }

    


    public Seat[] getInFlightSeats(Flight flight){
        Connection conn = null;
        ResultSet resultSet = null;
        List<Seat> myList = new ArrayList<>();
        try{ conn = DriverManager.getConnection(url,user,password);
            String selectSql = "Select Seats.seat as seat, ticket.id as id "+ 
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
                String seat = resultSet.getString("seat");
                Seat addSeat = new Seat(resultSet.getInt("id"),Integer.parseInt(seat.substring(1)),seat.charAt(0));
                myList.add(addSeat);
            }return (Seat[])myList.toArray();
        }catch(SQLException e){
            e.printStackTrace();
            return (Seat[])myList.toArray();
        }
        

    }
    public int getSpaceInFlight(Flight flight){
        Connection conn = null;
        ResultSet resultSet = null;
        int seats_left = 0;
        try{ conn = DriverManager.getConnection(url,user,password);
            String query = "select DateFlight.Total_Seats, DateFlight.seats_left from DateFlight left join Flight on DateFlight.flight = Flight.id " +
            "where flight.FlightNum = '" + flight.getFlightNo() + "' and DateFlight.day = " + flight.getDate().toString();
            Statement stmnt = conn.createStatement();
            resultSet = stmnt.executeQuery(query);
            while(resultSet.next()){
                seats_left = resultSet.getInt(2);
                System.out.println(resultSet.getInt(1) +"  "+resultSet.getInt(2));
            } return seats_left;
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }

    }
    private int getCustomerIdBySSN(int ssn){
        Connection conn = null;
        ResultSet resultSet = null;
        try{
            conn = DriverManager.getConnection(url, user, password);
            String select ="select id from customer where ssn = " + ssn + ";";
            Statement stm = conn.createStatement();
            resultSet = stm.executeQuery(select);
            if(resultSet.next()){
                return resultSet.getInt("id");
            }
            return 0;
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }
    }
    private int getFlightIdbyDateandFlightNum(Date date, String flightnum){
        Connection conn = null;
        ResultSet resultSet = null;
        try{conn = DriverManager.getConnection(url, user, password);
            String select = "select DateFlight.id as id from DateFlight"+
                " left join flight on DateFlight.flight = flight.id " +
                " Where flight.FlightNum = '" +flightnum+"' and DateFlight.date = " + date.toString() +";";
            Statement stm = conn.createStatement();
            resultSet = stm.executeQuery(select);
            if(resultSet.next()){
                return resultSet.getInt("id");
            }
            return 0;
        }catch(SQLException e){
            return 0;
        }
    }
    private ArrayList<Ticket> getBookingTickets(int bookingId){
        Connection conn = null;
        ResultSet resultSet = null;
        ArrayList<Ticket> myList = new ArrayList<>();
        try{
            conn = DriverManager.getConnection(url, user, password);
            String sel = "select id, passport, SeatAssigned, name where booking = "+bookingId+";";
            Statement stm = conn.createStatement();
            resultSet = stm.executeQuery(sel);
            while(resultSet.next()){
                Ticket tik = new Ticket(resultSet.getString("name"));
                String seat = null;
                ResultSet rs = null;
                if(resultSet.getBoolean("SeatAssigned")){
                    String select = "select seat from Seats where ticket = "+resultSet.getByte("id")+";";
                    Statement statm = conn.createStatement();
                    rs = statm.executeQuery(select);
                    if(rs.next()){
                        seat = rs.getString("seat");
                        tik.setSeat(seat);
                    }
                }
                tik.setPassport(resultSet.getString("passport"));
                myList.add(tik);
            }
            return myList;
        }catch(SQLException e){
            e.printStackTrace();
            return myList;
        }

    }
    public ArrayList<Booking> getBookings(Customer customer) {
        Connection conn = null;
        ResultSet resultSet = null;
        ArrayList<Booking> myList = new ArrayList<>();
        try{ conn = DriverManager.getConnection(url,user,password);
            String sel = "select DateFlight.Date as date,booking.bookingId booking.id  as id, flight.flightNum as flightnum, Bookings.seats as seats  from Bookings left join flight on bookings.flight = DateFlight.id "+
                "left join flight on DateFlight.flight = flight.id " +
                "left join customer on bookings.customer = customer.id " +
                "where customer SSN = " + customer.getSSN() + ";";
            Statement stm = conn.createStatement();
            resultSet = stm.executeQuery(sel);
            while(resultSet.next()){
                int bookingId = resultSet.getInt("id");
                ArrayList<Ticket> tickets = getBookingTickets(bookingId);
                ArrayList<String> seats = new ArrayList<>();
                for(int i = 0; i> tickets.size();i++){
                    if(tickets.get(i).getSeat()!=null){
                        seats.add(tickets.get(i).getSeat());
                    }
                }
                Date date = new Date();
                try{
                    date = formatter.parse(resultSet.getString("date"));
                }catch(ParseException e){
                    System.out.println(e.toString());
                }
                Booking book = new Booking(resultSet.getString("flightnum"), customer,date);
                book.setSeats(seats);
                book.setNumSeats(resultSet.getInt("seats"));
                book.setBookingId(resultSet.getString("bookingId"));
                myList.add(book);
            }
            
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
        int flightid = getFlightIdbyDateandFlightNum(booking.getDate(), booking.getFlightNo());
        int custId = getCustomerIdBySSN(booking.getCustomer().getSSN());
        try{ conn = DriverManager.getConnection(url,user,password);
            if(flightid!=0 && custId!=0){
                String insert = "insert into bookings (bookingId,customer,flight) values("+booking.getBookingId()+","+custId+","+flightid+";";
                Statement stm = conn.createStatement();
                resultSet = stm.executeQuery(insert);
            }
            return getBookings(booking.getCustomer());
        }catch(SQLException e){
            e.printStackTrace();
            return myList;
        }

    }

    public boolean cancelBooking(Booking booking){
        Connection conn = null;
        ResultSet resultSet = null;
        try{ conn = DriverManager.getConnection(url,user,password);
            String getId = "delete from bookings where bookingId =" + booking.getBookingId()+" returning 1;";
            Statement stm = conn.createStatement();
            resultSet = stm.executeQuery(getId);
            if(!resultSet.next()){
                return false;
            }
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
    public static void main(String[] args) {
        BookingRepository app = new BookingRepository();
        System.out.println("running");
        app.run();
    }
}