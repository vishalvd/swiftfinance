package com.swiftfinance.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.swiftfinance.bean.CarBean;
import com.swiftfinance.service.CarService;
import com.swiftfinance.service.CarServiceImpl;

public class TestCarServiceImpl {
	private CarBean car;
	private CarService service;

	@BeforeEach
	public void init() {
		service = new CarServiceImpl();
	}
	
	@Test	
	public void testgetManufacturersCount() {
	
	assertTrue(service.getManufacturers().size()==4);
	}

	
	@Test	
	public void testgetCarPrice() {
	
	assertTrue(service.getCarPrice(101)==1450000 );
	}
	
	@Test	
	public void testgetCarPriceNull() {
	
	//assertThrows(service.getCarPrice(null));
	assertThrows(NullPointerException.class,()->service.getCarPrice((Integer) null));
	}

}
