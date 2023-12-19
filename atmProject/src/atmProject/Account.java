package atmProject;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

	private int customerNumber;
	private int pinNumber;
	private double checkingBalance = 0;
	private double savingBalance = 0;

	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	public int setCustomerNumber(int customerNumber) { // setters and getters for all the variables as it is masked with private
		this.customerNumber = customerNumber;
		return customerNumber;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public double getSavingBalance() {
		return savingBalance;
	}
	
	public double calCheckingWithdraw( double amount) { // doing subtraction of balance
		
		checkingBalance = (checkingBalance - amount);
		
		return checkingBalance;
		
	}
	
	public double calSavingWithdraw( double amount) {
		
		savingBalance = (savingBalance - amount);
		
		return savingBalance;
		
	}
	
	public double calCheckingDeposit( double amount) { // doing addition of balance with amount
		
		checkingBalance = (checkingBalance + amount);
		
		return checkingBalance;
		
	}
	
	
	public double calSavingDeposit( double amount) {
		
		savingBalance = (savingBalance + amount);
		
		return savingBalance;
		
	}
	
	public void getCheckingWithdrawInput() {
		
		System.out.println("Checking Account Balance : " + moneyFormat.format(checkingBalance));
		
		System.out.println("Enter the amount you want to withdraw from Checking Account : ");
		
		double amount = input.nextDouble();
		
		if(checkingBalance - amount >= 0) { // withdraw condition
			
			calCheckingWithdraw(amount);
			System.out.println("Updated Checking Account Balance : " + moneyFormat.format(checkingBalance) );		
			
		}else {
			
			System.out.println("Balance cannot be negative. " + "\n");
		}
		
		
	} 
	
	public void getSavingWithdrawInput() {
		
		System.out.println("Saving Account Balance : " + moneyFormat.format(savingBalance));
		
		System.out.println("Enter the amount you want to withdraw from Saving Account : ");
		
		double amount = input.nextDouble();
		
		if(savingBalance - amount >= 0) {
			
			calSavingWithdraw(amount);
			System.out.println("Updated Saving Account Balance : " + moneyFormat.format(savingBalance) );		
			
		}else {
			
			System.out.println("Balance cannot be negative. " + "\n");
		}
		
		
	}
	
	public void getCheckingDepositInput() {
		
		System.out.println("Checking Account Balance : " + moneyFormat.format(checkingBalance));
		
		System.out.println("Enter the amount you want to deposit to your Checking Account : ");
		
		double amount = input.nextDouble();
		
		if(checkingBalance + amount >= 0) { // deposit condition
			
			calCheckingDeposit(amount);
			System.out.println("Updated Checking Account Balance : " + moneyFormat.format(checkingBalance) );		
			
		}else {
			
			System.out.println("Balance cannot be negative. " + "\n");
		}

	}  
	
	public void getSavingDepositInput() {
		
		System.out.println("Saving Account Balance : " + moneyFormat.format(savingBalance));
		
		System.out.println("Enter the amount you want to deposit to your Saving Account : ");
		
		double amount = input.nextDouble();
		
		if(savingBalance + amount >= 0) {
			
			calSavingDeposit(amount);
			System.out.println("Updated Saving Account Balance : " + moneyFormat.format(savingBalance) );		
			
		}else {
			
			System.out.println("Balance cannot be negative. " + "\n");
		}

	}
	
}
