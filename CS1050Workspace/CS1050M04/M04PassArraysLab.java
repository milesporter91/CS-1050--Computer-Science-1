/*
 * Add comments to the code
 */

public class M04PassArraysLab
{

	public static void main(String[] args)
	{

		// Part 1: explore assigning one array to another
		System.out.println("-------- Part 1 Assign an array to another array ---------");
		// explain what is happening

		System.out.println("Declare and initialize array1 and array2");
		int[] array1 =
		{ 10, 2, 45, 12 };
		int[] array2 = new int[4];

		System.out.println("reference variable array1 " + array1);
		System.out.println("reference variable array2 " + array2);

		array2[0] = 1;
		array2[1] = 112;
		array2[2] = 82;

		System.out.println("Display array1\n");
		displayArray(array1);
		System.out.println("Display array2\n");
		displayArray(array2);

		array2 = array1;

		System.out.println("\narray2 = array1;");
		System.out.println("reference variable array1 " + array1);
		System.out.println("reference variable array2 " + array2);

		System.out.println("Display array1");
		displayArray(array1);
		System.out.println("Display array2\n");
		displayArray(array2);

		array1[1] = 9000;
		array2[3] = 1000;

		System.out.println("Display array1\n");
		displayArray(array1);
		System.out.println("Display array2\n");
		displayArray(array2);

		// Summarize part 1

		// Part 2 Copy Array 1 one element at a time into arrayCopy
		System.out.println("-------- Part 2 Copy with For Loop ---------");

		int[] arrayCopy = new int[4];

		System.out.println("\nreference variable array1 " + array1);
		System.out.println("reference variable arrayCopy " + arrayCopy);

		System.out.println("Display array1\n");
		displayArray(array1);
		System.out.println("Display arrayCopy\n");
		displayArray(arrayCopy);

		for (int i = 0; i < array1.length; i++)
		{
			arrayCopy[i] = array1[i];
		}

		array1[1] = -400;
		arrayCopy[3] = -999;

		System.out.println("\nreference variable array1 " + array1);
		System.out.println("reference variable arrayCopy " + arrayCopy);

		System.out.println("Display array1\n");
		displayArray(array1);
		System.out.println("Display arrayCopy\n");
		displayArray(arrayCopy);

		// Summarize part 2

		// Part 3 Passing array3 into updatePassedArray Method
		System.out.println("-------- Part 3 Pass Arrays---------");

		int[] array3 =
		{ 100, 200, 300, 400 };

		System.out.println("\nreference variable array3 " + array3);

		System.out.println("Display array3\n");
		displayArray(array3);

		updatePassedArray(array3);

		System.out.println("Display array3\n");
		displayArray(array3);

		// summarize Part 3

		// Part 4 Returning arrays from a method
		System.out.println("-------- Part 4 Return Arrays from method---------");

		System.out.println("call createArray method\n");

		int[] array4 = createArray(5);

		System.out.println("after createArray method");
		System.out.println("reference variable array4 " + array4);
		System.out.println("Display array4\n");
		displayArray(array4);
		
		int[] numbersArray = new int[5];
		int number = 10;
		updateRandomValue(numbersArray, number);
		System.out.println(number);
		displayArray(numbersArray);
		
		

	}// end main

	
	public static void updateRandomValue(int[] passedArray, int passedNumber) {
		passedNumber = (int) (Math.random() * 10 + 1);
		for (int i = 0; i < passedArray.length; i++) {
			passedArray[i] = (int) (Math.random() * 10 + 1);
		}
	}
	/*
	 * 
	 */
	public static void updatePassedArray(int passedArray[])
	{
		System.out.println("\n** STACK updatePassedArray method start **");
		System.out.println("passedArray " + passedArray);

		for (int i = 0; i < passedArray.length; i++)
		{

			passedArray[i] = passedArray[i] + 100;
		}

		// Notice you can call a method from with in this method to display passedArray
		displayArray(passedArray);
		System.out.println("** STACK updatePassedArray method end**\n");

	}

	/*
	 * 
	 */
	public static int[] createArray(int arraySize)
	{
		int[] newArray = new int[arraySize];
		System.out.println("createArray " + newArray);
		for (int i = 0; i < newArray.length; i++)
		{
			newArray[i] = (int) (Math.random() * 10 + 1);
		}
		return newArray;
	}

	/*
	 * 
	 */
	public static void displayArray(int passedArray[])
	{
		System.out.println("\n** STACK displayArray method start** ");
		System.out.println("passedArray " + passedArray);

		for (int i = 0; i < passedArray.length; i++)
		{
			System.out.printf("array[%d] = %d \n", i, passedArray[i]);
		}
		System.out.println("** STACK displayArray method end** \n");
	}

}// end of class