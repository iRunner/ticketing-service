package ticketservice.seating;

/**
 * Created by abdullahsahyouni on 6/26/17.
 */


import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;


public class VenueTest {
    private Venue testVenue;

    @Before
    public void setUp() {
        testVenue = new Venue(4, 4);
    }

    @Test
    public void venueInitialTest() throws Exception {
        Assert.assertEquals(testVenue.getVenue()[0][0].getCol(), 0);
        Assert.assertEquals(testVenue.getVenue()[0][0].getRow(), 0);

        Assert.assertEquals(testVenue.getVenue()[3][0].getCol(), 0);
        Assert.assertEquals(testVenue.getVenue()[3][0].getRow(), 3);

        Assert.assertEquals(testVenue.getVenue()[3][1].getCol(), 1);
        Assert.assertEquals(testVenue.getVenue()[3][1].getRow(), 3);

        Assert.assertEquals(testVenue.numSeatsAvailable(), 16);
    }

    @Test
    public void venueHoldSeatTest() throws Exception {
        SeatHold testHold1 = testVenue.findAndHoldSeats(3, "example@example.com");

        Assert.assertEquals(testVenue.numSeatsAvailable(), 13);
        SeatHold testHold2 = testVenue.findAndHoldSeats(3, "example@example.com");
        Assert.assertEquals(testVenue.numSeatsAvailable(), 10);
    }

    @Test
    public void venueReserveSeatsTest() throws Exception {
        SeatHold testHold1 = testVenue.findAndHoldSeats(3, "example@example.com");
        Assert.assertEquals(testVenue.numSeatsAvailable(), 13);
        String testReserve1Id = testVenue.reserveSeats(testHold1.getSeatHoldId(), testHold1.getCustomerEmail());

        Assert.assertEquals(testHold1.getSeats().get(0).getReservationSeatId(), testReserve1Id);

    }

}
