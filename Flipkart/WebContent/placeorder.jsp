<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<%@ page import="org.iiitb.flipkart.cart.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>


<%-- <link rel="stylesheet" href="/Flipkart/bootstrap/css/bootstrap.min.css">
<script src="/Flipkart/bootstrap/js/jquery.min.js"></script>
<script src="/Flipkart/bootstrap/js/bootstrap.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> --%>




<head>

<meta charset="UTF-8">

<title>Placeorder</title>


<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet"
	href="font-awesome-4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

<%-- <script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"
	type="text/javascript"></script> --%>
<!-- Latest compiled JavaScript -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<%-- <script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> --%>
<script src="js/modernizr.js"></script>
<script src="js/index.js"></script>
<style>
.flip_nav7 {
	background:  url(images/r9.png)
		100px top repeat;
	height: 79px;
}

.backcolour_placeorder {
	background: url(images/r10.png) repeat;
	height: 1000px;
}

.addressbox {
	width: 250px;
	height: 310px;
	padding: 40px;
	border: 1px solid gray;
	margin: 30px;
	background: #D0D0D0;
}

.addressbox:hover {
	background: white;
	border: 1px solid blue;
}

.continueshopping1 {
	color: #f9f9f9;
	height: 41px;
	width: 200px;
	font-size: 14px;
	background: #f78828;
	border: 1px solid #da7532;
}

.addtocart1 {
	vertical-align: middle;
	cursor: pointer;
	text-shadow: 0 0 1px rgba(0, 0, 0, 0.33);
	border: 1px solid;
	border-radius: 4px;
	outline: 0;
}

.placeorder-open {
	overflow: hidden
}

.placeorder {
	position: fixed;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	z-index: 1040;
	display: none;
	overflow: auto;
	overflow-y: scroll
}

.placeorder.fade .placeorder-dialog {
	-webkit-transform: translate(0, -25%);
	-ms-transform: translate(0, -25%);
	transform: translate(0, -25%);
	-webkit-transition: -webkit-transform .3s ease-out;
	-moz-transition: -moz-transform .3s ease-out;
	-o-transition: -o-transform .3s ease-out;
	transition: transform .3s ease-out
}

.placeorder.in .placeorder-dialog {
	-webkit-transform: translate(0, 0);
	-ms-transform: translate(0, 0);
	transform: translate(0, 0)
}

.placeorder-dialog {
	position: relative;
	z-index: 1050;
	width: auto;
	margin: 100px 200px 100px 400px;
}

.zindex {
	position: relative;
	z-index: 1050;
}

.placeorder-content {
	position: relative;
	width: 500px;
	background-color: #fff;
	border: 1px solid #999;
	border: 1px solid rgba(0, 0, 0, 0.2);
	border-radius: 6px;
	outline: 0;
	-webkit-box-shadow: 0 3px 9px rgba(0, 0, 0, 0.5);
	box-shadow: 0 3px 9px rgba(0, 0, 0, 0.5);
	background-clip: padding-box
}

.placeorder-backdrop {
	position: absolute;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	z-index: 1030;
	background: url(images/r10.png) repeat;
}

.placeorder-backdrop.fade {
	opacity: 0;
	filter: alpha(opacity = 0)
}

.placeorder-backdrop.in {
	opacity: .5;
	filter: alpha(opacity = 50)
}

.placeorder-header {
	min-height: 16.42857px;
	padding: 15px;
	border-bottom: 1px solid #e5e5e5
}

.placeorder-body {
	position: relative;
	padding: 20px
}

.addressDetailForm .fk-label {
	padding: 0 20px 0 10px
}

.addressDetailForm .btn.btn-large[type="submit"] {
	width: 60%
}

.addressDetailForm .fk-input {
	width: 55%;
	padding: 9px 10px;
	margin: 16px 0 4px
}

.pad {
	padding: 5px;
}




/* //Add to cart css starts */

table {
	border-collapse: collapse;
}

table,td {
	border: 1px solid #e4e4e4;
}

table {
	
}

th {
	border: 1px solid #e4e4e4;
	background-color: #f4f4f4;
	color: black;
}

.remove {
	position: relative;
	left: 355px;
	top: 26px;
	font-size:6pt;
	
}

.nav {
	display: inline-block;
	position: relative;
	cursor: default;
	z-index: 500;
}

.placeorderCart {
	color: #f9f9f9;
	height: 41px;
	width: 160px;
	font-size: 12px;
	background: #f78828;
	border: 1px solid #da7532;
}

