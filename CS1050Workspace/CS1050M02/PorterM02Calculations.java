

import java.util.Scanner;

/*
 * Name: Miles Porter
 * Class: CS1050 M/W
 * Description: Guided Exploration 02
 * The program will take input from the student for name and grades, 
 * then calculate a final grade for the class based on provided weights for grades,
 * and output the students initials and grade.
 */

public class PorterM02Calculations {
	public static void main(String[] args) {
		final double PARTICIPATION_WEIGHT = 0.15;
		final double GUIDED_EXPLORATION_WEIGHT = 0.20;
		final double QUIZZES_WEIGHT = 0.25;
		final double PROJECTS_WEIGHT = 0.20;
		final double FINAL_DEMONSTRATION_OF_LEARNING_WEIGHT = 0.20;
		double participationGrade, guidedExplorationGrade, quizzesGrade, projectsGrade, finalDemonstrationOfLearningGrade;
		char letterGrade = '~';
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter your first name.");
		String firstName = kb.nextLine();
		char firstInitial = firstName.charAt(0);
		System.out.println("Please enter your last name.");
		String lastName = kb.nextLine();
		char lastInitial = lastName.charAt(0);
		String studentInitials = firstInitial + "." + lastInitial + ".";
		System.out.println("\nLets calculate grades!");
		System.out.println("Please enter your grade for Participation: ");
		participationGrade = kb.nextDouble();
		System.out.println("Please enter your grade for Guided Explorations: ");
		guidedExplorationGrade = kb.nextDouble();
		System.out.println("Please enter your grade for Quizzes: ");
		quizzesGrade = kb.nextDouble();
		System.out.println("Please enter your grade for Projects: ");
		projectsGrade = kb.nextDouble();
		System.out.println("Please enter your grade for Final Demonstration of Learning: ");
		finalDemonstrationOfLearningGrade = kb.nextDouble();
		double grade = (participationGrade * PARTICIPATION_WEIGHT) + (guidedExplorationGrade * GUIDED_EXPLORATION_WEIGHT)
				+ (quizzesGrade * QUIZZES_WEIGHT) + (projectsGrade * PROJECTS_WEIGHT)
				+ (finalDemonstrationOfLearningGrade * FINAL_DEMONSTRATION_OF_LEARNING_WEIGHT);
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
		System.out.printf(firstName + " " + lastName + " %.2f " + letterGrade, grade);
		if(grade < 75) {
			System.out.println();
			System.out.println(studentInitials + " Please come to office hours.");
		}
		
		kb.close();
	}

}
