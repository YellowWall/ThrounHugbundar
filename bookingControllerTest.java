public class bookingControllerTest{
    private String seatNumber;
    private String service;
    private int priceExtra;
    private String bookingId;
    private int numTickets;

    private Customer customer;
    private Flight flight;
    private Booking booking;


    public Flight getFlight(){
        return this.flight;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }

    public void setPriceExtra(int priceExtra) {
        this.priceExtra = priceExtra;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void getBookings(){
        
    }

    public Booking createBooking(Booking booking,Customer customer){
        return booking;
    }

    public Boolean cancelBooking(String bookingId){
        return null;
        /* Losna við pirrandi villu */
    }

    public String reserveSeat(String seatNumber){
        return seatNumber;
    }

    public Boolean removeSeats(String seatNumber){
        return null; 
        /* Losna við pirrandi villu */
    }


}
