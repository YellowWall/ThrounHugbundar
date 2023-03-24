import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bookingControllerTest{
    private List<Booking> bookings = new ArrayList<Booking>();
    private bookingRepositiory bookingRepo;

    //private Customer customer;
    //private Flight flight;
    //private Booking booking;


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

    public void reserveSeat(String seatNumber){
        //Todo, veit ekki hvernir þetta á að virka
    }

    public void removeSeats(String seatNumber){
        //Todo, veit ekki hvernir þetta á að virka
    }


}
