package stateandbehavior;

public class Digit {
	int numeralSystem;
	int value; 
	
	public Digit(int numeralSystem) {
		this.numeralSystem = numeralSystem;
		value = 0;
	}
	
	public int getValue() {
		return value;	
	}
	
	public boolean increment() {
		this.value += 1;
		
		if (value == numeralSystem) {
			this.value = 0;
			return true;
		}
		return false;
	}
	
	public int getBase() {
		return numeralSystem;
	}
	
	public String toString() {
		return Integer.toString(value, numeralSystem);
	}
		
	
	public static void main(String[] args) {
		Digit a = new Digit(16);
		a.value = 11;
		System.out.println(a.toString());

	}

}
