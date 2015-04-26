<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<link rel="stylesheet" href="font-awesome-4.3.0/css/font-awesome.min.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.2.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

<link rel="stylesheet" href="styles.css">
   
   <script src="js/script.js"></script>
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
  <%-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> --%>
<title>Insert title here</title>

 <Script>
$(document).ready(function(){
   
	  $("#testing2").click(function(){   
	$("#testing1").hide();
	$("#testing2").hide();
	  });   
}); 
</Script>


<style>
.example1 {
    background: url(images/r1.png) no-repeat;
    padding: 15px;
    background-size:auto;
}
.flip_nav {
    background:url(images/r4.png) 80px top no-repeat,url(images/r1.png) left top repeat;
    padding: 1px;

    background-size:contain,auto;
}

.flip_nav2{
	background:url(images/r5.png) left top repeat;
	padding: 15px;

    background-size:auto;
}

.ul2 {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
}

.li2 {
    float: left;
     position: relative;
    left: 500px;
    
}

.a2 {
    display: block;
    padding: 5px;
    width: auto;
    color: #FFFFFF;
    overflow:visible;
}
.box{
  
  width: 300px;
  height: 50px;
}

.container-1{
  width: 300px;
  vertical-align: middle;
  white-space: nowrap;
  position: relative;
}

.search{
position: relative;
    left: 500px;
  width: 500px;
  height: 40px;
  
  border: none;
  font-size: 10pt;
  float: left;
  color: #63717f;
  padding-left: 45px;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  border-radius: 5px;
  
}

.button{
position: relative;
    left: 500px;
  width: 100px;
  height: 40px;
  border: none;
  font-size: 10pt;
  color: #63717f;
  font-weight: bold;
  background: #FFD700;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  border-radius: 5px;
}

.button2{
position: relative;
    left: 500px;
  width: 100px;
  height: 40px;
  border: none;
  font-size: 10pt;
  color: #ffffff;
  
  background: url(images/r3.png) left top repeat;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  border-radius: 5px;
}

.container-1 input#search::-webkit-input-placeholder {
   color: #65737e;
}
 
.container-1 input#search:-moz-placeholder { /* Firefox 18- */
   color: #65737e;  
}
 
.container-1 input#search::-moz-placeholder {  /* Firefox 19+ */
   color: #65737e;  
}
 
.container-1 input#search:-ms-input-placeholder {  
   color: #65737e;  
}
.container-1 .icon{
position: relative;
    left: 500px;
  position: absolute;
  margin-left: 13px;
  margin-top: 13px;
  z-index: 1;
  color: #4f5b66;
}

a:hover{
color:white;
}

.gantagly
{
color:yellow;
}


.container-1 .icon2{
    
    left: 1100px;
  position: absolute;

  margin-left: 5px;
  margin-top: 5px;
  z-index: 1;
  color: #4f5b66;
}
.container-1 input#search:hover, .container-1 input#search:focus, .container-1 input#search:active{
    outline:none;
    background: #ffffff;
  }
.placeholder
{
  left: 525px;
position: absolute;
margin-left: 13px;
margin-top: 13px;
z-index: 1;
color: #4F5B66;

}
.padding{
font-size:10pt;
vertical-align:text-bottom;}
.testgly
{
font-size:18px;}
</style>
<script>
$(document).ready(function(){
    $("a").mouseover(function(){
        $(this).css('color','white');
    });
});
</script>
<sx:head />
</head>
<body>
<form name=termDDL>
<% 
	String cartCount=String.valueOf(0);
	Cookie cookie[] = request.getCookies();
	for(Cookie temp:cookie)
	{
		if(temp.getName().equalsIgnoreCase("CART_ITEMS_COUNT"))
		{
			cartCount = temp.getValue();
		}
		
	}
		 %>
<div class="flip_nav"> 
<ul class="ul2">
  <li class="li2"><a class="a2" class="a2" href="#home">Flipkart First</a></li>
  <li class="li2"><a class="a2">|</a></li>
  <li class="li2"><a class="a2" href="#news">Download App</a></li>
  <li class="li2"><a class="a2">|</a></li>
  <li class="li2"><a class="a2" href="#contact">Sell</a></li>
  <li class="li2"><a class="a2">|</a></li>
  <li class="li2"><a class="a2" href="#about">24x7 Customer Care</a></li>
  <li class="li2"><a class="a2">|</a></li>
  <li class="li2"><a class="a2" href="#about"><span class="icon2"><i class="glyphicon glyphicon-map-marker"></i> </span></a></li>
  <li class="li2"><a class="a2" href="#about">Track Order</a></li>
  <li class="li2"><a class="a2">|</a></li>
  <li class="li2"><a class="a2" href="#about"><span class="icon2"><i class="glyphicon glyphicon-bell gantagly"></i> </span></a></li>
  <li class="li2"><a class="a2">|</a></li>
  <li class="li2"><a class="a2" href="#about">Sign up</a></li>
  <li class="li2"><a class="a2">|</a></li>
  <li class="li2"><a class="a2" href="#about">Login</a></li>
  
</ul>
<div class="box">
  <div class="container-1 ">
      <span class="icon" id="testing1"><i class="glyphicon glyphicon-search"></i></span>
      <span class="placeholder" id="testing2"> Search for a product,category or brand</span> 
     
      <!-- <input type="search" class="search" placeholder="Search for a product,category or brand" />  -->
     <div id="testing">
      <sx:autocompleter name="product" list="products" showDownArrow="false" onselect="onTermChange()" cssClass="search" autoComplete="false" dropdownHeight="720"/>
     </div>
     </div>
  
  <div class="container-1 ">
  <input type="button" class="button" value="SEARCH" onclick="onTermChange()">
 <!--   <span class="icon2"><i class="fa fa-shopping-cart fa-2x"></i> </span>
  <input type="button" class="button2" value="CART" color="#FFFFF">-->
  <button class="btn btn-primary button2">

		<span class="glyphicon glyphicon-shopping-cart testgly"></span> <span
			class=padding>CART</span> <span style="vertical-align: middle">
			<svg width="20" height="20"> <g> <circle cx="9" cy="11"
				r="9" fill="white"></circle> <text x="5" y="14"
				font-family="Verdana" font-size="8" font-align="left" fill="blue" id="count"> <%= cartCount %> </text> </g> </svg>
		</span>
	</button>
  </div>
  
</div>
</div>
 
</form>
<script type="text/javascript">
		function onTermChange() {
			//document.getElementById("courseDisplayChoice").selectedIndex = 0;
			document.termDDL.action = 'displayProduct.action';
			document.termDDL.submit();
		}
		</script> 
</body>
</html>