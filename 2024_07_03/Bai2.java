import java.util.LinkedList;
import java.util.function.Consumer;
import java.util.function.Function;

class Bai2 {
    public static void main(String[] args) {
        Function<Integer, LinkedList> solution = (num) -> {
            LinkedList<Integer> ans = new LinkedList<>();
            int remain;

            while (true) {
                remain = num % 2;
                ans.add(0, remain);
                num = num / 2;

                if (num == 0) break;
            }

            return ans;
        };

        Consumer<Integer> printElem = (in) -> System.out.print(in);

        int num = 33;
        LinkedList<Integer> bin = solution.apply(num);
        
        System.out.println("Number: " + num);
        System.out.print("Bin: ");
        bin.forEach(printElem);

        System.out.println("\n");

        num = 747;
        bin = solution.apply(num);
        
        System.out.println("Number: " + num);
        System.out.print("Bin: ");
        bin.forEach(printElem);
    }
}