package CS1050M05;

public class TestCircleObjectClassIntro
{

	/** Main method */
	public static void main(String[] args)
	{
		System.out.println("Class of " + SimpleCircle.getShape());
		int totalCircles = SimpleCircle.getNumberOfObjects();
		System.out.println("Total number of circles: " + totalCircles);

		SimpleCircle circle1 = new SimpleCircle();
		System.out.println("Total number of circles: " + totalCircles);
		System.out.println("Circle 1 radius: " + circle1.getRadius() + " area: " + circle1.getArea());

		SimpleCircle circle2 = new SimpleCircle(25);
		System.out.println("Total number of circles: " + totalCircles);
		System.out.println("Circle 1 radius: " + circle2.getRadius() + " area: " + circle2.getArea());
		System.out.println("Total number of circles: " + totalCircles);
		// Add code to create a third circle
		// Call the method to print the number of circles
		// set the radius to a new value
		// print the area of the third circle
		
		
	}
}

class SimpleCircle
{
	private double radius;

	private static int numberOfObjects = 0;
	private static String shape = "circle";

	/** Construct a circle with radius 1 */
	public SimpleCircle()
	{
		radius = 1;
		numberOfObjects++;
	}

	// fix the code below.
	public SimpleCircle(double radius)
	{
		this.radius = radius;
		numberOfObjects++;
	}

	public double getRadius()
	{
		return radius;
	}

	// fix the code below.
	public void setRadius(double radius)
	{
		this.radius = radius;
	}

	public double getArea()
	{
		return radius * radius * Math.PI;
	}

	public static int getNumberOfObjects()
	{
		return numberOfObjects;
	}

	public static String getShape()
	{
		return shape;
	}

}