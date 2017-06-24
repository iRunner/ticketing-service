package ticketservice;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TicketingController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
