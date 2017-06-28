package ticketservice;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import ticketservice.seating.SeatHold;
import ticketservice.seating.Venue;

@RestController
public class TicketingController {

    Venue venue = new Venue(100, 100);

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/numberofseats")
    public String seatsAvailable() {
        return Integer.toString(venue.numSeatsAvailable());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/holdSeats")
    public SeatHold holdSeats(@ModelAttribute("num")int num,
                              @ModelAttribute("customerEmail") String customerEmail) {
        return venue.findAndHoldSeats(num, customerEmail);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/reserveHold")
    public String researveHold(@ModelAttribute("seatHoldId") int seatHoldId,
                               @ModelAttribute("customerEmail") String customerEmail) {
        return venue.reserveSeats(seatHoldId, customerEmail);
    }
}