.continueshopping {
	height: 41px;
	width: 175px;
	background: #f4f4f4;
	font-size: 12px;
	border: 1px solid #f4f4f4;
	color: black;
}

.addtocart {
	vertical-align: middle;
	cursor: pointer;
	text-shadow: 0 0 1px rgba(0, 0, 0, 0.33);
	border: 1px solid;
	border-radius: 4px;
	outline: 0;
}



.cartimg {
	width: 900px;
}

.cartTab {
	position: absolute;
	 left: 239px;
  	  top: 93px;
	border-radius: 3px 3px 0 0;
	color: #fff;
	background: #666;
	text-transform: none;
	font-size: 18px;
	border: 0;
	height: 40px;
	width: 100px;
	text-align: center;
	padding-top: 5px;
}

.link_button {
	background: white;
	border: 0px;
   font-size: 7pt;
  position: relative;
  top: -5px;
  left: 5px;
}

.count
{
border:none;

}



</style>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.2.min.js"></script>
<script src="bootstrap/js/jquery.cookie.js"></script>
<script>
	$(document).ready(function() {
		$("button3").click(function() {
			$("#dialog").fadeIn();
			$("#backdrop").fadeTo("slow", 0.5);
		});
		$("button4").click(function() {
			$("#backdrop").fadeTo("slow", 1);
			$("#dialog").fadeOut();
		});
		
		
       
	});

	function SignUpvalidate() {

		var sEmail = $('#SignUpMailId').val();
		var pass = $('#SignUpPassId').val();
		var Rpass = $('#RepeatPassId').val();
		if ($.trim(sEmail).length == 0) {
			$("#er3").empty();
			$("#er3").show();
			$("#er3").append('Please enter valid email address');
			console.log("login");
			return false;

		}

		if (validateEmail(sEmail)) {
			if (pass.length == 0 || Rpass.length == 0) {
				$("#er3").empty();
				$("#er3").show();
				$("#er3").append('Please enter Password');
				console.log("login");
				return false;

			}
			if (pass == Rpass) {
				$("#er3").empty();
				$("#er3").hide();
				//alert('Email is valid');
				return true;
			} else {
				$("#er3").empty();
				$("#er3").show();
				$("#er3").append("Passwords Don't match");
				console.log("login");
				return false;
			}
		} else {
			$("#er3").empty();
			$("#er3").show();
			$("#er3").append('Please enter valid email address');
			$('#SignUpMailId').val("");
			return false;

		}

	}

	function checkuser() {
		var msg;
		var sEmail = $('#useremail').val();

		document.getElementById("rogerlabel").innerHTML = sEmail;
		$.getJSON('PlaceOrderCheckUser', {
					mailID : sEmail
				},
						function(jsonResponse) {
							msg = jsonResponse.message;

							if (msg == ("exists")) {
								console.log("exists");

								var thisAnswer1 = document
										.getElementById("accordion1");
								var thisAnswer2 = document
										.getElementById("existinguser");
								thisAnswer2.classList.toggle('is-collapsed');
								thisAnswer1.setAttribute('class',
										'accordionItem is-collapsed');
							}

							else {
								console.log("doesnotexists");
								var thisAnswer1 = document
										.getElementById("accordion1");
								var thisAnswer2 = document
										.getElementById("newuser");
								thisAnswer2.classList.toggle('is-collapsed');
								thisAnswer1.setAttribute('class',
										'accordionItem is-collapsed');
								// document.location.href='/Flipkart/login/adminHome.jsp';
							}
						});

	}
	function signupuser() {
		var msg;

		var setpassword = $('#setpassword1').val();

		var confirmpassword = $('#confirmpassword').val();
		if (setpassword == confirmpassword) {
			$
					.getJSON(
							'PlaceOrderSignUpUser',
							{
								mailID : $('#useremail').val(),
								password : confirmpassword
							},
							function(jsonResponse) {
								msg = jsonResponse.message1;
								if (msg == ("true")) {
									
									////
									//Remove cookie
										$.cookie("CART_ITEMS_COUNT",null);
										$.removeCookie('CART_ITEMS_COUNT');
										$.cookie("CART_ITEMS",null);
										$.removeCookie('CART_ITEMS');

										$.cookie("CART_ITEMS_COUNT", "", {
											expires : 7
										});

										$.cookie("CART_ITEMS_COUNT", "0", {
											expires : 7
										});
									
									////
									document.location="/Flipkart/PlaceOrderLoginCart";
									document.getElementById("addressbox1").style.visibility = "hidden";
									document.getElementById("addressbox2").style.visibility = "hidden";
									document.getElementById("addressbox3").style.visibility = "hidden";
									var thisAnswer1 = document
											.getElementById("newuser");
									var thisAnswer2 = document
											.getElementById("accordion2");
									thisAnswer2.classList
											.toggle('is-collapsed');
									thisAnswer1.setAttribute('class',
											'accordionItem is-collapsed');
								} else {
									window.alert("lag gyi bhai");
								}
							});
		}

		else {
			window.alert("You have entered different passwords");
		}

	}

	function addNewAddress() {
		
		var msg;
		var sEmail1 = $('#useremail').val();
		
		$
				.getJSON(
						'PlaceOrderNewAddress',
						{
							CustomerName : $('#CustomerName').val(),
							PinCode : $('#PinCode').val(),
							Address : $('#Address').val(),
							LandMark : $('#LandMark').val(),
							Phone : $('#Phone').val(),
							mailID : $('#useremail').val()
						},
						function(jsonResponse) {
							

							msg = jsonResponse.message;
							if (msg == ("success")) {

								$
								.post(
										'/Flipkart/findAddress',
										{
											email : sEmail1
										},
										function(jsonResponse) {
											$
													.each(
															jsonResponse.listMap,
															function(key, value) {
																var x = key;

																
																if (key == 1) {
																	document
																			.getElementById("addressbox1").style.visibility = "visible";
																	$('#1').text(
																			value.customerName)
																			.append();
																	$('#2').text(value.address)
																			.append();
																	$('#3')
																			.text(
																					value.landMark)
																			.append();
																	$('#4')
																			.text(
																					" Pincode:"
																							+ value.pinCode)
																			.append();
																	$('#5').text(value.phone)
																			.append();

																}

																else if (key == 2) {

																	document
																			.getElementById("addressbox2").style.visibility = "visible";
																	$('#6').text(
																			value.customerName)
																			.append();
																	$('#7').text(value.address)
																			.append();
																	$('#8')
																			.text(
																					value.landMark)
																			.append();
																	$('#9')
																			.text(
																					" Pincode:"
																							+ value.pinCode)
																			.append();
																	$('#10').text(value.phone)
																			.append();

																} else {

																	document
																			.getElementById("addressbox3").style.visibility = "visible";
																	$('#11').text(
																			value.customerName)
																			.append();
																	$('#12')
																			.text(value.address)
																			.append();
																	$('#13').text(
																			value.landMark)
																			.append();
																	$('#14')
																			.text(
																					" Pincode:"
																							+ value.pinCode)
																			.append();
																	$('#15').text(value.phone)
																			.append();

																}
															});
										});
											
							} else {
								window.alert("lag gyi bhai");
							}

						});

	}

	function deleteAddress()
	{
		var temp=$('#1').val();
		window.alert(temp);
		if (confirm("Are you Sure u want to delete this address!!") == true) {
			
			var msg;
			$.getJSON('PlaceOrderDeleteAddress',
							{
							mailID : $('#useremail').val()
							},
							function(jsonResponse) {

								msg = jsonResponse.message;
								if (msg == ("success")) {
									window.alert("Address has been deleted Successfully");
								}
							});
			
			
			var sEmail1 = $('#useremail').val();
			
			$
			.post(
					'/Flipkart/findAddress',
					{
						email : sEmail1
					},
					function(jsonResponse) {
						$
								.each(
										jsonResponse.listMap,
										function(key, value) {
											
											if(key==0)
												{
												document
												.getElementById("addressbox1").style.visibility = "hidden";
												document
												.getElementById("addressbox2").style.visibility = "hidden"
												document
												.getElementById("addressbox1").style.visibility = "hidden";
												}

											
											if (key == 1) {
												document
														.getElementById("addressbox1").style.visibility = "visible";
												$('#1').text(
														value.customerName)
														.append();
												$('#2').text(value.address)
														.append();
												$('#3')
														.text(
																value.landMark)
														.append();
												$('#4')
														.text(
																" Pincode:"
																		+ value.pinCode)
														.append();
												$('#5').text(value.phone)
														.append();

											}

											else if (key == 2) {

												document
														.getElementById("addressbox2").style.visibility = "visible";
												$('#6').text(
														value.customerName)
														.append();
												$('#7').text(value.address)
														.append();
												$('#8')
														.text(
																value.landMark)
														.append();
												$('#9')
														.text(
																" Pincode:"
																		+ value.pinCode)
														.append();
												$('#10').text(value.phone)
														.append();

											} else {

												document
														.getElementById("addressbox3").style.visibility = "visible";
												$('#11').text(
														value.customerName)
														.append();
												$('#12')
														.text(value.address)
														.append();
												$('#13').text(
														value.landMark)
														.append();
												$('#14')
														.text(
																" Pincode:"
																		+ value.pinCode)
														.append();
												$('#15').text(value.phone)
														.append();

											}
										});
					});

			

	    } else {
	        x = "You pressed Cancel!";
	    }
		
	}
	
	
	
	
	function checkpassword() {

		var msg1;
		var sEmail1 = $('#useremail').val();
		var pass1 = $('#userPassword').val();

		$
				.post('/Flipkart/PlaceOrderCheckPassword', {
					mailID : sEmail1,
					password : pass1
				},
						function(jsonResponse) {
							msg1 = jsonResponse.message;
							if (msg1 == ("correctpassword")) {
								console.log("correct");
								///
								//Remove cookie
										$.cookie("CART_ITEMS_COUNT",null);
										$.removeCookie('CART_ITEMS_COUNT');
										$.cookie("CART_ITEMS",null);
										$.removeCookie('CART_ITEMS');

										$.cookie("CART_ITEMS_COUNT", "", {
											expires : 7
										});

										$.cookie("CART_ITEMS_COUNT", "0", {
											expires : 7
										});
								
								///
								document.location="/Flipkart/PlaceOrderLoginCart";
								var thisAnswer1 = document
										.getElementById("accordion2");
								var thisAnswer2 = document
										.getElementById("existinguser");
								thisAnswer1.classList.toggle('is-collapsed');
								thisAnswer2.setAttribute('class',
										'accordionItem is-collapsed');

							}

							else {
								window.alert("wrong password");
								// document.location.href='/Flipkart/login/adminHome.jsp';
							}

						});

		$
				.post(
						'/Flipkart/findAddress',
						{
							email : sEmail1
						},
						function(jsonResponse) {
							$
									.each(
											jsonResponse.listMap,
											function(key, value) {
												var x = key;

												if (key == 1) {
													document
															.getElementById("addressbox1").style.visibility = "visible";
													$('#1').text(
															value.customerName)
															.append();
													$('#2').text(value.address)
															.append();
													$('#3')
															.text(
																	value.landMark)
															.append();
													$('#4')
															.text(
																	" Pincode:"
																			+ value.pinCode)
															.append();
													$('#5').text(value.phone)
															.append();

												}

												else if (key == 2) {

													document
															.getElementById("addressbox2").style.visibility = "visible";
													$('#6').text(
															value.customerName)
															.append();
													$('#7').text(value.address)
															.append();
													$('#8')
															.text(
																	value.landMark)
															.append();
													$('#9')
															.text(
																	" Pincode:"
																			+ value.pinCode)
															.append();
													$('#10').text(value.phone)
															.append();

												} else {

													document
															.getElementById("addressbox3").style.visibility = "visible";
													$('#11').text(
															value.customerName)
															.append();
													$('#12')
															.text(value.address)
															.append();
													$('#13').text(
															value.landMark)
															.append();
													$('#14')
															.text(
																	" Pincode:"
																			+ value.pinCode)
															.append();
													$('#15').text(value.phone)
															.append();

												}
											});
						});

	}
	
	
	
	
