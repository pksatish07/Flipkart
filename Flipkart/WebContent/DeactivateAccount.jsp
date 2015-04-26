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
<title>DeactivateAccount</title>
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
				<h3 ><strong>Deactivate Account</strong></h3>
				<br>
				<strong>Enter the new Email ID that you wish to associate with your Flipkart account. </strong>
				<br><br>
				<form action="deactivateaccount" class="form-horizontal" method="post" enctype="multipart/form-data">
							
						<p>	<label for="name">Email Address</label>  <s:property  value="email"/></p>	
					<br>
					
							<p>	<label >Password</label> <input type="password"
									 name="password" id="password"></p>
							<br>
				
					
					<p>	<button type="button" class="btn btn-blue"  onclick="performAction(this.form)">Save Changes</button></p>
						
				</form>
				<br>
				<div class="fk-suc-msg" id="per-info-suc">Your changes have been saved successfully.</div>		
	            <div class="fk-err-all" id="per-info-error">Invalid Password.</div>
				
				<p><strong>When you deactivate your account</strong><br><br></p>
				<ul>
			
<li>You are logged out of your Flipkart Account</li>
<li>Your public profile on Flipkart is no longer visible</li>
<li>Your reviews/ratings are still visible, while your profile information is shown as ‘unavailable’ as a result of deactivation.</li>
<li>Your wishlist items are no longer accessible through the associated public hyperlink. Wishlist is shown as ‘unavailable’ as a result of deactivation</li>
<li>You will be unsubscribed from receiving promotional emails from Flipkart</li>
<li>Your account data is retained and is restored in case you choose to reactivate your account</li>

</ul>

<p><strong>How do I reactivate my Flipkart account?</strong><br><br>			
Reactivation is easy.<br><br>Simply login with the email/social network ID and password combination used prior to deactivation. Your account data is fully restored. Default settings are applied and you will be subscribed to receive promotional emails from Flipkart.
<br><br>Flipkart retains your account data for you to conveniently start off from where you left, if you decide to reactivate your account.</p>
             <br><br> <br><br> <br><br> <br><br>  
		 </div>
		</div>
 <script>
document.getElementById('per-info-suc').style.visibility = "hidden";
document.getElementById('per-info-error').style.visibility = "hidden";
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
		if(xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			
			if(xmlhttp.getResponseHeader('flag')=='true'){
				document.getElementById('per-info-suc').style.visibility = "visible";
				document.getElementById('per-info-error').style.visibility = "hidden";
				}
				
				else{
					document.getElementById('per-info-error').style.visibility = "visible";
				     document.getElementById('per-info-suc').style.visibility = "hidden";
				}
		}
	};
	xmlhttp.open("POST","deactivateaccount",true);
	var formData=new FormData(form);
	xmlhttp.send(formData);
}

</script>
</body>
</html>