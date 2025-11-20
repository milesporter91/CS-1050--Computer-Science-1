
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CS1050F25Iteration02 {
	public static void main(String[] args) {
		String INPUT_FILENAME = "course1030.txt";
		// tells the program to try to run this block of code, but to also be ready to
		// catch an exception which will be specified in the catch block
		try {
			System.out.println();
			// 1. Create course from file
			Course course = courseSetUp(INPUT_FILENAME);

			// 2. Compute final grades for all students
			course.postFinalGrades();
			// 3. Display course information and all results
			course.displayCourseGrading();
			course.PrintFinalReport();
			// If a FNF exception is thrown, this line of code will execute instead of
			// displaying the exception in the console
			// I added the other printLn to display the exception message to the user in
			// addition to the custom message, just to see the difference in output
		} catch (FileNotFoundException exception) {
			System.out.println("Error: Unable to find file " + INPUT_FILENAME);
			System.out.println("Exception: " + exception.getMessage());
		}

		INPUT_FILENAME = "course1050.txt";

		try {
			System.out.println();
			// 1. Create course from file
			Course course = courseSetUp(INPUT_FILENAME);

			// 2. Compute final grades for all students
			course.postFinalGrades();
			// 3. Display course information and all results
			course.displayCourseGrading();
			course.PrintFinalReport();
		} catch (FileNotFoundException exception) {
			System.out.println("Error: Unable to find file " + INPUT_FILENAME);
		}
	} // end of main method

	/**
	 * Reads course data and student data from the input file. File format: Line 1:
	 * courseName Line 2: numberCategories Line 3 categoryNames Line 4:
	 * categoryWeights Line 5: maxNumberStudents Remaining lines: Student
	 * Information firstName lastName categoryGrades
	 * 
	 * @param filename
	 * @return Course object
	 * @throws FileNotFoundException
	 */
	public static Course courseSetUp(String filename) throws FileNotFoundException {
		// This creates a new scanner that reads data from the specified file
		Scanner fileScanner = new Scanner(new File(filename));

		// Line 1: courseName
		// assigns the data read from the next line of the file to a String, after
		// trimming any leading or trailing white space
		String courseName = fileScanner.nextLine().trim();

		// Line 2: number of categories
		// moves to the next line and assigns the data there to an int variable
		int numberCategories = fileScanner.nextInt();

		// Line 3: categoryNames
		// Create array to store categories
		// read categories from file into array
		String[] categoryNames = new String[numberCategories];
		// iterates through the array, assigning each subsequent comma separated value
		// on the current line of the file to the current index of the array
		for (int i = 0; i < categoryNames.length; i++) {
			categoryNames[i] = fileScanner.next();
		}

		// Line 4: categoryWeights
		// same logic as above for categoryNames, but for weights this time
		double[] categoryWeights = new double[numberCategories];
		for (int i = 0; i < categoryWeights.length; i++) {
			categoryWeights[i] = fileScanner.nextDouble();
		}

		// Line 5: how many student records to read from file
		// assigns the data from line 5 to an int variable
		int maxStudents = fileScanner.nextInt();

		// Creates a new Course object using the data read from the file
		Course course = new Course(courseName, maxStudents, categoryNames, categoryWeights);

		// Read students
		while (fileScanner.hasNext()) {
			String firstName = fileScanner.next();
			String lastName = fileScanner.next();

			double[] categoryGrades = new double[numberCategories];
			for (int i = 0; i < categoryGrades.length; i++) {
				categoryGrades[i] = fileScanner.nextDouble();
			}

			Student student = new Student(firstName, lastName, categoryGrades);
			boolean studentAdded = course.addStudent(student);
			if (!studentAdded) {
				System.out.println("Course is full. Can't add " + firstName + " " + lastName);
			}
		}

		fileScanner.close();
		return course;
	} // end of courseSetup method
} // End of Iteration02 class

class Course {
	// Instance variables
	private String courseName;
	private int numberOfCategories;
	private String[] categoryNames;
	private double[] categoryWeights;
	private int maxStudents;
	private Student[] students;
	private int numberOfStudents;
	private double classAverage;
	private double highestGrade;
	private double lowestGrade;

	// Constructors
	public Course(String courseName, int maxStudents, String[] categoryNames, double[] categoryWeights) {
		this.courseName = courseName;
		this.maxStudents = maxStudents;
		this.categoryNames = categoryNames;
		this.numberOfCategories = this.categoryNames.length;
		this.categoryWeights = categoryWeights;
		this.students = new Student[maxStudents];
	}

	// Instance methods
	public void displayStudentGrades() {
		for (int i = 0; i < this.students.length; i++) {
			Student student = this.students[i];
			System.out.println("---------------------------");
			System.out.println("Student Name: " + student.getFirstName() + " " + student.getLastName());
			System.out.printf("Final Percentage: %.2f%%\n", student.getFinalGrade());
			System.out.println("Final Letter Grade: " + student.getLetterGrade());
			System.out.println("---------------------------");
		}
	}

