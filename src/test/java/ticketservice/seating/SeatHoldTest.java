package ticketservice.seating;

/**
 * Created by abdullahsahyouni on 6/26/17.
 */



import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class SeatHoldTest {



    @Test
    public void initialTest() throws Exception {
        ArrayList<Seat> seats = new ArrayList<>(Arrays.asList(new Seat(0,0), new Seat(0,1)));
        long experation = Instant.now().getEpochSecond()+60;
        SeatHold seatHold1 = new SeatHold(1,
                "email@example.com",
                 seats,
                 experation);

        Assert.assertEquals(seatHold1.getSeats().get(0).getCustomerEmail(), "email@example.com");
        Assert.assertEquals(seatHold1.getSeats().get(1).getCustomerEmail(), "email@example.com");

        Assert.assertEquals(seatHold1.getSeats().get(0).getHoldSeatId(), 1);
        Assert.assertEquals(seatHold1.getSeats().get(1).getHoldExpiration(), experation);

    }
}
