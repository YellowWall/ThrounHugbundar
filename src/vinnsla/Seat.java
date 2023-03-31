package src.vinnsla;

public class Seat {
    private int ticket;
    private int Row;
    private char Column;
    public Seat(int ticket,int x,char y){
        this.ticket = ticket;
        Row = x;
        Column = y; 
    }
    public String getSeat(){
        return Column+"-"+Row;
    }
    public char getColumn(){
        return Column;
    }
    public int getRow(){
        return Row;
    }
    public int getTicket(){
        return ticket;
    }
}
