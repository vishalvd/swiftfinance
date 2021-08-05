package com.swiftfinance.dao;

import java.sql.SQLException;
import java.util.List;

import com.swiftfinance.bean.CustomerBean;
import com.swiftfinance.bean.LoanBean;

public interface LoanDao {

	boolean addLoanDetails(LoanBean loan) throws SQLException ;
	List<LoanBean> getLoanDetailList() throws SQLException ;
	
	boolean addcusomter(CustomerBean customer) throws SQLException ;
}
