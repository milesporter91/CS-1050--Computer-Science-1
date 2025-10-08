package cs1050Classwork;

import java.util.Scanner;

/*
 * Name: Miles Porter
 * Class: CS1050 M/W
 * Description: Guided Exploration 02
 * The program will then calculate a final grade for the class based on provided weights for grades
 */

public class PorterM01Calculations {
	public static void main(String[] args) {
		double participationGrade, guidedExplorationGrade, quizzesGrade, projectsGrade, finalDemonstrationOfLearningGrade;
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter your first name.");
		String firstName = kb.nextLine();
		char firstInitial = firstName.charAt(0);
		System.out.println("Please enter your last name.");
		String lastName = kb.nextLine();
		char lastInitial = lastName.charAt(0);
		String studentInitials = firstInitial + "." + lastInitial + ".";
		System.out.println(studentInitials);
		System.out.println("Lets calculate grades!");
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
		double finalGrade = calculateGrade(participationGrade, guidedExplorationGrade, quizzesGrade, projectsGrade, finalDemonstrationOfLearningGrade);
		System.out.printf("Your final grade based on the provided weighted grades is %.2f", finalGrade);
		
		kb.close();
	}
	
	public static Double calculateGrade(double participationGrade, double guidedExplorationsGrade, double quizzesGrade, double projectsGrade, double finalDemonstrationOfLearningGrade ) {
		final double PARTICIPATION_WEIGHT = 0.15;
		final double GUIDED_EXPLORATION_WEIGHT = 0.20;
		final double QUIZZES_WEIGHT = 0.25;
		final double PROJECTS_WEIGHT = 0.20;
		final double FINAL_DEMONSTRATION_OF_LEARNING_WEIGHT = 0.20;
		
		double grade = (participationGrade * PARTICIPATION_WEIGHT) + (guidedExplorationsGrade * GUIDED_EXPLORATION_WEIGHT)
				+ (quizzesGrade * QUIZZES_WEIGHT) + (projectsGrade * PROJECTS_WEIGHT)
				+ (finalDemonstrationOfLearningGrade * FINAL_DEMONSTRATION_OF_LEARNING_WEIGHT);
		
		return grade;
		
	}
}
