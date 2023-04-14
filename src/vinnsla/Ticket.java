package src.vinnsla;

public class Ticket {
    private String name;
    private String seat;
    private String passport;
    //private extras;
    public Ticket(String name){
        seat = null;
        passport = null;
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSeat(String seat){
        this.seat = seat;
    }
    public void setPassport(String passport){
        this.passport = passport;
    }
    public String getName(){
        return this.name;
    }
    public String getPassport(){
        return this.passport;
    }
    public String getSeat(){
        return this.seat;
    }
}
