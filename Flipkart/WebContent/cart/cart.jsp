<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<%@ page import="org.iiitb.flipkart.cart.*"%>
<%@ page import="java.util.*"%>


<%
	// add login id in the query after the session is added....
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="/Flipkart/bootstrap/css/bootstrap.min.css">
<script src="/Flipkart/bootstrap/js/jquery.min.js"></script>
<script src="/Flipkart/bootstrap/js/bootstrap.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<head>
<style>
table {
	border-collapse: collapse;
}

table,td {
	border: 1px solid #e4e4e4;
}

table {
	width: 75%;
}

th {
	border: 1px solid #e4e4e4;
	background-color: #f4f4f4;
	color: black;
}

.remove {
	position: relative;
	left: 355px;
	top: 26px;
	font-size:6pt;
	
}

.nav {
	display: inline-block;
	position: relative;
	cursor: default;
	z-index: 500;
}

.placeorder {
	color: #f9f9f9;
	height: 41px;
	width: 200px;
	font-size: 12px;
	background: #f78828;
	border: 1px solid #da7532;
}

.continueshopping {
	height: 41px;
	width: 175px;
	background: #f4f4f4;
	font-size: 12px;
	border: 1px solid #f4f4f4;
	color: black;
}

.addtocart {
	vertical-align: middle;
	cursor: pointer;
	text-shadow: 0 0 1px rgba(0, 0, 0, 0.33);
	border: 1px solid;
	border-radius: 4px;
	outline: 0;
}



.cartimg {
	width: 1080px;
}

.cartTab {
	position: absolute;
	 left: 239px;
  	  top: 93px;
	border-radius: 3px 3px 0 0;
	color: #fff;
	background: #666;
	text-transform: none;
	font-size: 18px;
	border: 0;
	height: 40px;
	width: 100px;
	text-align: center;
	padding-top: 5px;
}

.link_button {
	background: white;
	border: 0px;
   font-size: 7pt;
  position: relative;
  top: -5px;
  left: 5px;
}

.count
{
border:none;

}
</style>


<script type="text/javascript">
	$(document).ready(function() {
		
	
		
		
		
		$("input").click(function(event) {
			var id = event.target.id;

			document.getElementsByName(id)[0].style.visibility = "visible";
		});
		
	
		
		$("button").click(function(event) {

			
			if(this.id=="cart_quantity_static")
			{
				
				var id = this.name;
				
				var qty=  document.getElementById(id).value;
				
				// Check if quantity is negative or >100. If it is so , fetch the old qty value from
				// hidden input box and display again.
				
				if(qty<0 || qty>100 || qty==0)
				{
					alert("Sorry. Quantity cannot be '0', Negative/Greater than 100");
					var withProperty = [];
				    var els = document.getElementsByTagName('input');// or '*' for all types of element
				    var i = 0;

			for (i = 0; i < els.length; i++) {
				    if (els[i].hasAttribute('title')) {
				        if(els[i].title == id)
				        	{
				        		withProperty.push(els[i]);
				        	}
				    	
				    	
				    }
				} 
				
			document.getElementById(id).value = withProperty[0].value;
				
				}
				else
				document.location="/Flipkart/changeCart.action?id="+id+"&quantity="+qty;
				
			}
			
 
		 

		});
		

	$("a").hover(function(){
			
			if(this.id=="uid")
			{
				$(this).css("color","blue");
			}
		});
		
		

	});
	
	</script>
	
	




</head>
<body>
	<div class="container-fluid">
	<center>

		<table>
			<tr height="50px">
				<td>
					<div class="cartTab">Cart(<s:property value="cartCount"/>)</div>
				</td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col span="4" style="background-color: WHITE">
				<col style="background-color: white">
			</colgroup>
			<tr height="50px">
				<th width="54%"><div class="col-md-2"></div>
					<div class="col-md-10">ITEM</div></th>
				<th width="5%"><div class="col-md-2"></div>
					<div class="col-md-10">QTY</div></th>
				<th width="17%"><div class="col-md-2"></div>
					<div class="col-md-10">PRICE</div></th>
				<th width="19%"><div class="col-md-1"></div>DELIVERY DETAILS</th>
				<th width="17%"><div class="col-md-2"></div>
					<div class="col-md-10">SUBTOTAL</div></th>
			</tr>


			<%
				int Total = 0;
			%>
			<s:iterator value="resultSet" var="product">
				<%--  <%
   /*  try{
    	
		HttpRequest request = 	
    	Iterator resultIter = request.getAttribute("resultSet");
         
          while(resultIter.hasNext()){ 
          
          CartVO voObj = (CartVO)resultIter.next();
          Total=Total+ voObj.getPrice()+voObj.getDeliveryCharge(); */%> --%>
				<tr height="130px">
					<td><div class="col-md-2"></div>
						<div class="col-md-10">
							<div class="row">
								<s:property value="#product.productName" />
							</div>
							<div class="row">
								<s:property value="#product.colour" />
								,
								<s:property value="#product.size" />
							</div>

							<div class="row">
								Seller:<b><s:property value="#product.sellerName" /></b>
							</div>
							<div class="row remove ">
								<a href="removeCart?id=<s:property value="#product.productId"/>" id="uid" name="uid">REMOVE</a>
							</div>
						</div></td>
					<td><div class="col-md-2"><input style="display:none;" type="text"  title=<s:property value = "#product.productId"/>
								value=<s:property value = "#product.quantity"/> style = "text-align:center"size="1"></div>
						<div class="col-md-10">
							<input type="text" id=<s:property value = "#product.productId"/>
								value=<s:property value = "#product.quantity"/> style = "text-align:center"size="1">

							<button class="link_button" style="visibility: hidden"
								id="cart_quantity_static"
								name=<s:property value = "#product.productId"/>>
								<u>Save</u>
							</button>
						</div></td>
					<td><div class="col-md-2"></div>
						<div class="col-md-10">
							<b>Rs.<s:property value="#product.price"/></b>
							
						</div></td>
					<td><div class="col-md-1"></div> <%--  <% int flag = %> "%{#product.deliveryCharge}"<% 
       
 		if (flag==0) {%> --%> <s:if test="%{#product.deliveryCharge} == '0'">
							<div class="col-md-11">Free Delivery</div>
						</s:if> <s:else>
							<div class="col-md-11">
								Delivery Charges:Rs.
								<s:property value="#product.deliveryCharge" />
							</div>
						</s:else></td>
					<td><div class="col-md-0"></div>
						<div class="col-md-12">
							<b>Rs.<s:property value="#product.totalPrice" /></b>
						</div></td>
				</tr>

			</s:iterator>
		</table>
		
		<table width="75%">
			<tr height="50px">
				<th width="100%"><div class="col-md-8"></div>
					<div class="col-md-3 pull-right">
						<font size="3pt">Amount Payable: Rs.<s:property value="total" /></font>
					</div></th>

			</tr>
			<tr height="100px">
				<td>
					<div class="col-md-7"></div>
					<div class="col-md-5">
						
						<button class="addtocart continueshopping">&lt; CONTINUE
							SHOPPING</button>
						<a class="addtocart placeorder btn btn-warning" href="addCartToPlaceorder">PLACE ORDER</a>
					</div>
				</td>
			</tr>
			<tr height="55px">
				<td><img class="cartimg" src="/Flipkart/images/cart_footer_final.png" />
				</td>
			</tr>
		</table>
		

		<!-- #565656 -cart ka colour -->
	</center>
	</div>
</body>
</html>