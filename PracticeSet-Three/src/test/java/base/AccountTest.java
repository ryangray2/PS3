package base;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Date;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	Account acc = new Account(1122, 20000);
	
	
	@Test
	public void WithdrawTest() throws InsufficientFundsException {
		acc.withdraw(2500);
		double test = acc.getBalance();
		assertEquals(17500, test, 0);
	}
	
	@Test(expected = InsufficientFundsException.class)
	public void WithdrawTest2() throws InsufficientFundsException {
		acc.withdraw(25000);
	}
	
	@Test
	public void DepositTest() {
		acc.deposit(3000);
		double test = acc.getBalance();
		assertEquals(23000, test, 0);
	}
	
	@Test
	public void MonthlyTest() {
		acc.setAnnualInterestRate(4.5);
		double test = acc.getMonthlyInterestRate();
		assertEquals(.375, test, .00001);
	}
	@Test
	public void PrintTest() {
		acc.setAnnualInterestRate(4.5);
		Date d = acc.getDateCreated();
		Double b = acc.getBalance();
		Double mi = acc.getMonthlyInterestRate();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println("Balance: " + b + "  Monthly Interest: " + mi + "%  Date Created: " + dateFormat.format(d));
	}

}