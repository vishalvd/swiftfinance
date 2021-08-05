package com.swiftfinance.bean;

public class LoanBean {
	private int loanid;
	private double emi;
	private double amount;
	private int duration;
	private double downpayment;
	private CarBean car;
	private CustomerBean cust;
	private double intr;
	
	public int getLoanid() {
		return loanid;
	}

	public void setLoanid(int loanid) {
		this.loanid = loanid;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getDownpayment() {
		return downpayment;
	}

	public void setDownpayment(double downpayment) {
		this.downpayment = downpayment;
	}

	public CarBean getCar() {
		return car;
	}

	public void setCar(CarBean car) {
		this.car = car;
	}

	public CustomerBean getCust() {
		return cust;
	}

	public void setCust(CustomerBean cust) {
		this.cust = cust;
	}

	public double getIntr() {
		return intr;
	}

	public void setIntr(double intr) {
		this.intr = intr;
	}

}
