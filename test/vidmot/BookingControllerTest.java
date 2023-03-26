package test.vidmot;
import org.junit.*;

import src.vinnsla.*;

import static org.junit.Assert.*;
import java.util.Date;
import java.beans.Transient;
import java.time.LocalDateTime;
public class BookingControllerTest {
    private BookingController testbooker;
    private BookingRepository bookingRepo;
    private String bookingNum1;
    private String bookingNum2;
    @Before
    public void setUp() { testbooker = new BookingController();
    bookingRepo = new BookingRepository();
    Location loc = new Location("fra","til");
    Flight testflight = new Flight(new Date(),loc,"123",12);
   	Customer testingCustomer = new Customer("A",123,"A");
    Customer testingCustomer2 = new Customer("B",234,"B");
    Booking testbook = new Booking("123",testingCustomer,new Date());
    bookingNum1 = testbook.getBookingNum();
    bookingNum2 = testbook2.getBookingNum();
    Booking testbook2 = new Booking("123",testingCustomer2,new Date());
    testbooker.addBooking(testbook);
    testbooker.addBooking(testbook2);
    };
    @After
    public void tearDown() { testbooker = null;
    bookingRepo = null; }
    @Test
    public void testSomeBehavior() {
    ...
    assert...(...);
}   
    @test
    public void testAddingSeatToBooking(){
        setUp();
        //bætum við sæti á booking 1
        testbooker.addSeat(bookingNum1,"A1");
        //það ætti að vera einum færri sæti eftir í fluginu okkar
        assertequals(testbooker.getNumSeatsLeft(
            testbooker.getFlightNo(bookingNum1),
            testbooker.getFlightDate(bookingNum1)),11);
        //booking ætti að innihalda umbeðið sæti í lista sínum af sætum.
        String[] seats = testbooker.getSeats(bookingNum1);
        Boolean seat = false;
        for(int i = 0; i<seats.length;i++){
            if(seats[i]!=null){
                if(seats[i]=="A1"){
                    seat = true;
                }
            }
        }
        assert(seat);
        testbooker.addSeat(bookingNum2,"A1");
        //þar sem bookingNum2 er í sama flugi og 1 og búið er að taka sæti A1
        //ætti fjöldi lausra sæta í fluginu enn að vera sá sami og síðast.
        assertequals(testbooker.getNumSeatsLeft(
            testbooker.getFlightNo(bookingNum2),
            testbooker.getFlightDate(bookingNum2)),11);
        //umbeðið sæti ætti ekki að birtast í lista yfir sæti í flugi
        String[] seats = testbooker.getSeats(bookingNum1);
        seat = false;
        for(int i = 0; i<seats.length;i++){
            if(seats[i]!=null){
                if(seats[i]=="A1"){
                    seat = true;
                }
            }
        }
        assert(!seat);
        tearDown();
    } 
    @test
    public void testAddServiceToBooking(){
        setUp();
        //testum með hvort að viðbótarþjónusta bæti við réttum kostnaði
        tearDown();
    }
    @test
    public void createBooking(){
        setUp();
        
        tearDown();
    }
}
    

