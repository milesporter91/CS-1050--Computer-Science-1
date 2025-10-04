
public class Examples {
	public static void main(String[] args) {
		double number = 1000.45785;
		System.out.printf("This will print a number trunkated to 3 decimal points %.3f", number);
		System.out.println();
		String newString = "This is an array of characters";
		char singleCharacter = newString.charAt(2); // this will assign the character at index 2, which is 'i'
		System.out.println("newString: " + newString);
		System.out.println("singleCharacter: " + singleCharacter);
		
		
		int x = 9;
		int y = x++; // value of x(9) is assigned to y, THEN x is incremented to 10
		System.out.println("x: " + x + "\ny: " + y); // x = 10, y = 9
		
		
		int loopCount = 0;
		for (int loopCounter = 0; loopCounter <= 7; loopCounter++) { 
			// sets a counter to 0, tells loop to iterate while counter is less than or equal to 7, post-increments counter
			loopCount++; // increments value of loopCount every time loop iterates
		}
		System.out.println("Loop count: " + loopCount); // loopCount = 8
		
	}
		
}
