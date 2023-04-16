package src.vinnsla;
import java.util.Date;

public class Flight implements flightInterface {
    private String flightNo;
    private Date date;
    private Location loc;
    private int capacity;
    private float price;
    private String[] seats;

    public Flight(Date dat, Location loc,String flightNo, int cap) {
        date = dat;
        this.loc = loc;
        this.flightNo = flightNo;
        capacity = cap;
    }

    @Override
    public void setLocation(Location loc) {
        // TODO Auto-generated method stub
        // dno með þetta tbh, þegar við erum með setter og getter í sama class. Smá ruglingslegt að mínu mati
        this.loc = loc;
    }

    @Override
    public Location getLocation() {
        return loc;
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
        capacity = x;
    }

    @Override
    public int getCapacity() {
        // TODO Auto-generated method stub
        return capacity;
    }

    @Override
    public void setDate(Date date) {
        // TODO Auto-generated method stub
        this.date = date;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setFlightNo(String str) {
        flightNo = str;
    }

    @Override
    public String getFlightNo() {
        return flightNo;
      }

    @Override
    public void setPrice(Float fl) {
        // TODO Auto-generated method stub
        price = fl;
    }

    @Override
    public Float getPrice() {
        // TODO Auto-generated method stub
        return price;
    }

}
