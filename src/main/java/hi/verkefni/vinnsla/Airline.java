package hi.verkefni.vinnsla;

import java.util.ArrayList;
import java.util.List;

public class Airline {
    private String contactInfo;
    //private Customer[] customerInfo;
    private List<hi.verkefni.vinnsla.Customer> customerInfo = new ArrayList<hi.verkefni.vinnsla.Customer>();
    private String airlineName;

    public Airline(String name) {
        airlineName = name;
    }

    public void setCustomerInfo(List<hi.verkefni.vinnsla.Customer> cos) {
        customerInfo = cos;
    }

    public void setContactInfo(String info) {
        contactInfo = info;
    }

    public List<hi.verkefni.vinnsla.Customer> getCustomerInfo() {
        return customerInfo;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getName() {
        return airlineName;
    }
}
