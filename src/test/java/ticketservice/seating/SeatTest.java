package ticketservice.seating;

/**
 * Created by abdullahsahyouni on 6/26/17.
 */

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import java.time.Instant;


public class SeatTest {

    private Seat testSeat;

    @Before
    public void setUp() {
        testSeat = new Seat(0, 0);
    }

    @Test
    public void initialTest() throws Exception {
        Assert.assertTrue("Seat should be available upon init",
                testSeat.isAvailable());
    }

    @Test
    public void reservationSeatIdTest() throws Exception {
        testSeat.setReservationSeatId("RESERVE-1");
        Assert.assertFalse("Seat should not be available once reserved",
                testSeat.isAvailable());
    }

    @Test
    public void holdSeatIdSet() throws Exception {
        testSeat.setHoldSeatId(1);
        testSeat.setHoldExpiration(Instant.now().getEpochSecond() + 60);
        Assert.assertFalse("Seat should not be available if valid Hold",
                testSeat.isAvailable());

    }

    @Test
    public void holdSeatIdSetExpired() throws Exception {
        testSeat.setHoldSeatId(1);
        testSeat.setHoldExpiration(Instant.now().getEpochSecond() - 60);
        Assert.assertTrue("Seat should not be available if Hold Expired",
                testSeat.isAvailable());
    }
}
