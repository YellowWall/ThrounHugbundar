package src.vinnsla;
import java.util.Date;

public class Flight implements flightInterface {
    private String flightNo;
    private Date date;
    private Location loc;
    private int capacity;

    public Flight(Date dat, Location loc,String flightNo, int cap) {
        date = dat;
        this.loc = loc;
        this.flightNo = flightNo;
        capacity = cap;
    }

    @Override
    public void setLocation(Location loc) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLocation'");
    }

    @Override
    public Location getLocation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLocation'");
    }

    @Override
    public String[] getSeatsLeft() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSeatsLeft'");
    }

    @Override
    public void setSeatTaken(int x, char a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSeatTaken'");
    }

    @Override
    public void setSeatAvail(int x, char a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSeatAvail'");
    }

    @Override
    public void setCapacity(int x) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCapacity'");
    }

    @Override
    public int getCapacity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCapacity'");
    }

    @Override
    public void setDate(Date date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDate'");
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setFlightNo(String str) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFlightNo'");
    }

    @Override
    public String getFlightNo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFlightNo'");
    }

    @Override
    public void setPrice(Float fl) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPrice'");
    }

    @Override
    public Float getPrice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPrice'");
    }

}
