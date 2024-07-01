package vn.edu.likelion.entity;

import java.util.ArrayList;

public class User {

    private String name;
    private int age;
    private ArrayList<Ticket> tickets;

    public User(String name, int age) {
        this.name = name;
        this.age = age;

        this.tickets = new ArrayList<>();
    }

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

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void sortTicket(){
        tickets.sort((o1, o2)
                -> o1.getStartDate().compareTo(
                o2.getStartDate()));
    }

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }
}
