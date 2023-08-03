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

@WebServlet("/checkBalance")
public class checkBalance extends HttpServlet{
	


	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		int accno=(int) session.getAttribute("accno");
		

		String url = "jdbc:mysql://localhost:3306/test25";

		String user = "root";

		String pwd = "Vipul@8800";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			pstmt = con.prepareStatement("Select balance from bankapp where accno=?");
			pstmt.setInt(1, accno);

			
			resultSet= pstmt.executeQuery();
			
			if(resultSet.next()==true) {
				session.setAttribute("balance",resultSet.getInt("balance"));

				resp.sendRedirect("/BankingAppProject/balance.jsp");
			}
			else {
				resp.sendRedirect("/BankingAppProject/balanceFail.jsp");

			}
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	

}
