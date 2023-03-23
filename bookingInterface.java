interface bookingInterface{
	public Date getDate();
	public String getFlightNo();
	public Customer getCustomer();
	public int getNumSeats();
	public void addSeat(int x,char a);
	public String[] getSeats();
	public Enum[] getService();
	public void setExtraPrice(Float fl);
	public Float getExtraPrice();
	public void setBookingId(String str);
	public String getBookingId();
}
