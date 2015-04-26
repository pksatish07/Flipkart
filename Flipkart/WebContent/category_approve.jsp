<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

<style type="text/css">
#wrapper {
    padding-left: 0;
    -webkit-transition: all 0.5s ease;
    -moz-transition: all 0.5s ease;
    -o-transition: all 0.5s ease;
    transition: all 0.5s ease;
}

#wrapper.toggled {
    padding-left: 250px;
}

.logoutalign{

position:absolute;
top:288px;
left: 0px

}
#sidebar-wrapper {
    z-index: 1000;
    position: fixed;
    left: 250px;
    width: 0;
    height: 100%;
    margin-left: -250px;
    overflow-y: auto;
    background: #FFFFFF;
    -webkit-transition: all 0.5s ease;
    -moz-transition: all 0.5s ease;
    -o-transition: all 0.5s ease;
    transition: all 0.5s ease;
}

/* #wrapper.toggled #sidebar-wrapper {
    width: 250px;
} */

#page-content-wrapper {
    width: 100%;
    position: absolute;
    padding: 15px;
}

#wrapper.toggled #page-content-wrapper {
    position: absolute;
    margin-right: -250px;
}

/* Sidebar Styles */

.sidebar-nav {
    position: absolute;
    top: 0;
    
    margin: 0;
    padding: 0;
    list-style: none;
}

.sidebar-nav li {
    text-indent: 25px;
    line-height: 50px;
}

.sidebar-nav li a {
    
    text-decoration: none;
    color: #999999;
}

.sidebar-nav li:hover {
    text-decoration: none;
    color: #4169E1;
    background:rgb(57, 54, 54);
}

.sidebar-nav li a:active,
.sidebar-nav li a:focus {
    text-decoration: none;
}

.sidebar-nav > .sidebar-brand {
    height: 20px;
    font-size: 15px;
    line-height: 10px;
    padding-top:20px;
    
}


.sidebar-nav > .sidebar-brand a {
    color: #999999;
    bold:strong;
}
.sidebar-nav > .sidebar-brand a:hover {
    color: #999999;
    background: none;
}

@media(min-width:768px) {
    #wrapper {
        padding-left: 250px;
    }

    #wrapper.toggled {
        padding-left: 0;
    }

    #sidebar-wrapper {
        width:20%;
        background:rgb(21, 18, 18);
    }

    #wrapper.toggled #sidebar-wrapper {
        width: 0;
    }

    #page-content-wrapper {
        padding: 20px;
        position: relative;
    }

    #wrapper.toggled #page-content-wrapper {
        position: relative;
        margin-right: 0;
    }
}



</style>

<title>Approve/Reject Category</title>

</head>
<body>
	<div id="wrapper">
		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"><a href="adminhome.jsp" style="color: white;">
						Admin Home </a></li>
				<li><br/></li>
				<li><a href="newCategory">Add Product Category</a></li>
				<li><a href="newProduct">Add Product</a></li>
				<li><a href="approveCategory">Approve/Reject Category
						addition </a></li>

				<li><a href="checkstock.jsp">Check Stock</a></li>
				<li><a  href="logoutAction"><span
						class="glyphicon glyphicon-log-out logoutalign"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Logout</a></li>
			</ul>
		</div>
	</div>
	<div class="container-fluid">
		
		<div class="col-md-offset-3">
			<br> <br> <br>
			<div class="row" id="dj"></div>
			<div class="row" align="center">
				<h2>New Category(s) to approved or rejected</h2>
			</div>
			<div id="msg"></div>
			<s:iterator value="list" var="category">
				<div id=<s:property value="#category.NotificationId" /> class="well">
					<form class="form-horizontal" name="myForm">
						<br> <br>
						<fieldset>

							<div class="form-group">
								<label for="categoryName" class="col-md-2 control-label">Category
									Name:</label>
								<div class="col-md-4">
									<label><s:property value="#category.categoryName" /></label>
								</div>
							</div>

							<div class="form-group">
								<label for="description" class="col-md-2 control-label">Description:</label>
								<div class="col-md-8">
									<label id="description"><s:property
											value="#category.description" /></label>
								</div>
							</div>

							<div class="form-group">
								<label for="categoryLevel" class="col-md-2 control-label">Category
									level:</label>
								<div class="col-md-2">
									<label id="categoryLevel"><s:property
											value="#category.categoryLevel" /></label>
								</div>
							</div>
							<div class="form-group" id="parent">
								<label for="parentName" class="col-md-2 control-label">Parent
									Category:</label>
								<div class="col-md-2">
									<label id="categoryName"><s:property
											value="#category.parentName" /></label>
								</div>
							</div>
							<div class="form-group" id="adminfname">
								<label for="adminName" class="col-md-2 control-label">Admin
									name:</label>
								<div class="col-md-2">
									<label id="adminName"><s:property
											value="#category.admin_fname" /></label>
								</div>
							</div>
							<br>
							<div class="form-group">
								<div class="col-md-10 col-md-offset-2">
									<button class="btn btn-success"
										id=<s:property
											value="#category.NotificationId" />
										title="add">
										<span class="glyphicon glyphicon-ok"></span>Approve
									</button>
									<button class="btn btn-warning"
										id=<s:property
											value="#category.NotificationId" />
										title="remove">
										<span class="glyphicon glyphicon-remove"></span>Reject
									</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>


			</s:iterator>

		</div>
	</div>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("button").click(function(){
			var id = this.id;
			var act = this.title;
			$.getJSON('addThisCategory',{
				notificationId:id,
				msg:act
			}, function(jsonResponse){
					document.myForm.action = 'approveCategory.action';
					document.myForm.submit();
					var elem = document.getElementById(id);
					 elem.parentElement.removeChild(elem);
				});
			});
		});
</script>


</body>
</html>