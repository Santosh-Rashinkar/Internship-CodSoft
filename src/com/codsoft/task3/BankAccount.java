package com.codsoft.task3;

import java.util.Scanner;

//BankAccount class representing the user's bank account
public class BankAccount {
	private float balance;

	public BankAccount(float initialBalance) {
		this.balance = initialBalance;
	}

	public float getBalance() {
		return balance;
	}

	public void deposit(float amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposit successful. New balance: " + balance);
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}

	public void withdraw(float amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawal successful. New balance: " + balance);
		} else {
			System.out.println("Invalid withdrawal amount or insufficient balance.");
		}
	}
}
