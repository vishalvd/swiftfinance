package com.swiftfinance.service;

import java.sql.SQLException;
import java.util.List;

import com.swiftfinance.bean.CustomerBean;
import com.swiftfinance.bean.LoanBean;
import com.swiftfinance.dao.LoanDao;
import com.swiftfinance.dao.LoanDaoImpl;

public class LoanServiceImpl implements LoanService {
private LoanDao dao;
	public LoanServiceImpl() {
		dao= new LoanDaoImpl();
	}
	@Override
	public boolean addLoanDetails(LoanBean loan) {
		// TODO Auto-generated method stub

		try {
			
			
			return dao.addLoanDetails(loan);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public List<LoanBean> getLoanDetailList() {
		// TODO Auto-generated method stub

		try {
			return dao.getLoanDetailList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean addcusomter(CustomerBean customer) {
		// TODO Auto-generated method stub
		try {
			return dao.addcusomter(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
			 
		
		
	}

}
