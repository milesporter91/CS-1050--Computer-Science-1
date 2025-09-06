package cs1050Classwork;

import java.util.Scanner;

/*
 * Name: Miles Porter
 * Class: CS1050 M/W
 * Description: Guided Exploration 01
 * This program will print a couple paragraphs about myself and my interests
 * The program will then calculate a final grade for the class based on provided weights for grades
 */

public class PorterM01Calculations {
	public static void main(String[] args) {
		double participationGrade, guidedExplorationGrade, quizzesGrade, projectsGrade, finalDemonstrationOfLearningGrade;
		Scanner kb = new Scanner(System.in);
		
		System.out.println("My name is Miles Porter. I am a 33 year old Army veteran.");
		System.out.println("I have lived in 5 states and 4 countries, I am a licensed sky diver, and I am an avid mountain climber, having climbed Kilimanjaro in 2020.");
		System.out.println("I am married and have a baby that was technically due on September 4, so we are just patiently waiting!");
		System.out.println("I am a Full-Stack Web Developer who uses Java and Eclipse in conjunction with Spring tools and other languages to write and deploy functional, user-friendly applications.");
		System.out.println("I am working on my CS degree to further bolster my resume before entering the work force.");
		System.out.println();
		System.out.println("Now, lets calculate grades!");
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
