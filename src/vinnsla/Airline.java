package src.vinnsla;
import java.util.ArrayList;
import java.util.List;

public class Airline {
    private String contactInfo;
    //private Customer[] customerInfo;
    private List<Customer> customerInfo = new ArrayList<Customer>();
    private String airlineName;

    public Airline(String name){
        airlineName = name;
    }

    public void setCustomerInfo(List<Customer> cos){
        customerInfo = cos;
    }

    public void setContactInfo(String info){
        contactInfo = info;
    }

    public List<Customer> getCustomerInfo(){
        return customerInfo;
    }

    public String getContactInfo(){
        return contactInfo;
    }

    public String getName(){
        return airlineName;
    }
}
