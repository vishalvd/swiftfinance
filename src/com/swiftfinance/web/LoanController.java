package com.swiftfinance.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.swiftfinance.bean.CarBean;
import com.swiftfinance.bean.CustomerBean;
import com.swiftfinance.bean.LoanBean;
import com.swiftfinance.service.CarService;
import com.swiftfinance.service.CarServiceImpl;
import com.swiftfinance.service.LoanService;
import com.swiftfinance.service.LoanServiceImpl;

@WebServlet(name = "Loan", urlPatterns = { "/Loan.sf" })
public class LoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoanService loanservice;
	private CarService carservice;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		loanservice = new LoanServiceImpl();
		carservice = new CarServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String referer = request.getParameter("first");// whole url
		if (referer!=null) {

			Map<Integer, String> manufacturer = carservice.getManufacturers();
			System.out.println("manufacturer fetch : " + manufacturer.size());

			// add object to request
			session.setAttribute("MANUFACTURER", manufacturer);
			response.sendRedirect("index.jsp");
			// forward to catalog page along with product list in request scope
			//getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} else {

			String manuid = request.getParameter("manuid");
			String carid = request.getParameter("carid");
			System.out.println(manuid);
			if (manuid != null) {
				Gson gson = new Gson(); // com.google.gson.Gson
				String carlist = gson.toJson(carservice.getCars(Integer.parseInt(manuid)));
				System.out.println(carlist);
				response.setContentType("text/html");
				response.getWriter().write(carlist);
				
			}
			else if(carid != null) {
				//Gson gson = new Gson(); // com.google.gson.Gson
				double price =carservice.getCarPrice(Integer.parseInt(carid));// gson.toJson(carservice.getCars(Integer.parseInt(manuid)));
				System.out.println(price);
				response.setContentType("text/html");
				response.getWriter().write(String.valueOf(price));
						
			}else {
				
				CustomerBean customerbean = new CustomerBean();
				customerbean.setName(request.getParameter("custname"));
				customerbean.setCity(request.getParameter("city"));
				if (loanservice.addcusomter(customerbean) == true) {
					LoanBean loanbean = new LoanBean();
					CarBean carbean = new CarBean();
					carbean.setCarid(Integer.parseInt(request.getParameter("car")));
				//	carbean.setName(request.getParameter("carname"));
					carbean.setPrice(Double.parseDouble(request.getParameter("price")));
					
					loanbean.setCar(carbean);
					loanbean.setCust(customerbean);
					loanbean.setEmi(Double.parseDouble(request.getParameter("emiamt")));
					loanbean.setAmount(Double.parseDouble(request.getParameter("princeamt")));
					loanbean.setDuration(Integer.parseInt(request.getParameter("tenure")));
					loanbean.setDownpayment(Double.parseDouble(request.getParameter("downpayment")));
					loanbean.setIntr(Double.parseDouble(request.getParameter("intperc")));
					 

					if (loanservice.addLoanDetails(loanbean)) {
						//
						
						session.setAttribute("LOANDETAILS", customerbean.getName());
					//	getServletContext().getRequestDispatcher("/summary.jsp").forward(request, response);
						response.sendRedirect("summary.jsp");
					} else {
						response.sendRedirect("index.jsp");
					}
				}
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
