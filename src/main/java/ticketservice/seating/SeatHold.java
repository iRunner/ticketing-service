package ticketservice.seating;

import java.util.ArrayList;

/**
 * Created by abdullahsahyouni on 6/24/17.
 */

public class SeatHold {

    private int seatHoldId;
    private String customerEmail;
    private ArrayList<Seat> seats;
    private long expiration;

    public SeatHold(int seatHoldId,
                    String cusEmail,
                    ArrayList<Seat> seats,
                    long expiration) {
        this.seatHoldId = seatHoldId;
        this.customerEmail = cusEmail;
        this.seats = seats;
        this.expiration = expiration;

        for(int i = 0; i<seats.size(); i++) {
            seats.get(i).setHoldSeatId(this.seatHoldId);
            seats.get(i).setHoldExpiration(this.expiration);
            seats.get(i).setCustomerEmail(this.customerEmail);
        }

    }

    public int getSeatHoldId() {
        return seatHoldId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public long getExpiration() {
        return expiration;
    }
}
