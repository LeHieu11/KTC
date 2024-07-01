import java.util.HashSet;

public class Bai1 {
    public static void main(String[] args) {
        int[] input = {5,1,8,4,9,1,5};

        System.out.println(solution(input));      
    }

    public static int solution(int[] input){
        int ans = 0;
        HashSet<Integer> mySet = new HashSet<>();
        
        for(int tmpNum: input){
            //if number not in set
            if(!mySet.contains(tmpNum)){
                ans += tmpNum;
                mySet.add(tmpNum);
            }
        }

        return ans;
    }
}
