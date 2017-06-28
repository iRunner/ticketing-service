package ticketservice.seating;

import java.time.Instant;

/**
 * Created by abdullahsahyouni on 6/24/17.
 */
public class Seat {


    private int row;
    private int col;
    private int holdSeatId;
    private long holdExpiration;

    private String reservationSeatId;

    private String customerEmail;

    public Seat() {
        this.row = -1;
        this.col = -1;
        this.holdSeatId = -1;
        this.holdExpiration = Instant.now().getEpochSecond();
    }

    public Seat(int row, int col) {
        this.row = row;
        this.col = col;
        this.holdSeatId = -1;
        this.holdExpiration = Instant.now().getEpochSecond();
    }

    public boolean isAvailable() {
        if (this.reservationSeatId != null) {
            return false;
        }
        if (this.holdSeatId > 0
                && Instant.now().getEpochSecond() < this.holdExpiration) {
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "{ point: ("+this.row+", "+this.col+")" +
                ", holdSeatId: " + Integer.toString(this.holdSeatId) +
                ", holdExpiration: " + Long.toString(this.holdExpiration) +
                ", reservationSeatId: " + this.reservationSeatId +
                ", customerEmail: " + this.customerEmail + " }";

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getHoldSeatId() {
        return holdSeatId;
    }

    public void setHoldSeatId(int holdSeatId) {
        this.holdSeatId = holdSeatId;
    }

    public long getHoldExpiration() {
        return holdExpiration;
    }

    public void setHoldExpiration(long holdExpiration) {
        this.holdExpiration = holdExpiration;
    }

    public String getReservationSeatId() {
        return reservationSeatId;
    }

    public void setReservationSeatId(String reservationSeatId) {
        this.reservationSeatId = reservationSeatId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
