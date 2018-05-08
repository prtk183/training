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

import model.Supplier;
import service.RetailerService;
import service.SupplierService;

/**
 * Servlet implementation class SuppliersServlet
 */
@WebServlet("/SuppliersServlet")
public class SuppliersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppliersServlet() {
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
		
		SupplierService cdao = (SupplierService) context.getBean("supplierService");
		
		List<Supplier> supplierz = new ArrayList<Supplier>();

		int ch = Integer.parseInt(request.getParameter("operation"));
		//int ch=0;
		switch(ch)
		{
		
		case 1:
			int id = Integer.parseInt(request.getParameter("supplierId"));
			String name = request.getParameter("supplierName");
			String address = request.getParameter("supplierAddress");
			int quantityOrder = Integer.parseInt(request.getParameter("quantityOrder"));
			int orderId = Integer.parseInt(request.getParameter("orderId"));
			double amount = Double.parseDouble(request.getParameter("amount"));
			
			cdao.addSupplier(id, name, address, quantityOrder, orderId, amount);

			break;
		
		case 2:
		
			int supplierId1 = Integer.parseInt(request.getParameter("supplierId"));
			cdao.removeSupplier(supplierId1);
			break;
			
		case 3:
			
			int supplierId2 = Integer.parseInt(request.getParameter("supplierId"));
			String supplierName = request.getParameter("supplierName");
			cdao.updateSupplier(supplierId2, supplierName);
			break;
			
		case 4:
			RetailerService rdao = (RetailerService) context.getBean("retailerService");
			
			supplierz=rdao.getAllSupplier();
			break;
			
	default:
			
		break;
		}
		

		RetailerService rdao = (RetailerService) context.getBean("retailerService");
		
		supplierz=rdao.getAllSupplier();
		request.setAttribute("supplierslist", supplierz); //categorylist is an arraylist      contains object of class category  
		
		RequestDispatcher rd = request.getRequestDispatcher("showSuppliers.jsp");
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
