package game;

public class TicTacToeMove {
	private char c;
	private int x;
	private int y;
	
	public TicTacToeMove(char c, int x, int y) {
		this.c = c;
		this.x = x;
		this.y = y;
	
	}
	
	public char getChar() {
		return this.c;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

}
