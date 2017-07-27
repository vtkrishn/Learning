package openTable;

import java.time.LocalTime;

public class Client {
    public Client() {
        super();
    }

    public static void main(String[] args){
        Table t = null;
        Byte b;
        String s;
        Integer i;
        Float f;
        Double d;
        Character c;
        System.out.println(Integer.reverseBytes(1234));
        Restraunt rest = new Restraunt(LocalTime.now().minusHours(8),LocalTime.now().plusHours(4),100);
        Reservation reserv1 = new Reservation("Vinod",6,LocalTime.now());
        t = rest.bookReservation(reserv1);
        if(t != null)
            System.out.println(t.tableNumber);
        Reservation reserv2 = new Reservation("Sandhya",2,LocalTime.now());
        t = rest.bookReservation(reserv2);
        if(t != null)
            System.out.println(t.tableNumber);
        Reservation reserv3 = new Reservation("Pranay",4,LocalTime.now());
        t = rest.bookReservation(reserv3);
        if(t != null)
            System.out.println(t.tableNumber);
    }
}
