package termdeposit;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * This is a simple java program to calculate term deposit based on user inputs
 */
public class TermDepositCalculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			// This bit of code takes inputs from the user
			System.out.println("Enter Deposit Amount (in dollars): ");
			System.out.println();
			int principal = input.nextInt();
			System.out.println("Enter Interest Rate: ");
			System.out.println();
			double interestRate = input.nextDouble();
			System.out.println("Enter Investment Term in years only: ");
			System.out.println();
			int term = input.nextInt();

			System.out.println("Select interest paid options: ");
			System.out.println("1.Monthly");
			System.out.println("2.Quarterly");
			System.out.println("3.Anually");
			System.out.println("4.Maturity");
			while (!input.hasNextInt()) {
				input.next();
			}
			int intType = input.nextInt();
			switch (intType) {
			case 1:
				System.out.println("You have selected - Monthly");
				break;
			case 2:
				System.out.println("You have selected - Quarterly");
				break;
			case 3:
				System.out.println("You have selected - Anually");
				break;
			case 4:
				System.out.println("You have selected - Maturity");
				break;
			default:
				System.out.println("Invalid Option selected");
				System.out.println("So displaying only final amount at maturity");
				break;
			}
			// function that calculates term deposit results
			calculateTermDeposit(principal, interestRate, term, intType);
			// Any incorrect input or other exceptions throws will be caught here
		} catch (InputMismatchException ex) {
			System.out.println("Incorrect input " + ex);
		} catch (Exception ex) {
			System.out.println("Exception " + ex);
		} finally {
			input.close();
		}
	}

	/*
	 * Takes deposit amount, interest rate, investment term and interest paid type
	 * (i.e., monthly, quarterly, annually, at maturity)as inputs and produces
	 * output as total amount at maturity, total interest and interest during each
	 * period
	 */
	private static void calculateTermDeposit(int principal, double interestRate, int term, int type) {
		double balance = principal * Math.pow(1 + interestRate / 100.0, term);
		int finalAmount = (int) balance;
		System.out.println("----------------------------------------");
		System.out.println("OUTPUT");
		System.out.println("----------------------------------------");
		System.out.println("Final balance at maturity : $ " + finalAmount);
		int interestPaid = finalAmount - principal;
		System.out.println("Interest paid at maturity: $ " + interestPaid);

		if (type == 1) {
			int monthlyInt = interestPaid / (term * 12);
			System.out.println("Interest paid each month is: $ " + monthlyInt);
		} else if (type == 2) {
			int quarterInt = interestPaid / (term * 4);
			System.out.println("Interest paid each quarter is: $ " + quarterInt);
		} else if (type == 3) {
			int yearlyInt = interestPaid / (term);
			System.out.println("Interest paid each year is: $ " + yearlyInt);
		} else if (type == 4) {
			System.out.println("Interest paid at maturity is: $ " + interestPaid);
		}

	}
}
