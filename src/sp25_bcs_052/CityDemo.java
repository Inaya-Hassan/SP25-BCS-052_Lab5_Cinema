package sp25_bcs_052;
public class CityDemo {

    public static void main(String[] args) {

        CityCinema lahore = new CityCinema("Lahore", 2);

        	Cinema c1 = new Cinema("Emporium Johartown", 2);
        	Cinema c2 = new Cinema("CineStar Gulberg", 2);

       		lahore.addCinema(c1);
        	lahore.addCinema(c2);

        	System.out.println(c1);

        lahore.displayCity();

        	System.out.println("Booking Seat 3-007 in Emporium Johartown ");
        Cinema firstLahoreCinema = lahore.getCinema(1);  
        Screen firstScreen = firstLahoreCinema.getScreen(1); 
        firstScreen.bookSeat("3-7");
	lahore.displayCity();
        System.out.println(" Attempting to rebook ");
        firstScreen.bookSeat("3-7");
	lahore.displayCity();
        System.out.println(" Canceling seat 3-007 in Emporium Johartown");
        firstScreen.cancelBooking("3-7");

        lahore.displayCity();

        	System.out.println(" Searching for first available VIP seat in Lahore...");
        System.out.println(lahore.describeFirstAvailableVIP());
    }
}
