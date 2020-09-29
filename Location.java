package stateandbehavior;

public class Location {
	int x;
	int y;
	
	public Location() {
		x = 0;
		y = 0;
	}
	
	public void up() {
		this.y -= 1;
	}
	
	public void down() {
		this.y += 1;
	}
	
	public void left() {
		this.x -= 1;
	}
	
	public void right() {
		this.x += 1;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String toString() {
		return "X-coordinate: " + x + " \nY-coordinate: " + y;
		
	}

	public static void main(String[] args) {
		Location a = new Location();
		a.down();
		a.right();
		System.out.println(a.toString());
		

	}

}
