package hi.verkefni.vinnsla;

import hi.verkefni.repositories.BookingRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BookingController {
    private List<Booking> bookings = new ArrayList<Booking>();
    private BookingRepository bookingRepo;
    private hi.verkefni.vinnsla.Customer customer = null;


    public BookingController() {
        bookingRepo = new BookingRepository();
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public Booking findBookingByid(String str) {
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookingId() == str) {
                return bookings.get(i);
            }
        }
        return null;
    }

    public String getFlightNo(String str) {
        Booking book = findBookingByid(str);
        if (book != null) {
            return book.getFlightNo();
        }
        return null;
    }

    public Date getDate(String str) {
        Booking book = findBookingByid(str);
        if (book != null) {
            return book.getDate();
        }
        return null;
    }

    public Booking createBooking(Booking booking, hi.verkefni.vinnsla.Customer customer) {
        List<Booking> list = bookingRepo.createBooking(booking);
        bookings = list;
        return (Booking) list;
    }

    public Boolean cancelBooking(String bookingId) {
        Iterator<Booking> it = bookings.iterator();
        while (it.hasNext()) {
            Booking b = it.next();
            if (bookingId.equals(b.getBookingId())) {
                if (bookingRepo.cancelBooking(b)) {
                    bookings = bookingRepo.getBookings(customer);
                    return true;
                } else return false;
            }
        }
        return false;
    }

    public void reserveSeat(String seatNumber) {

    }

    public void removeSeats(String seatNumber) {
        //Todo, veit ekki hvernir þetta á að virka
    }

    public void setCustomer(hi.verkefni.vinnsla.Customer customer) {
        this.customer = customer;
    }

}
