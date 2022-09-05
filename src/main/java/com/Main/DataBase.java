package com.Main;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.jsp.tagext.TryCatchFinally;

@WebServlet("/database")
public class DataBase extends HttpServlet {
	public boolean DataConnection(String Fname, String Lname, String number, String email) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/validation","root","dsp0805");
			PreparedStatement p = connect.prepareStatement("Insert into infodata Values(?,?,?,?)");
			System.out.println("hu: " + Fname + Lname + number + email);
			p.setString(1, Fname);
			p.setString(2, Lname);
			p.setString(3, number);
			p.setString(4, email);
			p.execute();
			return true;
		} catch (Exception e) {
			System.out.println("Execption" + e.getMessage());
			return false;
		}
		
	}
}
	
	
