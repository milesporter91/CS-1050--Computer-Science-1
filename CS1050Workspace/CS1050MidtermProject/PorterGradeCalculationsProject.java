/* 
 * This is a grade calculator project for CS1050. 
 * Start by inputting the number of students you would like to input grades for
 * The program will then iterate through based on the amount of students, printing a grade summary for each student
 * Once all student grades have been input, a Class Summary including Class Average, lowest, and highest grades will be printed
 * The program will then output a goodbye message and terminate
 */

import java.util.Scanner;

public class PorterGradeCalculationsProject {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Constants
		final int MIN_STUDENTS = 1;
		final int MAX_STUDENTS = 35;
		final int MIN_GRADE = 0;
		final int MAX_GRADE = 105;
		final String[] categoryNames = { "Class Participation", "Guided Exploration", "Module Quizzes", "Project Iterations", "Final Exam"};
		final double[] categoryWeights = { 0.15, 0.20, 0.25, 0.20, 0.20 };
		
		// Call method to print welcome message, sending the arrays for category info as arguments
		printWelcomeMessage(categoryNames, categoryWeights);
		
		// Declaring an array that will be filled with another array during the loop in main; 
		// This array will change each time a new student's grades are entered
		double[] studentCategoryGrades;
		
		// Program gets value for amount of students in the class from the user's input
		int studentCount = (int)getValidDoubleInRange(input, "Enter student count: ", MIN_STUDENTS, MAX_STUDENTS);
		
		// Declaring and initializing a new array of doubles to hold the final grades, with a spot for each student
		double[] classFinalGrades = new double[studentCount];
		
		// Loop that iterates through the methods for each student in the class; See each method for individual descriptions
		for (int i = 0; i < studentCount; i++) {
			int studentNumber = i + 1; // add 1 to i; i starts at 0 for java index, but humans don't count from 0, we count from 1
			System.out.println("Entering grades for student #" + studentNumber);
			studentCategoryGrades = getCategoryGrades(input, categoryNames, MIN_GRADE, MAX_GRADE);
			classFinalGrades[i] = calculateFinalGrade(studentCategoryGrades, categoryWeights);
			printStudentSummary(studentNumber, classFinalGrades[i]);
		} // end of for loop
		
		// After the final iteration of the loop, the Class Summary will be printed
		printClassSummary(classFinalGrades);
		System.out.println("Thank you for using the CS1050 Grade Calculator!"); // Goodbye message;
	} // end of main()

	// Prints all the categories and their weights, as well as the Grading Scale 
	// Iterating through the arrays to print the message ensures this works with any given values for categories and weights
	public static void printWelcomeMessage(String[] currentCategories, double[] currentCategoryWeights) {
		System.out.println("========================================");
		System.out.println("CS1050 Final Grade Calculator");
		System.out.println("========================================");
		System.out.println("Grading Categories and Weights");
		System.out.println("------------------------------");
		for (int i = 0; i < currentCategories.length; i++) {
			System.out.printf("%s: %.0f%%%n", currentCategories[i], currentCategoryWeights[i] * 100);
		} // end of for loop
		System.out.println("------------------------------");
		System.out.println("Grading Scale");
		System.out.println("A: 90 or greater");
		System.out.println("B: 80 - 89.99");
		System.out.println("C: 70 - 79.99");
		System.out.println("D: 60-69.99");
		System.out.println("F: Less than 60");
		System.out.println("------------------------------");
	}

	// This method insures that a user's input is between the min and max values, looping until a valid input is entered
	public static double getValidDoubleInRange(Scanner input, String prompt, double min, double max) {
		double validDouble = -0.1;
		System.out.println(prompt);
		boolean validInput = false;
		while (!validInput) {
			validDouble = input.nextDouble();
			if (validDouble < min || validDouble > max) {
				System.out.printf("Error: Enter a value between %.0f and %.0f\n", min, max);
			} else {
				validInput = true;
			} // end of if / else statement
		} // end of while loop
		return validDouble;
	}

	// Gets grades for each category, returning an array of doubles;
	// Utilizes the getValidDoubleInRange method to insure valid inputs into array
	public static double[] getCategoryGrades(Scanner input, String[] categories, double minGrade, double maxGrade) {
		double[] gradesArray = new double[categories.length];
		for (int i = 0; i < categories.length; i++) {
			gradesArray[i] = getValidDoubleInRange(input, "Enter the " + categories[i] + " grade.", minGrade, maxGrade);
		} // end of for loop
		return gradesArray;
	}

	// Takes array of grades and category weights, and calculates the final grade % for the student, returning the grade as a double
	public static double calculateFinalGrade(double[] studentCategoryGrades, double[] currentCategoryWeights) {
		double finalGrade = 0;
		for (int i = 0; i < studentCategoryGrades.length; i++) {
			finalGrade += studentCategoryGrades[i] * currentCategoryWeights[i];
		} // end of for loop
		return finalGrade;
	}
	
	// Takes the final grade and determines the letter grade, returning a char for the Letter grade that corresponds to the double passed
	public static char calculateLetterGrade(double grade) {
		char letterGrade = ' ';
		if (grade >= 90) {
			letterGrade = 'A';
		} else if ( grade >= 80 && grade < 90) {
			letterGrade = 'B';
		} else if (grade >= 70 && grade < 80) {
			letterGrade = 'C';
		} else if (grade >= 60 && grade < 70) {
			letterGrade = 'D';
		} else {
			letterGrade = 'F';
		} // end of if / else if statements
		return letterGrade;
	}
	
	// Prints a summary of each student's Final Grade, including Student #, Final %, and Letter Grade
	public static void printStudentSummary(int studentNumber, double studentFinalGrade) {
		char studentLetterGrade = calculateLetterGrade(studentFinalGrade);
		System.out.println("---------------------------");
		System.out.println("Student #" + studentNumber);
		System.out.printf("Final Percentage: %.2f%%\n", studentFinalGrade);
		System.out.println("Final Letter Grade: " + studentLetterGrade);
		System.out.println("---------------------------");
	}

	// takes the classFinalGrades array as an argument and finds the average, returning the average grade as a double
	public static double calculateClassAverage(double[] grades) {
		double average = 0.0;
		for (int i = 0; i < grades.length; i++) {
			average += grades[i];
		} // end of for loop
		average /= grades.length;
		return average;
	}
	// takes the classFinalGrades array as an argument and finds the lowest value, returning it as a double
	public static double findLowestGrade(double[] grades) {
		double lowestGrade = grades[0];
		for (int i = 1; i < grades.length; i++) {
			if (grades[i] < lowestGrade) {
				lowestGrade = grades[i];
			} // end of if statement
		} // end of for loop
		return lowestGrade;
	}
	
	// takes the classFinalGrades array as an argument and finds the highest value, returning it as a double
	public static double findHighestGrade(double[] grades) {
		double highestGrade = grades[0];
		for (int i = 1; i < grades.length; i++) {
			if (grades[i] > highestGrade) {
				highestGrade = grades[i];
			}
		}
		return highestGrade;
	}
	
	// calls the method for calculating the class summary values, then uses print methods to print the Class Summary
	public static void printClassSummary(double[] classGrades) {
		double averageGrade = calculateClassAverage(classGrades);
		double highestGrade = findHighestGrade(classGrades);
		double lowestGrade = findLowestGrade(classGrades);
		
		System.out.printf("Average Grade: %.2f", averageGrade);
		System.out.printf("Highest Grade: %.2f", highestGrade);
		System.out.printf("Lowest Grade: %.2f", lowestGrade);
	}
	
} // end of Class
