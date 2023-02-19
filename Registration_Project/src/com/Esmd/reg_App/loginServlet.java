package com.Esmd.reg_App;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class loginServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("em");
		String password = req.getParameter("ps");
		RequestDispatcher dispatcher = null;

		if ((password == "" && email == "") == false) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String qry = "select * from btm.crud where email=? and pass=?";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
				pstmt = con.prepareStatement(qry);
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					req.setAttribute("con", con);
					req.setAttribute("pstmt", pstmt);
					req.setAttribute("rs", rs);
					dispatcher = req.getRequestDispatcher("Reading.jsp");
					dispatcher.forward(req, res);
				} else {
					dispatcher = req.getRequestDispatcher("NotRegistered.jsp");
					dispatcher.forward(req, res);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} finally {
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
				if (pstmt != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			dispatcher = req.getRequestDispatcher("FillAllFieldsLogin.jsp");
		}
		dispatcher.forward(req, res);
	}
}