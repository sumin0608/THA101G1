package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.dao.impl.productDaoImpl;
import product.vo.product;

/**
 * Servlet implementation class BuyButtonServlet
 */
@WebServlet("/BuyButtonServlet")
			
public class BuyButtonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyButtonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//product p = new product();
		//p.setProduct_name("斯伯丁籃球");
		
		//HttpSession session = request.getSession();
		
		//session.setAttribute("P", p);
			
			
		request.setCharacterEncoding("big5");	
		String name = request.getParameter("input");
		
		if("購買".equals(name)) {
			response.sendRedirect("Order_listV5.jsp");
		}else if("加入購物車".equals(name)) {
			response.sendRedirect("Cart.jsp");
		}
		
		
	}

}
