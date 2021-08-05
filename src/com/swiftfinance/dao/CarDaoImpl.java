package com.swiftfinance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.swiftfinance.bean.CarBean;
import com.swiftfinance.bean.ManufacturerBean;
import com.swiftfinance.util.JdbcFactory;

public class CarDaoImpl implements CarDao {

	@Override
	public List<ManufacturerBean> list() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from manufacturer";

		List<ManufacturerBean> manufacturers = new ArrayList<ManufacturerBean>();
		Connection con = null;
		try {
			con = JdbcFactory.getCon();
			ResultSet r = con.createStatement().executeQuery(sql);
			while (r.next()) {
				ManufacturerBean mnu = new ManufacturerBean();
//				car.setCarid(r.getInt(1));
//				car.setName(r.getString(2));
//				car.setPrice(r.getDouble(3));
				mnu.setManufacturerid(r.getInt(1));
				mnu.setManufacturer(r.getString(2));
				manufacturers.add(mnu);
			}
			return manufacturers;
		} finally {
			// TODO: handle finally clause
			con.close();
		}
	}

	@Override
	public List<CarBean> carlist(int manuid ) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from car where manuid=" + manuid;

		List<CarBean> cars = new ArrayList<CarBean>();
		Connection con = null;
		try {
			con = JdbcFactory.getCon();
			ResultSet r = con.createStatement().executeQuery(sql);
			while (r.next()) {
				CarBean car = new CarBean();
				car.setCarid(r.getInt(1));
				car.setName(r.getString(2));
				car.setPrice(r.getDouble(3));
				cars.add(car);
			}
			return cars;
		} finally {
			// TODO: handle finally clause
			con.close();
		}
	}
	@Override
	public double getCarPrice(int carid ) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select price from car where carid=" + carid;

		Double price=null;
		Connection con = null;
		try {
			con = JdbcFactory.getCon();
			ResultSet r = con.createStatement().executeQuery(sql);
		if (r.next()) {
				 
				price = r.getDouble(1);
				//cars.add(car);
			}
			return price;
		} finally {
			// TODO: handle finally clause
			con.close();
		}
	}

}