// cart script starts here


$(document).ready(function() {
		
		$(".cartInput").click(function(event) {
			var id = event.target.id;

			document.getElementsByName(id)[0].style.visibility = "visible";
		});
		
	
		
		$(".saveButton").click(function(event) {

			
			
	if (this.id == "cart_quantity_static") {

												var id = this.name;
												
												var qty = document.getElementById(id).value;
												window.alert(qty);

												// Check if quantity is negative or >100. If it is so , fetch the old qty value from
												// hidden input box and display again.

												if (qty<0 || qty>100
														|| qty == 0) {
													alert("Sorry. Quantity cannot be '0', Negative/Greater than 100");
													var withProperty = [];
													var els = document
															.getElementsByTagName('input');// or '*' for all types of element
													var i = 0;

													for (i = 0; i < els.length; i++) {
														if (els[i]
																.hasAttribute('title')) {
															if (els[i].title == id) {
																withProperty
																		.push(els[i]);
															}

														}
													}

													document.getElementById(id).value = withProperty[0].value;

												} else
													document.location = "/Flipkart/changeCartPlaceorder.action?id="
															+ id
															+ "&quantity="
															+ qty;

											}

										});

						$(".remove2").hover(function() {

							if (this.id == "uid") {
								$(this).css("color", "blue");
							}
						});

					});
