<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SwiftFinance</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>

  <link rel="stylesheet" href="swiftfin.css"/>
  <script type="text/javascript" src="swiftfin.js"> </script>
 

</head>
<body>
<jsp:include page="banner.html"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<form name="loandata" action="Loan.sf" method="post">
		<div class="outer1 rounded">
			<div class="inner2">

				<div class="input-group" style="margin-left: 20px;">
					<br> <span class="input-group-text">Manufacturer</span> <select
						class="form-control" name="manufacturer" id="manufacturer">
						<option>Select</option>
						<%
							Map<Integer, String> manufacturer = (Map<Integer, String>) session.getAttribute("MANUFACTURER");

						if (manufacturer != null) {
							//System.out.println("manufacturer jsp if : " + manufacturer.size());
							for (int key : manufacturer.keySet()) {
						%>
						<option value="<%=key%>"><%=manufacturer.get(key)%></option>
						<%}
						}%>

					</select> <br>
					<br> <span class="input-group-text">Car</span>
					 <select class="form-control" style="margin-left: 87px;" name="car" id="car">

					</select> <br>
					<br> <span class="input-group-text">Price</span> 
					<input type="text" style="margin-left: 75px;" id="price" name="price"
						readonly class="form-control"> <br>
					<br> <span class="input-group-text">Down-Payment</span> 
					<input type="text" style="margin-left: 5px;" id="downpayment"
						name="downpayment" value="0" onkeydown="return numberonly(event)"
						onchange='calcprincipal(this.value)' class="form-control">
				</div>
				<br>

			</div>
		</div>
		<br>
		<div class="outer1 rounded">
			<br>
			<div name="rangediv" class="inner2"
				style="padding-right: 3%; border-right: 1pt solid gainsboro;">
				<label for="loanamt">Loan Amount(&#8377;)</label>
				<div style="float: right;">
					<input type="text" readonly name="loanamt" id="loanamt" value="200000"
						style="text-align: right;" onchange="princeamt.value=value;">
				</div>
				<br>
				<br> <input id="loanamtrange"  type="range" name="range" step="5000" min="100000"
					max="4000000" value="200000"
					onmousemove="loanamt.value=value;princeamt.value=value ;calculate(); ">
				<br> <label class="form-label minmax">1L</label><label
					class="form-label minmax" style="float: right;">40L</label> <br>
				<br> <label for="intperc" class="form-label">Interest(%)</label>
				<div style="float: right;">
					<input type="text" readonly name="intperc" id="intperc" value="6.5"
						style="text-align: right;" />
				</div>
				<br>
				<br> <input id="intrestrange"  type="range" name="range" step="0.05" min="4.5"
					max="14.5" value="6.5" onmousemove="intperc.value=value;calculate();"><br>

				<label class="form-label minmax">4.5%</label><label
					class="form-label minmax" style="float: right;">14.5%</label><br>
				<br> <label for="tenure" class="form-label">Tenure(Years)</label>
				<div style="float: right;">
					<input type="text" id="tenure" name="tenure" readonly value="5"
						style="text-align: right;" />
				</div>
				<br>
				<br> <input id="tenuretrange"  type="range" name="range" step="1" min="1" max="30"
					value="5" onmousemove="tenure.value=value;calculate();"><br> <label
					class="form-label minmax">1 Year</label><label
					class="form-label minmax" style="float: right;">30 Years</label>


			</div>
			<div name="emi" class="inner2" style="padding: 0; font-size: 14pt;">
				<label for="">EMI </label> <input type="text" name="emiamt" id="emiamt" value="0"
					class="emiamount" readonly><br> <br>
				<div id="hr"></div>
				<br> <label for="">Principal </label> <input type="text"
					name="princeamt" id="princeamt" class="emiamount" value="200000" readonly> <br>
				<br>
				<br> <label for="">Interest </label> <input type="text"
					name="intamt" id="intamt" class="emiamount" value="0" readonly> <br>
				<br>
				<br> <label for="">Total </label> <input type="text" id="total"
					class="emiamount" value="0" readonly> <br>
				<br>
				<br>

			</div>
		</div>
		<br>
		<div id="cust" class="outer1 rounded">
			<br>
			<div class="inner1">
				<div style="float: left; width: 45%;text-align:right;">
					<div class="input-group">

						<span class="input-group-text">Name</span>&ensp; <input type="text"
							class="form-control" id="custname" name="custname" onkeydown="return alphaOnly(event)">

					</div>
				</div>
				<div style="float: right; width: 45%;text-align:left;">
					<div class="input-group">

						<span class="input-group-text">City</span> 
						<select id="city" name="city" class="form-control">
<option value="Mumbai">Mumbai</option>
<option value="Delhi">Delhi</option>
<option value="Chennai">Chennai</option>
<option value="kolkata">Kolkata</option>
<option value="Kolkata">Hyderabad</option>
<option value="Jaipur">Jaipur</option>
</select>

					</div>
				</div>
				<br><br><br>
				<!-- <div class="input-group">
               <div class="input-group-prepend">
                 <span class="input-group-text">Age</span>
               </div>
               <input type="text"   class="form-control">
               
             </div> -->
			</div>
			<center>
				<button type="submit" class="btn btn-primary btn-sm summitbutton">Submit</button>&emsp;
				<button type="reset" class="btn btn-secondary btn-sm">Reset</button><br><br>
			</center>
		</div>
		<br>
	</form>



</body>
</html>