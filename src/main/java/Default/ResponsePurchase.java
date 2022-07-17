package Default;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class ResponsePurchase {
    @JsonProperty("ticket")
    private Seat seatTicket;

    private String token;

    public Seat getSeatTicket() {
        return seatTicket;
    }

    public void setSeatTicket(Seat seatTicket) {
        this.seatTicket = seatTicket;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static ResponsePurchase of(Seat seat, String token) {
        ResponsePurchase responsePurchase = new ResponsePurchase();
        responsePurchase.setToken(token);
        responsePurchase.setSeatTicket(seat);
        return responsePurchase;
    }
}
