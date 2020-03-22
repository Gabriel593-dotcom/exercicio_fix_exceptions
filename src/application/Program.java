package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Account account = new Account();

		try {
			System.out.println("Enter account data: ");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			account = new Account(number, holder, balance, withdrawLimit);
			System.out.print("Choice the service: [1 - withdraw / 2 - deposit] ");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:

				System.out.println();
				System.out.print("Enter amount for withdraw: ");
				account.withdraw(sc.nextDouble());
				System.out.print("New balance: " + account.getBalance());
				break;

			case 2:

				System.out.print("Enter amount for deposit: ");
				account.deposit(sc.nextDouble());
				System.out.print("New balance: " + account.getBalance());
				break;
			}

		}

		catch (DomainException e) {
			System.out.println("-------------------------------");
			System.out.println("Erro na transação: " + e.getMessage());
		}
		
		catch(InputMismatchException e) {
			System.out.println("-------------------------------");
			System.out.println("Digite um valor numérico para este campo.");
		}

		sc.close();
	}
}

// InputMismatchException