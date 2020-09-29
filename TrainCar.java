package inheritance;

public class TrainCar {
	private int deadWeight; //Dead weight is the weight of an empty train without passengers. 

	public TrainCar(int weight) { //Constructor. Takes weight in as an argument.
		if (weight > 0) {
			deadWeight = weight;
		}
	}
	public int getTotalWeight() { //Returns the total weight
		return deadWeight;
		
	}
	public void setDeadWeight(int weight) { //Sets the dead weight of the train
		if (weight > 0) {
			deadWeight = weight;
		}
	}
	public int getDeadWeight() { //Returns the dead weight
		return deadWeight;
	}	

}
