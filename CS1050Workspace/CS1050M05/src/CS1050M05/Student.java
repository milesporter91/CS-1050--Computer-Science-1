package CS1050M05;

public class Student {
	
	// Instance Variables
	private String name;
	private double[] categoryGrades;
	
	// Constructors
	public Student() {}
	
	public Student(String name) {
		this.name = name;
	}
	
	// Getters & Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double[] getCategoryGrades() {
		return categoryGrades;
	}
	public void setCategoryGrades(double[] categoryGrades) {
		this.categoryGrades = categoryGrades;
	}
}
