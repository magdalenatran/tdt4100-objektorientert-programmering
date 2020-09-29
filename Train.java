package inheritance;

import java.util.ArrayList;
import java.util.Collection;

public class Train {
	private Collection <TrainCar> train;
	
	public Train() { //The constructor makes an empty list of all the traincars. The list is the train. 
		train = new ArrayList<TrainCar>();
	}
	//This method adds a traincar to the train. 
	public void addTrainCar(TrainCar trainCar) { 
		train.add(trainCar);
	}
	//Returns true if the list of trains contains the traincar.
	public boolean contains(TrainCar trainCar) {
		return train.contains(trainCar);
	}
	public int getTotalWeight() {
		int totalWeight = 0;
		for (TrainCar trainCar : train) {
			totalWeight += trainCar.getTotalWeight();
		}
		return totalWeight;
	}
	
	public int getPassengerCount() {
		int passengerCount = 0;
		for (TrainCar trainCar : train) {
			if (trainCar instanceof PassengerCar) {
				passengerCount += ((PassengerCar) trainCar).getPassengerCount();
			}
		}
		return passengerCount;
	}
	
	public int getCargoWeight() {
		int cargoWeight = 0;
		for (TrainCar trainCar : train) {
			if (trainCar instanceof CargoCar) {
				cargoWeight += ((CargoCar) trainCar).getCargoWeight();
			}
		}
		return cargoWeight;
	}
	
	public String toString() {
		String output = "";
		for (TrainCar trainCar : train) {
			output += trainCar.toString() + "\n";
		}
		return output;
		
	}

	public static void main(String[] args) {
		Train train = new Train();
		train.addTrainCar(new PassengerCar(1500, 75));
		train.addTrainCar(new CargoCar(2000, 5000));
		train.addTrainCar(new PassengerCar(3000, 56));
		
		System.out.println(train);

	}

}
