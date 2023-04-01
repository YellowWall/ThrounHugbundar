package src.vinnsla;

public class Airline {
    private String contactInfo;
    private Customer[] customerInfo;
    private String airlineName;

    public Airline(String name){
        airlineName = name;
    }

    public void setContactInfo(String info){
        contactInfo = info;
    }

    public Customer[] getCustomerInfo(){
        return customerInfo;
    }

    public String getContactInfo(){
        return contactInfo;
    }

    public String getName(){
        return airlineName;
    }
}
