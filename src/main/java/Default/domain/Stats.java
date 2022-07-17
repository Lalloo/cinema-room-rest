package Default.domain;

public class Stats {
    private int currectIncome;
    private int numberOfAvailableSeats;
    private int numberOfPurchasedTickets;

    public Stats(int currectIncome, int numberOfAvailableSeats, int numberOfPurchasedTickets) {
        this.currectIncome = currectIncome;
        this.numberOfAvailableSeats = numberOfAvailableSeats;
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }

    public Stats() {
        this.currectIncome = 0;
        this.numberOfAvailableSeats = 81;
        this.numberOfPurchasedTickets = 0;
    }

    public int getCurrectIncome() {
        return currectIncome;
    }

    public void setCurrectIncome(int currectIncome) {
        this.currectIncome = currectIncome;
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

    public void setNumberOfPurchasedTickets(int numberOfPurchasedTickets) {
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }
}
