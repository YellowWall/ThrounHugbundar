import java.util.ArrayList;
import java.util.List;

public class bookingControllerTest{
    private String seatNumber;
    private String service;
    private int priceExtra;
    private String bookingId;
    private int numTickets;

    private Customer customer;
    private Flight flight;
    private Booking booking;


    public Flight getFlight(){
        return this.flight;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public String setBookingId(String bookingId) {
        this.bookingId = bookingId;
        return bookingId;
    }

    public int setNumTickets(int numTickets) {
        this.numTickets = numTickets;
        return numTickets;
    }

    public int setPriceExtra(int priceExtra) {
        this.priceExtra = priceExtra;
        return priceExtra;
    }

    public String setService(String service) {
        this.service = service;
        return service;
    }

    public String setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
        return seatNumber;
    } 

    public Booking getBookings(Booking booking){
        List<Booking> list = new ArrayList<Booking>();
        return (Booking) list;
    }

    public Booking createBooking(Booking booking,Customer customer){
        List<Booking> list = new ArrayList<Booking>();
        return (Booking) list;
    }

    public Boolean cancelBooking(String bookingId){
        return null;
        /* Losna við pirrandi villu */
    }

    public String reserveSeat(String seatNumber){
        return seatNumber;
    }

    public Boolean removeSeats(String seatNumber){
        return null; 
        /* Losna við pirrandi villu */
    }


}
