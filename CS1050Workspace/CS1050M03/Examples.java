
public class Examples {
	public static void main(String[] args) {
		double number = 1000.45785;
		System.out.printf("This will print a number trunkated to 3 decimal points %.3f", number);
		System.out.println();
		String newString = "This is an array of characters";
		char singleCharacter = newString.charAt(2); // this will assign the character at index 2, which is 'i'
		System.out.println("newString: " + newString);
		System.out.println("singleCharacter: " + singleCharacter);
	}
		
}
