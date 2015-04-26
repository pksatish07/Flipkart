<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >

  <div align="center">
  <br>
  <br>
  <h4>CHECK BALANCE</h4>
 
 
 
  <form action="accountAction" method="POST"  >
    <label >Account no :</label>
  
 
 
 
 
 
  <input type="text" name ="accountId"/>
   
    
      <div style="position:relative;left:200px;">
    <input type="submit" value="Check Amount" class="btn btn-default">
   </div>
   <s:property value="amountAcc"/>
  </form>
  
  
  <br/>
  <br/>
  <br/>
  
  <br/>
  <br/>

  <br/>
  <form action="creditAction" method="POST">
     <label style="position: relative;
right: 10px;">Credit Card no :</label>
    <input type="text" name = "creditId" style="position: relative;
right: 10px;"/>
  
   
    
    <div style="position:relative;left:200px;">
    <input type="submit" value="Check Amount" class="btn btn-default" >
   </div>
   
   <s:property value="amountCrd"/>
  </form>
   </div>

</body>
</html>
