package sp25_bcs_052;
public class CityCinema {


	private String cityName;
	private Cinema[] cinemas;
	private int count;


	
	public CityCinema(String cityName, int numCinemas) {
		this.cityName = cityName;
		this.cinemas = new Cinema[numCinemas];
		this.count  = 0;
	}

    	public String getCityName() {
        	return cityName;
    	}

	public void addCinema(Cinema c) {
		if (count == cinemas.length) {
			Cinema[] temp = new Cinema[cinemas.length + 1];
				for (int i = 0; i < cinemas.length; i++) 
					temp[i] = cinemas[i];
					cinemas = temp;
		}
	cinemas[count++] = c;
	}

	public Cinema getCinema(int index) {
    		if (index >= 1 && index <= count) {
        		return cinemas[index - 1];
    		}
    	return null;
	}

    	public Cinema findCinemaByName(String name) {
        	for (int i = 0; i < count; i++)
            		if (cinemas[i].getCinemaName().equals(name))
                return cinemas[i];
        return null;
   	 }

    	public Seat findFirstAvailableVIP() {
        	for (int i = 0; i < count; i++) {
            		Seat s = cinemas[i].findFirstAvailable(SeatType.VIP);
            		if (s != null) {
                return s;
            		}
        	}
        return null;
    	}

    	public String describeFirstAvailableVIP() {
        	for (int i = 0; i < count; i++) {
            		Cinema c = cinemas[i];
            		for (int j = 1; j <= 2; j++) { // assuming 2 screens per cinema
                		Screen s = c.getScreen(j);
                		Seat seat = s.findFirstAvailable(SeatType.VIP);
                			if (seat != null) {
                    			return String.format("%s > %s > %s", c.getCinemaName(),s.getScreenName(), seat.toString());
                			}
           	 	}
        	}
        return "No VIP seat available in " + cityName;
    	}

   	public void displayCity() {
        	System.out.println("\n====== City: " + cityName + " ======");
        		for (int i = 0; i < count; i++)
            			cinemas[i].displayAllScreens();
    	}




}