package ticketservice.seating;

/**
 * Created by abdullahsahyouni on 6/26/17.
 */

import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;


public class SeatReservedTest {
    @Test
    public void initialTest() throws Exception {
        ArrayList<Seat> seats = new ArrayList<>(Arrays.asList(new Seat(0,0), new Seat(0,1)));
        long experation = Instant.now().getEpochSecond()+60;
        SeatHold seatHold1 = new SeatHold(1,
                "email@example.com",
                seats,
                experation);
        SeatReserved test = new SeatReserved(seatHold1);

        Assert.assertEquals(seats.get(0).getReservationSeatId(), test.getSeatReserveId());

    }
}
