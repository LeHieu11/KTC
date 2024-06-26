package vn.edu.likelion.entity;

import java.time.LocalDate;

public class RentedBook extends Book{
    private int amount;
    private LocalDate startDate;
    private LocalDate endDate;

    public RentedBook(){}

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" +
                "So luong: " + amount + "\t" +
                startDate;
    }
}
