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

@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res1;
	private ResultSet res2;
	private ResultSet res3;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		int cust_id = Integer.parseInt(req.getParameter("cust_id"));
		String bank_name = req.getParameter("bank_name");

		String ifsc = req.getParameter("ifsc");

		int sender_accno = Integer.parseInt(req.getParameter("sender_accno"));
		String Receiver_ifsc = req.getParameter("receiver_ifsc");
		int Receiver_accno = Integer.parseInt(req.getParameter("Receiver_accno"));

		int pin = Integer.parseInt(req.getParameter("pin"));

		int amount = Integer.parseInt(req.getParameter("amount"));

		String url = "jdbc:mysql://localhost:3306/test25";

		String user = "root";

		String pwd = "Vipul@8800";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pwd);

			pstmt = con.prepareStatement("Select * from bankApp where cust_id=? and ifsc_code=? and accno=? and pin=?");
			pstmt.setInt(1, cust_id);
			pstmt.setString(2, ifsc);
			pstmt.setInt(3, sender_accno);
			pstmt.setInt(4, pin);

			res1 = pstmt.executeQuery();
			// Sender (Customer Id , IfSc code ,account number , pin )authenticated
			if (res1.next() == true) {
				pstmt = con.prepareStatement("Select * from BankApp where ifsc_code=? and accno=?");
				pstmt.setString(1, Receiver_ifsc);
				pstmt.setInt(2, Receiver_accno);
				res2 = pstmt.executeQuery();

				// Reciever IFSC & Account number got autenticated
				if (res2.next() == true) {
					pstmt = con.prepareStatement("Select balance from BankApp where accno=?");
					pstmt.setInt(1, sender_accno);
					res3 = pstmt.executeQuery();
					res3.next();
					int bal = res3.getInt(1);
					// Sender balance is checked whethere sufficent or not
					if (bal > amount) {
						pstmt = con.prepareStatement("Update BankApp set balance=balance-? where accno=?");
						pstmt.setInt(1, amount);
						pstmt.setInt(2, sender_accno);
						int x1 = pstmt.executeUpdate();
						// amount debited from sender
						if (x1 > 0) {
							pstmt = con.prepareStatement("Update BankApp set balance=balance + ? where accno=?");
							pstmt.setInt(1, amount);
							pstmt.setInt(2, Receiver_accno);
							int x2 = pstmt.executeUpdate();
							// Amount is credited to the receiver
							if (x2 > 0) {
								pstmt = con.prepareStatement("Insert into transferstatus values(?,?,?,?,?,?,?)");
								pstmt.setInt(1, cust_id);
								pstmt.setString(2, bank_name);
								pstmt.setString(3, ifsc);
								pstmt.setInt(4, sender_accno);
								pstmt.setString(5, Receiver_ifsc);
								pstmt.setInt(6, Receiver_accno);
								pstmt.setInt(7, amount);
								// Store transactional details
								int x3 = pstmt.executeUpdate();
								if (x3 > 0) 
								{
									resp.sendRedirect("/BankingAppProject/TransferSuccess.html");
									
									
								} 
								else 
								{
									System.out.println("store transaction details");
									resp.sendRedirect("/BankingAppProject/TransferFail.jsp");

								}
							} 
							else 
							{   System.out.println("credit amount to receiver");
								resp.sendRedirect("/BankingAppProject/TransferFail.jsp");

							}

						} else 
						{   System.out.println("debit amount to sender");
							resp.sendRedirect("/BankingAppProject/TransferFail.jsp");
						}
					} else 
					{	System.out.println("check sufficent balance");
						resp.sendRedirect("/BankingAppProject/TransferFail.jsp");
					}
				} else 
				{	System.out.println("receiver ifsc and accno  "+sender_accno+" "+Receiver_ifsc+" "+Receiver_accno);
				
					resp.sendRedirect("/BankingAppProject/TransferFail.jsp");
				}
			} else 
			{   System.out.println("sender customer id & ifsc");
				resp.sendRedirect("/BankingAppProject/TransferFail.jsp");
			}

		}

		catch (Exception e) {

			e.printStackTrace();

		}
	}

}
