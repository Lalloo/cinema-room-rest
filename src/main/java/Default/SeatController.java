package Default;

import Default.domain.Seat;
import Default.domain.Stats;
import Default.exception.LoginException;
import Default.exception.SeatException;
import Default.response.ResponsePurchase;
import Default.response.ResponseReturn;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class SeatController {

    private final MovieTheatre movieTheatre = new MovieTheatre(9, 9);

    private final Stats stats = new Stats();

    @GetMapping("/seats")
    public MovieTheatre getAvailableSeats() {
        return movieTheatre;
    }

    @PostMapping("/purchase")
    public ResponsePurchase buyTicket(@RequestBody Seat request) {
        Seat seat = movieTheatre.findByRowColumn(request.getRow(), request.getColumn())
                .orElseThrow(() -> new SeatException("The number of a row or a column is out of bounds!"));
        seat.tryBuy();
        stats.setCurrectIncome(stats.getCurrectIncome() + seat.getPrice());
        stats.setNumberOfAvailableSeats(stats.getNumberOfAvailableSeats() - 1);
        stats.setNumberOfPurchasedTickets(stats.getNumberOfPurchasedTickets() + 1);
        return ResponsePurchase.of(seat, seat.getToken());
    }

    @PostMapping("/return")
    public ResponseReturn returnTicket(@RequestBody Map<String, String> payload) {
        Seat seat = movieTheatre.findByToken(payload.get("token"))
                .orElseThrow(() -> new SeatException("Wrong token!"));
        stats.setCurrectIncome(stats.getCurrectIncome() - seat.getPrice());
        stats.setNumberOfAvailableSeats(stats.getNumberOfAvailableSeats() + 1);
        stats.setNumberOfPurchasedTickets(stats.getNumberOfPurchasedTickets() - 1);
        return ResponseReturn.of(seat);
    }

    @PostMapping("/stats")
    public Stats getStatistics(@RequestParam(required = false) Optional<String> password) {
        password.filter("super_secret"::equals).orElseThrow(() -> new LoginException("The password is wrong!"));
        return stats;
    }
}
