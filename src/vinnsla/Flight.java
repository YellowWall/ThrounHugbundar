package src.vinnsla;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import junit.*;

public class Flight implements flightInterface {
    private String flightNo;
    private Date date;
    private Location loc;
    private int capacity;
    private float price;
    private List<String> seats;
    private List<String> seatsLeft;
    private char[] seatLetters= {'a', 'b', 'c', 'd', 'e', 'f'};

    public Flight(Date dat, Location loc,String flightNo, int cap) {
        date = dat;
        this.loc = loc;
        this.flightNo = flightNo;
        capacity = cap;
        seats = new ArrayList<>(cap);
        seatsLeft = new ArrayList<>(cap);

        for (int i = 1; i <= cap; i++) {
            for (int j = 0; j < 6; j++) {
                char row = (char)(i + '0');
                char seatLetter = seatLetters[j];
                String seat = new String(new char[] {row, seatLetter});
                seats.add(seat);
                seatsLeft.add(seat);
            }
        }
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
        return seatsLeft.toArray(new String[0]);
    }

    /*
     * seat must be a non-capital letter
     */
    @Override
    public void setSeatTaken(int row, char seat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSeatTaken'");
    }
    /*
     * seat must be a non-capital letter
     */
    @Override
    public void setSeatAvail(int x, char seat) {
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

    public static void main(String[] args) {
        Flight test = new Flight(null, null, null, 20);

    }

}
