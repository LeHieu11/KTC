package vn.edu.likelion.app;

import vn.edu.likelion.entity.Library;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Library myLib = new Library();

        //declare
        String bookName, authorName;
        String oldBookName, oldAuthorName;
        String newBookName, newAuthorName;
        String userName;
        String oldUserName, newUserName;
        int age, amount;
        int oldAge, newAge;
        LocalDate start, end;

        boolean quit = false;
        while (!quit) {
            printOption();

            int option = Integer.parseInt(myScanner.next());
            switch (option) {
                case 0:
                    quit = true;
                    break;
                case 1://Them sach
                    try {
                        System.out.print("Ten sach: ");
                        bookName = myScanner.next();

                        System.out.print("Ten Tac Gia: ");
                        authorName = myScanner.next();

                        System.out.print("So luong: ");
                        amount = Integer.parseInt(myScanner.next());

                        for(int i =0; i<amount; i++) {
                            myLib.addBook(bookName, authorName);
                        }

                        System.out.println("Done");
                        System.out.println("************************************************");
                    }
                    catch (Exception e){
                        System.err.println("Wrong");
                    }

                    break;
                case 2://Them nguoi dung
                    try {
                        System.out.print("Ten: ");
                        userName = myScanner.next();

                        System.out.print("Tuoi: ");
                        age = Integer.parseInt(myScanner.next());

                        myLib.addUser(userName, age);
                        System.out.println("Done");
                        System.out.println("************************************************\n");
                    }
                    catch (Exception e){
                        System.err.println("Wrong");
                    }

                    break;
                case 3://In tat ca sach
                    try {
                        myLib.printAllRemainBook();
                        System.out.println("Done");
                        System.out.println("************************************************\n");
                    }
                    catch (Exception e){
                        System.err.println("Wrong");
                    }

                    break;
                case 4://Sua sach
                    try {
                        System.out.print("Ten sach tim kiem: ");
                        oldBookName = myScanner.next();

                        System.out.print("Ten tac gia tim kiem: ");
                        oldAuthorName = myScanner.next();

                        System.out.print("Ten sach moi: ");
                        newBookName = myScanner.next();

                        System.out.print("Ten tac gia moi: ");
                        newAuthorName = myScanner.next();

                        myLib.updateBook(oldBookName, oldAuthorName
                                , newBookName, newAuthorName);
                        System.out.println("Done");
                        System.out.println("************************************************");
                    }
                    catch (Exception e){
                        System.err.println("Wrong");
                    }

                    break;
                case 5://Xoa sach
                    try {
                        System.out.print("Ten sach: ");
                        bookName = myScanner.next();

                        System.out.print("Ten Tac Gia: ");
                        authorName = myScanner.next();

                        System.out.print("So luong: ");
                        amount = Integer.parseInt(myScanner.next());

                        myLib.deleteBook(bookName, authorName, amount);
                        System.out.println("Done");
                        System.out.println("************************************************");
                    }
                    catch (Exception e){
                        System.err.println("Wrong");
                    }

                    break;
                case 6://Muon sach
                    try {
                        System.out.print("Ten nguoi thue: ");
                        userName = myScanner.next();

                        System.out.print("Ten sach: ");
                        bookName = myScanner.next();

                        System.out.print("Ten tac gia sach: ");
                        authorName = myScanner.next();

                        System.out.print("So luong: ");
                        amount = Integer.parseInt(myScanner.next());


                        System.out.println("Ngay bat dau muon (YYYY-MM-dd): ");
                        start = LocalDate.parse(myScanner.next());

                        System.out.println("Ngay tra (YYYY-MM-dd): ");
                        end = LocalDate.parse(myScanner.next());

                        myLib.borrowBook(userName,
                                bookName, authorName, amount,
                                start, end);

                        System.out.println("Done");
                        System.out.println("************************************************");
                    }
                    catch (Exception e){
                        System.err.println("Wrong");
                    }
                    break;
                case 7:
                    //in tat ca thong tin muon sach
                    try {
                        myLib.printAllUserInfos();
                        System.out.println("Done");
                        System.out.println("************************************************");
                    }
                    catch (Exception e){
                        System.err.println("Wrong");
                    }

                    break;
                case 8: //Sua thong tin nguoi dung
                    try {
                        System.out.print("Ten cu: ");
                        oldUserName = myScanner.next();

                        System.out.print("Tuoi cu: ");
                        oldAge = Integer.parseInt(myScanner.next());

                        System.out.print("Ten moi: ");
                        newUserName = myScanner.next();

                        System.out.print("Tuoi moi: ");
                        newAge = Integer.parseInt(myScanner.next());

                        myLib.updateUser(oldUserName, newUserName, newAge);

                        System.out.println("Done");
                        System.out.println("************************************************");
                    }
                    catch (Exception e){
                        System.err.println("Wrong");
                    }

                    break;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        }

        myScanner.close();
    }


    public static void printOption() {
        System.out.println("Hay chon so voi chuc nang tuong ung.");
        System.out.println("Them sach: 1");
        System.out.println("Them nguoi dung: 2");
        System.out.println("In tat ca sach: 3");
        System.out.println("Sua thong tin sach: 4");
        System.out.println("Xoa sach: 5");
        System.out.println("Muon sach: 6");
        System.out.println("In tat ca thong tin nguoi muon: 7");
        System.out.println("Sua thong tin nguoi dung: 8");
        System.out.println("Dung chuong trinh an: 0");
        System.out.print("\nLua chon cua ban: ");
    }
}
