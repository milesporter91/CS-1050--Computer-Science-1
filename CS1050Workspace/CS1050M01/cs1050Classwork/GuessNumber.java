/**
 * This program takes user input to see if they can guess the 
 * random number generated. Add comments to explain the code.
 */
package cs1050Classwork;

import java.util.Scanner;

public class GuessNumber
{
	public static void main(String[] args)
	{		
		// final indicates a constant
		final int RANDOM_MULTIPLIER = 100;
		
		// declaration and initialization of a variable of data type int, with the identifier 'number'
		// Math.random() method produces a double between 0.00 and 0.99, which is then multiplied by the
		// constant RANDOM_MULTIPLIER(100) to get a result between 0 and 99
		int number = (int) (Math.random() * RANDOM_MULTIPLIER) + 1;
		
		// initializing a Scanner object to take input from user
		Scanner keyboardInput = new Scanner(System.in);
		
		// printing message to console
		System.out.println("Guess a magic number between 0 and 100");

		int guess = -1;
		// Loop continues while guess is not the same as the random number assigned above
		while (guess != number)
		{

			System.out.print("\nEnter your guess: ");
			guess = keyboardInput.nextInt();
			// Prints a success message if the guess is the same as the random number, or tells the user if the guess is too high or too low
			if (guess == number) 
			{
				System.out.println("Yes, the number is " + number);
			}
			else if (guess > number)
			{
				System.out.println("Your guess is too high");
			}
			else
			{
				System.out.println("Your guess is too low");
			}
		}
		// closes Scanner object to prevent memory leak
		keyboardInput.close();

	}//end of main
}//end of class
