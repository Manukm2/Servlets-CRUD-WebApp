<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="RegistrationCss.css">
</head>
<body>
	<div class="login-box">
		<h2>Registeration</h2>
		<form action="register" method="post">
			<div id="Manu">
				<div id="card1">
					<div class="user-box">
						<input type="email" class="in" name="id" required=""> <label>Email</label>
					</div>

					<div class="user-box">
						<input type="text" class="in" name="pas" required=""> <label>Password</label>
					</div>

					<div class="user-box">
						<input type="text" class="in" name="nm" required=""> <label>Name</label>
					</div>

					<div class="user-box">
						<input type="number" class="in" name="pn" required=""> <label>Phone</label>
					</div>

					<div class="user-box">
						<input type="text" class="in" name="co" required=""> <label>College</label>
					</div>

					<div class="manu">
						<label for="">Gender :</label> <input type="radio" name="ge"
							value="MALE">Male <input type="radio" name="ge"
							value="MALE">Female <input type="radio" name="ge"
							value="MALE">Other
					</div>

				</div>

				<div id="card2">

					<div class="user-box">
						<input type="text" class="in" name="de" required=""> <label>Department</label>
					</div>

					<div class="user-box">
						<input type="text" class="in" name="yr" required=""> <label>Pass
							Out Year</label>
					</div>

					<div class="user-box">
						<input type="text" class="in" name="teper" required=""> <label>10th
							Percentege</label>
					</div>

					<div class="user-box">
						<input type="text" class="in" name="twper" required=""> <label>12th
							Percentege</label>
					</div>

					<div class="user-box">
						<input type="text" class="in" name="deper" required=""> <label>Degree
							CGPA</label>
					</div>
					<div class="manu">
						<label for="">Select DataBase :</label> <input type="radio"
							name="db" value="a">SQL <input type="radio" name="db"
							value="b">Oracle
					</div>
				</div>
			</div>
			<div id="Manu1">
				<input type="submit" value="REGISTER" id="A"> <span></span>
				<span></span> <span></span> <span></span>
			</div>
	</div>
	</form>
	</div>
</body>
</html>