</script>


<script type="text/javascript">
  window.onload = function() {
  	
    	var k = document.getElementById("checkmail").innerHTML;
	
    	if (k=="present")
    	{
		var thisAnswer2 = document
		.getElementById("accordion2");
thisAnswer2.classList.toggle('is-collapsed');
var sEmail1 = document.getElementById("cookieMailID").innerHTML;

$('#useremail').val(sEmail1);

//  .append(sEmail1);
//  window.alert($('#SignUpMailId').val());

$
.post(
		'/Flipkart/findAddress',
		{
			email : sEmail1
		},
		function(jsonResponse) {
			$
					.each(
							jsonResponse.listMap,
							function(key, value) {
								var x = key;

								
								if (key == 1) {
									document
											.getElementById("addressbox1").style.visibility = "visible";
									$('#1').text(
											value.customerName)
											.append();
									$('#2').text(value.address)
											.append();
									$('#3')
											.text(
													value.landMark)
											.append();
									$('#4')
											.text(
													" Pincode:"
															+ value.pinCode)
											.append();
									$('#5').text(value.phone)
											.append();

								}

								else if (key == 2) {

									document
											.getElementById("addressbox2").style.visibility = "visible";
									$('#6').text(
											value.customerName)
											.append();
									$('#7').text(value.address)
											.append();
									$('#8')
											.text(
													value.landMark)
											.append();
									$('#9')
											.text(
													" Pincode:"
															+ value.pinCode)
											.append();
									$('#10').text(value.phone)
											.append();

								} else {

									document
											.getElementById("addressbox3").style.visibility = "visible";
									$('#11').text(
											value.customerName)
											.append();
									$('#12')
											.text(value.address)
											.append();
									$('#13').text(
											value.landMark)
											.append();
									$('#14')
											.text(
													" Pincode:"
															+ value.pinCode)
											.append();
									$('#15').text(value.phone)
											.append();

								}
							});
		});
	}
    	else
    		{
    		var thisAnswer1 = document
    		.getElementById("accordion1");
    thisAnswer1.classList.toggle('is-collapsed');
    		}
// 	else
// 		{
// 		window.alert("hi"+k);
// 		var thisAnswer1 = document
// 		.getElementById("accordion1");

// thisAnswer1.classList.toggle('is-collapsed');
// 		}
	
   }
