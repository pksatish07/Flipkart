<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <style>
   
    .toggle-details {
    background:url("images/my-order-sprite-1addd53e.png") no-repeat scroll 0px -65px;
    display: inline-block;
    vertical-align: middle;
    width: 22px;
    height: 14px;
    margin-top: 10px;
}
a {
    color: #666;
    text-decoration: none;
    cursor: pointer;
}
.order-item .item-image {
    max-width: 80px;
    width: auto !important;
}
img {
    border: 0px none;
}
div.img {
    margin: 5px;
    padding: 5px;
    border: 1px solid #0000ff;
    height: auto;
    width: auto;
    float: left;
    text-align: center;
}	

div.img img {
    display: inline;
    margin: 5px;
    border: 1px solid #ffffff;
}

div.img a:hover img {
    border: 1px solid #0000ff;
}

div.desc {
  text-align: center;
  font-weight: normal;
  width: 120px;
  margin: 5px;
}
.goquickly-bar {
    height: 32px;
    width: 1100px;
    border-right: 2px solid #F0F0F0;
    border-width: 0px 2px 2px;
    border-style: none solid solid;
    border-color: -moz-use-text-color #F0F0F0 #F0F0F0;
    -moz-border-top-colors: none;
    -moz-border-right-colors: none;
    -moz-border-bottom-colors: none;
    -moz-border-left-colors: none;
    border-image: none;
    border-radius: 0px 0px 2px 2px;
    padding: 0px 10px;
    font-size: 12px;
    background: none repeat scroll 0% 0% #FFF;
}
.goquickly-list > li {
    display: inline-block;
}
.goquickly-bar .goquickly-list > li a {
    display: block;
    padding: 0px 6px;
    margin: 10px 0px;
    border-right: 1px solid #E8E8E8;
}
a {
    color: #666;
    text-decoration: none;
    cursor: pointer;
}
a:hover {
    color: #2271B2;
    text-decoration: underline;
}
.fk-font-17 {
    font-size: 17px;
}
.line, .lastUnit {
    overflow: hidden;
}
.tmargin20 {
    margin-top: 20px;
}
.bmargin20 {
    margin-bottom: 20px;
}
.orderIdBtn {
    width: 196px;
}
.btn.btn-blue {
    border: 1px solid #004B91;
    background: linear-gradient(to bottom, #007FB8 1%, #6EBAD5 3%, #007FB8 7%, #007FB8 100%) repeat scroll 0% 0% transparent;
}
a:hover {
    color: #2271B2;
    text-decoration: underline;
}

.order-expanded {
    background-color: #F9F9F9;
    border-bottom: 1px solid #E6E6E6;
    padding: 12px 15px;
}
.toggle-details {
    background: url("images/my-order-sprite-1addd53e.png") no-repeat scroll 0px -65px transparent;
    display: inline-block;
    vertical-align: middle;
    width: 22px;
    height: 14px;
    margin-top: 10px;
} 

#order-section
.order-collapsed
.toggle-details {
    background: transparent url("images/my-order-sprite-1addd53e.png") no-repeat scroll 0px -65px;
    margin-top: 0px;
    transform: rotate(180deg);
}
.collapsed .order-collapsed {
    display: block;
}
.myorder-tabs {
    padding: 0px 0px 0px 25px;
    border-bottom: 1px solid #B3B3B3;
}

.myorder-tabs .tab {
    position: relative;
    top: 1px;
    border-width: 1px 1px 4px;
    border-style: solid;
    border-color: #B3B3B3 #B3B3B3 #CCCAC6;
    -moz-border-top-colors: none;
    -moz-border-right-colors: none;
    -moz-border-bottom-colors: none;
    -moz-border-left-colors: none;
    border-image: none;
    border-top-left-radius: 2px;
    border-top-right-radius: 2px;
    padding: 7px 30px 4px;
    text-align: center;
    cursor: pointer;
    font-size: 15px;
    color: #999;
    background-color: #E0DED9;
    vertical-align: bottom;
}
.myorder-tabs .tab.selected {
    background-color: transparent;
    padding: 11px 30px 0px;
    color: #565656;
    border-bottom: 0px none;
}
.fk-inline-block,#order-infograph li,#order-infograph li i,#ndr_dialog .radios{
	display:inline-block;
	*display:inline;
	zoom:1
}
body {
    font-size: 13px;
    font-family: arial,tahoma,verdana,sans-serif;
    color: #333;
    text-align: left;
}
.order-item {
    margin: 0px 15px;
    padding: 10px 0px;
    border-bottom: 1px solid #CCC;
}

