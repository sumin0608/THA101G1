package tw.idv.ixercise.store.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.idv.ixercise.store.dao.implProduct;
import tw.idv.ixercise.store.entity.product;



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
		//p.setProduct_name("���B�B�x�y");
		
		//HttpSession session = request.getSession();
		
		//session.setAttribute("P", p);
			
			
		request.setCharacterEncoding("UTF-8");	
		String name = request.getParameter("input");
		String productName = request.getParameter("productName");
		product p = new implProduct().query(productName);
		HttpSession session = request.getSession();
		if("購買".equals(name)) {
			if(p!=null) {
				session.setAttribute("P", p);
				response.sendRedirect("description.jsp");
			}else {
				PrintWriter out = response.getWriter();
				out.println("<h1>無此商品</h1>");
			}
		}else if("加入購物車".equals(name)) {
			
			response.sendRedirect("Cart.jsp");
		}
		
		
	}

}
