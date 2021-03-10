package by.sergel.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private String id;
    private LocalDate date;

    public Order(String id, String date) {
        this.id = id;
        this.date = LocalDateTime.parse(date).toLocalDate();

    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }
}
