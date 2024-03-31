package com.codsoft.task3;

import java.util.Scanner;

public class ATM {

	private BankAccount bankAccount;

	public ATM(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public void displayMenu() {
		System.out.println("Welcome to the ATM.");
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Exit");
		System.out.println("Enter your choice: ");
	}

	public void processOption(int choice) {
		Scanner scanner = new Scanner(System.in);
		switch (choice) {
		case 1:
			System.out.println("Your balance: " + bankAccount.getBalance());
			break;
		case 2:
			System.out.println("Enter deposit amount: ");
			float depositAmount = scanner.nextFloat();
			bankAccount.deposit(depositAmount);
			break;
		case 3:
			System.out.println("Enter withdrawal amount: ");
			float withdrawAmount = scanner.nextFloat();
			bankAccount.withdraw(withdrawAmount);
			break;
		case 4:
			System.out.println("Thank you for using the ATM.");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid choice. Please try again.");
		}
	}

	public static void main(String[] args) {
		BankAccount userAccount = new BankAccount(1000);
		ATM atm = new ATM(userAccount);

		while (true) {
			atm.displayMenu();
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			atm.processOption(choice);
		}
	}
}
