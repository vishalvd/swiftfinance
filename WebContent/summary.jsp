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
		String customername = (String)session.getAttribute("LOANDETAILS");
	//	session.removeAttribute("LOANDETAILS");
	%>
	
	<div class="outer1 rounded">
	<label style="float: right"><a href="report.jsp">Report</a> </label>
		<div class="inner2">

			<div class="input-group" style="margin-left: 20px;">
				


				<sql:query var="rs" dataSource="jdbc/mssql">
					select max(loanid) as appno from loandetails
				</sql:query>

				<c:forEach items="${rs.rows}" var="row">
				<br> <%=customername %> , <br> <br> <span>
				Thank you for considering us, your applcation is being processed</span><br>
				<br>
				<span>Your Loan Application no : 	${row.appno}</span><br><br><br>
				</c:forEach>

			</div>
		</div>
</body>
</html>