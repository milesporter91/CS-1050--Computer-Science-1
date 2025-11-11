package CS1050M05;

public class TotalArea {
	  /** Main method */
	  public static void main(String[] args) {
	    // Declare circleArray
	    CircleWithPrivateDataFields[] circleArray;

	    // Create circleArray
	    circleArray = createCircleArray();

	    // Print circleArray and total areas of the circles
	    printCircleArray(circleArray);
	  }

	  /** Create an array of Circle objects */
	  public static CircleWithPrivateDataFields[] createCircleArray() {
	    CircleWithPrivateDataFields[] circleArray = 
	      new CircleWithPrivateDataFields[5];

	    for (int i = 0; i < circleArray.length; i++) {
	      circleArray[i] = 
	        new CircleWithPrivateDataFields(Math.random() * 100);
	    }

	    // Return Circle array
	    return circleArray;
	  }

	  /** Print an array of circles and their total area */
	  public static void printCircleArray(
	      CircleWithPrivateDataFields[] circleArray) {
	    System.out.printf("%-30s%-15s\n", "Radius", "Area");
	    for (int i = 0; i < circleArray.length; i++) {
	      System.out.printf("%-30f%-15f\n", circleArray[i].getRadius(),
	        circleArray[i].getArea());
	    }

	    System.out.println("-----------------------------------------");

	    // Compute and display the result
	    System.out.printf("%-30s%-15f\n", "The total areas of circles is",
	      sum(circleArray));
	  }

	  /** Add circle areas */
	  public static double sum(
	      CircleWithPrivateDataFields[] circleArray) {
	    // Initialize sum
	    double sum = 0;

	    // Add areas to sum
	    for (int i = 0; i < circleArray.length; i++)
	      sum += circleArray[i].getArea();

	    return sum;
	  }
	}

class CircleWithPrivateDataFields {
	/** The radius of the circle */
	private double radius = 1;

	/** The number of the objects created */
	private static int numberOfObjects = 0;

	/** Construct a circle with radius 1 */
	public CircleWithPrivateDataFields() {
		numberOfObjects++;
	}

	/** Construct a circle with a specified radius */
	public CircleWithPrivateDataFields(double newRadius) {
		radius = newRadius;
		numberOfObjects++;
	}

	/** Return radius */
	public double getRadius() {
		return radius;
	}

	/** Set a new radius */
	public void setRadius(double newRadius) {
		radius = (newRadius >= 0) ? newRadius : 0;
	}

	/** Return numberOfObjects */
	public static int getNumberOfObjects() {
		return numberOfObjects;
	}

	/** Return the area of this circle */
	public double getArea() {
		return radius * radius * Math.PI;
	}
}
