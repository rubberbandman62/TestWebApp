package controller;
import java.io.IOException;
import java.text.NumberFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Interest;

public class WebServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1541718609434111265L;
	
	private int principalAmount;
	private double rate;
	private int years;
	private int compound;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/MainPage.jsp");
			request = initCalculation(request);
			dispatcher.forward(request, response);
		}catch (Exception e){
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
	
	private HttpServletRequest initCalculation(HttpServletRequest request){
		NumberFormat nFormat = NumberFormat.getInstance();
		nFormat.setMaximumFractionDigits(3);
		
		principalAmount = Integer.parseInt(request.getParameter("principalAmount"));
		rate = Double.parseDouble(request.getParameter("rate"));
		years = Integer.parseInt(request.getParameter("years"));
		compound = Integer.parseInt(request.getParameter("compounded"));
		Interest interest = new Interest(principalAmount, rate, years, compound);
		
		double result = interest.calculateInterest();
		request.setAttribute("interest", nFormat.format(result));		
		return request;
	}
}