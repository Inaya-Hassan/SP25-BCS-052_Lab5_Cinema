package sp25_bcs_052;
import java.util.Random;
public class Screen {

	private Seat[][] seats;
	private String screenName;
	private static final int DEFAULT_NUM_ROWS = 5;
	private static final int[] DEFAULT_ROW_LENGTHS = {10, 11, 12, 13, 14};

//static since it is shared by all cinemas and is fixed
	private static final double PRICE_REGULAR = 500.0;
	private static final double PRICE_PREMIUM = 750.0;
	private static final double PRICE_VIP = 1000.0;
	private static final double PRICE_RECLINER = 1200.0;
	

// Default constructor
	public Screen() {
    		this("Default Screen");
	}

	public Screen(String screenName) {
		this.screenName = screenName;
		seats = new Seat[DEFAULT_ROW_LENGTHS.length][];

		for (int i = 0; i < DEFAULT_ROW_LENGTHS.length; i++) {
			seats[i] = new Seat[DEFAULT_ROW_LENGTHS[i]];

			for (int j = 0; j < DEFAULT_ROW_LENGTHS[i]; j++) {
				SeatType type;
				double price;

				if(i == 0){
					type = SeatType.REGULAR;
					price = PRICE_REGULAR;
				} else if(i == 1 || i == 2) {
					type = SeatType.PREMIUM;
					price = PRICE_PREMIUM;
				} else if(i == 3) {
					type = SeatType.VIP;
					price = PRICE_VIP;
				} else {
					type = SeatType.RECLINER;
					price = PRICE_RECLINER;
				}
		
			String id = (i + 1) + "-" + (j + 1);
		
			seats[i][j] = new Seat(type, price, id);
			}
		}
	}

	public void displayLayout() {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				String status;
					if (seats[i][j].isAvailable()) {
    					status = "A";
					} else {
   					status = "B";
					}
                	System.out.print(String.format("[%d-%03d:%s]", (i + 1), (j + 1), status));
            }
            	System.out.println();
        }
    }

	public String getScreenName() {
		return screenName;
	}

	public Seat getSeat(String id) {
		for( int i = 0; i < seats.length; i++) {
			for(int j = 0; j < seats[i].length; j++) {
				if(seats[i][j].getId().equals(id)) {
				return seats[i][j];
				}
			}
		}
	return null;
	}
	public Seat getSeat(int row, int column) {
		checkBounds(row + 1, column + 1); 

		if(row >= 0 && row < seats.length && column >= 0 && column < seats[row].length) {
			return seats[row][column];
		}
	return null;
	}			
//MISSED
	/*public boolean bookSeat(int row, int column) {
		checkBounds(row, column);
		int rows = row - 1;
    		int columns = column - 1;
		Seat seat = getSeat(rows, columns);
		if(seat != null) {
			return seat.bookSeat();
		}
	return false;
	}*/
	public boolean bookSeat(String id) {
		Seat seat = getSeat(id);
		if(seat != null) {
			return seat.bookSeat();
		}
	return false;
	}

	/*public boolean cancelBooking(int row, int column) {
		checkBounds(row, column);
		int rows = row - 1; //to convert java array system to human 
    		int columns = column - 1;
		Seat seat = getSeat(rows, columns);
		if(seat != null) {
			return seat.cancelBooking();
		}
	return false;
	}*/
	public boolean cancelBooking(String id) {
		Seat seat = getSeat(id);
		if(seat != null) {
			return seat.cancelBooking();
		}
	return false;
	}

	public void checkRow(int row) {
		if(row < 1 || row > seats.length) {
			System.out.println("Invalid row.");
		}
	}
	public void checkBounds(int row, int column) {
		checkRow(row); //reuse previous method
		if(column < 1 || column > seats[row - 1].length) {
			System.out.println("Invalid row & column.");	
		}
	}
//....
	public int getTotalSeatCount() {
		int total = 0;
		for (int i = 0; i < seats.length; i++) {
			total += seats[i].length;
		}
	return total;
	}

	public int getAvailableSeatCount() {
		int count = 0;
		for (int i = 0; i < seats.length; i++) {
			for(int j = 0; j < seats[i].length; j++) {
				if(seats[i][j].isAvailable()) {
				count++;
				}
			}
		}
	return count;
	}

	public int getAvailableSeatCount(SeatType seatType) {
    		int count = 0;
    		for (int i = 0; i < seats.length; i++) {
        		for (int j = 0; j < seats[i].length; j++) {
            			if (seats[i][j].getSeatType() == seatType && seats[i][j].isAvailable()) {
                		count++;
            			}
        		}
    		}
    	return count;
	}
//WHAT KINDOFF SEAT IS AT PARTICULAR POSITION	MISSED
	public SeatType seatTypeFor(int row, int column) {
		Seat seat = getSeat(row, column);
			if(seat != null) {
				return seat.getSeatType();
		}
	return null;
	}

	public double priceFor(SeatType seatType) {
		switch(seatType) {
        		case REGULAR: 
				return PRICE_REGULAR;
        		case PREMIUM: 
				return PRICE_PREMIUM;
        		case VIP: 
				return PRICE_VIP;
        		case RECLINER: 
				return PRICE_RECLINER;
        		default: return 0;
    		}
	}
			
	public Seat findFirstAvailable(SeatType seatType) {
    		for (int i = 0; i < seats.length; i++) {
        		for (int j = 0; j < seats[i].length; j++) {
            			if (seats[i][j].getSeatType() == seatType && seats[i][j].isAvailable()) {
                		return seats[i][j];
            			}
        		}
    		}
    	return null;
	}

//to check how many rows are in the cinema 
	public int getRowCount() {
    		return seats.length;
	}

// Returns length of a specific row
	public int getRowLength(int row) {
    		return seats[row - 1].length;
	}

// Change seat type and price for a full row
	public void setRowType(int row, SeatType type, double price) {
    		for (int j = 0; j < seats[row - 1].length; j++) {
        		seats[row - 1][j].setSeatType(type);
        		seats[row - 1][j].setPrice(price);
    		}
	}

// List all available seats of a given type
	public Seat[] listAvailable(SeatType seatType) {
    		Seat[] available = new Seat[getAvailableSeatCount(seatType)];
    		int index = 0;

    		for (int i = 0; i < seats.length; i++) {
        		for (int j = 0; j < seats[i].length; j++) {
            			if (seats[i][j].getSeatType() == seatType && seats[i][j].isAvailable()) {
                available[index++] = seats[i][j];
           			}
        		}
    		}
    	return available;

	}

// Verbose layout display with full details
	public void displayVerbose() {
    		System.out.println("== Screen: " + screenName + " | Verbose Layout ==");
    		for (int i = 0; i < seats.length; i++) {
        		for (int j = 0; j < seats[i].length; j++) {
            			System.out.print(seats[i][j] + "  ");
        		}
        	System.out.println();
    		}
	}

	public void bookRandomSeats() {
		Random rand = new Random();
		
	
		for(int i = 0; i < 15; i++) {
			int rR = rand.nextInt(seats.length);
			int rC = rand.nextInt(seats[rR].length);
		
		Seat randomSeat = seats[rR][rC];

		boolean booked = randomSeat.bookSeat();
			if (booked) {
				System.out.println (randomSeat.getId() + "booked");
			}else {
			System.out.println(randomSeat.getId() + "not booked" );

			}
		}
	}







}