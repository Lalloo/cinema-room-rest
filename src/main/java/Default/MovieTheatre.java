package Default;

import Default.domain.Seat;
import Default.exception.SeatException;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class MovieTheatre {
    @JsonProperty("total_rows")
    private int totalRows;
    @JsonProperty("total_columns")
    private int totalColumns;
    @JsonProperty("available_seats")
    private List<Seat> availableSeats;

    public MovieTheatre() {}

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Optional<Seat> findByRowColumn(int row, int column) {
        return availableSeats.stream()
                .filter(s -> s.getColumn() == column && s.getRow() == row)
                .findFirst();
    }

    public Optional<Seat> findByToken(String token) {
        if (token == null) {
            throw new SeatException("Wrong token!");
        }
        return availableSeats.stream()
                .filter(s -> Objects.nonNull(s.getToken()))
                .filter(s -> s.getToken().equals(token))
                .findFirst();
    }

    public MovieTheatre(int total_rows, int total_columns) {
        this.totalRows = total_rows;
        this.totalColumns = total_columns;
        this.availableSeats = assembleSeats();
    }

    public List<Seat> assembleSeats() {
        List<Seat> totalSeats = new ArrayList<>();
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 1; j <= totalColumns; j++) {
                if (i <= 4) {
                    totalSeats.add(new Seat(i, j, 10));
                } else {
                    totalSeats.add(new Seat(i, j, 8));
                }
            }
        }
        return totalSeats;
    }
}