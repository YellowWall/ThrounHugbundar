package test.vinnsla;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import src.Booking;
import src.Customer;
import src.Flight;
import src.Location;

public class bookingControllerTest{
    private List<Booking> bookings = new ArrayList<Booking>();
    private bookingRepositiory bookingRepo;
    
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

    }

    public void removeSeats(String seatNumber){
        //Todo, veit ekki hvernir þetta á að virka
    }


}
	Location a = new Location("A","B");
	Flight f123 = new Flight(new Date(),a,"123",20);
   	Customer testingCustomer = new Customer("A",123,"A");
        Booking testbook = new Booking("123",testingCustomer);
        Booking testbook2 = new Booking("123",testingCustomer);
        Boolean seatget = testbook.reserveSeat("A12");
        Boolean seatget2 = testbook2.reserveSeat("A12");
        expect(seatget).toBeTrue();
        expect(seatget2).not.toBeTrue();
        
        
