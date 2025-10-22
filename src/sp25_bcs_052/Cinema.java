package sp25_bcs_052;

public class Cinema {
	private String cinemaName;
	private Screen[] screens;
	private int counter;

	private static final int defaultScreens = 2;

	public Cinema(String cinemaName) {
        	this.cinemaName = cinemaName;
        	this.screens = new Screen[defaultScreens];
        	this.counter = defaultScreens;
        	for (int i = 0; i < defaultScreens; i++) {
            		screens[i] = new Screen("Screen-" + (i + 1));
        	}
    	}

    	public Cinema(String cinemaName, int numScreens) {
        	this.cinemaName = cinemaName;
        	this.screens = new Screen[numScreens];
        	this.counter = numScreens;

        	for (int i = 0; i < numScreens; i++) {
            		screens[i] = new Screen("Screen-" + (i + 1));
        	}
    	}

	public void addScreen(Screen newScreen) {
		if (counter == screens.length) {
			Screen[] newArray = new Screen[screens.length + 1];
			for (int i = 0; i < screens.length; i++) {
				newArray[i] = screens[i];
			}
		screens = newArray;
		}
	screens[counter++] = newScreen;
	}
	
	public Screen findScreenByName(String name) {
		for (int i =0; i < counter; i++) {
			if (screens[i].getScreenName().equals(name)) {
				return screens[i];
			}
		}
	return null;
	}

    	public String getCinemaName() {
        	return cinemaName;
    	}

    	public int getCounter() {
        	return counter;
    	}

	public Screen getScreen(int index) {
		if(index >= 1 && index <= counter) {
			return screens[index - 1];
		}
	return null;
	}


	public boolean bookSeat(int screenIndex, String seatId) {
		Screen seat = getScreen(screenIndex);
			if(seat != null) {
				return seat.bookSeat(seatId);
			}
	return false;
	}

	public boolean cancelSeat(int screenIndex, String seatId) {
		Screen seat = getScreen(screenIndex);
			if(seat != null) {
				return seat.cancelBooking(seatId);
			}
	return false;
	}

//...
	public int getTotalSeats() {
        	int total = 0;
        	for (int i = 0; i < counter; i++) {
            		total += screens[i].getTotalSeatCount();
        	}
        return total;
    	}

    	public int getAvailableSeats() {
        	int total = 0;
        	for (int i = 0; i < counter; i++) {
            		total += screens[i].getAvailableSeatCount();
        	}
        return total;
    	}

    	public int getAvailableSeats(SeatType seatType) {
        	int total = 0;
        	for (int i = 0; i < counter; i++) {
            		total += screens[i].getAvailableSeatCount(seatType);
        	}
        return total;
    	}

	public Seat findFirstAvailable(SeatType type) {
    		for (int i = 0; i < counter; i++) {
        		Seat seat = screens[i].findFirstAvailable(type);
        			if (seat != null) {
            				return seat;
        			}
    		}
    	return null;
	}


    	public void displayAllScreens() {
        	System.out.println("\n== Cinema: " + cinemaName + " ==");
        	for (int i = 0; i < counter; i++) {
            	screens[i].displayLayout();
        	}
    	}

    	@Override
   	 public String toString() {
   	     return String.format("Cinema[%s: %d screens, %d total seats, %d available]",
                cinemaName, counter, getTotalSeats(), getAvailableSeats());
    	}

	
}