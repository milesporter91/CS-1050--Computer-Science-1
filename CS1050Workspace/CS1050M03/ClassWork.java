import java.util.Scanner;

public class ClassWork {
	
	public static void main(String[] args) {
		boolean keepGoing = true;
		Scanner kb = new Scanner(System.in);
		while (keepGoing) {
		System.out.println("Please choose the max number");
		int maxNumber = kb.nextInt();
		int sumFromOneToMax = getSumFromOneToMax(maxNumber);
		
		System.out.println("The total sum of all numbers from 1 to " + maxNumber + " is " + sumFromOneToMax);
		System.out.println("Input R to repeat program");
		char userInput = kb.next().charAt(0);
		if (userInput != 'R' && userInput != 'r') {
			keepGoing = false;
		}
		}
		
	}
	
	public static int getSumFromOneToMax(int maxNumber) {
		int sumOfNumbersFromOneToMax = 0;
		for (int count = 0; count <= maxNumber; count++) {
			sumOfNumbersFromOneToMax += count;
		}
		return sumOfNumbersFromOneToMax;
	}
}
