package src;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import src.Booking;
import src.Customer;
import src.Flight;
import src.Location;
import src.BookingRepositiory;

public class BookingController {
    private List<Booking> bookings = new ArrayList<Booking>();
    private BookingRepositiory bookingRepo;
    
    public List<Booking> getBookings(){
        return bookings;
    }

    public Booking createBooking(Booking booking,Customer customer){
        List<Booking> list = bookingRepo.createBooking(booking);
        bookings = list;
        return (Booking) list;
    }

    public Boolean cancelBooking(String bookingId){
        Iterator<Booking> it = bookings.iterator();
        while (it.hasNext()) {
            Booking b = it.next();
            if (bookingId.equals(b.getBookingId())) {
                if (bookingRepo.cancelBooking(b)) {
                    bookings = bookingRepo.getBookings();
                    return true;
                }
                else return false;
            }
        }
        return false;
    }

    public Boolean reserveSeat(String seatNumber){
        return false;
    }

    public void removeSeats(String seatNumber){
        //Todo, veit ekki hvernir þetta á að virka
    }
    
}
