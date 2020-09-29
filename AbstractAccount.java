package inheritance;

public abstract class AbstractAccount {
	protected double balance;
	
	public AbstractAccount() {
		this.balance = 0;
		
	}
	//Increases the balance with a given amount
	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Error. The amount must be positive.");
		}
		balance += amount;
	}
	//Decreases the balance with a given amount - calls the method internal withdraw because each account has its own rules for withdrawal.
	public void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Error. The amount must be positive.");
		}
		internalWithdraw(amount);
		
	}
	//Each account has its own rules for withdrawal. 
	protected abstract void internalWithdraw(double amount); {
	}
	
	//Returns the balance
	public double getBalance() {
		return balance;
	}
	
}

