package ticketservice.seating;

/**
 * Created by abdullahsahyouni on 6/24/17.
 */

import java.util.UUID;

/**
 * SeatReserve Class
 */
public class SeatReserved {
    private SeatHold hold;
    private String seatReserveId;

    public SeatReserved(SeatHold seats) {
        this.hold = seats;
        this.seatReserveId = UUID.randomUUID().toString();

        for(int i = 0; i<this.hold.getSeats().size(); i++) {
            this.hold.getSeats().get(i).setReservationSeatId(this.seatReserveId);
        }
    }

    public String getSeatReserveId() {
        return this.seatReserveId;
    }

    public SeatHold getHold() {
        return this.hold;
    }
}
