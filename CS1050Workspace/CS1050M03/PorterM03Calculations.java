import java.util.Scanner;

public class PorterM03Calculations {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		boolean keepCalculatingGrades = true;
		programStartUpMessage();
		
		while (keepCalculatingGrades) {
		final int MIN_GRADE = 0;
		final int MAX_GRADE = 105;
		System.out.println("Please enter a grade for Participation");
		double participationGrade = getValidGrade(MIN_GRADE, MAX_GRADE, kb);
		System.out.println("Please enter a grade for Guided Exploration");
		double guidedExplorationGrade = getValidGrade(MIN_GRADE, MAX_GRADE, kb);
		System.out.println("Please enter a grade for Quizzes");
		double quizzesGrade = getValidGrade(MIN_GRADE, MAX_GRADE, kb);
		System.out.println("Please enter a grade for Projects");
		double projectsGrade = getValidGrade(MIN_GRADE, MAX_GRADE, kb);
		System.out.println("Please enter a grade for Final Exam");
		double finalDemonstrationOfLearningGrade = getValidGrade(MIN_GRADE, MAX_GRADE, kb);
		double grade = calculateGradeAverage(participationGrade, guidedExplorationGrade, quizzesGrade, 
												projectsGrade, finalDemonstrationOfLearningGrade);
		printGrades(grade);
		System.out.println();
		System.out.println("Would you like to calculate another students' grades? Y for yes, N for no");
		char keepGoingAnswer = kb.next().toUpperCase().charAt(0);
		if (keepGoingAnswer == 'Y') {
			System.out.println("Let's do some more grades!");
		} else if (keepGoingAnswer == 'N') {
			System.out.println("Goodbye!");
			keepCalculatingGrades = false;
		} else {
			System.out.println("Invalid input. Program terminating.");
			keepCalculatingGrades = false;
		}
		}
		kb.close();
	}

	public static void programStartUpMessage() {
		System.out.println("**********************************");
		System.out.println("CS1050 Final Grade Calculator");
		System.out.println("**********************************");
		System.out.println("------------------------------");
		System.out.println("Category:Percent");
		System.out.println("------------------------------");
		System.out.println("Class Participation: 10%");
		System.out.println("Guided Exploration: 20%");
		System.out.println("Module Quizzes: 25%");
		System.out.println("Project Iterations: 25%");
		System.out.println("Final Exam: 20%");
		System.out.println("------------------------------");
		System.out.println("Letter Grade Range");
		System.out.println("------------------------------");
		System.out.println("A: 90 to 100");
		System.out.println("B: 80 to < 90");
		System.out.println("C: 70 to < 80");
		System.out.println("D: 60 to < 70");
		System.out.println("F: < 60");
	}
	
	public static double getValidGrade(int MIN_GRADE, int MAX_GRADE, Scanner kb) {
		double grade = 0.0;
		boolean validGrade = false;
		while (!validGrade) {
			System.out.println("Please enter a grade value from " + MIN_GRADE + " to " + MAX_GRADE +  ":");
			grade = kb.nextDouble();
			if (grade >= MIN_GRADE && grade <= MAX_GRADE) {
				validGrade = true;
			}
		}
		return grade;
	}
	
	public static double calculateGradeAverage(double participationGrade, double guidedExplorationGrade, double quizzesGrade,
												double projectsGrade, double finalExamGrade) {
		final double PARTICIPATION_WEIGHT = 0.15;
		final double GUIDED_EXPLORATION_WEIGHT = 0.20;
		final double QUIZZES_WEIGHT = 0.25;
		final double PROJECTS_WEIGHT = 0.20;
		final double FINAL_EXAM_WEIGHT = 0.20;
		
		double grade = (participationGrade * PARTICIPATION_WEIGHT) + (guidedExplorationGrade * GUIDED_EXPLORATION_WEIGHT)
				+ (quizzesGrade * QUIZZES_WEIGHT) + (projectsGrade * PROJECTS_WEIGHT)
				+ (finalExamGrade * FINAL_EXAM_WEIGHT);									
		
		return grade;
	}
	
	public static char getLetterGrade(double grade) {
		char letterGrade = 'X';
		if (grade < 60) { 
			letterGrade = 'F';
		} else if (grade >= 60 && grade < 70 ) {
			letterGrade = 'D';
		} else if (grade >= 70 && grade < 80 ) {
			letterGrade = 'C';
		} else if (grade >= 80 && grade < 90 ) {
			letterGrade = 'B';
		} else if (grade >= 90) {
			letterGrade = 'A';
		}
		return letterGrade;
	}
	
	public static void printGrades(double grade) {
		char letterGrade = getLetterGrade(grade);
		System.out.printf("The final grade average is %.2f which is a letter grade of %c",  grade, letterGrade );
	}
}