.button-bar {
    text-align: center;
    display: inline-block;
    border-radius: 2px;
    border: 1px solid #C9C9C9;
    background: transparent linear-gradient(to bottom, #F9F9F9 1%, #FFF 3%, #F9F9F9 7%, #F2F2F2 100%) repeat scroll 0% 0%;
}
.button-bar a {
    display: inline-block;
    white-space: nowrap;
    padding: 6px 0px;
    width: 100px;
    text-align: center;
    text-decoration: none;
}
.button-bar .action:hover {
    color: #565656;
    background: transparent linear-gradient(to bottom, #FFF 1%, #F9F9F9 3%, #FFF 7%, #F2F2F2 100%) repeat scroll 0% 0%;
}
#order-section .new-return i {
    background: transparent url("images/my-order-sprite-1addd53e.png") no-repeat scroll 0px -48px;
    display: inline-block;
    vertical-align: middle;
    height: 13px;
    width: 17px;
}
.size2of7 {
    width: 28.5714%;
}
.unit {
    float: left;
}
.size2of5 {
    width: 40%;
}
.unit {
    float: left;
}
.lpadding10 {
    padding-left: 10px;
}
.bmargin10 {
    margin-bottom: 10px;
}
.size2of5 {
    width: 40%;
}
.unit {
    float: left;
}
.lastUnit {
    overflow: hidden;
}
.size1of8 {
    width: 12.5%;
}
.lpadding10 {
    padding-left: 10px;
}


.lpadding10 {
    padding-left: 10px;
}
.bmargin10 {
    margin-bottom: 10px;
}

.unit {
    float: left;
}
.fk-text-center {
    text-align: center;
}
.text_right {
    text-align: right;
}.lastUnit {
    float: none;
    width: auto;
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

$("#myaccount").hover(function(){
    	
        $("#myaccount").css({"background-color": "LightGray","color": "blue"});
    });
    
    $("#myaccount").mouseout(function(){
        $("#myaccount").css({"background-color": "white","color":"black"});
    });
$("#pname").hover(function(){
    	
        $("#pname").css("color","blue");
    });
    
    $(a[href="getproductAction?pid=<s:property value="productId" />"]).mouseout(function(){
        $(a[href="getproductAction?pid=<s:property value="productId" />"]).css("color","black");
    });
    $(document).ready(function(){
        $(a[href="getproductAction?pid=<s:property value="productId" />"]).click(function(){
            $("#hemu").slideToggle("fast");
        });
    });
});

</script>
  </head>

  <body  style = "background:#F5F5F5;" >
    <div class="container" style = "background:white;">
   		<div class="goquickly-bar" data-tracking-id="nmenu_quicklinks"> 
  			 <ul class="goquickly-list">
   				 <li class="subheading">Go quickly to <span class="glyphicon glyphicon-arrow-right"></span></li> 
   				 
       			 <li class=""><a href="personal" id="personal">Profile Information</a></li>
   				 <li class=""><a href="changePassword" id="changepassword">ChangePassword</a></li>
    			 <li class=""><a href="updateEmail" id="update">UpdateEmail</a></li>
     			 <li class=""><a href="deactivateAccount" id="deactivate">Deactivate Account</a></li>  
       			 <li class="last"><a href="getaddress" id="address" >Addresses</a></li> 
       			
       		 </ul> 
       </div>
     <ul class="line bmargin20 tmargin20 fk-font-17"> 
     		<li class="fk-inline-block" ><a href="personal" id="myaccount">My Account</a> / </li> 
     		<li class="fk-inline-block"><h4>My Orders</h4></li> </ul>
      	<div class="myorder-tabs"> 
    		 <ul> 
     		 <li class="fk-inline-block tab selected" id="recent-orders"><span class="text">RECENT ORDERS</span><span id="subText" class="text fk-font-small">(Last 6 Months)</span></li> 
     		 <li class="fk-inline-block tab" id="past-orders"><span class="text">PAST ORDERS</span></li> </ul> </div>
       
       <s:iterator value="resultList" >
        
       <div class="panel-body">
   		 	<div class="panel panel-default">
           			<div class="line order-expanded"> 
           			     <div class="unit size1of4">
            				 <a class="orderIdBtn btn btn-medium btn-blue"><s:property value="orderid"/></a> 
            			 </div> 
           				 <div class="unit size3of5"> </div> 
           					 <div class="lastUnit text_right" id="hemui"> <a  id="hemui"  class="toggle-details" ></a> 
            	 			</div> 
           		  </div>
                  <div id="hemu" > 
                  		<div class="panel-body">
                 				 <div class="line js-order-details">
            					 <div class="line order-item ">
            					    <div class="unit size1of8 fk-text-center product-image">  
            				        <img class="item-image" src="productImage?productId=<s:property value="productId" />" /> </div> 
            				        <div class="unit size2of7"> <a target="_blank" id="pname" href="getproductAction?pid=<s:property value="productId" />">
							        <s:property value="pname"/> </a>  <p class="smallText tmargin10">
							    		  Quantity: <s:property value="pquantity"/> </p> </div>
            				        <div class="unit size1of6"> <div class="lpadding10">
							           RS:<s:property value="price"/> </div> </div> <div class="unit size1of6"> <div class="lpadding10">
							            </div> </div><br><br><div class="unit size2of7"><p class="greyText bmargin10">
 							              <s:property value="pstatus"/> </p> </div> 
 							             
                  </div>
                    <div class="line order-total"> <div class="line"> <div class="unit size2of5"> 
                    <span class="smallText">Seller:</span><s:property value="pseller"/> <span class="rmargin20"></span> 
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp
                    <span class="smallText fk-inline-block">Ordered Date:</span> Fri, 27th Mar'15 </div> 
                    
                         <div class="lastUnit text_right"> <span class="smallText">Order Total:</span> <strong>Rs.</strong><s:property value="price"/> 
                         </div> </div> </div>
                  </div>
                  </div></div>
         
       	    </div>
        </div>
       </s:iterator>
        </div>
     
    <script src="bootstrap/jquery/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>