<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="org.iiitb.flipkart.cart.*"%>
	<%@ page import="org.iiitb.flipkart.login.*"%>
	<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/jquery.cookie.js"></script>

<title>Flipkart</title>

<script>
	$(document).ready(function() {
						$("#addcart").click(function() {

							
							
							<%if(session.getAttribute("mailID")==null)
							{%>
								
							var cookieValue;
							if($.cookie("CART_ITEMS_COUNT") == null)
							{
								cookieValue = 0;
								$.removeCookie('CART_ITEMS_COUNT');
							}
							else
							{
							   cookieValue = parseInt($.cookie("CART_ITEMS_COUNT"));
							   $.removeCookie('CART_ITEMS_COUNT');
							}
							cookieValue = cookieValue + 1;
							$.cookie('CART_ITEMS_COUNT',
									cookieValue.toString(), {
										expires : 7
									});
							cookieValue = $
									.cookie("CART_ITEMS_COUNT");

							// use of ajax to set text
							 $("#count").text(cookieValue); 
							/* window.alert(cookieValue); */

							var items = $.cookie("CART_ITEMS");
							 $.removeCookie('CART_ITEMS');
							 
							 
								if (items != "")
									items = items + ","+<%= request.getParameter("pid")%>+":1";
								else
									items =<%= request.getParameter("pid")%>+":1";

							$.cookie("CART_ITEMS", items, {
							expires : 7
						});
							// After clicking on "ADD TO CART" it should get disabled 
							this.disabled = "disabled";
							<%}
							
							else
								{%>
							
								
								$.post(
										'/Flipkart/cartAdditionOnSession',
										{
											id:<%=request.getParameter("pid")%>
										},
										function(jsonResponse) {
											msg = jsonResponse.message;
											
											
											$("#count").text(msg);
											
								
										});
								
								// After clicking on "ADD TO CART" it should get disabled 
							 		this.disabled = "disabled";
							 
							 
							
								<%}%>
									
								
							});
					});
	

</script>


</head>
<body>
<% 
			String cartProductId;
			String currentProductId = request.getParameter("pid");
			boolean addToCartFlag=true;%>

<s:if test="#session.mailID==null">

<%
			Cookie cookie[] = request.getCookies();
		for (Cookie temp : cookie) {
		
				if (temp.getName().equalsIgnoreCase("CART_ITEMS")) {
				    cartProductId = temp.getValue().toString();
				    cartProductId = cartProductId.replaceAll("%2C", ",").replaceAll("%3A",":");
					String prodId[] = cartProductId.split(",");
					
					for(int i=1;i<prodId.length;i++)
					{
						
						
						if(Integer.parseInt((prodId[i].split(":")[0]))==Integer.parseInt(currentProductId.toString()))
						{
							
							addToCartFlag=false;
						}
					}
				    
				
			}
		}
%>	

</s:if>
<s:else>
<%
				String loginId1 = String.valueOf(((User)session.getAttribute("User")).getLoginId());
				//String loginId1="1";
				
				CartDAO fetchCart1 = new CartDAOImpl();
				ArrayList<String> idList = (ArrayList<String>)fetchCart1.fetchCartId(loginId1);
				if(idList.contains(currentProductId))
					addToCartFlag=false;

%>
</s:else>





	<div class="col-md-2"></div>
	<div class="col-md-8">
		<div class="panel panel-default">
			<div class="panel-body" style="background: white;">

				<div class="col-md-4 col-md-offset-2 " align="center">
					<img width="250dp" style="min-height: 250dp" alt=""
						src="ImageAction?pid=<s:property value="pid"/>" />
				</div>
				<div class="col-md-4">

					<div class="row">
						<h2 style="display: inline; font-family: cursive;">
							<s:property value="pName" />
						</h2>
						<h3 style="color: silver; display: inline; font-family: cursive;">
							(
							<s:property value="pColour" />
							)
						</h3>
					</div>

					<br>
					<div class="row">
						<s:if test="hasKf">
							<div class="col-md-6" style="color: graytext;">
								<%
									int count2 = 0;
								%>
								<s:iterator value="kfList" var="a">
									<%
										if (count2 < 4) {
									%>
									<li><s:property value="a" /></li>
									<%
										}
												count2++;
									%>
								</s:iterator>

							</div>
						</s:if>
						<s:else>
							<div class="col-md-6">
								<br> <br> <br> <br>
							</div>
						</s:else>
						<div class="col-md-6">
							<b>WARRANTY </b> <br>
							<s:property value="pWarranty" />
							months
						</div>
					</div>

					<div class="row">
						<h2 style="font: lighter;">
							Rs.
							<s:property value="pPrice" />
						</h2>
					</div>

					
					
					
					<% if(addToCartFlag == true){%>
					<div class="row">
						<button type="button" class="btn btn-warning" id ="addcart">ADD TO CART</button>

					</div>
					<% }else{%>
					<div class="row">
						<button type="button" class="btn btn-warning" id ="addcart" disabled>ADD TO CART</button>

					</div>
					<%}%>

					<BR>
					<div class="row">
						<button type="button" class="btn btn-success"
							style="padding-left: 0.7cm; padding-right: 0.7cm">BUY
							NOW</button>

					</div>


				</div>


				<div class="col-md-2"></div>


				<div class="col-md-8 col-md-offset-2">
					<s:if test="hasKf">
						<hr
							style="height: 1px; border: none; color: #333; background-color: #333;" />
						<div class="row" style="margin-left: 20px">


							<h4 style="font-family: cursive;">
								<b>Key Features of <s:property value="pName" /> :
								</b>
							</h4>

							<s:iterator value="kfList" var="a">
								<li><s:property value="a" /></li>
							</s:iterator>


						</div>
					</s:if>
					<s:if test="hasDesc">
						<hr
							style="height: 1px; border: none; color: #333; background-color: #333;" />

						<div class="row" style="margin-left: 20px">

							<h4 style="font-family: cursive;">
								<b><s:property value="pName" /> : </b>
							</h4>

							<s:property value="desc" />


						</div>
					</s:if>
					<s:if test="hasSpecs">
						<hr
							style="height: 1px; border: none; color: #333; background-color: #333;" />
						<div class="row" style="margin-left: 20px">
							<h4 style="font-family: cursive;">
								<b>Specifications of <s:property value="pName" /> (<s:property
										value="pColour" />):
								</b>
							</h4>


							<table class="table table-bordered">

								<tbody>

									<tr>
										<th colspan="2"><h4 style="background-color: #aaaaaa;">General
												Features :</h4></th>
									</tr>
									<s:iterator value="specPairs" var="a">
										<%
											String spec = request.getAttribute("a").toString();
													String[] parts = spec.split(" : ");
										%>
										<tr>
											<td><%=parts[0]%></td>
											<td><%=parts[1]%></td>

										</tr>
									</s:iterator>


								</tbody>
							</table>
						</div>
					</s:if>
				</div>
			</div>


		</div>
	</div>
	<div class="col-md-2"></div>

	<br>
</body>
</html>