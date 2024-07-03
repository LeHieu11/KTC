
import java.util.function.Function;
import java.util.function.Predicate;

class Bai1 {
    public static void  main(String[] args) {

        Function<Integer, Integer> solution = (in) -> {
            Predicate <Integer> isPrime = (num) -> {
                if (num == 1) return false;
                if (num == 2) return true;
                
                for (int i = 2; i <= (int) Math.sqrt(num); ++i) {
                    if (num % i == 0) return false;
                }

                return true;
            };

            if (in == 2) return 2;
            if (isPrime.test(in)) return in;

            for(int i = (int) Math.sqrt(in); i > 2 ; --i) {
                if (isPrime.test(i) && in % i == 0) return i;
            }

            return 1;
        };

        int number = 176;
        System.out.println("Number: " + number);
        System.err.println("Largest prime factor: " + solution.apply(number));

        number = 36;
        System.out.println("Number: " + number);
        System.err.println("Largest prime factor: " + solution.apply(number));

        number = 13;
        System.out.println("Number: " + number);
        System.err.println("Largest prime factor: " + solution.apply(number));

    }
}