	public void postFinalGrades() {
		for (int i = 0; i < this.students.length; i++) {
			double finalGrade = 0.0;
			for (int j = 0; j < this.numberOfCategories; j++) {
				finalGrade += this.students[i].getCategoryGrades()[j] * this.categoryWeights[j];
			} // end of inner for loop
			this.students[i].setFinalGrade(finalGrade);
			this.postLetterGrades(i);
		} // end of outer for loop
		this.calculateClassAverage();
		this.findHighestGrade();
		this.findLowestGrade();
	}

	public boolean addStudent(Student student) {
		boolean studentAdded = false;
		if (this.numberOfStudents < this.maxStudents && this.students[numberOfStudents] == null) {
			this.students[numberOfStudents] = student;
			this.numberOfStudents++;
			studentAdded = true;
		} else {
		}
		return studentAdded;
	}

	public void postLetterGrades(int studentIndex) {
		char letterGrade = ' ';
		double studentFinalGrade = this.students[studentIndex].getFinalGrade();
		if (studentFinalGrade >= 90) {
			letterGrade = 'A';
		} else if (studentFinalGrade >= 80 && studentFinalGrade < 90) {
			letterGrade = 'B';
		} else if (studentFinalGrade >= 70 && studentFinalGrade < 80) {
			letterGrade = 'C';
		} else if (studentFinalGrade >= 60 && studentFinalGrade < 70) {
			letterGrade = 'D';
		} else {
			letterGrade = 'F';
		} // end of if / else if statements
		this.students[studentIndex].setLetterGrade(letterGrade);
	}

	public void calculateClassAverage() {
		double classAverage = 0.0;
		for (int i = 0; i < students.length; i++) {
			classAverage += students[i].getFinalGrade();
		}
		this.classAverage = classAverage / this.students.length;
	}

	public void findHighestGrade() {
		this.highestGrade = this.students[0].getFinalGrade();
		for (int i = 1; i < this.students.length; i++) {
			if (this.students[i].getFinalGrade() > this.highestGrade) {
				this.highestGrade = this.students[i].getFinalGrade();
			}
		}
	}

	public void findLowestGrade() {
		this.lowestGrade = this.students[0].getFinalGrade();
		for (int i = 1; i < this.students.length; i++) {
			if (this.students[i].getFinalGrade() < this.lowestGrade) {
				this.lowestGrade = this.students[i].getFinalGrade();
			}
		}
	}

	public void PrintFinalReport() {
		displayStudentGrades();
		System.out.printf("Class Average Grade: %.2f\n", this.classAverage);
		System.out.printf("Class Highest Grade: %.2f\n", this.highestGrade);
		System.out.printf("Class Lowest Grade: %.2f\n", this.lowestGrade);
	}

	public void displayCourseGrading() {
		System.out.println("========================================");
		System.out.println("CS1050 Final Grade Calculator");
		System.out.println("========================================");
		System.out.println("Grading Categories and Weights");
		System.out.println("------------------------------");
		for (int i = 0; i < this.categoryNames.length; i++) {
			System.out.printf("%s: %.0f%%\n", this.categoryNames[i], this.categoryWeights[i] * 100);
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

	// Getters & Setters
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getNumberOfCategories() {
		return numberOfCategories;
	}

	public void setNumberOfCategories(int numberOfCategories) {
		this.numberOfCategories = numberOfCategories;
	}

	public String[] getCategoryNames() {
		return categoryNames;
	}

	public void setCategoryNames(String[] categoryNames) {
		this.categoryNames = categoryNames;
	}

	public double[] getCategoryWeights() {
		return categoryWeights;
	}

	public void setCategoryWeights(double[] categoryWeights) {
		this.categoryWeights = categoryWeights;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public void setStudent(Student student) {
		this.students[0] = student;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public double getClassAverage() {
		return classAverage;
	}

	public void setClassAverage(double classAverage) {
		this.classAverage = classAverage;
	}

	public double getHighestGrade() {
		return highestGrade;
	}

	public void setHighestGrade(double highestGrade) {
		this.highestGrade = highestGrade;
	}

	public double getLowestGrade() {
		return lowestGrade;
	}

	public void setLowestGrade(double lowestGrade) {
		this.lowestGrade = lowestGrade;
	}

} // End of Course class

class Student {
	private double[] categoryGrades;
	private String firstName;
	private String lastName;
	private double finalGrade;
	private char letterGrade;

	// Constructors
	public Student(String firstName, String lastName, double[] categoryGrades) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.categoryGrades = categoryGrades;
	}

	// Getters & Setters
	public double[] getCategoryGrades() {
		return categoryGrades;
	}

	public void setCategoryGrades(double[] categoryGrades) {
		this.categoryGrades = categoryGrades;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(double finalGrade) {
		this.finalGrade = finalGrade;
	}

	public char getLetterGrade() {
		return letterGrade;
	}

	public void setLetterGrade(char letterGrade) {
		this.letterGrade = letterGrade;
	}

} // End of Student class