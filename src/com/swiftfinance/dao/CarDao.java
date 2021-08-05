package com.swiftfinance.dao;

import java.sql.SQLException;
import java.util.List;

import com.swiftfinance.bean.CarBean;
import com.swiftfinance.bean.ManufacturerBean;



public interface CarDao {
 
	List<ManufacturerBean> list( ) throws SQLException;
	List<CarBean> carlist( int manuid) throws SQLException;
//	List<Car> manufact() throws SQLException;
	double getCarPrice(int carid) throws SQLException;
}
