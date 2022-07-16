public class Seat {
    private int row;
    private int column;
    private int price;
    private boolean isBuyed = false;

    public Seat() {}

    public Seat(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
    }

    public void tryBuy() {
        if (isBuyed)
            throw new SeatException("The ticket has been already purchased!");
        isBuyed = true;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}