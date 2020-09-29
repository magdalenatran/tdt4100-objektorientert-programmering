package game;
import java.util.*;
import java.io.*; //inputstream and outputstream

public class TicTacToe implements TicTacToeFileHandler {
	private char[][] board;
	private Stack<TicTacToeMove> undo = new Stack<TicTacToeMove>();
	private Stack<TicTacToeMove> redo = new Stack<TicTacToeMove>();
	private boolean hasMoved;
	
	//The constructor makes a new board
	public TicTacToe() {
		char [][] newBoard = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
		this.board = newBoard;
	}
	//Keeps playing on the saved board
	public TicTacToe(String savedBoard) {
		if (savedBoard.length() != 9) {
			throw new IllegalArgumentException("The board has to be of length 9");
		}
		char[][] newBoard = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
		int currentIndex = 0;
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++ ) {
				newBoard[r][c] = savedBoard.charAt(currentIndex);
				currentIndex++;
			}
		}
		this.board = newBoard;
	}
	//Changes the whole board
	public void SetTicTacToe(String savedBoard) {
		if (savedBoard.length() != 9) {
			throw new IllegalArgumentException("The board has to be of length 9");
		}
		
		char[][] newBoard = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
		int currentIndex = 0;
		for (int r = 0; r < 3; r++) {
			for (int c=0; c < 3; c++ ) {
				newBoard[r][c] = savedBoard.charAt(currentIndex);
				currentIndex++;
			}
		}
		this.board = newBoard;
		if (!hasMoved) { //Checks redo
			redo.removeAllElements();  //Resets redo
		}
	}
	
	public  char getCell(int x, int y) {
		return this.board[x-1][y-1];
	}
	
	public boolean setCell(char c, int x, int y) {
		if (x>3 || x<1 || y>3 || y<1) {
			return false;
		}
		this.board[x-1][y-1] = c;
		undo.push(new TicTacToeMove(c, x, y)); //Adds a TicTacToeMove-object into the stack
		return true;
	}
	
	public boolean isOccupied(int x, int y) {
		if (this.board[x-1][y-1]!=' ') {
			return true;
		}
		return false;	
	}
	
	public char getCurrentPlayer() {
		int xCounter = 0;
		int oCounter = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (this.board[i][j]=='x') {
					xCounter++;
				}
				else if(this.board[i][j]=='o') {
					oCounter++;
				}
			}
		}
		if (xCounter > oCounter) {
			return 'o';
		}
		return 'x';
	}
	//Prints out the board
	public String toString() {
		return (" " + this.board[0][0] + " | " + this.board[0][1] + " | " + this.board[0][2] 
				+ " \n-----------\n" 
				+ " " +this.board[1][0] + " | " + this.board[1][1] + " | " + this.board[1][2] + 
				" \n-----------\n" 
				+" " + this.board[2][0] + " | " + this.board[2][1] + " | " + this.board[2][2] + " \n");
	}
	//Checks if there is a winner
	public boolean isWinner(char c) {
		for (int row = 1; row <= 3; row++) {
			if (((this.getCell(row,1)==this.getCell(row,2)) && (this.getCell(row,2)==this.getCell(row,3))) && this.getCell(row,1)==c){
				return true;
			}
			else if (((this.getCell(1,row)==this.getCell(2,row)) && (this.getCell(2,row)==this.getCell(3,row))) && this.getCell(1,row)==c) {
				return true;
			}
			else if (((this.getCell(1,1)==this.getCell(2,2)) && (this.getCell(2,2)==this.getCell(3,3))) && this.getCell(2,2)==c) { 
				return true;
			}
			else if (((this.getCell(3,1)==this.getCell(2,2)) && (this.getCell(2,2)==this.getCell(1,3))) && this.getCell(2,2)==c) {
				return true;
			}
		}
		return false;
	}
	//Checks if the game has a winner
	public boolean hasWinner() {
		if (isWinner('x')) {
			return true;
		}
		else if (isWinner('o')) {
			return true;
		}
		return false;
	}
	//Checks if the game is over
	public boolean isFinished() {
		if (hasWinner()) {
			return true;
		}
		//Checks if the board is full
		for (int i = 1; i < 4; i++) {
			for (int j = 1;j < 4;j++) {
				if (this.getCell(i,j)==' ') {
					return false;
				}
			}
		}
		return true;
	}
	//User input
	public void getInput(String in) {
		if (isFinished()) {
			return;
		}
		//Not valid inputs
		if (in.length()!= 2 && !in.equals("u") && !in.equals("r")) {
			throw new IllegalArgumentException("The input has to be <row><column>, u(undo), or r(redo)");
		}
		//Undo
		if (in.equals("u")) {
			this.undo();
			return;
		}
		//Redo
		else if (in.equals("r")) {
			this.redo();
			return;
		}
		//Sets cell
		int nextX = Character.getNumericValue(in.charAt(0));
		int nextY = Character.getNumericValue(in.charAt(1));
		if (!this.isOccupied(nextX, nextY)) {
			this.setCell(getCurrentPlayer(), nextX, nextY);
		}
	}
	//Undo a move
	public void undo() {
		redo.push(undo.peek()); //redo adds undo's latest value without removing it from undo 
		TicTacToeMove action = undo.pop();
		this.setCell(' ', action.getX(), action.getY()); //Removes the value from the cell
		undo.pop(); //
	}
	//Redo a move
	public void redo() {
		hasMoved = true;
		TicTacToeMove action = redo.pop();
		this.setCell(action.getChar(), action.getX(), action.getY()); 
	}
	//Prints out the current board
	public String currentBoard() {
		String board = "";
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				board += this.board[r][c];
			}
		}
		return board;
	}
	//Writtes the current board to file
	@Override
	public void save(String fileName) {
		String savedBoard = this.currentBoard();
		try {
			PrintWriter writer = new PrintWriter("/Users/Magdalena/tdt4100-2018-master/git/tdt4100-2018/ovinger/src/game/" + fileName);
			writer.println(savedBoard);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	//Reads the current board from file
	@Override
	public void load(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("/Users/Magdalena/tdt4100-2018-master/git/tdt4100-2018/ovinger/src/game/" + fileName));
			String board = reader.readLine();
			this.SetTicTacToe(board);
			reader.close();
		}
		catch (IOException e) {
			e.getStackTrace();
		}
	}
}
	

			
