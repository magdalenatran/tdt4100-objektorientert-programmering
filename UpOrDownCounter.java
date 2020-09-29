package stateandbehavior;

public class UpOrDownCounter {
	int start;
	int end;
	int counter;

	
	public UpOrDownCounter(int start, int end) {
		if (start == end) {
			throw new IllegalArgumentException("Error");
		}
		
		this.start = start;
		this.end = end;
		this.counter = start;
		
		
	}
	
	public int getCounter() {
		return counter;
	}
	
	
	public boolean count() {
		if (counter > end) {
			counter --;
			if (counter == end) {
				return false;
			}
			return true;
		}
		
		else if (counter < end) {
			counter ++;
			if (counter == end) {
				return false;
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		UpOrDownCounter a = new UpOrDownCounter(0, 5);
		a.count();
		System.out.println(a.getCounter());

	}

}
