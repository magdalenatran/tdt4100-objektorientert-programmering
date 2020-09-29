package inheritance;

public class CargoCar extends TrainCar{
	private int cargoWeight;
	
	public CargoCar(int deadWeight, int cargoWeight) {
		super(deadWeight);
		if (cargoWeight > 0) {
			this.cargoWeight = cargoWeight;
		}
	}
	
	public int getCargoWeight() { //Returns the cargo weight
		return cargoWeight;
	}

	public void setCargoWeight(int cargoWeight) { //Sets the cargo weight
		if (cargoWeight > 0) {
			this.cargoWeight = cargoWeight;
		}
	}
	
	public int getTotalWeight() { //Returns the total weight
		return super.getTotalWeight() + cargoWeight;
	}
	
	protected String getCarType() {
		return "cargo car";
	}
	
	public String toString() {
		return "This is a " + getCarType() + " and the total weight is " + getTotalWeight() + " kg";
	}
	public static void main(String[] args) {
	

	}

}
