public class Bai5 {
    public static void main(String[] args) {
        StringBuilder input1 = new StringBuilder("Hello");
        StringBuilder input2 = new StringBuilder("World");

        input1.append(input2);
        input2 = new StringBuilder(
            input1.substring(0, input1.length() - input2.length())
        );     
        input1 = new StringBuilder(
            input1.substring(input2.length(), input1.length())
        );

        System.out.println("input 1: " + input1);
        System.out.println("input 2: " + input2);
    }
}
