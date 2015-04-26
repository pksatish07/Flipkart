<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<%@ page import="org.iiitb.flipkart.cart.*"%>
<%@ page import="org.iiitb.flipkart.login.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>




<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="bootstrap/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

<link rel="stylesheet" href="styles.css">


<link rel="shortcut icon" href="image/favicon.ico">
<title>Online Shopping -Shop Online for Mobile Phones, Digital
	Cameras, Watches, Books & More at Flipkart.com</title>


<link href="/Flipkart/bootstrap/css/jquery-ui.css" rel="stylesheet">
<script type="text/javascript" src="/Flipkart/bootstrap/js/jquery-ui.js"></script>



<style>
.example1 {
	background: url(images/r1.png) no-repeat;
	padding: 15px;
	background-size: auto;
}

.flip_nav {
	background: /* url(images/r4.png) 100px top no-repeat, */
		url(images/r1.png) left top repeat;
	padding: 1px;
	background-size: contain, auto;
}

.flip_nav2 {
	background: url(images/r5.png) left top repeat;
	padding: 15px;
	background-size: auto;
}

.ul2 {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: visible;
}

.li2 {
	float: left;
	position: relative;
	left: 500px;
}

.a2 {
	display: block;
	padding: 5px;
	width: auto;
	color: #FFFFFF;
	overflow: visible;
}

.box {
	width: 300px;
	height: 50px;
}

.container-1 {
	width: 300px;
	vertical-align: middle;
	white-space: nowrap;
	position: relative;
}

.search {
	position: relative;
	left: 500px;
	width: 500px;
	height: 40px;
	border: none;
	font-size: 10pt;
	float: left;
	color: #63717f;
	padding-left: 45px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
}

.button {
	position: relative;
	left: 500px;
	width: 100px;
	height: 40px;
	border: none;
	font-size: 10pt;
	color: #63717f;
	font-weight: bold;
	background: #FFD700;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
}

.button2 {
	position: relative;
	left: 500px;
	width: 100px;
	height: 40px;
	border: none;
	font-size: 10pt;
	color: #ffffff;
	background: url(images/r3.png) left top repeat;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
}

.container-1 input#search::-webkit-input-placeholder {
	color: #65737e;
}

.container-1 input#search:-moz-placeholder { /* Firefox 18- */
	color: #65737e;
}

.container-1 input#search::-moz-placeholder { /* Firefox 19+ */
	color: #65737e;
}

.container-1 input#search:-ms-input-placeholder {
	color: #65737e;
}

.placeholder {
	left: 525px;
	position: absolute;
	margin-left: 13px;
	margin-top: 13px;
	z-index: 1;
	color: #4F5B66;
}

.container-1 .icon {
	position: relative;
	left: 500px;
	position: absolute;
	margin-left: 13px;
	margin-top: 13px;
	z-index: 1;
	color: #4f5b66;
}

a:hover {
	color: white;
}

.gantagly {
	color: yellow;
}

.container-1 .icon2 {
	left: 1100px;
	position: absolute;
	margin-left: 5px;
	margin-top: 5px;
	z-index: 1;
	color: #4f5b66;
}

.container-1 input#search:hover,.container-1 input#search:focus,.container-1 input#search:active
	{
	outline: none;
	background: #ffffff;
}

.padding {
	font-size: 10pt;
	vertical-align: text-bottom;
}

.testgly {
	font-size: 18px;
}

.modalDialog {
	position: fixed;
	font-family: Arial, Helvetica, sans-serif;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	background: rgba(0, 0, 0, 0.8);
	z-index: 99999;
	opacity: 0;
	-webkit-transition: opacity 400ms ease-in;
	-moz-transition: opacity 400ms ease-in;
	transition: opacity 400ms ease-in;
	pointer-events: none;
}

.modalDialog:target {
	opacity: 1;
	pointer-events: auto;
}

.modalDialog>.testModal {
	width: 600px;
	position: relative;
	margin: 10% auto;
	padding: 0px;
	border-radius: 1px;
	border: 8px solid;
	border-color: gray;
	background: white;
	margin-top: 0px;
	top: 100px;
}

