package vn.edu.likelion.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private HashMap<String, Integer> bookAvailability;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        bookAvailability = new HashMap<>();
    }

    public void printAllRemainBook() {
        for (String key : bookAvailability.keySet()) {
            String bookName = key.split(":")[0];
            String authorName = key.split(":")[1];

            System.out.println("Book name: " + bookName + 
                                "\t\tauthor: " + authorName +
                                "\t\tamount: " + bookAvailability.get(key));
        }
    }

    public void printAllBook(){
        HashMap<String, Integer> map = new HashMap<>();

        for (Book currBook:books) {
            String key = currBook.getName() + ":" + currBook.getAuthorName();

            if (map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }
            else {
                map.put(key, 1);
            }
        }

        int stt = 1;
        for(String key : map.keySet()){
            String bookName = key.split(":")[0];
            String authorName = key.split(":")[1];

            System.out.println("STT: " + stt +
                    "\t\tTen Sach: " + bookName +
                    "\t\tTen tac gia: " + authorName +
                    "\t\tSo luong: " + map.get(key));

            stt++;
        }
    }

    public void addBook(String name, String authorName) {
        //Init book and add
        Book myBook = new Book();
        myBook.setName(name);
        myBook.setAuthorName(authorName);
        books.add(myBook);

        //update map
        String key = name + ":" + authorName;
        if (!bookAvailability.containsKey(key)){
            bookAvailability.put(key, 1);
        }
        else {
            bookAvailability.put(key, bookAvailability.get(key) + 1);
        }
    }

    public void deleteBook(String name, String authorName, int amount) {
        String key = name + ":" + authorName;

        //Nếu không có sách sẵn trong thư viện
        if (bookAvailability.get(key) < amount){
            System.out.println("Sach dang duoc muon");
            return;
        }

        //Remove books
        for (Book book : books) {
            if( book.getName().equals(name) &&
                book.getAuthorName().equals(authorName) ){
                books.remove(book);

                //update hashmap
                bookAvailability.put(key, bookAvailability.get(key) - 1);
                amount--;
            }

            if (amount == 0) {
                return;
            }
        }

        System.out.println("Khong tim thay sach duoc chon");
    }

    //chagne book info depend on hom many book remain in library
    public void updateBook(String oldName, String oldAuthorName, 
    String newName, String newAuthorName,
    int amount) {
        //check if old info is the same as new info
        if (oldName.equals(newName) && oldAuthorName.equals(newAuthorName)) {
            System.out.println("Thong tin cu va moi phai it nhat co mot truong khac nhau");
            return;
        }
        
        String oldKey = oldName + ":" + oldAuthorName;
        //check if book exist
        if (!bookAvailability.containsKey(oldKey)) {
            System.out.println("Khong tim thay sach trung voi thong tin");
            return;
        }

        //check if remain book in library available
        if (bookAvailability.get(oldKey) < amount) {
            System.out.println("Sach trong kho khong du");
            return;
        }
                
        //change all book with familar book name and author name
        int zero = amount;
        for (Book book : books) {
            //find the first book with the same value and change it
            if( book.getName().equals(oldName) && 
                book.getAuthorName().equals(oldAuthorName) ){
                //Change the wanted book value
                book.setAuthorName(newName);
                book.setAuthorName(newAuthorName);

                zero--;
            }

            if (zero == 0) {
                break;
            }
        }

        //update map
        String newKey = newName + ":" + newAuthorName;
        bookAvailability.put(newKey, amount);
        bookAvailability.put(oldKey, bookAvailability.get(oldKey) - amount);
    }

    public void addUser(String name, int age){
        //check age
        if (age <= 16){
            System.out.println("Nguoi dung phai co tuoi tren 16");
            return;
        }

        //check if name exist
        for (User currUser: users) {
            if (currUser.getName().equals(name)) {
                System.out.println("Hay chon ten khac");
                return;
            }
        }

        //init and add new user
        User myUser = new User();
        myUser.setName(name);
        myUser.setAge(age);
        users.add(myUser);
    }

    public void updateUser(String oldName,
                           String newName, int newAge) {
        //Check age
        if (newAge < 16) {
            System.out.println("Tuoi phai tren 16");
            return;
        }

        for (User currUser:users){
            //find the user and update
            if (currUser.getName().equals(oldName)) {
                currUser.setName(newName);
                currUser.setAge(newAge);
            }
        }
    }

    public void borrowBook(String userName,
    String bookName, String authorName, int amount,
    LocalDate start, LocalDate end) {
        String key = bookName + ":" + authorName;

        //check info is right
        if (!bookAvailability.containsKey(key)){
            System.out.println("Khong co sach nhu vay");
            return;
        }

        //check book Availability
        if (bookAvailability.get(key) < amount){
            System.out.println("Sach tam het hoac khong du");
            return;
        }

        //find the user and rent book/books
        for (User currUser:users) {
            if (currUser.getName().equals(userName)) {
                //init and add rented book to user
                RentedBook myRentedBook = new RentedBook();
                myRentedBook.setName(bookName);
                myRentedBook.setAuthorName(authorName);
                myRentedBook.setAmount(amount);
                myRentedBook.setStartDate(start);
                myRentedBook.setEndDate(end);
                currUser.rentBook(myRentedBook);

                //update bookAvailability
                bookAvailability.put(key, bookAvailability.get(key) - amount);
                return;
            }
        }

        System.out.println("Ten nguoi dung khong co");
    }

    public void printAllUserInfos(){
        int stt = 1;
        for (User user : users) {
            System.out.print("STT:" + stt);
            System.out.print("\t\tTen: " + user.getName());
            System.out.print(" {\n");

            if (user.getRentedBooks().isEmpty()){
                System.out.print("\t\tNone");
            }
            else {
                // user.sortTicket();
                for(RentedBook cuRentedBook:user.getRentedBooks()){
                    System.out.print("\t\t");
                    System.out.println(cuRentedBook);
                }
            }

            stt++;
            System.out.println("\n}");
        }
    }

    public void returnBook(String userName, 
    String bookName, String bookAuthorName) {
        //check if book exist
        String key = bookName + ":" + bookAuthorName;
        if (!bookAvailability.containsKey(key)) {
            System.out.println("Khong co sach nao nhu vay");
            return;
        }

        //looping to find the user
        User choosenUser = null;
        for (User tmpUser:users) {
            //if is that user
            if (tmpUser.getName().equals(userName)) {
                choosenUser = tmpUser;
                break;
            }
        }

        //check if user exist
        if (choosenUser == null) {
            System.out.println("Cannot find user");
            return;
        }

        //return and update map
        int bookReturnQuantity = choosenUser.returnBook(
            bookName, bookAuthorName);
        bookAvailability.put(key, bookAvailability.get(key) + bookReturnQuantity);
    }

}
