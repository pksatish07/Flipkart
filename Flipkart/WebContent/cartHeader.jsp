<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<link rel="stylesheet" href="font-awesome-4.3.0/css/font-awesome.min.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">


<!-- Latest compiled JavaScript -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

<link rel="stylesheet" href="styles.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="js/script.js"></script>
   <script src="bootstrap/js/bootstrap-hover-dropdown.min.js"></script>
<title>Insert title here</title>
<style>
#example1 {
    background: url(images/r1.png) no-repeat;
    padding: 15px;
    background-size:auto;
}
.test{
background:url(images/r1.png) no-repeat;
color:#f9f9f9;}

#flip_nav {
    background:url(images/r4.png) 150px top no-repeat,url(images/r1.png) left top repeat;
    padding: 15px;

    background-size:contain,auto;
}

#flip_nav2{
	background:url(images/r5.png) left top repeat;
	padding: 15px;

    background-size:auto;
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
}

li {
 
    
}
li1{
float:left;
position: relative;
    left: 1200px;
}
a {
    display: block;
    padding: 5px;
    width: auto;
    color: #FFFFFF;
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

.container-1 input#search{
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

.container-1 input#button{
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

.container-1 input#button2{
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
  top: 50%;
  margin-left: 13px;
  margin-top: 13px;
  z-index: 1;
  color: #4f5b66;
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
  
  .dropdown
  {
  
  position: relative;
    left: 1200px;
    
  }
  .nav {
    display: inline-block;
    position: relative;
    cursor: default;
    z-index: 500;
}
.nav > li:hover > a { background: #ffffff;
color:#000000; }
li:hover span{  background-color:#78a802; color:green; display:block} 
li:hover div{  background-position: -5px -120px; color:green}
</style>
<script>$('.dropdown-toggle').dropdownHover();
</script>

</head>
<body>
<div id="flip_nav"> 
<%! int flag = 1;%>
 <%if (flag==0) {%>
   <ul>
  <li1><a href="#home">Signup</a></li1>
  <li1><a>|</a></li1>
  <li1><a href="#news">Login</a></li1>

  </ul>
  <%} 	else		{%>
   <div class="dropdown">
        <button class="btn test dropdown-toggle" type="button" id="menu1" data-toggle="dropdown" href="#">Hi Ganesh!<span class="caret"></span></button>
         <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
          <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Account</a></li>
          <li role="presentation" class="divider"></li>
          <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Orders</a></li>
          <li role="presentation" class="divider"></li>
          <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Recommendations</a></li>
          <li role="presentation" class="divider"></li>
          <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Logout</a></li>
        </ul>
     </div>
<%} %>

  <div class="container-1 ">
      <span class="icon"><i class="fa fa-search"></i></span>
      <input type="search" id="search" placeholder="Search for a product,category or brand" />
 
  </div>
  <div class="container-1 ">
      <input type="button" id="button" value="SEARCH">

  </div>
 
 



</div>
<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>