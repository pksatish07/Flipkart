<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">

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

<title>Add Category</title>

</head>
<body>
	<div id="wrapper">
		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"><a href="#" style="color: white;">
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
			<form class="form-horizontal" name="myForm" action ="addNewCategory">
				<br> <br>
				<fieldset>
					<legend>New Category Details</legend>
					<div class="form-group">
						<label for="categoryName" class="col-md-2 control-label">Category
							Name:</label>
						<div class="col-md-4">
							<input type="text" class="form-control" id="categoryName" name = "categoryName"
								placeholder="Category Name">
						</div>
					</div>

					<div class="form-group">
						<label for="description" class="col-md-2 control-label">Description:</label>
						<div class="col-md-8">
							<textarea class="form-control" rows="3" id="description"
								name="description" placeholder="Enter description here"></textarea>
						</div>
					</div>

					<div class="form-group">
						<label for="categoryLevel" class="col-md-2 control-label">Category
							level:</label>
						<div class="col-md-2">
							<select class="form-control" id="categoryLevel"
								name="categoryLevel">
								<option>0</option>
								<option>1</option>
								<option>2</option>
							</select>
						</div>
					</div>
					<div class="form-group" id="parent" style = "display:none">
						<label for="parentName" class="col-md-2 control-label">Parent
							Category:</label>
						<div class="col-md-2">
							<select class="form-control" id="parentName" name="parentName" disabled = "disabled">
								<option></option>
							</select>
						</div>
					</div>
					<br>
					<div class="form-group">
						<div class="col-md-10 col-md-offset-2">
							<a href = "newCategory" class = "btn btn-default">Cancel</a>
							<button type = "submit" class = "btn btn-primary">Submit</button>
						</div>
					</div>


				</fieldset>
			</form>
		</div>
	</div>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript">
$(document).ready(function(){
	
	$("#categoryLevel").on('change',function(){

		var level = $(this).val();
		
		if(level == 0){
			$("#parentName").find('option').remove();
			$("#parent").hide();
		}
		else{
			$("#parentName").prop('disabled',false);
			$("#parent").show();
			
		$.getJSON('getCategoryNames',{
			catLevel : level
		}, function(jsonResponse){
			var select = $("#parentName");
			select.find('option').remove();
			$.each(jsonResponse.catList,function(key,value){
				  $('<option>').text(value).appendTo(select);  
			});
		});
		}
	});
});
</script>
</body>
</html>