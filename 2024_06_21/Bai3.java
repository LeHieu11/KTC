public class Bai3 {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7,8,9};

        solution(input);
    }

    public static void solution(int[] input){
        int numOfOdd = 0;
        int numOfEven = 0;

        for(int currInt:input){
            //is even
            if(currInt % 2 == 0){
                numOfEven++;
            }else{
                numOfOdd++;
            }
        }

        System.out.println("Number of even elements: " + numOfEven +
            " Number of odd elements: " + numOfOdd);
    }
}
