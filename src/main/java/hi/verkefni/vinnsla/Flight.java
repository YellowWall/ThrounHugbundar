package hi.verkefni.vinnsla;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Flight implements flightInterface {
    private String flightNo;
    private Date date;
    private Location loc;
    private int capacity;
    private float price;
    private List<String> seats;
    private List<String> seatsLeft;
    private char[] seatLetters = {'a', 'b', 'c', 'd', 'e', 'f'};

    public Flight(Date dat, Location loc, String flightNo, int cap) {
        date = dat;
        this.loc = loc;
        this.flightNo = flightNo;
        capacity = cap;
        seats = new ArrayList<>(cap);
        seatsLeft = new ArrayList<>(cap);
        int capNumber = 1;
        for (int i = 1; capNumber <= cap; i++) {
            for (int j = 0; j < 6; j++) {
                String row = String.valueOf(i);
                char seatLetter = seatLetters[j];
                String seat = row + seatLetter;
                seats.add(seat);
                seatsLeft.add(seat);
                capNumber++;
            }
        }
    }

    @Override
    public void setLocation(Location loc) {
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
    public void setSeatTaken(int row, char seat) throws Exception {

        String takenSeat = String.valueOf(row) + seat;
        if (seatsLeft.contains(takenSeat)) {
            seatsLeft.remove(takenSeat);
        } else {
            throw new Exception("Seat already taken");
        }
    }

    /*
     * seat must be a non-capital letter
     */
    @Override
    public void setSeatAvail(int row, char seat) {
        String availSeat = String.valueOf(row) + seat;
        seatsLeft.add(availSeat);
    }

    @Override
    public void setCapacity(int x) {
        capacity = x;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void setDate(Date date) {
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
        price = fl;
    }

    @Override
    public Float getPrice() {
        return price;
    }
/*
    public static void main(String[] args) {
        Flight testflug = new Flight(null, null, null, 30);
        try {
            testflug.setSeatTaken(3, 'b');
            testflug.setSeatTaken(3, 'b');
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String[] saeti = testflug.getSeatsLeft();

        for (String string : saeti) {
            System.out.println(string);
        }
    }*/

}
