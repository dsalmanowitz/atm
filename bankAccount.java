public class bankAccount {
	private double balance;
	private int accountNumber;
	private accountHolder user;
	
	public bankAccount (double balance, int accountNumber, accountHolder user) {
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.user = user;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public accountHolder getHolder() {
		return user;
	}
	
	public void setHolder(accountHolder user) {
		this.user = user;
	}
	
	public int deposit(double amount) {
		if (amount <= 0) {
			return 0;
		} else {
			balance += amount;
			return 1;
		}
	}
	
	public int withdraw(double amount) {
		if (amount > balance) {
			return 0;
		} else if (amount <= 0) {
			return 1;
		} else {
			balance -= amount;
			return 2;
		}
	}
	
}
