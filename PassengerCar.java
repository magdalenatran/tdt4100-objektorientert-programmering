package inheritance;

public class PassengerCar extends TrainCar {
	private int passengerCount;
	private final int PASSENGERWEIGHT = 80;
	
	public PassengerCar(int deadWeight, int passengers) {
		super(deadWeight);
		this.passengerCount = passengers;
	}
	public int getPassengerCount() { //Returns the numbers of passengers
		return passengerCount;
	}
	public void setPassengerCount(int passengers) { //Sets the numbers of passengers
		this.passengerCount = passengers;
	}
	public int getTotalWeight() {
		return super.getTotalWeight() + passengerCount * PASSENGERWEIGHT;
 	}
	
	protected String getCarType() {
		return "passenger car";
	}
	
	public String toString() {
		return "This is a " + getCarType() + " and the total weight is " + getTotalWeight() + " kg with " + 
	getPassengerCount() + " passengers.";
	}

	public static void main(String[] args) {
		

	}

}
