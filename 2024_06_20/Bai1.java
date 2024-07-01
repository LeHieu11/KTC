import java.util.*; 
import java.util.stream.*; 

/**
 * Bai1
 */
public class Bai1 {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Chuoi nhap vao: ");

        String inputString = myScanner.nextLine();
        myScanner.close();
        
        //Boolean var for isDuplicate
        HashMap<Character, Boolean> map = new HashMap<>();

        //Solution
        for(char mChar:inputString.toCharArray()){
            //if key not contain
            if(!map.containsKey(mChar)){
                map.put(mChar, false);
            }          
            else{
                map.replace(mChar, true);
            }
        }

        //loop through input string with map
        for(char mChar:inputString.toCharArray()){
            boolean isDuplicated = map.get(mChar);

            if(!isDuplicated){
                System.out.println("Ky tu khong lap dau tien: " + mChar);
                break;
            }
        }
    }
}