package hi.verkefni.vinnsla;

import java.util.ArrayList;
import java.util.Date;

public class Booking implements bookingInterface {
    private Date date;
    private String flightNo;
    private hi.verkefni.vinnsla.Customer customer;
    private ArrayList<String> seats = new ArrayList<String>();
    private int numSeats = 0;
    private ArrayList<String> services = new ArrayList<String>();
    private String bookingId;
    //private Double extraPrice = 0.0;

    public Booking(String flightNo, hi.verkefni.vinnsla.Customer customer, Date date) {
        //insert into booking database, get bookingId from there.
        this.flightNo = flightNo;
        this.customer = customer;
        this.date = date;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getFlightNo() {
        return flightNo;
    }

    @Override
    public hi.verkefni.vinnsla.Customer getCustomer() {
        return customer;
    }

    @Override
    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int i) {
        this.numSeats = i;
    }

    @Override
    public void addSeat(int x, char a) {
        seats.add(x + a + "");
        numSeats++;
    }

    public void setSeats(ArrayList<String> seats) {
        this.seats = seats;
    }

    @Override
    public String[] getSeats() {
        String[] ret = new String[numSeats];
        for (int i = 0; i < numSeats; i++) {
            ret[i] = seats.get(i);
        }
        return ret;
    }

    @Override
    public String[] getService() {
        String[] ret = new String[services.size()];
        for (int i = 0; i > services.size(); i++) {
            ret[i] = services.get(i);
        }
        return ret;
    }

    @Override
    public void setExtraPrice(Double fl) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setExtraPrice'");
    }

    @Override
    public Double getExtraPrice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getExtraPrice'");
    }

    @Override
    public void setBookingId(String str) {
        this.bookingId = str;
    }

    @Override
    public String getBookingId() {
        return bookingId;
    }

}