</script>




</head>

<body>
	

	<div class="backcolour_placeorder">

		<div class="placeorder-dialog" style="display: none;" id="dialog">
			<div class="placeorder-content">
				<div class="placeorder-body">
					<div class="placeorder-header">
						<font size="4">Enter a new Shipping Address</font>
					</div>
					<br />
					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-2 pad">Name</div>
						<div class="required col-md-8">
							<input type="text" class="form-control" id="CustomerName">
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-2 pad">Pincode</div>
						<div class="col-md-8">
							<input type="text" class="form-control" id="PinCode">
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-2 pad">Address</div>
						<div class="col-md-8">
							<textarea class="form-control" id="Address" rows="5"></textarea>
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-2 pad">Landmark</div>
						<div class="col-md-8">
							<input type="text" class="form-control" id="LandMark">
						</div>
					</div>

					<br />

					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-2 pad">Country</div>
						<div class="col-md-8 pad">
							&nbsp;&nbsp;&nbsp;<b>India</b>(Service available only in India)
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-2 pad">Phone</div>
						<div class="col-md-8">
							<input type="text" class="form-control" id="Phone">
						</div>
					</div>
					<br />
					<center>
						<button4>
						<button class="addtocart1 continueshopping1"
							onclick="addNewAddress()">
							<font size="4"> SAVE & CONTINUE </font>
						</button>
						</button4>
						<button4>
						<button class="addtocart1 continueshopping1">
							<font size="4"> BACK </font>
						</button>
						</button4>
					</center>
					<br />
				</div>
			</div>
		</div>



		<div class="placeorder-backdrop" id="backdrop">
			<div class="flip_nav7">
			<a href="HomeAction" style="position: relative; left:100px"><img src="images/r8.png"/></a>
			</div>
			<div class="container">
				<div class="accordion">
					<dl>
						<dt>
							<a aria-expanded="false" id="papa1" aria-controls="accordion1"
								class="accordionTitle js-accordionTrigger"><font size="4">1.BEFORE
									YOU PLACE ORDER!>SIGN IN</font></a>
						</dt>
						<dd class="accordionItem is-collapsed" id="accordion1"
							aria-hidden="true">

							<div class="col-md-12"></div>

							<div class="row">

								<div class="col-md-1"></div>
								<div class="col-md-4">
									<div style="visibility: visible" id="p1">
									<div class="row" id="checkmail" style="visibility:hidden"><s:property value="checkmailincookie"/></div>
									<div class="row" id="cookieMailID" style="visibility:hidden"><s:property value="mailID"/></div>	
										
										<br> <font size="4"> What is your email Address?</font> <input
											type="email" class="form-control" id="useremail" /> <br>

										<button type="button" id="rajeev03"
											class=" btn btn-primary btn-lg" onclick="checkuser()">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CONTINUE
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>

										<br> <br> <br>
									</div>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-1">
									<span class="btn-separator"></span>
								</div>
								<div class="col-md-4">
									<img src="images/r11.png">
								</div>


							</div>
						</dd>
						<dd class="accordionItem is-collapsed" id="newuser"
							aria-hidden="true">
							<div id="setpassword" class="panel-body">
								<div class="row">
									<div class="form-group col-md-1"></div>
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Set Password</label> <input
											type="password" class="form-control" id="setpassword1"
											placeholder="Password"> <br /> <label
											for="exampleInputPassword1">Confirm Password</label> <input
											type="password" class="form-control" id="confirmpassword"
											placeholder="Password"> <br />
										<button id="signup" type="button" onclick="signupuser()"
											class="btn btn-warning">SIGN UP</button>

									</div>
									<div class="form-group col-md-1"></div>
									<div class="form-group col-md-1">
										<span class="btn-separator"></span>
									</div>
									<div class="form-group col-md-5">
										<img src="images/r11.png">
									</div>
								</div>



							</div>

						</dd>
						<dd class="accordionItem is-collapsed" id="existinguser"
							aria-hidden="true">
							<div id="setpassword" class="panel-body">


								<div class="row">

									<div class="col-md-1"></div>
									<div class="col-md-4">
										<p>
											<font size="4" color="blue" id="rogerlabel"></font>
											&nbsp;&nbsp; <span class="glyphicon glyphicon-pencil "></span><a
												class="js-accordionTrigger" id="change">Change</a>
										</p>
										<br />
										<p class="pad">
											<font size="4">Enter Password*</font>
										</p>

										<input type="password" class="form-control" id="userPassword"
											placeholder="Password"> <br />

										<button id="afterpwdset" onclick="checkpassword()"
											type="button" class="btn btn-warning" href="addCartToPlaceorder">SIGN IN</button>
									</div>
									<div class="form-group col-md-1"></div>
									<div class="form-group col-md-1">
										<span class="btn-separator"></span>
									</div>
									<div class="form-group col-md-5">
										<img src="images/r11.png">
									</div>
								</div>



							</div>

						</dd>
						<dt>
							<a href="#accordion2" aria-expanded="false"
								aria-controls="accordion2" id="papa2"
								class="accordionTitle js-accordionTrigger"> <font size="4">2.Delivery
									Address
									
									</font></a>
						</dt>
						<dd class="accordionItem is-collapsed" id="accordion2"
							aria-hidden="true">
							<div class="col-md-4" id="addressbox1" style="visibility: hidden">
								<div class="addressbox">
									<div class="row">
										<div class="col-md-8">
											<div id="1"></div>
										</div>
										<div class="col-md-1">
