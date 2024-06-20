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
        for(int i = 0; i < inputString.length(); i++){
            if(!map.containsKey(inputString.charAt(i))){
                map.put(inputString.charAt(i), false);
            }          
            else{
                map.replace(inputString.charAt(i), true);
            }
        }

        for(char mChar:inputString.toCharArray()){
            boolean isDuplicated = map.get(Character.valueOf(mChar));

            if(!isDuplicated){
                System.out.println(mChar);
                break;
            }
        }
    }
}