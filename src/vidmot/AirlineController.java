package src.vidmot;

import src.repositories.AirlineRepository;
import src.vinnsla.Airline;

public class AirlineController {
    private AirlineRepository airlineRepo;
    private Airline thisAirline;

    public AirlineController(Airline airline){
        thisAirline = airline;
        airlineRepo = new AirlineRepository();
    }

    public Customer findCustomer(String name, String fligthNo){

    }
    public Customer addCustomer(Customer customer){

    }
}
