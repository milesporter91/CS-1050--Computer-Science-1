import java.util.Scanner;

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
		
		for (int outerLoop = 1; outerLoop <= 5; outerLoop++) {
			System.out.println();
			for (int innerLoop = 1; innerLoop <= 5; innerLoop++) {
				System.out.println("Outer Loop #" + outerLoop + " Inner Loop #" + innerLoop);
			}
		}
		int outerLoop = 1;
		while (outerLoop <= 5) {
			int innerLoop = 1;
			while (innerLoop <= 5) {
				System.out.println("Outer: " + outerLoop + " Inner: " + innerLoop);
				innerLoop++;
			}
			outerLoop++;
			System.out.println();
		}
		// For each iteration of outerLoop, innerLoop will iterate 5 times; this should result in 25 lines being printed throughout the loop
		
		int sum = sumMethod(5, 2); // passes the values 5 and 2 to the sumMethod, assigns returned value to sum
		
		System.out.println(gaussMethod(100));
		System.out.println(gaussMethod(10));
		System.out.println(gaussMethod(5));
		
		getMoreEfficientAlgorithm();
		
		String startingString = "SquarePants";
		methodOutputs(startingString);
		System.out.println("String after method: " + startingString);
		
		double[] gradesArrayOne = {95.6, 95.6, 95.6, 95.6, 95.6};
		double[] gradesArrayTwo = {95.5, 95.4, 95.6, 94.5, 99.9};
		
		double maxGradeOne = getMaxGrade(gradesArrayOne);
		double maxGradeTwo = getMaxGrade(gradesArrayTwo);
		System.out.println("maxGradeOne = " + maxGradeOne + "\nmaxGradeTwo = " + maxGradeTwo);
		
		getRider(48, 10);
	}
	
	public static void methodOutputs(String StringParameterInput) {
		int stringLength = StringParameterInput.length();
		
		for (int i = (stringLength - 1); i >= 0; i--) {
			char currentChar = StringParameterInput.charAt(i);
			if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i'
					|| currentChar == 'o' || currentChar == 'u') {
				currentChar = Character.toLowerCase(currentChar);
			} else {
				currentChar = Character.toUpperCase(currentChar);
			}
			System.out.print(currentChar);
		}
		System.out.println();
	}
	
	
	public static int sumMethod(int a, int b) {
		int sum = a + b; // adds the values that were passed and stores them in an int called sum
		printSum(sum); // passes sum to printSum method
		return sum; // returns the sum
	}
	
	public static void printSum(int sum) {
		//        ^ void return means nothing is returned by the method
		System.out.println("The sum is " + sum); // outputs the message and the sum that was passed to it
	}
	
	public static int gaussMethod(int max) {
		int sum = 0;
		sum = (max + 1) * max / 2;
		return sum;
	}
	
	public static void getMoreEfficientAlgorithm() {
		double algorithmA = 0.1;
		double algorithmB = 0.0;
		double n = 1;
		
		for (n = 1; algorithmA > algorithmB; n++ ) {
			algorithmA = 100 * (n*n);
			algorithmB = 0.01 * Math.pow(2.0, n);
		}
		System.out.println("When n = " + n + ", A's work = " + algorithmA + ", and B's work = " + algorithmB);
	}
	
	public static double getMaxGrade(double[] gradesArray) {
		double maxGrade = 0.0;
		for (int i = 0; i < gradesArray.length; i++) {
			if (gradesArray[i] > maxGrade) {
				maxGrade = gradesArray[i];
			}
		}
		return maxGrade;
	}
	
	public static void getRider(int minimumHeightInches, int minimumAgeYears) {
		Scanner input = new Scanner(System.in);
		int age = 0;
		int height = 0;
		while (height < minimumHeightInches || age < minimumAgeYears) {
			System.out.println("Enter height in inches.");
			height = input.nextInt();
			System.out.println("Enter age in years.");
			age = input.nextInt();
			if (height < minimumHeightInches || age < minimumAgeYears) {
				System.out.println("You can not ride.");
			} // end of if
		} // end of while
		System.out.println("You can ride!");
		input.close();
	} // end of getRider()
		
}
