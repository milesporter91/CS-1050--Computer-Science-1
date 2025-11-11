package CS1050M05;

public class Class {
	Student[] students;
	private double[] categoryWeights;
	private double[] categoryNames;
	
	// Getters & Setters
	public Student[] getStudents() {
		return students;
	}
	public void setStudents(Student[] students) {
		this.students = students;
	}
	public double[] getCategoryWeights() {
		return categoryWeights;
	}
	public void setCategoryWeights(double[] categoryWeights) {
		this.categoryWeights = categoryWeights;
	}
	public double[] getCategoryNames() {
		return categoryNames;
	}
	public void setCategoryNames(double[] categoryNames) {
		this.categoryNames = categoryNames;
	}
}
