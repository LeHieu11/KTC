package vn.edu.likelion.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Ticket {
    private String bookInfo;
    private int amount;
    private LocalDate startDate;
    private LocalDate endDate;

    public Ticket(String bookInfo, int amount,
                  LocalDate startDate, LocalDate endDate){
        this.bookInfo = bookInfo;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        String bookName = bookInfo.split(":")[0];
        String authorName = bookInfo.split(":")[1];

        return bookName + "\t" + authorName + "\t" +
                "So luong: " + amount + "\t" +
                startDate;
    }
}
