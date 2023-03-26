package src.vinnsla;
import java.util.Date;

interface bookingInterface{
	public Date getDate();
	public String getFlightNo();
	public Customer getCustomer();
	public int getNumSeats();
	public void addSeat(int x,char a);
	public String[] getSeats();
	public String[] getService();
	public void setExtraPrice(Double fl);
	public Double getExtraPrice();
	public void setBookingId(String str);
	public String getBookingId();
}
