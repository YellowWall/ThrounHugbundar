package src.vidmot;

import src.repositories.AirlineRepository;
import src.vinnsla.Airline;
import src.vinnsla.Customer;
import java.util.Iterator;


public class AirlineController {
    private AirlineRepository airlineRepo;
    private Airline thisAirline;

    public AirlineController(Airline airline){
        thisAirline = airline;
        airlineRepo = new AirlineRepository();
    }

    public Customer findCustomer(String name, String fligthNo){

        Iterator<Customer> it = thisAirline.getCustomerInfo().iterator();
        while (it.hasNext()) {
            Customer cus = it.next();
            if (cus.getName().equals(name)) {
                return cus;
            }
        }
        return null;
    }
    public Customer addCustomer(Customer customer){
        thisAirline.setCustomerInfo(airlineRepo.addCustomer(customer));;
        return customer;
    }
}
