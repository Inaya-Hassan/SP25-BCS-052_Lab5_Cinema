package sp25_bcs_052;
import java.time.LocalDate;
public class CityDemo {

    public static void main(String[] args) {

        CityCinema lahore = new CityCinema("Lahore", 2);

        	Cinema c1 = new Cinema("Emporium Johartown", 2);
        	Cinema c2 = new Cinema("CineStar Gulberg", 2);

       		lahore.addCinema(c1);
        	lahore.addCinema(c2);
        	System.out.println(c1);

	Screen s1 = c1.getScreen(1);
	s1.bookRandomSeats();




        LocalDate today = LocalDate.now(); 
        System.out.println("Today's date: " + today);


















	/*//c1.bookRandom();
       // lahore.displayCity();
//
//lahore.displayLayout();
        System.out.println("Booking Seat 3-007 in Emporium Johartown ");

Screen firstScreen = c1.getScreen(1);

// Book 5 random seats in the first screen
firstScreen.bookRandomSeats(5);
        Cinema firstLahoreCinema = lahore.getCinema(1);  
       // Screen firstScreen = firstLahoreCinema.getScreen(1); 
	firstScreen.displayVerbose();;
//System.out.println(a);
	Seat s = firstScreen.getSeat("3-7");
	System.out.println(s);
        // Step 3: List available REGULAR seats
        Seat[] regularSeats = firstScreen.listAvailable(SeatType.REGULAR);

        System.out.println("\nAvailable REGULAR Seats:");
        for (Seat s1 : regularSeats) {
            System.out.println(s1);
        }
	
        firstScreen.bookSeat("3-7");
	  firstScreen.bookSeat("3-8");
	  firstScreen.bookSeat("3-9");
	  firstScreen.bookSeat("3-10");
	  firstScreen.bookSeat("3-11");
	firstScreen.bookSeat("3-12");
	System.out.println(c1);
       // System.out.println(" Attempting to rebook ");
        //firstScreen.bookSeat("3-7");
	//lahore.displayCity();
       // System.out.println(" Canceling seat 3-007 in Emporium Johartown");
       // firstScreen.cancelBooking("3-7");

        //lahore.displayCity();

        //System.out.println(" Searching for first available VIP seat in Lahore...");
        //System.out.println(lahore.describeFirstAvailableVIP());

        //System.out.println("Booking Seat 3-007 in Emporium Johartown ");
        Cinema secondLahoreCinema = lahore.getCinema(1);  
        Screen secondScreen = secondLahoreCinema.getScreen(2); 
        secondScreen.bookSeat("3-7");
	 secondScreen.bookSeat("3-8");
	 secondScreen.bookSeat("3-9");
	 secondScreen.bookSeat("3-10");
	  secondScreen.bookSeat("3-11");
	secondScreen.bookSeat("3-12");

	lahore.displayCity();
//........................
    Cinema thirdLahoreCinema = lahore.getCinema(2);  
        Screen thirdScreen = thirdLahoreCinema.getScreen(1); 
        thirdScreen.bookSeat("3-7");
        thirdScreen.bookSeat("3-7");
	thirdScreen.bookSeat("3-8");
	thirdScreen.bookSeat("3-9");
	thirdScreen.bookSeat("3-10");
	thirdScreen.bookSeat("3-11");
	thirdScreen.bookSeat("3-12");

	lahore.displayCity();
*/
    }
}
