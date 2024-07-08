import java.util.Scanner;

public class Account implements Transactions {
 
	private String userId;
	private String userName;
	private double balance;
	private double previousTransaction;
 
	public Account(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}
 
	@Override
	public String toString() {
		return "Account [userId=" + userId + ", userName=" + userName + ", balance=" + balance
				+ ", previousTransaction=" + previousTransaction + "]";
	}
 
	public String getUserId() {
		return userId;
	}
 
	public void setUserId(String userId) {
		this.userId = userId;
	}
 
	public String getUserName() {
		return userName;
	}
 
	public void setUserName(String userName) {
		this.userName = userName;
	}
 
	public double getBalance() {
		return balance;
	}
 
	public void setBalance(double balance) {
		this.balance = balance;
	}
 
	public double getPreviousTransaction() {
		return previousTransaction;
	}
 
	public void setPreviousTransaction(double previousTransaction) {
		this.previousTransaction = previousTransaction;
	}
 
	@Override
	public double deposit(double amount) {
		if (amount > 0 ) {
			balance = balance + amount;
			previousTransaction = amount;
		}
		return amount;
	}
 
	@Override
	public double withdraw(double amount) {
		if (amount > 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
		return amount;
	}
	@Override
	public double calculateInterest(int years) {
        double interestRate =0.064;
        double amount = this.balance*interestRate*years;    		
        return amount;
	}
 
	@Override
	public void lastTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Amount deposited " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Amount withdrawn " + previousTransaction);
		} else {
			System.out.println("No transaction done");
		}
	}
 
	public void showMenu() {
 
		System.out.println("Welcome, " + userName);
		char option;
		do {
			System.out.println("What would you like to do");
			System.out.println("A - Check your balance");
			System.out.println("B - Make a deposit");
			System.out.println("C - Make a withdraw");
			System.out.println("D - Check lasttransaction");
			System.out.println("E - Calculate interest");
			System.out.println("F - Exit");
			System.out.println("Enter an option: ");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			char ch = sc.next().charAt(0);
		    option = Character.toUpperCase(ch);
 
			switch (option) {
			case 'A':
				System.out.println("Your current balance: "+getBalance());
				System.out.println();
				break;
			case 'B':
				while (true){
					System.out.println("Enter amount you want to deposit:");
					try {
						@SuppressWarnings("resource")
						Scanner sc1 = new Scanner(System.in);
						String amount = sc1.next();
						double damount = Double.parseDouble(amount);
						double deposit = deposit(damount);
						System.out.println("Amount deposited successfully:" + " " + deposit);
						System.out.println();
						break;
					    }
					catch (NumberFormatException e) {
						System.out.println("Enter only Integer values");
					                                }
				            }
				break;
			case 'C':
			
				while (true) {
					System.out.println("Enter amount you want to withdraw:");
					try {
						@SuppressWarnings("resource")
						Scanner sc1 = new Scanner(System.in);
						String amount = sc1.next();
						double wamount = Double.parseDouble(amount);
						double withdraw= withdraw(wamount);
						System.out.println("Amount withdrawn successfully:" + " " + withdraw);
						System.out.println();
						break;
					    }
 
					catch (NumberFormatException e) {
						System.out.println("Enter only Integer values");
					}
				}
				break;
			case 'D':
				lastTransaction();
				break;
			case 'E':
				System.out.println("Enter number of years : ");
				Scanner scanner = new Scanner(System.in);
				int years=Integer.parseInt(scanner.next());
				System.out.println("Your interest for "+ years +" years : " + calculateInterest(years));
				
				
			}
			
 
		}
		while (option!='F');
		System.out.println("Thank you!");
	}
 
	
 
}

