public class Bai2 {
    public static void main(String[] args) {
        String input = "hello goodbye goodnight";

        System.out.println(solution(input));
    }

    public static String solution(String input){
        StringBuilder ans = new StringBuilder("");

        for(char currChar:input.toCharArray()){
            ans.append(currChar);
            ans.append(currChar);
        }

        return ans.toString();
    }
}