.modalfooter {
	border-top: @gray-lighter solid 1px;
	text-align: right;
}

.modalheader {
	border-bottom: @gray-lighter solid 1px;
}

.ui-widget-content {
	z-index: 9999;
}
</style>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.2.min.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="bootstrap/js/jquery.cookie.js"></script>
<script>
	$(document).ready(function() {
		$("a").mouseover(function() {
			$(this).css('color', 'white');
		});
	});
	//script for login

	$(document).ready(function() {
		$(function() {
			$("#search").autocomplete({
				source : function(request, response) {

					$.ajax({
						url : "searchAction",
						type : "POST",
						data : {
							term : request.term
						},
						dataType : "json",
						success : function(jsonResponse) {
							response(jsonResponse.list);
						}
					});
				}
			});
		});
	});

	$(function() {

		$('#loginheaderClose,#loginFooterClose,#ForgotPasswordId').hover(
				function() {
					$('#loginheaderClose,#loginFooterClose,#ForgotPasswordId')
							.css("color", "darkgray");
				});
		$('#SignupFromLogin,#loginFromSignUp').hover(function() {
			$('#SignupFromLogin,#loginFromSignUp').css("color", "blue");
		});
		$('.hovering').hover(function() {
			$('.hovering').css("color", "black");
		});
		
		$('#loginclick').click(function() {
			$(".errorMessage").hide();
			$(".textclass").val("");
			$("#SuccessForgotPassword").empty();
			$("#SuccessForgotPassword").hide();
			$("#forgotpwdtab").slideUp();

		});
		$('#signupclick').click(function() {
			$(".errorMessage").hide();
			$(".textclass").val("");

		});

		$('#loginSubmit').click(function() {
			login();
		});
		

		$("#ForgotPasswordId").click(function() {
			$(".errorMessage").hide();
			$("#SuccessForgotPassword").empty();
			$("#SuccessForgotPassword").hide();
			$("#forgotpwdtab").toggle(500);
		});

	});

	function validateEmail(Email) {

		var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		if (filter.test(Email)) {
			console.log('Validated');
			return true;
		} else {
			console.log(' not Validated');
			return false;
		}

	}

	function SignUpvalidate() {

		var sEmail = $('#SignUpMailId').val();
		var pass = $('#SignUpPassId').val();
		var Rpass = $('#RepeatPassId').val();
		if ($.trim(sEmail).length == 0) {
			$("#er3").empty();
			$("#er3").show();
			$("#er3").append('Please enter valid email address');
			console.log("login");
			event.preventDefault();

		}

		if (validateEmail(sEmail)) {
			if (pass.length == 0 || Rpass.length == 0) {
				$("#er3").empty();
				$("#er3").show();
				$("#er3").append('Please enter Password');
				console.log("login");
				event.preventDefault();

			}
			if (pass == Rpass) {
				$("#er3").empty();
				$("#er3").hide();
				//alert('Email is valid');

				$.post('/Flipkart/SignUp', {
					SignupId : sEmail,
					SignUpPassId : pass
				}, function(jsonResponse) {

					console.log("Successhome");
					//document.location.href='home.jsp'
					//alert("test");
					//Remove cookie
					$.cookie("CART_ITEMS_COUNT", null);
					$.removeCookie('CART_ITEMS_COUNT');
					$.cookie("CART_ITEMS", null);
					$.removeCookie('CART_ITEMS');

					$.cookie("CART_ITEMS_COUNT", "", {
						expires : 7
					});

					$.cookie("CART_ITEMS_COUNT", "0", {
						expires : 7
					});
					//alert("test1");

					document.location = '/Flipkart/HomeAction';
				}).done(function() {

					console.log("Success");

				}).fail(function() {
					console.log("failure");
					$("#er3").empty();
					$("#er3").show();
					$("#er3").append("MailId already registered");
				}).always(function() {
					console.log("End");
				});

			} else {
				$("#er3").empty();
				$("#er3").show();
				$("#er3").append("Passwords Don't match");
				console.log("login");
				event.preventDefault();

			}
		} else {
			$("#er3").empty();
			$("#er3").show();
			$("#er3").append('Please enter valid email address');
			$('#SignUpMailId').val("");
			event.preventDefault();

		}

	}

	function ForgotPwdvalidate() {

		var sEmail = $('#ForgotpwdMailId').val();
		if ($.trim(sEmail).length == 0) {
			$("#er2").empty();
			$("#er2").show();
			$("#er2").append('Please enter valid email address');
			console.log("login");
			event.preventDefault();

		}

		if (validateEmail(sEmail)) {

			$("#er2").empty();
			$("#er2").hide();
			//alert('Email is valid');
			//added
			{

				$.post('/Flipkart/ForgotPassword', {
					ForgotMailId : sEmail
				}, function(jsonResponse) {

					console.log("Successhome");
					if(jsonResponse.successFlag=="T"){
						$("#SuccessForgotPassword").empty();
						$("#SuccessForgotPassword").show();
						$("#SuccessForgotPassword").append(jsonResponse.message);
						}
					else{
						$("#er2").empty();
						$("#er2").show();
						$("#er2").append(jsonResponse.message);
					}
					

				}).done(function() {

					console.log("Success");

				}).fail(function() {
					console.log("failure");
					$("#er2").empty();
					$("#er2").show();
					$("#er2").append("Server Error");
				}).always(function() {
					console.log("End");
				});

			}
			//addend

			return true;
		} else {
			$("#er2").empty();
			$("#er2").show();
			$("#er2").append('Please enter valid email address');
			$('#ForgotpwdMailId').val("");
			event.preventDefault();

		}

	}

	function login() {

		var sEmail = $('#loginMailId').val();
		var pass = $('#LoginPassId').val();

		if ($.trim(sEmail).length == 0) {
			$("#er1").empty();
			$("#er1").show();
			$("#er1").append('Please enter valid email address');
			console.log("login");
			event.preventDefault();
		}

		if (validateEmail(sEmail)) {
			if (pass.length == 0) {
				$("#er1").empty();
				$("#er1").show();
				$("#er1").append('Please enter Password');
				console.log("login");
				event.preventDefault();

			} else {

				$("#er1").empty();
				$("#er1").hide();
				var msg;
				var flag;
				$
						.post(
								'/Flipkart/LoginAction',
								{
									mailID : sEmail,
									password : pass
								},
								function(jsonResponse) {
									msg = jsonResponse.message;
									flag = jsonResponse.flag;
									if (msg == ("home")) {
										console.log("Successhome");
										//document.location.href='home.jsp'

										//Remove cookie
										$.cookie("CART_ITEMS_COUNT", null);
										$.removeCookie('CART_ITEMS_COUNT');
										$.cookie("CART_ITEMS", null);
										$.removeCookie('CART_ITEMS');

										$.cookie("CART_ITEMS_COUNT", "", {
											expires : 7
										});

										$.cookie("CART_ITEMS_COUNT", "0", {
											expires : 7
										});
<%System.out.println("test");%>
	document.location = '/Flipkart/HomeAction';
									}

									else if (msg == ("admin")) {
										console.log("Success");
										document.location.href = '/Flipkart/adminhome.jsp';

										/* eg: in jsp give /Flipkart/login/adminHome.jsp but in struts give path as /login/adminHome.jsp*/

										// document.location='HomeAction';
									}

									else if (msg == ("error")) {
										$("#er1").empty();
										$("#er1").show();
										$("#er1")
												.append(
														"MailId not registered or Password not valid");
										//alert(msg);
									}/* var select = $('#states');
																																																																													select.find('option').remove();
																																																																													$.each(jsonResponse.stateMap, function(key, value) {
																																																																																	$('<option>').val(key).text(value).appendTo(select);

																																																																																	}); */
								}).done(function() {

							console.log("Success");

						}).fail(function() {
							console.log("failure");
							$("#er1").empty();
							$("#er1").show();
							$("#er1").append("Server Error");
						}).always(function() {
							console.log("End");
						});

			}
		} else {
			$("#er1").empty();
			$("#er1").show();
			$("#er1").append('Please enter valid email address');
			$('#loginMailId').val("");
			event.preventDefault();

		}

	}
	//script for login ends
