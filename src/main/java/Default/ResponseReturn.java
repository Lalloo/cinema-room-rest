package Default;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseReturn {
    @JsonProperty("returned_ticket")
    private Seat seatTicket;

    public Seat getSeatTicket() {
        return seatTicket;
    }

    public void setSeatTicket(Seat seatTicket) {
        this.seatTicket = seatTicket;
    }

    public static ResponseReturn of(Seat seat) {
        ResponseReturn responseReturn = new ResponseReturn();
        responseReturn.setSeatTicket(seat);
        return responseReturn;
    }

}
