package com.swiftfinance.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.swiftfinance.bean.CarBean;
import com.swiftfinance.bean.ManufacturerBean;
import com.swiftfinance.dao.CarDao;
import com.swiftfinance.dao.CarDaoImpl;

public class CarServiceImpl implements CarService {

	private CarDao dao;

	public CarServiceImpl() {
		dao = new CarDaoImpl();

	}

	@Override
	public Map<Integer, String> getCars(int manuid) {
		// TODO Auto-generated method stub
		// List<Car> cars =new ArrayList<Car>();

		try {

			return dao.carlist(manuid).stream().collect(Collectors.toMap(CarBean::getCarid, CarBean::getName));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}

	@Override
	public Map<Integer, String> getManufacturers() {
		// TODO Auto-generated method stub

		try {

			return dao.list().stream().collect(Collectors.toMap(ManufacturerBean::getManufacturerid, ManufacturerBean::getManufacturer));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}

	/*
	 * @Override public List<ManufacturerBean> list() { // TODO Auto-generated
	 * method stub try { // List<CarBean> cars= ArrayList<CarBean>(); return
	 * dao.list(); // return cars.stream().collect(Collectors.toMap(Car::getCarid,
	 * Car::getName)); // return cars; } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); return null;
	 * 
	 * } }
	 */

	@Override
	public double getCarPrice(int carid) {
		 
		try {
			return dao.getCarPrice(carid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

}
