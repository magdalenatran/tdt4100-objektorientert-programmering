package inheritance;

public class SavingsAccount2 extends AbstractAccount{
	private int withdrawals;
	private final double FEE;
	
	public SavingsAccount2(int withdrawals, double FEE) {
		super();
		this.withdrawals = withdrawals;
		this.FEE = FEE;
	}
	
	@Override
	public void internalWithdraw(double amount) {
		if (balance - amount < 0) {
			throw new IllegalStateException("Error.");
		}
		if (withdrawals > 0) {
			balance -= amount;
			withdrawals--;
		} else if (balance - amount - FEE > 0){
			balance = balance - amount - FEE;
		} else {
			throw new IllegalStateException("Error");
		}
	}

	public String toString() {
		return "The balance is " + getBalance() + " and the number of withdrawals is " + withdrawals;
	}

	public static void main(String[] args) {
		SavingsAccount2 account = new SavingsAccount2(2, 10);
		System.out.println(account);
		account.deposit(100);
		System.out.println(account);
		account.withdraw(20);
		System.out.println(account);
		account.withdraw(20);
		System.out.println(account);
		account.withdraw(20);
		System.out.println(account);
		account.withdraw(20);
		System.out.println(account);
		
		

	}

}
