package com.digit.bankProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/changePin")
public class changePin extends HttpServlet {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession();
		int accno=(int) session.getAttribute("accno");
		int pin = Integer.parseInt(req.getParameter("pin"));
		int New_Pin = Integer.parseInt(req.getParameter("New_Pin"));
		int Confirm_Pin = Integer.parseInt(req.getParameter("Confirm_Pin"));


		String url = "jdbc:mysql://localhost:3306/test25";

		String user = "root";

		String pwd = "Vipul@8800";
		
		if(New_Pin==Confirm_Pin) {
			
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			pstmt = con.prepareStatement("update bankapp set pin=? where accno=? and pin=?");
			pstmt.setInt(1, New_Pin);
			pstmt.setInt(2, accno);
			pstmt.setInt(3, pin);
			
			

			
			int x= pstmt.executeUpdate();
			
			if(x>0) {
				//session.setAttribute("balance",resultSet.getInt("balance"));

				resp.sendRedirect("/BankingAppProject/pinChangeSuccess.html");
			}
			else {
				resp.sendRedirect("/BankingAppProject/pinChangeSuccessFail.html");

			}
			
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		}
		
		else {
			resp.sendRedirect("/BankingAppProject/pinChangeSuccessFail.html");
		}
			
	}
	

}
