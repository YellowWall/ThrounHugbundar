import java.util.ArrayList;

public class Customer implements customerInterface{
	private String name = null;
	private int SSN;
	private String email = null;
	private ArrayList<Booking> bookings = new ArrayList();

	@Override
	public void setName(String str) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setName'");
	}

	@Override
	public void setSSN(int x) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setSSN'");
	}

	@Override
	public void setEmail(String str) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setEmail'");
	}

	@Override
	public void addBooking(Booking book) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addBooking'");
	}

	@Override
	public ArrayList<Booking> getBookings() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getBookings'");
	}

}
