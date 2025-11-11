package CS1050M05;

public class TestRectangle {

	public static void main(String[] args) {
		System.out.println(Rectangle.getNumberOfRectangles());
		Rectangle rect1 = new Rectangle();
		System.out.println(Rectangle.getNumberOfRectangles());
		
		Rectangle rect2 = new Rectangle(2.0, 3.0);
		
		Rectangle rect3 = new Rectangle(3.0, 4.0);

		Rectangle[] rectangles = new Rectangle[3];
		rectangles[0] = rect1;
		rectangles[1] = rect2;
		rectangles[2] = rect3;

		rectangles[2].setLength(5.0);

		System.out.println(rectangles[0].getArea());
		
		printArrayRectangleInformation(rectangles);
		System.out.println("Rectangle with Longest Length Index: " + getRectangleWithLongestLengthIndex(rectangles));
		System.out.println("Total Area of all Rectangles" + getTotalAreaForAllRectangles(rectangles));

	}

	public static void printArrayRectangleInformation(Rectangle[] rectangles) {
		for (int i = 0; i < rectangles.length; i++) {
			Rectangle rectangle = rectangles[i];
			System.out.println("Rectangle #" + (i+1));
			System.out.println("Length = " + rectangle.getLength());
			System.out.println("Width = " + rectangle.getWidth());
			System.out.println("Area = " + rectangle.getArea());
			System.out.println("Perimeter = " + rectangle.getPerimeter());
			System.out.println("-----------------------");
		}
	}
	
	public static int getRectangleWithLongestLengthIndex(Rectangle[] rectangles) {
		Rectangle rectangleWithLongestLength = rectangles[0];
		int indexOfRectangle = 0;
		for (int index = 1; index < rectangles.length; index++) {
			if (rectangles[index].getLength() > rectangleWithLongestLength.getLength()) {
				rectangleWithLongestLength = rectangles[index];
				indexOfRectangle = index;
			}
		}
		return indexOfRectangle;
	}
	
	public static double getTotalAreaForAllRectangles(Rectangle[] rectangles) {
		double totalArea = 0.0;
		for (int i = 0; i < rectangles.length; i++) {
			totalArea += rectangles[i].getArea();
		}
		return totalArea;
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

	public double getPerimeter() {
		double perimeter = (length * 2) + (width * 2);
		return perimeter;
	}

	public double getArea() {
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
