package sp25_bcs_052;
public class SeatDemo {

	public static void main(String args[]) {
//Testing of Seat
	Seat s1 = new Seat (SeatType.VIP, 1000.0, "3-007");
	System.out.println(s1);
	Seat s2 = new Seat(SeatType.REGULAR, 500, "1-001");
	System.out.println(s2);

	
	System.out.println("Seat is Available? " + s2.bookSeat());
        System.out.println(s2);
       /* System.out.println("Seat is Available? " + s2.cancelBooking()); 
        System.out.println(s2);
        System.out.println("Seat is Available? " + s1.isAvailable()); 
        System.out.println(s1);*/






	}

}