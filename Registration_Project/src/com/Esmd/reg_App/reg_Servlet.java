package com.Esmd.reg_App;

import java.io.IOException;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class reg_Servlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Store the value in the ArrayList to Verify it,not present null value;
		Enumeration<String> el = req.getParameterNames();
		ArrayList<String> al = new ArrayList<String>();
		RequestDispatcher dispatcher = null;
		while (el.hasMoreElements()) {
			al.add(req.getParameter(el.nextElement()));
		}
		boolean tr = check(al);
		if (tr) {
			// getting UI/FORM data from register.html
			String emailid = req.getParameter("id");
			String name = req.getParameter("nm");
			Long phone = Long.parseLong(req.getParameter("pn"));
			String college = req.getParameter("co");
			String dept = req.getParameter("de");
			int year = Integer.parseInt(req.getParameter("yr"));
			double tenperc = Double.parseDouble(req.getParameter("teper"));
			double twperc = Double.parseDouble(req.getParameter("twper"));
			double degperc = Double.parseDouble(req.getParameter("deper"));
			String pass = req.getParameter("pas");
			String gender = req.getParameter("ge");
			String Database = req.getParameter("db");

			if (Database != null) {
				ServletConfig conf = getServletConfig();
				String url = "", dr = "", qry1 = "", qry2 = "", user = "", passw = "";

				if (Database.equals("a")) {// My SQL
					url = conf.getInitParameter("url1");
					dr = conf.getInitParameter("dr1");
					qry1 = "select email,pass from btm.crud where email=? or pass=?";
					qry2 = "insert into btm.crud values(?,?,?,?,?,?,?,?,?,?,?)";
				} else if (Database.equals("b")) {// Oracle
					url = conf.getInitParameter("url2");
					dr = conf.getInitParameter("dr2");
					user = conf.getInitParameter("user");
					passw = conf.getInitParameter("pass1");
					qry1 = "select email,pass from crud where email=? or pass=?";
					qry2 = "insert into crud values(?,?,?,?,?,?,?,?,?,?,?)";
				}
				// storing to DATABASE
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					Class.forName(dr);
					if (Database.equals("a"))
						con = DriverManager.getConnection(url);
					else
						con = DriverManager.getConnection(url, user, passw);
					pstmt = con.prepareStatement(qry1);
					pstmt.setString(1, emailid);
					pstmt.setString(2, pass);
					rs = pstmt.executeQuery();
					// check if for already present Using ResultSet
					if (rs.next() == false) {
						pstmt = con.prepareStatement(qry2);
						pstmt.setString(1, emailid);
						pstmt.setString(2, name);
						pstmt.setLong(3, phone);
						pstmt.setString(4, college);
						pstmt.setString(5, dept);
						pstmt.setInt(6, year);
						pstmt.setDouble(7, tenperc);
						pstmt.setDouble(8, twperc);
						pstmt.setDouble(9, degperc);
						pstmt.setString(10, gender);
						pstmt.setString(11, pass);
						pstmt.execute();
						dispatcher = req.getRequestDispatcher("Congradulaton.jsp");
					} else {
						dispatcher = req.getRequestDispatcher("AlreadyRegistered.jsp");
					}
				} catch (ClassNotFoundException | SQLException e) {
					System.out.println(e);
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
				dispatcher = req.getRequestDispatcher("SelectDatabase.jsp");
			}

		} else {
			dispatcher = req.getRequestDispatcher("FillAllFieldsRegister.jsp");
		}
		dispatcher.forward(req, res);
	}

	private boolean check(ArrayList<String> al) {
		for (String i : al) {
			if (i.equals("")) {
				return false;
			}
		}
		return true;
	}
}
