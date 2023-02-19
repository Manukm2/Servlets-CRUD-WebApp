<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel='stylesheet' href='ReadingCss.css'>
</head>
<body>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>
<%
			ResultSet rs = (ResultSet) request.getAttribute("rs");
			Connection con = (Connection) request.getAttribute("con");
			PreparedStatement pstmt = (PreparedStatement) request.getAttribute("pstmt");
			%>
<div class='login-box'>
<h1>Hi, </h1><br>
<table>
     <tr>
	<td><label class='A'>Email</label></td>
	<td><label class='B'>: </label></td>
     </tr>
     <tr>
	<td><label class='A'>Phone</label></td>
	<td><label class='B'>: </label></td>
      </tr>
	 <tr>
	<td><label class='A'>Department</label></td>
	<td><label class='B'>: </label></td>
	 </tr>
	<tr>
	<td><label class='A'>College</label></td>
	<td>  <label class='B'>: </label></td>
	</tr><br><br>
	<tr>
	<td><label class='A'>Year</label></td>
	<td><label class='B'>: </label></td>
	</tr>
	<tr>
	<td><label class='A'>10th Per</label></td>
	<td><label class='B'>: </label></td>
	</tr>
	<tr>
	<td><label class='A'>12th Per</label></td>
	<td><label class='B'>: </label></td>
	</tr>
	<tr>
	<td><label class='A'>DegreeCGPA</label></td>
	<td><label class='B'>: </label></td>
	</tr>
	<% finally {
		if (rs != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) 
		{
			try 
			{
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} %>
</table>
</div>
</div>
</body>
</html>