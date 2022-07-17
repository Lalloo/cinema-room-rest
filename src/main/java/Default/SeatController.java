package Default;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.StringJoiner;
import java.util.UUID;

@RestController
public class SeatController {

    private final MovieTheatre movieTheatre = new MovieTheatre(9, 9);

    @GetMapping("/seats")
    public MovieTheatre getAvailableSeats() {
        return movieTheatre;
    }

    @PostMapping("/purchase")
    public ResponsePurchase buyTicket(@RequestBody Seat request) {
        Seat seat = movieTheatre.findByRowColumn(request.getRow(), request.getColumn())
                .orElseThrow(() -> new SeatException("The number of a row or a column is out of bounds!"));
        seat.tryBuy();

        return ResponsePurchase.of(seat, seat.getToken());
    }

    @PostMapping("/return")
    public ResponseReturn returnTicket(@RequestBody Map<String, String> payload) {

        Seat abc = movieTheatre.findByToken(payload.get("token"))
                .orElseThrow(() -> new SeatException("Wrong token!"));
        return ResponseReturn.of(abc);
    }
}
