<%@page import="com.swiftfinance.bean.CustomerBean"%>
<%@page import="com.swiftfinance.bean.LoanBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SwiftFinance</title>
<link rel="stylesheet" href="swiftfin.css">
</head>
<body>
	<jsp:include page="banner.html" />
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
	<%
		session.removeAttribute("LOANDETAILS");
	%>
	<div class="outer1 rounded">


		<div class="inner2">



			<sql:query var="rs" dataSource="jdbc/mssql">
					select loanid, cu.name nm, c.name cnm, emi, intrate, amount, duration from loandetails l, customer cu, car c where l.custid=cu.custid and l.carid=c.carid
				</sql:query>
			<table border="1" bordercolor="gainsboro">
				<tr>
					<th>Customer</th>
					<th>Car</th>
					<th>EMI</th>
					<th>Int(%)</th>
					<th>Loan Amount</th>
					<th>Tenure</th>
				</tr>
				<c:set var="total" value="${0}" />
				<c:forEach items="${rs.rows}" var="row">
					<c:set var="total"
						value="${total +  (((row.emi * 12)* row.duration)-row.amount)}" />
					<tr>
						<td>${row.nm}</td>
						<td>${row.cnm}</td>
						<td>${row.emi}</td>
						<td>${row.intrate}</td>
						<td>${row.amount}</td>
						<td>${row.duration}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6">Total Intrest Earned : ${total}</td>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>