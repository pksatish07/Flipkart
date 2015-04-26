<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
<%ResultSet resultset1 =null;%>
<%ResultSet resultset3 =null;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<style>
.nav,
.nav a3,
.nav ul,
.nav li3,
.nav div,
.nav form,
.nav input {
    margin: 0;
    padding: 0;
    border: none;
    outline: none;
}
 
.nav a3 { text-decoration: none; 
			color:Black;}
 
.nav li3 { list-style: none; }

.nav {
    display: inline-block;
    position: relative;
    cursor: default;
    z-index: 500;
}
 
.nav > li3 {
    display: block;
    float: left;
}

.nav > li3 > a3 {
    position: relative;
    display: block;
    z-index: 510;
    height: 40px;
    padding: 0 10px;
    line-height: 54px;
 
    font-family: Helvetica, Arial, sans-serif;
    font-weight: bold;
    font-size: 13px;
    color: #fcfcfc;
    text-shadow: 0 0 1px rgba(0,0,0,.35);
 
    background: #003366;
    border-left: 1px solid #3366CC;
    border-right: 1px solid #312a27;
 
    -webkit-transition: all .3s ease;
    -moz-transition: all .3s ease;
    -o-transition: all .3s ease;
    -ms-transition: all .3s ease;
    transition: all .3s ease;
}

.nav > li3:hover > a3 { background: #ffffff;
color:#000000; }
 
.nav > li3:first-child > a3 {
    border-radius: 3px 0 0 3px;
    border-left: none;
}


.nav > li3 > div {
    position: absolute;
    display: block;
    width: 100%;
    
    left: 0;
 
    opacity: 0;
    visibility: hidden;
    overflow: hidden;
 
    background: #F8F8FF;
    border-radius: 0 0 3px 3px;
 
/*   -webkit-transition: all .3s ease .15s;
    -moz-transition: all .3s ease .15s;
    -o-transition: all .3s ease .15s;
    -ms-transition: all .3s ease .15s;
    transition: all .3s ease .15s; */
}

.nav > li3:hover > div {
    opacity: 1;
    visibility: visible;
    overflow: visible;
     width: 100%;
}


.nav .nav-column {
    float: left;
    width: 30%;
    padding: 2.5%;
}
 
.nav .nav-column h3 {
    margin: 20px 0 10px 0;
    line-height: 18px;
 
    font-family: Helvetica, Arial, sans-serif;
    font-weight: bold;
    font-size: 14px;
    color: #372f2b;
    text-transform: uppercase;
}
 
.nav .nav-column h3.orange { color: #ff722b; }
 
.nav .nav-column li3 a3 {
    display: block;
    line-height: 26px;
 
    font-family: Helvetica, Arial, sans-serif;
    font-weight: bold;
    font-size: 13px;
    color: #888888;
}


 
.nav .nav-column li3 a3:hover { color: #000000; }
.flip_nav1
{
background: #003366;
height:40px;
	
	}
</style>
<script src="bootstrap/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	
	$(".navlink").hover(function(){
		$(".navlink").css("color","gray");
	});
});
 
 </script>
</head>


<body>

<!-- <div style="background-color:#003366" > -->
<%
    try{
    	
//Class.forName("com.mysql.jdbc.Driver").newInstance();
Class.forName("com.mysql.jdbc.Driver");
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost/flipkart","root","root");

       Statement statement = connection.createStatement() ;
       Statement statement1 = connection.createStatement() ;
       Statement statement3 = connection.createStatement() ;
       resultset =statement.executeQuery("select cat_name from category where cat_level=0 ") ;		
%>
<div class="flip_nav1">
<center style="
    position: relative;
    right: 500px;
">
        <ul class="nav">
        
        <%  while(resultset.next()){ %>
       <li3><a3 href="#"><%= resultset.getString(1)%> <span class="glyphicon glyphicon-chevron-down"></span></a3>
       <% String temp=resultset.getString(1);
       String query2="SELECT category_id from category where cat_name='"+temp+"'";
       
		//temp=temp.toUpperCase();
		//PreparedStatement ps = connection.prepareStatement(query2);
		Statement stmt = connection.createStatement();
	   // ps.setString(1, "%" + temp + "%");
		ResultSet rs = stmt.executeQuery(query2);
		int id = 0; 
		while(rs.next()){
	          id  = rs.getInt("category_id");
		}
		resultset1 =statement1.executeQuery("select cat_name from category where cat_parent="+id) ;
		%>
		<div>
	 
        <%  while(resultset1.next()){ 
        int i=0;
        if(i%2==0){%>
        
 <div class="nav-column">
 <%}  %>

    		<h3><a3 href="displayProduct?product=<%= resultset1.getString(1) %>"><%= resultset1.getString(1)%></a3></h3>
    		   
    		 <%i++; 
    		 String temp3=resultset1.getString(1);
       String query3="SELECT category_id from category where cat_name='"+temp3+"'";
		//temp3=temp3.toUpperCase();
		//PreparedStatement ps3 = connection.prepareStatement(query3);
	    //ps3.setString(1, "%" + temp3 + "%");
	    Statement stmt1 = connection.createStatement();
		ResultSet rs3 = stmt1.executeQuery(query3);
		int id3 = 0; 
		while(rs3.next()){
	          id3  = rs3.getInt("category_id");      
		}
		resultset3 =statement3.executeQuery("select cat_name from category where cat_parent="+id3) ;
		%>
		<ul>
		<%  while(resultset3.next()){%>
		<li3><a style="color:gray;" class="navlink" href="displayProduct?product=<%= resultset3.getString(1)  %>"><b><%= resultset3.getString(1)%></b></a></li3>
	 <% } %>
	 </ul>
		 </div>
    <% } %> </div></li3>
        <% } %>
        </ul>
 
<%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>
</center>
</div>
</body>
</html>