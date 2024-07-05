import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 * Bai1
 */
public class Bai1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,12,14);
        System.out.println("List of numbers: " + list);


        System.out.print("Sum of even numbers: ");
        System.out.println(list.stream()
        .collect(
            Collectors.summingInt(
            number -> number % 2 == 0 ? number : 0)
        ));

        System.out.print("Sum of odd numbers: ");
        System.out.println(list.stream()
        .collect(Collectors.summingInt(
            number -> number % 2 == 1 ? number : 0)
        ));
        
    }
}