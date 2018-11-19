import java.util.Scanner;

public class ATM {

	static Scanner in = new Scanner(System.in);
	private bankAccount account;
	
	ATM(bankAccount account) {
		this.account = account;
	}
	
	public static void main(String[] args) {
		System.out.println("//Account Creation//\n");
		System.out.println("What is your PIN?");
		int pin = in.nextInt();
		in.nextLine();
		System.out.println("What is your name?");
		String name = in.nextLine();
		System.out.println("What is your address?");
		String address = in.nextLine();
		accountHolder user = new accountHolder(pin, name, address);
		
		System.out.println("What is your account number?");
		int accountNumber = in.nextInt();
		in.nextLine();
		
		bankAccount account = new bankAccount(0.00, accountNumber, user);
		ATM atm = new ATM(account);
		if(atm.verify()) {
			atm.menu();
		} else {
			System.out.println("Invalid PIN.");
		}
		in.close();
	}
	
	public void menu() {
		boolean again = true;
		while (again) {
			System.out.println("\nWhat would you like to do?\n\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
			int n = in.nextInt();
			in.nextLine();
			switch (n) {
			case 1 : 
				System.out.println("How much would you like to deposit?");
				double b = in.nextDouble();
				in.nextLine();
				switch (this.account.deposit(b)) {
				case 0 : System.out.println("Cannot deposit negative number.");
				break;
				case 1 : System.out.println("Transaction complete. Would you like to continue (y/n)?");
					String response = in.nextLine();
				if (response.equals("y")) {
						again = true;
				} else {
					again = false;
				}
				break;
				}
				break;
			case 2 :
				System.out.println("How much would you like to withdraw?");
				double w = in.nextDouble();
				in.nextLine();
				switch (this.account.withdraw(w)) {
					case 0 :
						System.out.println("Cannot withdraw more than balance.");
						break;
					case 1 :
						System.out.println("Cannot withdraw non-positive number.");
						break;
					case 2 : System.out.println("Transaction complete. Would you like to continue (y/n)?");
					String response = in.nextLine();
				if (response.equals("y")) {
						again = true;
				} else {
					again = false;
				}
					break;
				}
				again = true;
				break;
			case 3 :
				System.out.println("Current Balance: " + this.account.getBalance() + "\nWould you like to continue?");
				String response = in.nextLine();
				if (response.equals("y")) {
					again = true;
				} else {
					again = false;
				}
				break;
			case 4 :
				System.out.println("Have a nice day.");
				again = false;
				break;
			default :
				System.out.println("Invalid input.");
				again = true;
				break;
			}
		}
		if (!again) {
			System.out.println("Have a nice day.");
		}
	}
	
	public boolean verify() {
		System.out.println("//User Verification//\n");
		System.out.println("What is your PIN?");
		int pin = in.nextInt();
		in.nextLine();
		if (pin == this.account.getHolder().getPIN()) {
			System.out.println("Verification complete.\n");
			return true;
		} else {
			return false;
		}
	}
}
