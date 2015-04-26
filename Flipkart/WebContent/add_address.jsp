<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
 <link href="bootstrap/css/simple-sidebar.css" rel="stylesheet">
<script src="bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Address</title>
<style>
.fk-lcat-main-header {
    padding: 5px 5px 5px 9px;
    font-size: 16px;
    font-weight: bold;
    background: url("images/diag_tile-c3eb9dc7.png") repeat scroll left top #014A72;
    color: #FFF;
}
.fk-suc-msg {
    background: url("images/tick1-042bc15a.png") no-repeat scroll 5px 10px #CFC;
    border: 1px solid #696;
    color: #008000;
    font-size: 13px;
    padding: 10px 0px 10px 30px;
    text-align: left;
}
.btn.btn-blue:hover {
    border: 1px solid #004B91;
    background: linear-gradient(to bottom, #007FB8 1%, #6EBAD5 3%, #059FC6 7%, #007FB8 100%) repeat scroll 0% 0% transparent;
}
.btn.btn-blue {
    border: 1px solid #004B91;
    background: linear-gradient(to bottom, #007FB8 1%, #6EBAD5 3%, #007FB8 7%, #007FB8 100%) repeat scroll 0% 0% transparent;
}
.fk-input {
    font-size: 13px;
    padding: 5px 6px;
    border: 1px solid #CCC;
    resize: none;
    font-family: inherit;
}
.fk-err-all {
    background: #FCE7E7 none repeat scroll 0% 0%;
    border: 1px solid #B00;
    color: #B00;
    padding: 5px;
    text-align: left;
}
form p label {
	display:block;
	float:left;
	width:200px;
}
.account_page_address_info.sel {
    border-color: #DDD;
}
.account_page_address_info {
    padding: 10px;
    font-weight: normal;
    float: left;
    text-align: left;
    border: 3px solid #FFF;
    background: #F2F2F2 none repeat scroll 0% 0%;
    margin: 5px;
    width: 180px;
}
</style>
<script>
$(function(){
    $("#personal").on({
    	mouseenter: function(){
        $(this).css({"background-color": "LightGray","color": "blue"});
    },  
    mouseleave: function(){
        $(this).css({"background-color": "white","color":"black"});
    }}
    );

 $("#changepassword").on({
    	mouseenter: function(){
        $(this).css({"background-color": "LightGray","color": "blue"});
    },  
    mouseleave: function(){
        $(this).css({"background-color": "white","color":"black"});
    }}
    );
$("#address").on({
    	mouseenter: function(){
        $(this).css({"background-color": "LightGray","color": "blue"});
    },  
    mouseleave: function(){
        $(this).css({"background-color": "white","color":"black"});
    }}
    );
$("#update").on({
    	mouseenter: function(){
        $(this).css({"background-color": "LightGray","color": "blue"});
    },  
    mouseleave: function(){
        $(this).css({"background-color": "white","color":"black"});
    }}
    );
$("#deactivate").on({
    	mouseenter: function(){
        $(this).css({"background-color": "LightGray","color": "blue"});
    },  
    mouseleave: function(){
        $(this).css({"background-color": "white","color":"black"});
    }}
    );
$("#home").on({
    	mouseenter: function(){
        $(this).css({"background-color": "LightGray","color": "blue"});
    },  
    mouseleave: function(){
        $(this).css({"background-color": "white","color":"black"});
    }}
    );
$("#myorders").on({
    	mouseenter: function(){
        $(this).css({"background-color": "LightGray","color": "blue"});
    },  
    mouseleave: function(){
        $(this).css({"background-color": "white","color":"black"});
    }}
    );
});

</script>

</head>
 <body  style = "background:#F5F5F5;" >
    <div class="container" style = "background:white; z-index: 100;" id="sidebar-wrapper">
    <br>       
            <ul class="sidebar-nav">
            <br>
                <li class="sidebar-brand" >
                   <h6>  <a href="HomeAction" id="home">Home</a>>My Account</h6>
                 </li>
               <br>
                <li  >
                   <div class="fk-lcat-main-header">
                     <strong style="color:white;" > MY ACCOUNT</strong>
                    </a></div>
                    
                 </li>
                <br>
                  <li class="sidebar-brand">
                   
                      <strong style="color:#808080;">  ORDERS</strong>
                   
                 </li>
                 
                <li>
                    <a href="myorders" id="myorders">My Orders</a>
                </li>
                
               
                
                <hr>
                
                 <li class="sidebar-brand">
                   
                    <strong style="color:#808080;">  SETTINGS</strong>
                   
                 </li>
                
                <li>
                    <a  href="personal"  id="personal">Personal Information</a>
                </li>
                <li>
                    <a href="changePassword"  id="changepassword">Change password</a>
                </li>
                <li>
                    <a href="getaddress" id="address">Addresses</a>
                </li>
               
                <li>
                    <a href="updateEmail" id="update">Update Email</a>
                </li>
                <li>
                    <a href="deactivateAccount" id="deactivate">Deactive Account</a>
                </li>
                
            </ul>
       
       
		
		<br>
		<div class="col-md-8 col-md-offset-2">
				<h3 >Add a New Address</h3>
				<br>
				<form action="address"  method="post" enctype="multipart/form-data">
							
							<p>	<label >First Name</label>
								<input type="text"  name="name" id="name"></p>
							
					
						<p>	<label >Street Address</label><br>
							<textarea name="street" rows="5" cols="40"></textarea></p>
                    	
							<p>	<label >Landmark</label><input type="text"
									 name="landmark" id="landmark"></p>
					
					
							<p>	<label >City</label><input type="text"
									 name="city" id="city"></p>
						
						
					      <p>   <label>State</label>
					         <select name="state">
							 <option>SELECT</option>
							 <option>KARNATAKA</option> 
							 <option>ANDHRA PRADESH</option> 
							 <option>GOA</option> 
							 <option>KERALA</option> 
							 </select></p>
							
							<p> <label >Pincode</label><input type="text"
									 name="pincode" id="pincode"></p>
						
							<p>	<label>Phone Number</label><input type="text"
									 name="mobile" id="mobile"></p>
						
					
							<p>	<button type="button" class="btn btn-blue"  onclick="performAction(this.form)">Save Changes</button></p>
						
				</form>
				 <br>
				<div class="fk-suc-msg" id="per-info-suc">Address added successfully.</div>		
	             <br>
				<div  > <span ><b>Your Saved Addresses</b></span> <br><hr>
				  <s:iterator value="resultList" >
				 <div class="account_page_address_info sel"> 
				 <div class="account_page_address_data"> <span><b><s:property value="ad_name"/></b></span><br> 
				 <span><s:property value="street"/></span><br> <span><s:property value="landmark"/></span><br>
                     <span><s:property value="city"/> - <s:property value="pincode"/></span><br>
                     <span><s:property value="state"/></span><br> <span>Ph:<s:property value="mobile"/></span><br>  </div>
                      <div > 
                       </div>
                        <div class="cls"></div>  <br><br> <br>  <br><br> <br>  <br> </div> 
                         
                      </s:iterator>
                     
                      </div>
                   
		 </div>
		  <br><br> <br> 
		 </div>
		


 <script>
document.getElementById('per-info-suc').style.visibility = "hidden";

function performAction(form)
{
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	
	xmlhttp.onreadystatechange=function()
	{
		//console.log("hi");
		if(xmlhttp.getResponseHeader('flag')=='true')
			document.getElementById('per-info-suc').style.visibility = "visible";
			
	};
	xmlhttp.open("POST","address",true);
	var formData=new FormData(form);
	xmlhttp.send(formData);
}

</script>
</body>
</html>