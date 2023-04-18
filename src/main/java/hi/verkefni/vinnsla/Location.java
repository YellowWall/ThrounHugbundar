package hi.verkefni.vinnsla;

public class Location implements locationInterface {
    private String destination = null;
    private String departure = null;

    public Location(String destination, String departure) {
        this.destination = destination;
        this.departure = departure;
    }

    @Override
    public void setDestination(String str) {
        if (str != null && str.length() > 0) {
            destination = str;
        }
        throw new Error("Invalid destination string");
    }

    @Override
    public void setDeparture(String str) {
        if (str != null && str.length() > 0) {
            departure = str;
        }
        throw new Error("Invalid departure string");
    }

    @Override
    public String getDestination() {
        if (destination == null) {
            return "inv";
        }
        return destination;
    }

    @Override
    public String getDeparture() {
        if (departure == null) {
            return "inv";
        }
        return departure;
    }


}
