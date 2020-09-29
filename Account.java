package stateandbehavior;

public class Account {
	double balance;
	double interestRate;
	
	public Account() {
		balance = 0.0;
		interestRate = 0.0;
	}
	
	public void deposit(double amount) {
		if (amount > 0) {
			this.balance += amount;
		}
	}
	
	public void addInterest() {
		this.balance += balance * interestRate/100; 
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public String toString() {
		return "Balance: " + balance + " \nInterest rate: " + interestRate;
	}

	public static void main(String[] args) {
		Account a = new Account();
		System.out.println(a);
		
	}

}
