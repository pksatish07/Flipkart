<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html lang="en">
<head>
<link href="/flipkartLogin/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/flipkartLogin/bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Flipkart</title>
<style type="text/css">
.container1
{
padding-right: 40px;
padding-left: 0px;
margin-right: auto;
margin-left: auto;
width: 1400px;
}
</style>
</head>
<body >

	<div class="container1">
		<tiles:insertAttribute name="header" />

	</div>
	<div>
		<tiles:insertAttribute name="navbar" />

	</div>
	<div style="background-color: #FCFCFC;">
		<tiles:insertAttribute name="body" />

	</div>
	
</body>
</html>