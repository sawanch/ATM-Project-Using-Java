package atmProject;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;


public class OptionMenu extends Account {

	Scanner menuInput = new Scanner(System.in);

	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00"); // 0: This is also a placeholder for a digit. However, unlike #, if there is no digit in that place, a "0" will be displayed.

	HashMap<Integer, Integer> data = new HashMap<>(); // stores customer id and Pin Number

	public void getLogin() throws IOException {
		int x = 1;

		do {
			try {

				data.put(952141, 191904);
				data.put(989947, 71976);

				System.out.println("Welcome to the ATM Project by Sawan!");
				System.out.println("Please enter your Customer Number: ");
				setCustomerNumber(menuInput.nextInt());

				System.out.println("Enter your PIN number: ");
				setPinNumber(menuInput.nextInt());

			} catch (Exception e) {

				System.out.println("\n" + "Invalid Character(s). Only Numbers." + "\n");
				x = 2;

			}
			
			int cn = getCustomerNumber();
			int pn = getPinNumber();
					
			if(data.containsKey(cn) && data.get(cn) == pn) { // matches the customer number with respective pin number
				getAccountType();
			}
			else {
				System.out.println("\n"+"Wrong Customer Number or Pin Number"+"\n");
			}

		} while (x == 1);
	}

	public void getAccountType() {

		System.out.println("Select the the type of Account you want to access: ");
		System.out.println("Type 1 : Checking Account ");
		System.out.println("Type 2 : Savings Account ");
		System.out.println("Type 3 : Exit ");

		int selection = menuInput.nextInt();

		switch (selection) {

		case 1:
			getChecking(); // fetches checking account
			break;

		case 2:
			getSaving(); // fetches saving account
			break;

		case 3:
			System.out.println("Thank you for using this ATM, bye. \n");
			break;

		default:
			System.out.println("\n" + "Invalid Choice" + "\n");
			getAccountType();

		}

	}

	public void getChecking() {

		System.out.println("Checking Account: ");
		System.out.println("Type 1 : View Account Balance ");
		System.out.println("Type 2 : Withdraw Funds ");
		System.out.println("Type 3 : Deposit Funds ");
		System.out.println("Type 4 : Exit ");
		System.out.println("Please enter your choice : ");

		int selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance())); // prints balance in the decimal format provided in  the beginning
			getAccountType();
			break;

		case 2:
			getCheckingWithdrawInput(); // calls withdraw method from Account class
			getAccountType();
			break;

		case 3:
			getCheckingDepositInput(); // calls deposit method from the Account class
			getAccountType();
			break;

		case 4:
			System.out.println("Thank you for using this ATM, bye. \n"); // exits the 
			break;

		default:
			System.out.println("\n" + "Invalid Choice" + "\n");
			getAccountType();

		}

	}

	public void getSaving() {

		System.out.println("Saving Account: ");
		System.out.println("Type 1 : View Account Balance ");
		System.out.println("Type 2 : Withdraw Funds ");
		System.out.println("Type 3 : Deposit Funds ");
		System.out.println("Type 4 : Exit ");
		System.out.println("Please enter your choice : ");

		int selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;

		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;

		case 3:
			getSavingDepositInput();
			getAccountType();
			break;

		case 4:
			System.out.println("Thank you for using this ATM, bye. \n");
			break;

		default:
			System.out.println("\n" + "Invalid Choice" + "\n");
			getAccountType();

		}

		
		
	}

}
