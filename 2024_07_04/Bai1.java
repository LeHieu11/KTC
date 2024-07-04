import java.util.function.Predicate;

class Bai1 {
	public static void main(String[] args) {
		Predicate<String> isPalindrome = (str) -> {
			int head = 0;
			int tail = str.length() - 1;

			while (true) { 
				if (head == tail) break;

				if (str.charAt(head) != str.charAt(tail)) {
					return false;
				}

				head++;
				tail--;
			}

			return true;
		};

		String inputString;

		inputString = "Madam";
		System.out.println(inputString + " is panlindrome? " + 
				isPalindrome.test(inputString));

		inputString = "radar";
		System.out.println(inputString + " is panlindrome? " + 
				isPalindrome.test(inputString));
		
		inputString = "defied";
		System.out.println(inputString + " is panlindrome? " + 
				isPalindrome.test(inputString));
	}
}