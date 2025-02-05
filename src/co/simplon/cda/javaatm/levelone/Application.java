package co.simplon.cda.javaatm.levelone;

import java.util.Scanner;

// this is the first level of the brief, 
//I decided to separat the 2 versions to keep a trace of what I did in the first place even if I start the second level

public class Application {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// false user data
		String userGoodCardNumber = "0123456789";
		int userGooddPin = 187;
		int userBalance = 500;

		// Authentification
		System.out.print("ATM > Input your card number: ");
		String inputCardNumber = scanner.nextLine();

		// in the first place, in the condition i tried 
		//(inputCardNumber != userGoodCardNumber) 
		// and it didn't work but I don't understand why, can you explain to me?
		if (!inputCardNumber.equals(userGoodCardNumber)) {
			System.out.println("ATM > Unknown card, bye!");
			return; // I didn't find a better way to close the program than a return
		}

		System.out.print("ATM > Enter PIN code: ");
		int inputPin = scanner.nextInt();
		scanner.nextLine();

		if (inputPin != userGooddPin) {
			System.out.println("ATM > Bad PIN code, bye!");
			return;
		}

		// operation choice
		System.out.print("ATM > Choose operation. Enter 'withdraw' or 'balance': ");
		String operation = scanner.nextLine().trim().toLowerCase();

		// withdraw
		if (operation.equals("withdraw")) {
			System.out.print("ATM > Enter amount to withdraw: ");
			int amount = scanner.nextInt();

			if (amount > userBalance) {
				System.out.println("ATM > Not enough money, bye!");
			} else {
				userBalance -= amount;
				System.out.println("ATM > Here is your money (" + amount + "), bye!");
			}

		// balance
		} else if (operation.equals("balance")) {
			System.out.println("ATM > Your balance is " + userBalance + ", bye!");
		} else {
			System.out.println("ATM > Bad operation, bye!");
		}

		scanner.close();
	}

}
