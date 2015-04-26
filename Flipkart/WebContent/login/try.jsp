<!DOCTYPE html>
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>


<link href="css/jquery-ui.css" rel="stylesheet">


<script type="text/javascript" src="js/jquery.js">
	
</script>

<script type="text/javascript" src="js/jquery-ui.js"></script>

<link rel="stylesheet" href="css/bootstrap.css">

<script src="js/bootstrap.js"></script>
<script>

	
		function my(){
		$("#forgotpwdtab").slideUp();
		}
	
	
</script>




</head>
<body>

	<div class="row" id="forgotpwdtab">


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
					value="SEND MAIL" onclick="my()" />
			</div>

		</div>


	</div>

</body>
</html>
