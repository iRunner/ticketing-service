package ticketservice.seating;

/**
 * Created by abdullahsahyouni on 6/24/17.
 */

import java.time.Instant;
import java.util.ArrayList;

/**
 * This class was created to serve as the main layer
 * that communicates with endpoints.
 * A Venue object implements TicketService and maintains
 * a record of all seats given a venue.
 */
public class Venue implements TicketService {

    private int holdNum;

    private Seat[][] venue;
    private ArrayList<SeatHold> pendingReservations;
    private ArrayList<SeatReserved> resertations;

    // Default hold time for any given SeatHold object
    private long holdTime = 60*8;

    public Venue(int rows, int columns) {
        this.pendingReservations = new ArrayList<>();
        this.resertations = new ArrayList<>();
        this.holdNum = 1;
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

    /**
     * Counts the number of available seats in the venue
     * using seat object's isAvailable method
     *
     * @return the number (int) of available seats in a venue
     */
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

    /**
     * helper function to provide n available seats
     *
     * @param numSeats number of seats asked for
     * @return an arraylist of seats. (in order exp:
     *  1 2 3 4
     *  5 6 7 8
     *  9 ...
     */
    private ArrayList<Seat> nextAvailableSeats(int numSeats) {
        ArrayList<Seat> availableSeats = new ArrayList<>();
        for(int i = 0; i<this.venue.length; i++) {
            for (int j = 0; j < this.venue[i].length; j++) {
                if(venue[i][j].isAvailable()) {
                    availableSeats.add(venue[i][j]);
                    if (availableSeats.size() >= numSeats) {
                        return availableSeats;
                    }
                }
            }
        }
        return availableSeats;
    }

    /**
     * Finds and holds seats. Side effect includes manipulating
     * seat vairables in venue[][]
     *
     * @param numSeats the number of seats to find and hold
     * @param customerEmail unique identifier for the customer
     * @return SeatHold object containing information block
     */
    public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {

        SeatHold newSeatHold = new SeatHold(this.holdNum,
                customerEmail,
                nextAvailableSeats(numSeats),
                Instant.now().getEpochSecond()+this.holdTime);
        this.pendingReservations.add(newSeatHold);
        this.holdNum += 1;

        return newSeatHold;
    }

    /**
     * helper function to find seatHold object in venue
     *
     * @param seatHoldId
     * @return SeatHold object found in venue
     *   ** Warnding: will return null if not found
     */
    private SeatHold getPendingReservationById(int seatHoldId) {
        for(int i = 0; i<this.pendingReservations.size(); i++) {
            if (this.pendingReservations.get(i).getSeatHoldId() == seatHoldId) {
                return this.pendingReservations.get(i);
            }
        }
        return null;
    }

    /**
     * Reserves a seatHold object
     *
     * @param seatHoldId the seat hold identifier
     * @param customerEmail the email address of the customer to which the
    seat hold is assigned
     * @return reserve confirmation string or null if invalid seatHoldId
     */
    public String reserveSeats(int seatHoldId, String customerEmail) {
        SeatHold heldSeats = getPendingReservationById(seatHoldId);
        if (heldSeats == null || heldSeats.getSeats().get(0).isAvailable()) {
            return null;
        }
        SeatReserved seats = new SeatReserved(heldSeats);
        this.resertations.add(seats);
        return seats.getSeatReserveId();
    }
}
