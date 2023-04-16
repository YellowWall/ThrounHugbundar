package src.vinnsla;
import java.util.Date;

interface flightInterface{
	public void setLocation(Location loc);
	public Location getLocation();
	public String[] getSeatsLeft();
	public void setSeatTaken(int x,char a) throws Exception;
	public void setSeatAvail(int x,char a);
	public void setCapacity(int x);
	public int getCapacity();
	public void setDate(Date date);
	public Date getDate();
	public void setFlightNo(String str);
	public String getFlightNo();
	public void setPrice(Float fl);
	public Float getPrice();
}
