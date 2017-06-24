package ticketingservice;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TicketingController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
