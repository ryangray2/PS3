package base;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Account {
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated;
	
	public Account() {
	}

	public Account(int id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		DateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date dateCreated = new Date();
		return dateCreated;
	}

	public double getMonthlyInterestRate() {
		double month = this.annualInterestRate / 12;
		return month;
	}
	public void withdraw(double takeaway) throws InsufficientFundsException {
		if (this.balance >= takeaway) {
			this.balance = this.balance - takeaway;
		} else {
			double funds = takeaway - this.balance;
			throw new InsufficientFundsException(funds);
		}
	}
	public void deposit(double input) {
		this.balance = this.balance + input;
	}
}

