import java.util.HashSet;

public class Bai4 {
    public static void main(String[] args) {
        String input = "characters";

        System.out.println(solution(input));
    }

    public static String solution(String input){
        StringBuffer ans = new StringBuffer("");
        HashSet<Character> set = new HashSet<>();

        for(char currChar:input.toCharArray()){
            //if set not contain that char
            if(!set.contains(currChar)){
                ans.append(currChar);
                set.add(currChar);
            }
        }

        return ans.toString();
    }
}
