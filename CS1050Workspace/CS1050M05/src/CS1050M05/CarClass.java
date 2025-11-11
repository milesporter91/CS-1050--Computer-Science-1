package CS1050M05;

public class CarClass {
	
	// Instance variables
	private String make;
	private String model;
	private double price;
	
	// Constructors
	public CarClass() {
		this.make = "Geo";
		this.model = "Metro";
	}
	public CarClass(String make, String model, double price) {
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
