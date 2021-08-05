package com.swiftfinance.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.swiftfinance.bean.CarBean;
import com.swiftfinance.bean.CustomerBean;
import com.swiftfinance.bean.LoanBean;
import com.swiftfinance.service.LoanService;
import com.swiftfinance.service.LoanServiceImpl;

public class TestLoanServiceImpl {

	private LoanBean loan;
	private CustomerBean cust;
	private LoanService service;

	@BeforeEach
	public void init() {
		service = new LoanServiceImpl();
	}

	@Test
	public void testaddcustomer() {
		// TODO Auto-generated method stub
		cust= new CustomerBean();
		cust.setCity("Mumbai");
		cust.setName("Vishal");
		assertTrue(service.addcusomter(cust));
	}
	@Test
	public void testaddcustomernull() {
		// TODO Auto-generated method stub
		 
		assertFalse(service.addcusomter(null));
	}
	
 
	@Test
	public void testaddLoanDetails() {
		// TODO Auto-generated method stub
		cust= new CustomerBean();
		
		cust.setCity("Mumbai");
		cust.setName("Maria");
		
		if (service.addcusomter(cust)) {
		CarBean car = new CarBean();
		car.setName("City");
		car.setCarid(101);
		
		loan = new LoanBean();
		 
		loan.setCust(cust);
		loan.setCar(car);
		loan.setEmi(28370.91);
		loan.setDuration(5);
		loan.setAmount(1450000);
		loan.setDownpayment(0);
		loan.setIntr(6.50);
		assertTrue(service.addLoanDetails(loan));
		}
	}
	@Test
	public void testaddLoanDetailsnull() {
		// TODO Auto-generated method stub
		 
		assertFalse(service.addLoanDetails((null)));
	}
	
	
}
