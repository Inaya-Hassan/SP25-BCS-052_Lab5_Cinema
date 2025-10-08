package sp25_bcs_052;
enum SeatType {
	REGULAR, PREMIUM, VIP, RECLINER
}
public class Seat {
	private SeatType seatType;
	private double price;
	private String id;
	private boolean isAvailable;

	public Seat(SeatType seatType, double price, String id)  {
	this.seatType = seatType;
	this.price = price;
	this.id = id;
	this.isAvailable = true; //free by default
}
	
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	public SeatType getSeatType() {
		return seatType;
	}
	
	public void setPrice (double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}

	public String getId() {
		return id;
	}
	
	public boolean bookSeat() {
		if (isAvailable) {
			isAvailable = false;
			return true;	 
	}
		return false;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public boolean cancelBooking() {
		if(!isAvailable) {
			isAvailable = true;
			return true;
	}
		return false;
	}
	@Override
	public String toString() {
		String status;
		if(isAvailable) {
			status = "Avaialble";
		} else {
			status = "Booked";
		}
	
        return String.format("Seat %s %.2f PKR ID: %s %s", seatType, price, id, status);
        }


	
		
		

	
	
	




}