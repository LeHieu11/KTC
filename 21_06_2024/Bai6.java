import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.print("How many number you want to input? ");
        int nNum = myScanner.nextInt();

        HashSet<Integer> mySet = new HashSet<>();
        ArrayList<Integer> duplicateNums = new ArrayList<>();

        for(int i = 0; i < nNum; i++){
            int inputNum = myScanner.nextInt();
            boolean flag = mySet.add(inputNum);

            if(!flag){
                duplicateNums.add(inputNum);
            }
        }

        if(duplicateNums.size() != 0){
            System.out.print("Error: Duplicate number found: " + duplicateNums.toString());
        }else{
            System.out.println("No dublicate number!");
        }
    }
}
