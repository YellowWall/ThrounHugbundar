import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Booking implements bookingInterface {
    private Date date;
    private String flightNo;
    private Customer customer;
    private ArrayList<String> seats = new ArrayList<String>();
    private int numSeats = 0;
    private ArrayList<String> services = new ArrayList<String>();
    private String bookingId;
    private Float extraPrice;

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getFlightNo() {
        return flightNo;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public int getNumSeats() {
        return numSeats;
    }

    @Override
    public void addSeat(int x, char a) {
        seats.add(x + a + "");
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
    public void setExtraPrice(Float fl) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setExtraPrice'");
    }

    @Override
    public Float getExtraPrice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getExtraPrice'");
    }

    @Override
    public void setBookingId(String str) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setBookingId'");
    }

    @Override
    public String getBookingId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookingId'");
    }

}
