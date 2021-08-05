$(document).ready(function() {
/* 		var $select1 = $('#manufacturer'), $select2 = $('#car'), $options = $select2.find('option');

						$select1.on('change',function() {
									$select2.html($options.filter('[value="'
											+ this.value + '"]'));
								}).trigger('change'); */


		$('#manufacturer').change(function () {
            $('#car').find('option').remove();
            $('#car').append('<option>Select</option>');

            let sid = $('#manufacturer').val();
            console.log(sid);
            let data = {
                manuid: sid
            };

            $.ajax({
                url: "Loan.sf",
                method: "GET",
                data: data,
                success: function (data, textStatus, jqXHR) {
                	console.log(data.error);
                    console.log(data);
                    let obj = $.parseJSON(data);
                    $.each(obj, function (key, value) {
                        $('#car').append('<option value="' + key + '">' + value + '</option>')
                    });
                   // $('select').formSelect();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                	 console.log(textStatus, errorThrown);
                    //  $('#car').append('<option>Car Unavailable</option>');
                },
                cache: false
            });
        }); //manufacturer.change

		$('#car').change(function () {
          	let sid = $('#car').val();
            let data = {
                carid: sid
            };

            $.ajax({
                url: "Loan.sf",
                method: "GET",
                data: data,
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                  //  let obj = $.parseJSON(data);
                  // $("#loanamt").val(data.toString());
                   $("#price").val(data.toString());

					calcprincipal($("#downpayment").val());
					//calculate();
                  //  $("#loanamtrange").val(data.toString());
                   //$("#princeamt").val(data.toString());
                   
                    //$('select').formSelect();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                  // console.log("price error");
                   console.log(textStatus, errorThrown);
                  // $("#loanamt").val("200000");
                   $("#price").val("");
                },
                cache: false
            });
        }); //car.change

		}); //doc.ready

		function calcprincipal(down){
			var price = document.getElementById("price").value; 
			if(price!=="" || price!==0){
			
			var value =price- down;
			  $("#loanamt").val(value);
			  $("#loanamtrange").val(value);
              $("#princeamt").val(value);
              
              calculate();}
			}
		function alphaOnly(event) {
			  var key = event.keyCode;
			  
			  return ((key >= 65 && key <= 90) || key == 8 || key==46);
			}
		function numberonly(event){
			 var key = event.keyCode;
			// console.log(key);
			return ((key <= 57 && key >= 48) || key == 8 || key==46);
			//if(event.which < 48 || event.which > 57 ) if(event.which != 8) return false;
				
			}


	/* 	How is EMI calculated?

		EMI = (P X R/12) X [(1+R/12) ^N] / [(1+R/12) ^N-1].

		P is the original loan amount or principal,
		 R is the rate of interest that is applicable per annum 
		 N is the number of monthly installments/ loan tenure. */

		function calculate() {
		    //  
		    console.log("calculate");
		    var principal = document.loandata.loanamt.value;
		    var interest = document.loandata.intperc.value / 100 / 12;
		    var numberofemi = document.loandata.tenure.value * 12;
			console.log(principal);
			console.log(interest);
			console.log(numberofemi);
		    // Now compute the monthly payment figure 
		    var x = Math.pow(1 + interest, numberofemi);
		    var monthly = (principal*x*interest)/(x-1);
		    console.log(monthly)
		    // Check that the result is a finite number. If so, display the results.
		    if (!isNaN(monthly) && 
		        (monthly != Number.POSITIVE_INFINITY) &&
		        (monthly != Number.NEGATIVE_INFINITY)) {

		        document.loandata.emiamt.value = round(monthly);
		        document.loandata.total.value = round(monthly * numberofemi);
		        document.loandata.intamt.value = round((monthly * numberofemi) - principal);
		    }
		    // Otherwise, the user's input was probably invalid, so don't
		    // display anything.
		    else {
		        document.loandata.emiamt.value = "0";
		        document.loandata.total.value = "0";
		        document.loandata.intamt.value = "0";
		    }
		}

		// This simple method rounds a number to two decimal places.
		function round(x) {
		  return Math.round(x*100)/100;
		}