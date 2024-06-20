import java.util.*; 
import java.util.stream.*; 

public class Bai2 {
    public static void main(String[] args) {
        String[] inputArrayString = {"Black", "White", "Red"};

        for(int i = 0; i < inputArrayString.length - 1; i++){
            for(int j = 0; j < inputArrayString.length - 1 - i; j++){
                if(inputArrayString[j].compareTo(inputArrayString[j + 1]) > 0){
                    //swap
                    String tmp = inputArrayString[j];
                    inputArrayString[j] = inputArrayString[j + 1];
                    inputArrayString[j + 1] = tmp;
                }
            }
        }

        for(String s:inputArrayString){
            System.err.print(s + "\t");
        }
    }
}
