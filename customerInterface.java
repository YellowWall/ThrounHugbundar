import java.util.ArrayList;

interface customerInterface{
	public void setName(String name);
	public void setSSN(int SSN);
	public void setEmail(String email);
	public void addBooking(Booking booking);
	public ArrayList<Booking> getBookings();
}
