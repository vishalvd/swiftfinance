package com.swiftfinance.service;

import java.util.List;
import java.util.Map;

import com.swiftfinance.bean.CarBean;
import com.swiftfinance.bean.ManufacturerBean;

public interface CarService {

	Map<Integer,String> getCars(int manuid);
	Map<Integer,String> getManufacturers();
	//List<ManufacturerBean> list();
	double getCarPrice(int carid); 
	
}
