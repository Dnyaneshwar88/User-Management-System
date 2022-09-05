package com.Main;

import java.io.IOException;
import java.security.PublicKey;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ToServlet")
public class ValidateInfo extends HttpServlet {
	String Fname, Lname, number, email;

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Fname = req.getParameter("fname");
		Lname = req.getParameter("lname");
		number = req.getParameter("mobile");
		email = req.getParameter("email");

		HttpSession session = req.getSession();
		session.setAttribute("Fname", Fname);
		session.setAttribute("lname", Lname);
		session.setAttribute("number", number);
		session.setAttribute("email", email);

		System.out.println("Validation: " + Fname + Lname + number + email);
		DataBase in = new DataBase();
		if(in.DataConnection(Fname, Lname, number, email))
		{
			System.out.println("data registered");
		}
		else
		{
			System.out.println("no entry");
		}
	}

}
