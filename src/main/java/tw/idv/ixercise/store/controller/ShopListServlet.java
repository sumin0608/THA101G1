package tw.idv.ixercise.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.idv.ixercise.store.entity.porder;
import tw.idv.ixercise.store.entity.product;

@WebServlet("/ShopListServlet")
public class ShopListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ShopListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		product p = (product)session.getAttribute("P");
		List<porder> l = (List)session.getAttribute("L");
		String porderNo = request.getParameter("porderNo");
		String num = request.getParameter("pamount");
		int amount = Integer.parseInt(num);
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		porder order = new porder(porderNo,"m003",name,p.getProductName(),amount,phone,email);
		l.add(order);
		
		//response.sendRedirect("shop.jsp");
		response.sendRedirect("PayWay.jsp");
		
	}

}
