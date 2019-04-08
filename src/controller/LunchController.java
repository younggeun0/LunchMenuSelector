package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.LunchDomain;
import service.LunchService;

@SuppressWarnings("serial")
public class LunchController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Random r = new Random();
		LunchService ls = new LunchService();
		
		int total = ls.getTotal();
		LunchDomain ld = ls.selectLunchMenu(r.nextInt(total) +1);
		request.setAttribute("LunchDomain", ld);
		
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}
}
