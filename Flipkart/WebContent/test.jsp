<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="bootstrap/css/simple-sidebar.css">


<title>Admin Home</title>
<style>
#mainCarousel>a>img{
width:100%;
}
#groupButton{
background-color:black;
border:0;
}

</style>
</head>

<body>

	<br>
	<br>

	<div id="mainCarousel" class="col-md-8 col-md-offset-1">
	
		<a href="#"><img src="carousel/car1.jpg" class="img-responsive" id = "mainimage" style = "box-shadow: 0px 0px 4px #888888;"></a>
		<div id="menuButtons" class="btn-group btn-group-justified"
			role="group" aria-label="...">
			<div class="btn-group">
				<button type="button" class = "btn" id = "groupButton"><p style = "font-size-adjust:0.4"
				>Canvas Nitro<br> At Amazing Price</p></button>
			</div>
			<div class="btn-group">
				<button type="button" class="btn btn-primary ">Apple
					and Samsung</button>
			</div>
			<div class="btn-group">
				<button type="button" class="btn btn-primary ">Apple
					and Samsung</button>
			</div>
			<div class="btn-group">
				<button type="button" class="btn btn-primary ">Apple
					and Samsung</button>
			</div>
			<div class="btn-group">
				<button type="button" class="btn btn-primary ">Apple
					and Samsung</button>
			</div>
			
		</div>
	</div>
	
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
$(document).ready(function(){
	
$("#groupButton").hover(function(){
	$(this).css({
		"background-color":"white",
		"color":"black"
	});
	
	$("#mainimage").attr("src","carousel/car2.jpg");
	
});

$("#groupButton").mouseleave(function(){
	$(this).css({
		"background-color":"black",
		"color":"white",
		"box-shadow":"2px 2px 2px #88888"
		
	});
});
	
});
</script>
</body>
</html>