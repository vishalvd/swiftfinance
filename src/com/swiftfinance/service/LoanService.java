package com.swiftfinance.service;

import java.util.List;

import com.swiftfinance.bean.CustomerBean;
import com.swiftfinance.bean.LoanBean;

public interface LoanService {

	boolean addLoanDetails(LoanBean loan);

	List<LoanBean> getLoanDetailList();

	boolean addcusomter(CustomerBean customer); 
}
