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
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsServlet() {
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
		
		GoodsService cdao = (GoodsService) context.getBean("goodsService");
		
		List<Goods> Goodsz = new ArrayList<Goods>();

		int ch = Integer.parseInt(request.getParameter("operation"));
		//int ch=0;
		switch(ch)
		{
		
		case 1:
			int id = Integer.parseInt(request.getParameter("goodsId"));
			String name = request.getParameter("goodsName");
			int quantity = Integer.parseInt(request.getParameter("goodsQuantity"));
			double price = Double.parseDouble(request.getParameter("goodsPrice"));
			
			cdao.addGoods(id, name, quantity, price);
			
			break;
		
		case 2:
		
			int GoodsId1 = Integer.parseInt(request.getParameter("goodsId"));
			cdao.removeGoods(GoodsId1);
			break;
			
		case 3:
			
			int GoodsId2 = Integer.parseInt(request.getParameter("goodsId"));
			String GoodsName = request.getParameter("goodsName");
			cdao.updateGoods(GoodsId2, GoodsName);
			break;
			
		case 4:
			
			RetailerService rdao = (RetailerService) context.getBean("retailerService");
			
			Goodsz=rdao.getAllGoods();
			break;
			
	default:
			
		break;
		}
		

		RetailerService rdao = (RetailerService) context.getBean("retailerService");
		
		Goodsz=rdao.getAllGoods();
		request.setAttribute("goodslist", Goodsz); //categorylist is an arraylist      contains object of class category  
		
		RequestDispatcher rd = request.getRequestDispatcher("showGoods.jsp");
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
