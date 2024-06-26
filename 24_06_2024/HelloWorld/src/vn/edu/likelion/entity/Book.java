package vn.edu.likelion.entity;

public class Book {
    private String name;
    private String authorName;

    public Book() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return this.name + "\t" + this.authorName;
    }
}
