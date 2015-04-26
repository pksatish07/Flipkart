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

<title>Add New Product</title>

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
			<s:form action="addProductDetails" class = "form-horizontal" enctype="multipart/form-data">
				<br><br>
				<fieldset>
				
					<legend>New Product Details</legend>
					<div class="form-group">
						<label for="productName" class="col-md-2 control-label">Product
							Name:</label>
						<div class="col-md-4">
							<input type="text" class="form-control" id="productName"
								placeholder="Product Name" name="productName">
						</div>
					</div>
					<br>
					<div class="form-group">
						<label for="productPrice" class="col-md-2 control-label">Product
							Price:</label>
						<div class="col-md-4">
							<input type="text" class="form-control" id="productPrice"
								placeholder="Product Price" name="productPrice">
						</div>
					</div>
					 <br>
					<div class="form-group">
						<label for="warranty" class="col-md-2 control-label">Product
							Warranty:</label>
						<div class="col-md-4">
							<input type="text" class="form-control" id="warranty"
								placeholder="Product Warranty" name="warranty">
						</div>
					</div>
					 <br>
					<div class="form-group">
						<label for="productImage" class="col-md-2 control-label">Product
							Image:</label>
						<div class="col-md-4">
							<input type="file" class="form-control" id="productImage"
								placeholder="Product Image" name="productImage">
						</div>
					</div>
					<br>
					<div class="form-group">
						<label for="color" class="col-md-2 control-label">Product
							Colour:</label>
						<div class="col-md-4">
							<input type="text" class="form-control" id="color"
								placeholder="Product Colour" name="color">
						</div>
					</div>
					<br>
					<div class="form-group">
						<label for="deliveryCharge" class="col-md-2 control-label">Delivery
							Charge:</label>
						<div class="col-md-4">
							<input type="text" class="form-control" id="deliveryCharge"
								placeholder="Delivery Charge" name="deliveryCharge">
						</div>
					</div>
					<!-- <br> <br>
					<div class="form-group">
						<label for="productSize" class="col-md-2 control-label">Product
							Size:</label>
						<div class="col-md-4">
							<input type="text" class="form-control" id="productSize"
								placeholder="Product Size" name="productSize">
						</div>
					</div> -->
					<br>
					<div class="form-group">
						<label for="category" class="col-md-2 control-label">Category:</label>
						<div class="col-md-4">
							<select id="category" name="category" class="form-control">
								<s:iterator value="categoryList" var="category">
									<option><s:property value="#category" /></option>
								</s:iterator>
							</select>
						</div>
					</div>
					<br>
					<div class="form-group">
						<label for="color" class="col-md-2 control-label">Description:
						</label>
						<div class="col-md-4">
							<textarea cols = "100" rows = "2" name = "description" id= "description"></textarea>
						</div>
					</div>
					<br>
					<div class="form-group">
						<label for="color" class="col-md-2 control-label">Specifications:
						</label>
						<div class="col-md-4 ">
							<textarea cols = "100" rows = "2" name = "specs" id= "specs"></textarea>
						</div>
					</div>
					<br>
					<div class="form-group">
						<label for="color" class="col-md-2 control-label">Key features:</label>
						<div class="col-md-4">
							<textarea cols = "100" rows = "2" name = "kf" id= "kf"></textarea>
						</div>
					</div>
					<br>
					<div class="form-group">
						<div class="col=md-2 col-md-offset-3">
							<button type="submit" value="Submit" class="btn btn-success">Submit</button>
						</div>
					</div>

				</fieldset>
			</s:form>
		</div>
	</div>
</body>


<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
</html>