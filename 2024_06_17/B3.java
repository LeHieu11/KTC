import java.util.Scanner;

public class B3 {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("String: ");

        String newString = reverseString(myScanner.nextLine());
        System.out.print("Reversed: " + newString);
    }

    public static String reverseString(String string){
        String outputString = "";
        
        for(int i = 0; i < string.length(); i++){
            outputString = string.charAt(i) + outputString;
        }

        return outputString;
    }
}
