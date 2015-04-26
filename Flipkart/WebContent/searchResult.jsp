<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<title>Welcome</title>

<style type="text/css">
.panel {
	width: 300px;
	height: 350px;
}

.table-condensed>tbody>tr>td,.table-condensed>tbody>tr>th,.table-condensed>tfoot>tr>td,.table-condensed>tfoot>tr>th,.table-condensed>thead>tr>td,.table-condensed>thead>tr>th
	{
	border: medium none;
}

div.transbox {
	
	background-color: #ffffff;
	opacity: 0.5;
	filter: alpha(opacity = 30); /* For IE8 and earlier */
}



div.transbox p {
	margin: 5%;
	font-weight: bold;
	color: #000000;
}

.img-responsive {
    margin: 0 auto;
	position:relative;
	padding-top:20px;    
}


</style>
</head>
<body>
	<div align="center">
<!-- 
		<div class="well" align="center">
			<p class="lead">Product Information</p>
		</div> -->
		<div class="container-fluid">
			<div class="row">
				<div class="row">
					<!-- <button type="button" class="btn btn-default btn-lg"
								onclick="window.location='ltoh'"
								style="background-color: blue; color: white;">sort low to high</button>
				<button type="button" class="btn btn-default btn-lg"
								onclick="window.location='htol'"
								style="background-color: blue; color: white;">Sort High to low</button>
				</div> -->

					<br />

					<div class="col-md-3">
						<s:if test="showFilter">
							<h3 >SORT BY</h3>
							<s:if test="isAllDisplayed">
								<h4>
									<a
										href="sortProductByDesc.action?product=<s:property value="product"/>"
										style="color: #0000ff;">Highest Price</a>
								</h4>
								<h4>
									<a
										href="sortProductByAsc.action?product=<s:property value="product"/>"
										style="color: #0000ff;">Lowest Price</a>
								</h4>
							</s:if>
							<s:else>
								<h4>
									<a
										href="sortProductInRangeByDesc.action?input=<s:property value="product"/>:<%=request.getAttribute("index")%>:<%=request.getAttribute("filterOptions").toString()%>"
										style="color: #0000ff;">Highest Price</a>
								</h4>
								<h4>
									<a
										href="sortProductInRangeByAsc.action?input=<s:property value="product"/>:<%=request.getAttribute("index")%>:<%=request.getAttribute("filterOptions").toString()%>"
										style="color: #0000ff;">Lowest Price</a>
								</h4>
							</s:else>
							<BR>
							<h3 >FILTER BY PRICE</h3>
							<h4>
								<a
									href="displayProduct.action?product=<s:property value="product"/>"
									style="color: #0000ff;">Clear</a>
							</h4>
							

								<%
									String parts[] = request.getAttribute("filterOptions.get(0)")
												.toString().split(":");
								%><input
									type="radio" name="selectedOption"
									<%if (Integer.parseInt(request.getAttribute("index").toString()) == 0) {%>
									checked="checked" <%}%>
									value="<%=request.getAttribute("filterOptions.get(0)")
						.toString().replace(" ", "")
						+ ":"
						+ request.getAttribute("product")
						+ ":0:"
						+ request.getAttribute("filterOptions").toString()%>"
									id="option1" onclick="onOptionSelect(<%=1%>)">
								<h4 style="display: inline"><%=parts[0]%></h4>
								<h5 style="color: gray; display: inline;">
									<%=parts[1]%></h5>
								<br>
								<%
									parts = request.getAttribute("filterOptions.get(1)").toString()
												.split(":");
								%><input
									type="radio" name="selectedOption"
									<%if (Integer.parseInt(request.getAttribute("index").toString()) == 1) {%>
									checked="checked" <%}%>
									value="<%=request.getAttribute("filterOptions.get(1)")
						.toString().replace(" ", "")
						+ ":"
						+ request.getAttribute("product")
						+ ":1:"
						+ request.getAttribute("filterOptions").toString()%>"
									id="option2" onclick="onOptionSelect(2)">
								<h4 style="display: inline"><%=parts[0]%></h4>
								<h5 style="color: gray; display: inline;">
									<%=parts[1]%></h5>
								<br>
								<%
									parts = request.getAttribute("filterOptions.get(2)").toString()
												.split(":");
								%><input
									type="radio" name="selectedOption"
									<%if (Integer.parseInt(request.getAttribute("index").toString()) == 2) {%>
									checked="checked" <%}%>
									value="<%=request.getAttribute("filterOptions.get(2)")
						.toString().replace(" ", "")
						+ ":"
						+ request.getAttribute("product")
						+ ":2:"
						+ request.getAttribute("filterOptions").toString()%>"
									id="option3" onclick="onOptionSelect(3)">
								<h4 style="display: inline"><%=parts[0]%></h4>
								<h5 style="color: gray; display: inline;">
									<%=parts[1]%></h5>
								<br>
								<%
									parts = request.getAttribute("filterOptions.get(3)").toString()
												.split(":");
								%><input
									type="radio" name="selectedOption"
									<%if (Integer.parseInt(request.getAttribute("index").toString()) == 3) {%>
									checked="checked" <%}%>
									value="<%=request.getAttribute("filterOptions.get(3)")
						.toString().replace(" ", "")
						+ ":"
						+ request.getAttribute("product")
						+ ":3:"
						+ request.getAttribute("filterOptions").toString()%>"
									id="option4" onclick="onOptionSelect(4)">
								<h4 style="display: inline"><%=parts[0]%></h4>
								<h5 style="color: gray; display: inline;">
									<%=parts[1]%></h5>
								<br>
								<%
									parts = request.getAttribute("filterOptions.get(4)").toString()
												.split(":");
								%><input
									type="radio" name="selectedOption"
									<%if (Integer.parseInt(request.getAttribute("index").toString()) == 4) {%>
									checked="checked" <%}%>
									value="<%=request.getAttribute("filterOptions.get(4)")
						.toString().replace(" ", "")
						+ ":"
						+ request.getAttribute("product")
						+ ":4:"
						+ request.getAttribute("filterOptions").toString()%>"
									id="option5" onclick="onOptionSelect(5)">
								<h4 style="display: inline"><%=parts[0]%></h4>
								<h5 style="color: gray; display: inline;">
									<%=parts[1]%></h5>
								<br>
								<%
									parts = request.getAttribute("filterOptions.get(5)").toString()
												.split(":");
								%><input
									type="radio" name="selectedOption"
									<%if (Integer.parseInt(request.getAttribute("index").toString()) == 5) {%>
									checked="checked" <%}%>
									value="<%=request.getAttribute("filterOptions.get(5)")
						.toString().replace(" ", "")
						+ ":"
						+ request.getAttribute("product")
						+ ":5:"
						+ request.getAttribute("filterOptions").toString()%>"
									id="option6" onclick="onOptionSelect(6)">
								<h4 style="display: inline"><%=parts[0]%></h4>
								<h5 style="color: gray; display: inline;">
									<%=parts[1]%></h5>
								<br>

						
						</s:if>

					</div>

					<div class="col-md-8" align="center">

						<div class="row">

							<table class="table table-responsive table-hover table-condensed">

								<%
									int i = 0;
								%>
								<s:iterator value="productInfo" var="p">
									<%
										if (i % 3 == 0) {
									%>
									<tr>
										<%
											}
										%>

										<td>
										<s:if test="!#p.isThereStock">
										<div class="panel panel-default transbox" align = "center">
												<center>
													<a  title="OUT OF STOCK"
														href="getproductAction?pid=<s:property value="#p.productId"/>"><img
														width="150" height="250" class ="img-responsive center-block"
														src="imageAction?productId=<s:property value="#p.productId"/>" style="text-align:center;" /></a>
												</center>
												<br />
												<center>
													<s:property value="#p.productName"></s:property>
												</center>
												<br />
												<center>
													Price:
													<s:property value="#p.productPrice"></s:property>
												</center>
											</div>
											</s:if>
											<s:else>
											<div class="panel panel-default" align = "justify">
												<center>
													<a
														href="getproductAction?pid=<s:property value="#p.productId"/>"><img
														width="150" height="250" class ="img-responsive"
														src="imageAction?productId=<s:property value="#p.productId"/>" /></a>
												</center>
												<br />
												<center>
													<s:property value="#p.productName"></s:property>
												</center>
												<br />
												<center>
													Price:
													<s:property value="#p.productPrice"></s:property>
												</center>
											</div>
											</s:else></td>
										<%i++; %>
										<%if(i%3==0 && i!=0){
								%>
									</tr>
									<%
								}
								%>


								</s:iterator>
							</table>

						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function onOptionSelect(i) {
			//document.getElementById("courseDisplayChoice").selectedIndex = 0;
			window.location = 'displayProductsInRange.action?selectedOption='+document.getElementById("option"+i).value;
		};
		</script>

	<script>
$(document).ready(function(){
    $("a").mouseenter(function(){
        $(this).css("color","#000077");
    });
    $("a").mouseleave(function(){
        $(this).css("color","#0000ff");
    });
});
</script>

</body>
</html>