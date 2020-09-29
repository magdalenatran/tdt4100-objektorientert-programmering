package inheritance;

public class DebitAccount extends AbstractAccount {
	
	@Override
	//The balance must always be over zero. 
	public void internalWithdraw(double amount) {
		if (getBalance() - amount < 0) {
			throw new IllegalStateException("Error. It is not possible to withdraw the given amount.");
		}
		super.balance -= amount;
	}

}
