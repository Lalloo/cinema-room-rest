
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Response {
    @JsonProperty("ticket")
    private Seat returnedTicket;
    private String token = UUID.randomUUID().toString();

    public Seat getReturnedTicket() {
        return returnedTicket;
    }

    public void setReturnedTicket(Seat returnedTicket) {
        this.returnedTicket = returnedTicket;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static Response of(Seat seat) {
        Response response = new Response();
        response.setReturnedTicket(seat);
        return response;
    }
}
