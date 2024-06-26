package vn.edu.likelion.entity;

import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private ArrayList<RentedBook> rentedBooks = new ArrayList<>();

    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<RentedBook> getRentedBooks() {
        return rentedBooks;
    }

    public void rentBook(RentedBook rentedBook){
        rentedBooks.add(rentedBook);
    }
}