<!-- 											<a onclick="editAddress()"><span -->
<!-- 												class="glyphicon glyphicon-pencil"></span></a> -->
										</div>
										<div class="col-md-1">
<!-- 											<a onclick="deleteAddress()"><span -->
<!-- 												class="glyphicon glyphicon-trash"></span></a> -->
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-md-12">
											<div id="2"></div>
											<br />
											<div id="3"></div>
											<br />
											<div id="4"></div>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-md-12">
											<div id="5"></div>
											<hr>
										</div>

										<div class="row">
											<button
												class="addtocart1 continueshopping1 js-accordionTrigger"
												id="deliverhere1">
												<span id="selected1" class="glyphicon glyphicon-ok"
													style="visibility: hidden"></span>&nbsp;&nbsp;DELIVER HERE
											</button>
										</div>

									</div>
								</div>
							</div>



							<div class="col-md-4" id="addressbox2" style="visibility: hidden">
								<div class="addressbox">
									<div class="row">
										<div class="col-md-8">
											<div id="6"></div>
										</div>
										<div class="col-md-1">
<!-- 											<span class="glyphicon glyphicon-pencil"></span> -->
										</div>
										<div class="col-md-1">
<!-- 											<span class="glyphicon glyphicon-trash"></span> -->
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-md-12">
											<div id="7"></div>
											<br />
											<div id="8"></div>
											<br />
											<div id="9"></div>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-md-12">
											<div id="10"></div>
											<hr>
										</div>

										<div class="row">
											<button
												class="addtocart1 continueshopping1 js-accordionTrigger"
												id="deliverhere2">
												<span id="selected2" class="glyphicon glyphicon-ok"
													style="visibility: hidden"></span>&nbsp;&nbsp;DELIVER HERE
											</button>
										</div>

									</div>
								</div>
							</div>





							<div class="col-md-4" id="addressbox3" style="visibility: hidden">
								<div class="addressbox">
									<div class="row">
										<div class="col-md-8">
											<div id="11"></div>
										</div>
										<div class="col-md-1">
