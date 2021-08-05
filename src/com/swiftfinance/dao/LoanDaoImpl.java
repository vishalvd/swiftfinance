package com.swiftfinance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.swiftfinance.util.JdbcFactory;
import com.swiftfinance.bean.CarBean;
import com.swiftfinance.bean.CustomerBean;
import com.swiftfinance.bean.LoanBean;

public class LoanDaoImpl implements LoanDao {

	public LoanDaoImpl() {

	}
	@Override
	public  boolean addcusomter(CustomerBean customer) throws SQLException {
		String sql = "insert into Customer values (?,?)";
		Connection conn = null;

		try {
			conn = JdbcFactory.getCon();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, customer.getName());
			stmt.setString(2, customer.getCity());
			stmt.executeUpdate();
			return true;
	 
		} finally {
			conn.close();
		}
	}

	@Override
	public boolean addLoanDetails(LoanBean loan) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "insert into loandetails values (?,?,?,(select max(custid) from customer),?,?,?)";
		Connection conn = null;
		

		try {
			conn = JdbcFactory.getCon();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, loan.getEmi());
			stmt.setInt(2, loan.getDuration());
			stmt.setDouble(3, loan.getAmount());
			stmt.setInt(4, loan.getCar().getCarid());
			stmt.setDouble(5, loan.getDownpayment());
			stmt.setDouble(6, loan.getIntr());
			stmt.executeUpdate();
			return true;
		 
		} finally {
			conn.close();
		}
	}

	@Override
	public List<LoanBean> getLoanDetailList() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select loanid, cu.name, c.name, emi, amount, c.carid, downpayment, intrate, duration from loandetails l, customer cu, car c where l.custid=cu.custid and l.carid=c.carid";

		List<LoanBean> loans = new ArrayList<LoanBean>();
		Connection con = null;
		try {
			con = JdbcFactory.getCon();
			ResultSet r = con.createStatement().executeQuery(sql);
			while (r.next()) {
				LoanBean loan = new LoanBean();
				CarBean car = new CarBean();
				car.setName(r.getString(3));
				car.setCarid(r.getInt(6));
				
				CustomerBean cust = new CustomerBean();
				cust.setName(r.getString(2));

				loan.setLoanid(r.getInt(1));
				loan.setCust(cust);
				loan.setCar(car);
				loan.setEmi(r.getDouble(4));
				loan.setAmount(r.getDouble(5));
				loan.setDownpayment(r.getDouble(7));
				loan.setIntr(r.getDouble(8));
				loan.setDuration(r.getInt(9));
				loans.add(loan);
			}
			return loans;
		} finally {
			// TODO: handle finally clause
			con.close();
		}
	}

}
