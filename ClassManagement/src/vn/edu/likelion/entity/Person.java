package vn.edu.likelion.entity;

import java.time.LocalDate;

public class Person {
    
    private String name;
    private LocalDate birthDate;
    private String idCard;

    public Person() {
    }

    public Person(String name, LocalDate birthDate, String idCard) {
        this.name = name;
        this.birthDate = birthDate;
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    @Override
    public String toString() {
        return name + "\t" + birthDate + "\t" + idCard;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        Person person = (Person) obj;

        return person.getIdCard().equals(this.getIdCard());
    }
}
