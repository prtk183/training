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
import model.Goods;
import service.CustomerService;
import service.GoodsService;
import service.RetailerService;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
response.getWriter().append("Served at: yo").append(request.getContextPath());
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		CustomerService cdao = (CustomerService) context.getBean("customerService");
		
		List<Customer> customerz = new ArrayList<Customer>();

		int ch = Integer.parseInt(request.getParameter("operation"));
		//int ch=0;
		switch(ch)
		{
		
		case 1:
			int id = Integer.parseInt(request.getParameter("customerId"));
			String name = request.getParameter("customerName");
			String address = request.getParameter("customerAddress");
			String mode = request.getParameter("PaymentMode");
			
			Customer customer1 = new Customer(id, name, address, mode);
			
			cdao.addCustomer(customer1);

			break;
		
		case 2:
		
			int customerId1 = Integer.parseInt(request.getParameter("customerId"));
			cdao.removeCustomer(customerId1);
			break;
			
		case 3:
			
			int customerId2 = Integer.parseInt(request.getParameter("customerId"));
			String customerName = request.getParameter("customerName");
			cdao.updateCustomer(customerId2, customerName);
			break;
			
		case 4:
			RetailerService rdao = (RetailerService) context.getBean("retailerService");
			
			customerz=rdao.getAllCustomer();
			break;
			
	default:
			
		break;
		}
		

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
