<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<title>Check Stock</title>

<script>

$(document).ready(function(){
	var choice;
	$("#choice").click(function(){
			
		$("#choice:selected").text(); //the text content of the selected option
		choice=$("#choice").val();
		
	      $.getJSON('checkStock', {
	        choice : choice
	      }, function(jsonResponse) {
	      
	      	var select = $('#list');
	        select.find('option').remove();
	        $.each(jsonResponse.list, function(key, value) {
	          $('<option>').val(key).text(value).appendTo(select);
	        });
		
		});
	});	
	
	$("#generate_details").click(function(){
		
		var select=$('#personDataTable');
		select.find('td').remove();
		select.show();
		
		 	
		$("#list:selected").text(); //the text content of the selected option
		var choice2=$("#list").val();
	//	var table = $('<table/>').appendTo($('#somediv'));
		
		$.getJSON('checkStock', {
	        choice : choice,choice2:choice2
	      }, function(jsonResponse) {
	    	  
	    	  $.each(jsonResponse.productlistoflowstock, function(key,value) {
	    		  drawRow(value);
	    	  });
	      });
	});
	      
    });
	    	
	
	
	function drawRow(rowData) {
	    var row = $("<tr />");
	    $("#personDataTable").append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
	    row.append($("<td>" + rowData.p_name + "</td>"));
	    row.append($("<td>" + rowData.p_price + "</td>"));
	    row.append($("<td>" + rowData.stock + "</td>"));
	}

	



</script>
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

<title>Check Stock</title>

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
<div class = "col-md-9 col-md-offset-3">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-6">
				<h1>
					<font color="black">Flipkart Administration</font>
				</h1>
			</div>
			<div class="col-md-2"></div>
		</div>
		<br>
		<div class="row">
			
			<div class="col-md-4">
				<h2>
					<font color="black">Check Stock</font>
				</h2>
			</div>
			<div class="col-md-6"></div>
			<div class="col-md-2"></div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
			Select Choice
			</div>
			<div class="col-md-4">
				<select id="choice" >
  					<option value="category">By Category</option>
 					<option value="seller">By Seller</option>
				</select>
			</div>
			<div class="col-md-4"></div>
		</div>
		<br> <br>
		<div class="row">
			<div class="col-md-4">
			Select Specific
			</div>
			<div class="col-md-4">
				<select id="list" >
				</select>
			</div>
			<div class="col-md-4">
			<button id="generate_details">Generate Details</button>
			</div>
		</div>
					<br>
   <div id="ajaxResponse"></div>
		
		<table id="personDataTable" class="table table-bordered table-striped" style = "display:none">
    <tr>
        <th>Product Name</th>
        <th>Price </th>
        <th>Stock</th>
    </tr>
    
</table>
		<div id="somediv" align="center"></div>	
				<br> <a href="adminhome.jsp">  </a>
			</div>
			</div>

		

</body>
</html>