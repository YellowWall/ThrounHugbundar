import java.util.ArrayList;

interface customerInterface{
	public void setName(String str);
	public void setSSN(int x);
	public void setEmail(String str);
	public void addBooking(Booking book);
	public ArrayList<Booking> getBookings();
}
