<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<sx:head />
<head>
<!-- <META HTTP-EQUIV="Refresh" CONTENT="0;URL=autoComplete.action"> -->
<title>Auto complete</title>
</head>
<body>
<h3>Auto complete Dropdown   |  Textbox</h3>
<s:form action="displayProduct">
<sx:autocompleter name="product" list="products" showDownArrow="false" label="Search for Product" autoComplete="false" dropdownHeight="720"/>

  <%-- <sx:autocompleter name="country" list="cricketNations" showDownArrow="false" 
     label="Cricket Nations"/> --%>
 <s:submit />
</s:form>
</body>
</html>