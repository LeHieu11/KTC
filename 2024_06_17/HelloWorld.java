import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
        //17-06-2024 b1
        System.out.println("Hello World");
        System.out.println("I am learning Java");

        //17-06-2024 b2
        Scanner myScanner = new Scanner(System.in);
        System.out.print("String = ");

        printTypeString(myScanner.nextLine());
    }

    /*
    Des: print a string
     */
    public static void printTypeString(String string) {
        System.out.println("Input String is: " + string);
    }
}
