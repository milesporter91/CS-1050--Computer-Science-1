import java.util.Scanner;

public class M02L06MathChars {
	public static void main(String[] args) {
		// Working with Math class
		double randomDouble = Math.random();
		int randomInt = (int) Math.random();
		
		randomInt = (int) (Math.random() * 10);
		randomInt = (int) (Math.random() * 10 + 1);
		
		System.out.println("Double: " + randomDouble + "\n" + "Int: " +  randomInt);
		
		
		// Working with chars
		char charTest = '1';
		int charIntValue = 1;
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Enter a char: ");
		charTest = kb.next().charAt(0);
		charIntValue = (int)charTest;
		System.out.printf("char: %c ascii value: %d \n", charTest, charIntValue);
		
		
		// Working with Strings
		String stringTest = "first name";
		System.out.println("Enter " + stringTest);
		String firstName = kb.next();
		System.out.printf("The name %s", firstName);
		
		char lastLetter = firstName.charAt(firstName.length() - 1);
		
		System.out.println(lastLetter);
		
		String word1 = kb.next();
		String word2 = kb.next();
		String word3 = kb.next();
		
		System.out.println("Word 1 is: " + word1);
		System.out.println("Word 2 is: " + word2);
		System.out.println("Word 3 is: " + word3);
		
		kb.close();
	}
}
