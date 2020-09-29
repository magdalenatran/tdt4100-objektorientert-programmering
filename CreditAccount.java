package inheritance;

public class CreditAccount extends AbstractAccount {
	private double creditLine;
	
	public CreditAccount(double creditLine) {
		super();
		this.creditLine = creditLine;
	}
	
	public double getCreditLine() { //Returns the credit line
		return creditLine; 
	}
	//Sets the credit line. 
	public void setCreditLine(double creditLine) {
		if (balance < 0 && creditLine < - balance) {
			throw new IllegalStateException("Error");
		} else if (creditLine < 0) {
			throw new IllegalArgumentException("Error. Credit line must be positive");
		}
		this.creditLine = creditLine;
	}
	
	@Override 
	public void internalWithdraw(double amount) {
		if (balance - amount < -creditLine) {
			throw new IllegalStateException("Error. Not enough funds.");
		}
		super.balance -= amount;
	}
}
