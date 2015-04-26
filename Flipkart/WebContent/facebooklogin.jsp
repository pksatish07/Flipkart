<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="image/faviconfb.ico">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login to Facebook | Facebook</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.2.min.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="bootstrap/js/jquery.cookie.js"></script>
<link rel="stylesheet" href="loginCss/login.css">
<script type="text/javascript"> 
$(function(){
	
	$("#submit").click(function(){
		login();
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
function login() {

	var sEmail = $('#emailId').val();
	var pass = $('#password').val();

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
</script>
</head>

<body style="position: relative; bottom: 10px;">
	<div style="background-color: rgb(58, 87, 149);">
		<img alt="none" src="image/fbLogo.PNG"
			style="position: relative; left: 150px">
	</div>
	<div class="container">
		<div
			style="border: 1px solid lightgray; height: 350px; width: 900px; top: 80px; position: relative; left: 120px; border-radius: 10px;">

			<div class="col-sm-4"></div>
			<div class="col-sm-8">
				<h3>
					<b
						style="position: relative; right: 250px; border-bottom: 1px solid lightgrey;">Facebook
						Login</b>
				</h3>
				<br> <br>
				<div class="row">
								<div class="errorMessage"
									style="position: relative; left: 50px;" id="er1"></div>
								<br>
								
							</div>
				<div class="row">
					<div class="col-sm-2">
						<b>Email id: </b>
					</div>
					<input type="text" name="emailId" id="emailId"
						style="width: 200px;" />
				</div>
				<br>
				<div class="row">
					<div class="col-sm-2">
						<b>password:</b>
					</div>
					<input type="password" name="password" id="password"
						style="width: 200px;" />
				</div>
				<br>
				<div class="row">
					<div class="col-sm-2"></div>
					<input type="button" name="submit" id="submit" style="width: 60px;"
						value="login"
						style="width: 60px; background-color: #3A5795;color: #FFF;border: 0px;height: 25px;" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>