</script>

<link rel="stylesheet" href="/Flipkart/loginCss/login.css">
</head>
<body>

	<%
		String cartCount=String.valueOf(0);
	%>
	<s:if test="#session.mailID==null">


		<%
			boolean countFlag = false;
				boolean itemsFlag =false;
				Cookie cookie[] = request.getCookies();
				for (Cookie temp : cookie) {
			if (temp.getName().equalsIgnoreCase("CART_ITEMS_COUNT")) {
				cartCount = temp.getValue().toString();
				countFlag = true;
			}
			if (temp.getName().equalsIgnoreCase("CART_ITEMS")) {
				itemsFlag = true;
			}

				}
				
				if(!countFlag)
				{
			Cookie cookieReset = new Cookie("CART_ITEMS_COUNT", String.valueOf(0));
			cookieReset.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookieReset);

			
				}
				if(!itemsFlag)
				{

			Cookie cookieResetItems = new Cookie("CART_ITEMS", "");
			cookieResetItems.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookieResetItems); 
				}
		%>
	</s:if>

	<s:else>
		<%
			String lg_id = String.valueOf(((User)session.getAttribute("User")).getLoginId());
			//String lg_id = "1";
			
			CartDAO fetchCart = new CartDAOImpl();
			cartCount = String.valueOf(fetchCart.fetchCartCount(lg_id));
		%>

	</s:else>


	<div class="flip_nav" style="height: 90px;">
		<a href="HomeAction"><img src="images/r4.png"
			style="position: relative; top: 10px; left: 190px;" /></a>
		<div class="row">
			<div class="colcustom" style="position: relative; bottom: 60px;">

				<div class="colcustom3">
					<ul class="ul2">
						<li class="li2"><a class="a2" href="account.jsp">CheckBalance</a></li>
						<li class="li2"><a class="a2">|</a></li>
						<li class="li2"><a class="a2" href="#news">Download App</a></li>
						<li class="li2"><a class="a2">|</a></li>
						<li class="li2"><a class="a2" href="#contact">Sell</a></li>
						<li class="li2"><a class="a2">|</a></li>
						<li class="li2"><a class="a2" href="#about">24x7 Customer
								Care</a></li>
						<li class="li2"><a class="a2">|</a></li>
						<li class="li2"><a class="a2" href="#about"><span
								class="icon2"><i class="glyphicon glyphicon-map-marker"></i>
							</span></a></li>
						<li class="li2"><a class="a2" href="#about">Track Order</a></li>
						<li class="li2"><a class="a2">|</a></li>
						<li class="li2"><a class="a2" href="#about"><span
								class="icon2"><i
									class="glyphicon glyphicon-bell gantagly"></i> </span></a></li>
						<li class="li2"><a class="a2">|</a></li>

					</ul>
				</div>
				<div class="colcustom2">
					<s:if test="#session.mailID==null">

						<ul class="ul2">
							<li class="li2"><a class="a2" id="signupclick"
								href="#openSignUpModal"> Sign Up</a></li>
							<li class="li2"><a class="a2">|</a></li>
							<li class="li2"><a class="a2" id="loginclick"
								href="#openloginModal"> Login</a></li>

						</ul>
					</s:if>
					<s:else>
						<ul class="ul2">
							<li class="dropdown li2"><a href="#" data-toggle="dropdown"
								class="dropdown-toggle a2"><s:property
										value="#session.mailID" /> <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="personal" class="hovering">About</a></li>
									<li><a href="myorders" class="hovering">Orders</a></li>
									<li><a href="#" class="hovering">Notifications</a></li>
									<li><a href="logoutAction" class="hovering">Logout</a></li>
								</ul></li>
						</ul>
					</s:else>
				</div>
			</div>
		</div>
		<form name="termDDL">
			<div class="box"
				style="position: relative; bottom: 55px; right: 100px;">
				<div class="container-1 ">
					<span class="icon" id="testing1"><i
						class="glyphicon glyphicon-search"></i></span>
					<%-- <span class="placeholder" id="testing2"> Search for a product,category or brand</span> --%>
					<!-- 	<input type="search" class="search"
					placeholder="Search for a product,category or brand" /> -->
					<%-- <div id="testing">
      <sx:autocompleter name="product" list="products" showDownArrow="false" cssClass="search" autoComplete="false" dropdownHeight="800"/>

     
     
     </div> --%>

					<input type="text" onselect="onTermChange()" id="search"
						name="product" class="search"
						placeholder="Search For Product,Category or Brand " />

				</div>
				<div class="container-1 ">
					<input type="button" class="button" value="SEARCH"
						onclick="onTermChange()">

					<!--   <span class="icon2"><i class="fa fa-shopping-cart fa-2x"></i> </span>
  <input type="button" class="button2" value="CART" color="#FFFFF">-->
					<a href="addCart" class="btn btn-primary button2"> <span
						class="glyphicon glyphicon-shopping-cart testgly"></span> <span
						class=padding>CART</span> <span style="vertical-align: middle">
							<svg width="20" height="20"> <g> <circle cx="9" cy="11"
								r="9" fill="white"></circle> <text x="5" y="14"
								font-family="Verdana" font-size="8" font-align="left"
								fill="blue" id="count"> <%=cartCount%> </text> </g> </svg>
					</span>
					</a>
				</div>


			</div>
		</form>
	</div>
	<!-- login modal part starts from here -->


	<div id="openloginModal" class="modalDialog">
		<div class="testModal" style="top: 50px;">
			<div class="modalheader">

				<div align="right" style="height: 20px">
					<a type="button" id="loginheaderClose" href="#close"
						style="color: darkgray; text-decoration: none; font-size: x-large; height: 20px;">&times;</a>
				</div>
				<div class="row">
					<div class="col-md-1">
						<div class="col-md-1 col-md-offset-1" style="font-size: large;">
							<b> Login</b>
							<!--CHANGED TO "#close"-->
						</div>
					</div>
				</div>

			</div>
			<div class="row" style="padding-bottom: 15px;">
				<!-- added -->
				<div class="container" style="width: 650px;">
					<div class="col-md-6">
						<div class="row">
							<div class="col-sm-6">
								<div class="errorMessage"
									style="position: relative; left: 50px;" id="er1"></div>
								<br>
							</div>


						</div>

						<div class="row">
							<div class="col-sm-1"></div>
							<div class="colCustom">Email</div>
							<div class="col-sm-2"></div>
							<div class="col-sm-6">
								<input type="text" class="textclass" id="loginMailId"
									name="loginMailId" style="position: relative; left: 30px;">

							</div>
						</div>
						<div class="row">

							<div class="col-sm-1"></div>
							<div class="colCustom">Password</div>
							<div class="col-sm-2"></div>
							<div class="col-sm-6">
								<input type="password" class="textclass" id="LoginPassId"
									name="PassId" style="position: relative; left: 30px;">
							</div>
						</div>
						<div class="col-sm-3">

							<div class="row">
								<br>
							</div>

							<div class="col-sm-1">
								<button class="btn btn-primary btn-sm" value="LOGIN"
									id="loginSubmit" name="loginsubmit"
									style="position: relative; left: 52px;">LOGIN</button>

							</div>

						</div>


						<br>
						<div class="row">
							<div class="col-sm-1"></div>
							<div class="col-sm-7">
								<div class="col-sm-1"></div>
								<a id="ForgotPasswordId">Forgot Your Password?</a>
							</div>
						</div>
						<br>
						<div class="row">

							<div class="col-sm-7" style="position: relative; left: 75px;">
								Dont Have an account?
								<div class="col-sm-1"></div>
								<a href="#openSignUpModal" id="SignupFromLogin"
									style="color: blue;">create one</a>
							</div>
						</div>

						<div class="row" style="display: none;" id="forgotpwdtab">



							<div class="row">
								<b style="position: relative; left: 50px;">Forgot your
									Password?</b>
							</div>

							<div class="row" id="ForgotPasswordId1"
								style="position: relative; left: 50px;">Enter your Email
								Address here to receive a link to change password.</div>

							<br>
							<div class="row">
								<div class="col-sm-6">
									<div class="errorMessage"
										style="position: relative; left: 50px;" id="er2"></div>
									<br>
								</div>


							</div>
							<div class="row">
								<div class="col-sm-1">
									<div class="col-sm-6 " style="position: relative; left: 10px;">Email</div>
								</div>
								<div class="col-sm-2"></div>
								<div class="col-sm-6">
									<input type="text" class="textclass" id="ForgotpwdMailId"
										name="ForgotpwdMailId">

								</div>
							</div>
							<div class="row">
								<div class="row">
									<br>
								</div>
								<div class="col-sm-2"></div>
								<div class="col-sm-1">
									<input type="submit" class="btn btn-primary btn-sm"
										onclick="ForgotPwdvalidate()" value="SEND MAIL" id="SendMail"
										style="position: relative; left: 30px;" />
								</div>

							</div>
							<div class="row">
								<div class="col-sm-6">
									<div
										style="display:none; position: relative; left: 50px;color:green; border: 1px solid green; top: 10px; width: 350px; height: 50px; background-color: lightgreen;"
										id="SuccessForgotPassword"></div>
									<br>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="col-sm-1">
							<img alt="none" src="/Flipkart/image/or.PNG">
						</div>
						<br>

						<div class="col-sm-3"></div>
						<div class="col-sm-4">
							<div class="row">
								<h5>
									<b>Sign in with</b>
								</h5>

							</div>
							<div class="row">
								<a href="facebooklogin.jsp" id="facebook"><img
									src="/Flipkart/image/fb.PNG" alt="Logo"></a>
							</div>
							<div class="row">
								<br>
							</div>
							<div class="row"></div>
							<div class="row">
								<a href="google.jsp" id="google"><img
									src="/Flipkart/image/google.PNG" alt="Logo"></a>
							</div>
						</div>
					</div>

				</div>
			</div>
			<div class="modalfooter"
				style="background-color: lightgray; height: 25px">
				<a href="#close" id="loginFooterClose" class="btn"
					style="color: darkgray; text-decoration: none; font-size: small;">close
					X</a>
				<!--CHANGED TO "#close"-->
			</div>
		</div>
	</div>


	<!--  ends-->


	<!-- signup modal -->
	<div id="openSignUpModal" class="modalDialog">
		<div class="testModal">
			<div class="modalheader">

				<div align="right" style="height: 20px">
					<a type="button" id="loginheaderClose" href="#close"
						style="color: darkgray; text-decoration: none; font-size: x-large; height: 20px;">&times;</a>
				</div>
				<div class="row">
					<div class="col-md-1">
						<div class="col-md-1 col-md-offset-1" style="font-size: large;">
							<b>SignUp</b>
							<!--CHANGED TO "#close"-->
						</div>
					</div>
				</div>

			</div>
			<div class="row" style="padding-bottom: 15px;">
				<!-- added -->
				<div class="container" style="width: 650px;">






					<div class="col-md-6">


						<div class="row">
							<div class="col-sm-6">
								<div class="errorMessage" id="er3"
									style="position: relative; left: 40px;"></div>
								<br>
							</div>


						</div>
						<!-- <form action="SignUp" onsubmit="return SignUpvalidate()"
							method="post"> -->
						<div class="row">
							<div class="colCustom">Email</div>
							<div class="col-sm-3"></div>
							<div class="col-sm-6">
								<input type="text" class="textclass" id="SignUpMailId"
									name="SignupId">

							</div>
						</div>
						<div class="row">

							<div class="colCustom">Password</div>
							<div class="col-sm-3"></div>
							<div class="col-sm-6">
								<input type="password" class="textclass" id="SignUpPassId"
									name="SignUpPassId">
							</div>
						</div>
						<div class="row">

							<div class="colCustom">Repeat</div>
							<div class="col-sm-3"></div>
							<div class="col-sm-6">
								<input type="password" class="textclass" id="RepeatPassId"
									name="RepeatPassId">
							</div>
						</div>

						<div class="row">
							<div class="row">
								<br>
							</div>
							<div class="col-sm-2"></div>
							<div class="col-sm-1">
								<input type="submit" class="btn btn-success btn-sm"
									value="SIGN UP NOW!" id="signUpNow"
									style="position: relative; left: 26px;"
									onclick="SignUpvalidate()">
							</div>
							<div class="col-sm-1"></div>
							<div class="col-sm-7"></div>
						</div>
						<!-- 	</form> -->
						<div class="row">

							<div class="col-sm-7"
								style="position: relative; left: 75px; font-size: small;">
								Already have an account?
								<div class="col-sm-1"></div>
								<a href="#openloginModal" id="loginFromSignUp"
									style="color: blue; position: relative; left: 25px;">Login</a>
							</div>
						</div>


					</div>
					<div class="col-sm-6">
						<div class="col-sm-1">
							<img alt="none" src="/Flipkart/image/or.PNG">
						</div>
						<br>

						<div class="col-sm-3"></div>
						<div class="col-sm-4">
							<div class="row">
								<h5>
									<b>Sign in with</b>
								</h5>

							</div>
							<div class="row">
								<a href="facebooklogin.jsp" id="facebook"><img
									src="/Flipkart/image/fb.PNG" alt="Logo"></a>
							</div>
							<div class="row">
								<br>
							</div>
							<div class="row"></div>
							<div class="row">
								<a href="google.jsp" id="google"><img
									src="/Flipkart/image/google.PNG" alt="Logo"></a>
							</div>
						</div>
					</div>





				</div>
			</div>
			<div class="modalfooter"
				style="background-color: lightgray; height: 25px">
				<a href="#close" id="loginFooterClose" class="btn"
					style="color: darkgray; text-decoration: none; font-size: small;">close
					X</a>
				<!--CHANGED TO "#close"-->
			</div>




			<!--  ends-->
		</div>
	</div>



	<!-- login modal part starts from here -->
	<!-- <div class="container">

		<div class="modal fade" id="basicModal" role="dialog"
			aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div id="tabs-1">
							<div class="container" id="container">
								<div class="col-sm-6">
									<ul>
										<li><a href="#tabs-2" id="loginStyle">login</a></li>
										<li><a href="#tabs-3" id="SignupStyle">signup</a></li>
									</ul>

									<div id="tabs-2">
										<br>
										<div class="row">
											<div class="col-sm-6">
												<div class="errorMessage" id="er1"></div>
												<br>
											</div>


										</div>

										<div class="row">
											<div class="colCustom">Email</div>
											<div class="col-sm-2"></div>
											<div class="col-sm-6">
												<input type="text" class="textclass" id="loginMailId"
													name="loginMailId">

											</div>
										</div>
										<div class="row">
											<div class="row">
												<br>
											</div>
											<div class="colCustom">Password</div>
											<div class="col-sm-2"></div>
											<div class="col-sm-6">
												<input type="password" class="textclass" id="LoginPassId"
													name="PassId">
											</div>
										</div>
										<div class="col-sm-3">
											<div class="row">
												<div class="row">
													<br>
												</div>
												<div class="col-sm-2"></div>
												<div class="col-sm-1">
													<button class="btn btn-primary btn-sm" value="LOGIN"
														id="loginSubmit" name="loginsubmit">LOGIN</button>

												</div>
											</div>
										</div>

										<div class="col-sm-9">
											<br>
											<div class="row">
												<div class="col-sm-1"></div>
												<div class="col-sm-7">
													<div class="col-sm-1"></div>
													<a href="#" id="ForgotPasswordId">Forgot Your Password?</a>
												</div>
											</div>
										</div>

										<div class="row" style="display: none;" id="forgotpwdtab">
											<br> <br> <br>

											<form action="" method="post"
												onsubmit="return ForgotPwdvalidate()">
												<div class="row">
													<b>Forgot your Password?</b>
												</div>

												<div class="row" id="ForgotPasswordId1">Enter your
													Email Address here to receive a link to change password.</div>

												<br>
												<div class="row">
													<div class="col-sm-6">
														<div class="errorMessage" id="er2"></div>
														<br>
													</div>


												</div>
												<div class="row">
													<div class="colCustom">Email</div>
													<div class="col-sm-2"></div>
													<div class="col-sm-6">
														<input type="text" class="textclass" id="ForgotpwdMailId"
															name="ForgotpwdMailId">

													</div>
												</div>
												<div class="row">
													<div class="row">
														<br>
													</div>
													<div class="col-sm-2"></div>
													<div class="col-sm-1">
														<input type="submit" class="btn btn-primary btn-sm"
															onclick="ForgotPwdvalidate()" value="SEND MAIL"
															id="SendMail" />
													</div>

												</div>
											</form>
										</div>

									</div>


									<div id="tabs-3">
										<br>
										<form action="" method="post"
											onsubmit="return SignUpvalidate()">
											<div class="row">
												<div class="col-sm-6">
													<div class="errorMessage" id="er3"></div>
													<br>
												</div>


											</div>
											<div class="row">
												<div class="colCustom">Email</div>
												<div class="col-sm-2"></div>
												<div class="col-sm-6">
													<input type="text" class="textclass" id="SignUpMailId"
														name="SignupId">

												</div>
											</div>
											<div class="row">
												<div class="row">
													<br>
												</div>
												<div class="colCustom">Password</div>
												<div class="col-sm-2"></div>
												<div class="col-sm-6">
													<input type="password" class="textclass" id="SignUpPassId"
														name="SignUpPassId">
												</div>
											</div>
											<div class="row">
												<div class="row">
													<br>
												</div>
												<div class="colCustom">Repeat</div>
												<div class="col-sm-2"></div>
												<div class="col-sm-6">
													<input type="password" class="textclass" id="RepeatPassId"
														name="RepeatPassId">
												</div>
											</div>

											<div class="row">
												<div class="row">
													<br>
												</div>
												<div class="col-sm-2"></div>
												<div class="col-sm-1">
													<input type="submit" class="btn btn-success btn-sm"
														onclick="SignUpvalidate()" value="SIGN UP NOW!"
														id="signUpNow">
												</div>
												<div class="col-sm-1"></div>
												<div class="col-sm-7"></div>
											</div>
										</form>
									</div>


								</div>


								<div class="col-sm-1">
									<img alt="none" src="/Flipkart/image/or.PNG">
								</div>
								<br>

								<div class="col-sm-1"></div>
								<div class="col-sm-2">
									<div class="row">
										<h5>
											<b>Sign in with</b>
										</h5>

									</div>
									<div class="row">
										<a href="facebooklogin.jsp" id="facebook"><img
											src="/Flipkart/image/fb.PNG" alt="Logo"></a>
									</div>
									<div class="row">
										<br>
									</div>
									<div class="row"></div>
									<div class="row">
										<a href="google.jsp" id="google"><img
											src="/Flipkart/image/google.PNG" alt="Logo"></a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							<h5>close&times;</h5>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div> -->


	<%-- 	<script type="text/javascript">
		/* function onTermChange() {
			//document.getElementById("courseDisplayChoice").selectedIndex = 0;
			document.termDDL.action = 'displayProduct.action';
			document.termDDL.submit();
		}
		
		
			
		function onClick() {
			//document.getElementById("courseDisplayChoice").selectedIndex = 0;
			window.alert("TEST");
			var text = dojo.widget.byId("searchret");
			text.setValue("test");
			
		} */
		
		function getValues() {
		     var autoCompleter = dojo.widget.byId("auto");
		      
		     //key (in the states example above, "AL")
		     var key = autoCompleter.getSelectedKey();
		     alert(key);
		      
		     //value (in the states example above, "Alabama")
		     var value = autoCompleter.getSelectedValue();
		     alert(value);
		      
		     //text currently on the textbox (anything the user typed)
		     var text = autoCompleter.getText();
		     alert(text);
		  }
		 
		  function setValues() {
		     var autoCompleter = dojo.widget.byId("auto");
		      
		     //key (key will be set to "AL" and value to "Alabama")
		     autoCompleter.setSelectedKey("AL");
		      
		     //value (key will be set to "AL" and value to "Alabama")
		     autoCompleter.setAllValues("AL", "Alabama");
		  }
		
		</script>
	 --%>

	<script type="text/javascript">
		function onTermChange() {
			//document.getElementById("courseDisplayChoice").selectedIndex = 0;
			document.termDDL.action = 'displayProduct.action';
			document.termDDL.submit();
		}
	</script>

</body>
</html>