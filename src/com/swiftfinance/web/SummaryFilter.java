package com.swiftfinance.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SummaryFilter
 */
@WebFilter({ "/summary.jsp", "/report.jsp" })
public class SummaryFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SummaryFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		if (session.getAttribute("LOANDETAILS") == null)
			((HttpServletResponse) response).sendRedirect("index.html");
		else
			chain.doFilter(request, response);	// pass the request along the filter chain
		
		PrintWriter out = response.getWriter();
		out.println("<br><center><hr style='width:80%;' id='hr'> &copy; Copyright 2020-25 Digite Inc.</center><br><br>");
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
