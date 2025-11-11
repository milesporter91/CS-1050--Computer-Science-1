package CS1050M05;

public class Dealership {
	private String name;
	private int currentNumberCars;
	private Car[] cars;

	public static void main(String[] args) {
		Dealership toyotaDealership = new Dealership("Toyota World", 50);
		toyotaDealership.addCar(new Car("Toyota", "4Runner", 60000.00));
		System.out.println("Current number of cars: " + toyotaDealership.getCurrentNumberCars());
		toyotaDealership.addCar(new Car("Toyota", "Tundra", 55000.00));
		System.out.println("Current number of cars: " + toyotaDealership.getCurrentNumberCars());
		toyotaDealership.addCar(new Car("Toyota", "Corolla", 30000.00));
		System.out.println("Current number of cars: " + toyotaDealership.getCurrentNumberCars());

		System.out.println("Most expensive car: " + toyotaDealership.findMostExpensiveCar());
		toyotaDealership.displayCars();

		Dealership emptyDealership = new Dealership("Vacant", 10);
		emptyDealership.displayCars();

		for (int i = 0; i < 12; i++) {
			emptyDealership.addCar(new Car("Toyota", "Rav4", 20000));
		}

	}

	// Constructors
	public Dealership(String name, int maxNumberCars) {
		this.name = name;
		cars = new Car[maxNumberCars];
	}

	// Instance Methods

	public Car findMostExpensiveCar() {
		Car mostExpensiveCar = cars[0];
		if (currentNumberCars > 0) {
			for (int index = 1; index < cars.length; index++) {
				if (cars[index] != null && cars[index].getPrice() > mostExpensiveCar.getPrice()) {
					mostExpensiveCar = cars[index];
				}
			}
		}
		return mostExpensiveCar;
	}

	public void addCar(Car newCar) {
		if (currentNumberCars < cars.length) {
			cars[currentNumberCars] = newCar;
			currentNumberCars++;
		} else {
			System.out.println(this.name + " is full.");
		}
	}

	public void displayCars() {
		if (currentNumberCars == 0) {
			System.out.println(this.name + " is empty.");
		} else {
			for (int index = 0; index < cars.length; index++) {
				if (cars[index] != null) {
					System.out.println(cars[index].toString());
				}
			}
		}
	}

	// Getters & Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car[] getCars() {
		return cars;
	}

	public void setCars(Car[] cars) {
		this.cars = cars;
	}

	public int getCurrentNumberCars() {
		return currentNumberCars;
	}
}

// Car Class
class Car {

	// Instance variables
	private String make;
	private String model;
	private double price;

	// Constructors
	public Car() {
		this.make = "Geo";
		this.model = "Metro";
	}

	public Car(String make, String model, double price) {
		this.make = make;
		this.model = model;
		this.price = price;
	}

	// Getters & Setters
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return this.make + " " + this.model + " Price: " + this.price;
	}
}