<!-- 											<span class="glyphicon glyphicon-pencil"></span> -->
										</div>
										<div class="col-md-1">
<!-- 											<span class="glyphicon glyphicon-trash"></span> -->
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-md-12">
											<div id="12"></div>
											<br />
											<div id="13"></div>
											<br />
											<div id="14"></div>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-md-12">
											<div id="15"></div>
											<hr>
										</div>

										<div class="row">
											<button
												class="addtocart1 continueshopping1 js-accordionTrigger"
												id="deliverhere3">
												<span id="selected3" class="glyphicon glyphicon-ok"
													style="visibility: hidden"></span>&nbsp;&nbsp;DELIVER HERE
											</button>
										</div>

									</div>
								</div>

							</div>




							<div align="center">
								<button3>
								<button class="addtocart1 continueshopping1">
									<font size="4">Add New Address</font>
								</button>
								</button3>
							</div>
						</dd>
						
						
<!-- 						Accordion 3 starts(Cart) -->
						
						
						<dt>
							<a  href="#accordion3" aria-expanded="false" id="papa3"
								aria-controls="accordion3"
								class="accordionTitle js-accordionTrigger"> <font size="4">3.Cart</font>
							</a>
						</dt>
						<dd class="accordionItem is-collapsed" id="accordion3"
							aria-hidden="true">
							<div class="container-fluid">
	

		<table>
			<colgroup>
				<col span="4" style="background-color: WHITE">
				<col style="background-color: white">
			</colgroup>
			<tr height="50px">
				<th width="54%"><div class="col-md-2"></div>
					<div class="col-md-10">ITEM</div></th>
				<th width="5%"><div class="col-md-2"></div>
					<div class="col-md-10">QTY</div></th>
				<th width="17%"><div class="col-md-2"></div>
					<div class="col-md-10">PRICE</div></th>
				<th width="21%"><div class="col-md-1"></div>DELIVERY DETAILS</th>
				<th width="17%"><div class="col-md-2"></div>
					<div class="col-md-10">SUBTOTAL</div></th>
			</tr>


			<%
				int Total = 0;
			%>
			<s:iterator value="resultSet" var="product">
				<%--  <%
   /*  try{
    	
		HttpRequest request = 	
    	Iterator resultIter = request.getAttribute("resultSet");
         
          while(resultIter.hasNext()){ 
          
          CartVO voObj = (CartVO)resultIter.next();
          Total=Total+ voObj.getPrice()+voObj.getDeliveryCharge(); */%> --%>
				<tr height="130px">
					<td><div class="col-md-2"></div>
						<div class="col-md-10">
							<div class="row">
								<s:property value="#product.productName" />
							</div>
							<div class="row">
								<s:property value="#product.colour" />
								,
								<s:property value="#product.size" />
							</div>

							<div class="row">
								Seller:<b><s:property value="#product.sellerName" /></b>
							</div>
							<div class="row remove">
								<a  class="remove2" href="removeCartPlaceOrder?id=<s:property value="#product.productId"/>" id="uid" name="uid">REMOVE</a>
							</div>
						</div></td>
					<td><div class="col-md-2"><input style="display:none;" type="text"  title=<s:property value = "#product.productId"/>
								value=<s:property value = "#product.quantity"/> style = "text-align:center"size="1"></div>
						<div class="col-md-10">
							<input class="cartInput" type="text" id=<s:property value = "#product.productId"/>
								value=<s:property value = "#product.quantity"/> style = "text-align:center"size="1">
							<button class="link_button saveButton" style="visibility: hidden"
								id="cart_quantity_static"
								name=<s:property value = "#product.productId"/>>
								<u>Save</u>
							</button>
						</div></td>
					<td><div class="col-md-2"></div>
						<div class="col-md-10">
							<b>Rs.<s:property value="#product.price"/></b>
							
						</div></td>
					<td><div class="col-md-1"></div> <%--  <% int flag = %> "%{#product.deliveryCharge}"<% 
       
 		if (flag==0) {%> --%> <s:if test="%{#product.deliveryCharge} == '0'">
							<div class="col-md-11">Free Delivery</div>
						</s:if> <s:else>
							<div class="col-md-11">
								Delivery Charges:Rs.
								<s:property value="#product.deliveryCharge" />
							</div>
						</s:else></td>
					<td><div class="col-md-0"></div>
						<div class="col-md-12">
							<b>Rs.<s:property value="#product.totalPrice" /></b>
						</div></td>
				</tr>

			</s:iterator>
		</table>
		
		<table width="100%" class="zindex">
			<tr height="100px">
				<th width="100%"><div class="col-md-6">
				<button class="addtocart placeorderCart js-accordionTrigger" id="topayment">CONTINUE
							</button>
				</div>
					<div class="col-md-6 ">
						<font size="5pt">Amount Payable: Rs.<s:property value="total" /></font>
					</div></th>

			</tr>
			
			
		</table>
		

		<!-- #565656 -cart ka colour -->
	
	</div>
						</dd>
						<dt>
							<a href="#accordion4" aria-expanded="false" id="papa4"
								aria-controls="accordion4"
								class="accordionTitle js-accordionTrigger"> <font size="4">4.Payment</font>
							</a>
						</dt>
						<dd class="accordionItem is-collapsed" id="accordion4"
							aria-hidden="true">
							<div id="payment" class="panel-body">

								<div class="panel panel-primary col-md-2">
									<div style="padding-top: 30px" class="panel-body">
										<div class="btn-group-vertical">
											<button type="button" class="btn btn-default col-md-2">Credit
												Card</button>
											<button type="button" class="btn btn-default col-md-2">Net
												Banking</button>
											<button type="button" class="btn btn-default col-md-2">Debit
												Card</button>
											<button type="button" class="btn btn-default col-md-2">COD</button>
										</div>
									</div>
								</div>

								<div id="paybox" class="mainbox col-md-4">
									<div class="panel panel-info" style="background: #f2f2f2">
										<div style="padding-top: 30px" class="panel-body">
											<div style="display: none" id="pay-alert"
												class="alert alert-danger col-sm-12"></div>

											<form id="payform" class="form-horizontal" name="ccard"
												action="pay">

												<div class="row">
													<div class="form-group"
														style="margin-left: 25px; margin-right: 25px">
														<input type="text" class="form-control" id="CardNumber"
															placeholder="Card Number" name="cardNumber"
															data-error="Card number cannot be blank"
															required="required">
														<div class="help-block with-errors"></div>
													</div>
												</div>

												<div class="row">
													<div style="margin-left: 25px; margin-right: 25px">
														<div class="form-group">
															<div class="col-lg-4">
																<input type="text" class="form-control" id="ExpDate"
																	name="expDate" placeholder="MM/YY"
																	data-error="Exp Date cannot be blank" required>
															</div>
															<div class="col-lg-3">
																<label>Exp Date</label>
															</div>



															<div class="col-md-5">
																<input type="text" class="form-control" id="CVV"
																	name="cvv" placeholder="CVV"
																	data-error="CVV cannot be blank" required>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div style="margin-left: 25px; margin-right: 25px">
														<div class="form-group">
															<div class="col-md-12">
																<input type="text" class="form-control" id="nameOnCard"
																	name="nameOnCard" placeholder="Name On Card"
																	data-error="Name On card cannot be blank" required>
																<div class="help-block with-errors"></div>
															</div>
														</div>
													</div>

												</div>
												<div class="row">
													<div style="margin-left: 25px; margin-right: 25px;"form-group">
														<button id="pay" type="submit"
															class="btn btn-warning col-md-12">PAY</button>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</dd>

					</dl>
				</div>
			</div>

		</div>


	</div>


	<script src="js/index.js"></script>



</body>


<style>
.btn-separator:after {
	content: ' ';
	display: block;
	float: left;
	background: #ADADAD;
	margin: 0 10px;
	height: 170px;
	width: 1px;
}
</style>
</html>