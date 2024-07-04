
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Bai2 {
    static class Pair {

        private int smallest;
        private int secondBiggest;

        public Pair(int small, int big) {
            secondBiggest = big;
            smallest = small;
        }

        public int getSmallest() {
            return smallest;
        }
        public void setSmallest(int smallest) {
            this.smallest = smallest;
        }
        public int getSecondBiggest() {
            return secondBiggest;
        }
        public void setSecondBiggest(int secondBiggest) {
            this.secondBiggest = secondBiggest;
        }

        
    }

    public static void main(String[] args) {
        Function<List<Integer>, Pair> solution = (list) -> {
            int curbig = list.get(0);
            int small = list.get(0);
            int preBig = list.get(0);

            for (Integer i : list) {
                //find biggest and set preBig
                if (i > curbig) {
                    preBig = curbig;
                    curbig = i;
                }

                //find the seccond biggest
                if (i > preBig && i < curbig) {
                    preBig = i;
                }

                //find smallest
                if (i < small) {
                    small = i;
                }
            }

            return new Pair(small, preBig);
        };

        List<Integer> myList = Arrays.asList(7,1,18,25,77,300,101);
        Pair myPair = solution.apply(myList);

        System.out.println("Array elements: " + myList.toString());
        System.out.println("Second largest element: " + myPair.getSecondBiggest());
        System.out.println("Smallest element: " + myPair.getSmallest());

    }
}
