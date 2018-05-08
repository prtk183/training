package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import model.Customer;
import service.CustomerService;
import service.RetailerService;

/**
 * Servlet implementation class Customers
 */
@WebServlet("/CustomersView")
public class CustomersView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		CustomerService cdao = (CustomerService) context.getBean("customerService");
		
		List<Customer> customerz = new ArrayList<Customer>();
		RetailerService rdao = (RetailerService) context.getBean("retailerService");
		
		customerz=rdao.getAllCustomer();
		
		request.setAttribute("customerslist", customerz); //categorylist is an arraylist      contains object of class category  
		
		RequestDispatcher rd = request.getRequestDispatcher("showCustomer.jsp");
		rd.forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
