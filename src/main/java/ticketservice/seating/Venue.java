package ticketservice.seating;

import java.time.Instant;
import java.util.ArrayList;

/**
 * Created by abdullahsahyouni on 6/24/17.
 */
public class Venue implements TicketService {

    private Seat[][] venue;
    private ArrayList<SeatHold> pendingReservations;
    private ArrayList<SeatReserved> resertations;

    public Venue(int rows, int columns) {
       this.venue = new Seat[rows][columns];

        for(int i = 0; i<this.venue.length; i++) {
            for(int j = 0; j<this.venue[i].length; j++) {
                this.venue[i][j] = new Seat(i, j);
            }
        }
    }

    public Seat[][] getVenue() {
        return venue;
    }

    public int numSeatsAvailable() {
        int available = 0;
        for(int i = 0; i<this.venue.length; i++) {
            for(int j = 0; j<this.venue[i].length; j++) {
                if(venue[i][j].isAvailable()){
                    available++;
                }
            }
        }
        return available;
    }

    public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
        ArrayList<Seat> availableSeats = new ArrayList<>();
        return new SeatHold(1,
                customerEmail,
                availableSeats,
                Instant.now().getEpochSecond());
    }

    public String reserveSeats(int seatHoldId, String customerEmail) {
        return "lawl";
    }
}
