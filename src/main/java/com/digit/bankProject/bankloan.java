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

@WebServlet("/bankloan")
public class bankloan extends HttpServlet {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
        String ltype=req.getParameter("ltype");
		String url = "jdbc:mysql://localhost:3306/test25";

		String user = "root";

		String pwd = "Vipul@8800";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		con = DriverManager.getConnection(url, user, pwd);
		pstmt = con.prepareStatement("Select * from loan where ltype=?");
		pstmt.setString(1,ltype);
		resultSet =pstmt.executeQuery();
		
		if(resultSet.next()==true) {
			session.setAttribute("lid",resultSet.getInt("lid"));
			session.setAttribute("ltype",resultSet.getString("ltype"));
			session.setAttribute("tenure",resultSet.getInt("tenure"));
			session.setAttribute("intrest",resultSet.getInt("intrest"));
			session.setAttribute("description",resultSet.getString("description"));


			resp.sendRedirect("/BankingAppProject/loanDetail.jsp");
		}
		else {
			resp.sendRedirect("/BankingAppProject/loanDetailFail.html");

		}
		
		
		}
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	

}
