
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatController {

    private final MovieTheatre movieTheatre = new MovieTheatre(9, 9);

    @GetMapping("/seats")
    public MovieTheatre getAvailableSeats() {
        return movieTheatre;
    }

    @PostMapping("/purchase")
    public Response buyTicket(@RequestBody Seat request) {
        Seat seat = movieTheatre.find(request.getRow(), request.getColumn())
                .orElseThrow(() -> new SeatException("The number of a row or a column is out of bounds!"));
        seat.tryBuy();
        return Response.of(seat);
    }
}
