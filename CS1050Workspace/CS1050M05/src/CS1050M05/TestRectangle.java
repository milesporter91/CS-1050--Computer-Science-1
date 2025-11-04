package CS1050M05;

public class TestRectangle {

	public static void main(String[] args) {
		System.out.println(Rectangle.getNumberOfRectangles());
		Rectangle rect1 = new Rectangle();
		System.out.println(Rectangle.getNumberOfRectangles());
		Rectangle rect2 = new Rectangle(2.0, 3.0);
		System.out.println(Rectangle.getNumberOfRectangles());
		System.out.println(rect2.getArea(rect2.getLength(), rect2.getWidth()));
		System.out.println(rect1.getPerimeter(rect1.getLength(), rect1.getWidth()));
	}

}

class Rectangle {
	// Instance variables
	private double length;
	private double width;

	private static String shape = "rectangle";
	private static int numberOfRectangles = 0;

	// Static Methods

	public static String getShape(Rectangle rectangle) {
		return shape;
	}

	public static int getNumberOfRectangles() {
		return numberOfRectangles;
	}

	// Constructors
	public Rectangle() {
		numberOfRectangles++;
	}

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
		numberOfRectangles++;
	}

	// Methods

	public double getPerimeter(double length, double width) {
		double perimeter = (length * 2) + (width * 2);
		return perimeter;
	}

	public double getArea(double length, double width) {
		double area = length * width;
		return area;
	}

	// Getters & Setters
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
}
