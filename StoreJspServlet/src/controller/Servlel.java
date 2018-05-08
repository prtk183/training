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

import model.Goods;
import service.GoodsService;
import service.RetailerService;

/**
 * Servlet implementation class Servlel
 */
@WebServlet("/Servlet")
public class Servlel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlel() {
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
		
		GoodsService gdao = (GoodsService) context.getBean("goodsService");
		
		//sgdao.addGoods(202,"Parle G", 2, 20);
		
		RetailerService rdao =(RetailerService) context.getBean("retailerService");

		List<Goods> goodz = new ArrayList<Goods>();
		
		goodz= rdao.getAllGoods();
		
		request.setAttribute("goodslist", goodz); //categorylist is an arraylist      contains object of class category  
		
		RequestDispatcher rd = request.getRequestDispatcher("show.jsp");
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
